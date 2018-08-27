package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Response from a {@link io.dronefleet.mavlink.ardupilotmega.GoproCommand GOPRO_COMMAND} set request 
 */
@MavlinkMessageInfo(
        id = 219,
        crc = 162
)
public final class GoproSetResponse {
    private final EnumValue<GoproCommand> cmdId;

    private final EnumValue<GoproRequestStatus> status;

    private GoproSetResponse(EnumValue<GoproCommand> cmdId, EnumValue<GoproRequestStatus> status) {
        this.cmdId = cmdId;
        this.status = status;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Command ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            enumType = GoproCommand.class
    )
    public final EnumValue<GoproCommand> cmdId() {
        return this.cmdId;
    }

    /**
     * Status 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = GoproRequestStatus.class
    )
    public final EnumValue<GoproRequestStatus> status() {
        return this.status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GoproSetResponse other = (GoproSetResponse)o;
        if (!Objects.deepEquals(cmdId, other.cmdId)) return false;
        if (!Objects.deepEquals(status, other.status)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(cmdId);
        result = 31 * result + Objects.hashCode(status);
        return result;
    }

    @Override
    public String toString() {
        return "GoproSetResponse{cmdId=" + cmdId
                 + ", status=" + status + "}";
    }

    public static final class Builder {
        private EnumValue<GoproCommand> cmdId;

        private EnumValue<GoproRequestStatus> status;

        /**
         * Command ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = GoproCommand.class
        )
        public final Builder cmdId(EnumValue<GoproCommand> cmdId) {
            this.cmdId = cmdId;
            return this;
        }

        /**
         * Command ID 
         */
        public final Builder cmdId(GoproCommand entry) {
            this.cmdId = EnumValue.of(entry);
            return this;
        }

        /**
         * Command ID 
         */
        public final Builder cmdId(Enum... flags) {
            this.cmdId = EnumValue.create(flags);
            return this;
        }

        /**
         * Status 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = GoproRequestStatus.class
        )
        public final Builder status(EnumValue<GoproRequestStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Status 
         */
        public final Builder status(GoproRequestStatus entry) {
            this.status = EnumValue.of(entry);
            return this;
        }

        /**
         * Status 
         */
        public final Builder status(Enum... flags) {
            this.status = EnumValue.create(flags);
            return this;
        }

        public final GoproSetResponse build() {
            return new GoproSetResponse(cmdId, status);
        }
    }
}
