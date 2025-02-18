package io.dronefleet.mavlink.python_array_test;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Array test #0. 
 */
@MavlinkMessageInfo(
        id = 17150,
        crc = 26,
        description = "Array test #0."
)
public final class ArrayTest0 {
    private final int v1;

    private final byte[] arI8;

    private final byte[] arU8;

    private final short[] arU16;

    private final int[] arU32;

    private ArrayTest0(int v1, byte[] arI8, byte[] arU8, short[] arU16, int[] arU32) {
        this.v1 = v1;
        this.arI8 = arI8;
        this.arU8 = arU8;
        this.arU16 = arU16;
        this.arU32 = arU32;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ArrayTest0 msg) {
        return builder()
                .v1(msg.v1)
                .arI8(msg.arI8)
                .arU8(msg.arU8)
                .arU16(msg.arU16)
                .arU32(msg.arU32);
    }

    /**
     * Stub field 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "Stub field"
    )
    public final int v1() {
        return this.v1;
    }

    /**
     * Value array 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 4,
            signed = true,
            description = "Value array"
    )
    public final byte[] arI8() {
        return this.arI8;
    }

    /**
     * Value array 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 4,
            description = "Value array"
    )
    public final byte[] arU8() {
        return this.arU8;
    }

    /**
     * Value array 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            arraySize = 4,
            description = "Value array"
    )
    public final short[] arU16() {
        return this.arU16;
    }

    /**
     * Value array 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            arraySize = 4,
            description = "Value array"
    )
    public final int[] arU32() {
        return this.arU32;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ArrayTest0 other = (ArrayTest0)o;
        if (!Objects.deepEquals(v1, other.v1)) return false;
        if (!Objects.deepEquals(arI8, other.arI8)) return false;
        if (!Objects.deepEquals(arU8, other.arU8)) return false;
        if (!Objects.deepEquals(arU16, other.arU16)) return false;
        if (!Objects.deepEquals(arU32, other.arU32)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(v1);
        result = 31 * result + Objects.hashCode(arI8);
        result = 31 * result + Objects.hashCode(arU8);
        result = 31 * result + Objects.hashCode(arU16);
        result = 31 * result + Objects.hashCode(arU32);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayTest0{v1=" + v1
                 + ", arI8=" + arI8
                 + ", arU8=" + arU8
                 + ", arU16=" + arU16
                 + ", arU32=" + arU32 + "}";
    }

    public static final class Builder {
        private int v1;

        private byte[] arI8;

        private byte[] arU8;

        private short[] arU16;

        private int[] arU32;

        /**
         * Stub field 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "Stub field"
        )
        public final Builder v1(int v1) {
            this.v1 = v1;
            return this;
        }

        /**
         * Value array 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                arraySize = 4,
                signed = true,
                description = "Value array"
        )
        public final Builder arI8(byte[] arI8) {
            this.arI8 = arI8;
            return this;
        }

        /**
         * Value array 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 4,
                description = "Value array"
        )
        public final Builder arU8(byte[] arU8) {
            this.arU8 = arU8;
            return this;
        }

        /**
         * Value array 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                arraySize = 4,
                description = "Value array"
        )
        public final Builder arU16(short[] arU16) {
            this.arU16 = arU16;
            return this;
        }

        /**
         * Value array 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                arraySize = 4,
                description = "Value array"
        )
        public final Builder arU32(int[] arU32) {
            this.arU32 = arU32;
            return this;
        }

        public final ArrayTest0 build() {
            return new ArrayTest0(v1, arI8, arU8, arU16, arU32);
        }
    }
}
