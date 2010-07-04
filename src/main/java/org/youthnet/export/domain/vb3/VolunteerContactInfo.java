package org.youthnet.export.domain.vb3;


import java.sql.Timestamp;
import java.util.UUID;


public class VolunteerContactInfo {

    private Long version;
    private Boolean isdefault;
    private Timestamp created;
    private Timestamp modified;
    private String notes;
    private UUID modifiedby;
    private Boolean isactive;
    private UUID id;
    private Boolean deleted;
    private UUID createdby;

    public VolunteerContactInfo() {
    }

    public Boolean getIsDefault() {
        return this.isdefault;
    }

    public void setIsDefault(Boolean isdefault) {
        this.isdefault = isdefault;
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

    public Boolean getIsActive() {
        return this.isactive;
    }

    public void setIsActive(Boolean isactive) {
        this.isactive = isactive;
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

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
