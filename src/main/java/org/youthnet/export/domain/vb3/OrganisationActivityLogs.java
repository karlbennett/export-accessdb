package org.youthnet.export.domain.vb3;


import java.sql.Timestamp;
import java.util.UUID;


public class OrganisationActivityLogs {

    private Long version;
    private Timestamp created;
    private UUID contactid;
    private UUID organisationid;
    private Timestamp modified;
    private UUID modifiedby;
    private UUID activitylogid;
    private UUID id;
    private Boolean deleted;
    private UUID createdby;

    public OrganisationActivityLogs() {
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

    public UUID getContactId() {
        return this.contactid;
    }

    public void setContactId(UUID contactid) {
        this.contactid = contactid;
    }

    public UUID getOrganisationId() {
        return this.organisationid;
    }

    public void setOrganisationId(UUID organisationid) {
        this.organisationid = organisationid;
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

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }
}
