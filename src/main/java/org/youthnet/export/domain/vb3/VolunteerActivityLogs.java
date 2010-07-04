package org.youthnet.export.domain.vb3;


import java.sql.Timestamp;
import java.util.UUID;


public class VolunteerActivityLogs {

    private Long version;
    private Timestamp created;
    private Timestamp modified;
    private UUID modifiedby;
    private UUID activitylogid;
    private UUID id;
    private Boolean deleted;
    private UUID createdby;
    private UUID volunteerid;

    public VolunteerActivityLogs() {
    }

    public UUID getActivityLogId() {
        return this.activitylogid;
    }

    public void setActivityLogId(UUID activitylogid) {
        this.activitylogid = activitylogid;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public UUID getModifiedBy() {
        return this.modifiedby;
    }

    public void setModifiedBy(UUID modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Timestamp getCreated() {
        return this.created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public UUID getCreatedBy() {
        return this.createdby;
    }

    public void setCreatedBy(UUID createdby) {
        this.createdby = createdby;
    }

    public UUID getVolunteerId() {
        return this.volunteerid;
    }

    public void setVolunteerId(UUID volunteerid) {
        this.volunteerid = volunteerid;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }
}
