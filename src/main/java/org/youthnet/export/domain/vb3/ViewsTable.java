package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ViewsTable implements CSVable {

    private String delimiter = "|";
    private String enclosure = "¬";
    private Integer columnNum = 15;
    private List<String> columnNames = null;
    private StringBuffer record = new StringBuffer();

    private UUID id;
    private Boolean deleted;
    private Boolean isskills;
    private Long vbase2id;
    private String sectionname;
    private String lookupuptypesvalue;
    private Long version;
    private UUID modifiedby;
    private String sectionlookup;
    private String skilltype;
    private Timestamp created;
    private UUID createdby;
    private String discriminator;
    private String fieldname;
    private Timestamp modified;

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
            this.columnNames.add("Id");
            this.columnNames.add("Deleted");
            this.columnNames.add("IsSKills");
            this.columnNames.add("Vbase2Id");
            this.columnNames.add("SectionName");
            this.columnNames.add("LookupUpTypesValue");
            this.columnNames.add("Version");
            this.columnNames.add("ModifiedBy");
            this.columnNames.add("SectionLookup");
            this.columnNames.add("SkillType");
            this.columnNames.add("Created");
            this.columnNames.add("CreatedBy");
            this.columnNames.add("Discriminator");
            this.columnNames.add("FieldName");
            this.columnNames.add("Modified");
        }

        return this.columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.id.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.deleted);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.isskills);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.vbase2id);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.sectionname);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.lookupuptypesvalue);
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
        record.append(this.sectionlookup);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.skilltype);
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
        record.append(this.discriminator);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.fieldname);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.modified);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
