package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * A message containing logged data (see also MAV_CMD_LOGGING_START) 
 */
@MavlinkMessageInfo(
        id = 266,
        crc = 193,
        description = "A message containing logged data (see also MAV_CMD_LOGGING_START)"
)
public final class LoggingData {
    private final int targetSystem;

    private final int targetComponent;

    private final int sequence;

    private final int length;

    private final int firstMessageOffset;

    private final byte[] data;

    private LoggingData(int targetSystem, int targetComponent, int sequence, int length,
            int firstMessageOffset, byte[] data) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.sequence = sequence;
        this.length = length;
        this.firstMessageOffset = firstMessageOffset;
        this.data = data;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(LoggingData msg) {
        return builder()
                .targetSystem(msg.targetSystem)
                .targetComponent(msg.targetComponent)
                .sequence(msg.sequence)
                .length(msg.length)
                .firstMessageOffset(msg.firstMessageOffset)
                .data(msg.data);
    }

    /**
     * system ID of the target 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "system ID of the target"
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * component ID of the target 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "component ID of the target"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * sequence number (can wrap) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "sequence number (can wrap)"
    )
    public final int sequence() {
        return this.sequence;
    }

    /**
     * data length 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "data length"
    )
    public final int length() {
        return this.length;
    }

    /**
     * offset into data where first message starts. This can be used for recovery, when a previous 
     * message got lost (set to 255 if no start exists). 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "offset into data where first message starts. This can be used for recovery, when a previous message got lost (set to 255 if no start exists)."
    )
    public final int firstMessageOffset() {
        return this.firstMessageOffset;
    }

    /**
     * logged data 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            arraySize = 249,
            description = "logged data"
    )
    public final byte[] data() {
        return this.data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        LoggingData other = (LoggingData)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(sequence, other.sequence)) return false;
        if (!Objects.deepEquals(length, other.length)) return false;
        if (!Objects.deepEquals(firstMessageOffset, other.firstMessageOffset)) return false;
        if (!Objects.deepEquals(data, other.data)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(sequence);
        result = 31 * result + Objects.hashCode(length);
        result = 31 * result + Objects.hashCode(firstMessageOffset);
        result = 31 * result + Objects.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "LoggingData{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", sequence=" + sequence
                 + ", length=" + length
                 + ", firstMessageOffset=" + firstMessageOffset
                 + ", data=" + data + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int sequence;

        private int length;

        private int firstMessageOffset;

        private byte[] data;

        /**
         * system ID of the target 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "system ID of the target"
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * component ID of the target 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "component ID of the target"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * sequence number (can wrap) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "sequence number (can wrap)"
        )
        public final Builder sequence(int sequence) {
            this.sequence = sequence;
            return this;
        }

        /**
         * data length 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "data length"
        )
        public final Builder length(int length) {
            this.length = length;
            return this;
        }

        /**
         * offset into data where first message starts. This can be used for recovery, when a previous 
         * message got lost (set to 255 if no start exists). 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "offset into data where first message starts. This can be used for recovery, when a previous message got lost (set to 255 if no start exists)."
        )
        public final Builder firstMessageOffset(int firstMessageOffset) {
            this.firstMessageOffset = firstMessageOffset;
            return this;
        }

        /**
         * logged data 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                arraySize = 249,
                description = "logged data"
        )
        public final Builder data(byte[] data) {
            this.data = data;
            return this;
        }

        public final LoggingData build() {
            return new LoggingData(targetSystem, targetComponent, sequence, length, firstMessageOffset, data);
        }
    }
}
