package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Lookups implements CSVable {

    private String delimiter = "|";
    private String enclosure = "¬";
    private Integer columnNum = 18;
    private List<String> columnNames = null;
    private StringBuffer record = new StringBuffer();

    private UUID languageid;
    private Boolean appliestoopportunities;
    private String value;
    private UUID id;
    private UUID ownerid;
    private Boolean deleted;
    private Long version;
    private UUID modifiedby;
    private Boolean appliestovolunteers;
    private Boolean isactive;
    private Long sortorder;
    private Timestamp created;
    private UUID createdby;
    private Long vbase2id;
    private Boolean isusereditable;
    private String discriminator;
    private Timestamp modified;
    private Boolean appliestoorganisations;

    public Lookups() {
    }

    public UUID getLanguageId() {
        return this.languageid;
    }

    public void setLanguageId(UUID languageid) {
        this.languageid = languageid;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getAppliesToOpportunities() {
        return this.appliestoopportunities;
    }

    public void setAppliesToOpportunities(Boolean appliestoopportunities) {
        this.appliestoopportunities = appliestoopportunities;
    }

    public UUID getOwnerId() {
        return this.ownerid;
    }

    public void setOwnerId(UUID ownerid) {
        this.ownerid = ownerid;
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

    public Boolean getAppliesToOrganisations() {
        return this.appliestoorganisations;
    }

    public void setAppliesToOrganisations(Boolean appliestoorganisations) {
        this.appliestoorganisations = appliestoorganisations;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }


    public String getDelimiter() {
        return this.delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getEnclosure() {
        return this.enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public Integer getClumnNumber() {
        return this.columnNum;
    }

    public List<String> getClumnNames() {
        if (this.columnNames == null) {
            this.columnNames = new ArrayList<String>();
            this.columnNames.add("LanguageId");
            this.columnNames.add("AppliesToOpportunities");
            this.columnNames.add("Value");
            this.columnNames.add("Id");
            this.columnNames.add("OwnerId");
            this.columnNames.add("Deleted");
            this.columnNames.add("Version");
            this.columnNames.add("ModifiedBy");
            this.columnNames.add("AppliesToVolunteers");
            this.columnNames.add("IsActive");
            this.columnNames.add("SortOrder");
            this.columnNames.add("Created");
            this.columnNames.add("CreatedBy");
            this.columnNames.add("VBase2Id");
            this.columnNames.add("IsUserEditable");
            this.columnNames.add("Discriminator");
            this.columnNames.add("Modified");
            this.columnNames.add("AppliesToOrganisations");
        }

        return this.columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.languageid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.appliestoopportunities);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.value);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.id.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.ownerid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.deleted);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.version);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.modifiedby.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.appliestovolunteers);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.isactive);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.sortorder);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.created);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.createdby.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.vbase2id);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.isusereditable);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.discriminator);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.modified);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.appliestoorganisations);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
