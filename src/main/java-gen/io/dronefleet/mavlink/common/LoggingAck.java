package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * An ack for a {@link io.dronefleet.mavlink.common.LoggingDataAcked LOGGING_DATA_ACKED} message 
 */
@MavlinkMessageInfo(
        id = 268,
        crc = 14,
        description = "An ack for a LOGGING_DATA_ACKED message"
)
public final class LoggingAck {
    private final int targetSystem;

    private final int targetComponent;

    private final int sequence;

    private LoggingAck(int targetSystem, int targetComponent, int sequence) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.sequence = sequence;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(LoggingAck msg) {
        return builder()
                .targetSystem(msg.targetSystem)
                .targetComponent(msg.targetComponent)
                .sequence(msg.sequence);
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
     * sequence number (must match the one in {@link io.dronefleet.mavlink.common.LoggingDataAcked LOGGING_DATA_ACKED}) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "sequence number (must match the one in LOGGING_DATA_ACKED)"
    )
    public final int sequence() {
        return this.sequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        LoggingAck other = (LoggingAck)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(sequence, other.sequence)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(sequence);
        return result;
    }

    @Override
    public String toString() {
        return "LoggingAck{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", sequence=" + sequence + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int sequence;

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
         * sequence number (must match the one in {@link io.dronefleet.mavlink.common.LoggingDataAcked LOGGING_DATA_ACKED}) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "sequence number (must match the one in LOGGING_DATA_ACKED)"
        )
        public final Builder sequence(int sequence) {
            this.sequence = sequence;
            return this;
        }

        public final LoggingAck build() {
            return new LoggingAck(targetSystem, targetComponent, sequence);
        }
    }
}
