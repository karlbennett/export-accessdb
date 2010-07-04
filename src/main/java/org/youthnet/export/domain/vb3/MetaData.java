package org.youthnet.export.domain.vb3;


import java.sql.Timestamp;
import java.util.UUID;


public class MetaData {

    private Long version;
    private UUID dtoid;
    private String type;
    private Timestamp created;
    private Timestamp modified;
    private byte[] serializedobject;
    private UUID modifiedby;
    private byte[] digest;
    private UUID id;
    private Boolean deleted;
    private UUID createdby;

    public MetaData() {
    }

    public byte[] getDigest() {
        return this.digest;
    }

    public void setDigest(byte[] digest) {
        this.digest = digest;
    }

    public UUID getDtoId() {
        return this.dtoid;
    }

    public void setDtoId(UUID dtoid) {
        this.dtoid = dtoid;
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

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
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

    public byte[] getSerializedObject() {
        return this.serializedobject;
    }

    public void setSerializedObject(byte[] serializedobject) {
        this.serializedobject = serializedobject;
    }
}
