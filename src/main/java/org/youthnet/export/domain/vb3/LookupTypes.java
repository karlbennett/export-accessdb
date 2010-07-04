package org.youthnet.export.domain.vb3;


import java.sql.Timestamp;
import java.util.UUID;


public class LookupTypes {

    private Long version;
    private Timestamp created;
    private Timestamp modified;
    private Boolean canedit;
    private UUID modifiedby;
    private Boolean isvisible;
    private String value;
    private UUID id;
    private Boolean deleted;
    private UUID createdby;

    public LookupTypes() {
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public Boolean getCanEdit() {
        return this.canedit;
    }

    public void setCanEdit(Boolean canedit) {
        this.canedit = canedit;
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

    public Boolean getIsVisible() {
        return this.isvisible;
    }

    public void setIsVisible(Boolean isvisible) {
        this.isvisible = isvisible;
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
