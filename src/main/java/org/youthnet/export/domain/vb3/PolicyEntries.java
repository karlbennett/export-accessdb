package org.youthnet.export.domain.vb3;


import java.sql.Timestamp;
import java.util.UUID;


public class PolicyEntries {

    private Long version;
    private Timestamp created;
    private Long vbase2id;
    private String discriminator;
    private Timestamp modified;
    private UUID policyid;
    private UUID modifiedby;
    private String comments;
    private UUID id;
    private Boolean deleted;
    private UUID createdby;
    private UUID policystatusid;

    public PolicyEntries() {
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public Long getVbase2Id() {
        return this.vbase2id;
    }

    public void setVbase2Id(Long vbase2id) {
        this.vbase2id = vbase2id;
    }

    public UUID getPolicyId() {
        return this.policyid;
    }

    public void setPolicyId(UUID policyid) {
        this.policyid = policyid;
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

    public String getDiscriminator() {
        return this.discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public UUID getPolicyStatusId() {
        return this.policystatusid;
    }

    public void setPolicyStatusId(UUID policystatusid) {
        this.policystatusid = policystatusid;
    }
}
