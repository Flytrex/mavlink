package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

/**
 * The global position, as returned by the Global Positioning System (GPS). This is NOT the global 
 * position estimate of the system, but rather a RAW sensor value. See message GLOBAL_POSITION 
 * for the global position estimate. 
 */
@MavlinkMessageInfo(
        id = 24,
        crc = 24,
        description = "The global position, as returned by the Global Positioning System (GPS). This is\n"
                        + "                NOT the global position estimate of the system, but rather a RAW sensor value. See message GLOBAL_POSITION for the global position estimate."
)
public final class GpsRawInt {
    private final BigInteger timeUsec;

    private final EnumValue<GpsFixType> fixType;

    private final int lat;

    private final int lon;

    private final int alt;

    private final int eph;

    private final int epv;

    private final int vel;

    private final int cog;

    private final int satellitesVisible;

    private final int altEllipsoid;

    private final long hAcc;

    private final long vAcc;

    private final long velAcc;

    private final long hdgAcc;

    private final int yaw;

    private final int id;

    private final int isPrimary;

    private GpsRawInt(BigInteger timeUsec, EnumValue<GpsFixType> fixType, int lat, int lon, int alt,
            int eph, int epv, int vel, int cog, int satellitesVisible, int altEllipsoid, long hAcc,
            long vAcc, long velAcc, long hdgAcc, int yaw, int id, int isPrimary) {
        this.timeUsec = timeUsec;
        this.fixType = fixType;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.eph = eph;
        this.epv = epv;
        this.vel = vel;
        this.cog = cog;
        this.satellitesVisible = satellitesVisible;
        this.altEllipsoid = altEllipsoid;
        this.hAcc = hAcc;
        this.vAcc = vAcc;
        this.velAcc = velAcc;
        this.hdgAcc = hdgAcc;
        this.yaw = yaw;
        this.id = id;
        this.isPrimary = isPrimary;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GpsRawInt msg) {
        return builder()
                .timeUsec(msg.timeUsec)
                .fixType(msg.fixType)
                .lat(msg.lat)
                .lon(msg.lon)
                .alt(msg.alt)
                .eph(msg.eph)
                .epv(msg.epv)
                .vel(msg.vel)
                .cog(msg.cog)
                .satellitesVisible(msg.satellitesVisible)
                .altEllipsoid(msg.altEllipsoid)
                .hAcc(msg.hAcc)
                .vAcc(msg.vAcc)
                .velAcc(msg.velAcc)
                .hdgAcc(msg.hdgAcc)
                .yaw(msg.yaw)
                .id(msg.id)
                .isPrimary(msg.isPrimary);
    }

    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
     * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * GPS fix type. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = GpsFixType.class,
            description = "GPS fix type."
    )
    public final EnumValue<GpsFixType> fixType() {
        return this.fixType;
    }

    /**
     * Latitude (WGS84, EGM96 ellipsoid) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true,
            description = "Latitude (WGS84, EGM96 ellipsoid)"
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude (WGS84, EGM96 ellipsoid) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true,
            description = "Longitude (WGS84, EGM96 ellipsoid)"
    )
    public final int lon() {
        return this.lon;
    }

    /**
     * Altitude (MSL). Positive for up. Note that virtually all GPS modules provide the MSL altitude 
     * in addition to the WGS84 altitude. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Altitude (MSL). Positive for up. Note that virtually all GPS modules provide the MSL altitude in addition to the WGS84 altitude."
    )
    public final int alt() {
        return this.alt;
    }

    /**
     * GPS HDOP horizontal dilution of position (unitless). If unknown, set to: UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "GPS HDOP horizontal dilution of position (unitless). If unknown, set to: UINT16_MAX"
    )
    public final int eph() {
        return this.eph;
    }

    /**
     * GPS VDOP vertical dilution of position (unitless). If unknown, set to: UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            description = "GPS VDOP vertical dilution of position (unitless). If unknown, set to: UINT16_MAX"
    )
    public final int epv() {
        return this.epv;
    }

    /**
     * GPS ground speed. If unknown, set to: UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            description = "GPS ground speed. If unknown, set to: UINT16_MAX"
    )
    public final int vel() {
        return this.vel;
    }

    /**
     * Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 
     * degrees. If unknown, set to: UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            description = "Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 degrees. If unknown, set to: UINT16_MAX"
    )
    public final int cog() {
        return this.cog;
    }

    /**
     * Number of satellites visible. If unknown, set to 255 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1,
            description = "Number of satellites visible. If unknown, set to 255"
    )
    public final int satellitesVisible() {
        return this.satellitesVisible;
    }

    /**
     * Altitude (above WGS84, EGM96 ellipsoid). Positive for up. 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            signed = true,
            extension = true,
            description = "Altitude (above WGS84, EGM96 ellipsoid). Positive for up."
    )
    public final int altEllipsoid() {
        return this.altEllipsoid;
    }

    /**
     * Position uncertainty. 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            extension = true,
            description = "Position uncertainty."
    )
    public final long hAcc() {
        return this.hAcc;
    }

    /**
     * Altitude uncertainty. 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4,
            extension = true,
            description = "Altitude uncertainty."
    )
    public final long vAcc() {
        return this.vAcc;
    }

    /**
     * Speed uncertainty. 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 4,
            extension = true,
            description = "Speed uncertainty."
    )
    public final long velAcc() {
        return this.velAcc;
    }

    /**
     * Heading / track uncertainty 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 4,
            extension = true,
            description = "Heading / track uncertainty"
    )
    public final long hdgAcc() {
        return this.hdgAcc;
    }

    /**
     * Yaw in earth frame from north. Use 0 if this GPS does not provide yaw. Use 65535 if this GPS is 
     * configured to provide yaw and is currently unable to provide it. Use 36000 for north. 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 2,
            extension = true,
            description = "Yaw in earth frame from north. Use 0 if this GPS does not provide yaw. Use 65535 if this GPS is configured to provide yaw and is currently unable to provide it. Use 36000 for north."
    )
    public final int yaw() {
        return this.yaw;
    }

    /**
     * GPS ID. 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 1,
            extension = true,
            description = "GPS ID."
    )
    public final int id() {
        return this.id;
    }

    /**
     * Boolean indicating whether this GPS is primary (currently used for navigation) or not 
     * (primary: 1, not primary: 0). 
     */
    @MavlinkFieldInfo(
            position = 19,
            unitSize = 1,
            extension = true,
            description = "Boolean indicating whether this GPS is primary (currently used for navigation) or not (primary: 1, not primary: 0)."
    )
    public final int isPrimary() {
        return this.isPrimary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GpsRawInt other = (GpsRawInt)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(fixType, other.fixType)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lon, other.lon)) return false;
        if (!Objects.deepEquals(alt, other.alt)) return false;
        if (!Objects.deepEquals(eph, other.eph)) return false;
        if (!Objects.deepEquals(epv, other.epv)) return false;
        if (!Objects.deepEquals(vel, other.vel)) return false;
        if (!Objects.deepEquals(cog, other.cog)) return false;
        if (!Objects.deepEquals(satellitesVisible, other.satellitesVisible)) return false;
        if (!Objects.deepEquals(altEllipsoid, other.altEllipsoid)) return false;
        if (!Objects.deepEquals(hAcc, other.hAcc)) return false;
        if (!Objects.deepEquals(vAcc, other.vAcc)) return false;
        if (!Objects.deepEquals(velAcc, other.velAcc)) return false;
        if (!Objects.deepEquals(hdgAcc, other.hdgAcc)) return false;
        if (!Objects.deepEquals(yaw, other.yaw)) return false;
        if (!Objects.deepEquals(id, other.id)) return false;
        if (!Objects.deepEquals(isPrimary, other.isPrimary)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(fixType);
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lon);
        result = 31 * result + Objects.hashCode(alt);
        result = 31 * result + Objects.hashCode(eph);
        result = 31 * result + Objects.hashCode(epv);
        result = 31 * result + Objects.hashCode(vel);
        result = 31 * result + Objects.hashCode(cog);
        result = 31 * result + Objects.hashCode(satellitesVisible);
        result = 31 * result + Objects.hashCode(altEllipsoid);
        result = 31 * result + Objects.hashCode(hAcc);
        result = 31 * result + Objects.hashCode(vAcc);
        result = 31 * result + Objects.hashCode(velAcc);
        result = 31 * result + Objects.hashCode(hdgAcc);
        result = 31 * result + Objects.hashCode(yaw);
        result = 31 * result + Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(isPrimary);
        return result;
    }

    @Override
    public String toString() {
        return "GpsRawInt{timeUsec=" + timeUsec
                 + ", fixType=" + fixType
                 + ", lat=" + lat
                 + ", lon=" + lon
                 + ", alt=" + alt
                 + ", eph=" + eph
                 + ", epv=" + epv
                 + ", vel=" + vel
                 + ", cog=" + cog
                 + ", satellitesVisible=" + satellitesVisible
                 + ", altEllipsoid=" + altEllipsoid
                 + ", hAcc=" + hAcc
                 + ", vAcc=" + vAcc
                 + ", velAcc=" + velAcc
                 + ", hdgAcc=" + hdgAcc
                 + ", yaw=" + yaw
                 + ", id=" + id
                 + ", isPrimary=" + isPrimary + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private EnumValue<GpsFixType> fixType;

        private int lat;

        private int lon;

        private int alt;

        private int eph;

        private int epv;

        private int vel;

        private int cog;

        private int satellitesVisible;

        private int altEllipsoid;

        private long hAcc;

        private long vAcc;

        private long velAcc;

        private long hdgAcc;

        private int yaw;

        private int id;

        private int isPrimary;

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * GPS fix type. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = GpsFixType.class,
                description = "GPS fix type."
        )
        public final Builder fixType(EnumValue<GpsFixType> fixType) {
            this.fixType = fixType;
            return this;
        }

        /**
         * GPS fix type. 
         */
        public final Builder fixType(GpsFixType entry) {
            return fixType(EnumValue.of(entry));
        }

        /**
         * GPS fix type. 
         */
        public final Builder fixType(Enum... flags) {
            return fixType(EnumValue.create(flags));
        }

        /**
         * GPS fix type. 
         */
        public final Builder fixType(Collection<Enum> flags) {
            return fixType(EnumValue.create(flags));
        }

        /**
         * Latitude (WGS84, EGM96 ellipsoid) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true,
                description = "Latitude (WGS84, EGM96 ellipsoid)"
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude (WGS84, EGM96 ellipsoid) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true,
                description = "Longitude (WGS84, EGM96 ellipsoid)"
        )
        public final Builder lon(int lon) {
            this.lon = lon;
            return this;
        }

        /**
         * Altitude (MSL). Positive for up. Note that virtually all GPS modules provide the MSL altitude 
         * in addition to the WGS84 altitude. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Altitude (MSL). Positive for up. Note that virtually all GPS modules provide the MSL altitude in addition to the WGS84 altitude."
        )
        public final Builder alt(int alt) {
            this.alt = alt;
            return this;
        }

        /**
         * GPS HDOP horizontal dilution of position (unitless). If unknown, set to: UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "GPS HDOP horizontal dilution of position (unitless). If unknown, set to: UINT16_MAX"
        )
        public final Builder eph(int eph) {
            this.eph = eph;
            return this;
        }

        /**
         * GPS VDOP vertical dilution of position (unitless). If unknown, set to: UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                description = "GPS VDOP vertical dilution of position (unitless). If unknown, set to: UINT16_MAX"
        )
        public final Builder epv(int epv) {
            this.epv = epv;
            return this;
        }

        /**
         * GPS ground speed. If unknown, set to: UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                description = "GPS ground speed. If unknown, set to: UINT16_MAX"
        )
        public final Builder vel(int vel) {
            this.vel = vel;
            return this;
        }

        /**
         * Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 
         * degrees. If unknown, set to: UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                description = "Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 degrees. If unknown, set to: UINT16_MAX"
        )
        public final Builder cog(int cog) {
            this.cog = cog;
            return this;
        }

        /**
         * Number of satellites visible. If unknown, set to 255 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1,
                description = "Number of satellites visible. If unknown, set to 255"
        )
        public final Builder satellitesVisible(int satellitesVisible) {
            this.satellitesVisible = satellitesVisible;
            return this;
        }

        /**
         * Altitude (above WGS84, EGM96 ellipsoid). Positive for up. 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                signed = true,
                extension = true,
                description = "Altitude (above WGS84, EGM96 ellipsoid). Positive for up."
        )
        public final Builder altEllipsoid(int altEllipsoid) {
            this.altEllipsoid = altEllipsoid;
            return this;
        }

        /**
         * Position uncertainty. 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                extension = true,
                description = "Position uncertainty."
        )
        public final Builder hAcc(long hAcc) {
            this.hAcc = hAcc;
            return this;
        }

        /**
         * Altitude uncertainty. 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4,
                extension = true,
                description = "Altitude uncertainty."
        )
        public final Builder vAcc(long vAcc) {
            this.vAcc = vAcc;
            return this;
        }

        /**
         * Speed uncertainty. 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 4,
                extension = true,
                description = "Speed uncertainty."
        )
        public final Builder velAcc(long velAcc) {
            this.velAcc = velAcc;
            return this;
        }

        /**
         * Heading / track uncertainty 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 4,
                extension = true,
                description = "Heading / track uncertainty"
        )
        public final Builder hdgAcc(long hdgAcc) {
            this.hdgAcc = hdgAcc;
            return this;
        }

        /**
         * Yaw in earth frame from north. Use 0 if this GPS does not provide yaw. Use 65535 if this GPS is 
         * configured to provide yaw and is currently unable to provide it. Use 36000 for north. 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 2,
                extension = true,
                description = "Yaw in earth frame from north. Use 0 if this GPS does not provide yaw. Use 65535 if this GPS is configured to provide yaw and is currently unable to provide it. Use 36000 for north."
        )
        public final Builder yaw(int yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * GPS ID. 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 1,
                extension = true,
                description = "GPS ID."
        )
        public final Builder id(int id) {
            this.id = id;
            return this;
        }

        /**
         * Boolean indicating whether this GPS is primary (currently used for navigation) or not 
         * (primary: 1, not primary: 0). 
         */
        @MavlinkFieldInfo(
                position = 19,
                unitSize = 1,
                extension = true,
                description = "Boolean indicating whether this GPS is primary (currently used for navigation) or not (primary: 1, not primary: 0)."
        )
        public final Builder isPrimary(int isPrimary) {
            this.isPrimary = isPrimary;
            return this;
        }

        public final GpsRawInt build() {
            return new GpsRawInt(timeUsec, fixType, lat, lon, alt, eph, epv, vel, cog, satellitesVisible, altEllipsoid, hAcc, vAcc, velAcc, hdgAcc, yaw, id, isPrimary);
        }
    }
}
