package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Status generated by radio. 
 */
@MavlinkMessageInfo(
        id = 166,
        crc = 21,
        description = "Status generated by radio."
)
public final class Radio {
    private final int rssi;

    private final int remrssi;

    private final int txbuf;

    private final int noise;

    private final int remnoise;

    private final int rxerrors;

    private final int fixed;

    private Radio(int rssi, int remrssi, int txbuf, int noise, int remnoise, int rxerrors,
            int fixed) {
        this.rssi = rssi;
        this.remrssi = remrssi;
        this.txbuf = txbuf;
        this.noise = noise;
        this.remnoise = remnoise;
        this.rxerrors = rxerrors;
        this.fixed = fixed;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(Radio msg) {
        return builder()
                .rssi(msg.rssi)
                .remrssi(msg.remrssi)
                .txbuf(msg.txbuf)
                .noise(msg.noise)
                .remnoise(msg.remnoise)
                .rxerrors(msg.rxerrors)
                .fixed(msg.fixed);
    }

    /**
     * Local signal strength. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "Local signal strength."
    )
    public final int rssi() {
        return this.rssi;
    }

    /**
     * Remote signal strength. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Remote signal strength."
    )
    public final int remrssi() {
        return this.remrssi;
    }

    /**
     * How full the tx buffer is. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "How full the tx buffer is."
    )
    public final int txbuf() {
        return this.txbuf;
    }

    /**
     * Background noise level. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "Background noise level."
    )
    public final int noise() {
        return this.noise;
    }

    /**
     * Remote background noise level. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "Remote background noise level."
    )
    public final int remnoise() {
        return this.remnoise;
    }

    /**
     * Receive errors. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "Receive errors."
    )
    public final int rxerrors() {
        return this.rxerrors;
    }

    /**
     * Count of error corrected packets. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            description = "Count of error corrected packets."
    )
    public final int fixed() {
        return this.fixed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Radio other = (Radio)o;
        if (!Objects.deepEquals(rssi, other.rssi)) return false;
        if (!Objects.deepEquals(remrssi, other.remrssi)) return false;
        if (!Objects.deepEquals(txbuf, other.txbuf)) return false;
        if (!Objects.deepEquals(noise, other.noise)) return false;
        if (!Objects.deepEquals(remnoise, other.remnoise)) return false;
        if (!Objects.deepEquals(rxerrors, other.rxerrors)) return false;
        if (!Objects.deepEquals(fixed, other.fixed)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(rssi);
        result = 31 * result + Objects.hashCode(remrssi);
        result = 31 * result + Objects.hashCode(txbuf);
        result = 31 * result + Objects.hashCode(noise);
        result = 31 * result + Objects.hashCode(remnoise);
        result = 31 * result + Objects.hashCode(rxerrors);
        result = 31 * result + Objects.hashCode(fixed);
        return result;
    }

    @Override
    public String toString() {
        return "Radio{rssi=" + rssi
                 + ", remrssi=" + remrssi
                 + ", txbuf=" + txbuf
                 + ", noise=" + noise
                 + ", remnoise=" + remnoise
                 + ", rxerrors=" + rxerrors
                 + ", fixed=" + fixed + "}";
    }

    public static final class Builder {
        private int rssi;

        private int remrssi;

        private int txbuf;

        private int noise;

        private int remnoise;

        private int rxerrors;

        private int fixed;

        /**
         * Local signal strength. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "Local signal strength."
        )
        public final Builder rssi(int rssi) {
            this.rssi = rssi;
            return this;
        }

        /**
         * Remote signal strength. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Remote signal strength."
        )
        public final Builder remrssi(int remrssi) {
            this.remrssi = remrssi;
            return this;
        }

        /**
         * How full the tx buffer is. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "How full the tx buffer is."
        )
        public final Builder txbuf(int txbuf) {
            this.txbuf = txbuf;
            return this;
        }

        /**
         * Background noise level. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "Background noise level."
        )
        public final Builder noise(int noise) {
            this.noise = noise;
            return this;
        }

        /**
         * Remote background noise level. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "Remote background noise level."
        )
        public final Builder remnoise(int remnoise) {
            this.remnoise = remnoise;
            return this;
        }

        /**
         * Receive errors. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "Receive errors."
        )
        public final Builder rxerrors(int rxerrors) {
            this.rxerrors = rxerrors;
            return this;
        }

        /**
         * Count of error corrected packets. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                description = "Count of error corrected packets."
        )
        public final Builder fixed(int fixed) {
            this.fixed = fixed;
            return this;
        }

        public final Radio build() {
            return new Radio(rssi, remrssi, txbuf, noise, remnoise, rxerrors, fixed);
        }
    }
}
