package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Reply to {@link io.dronefleet.mavlink.common.LogRequestData LOG_REQUEST_DATA} 
 */
@MavlinkMessageInfo(
        id = 12104,
        crc = 161,
        description = "Reply to LOG_REQUEST_DATA"
)
public final class LogDataExtended {
    private final int id;

    private final long ofs;

    private final int count;

    private final byte[] data;

    private LogDataExtended(int id, long ofs, int count, byte[] data) {
        this.id = id;
        this.ofs = ofs;
        this.count = count;
        this.data = data;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(LogDataExtended msg) {
        return builder()
                .id(msg.id)
                .ofs(msg.ofs)
                .count(msg.count)
                .data(msg.data);
    }

    /**
     * Log id (from {@link io.dronefleet.mavlink.common.LogEntry LOG_ENTRY} reply) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2,
            description = "Log id (from LOG_ENTRY reply)"
    )
    public final int id() {
        return this.id;
    }

    /**
     * Offset into the log 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Offset into the log"
    )
    public final long ofs() {
        return this.ofs;
    }

    /**
     * Number of bytes (zero for end of log) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Number of bytes (zero for end of log)"
    )
    public final int count() {
        return this.count;
    }

    /**
     * log data 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            arraySize = 248,
            description = "log data"
    )
    public final byte[] data() {
        return this.data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        LogDataExtended other = (LogDataExtended)o;
        if (!Objects.deepEquals(id, other.id)) return false;
        if (!Objects.deepEquals(ofs, other.ofs)) return false;
        if (!Objects.deepEquals(count, other.count)) return false;
        if (!Objects.deepEquals(data, other.data)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(ofs);
        result = 31 * result + Objects.hashCode(count);
        result = 31 * result + Objects.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "LogDataExtended{id=" + id
                 + ", ofs=" + ofs
                 + ", count=" + count
                 + ", data=" + data + "}";
    }

    public static final class Builder {
        private int id;

        private long ofs;

        private int count;

        private byte[] data;

        /**
         * Log id (from {@link io.dronefleet.mavlink.common.LogEntry LOG_ENTRY} reply) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2,
                description = "Log id (from LOG_ENTRY reply)"
        )
        public final Builder id(int id) {
            this.id = id;
            return this;
        }

        /**
         * Offset into the log 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Offset into the log"
        )
        public final Builder ofs(long ofs) {
            this.ofs = ofs;
            return this;
        }

        /**
         * Number of bytes (zero for end of log) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Number of bytes (zero for end of log)"
        )
        public final Builder count(int count) {
            this.count = count;
            return this;
        }

        /**
         * log data 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                arraySize = 248,
                description = "log data"
        )
        public final Builder data(byte[] data) {
            this.data = data;
            return this;
        }

        public final LogDataExtended build() {
            return new LogDataExtended(id, ofs, count, data);
        }
    }
}
