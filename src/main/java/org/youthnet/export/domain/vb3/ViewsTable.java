package org.youthnet.export.domain.vb3;


import java.sql.Timestamp;
import java.util.UUID;


public class ViewsTable {

    private Long version;
    private String sectionlookup;
    private Timestamp created;
    private Long vbase2id;
    private String discriminator;
    private Timestamp modified;
    private String sectionname;
    private String lookupuptypesvalue;
    private UUID modifiedby;
    private String skilltype;
    private UUID id;
    private Boolean deleted;
    private UUID createdby;
    private Boolean isskills;
    private String fieldname;

    public ViewsTable() {
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

    public Boolean getIsSKills() {
        return this.isskills;
    }

    public void setIsSKills(Boolean isskills) {
        this.isskills = isskills;
    }

    public Long getVbase2Id() {
        return this.vbase2id;
    }

    public void setVbase2Id(Long vbase2id) {
        this.vbase2id = vbase2id;
    }

    public String getSectionName() {
        return this.sectionname;
    }

    public void setSectionName(String sectionname) {
        this.sectionname = sectionname;
    }

    public String getLookupUpTypesValue() {
        return this.lookupuptypesvalue;
    }

    public void setLookupUpTypesValue(String lookupuptypesvalue) {
        this.lookupuptypesvalue = lookupuptypesvalue;
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

    public String getSectionLookup() {
        return this.sectionlookup;
    }

    public void setSectionLookup(String sectionlookup) {
        this.sectionlookup = sectionlookup;
    }

    public String getSkillType() {
        return this.skilltype;
    }

    public void setSkillType(String skilltype) {
        this.skilltype = skilltype;
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

    public String getFieldName() {
        return this.fieldname;
    }

    public void setFieldName(String fieldname) {
        this.fieldname = fieldname;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }
}
