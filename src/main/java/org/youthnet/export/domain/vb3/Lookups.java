package org.youthnet.export.domain.vb3;


import java.sql.Timestamp;
import java.util.UUID;


public class Lookups {

    private Long version;
    private Boolean appliestovolunteers;
    private UUID languageid;
    private Timestamp created;
    private UUID ownerid;
    private Long vbase2id;
    private String discriminator;
    private Timestamp modified;
    private Boolean appliestoorganisations;
    private UUID modifiedby;
    private Boolean isactive;
    private Long sortorder;
    private Boolean appliestoopportunities;
    private String value;
    private UUID id;
    private Boolean deleted;
    private UUID createdby;
    private Boolean isusereditable;

    public Lookups() {
    }

    public UUID getLanguageId() {
        return this.languageid;
    }

    public void setLanguageId(UUID languageid) {
        this.languageid = languageid;
    }

    public Boolean getAppliesToOpportunities() {
        return this.appliestoopportunities;
    }

    public void setAppliesToOpportunities(Boolean appliestoopportunities) {
        this.appliestoopportunities = appliestoopportunities;
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

    public UUID getOwnerId() {
        return this.ownerid;
    }

    public void setOwnerId(UUID ownerid) {
        this.ownerid = ownerid;
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

    public Boolean getAppliesToVolunteers() {
        return this.appliestovolunteers;
    }

    public void setAppliesToVolunteers(Boolean appliestovolunteers) {
        this.appliestovolunteers = appliestovolunteers;
    }

    public Boolean getIsActive() {
        return this.isactive;
    }

    public void setIsActive(Boolean isactive) {
        this.isactive = isactive;
    }

    public Long getSortOrder() {
        return this.sortorder;
    }

    public void setSortOrder(Long sortorder) {
        this.sortorder = sortorder;
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

    public Long getVBase2Id() {
        return this.vbase2id;
    }

    public void setVBase2Id(Long vbase2id) {
        this.vbase2id = vbase2id;
    }

    public Boolean getIsUserEditable() {
        return this.isusereditable;
    }

    public void setIsUserEditable(Boolean isusereditable) {
        this.isusereditable = isusereditable;
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

    public Boolean getAppliesToOrganisations() {
        return this.appliestoorganisations;
    }

    public void setAppliesToOrganisations(Boolean appliestoorganisations) {
        this.appliestoorganisations = appliestoorganisations;
    }
}
