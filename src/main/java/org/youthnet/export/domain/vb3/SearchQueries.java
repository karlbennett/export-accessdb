package org.youthnet.export.domain.vb3;


import java.sql.Timestamp;
import java.util.UUID;


public class SearchQueries {

    private Long version;
    private Timestamp created;
    private UUID userid;
    private Timestamp modified;
    private UUID modifiedby;
    private UUID id;
    private Boolean deleted;
    private UUID createdby;
    private Timestamp lastupdated;
    private Boolean iseditable;
    private byte[] data;

    public SearchQueries() {
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

    public UUID getUserId() {
        return this.userid;
    }

    public void setUserId(UUID userid) {
        this.userid = userid;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] data) {
        this.data = data;
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

    public Timestamp getLastUpdated() {
        return this.lastupdated;
    }

    public void setLastUpdated(Timestamp lastupdated) {
        this.lastupdated = lastupdated;
    }

    public Boolean getIsEditable() {
        return this.iseditable;
    }

    public void setIsEditable(Boolean iseditable) {
        this.iseditable = iseditable;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }
}
