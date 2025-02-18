package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.HasTransmissionId;
import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Message encoding a command with parameters as scaled integers. Scaling depends on the actual 
 * command value. The command microservice is documented at 
 * https://mavlink.io/en/services/command.html 
 */
@MavlinkMessageInfo(
        id = 75,
        crc = 158,
        description = "Message encoding a command with parameters as scaled integers. Scaling depends on the actual command value. The command microservice is documented at https://mavlink.io/en/services/command.html"
)
public final class CommandInt implements HasTransmissionId<CommandInt> {
    private final int targetSystem;

    private final int targetComponent;

    private final EnumValue<MavFrame> frame;

    private final EnumValue<MavCmd> command;

    private final int current;

    private final int autocontinue;

    private final float param1;

    private final float param2;

    private final float param3;

    private final float param4;

    private final int x;

    private final int y;

    private final float z;

    private final int tid;

    private CommandInt(int targetSystem, int targetComponent, EnumValue<MavFrame> frame,
            EnumValue<MavCmd> command, int current, int autocontinue, float param1, float param2,
            float param3, float param4, int x, int y, float z, int tid) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.frame = frame;
        this.command = command;
        this.current = current;
        this.autocontinue = autocontinue;
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.param4 = param4;
        this.x = x;
        this.y = y;
        this.z = z;
        this.tid = tid;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CommandInt msg) {
        return builder()
                .targetSystem(msg.targetSystem)
                .targetComponent(msg.targetComponent)
                .frame(msg.frame)
                .command(msg.command)
                .current(msg.current)
                .autocontinue(msg.autocontinue)
                .param1(msg.param1)
                .param2(msg.param2)
                .param3(msg.param3)
                .param4(msg.param4)
                .x(msg.x)
                .y(msg.y)
                .z(msg.z)
                .tid(msg.tid);
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "System ID"
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * The coordinate system of the COMMAND. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = MavFrame.class,
            description = "The coordinate system of the COMMAND."
    )
    public final EnumValue<MavFrame> frame() {
        return this.frame;
    }

    /**
     * The scheduled action for the mission item. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            enumType = MavCmd.class,
            description = "The scheduled action for the mission item."
    )
    public final EnumValue<MavCmd> command() {
        return this.command;
    }

    /**
     * Not used. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "Not used."
    )
    public final int current() {
        return this.current;
    }

    /**
     * Not used (set 0). 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            description = "Not used (set 0)."
    )
    public final int autocontinue() {
        return this.autocontinue;
    }

    /**
     * PARAM1, see {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "PARAM1, see MAV_CMD enum"
    )
    public final float param1() {
        return this.param1;
    }

    /**
     * PARAM2, see {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "PARAM2, see MAV_CMD enum"
    )
    public final float param2() {
        return this.param2;
    }

    /**
     * PARAM3, see {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "PARAM3, see MAV_CMD enum"
    )
    public final float param3() {
        return this.param3;
    }

    /**
     * PARAM4, see {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "PARAM4, see MAV_CMD enum"
    )
    public final float param4() {
        return this.param4;
    }

    /**
     * PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            signed = true,
            description = "PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7"
    )
    public final int x() {
        return this.x;
    }

    /**
     * PARAM6 / local: y position in meters * 1e4, global: longitude in degrees * 10^7 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            signed = true,
            description = "PARAM6 / local: y position in meters * 1e4, global: longitude in degrees * 10^7"
    )
    public final int y() {
        return this.y;
    }

    /**
     * PARAM7 / z position: global: altitude in meters (relative or absolute, depending on frame). 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            description = "PARAM7 / z position: global: altitude in meters (relative or absolute, depending on frame)."
    )
    public final float z() {
        return this.z;
    }

    /**
     * Transmission id. 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 1,
            extension = true,
            description = "Transmission id."
    )
    public final int tid() {
        return this.tid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CommandInt other = (CommandInt)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(frame, other.frame)) return false;
        if (!Objects.deepEquals(command, other.command)) return false;
        if (!Objects.deepEquals(current, other.current)) return false;
        if (!Objects.deepEquals(autocontinue, other.autocontinue)) return false;
        if (!Objects.deepEquals(param1, other.param1)) return false;
        if (!Objects.deepEquals(param2, other.param2)) return false;
        if (!Objects.deepEquals(param3, other.param3)) return false;
        if (!Objects.deepEquals(param4, other.param4)) return false;
        if (!Objects.deepEquals(x, other.x)) return false;
        if (!Objects.deepEquals(y, other.y)) return false;
        if (!Objects.deepEquals(z, other.z)) return false;
        if (!Objects.deepEquals(tid, other.tid)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(frame);
        result = 31 * result + Objects.hashCode(command);
        result = 31 * result + Objects.hashCode(current);
        result = 31 * result + Objects.hashCode(autocontinue);
        result = 31 * result + Objects.hashCode(param1);
        result = 31 * result + Objects.hashCode(param2);
        result = 31 * result + Objects.hashCode(param3);
        result = 31 * result + Objects.hashCode(param4);
        result = 31 * result + Objects.hashCode(x);
        result = 31 * result + Objects.hashCode(y);
        result = 31 * result + Objects.hashCode(z);
        result = 31 * result + Objects.hashCode(tid);
        return result;
    }

    @Override
    public String toString() {
        return "CommandInt{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", frame=" + frame
                 + ", command=" + command
                 + ", current=" + current
                 + ", autocontinue=" + autocontinue
                 + ", param1=" + param1
                 + ", param2=" + param2
                 + ", param3=" + param3
                 + ", param4=" + param4
                 + ", x=" + x
                 + ", y=" + y
                 + ", z=" + z
                 + ", tid=" + tid + "}";
    }

    @Override
    public CommandInt withTransmissionId(int tid) {
        return builder(this).tid(tid).build();
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private EnumValue<MavFrame> frame;

        private EnumValue<MavCmd> command;

        private int current;

        private int autocontinue;

        private float param1;

        private float param2;

        private float param3;

        private float param4;

        private int x;

        private int y;

        private float z;

        private int tid;

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System ID"
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Component ID"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * The coordinate system of the COMMAND. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = MavFrame.class,
                description = "The coordinate system of the COMMAND."
        )
        public final Builder frame(EnumValue<MavFrame> frame) {
            this.frame = frame;
            return this;
        }

        /**
         * The coordinate system of the COMMAND. 
         */
        public final Builder frame(MavFrame entry) {
            return frame(EnumValue.of(entry));
        }

        /**
         * The coordinate system of the COMMAND. 
         */
        public final Builder frame(Enum... flags) {
            return frame(EnumValue.create(flags));
        }

        /**
         * The coordinate system of the COMMAND. 
         */
        public final Builder frame(Collection<Enum> flags) {
            return frame(EnumValue.create(flags));
        }

        /**
         * The scheduled action for the mission item. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                enumType = MavCmd.class,
                description = "The scheduled action for the mission item."
        )
        public final Builder command(EnumValue<MavCmd> command) {
            this.command = command;
            return this;
        }

        /**
         * The scheduled action for the mission item. 
         */
        public final Builder command(MavCmd entry) {
            return command(EnumValue.of(entry));
        }

        /**
         * The scheduled action for the mission item. 
         */
        public final Builder command(Enum... flags) {
            return command(EnumValue.create(flags));
        }

        /**
         * The scheduled action for the mission item. 
         */
        public final Builder command(Collection<Enum> flags) {
            return command(EnumValue.create(flags));
        }

        /**
         * Not used. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "Not used."
        )
        public final Builder current(int current) {
            this.current = current;
            return this;
        }

        /**
         * Not used (set 0). 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                description = "Not used (set 0)."
        )
        public final Builder autocontinue(int autocontinue) {
            this.autocontinue = autocontinue;
            return this;
        }

        /**
         * PARAM1, see {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "PARAM1, see MAV_CMD enum"
        )
        public final Builder param1(float param1) {
            this.param1 = param1;
            return this;
        }

        /**
         * PARAM2, see {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "PARAM2, see MAV_CMD enum"
        )
        public final Builder param2(float param2) {
            this.param2 = param2;
            return this;
        }

        /**
         * PARAM3, see {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "PARAM3, see MAV_CMD enum"
        )
        public final Builder param3(float param3) {
            this.param3 = param3;
            return this;
        }

        /**
         * PARAM4, see {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "PARAM4, see MAV_CMD enum"
        )
        public final Builder param4(float param4) {
            this.param4 = param4;
            return this;
        }

        /**
         * PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                signed = true,
                description = "PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7"
        )
        public final Builder x(int x) {
            this.x = x;
            return this;
        }

        /**
         * PARAM6 / local: y position in meters * 1e4, global: longitude in degrees * 10^7 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                signed = true,
                description = "PARAM6 / local: y position in meters * 1e4, global: longitude in degrees * 10^7"
        )
        public final Builder y(int y) {
            this.y = y;
            return this;
        }

        /**
         * PARAM7 / z position: global: altitude in meters (relative or absolute, depending on frame). 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                description = "PARAM7 / z position: global: altitude in meters (relative or absolute, depending on frame)."
        )
        public final Builder z(float z) {
            this.z = z;
            return this;
        }

        /**
         * Transmission id. 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 1,
                extension = true,
                description = "Transmission id."
        )
        public final Builder tid(int tid) {
            this.tid = tid;
            return this;
        }

        public final CommandInt build() {
            return new CommandInt(targetSystem, targetComponent, frame, command, current, autocontinue, param1, param2, param3, param4, x, y, z, tid);
        }
    }
}
