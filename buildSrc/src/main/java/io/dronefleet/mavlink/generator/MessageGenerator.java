package io.dronefleet.mavlink.generator;

import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MessageGenerator {

    private static final ClassName MAVLINK_MESSAGE_INFO = ClassName.get(
            "io.dronefleet.mavlink.annotations",
            "MavlinkMessageInfo");

    private static final ClassName MAVLINK_MESSAGE_BUILDER = ClassName.get(
            "io.dronefleet.mavlink.annotations",
            "MavlinkMessageBuilder");

    private static final ClassName HAS_TRANSMISSION_ID = ClassName.get(
            "io.dronefleet.mavlink",
            "HasTransmissionId");

    private final PackageGenerator parentPackage;
    private final int id;
    private final String name;
    private final ClassName className;
    private final String description;
    private final List<FieldGenerator> fields;
    private final DeprecationGenerator deprecation;
    private final boolean workInProgress;

    public MessageGenerator(
            PackageGenerator parentPackage,
            int id,
            String name,
            ClassName className,
            String description,
            List<FieldGenerator> fields,
            DeprecationGenerator deprecation,
            boolean workInProgress) {
        this.parentPackage = parentPackage;
        this.id = id;
        this.name = name;
        this.className = className;
        this.description = description;
        this.fields = fields;
        this.deprecation = deprecation;
        this.workInProgress = workInProgress;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ClassName getClassName() {
        return className;
    }

    public ClassName builderClassName() {
        return ClassName.get(className.packageName(), className.simpleName(), "Builder");
    }

    public void addField(FieldGenerator generator) {
        fields.add(generator);
    }

    public String javadoc() {
        String javadoc = parentPackage.processJavadoc(description);
        if (deprecation.deprecated()) {
            javadoc += parentPackage.processJavadoc(deprecation.javadoc());
        } else if (workInProgress) {
            javadoc += parentPackage.processJavadoc("@deprecated This message is a work in progress. " +
                    "It may be modified in a non backward-compatible way in a future release without any warning. " +
                    "This version of the message may not even work with autopilots that support this message due to " +
                    "discrepancies between dialect versions. Unless you completely understand the risks of doing so, " +
                    "don't use it.");
        }
        return javadoc;
    }

    public int crc() {
        CrcX25 crc = new CrcX25();
        crc.accumulate(name + " ");
        fields.stream()
                .sorted()
                .filter(f -> !f.isExtension())
                .peek(f -> crc.accumulate(f.getType() + " "))
                .peek(f -> crc.accumulate(f.getName() + " "))
                .filter(FieldGenerator::isArray)
                .forEach(f -> crc.accumulate(f.getArraySize()));
        return crc.get() & 0xff;
    }

    public AnnotationSpec annotation() {
        AnnotationSpec.Builder annotation = AnnotationSpec.builder(MAVLINK_MESSAGE_INFO)
                .addMember("id", "$L", id)
                .addMember("crc", "$L", crc());

        if (description != null && !description.trim().isEmpty()) {
            annotation.addMember("description", "$S", description);
        }

        if (workInProgress) {
            annotation.addMember("workInProgress", "$L", true);
        }

        return annotation.build();
    }

    public List<AnnotationSpec> annotations() {
        List<AnnotationSpec> annotations = new ArrayList<>();
        annotations.add(annotation());
        if (deprecation.deprecated()) {
            annotations.add(deprecation.annotation());
        } else if (workInProgress) {
            annotations.add(AnnotationSpec.builder(Deprecated.class).build());
        }
        return annotations;
    }

    public TypeSpec generateBuilder() {
        return TypeSpec.classBuilder(builderClassName())
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL, Modifier.STATIC)
                .addFields(fields.stream()
                        .map(FieldGenerator::generateMutableMember)
                        .collect(Collectors.toList()))
                .addMethods(fields.stream()
                        .flatMap(f -> Stream.concat(
                                Stream.of(f.generateSetter(builderClassName())),
                                f.generateConvenienceSetters(builderClassName()).stream()))
                        .collect(Collectors.toList()))
                .addMethod(MethodSpec.methodBuilder("build")
                        .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                        .addStatement("return new $T(" +
                                fields.stream()
                                        .map(f -> CodeBlock.of("$N", f.getNameCamelCase()))
                                        .collect(CodeBlock.joining(", ")) +
                                ")", className)
                        .returns(className)
                        .build())
                .build();
    }

    public MethodSpec generateEquals() {
        CodeBlock.Builder equalsCode = CodeBlock.builder()
                .addStatement("if (this == o) return true")
                .addStatement("if (o == null || !getClass().equals(o.getClass())) return false")
                .addStatement("$1T other = ($1T)o", className);
        fields.forEach(f -> f.addEqualsStatement(equalsCode, "other"));
        equalsCode.addStatement("return true");
        return MethodSpec.methodBuilder("equals")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .addParameter(Object.class, "o")
                .addCode(equalsCode.build())
                .returns(boolean.class)
                .build();
    }

    public MethodSpec generateHashCode() {
        CodeBlock.Builder equalsCode = CodeBlock.builder()
                .addStatement("int result = 0");
        fields.forEach(f -> f.addHashCodeStatement(equalsCode, "result"));
        equalsCode.addStatement("return result");
        return MethodSpec.methodBuilder("hashCode")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .addCode(equalsCode.build())
                .returns(int.class)
                .build();
    }

    public MethodSpec generateToString() {
        CodeBlock.Builder toStringCode = CodeBlock.builder();
        String stmt = fields.stream()
                .map(f -> f.getNameCamelCase() + "=\" + " + f.getNameCamelCase())
                .collect(Collectors.joining(
                        "\n + \", ",
                        "return \"" + getClassName().simpleName() + "{",
                        " + \"}\""));
        toStringCode.addStatement(stmt);
        return MethodSpec.methodBuilder("toString")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .addCode(toStringCode.build())
                .returns(String.class)
                .build();
    }

    public TypeSpec generate() {
        TypeSpec.Builder builder = TypeSpec.classBuilder(className)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addJavadoc(javadoc())
                .addAnnotations(annotations())
                .addType(generateBuilder())
                .addMethod(MethodSpec.methodBuilder("builder")
                        .addJavadoc("Returns a builder instance for this message.\n")
                        .addAnnotation(MAVLINK_MESSAGE_BUILDER)
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                        .addStatement("return new $T()", builderClassName())
                        .returns(builderClassName())
                        .build())
                .addMethod(MethodSpec.methodBuilder("builder")
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                        .returns(builderClassName())
                        .addParameter(className, "msg")
                        .addStatement("return builder()\n" +
                                fields.stream()
                                        .map(field -> "." + field.getNameCamelCase() + "(msg." + field.getNameCamelCase() + ")")
                                        .collect(Collectors.joining("\n"))
                        )
                        .build())
                .addFields(fields.stream()
                        .map(FieldGenerator::generateImmutableMember)
                        .collect(Collectors.toList()))
                .addMethods(fields.stream()
                        .map(FieldGenerator::generateGetter)
                        .collect(Collectors.toList()))
                .addMethod(MethodSpec.constructorBuilder()
                        .addModifiers(Modifier.PRIVATE)
                        .addParameters(fields.stream()
                                .map(FieldGenerator::generateParameter)
                                .collect(Collectors.toList()))
                        .addCode(fields.stream()
                                .map(f -> CodeBlock.builder()
                                        .addStatement("this.$1N = $1N", f.getNameCamelCase())
                                        .build())
                                .collect(CodeBlock.joining("")))
                        .build())
                .addMethod(generateEquals())
                .addMethod(generateHashCode())
                .addMethod(generateToString());

        boolean hasTransmissionId = fields.stream()
                .anyMatch(field -> "tid".equals(field.getName()) && "uint8_t".equals(field.getType()));
        if (hasTransmissionId){
            builder.addSuperinterface(ParameterizedTypeName.get(HAS_TRANSMISSION_ID, className));
            builder.addMethod(MethodSpec
                    .methodBuilder("withTransmissionId")
                    .returns(className)
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override.class)
                    .addParameter(ParameterSpec.builder(TypeName.INT, "tid").build())
                    .addStatement("return builder(this).tid(tid).build()")
                    .build()
            );
        }

        return builder.build();
    }
}
