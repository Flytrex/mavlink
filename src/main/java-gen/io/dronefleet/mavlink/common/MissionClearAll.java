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
 * Delete all mission items at once. 
 */
@MavlinkMessageInfo(
        id = 45,
        crc = 232,
        description = "Delete all mission items at once."
)
public final class MissionClearAll implements HasTransmissionId<MissionClearAll> {
    private final int targetSystem;

    private final int targetComponent;

    private final EnumValue<MavMissionType> missionType;

    private final int tid;

    private MissionClearAll(int targetSystem, int targetComponent,
            EnumValue<MavMissionType> missionType, int tid) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.missionType = missionType;
        this.tid = tid;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(MissionClearAll msg) {
        return builder()
                .targetSystem(msg.targetSystem)
                .targetComponent(msg.targetComponent)
                .missionType(msg.missionType)
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
     * Mission type. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = MavMissionType.class,
            extension = true,
            description = "Mission type."
    )
    public final EnumValue<MavMissionType> missionType() {
        return this.missionType;
    }

    /**
     * Transmission id. 
     */
    @MavlinkFieldInfo(
            position = 5,
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
        MissionClearAll other = (MissionClearAll)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(missionType, other.missionType)) return false;
        if (!Objects.deepEquals(tid, other.tid)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(missionType);
        result = 31 * result + Objects.hashCode(tid);
        return result;
    }

    @Override
    public String toString() {
        return "MissionClearAll{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", missionType=" + missionType
                 + ", tid=" + tid + "}";
    }

    @Override
    public MissionClearAll withTransmissionId(int tid) {
        return builder(this).tid(tid).build();
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private EnumValue<MavMissionType> missionType;

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
         * Mission type. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = MavMissionType.class,
                extension = true,
                description = "Mission type."
        )
        public final Builder missionType(EnumValue<MavMissionType> missionType) {
            this.missionType = missionType;
            return this;
        }

        /**
         * Mission type. 
         */
        public final Builder missionType(MavMissionType entry) {
            return missionType(EnumValue.of(entry));
        }

        /**
         * Mission type. 
         */
        public final Builder missionType(Enum... flags) {
            return missionType(EnumValue.create(flags));
        }

        /**
         * Mission type. 
         */
        public final Builder missionType(Collection<Enum> flags) {
            return missionType(EnumValue.create(flags));
        }

        /**
         * Transmission id. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                extension = true,
                description = "Transmission id."
        )
        public final Builder tid(int tid) {
            this.tid = tid;
            return this;
        }

        public final MissionClearAll build() {
            return new MissionClearAll(targetSystem, targetComponent, missionType, tid);
        }
    }
}
