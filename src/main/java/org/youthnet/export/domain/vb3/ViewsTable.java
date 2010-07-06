package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ViewsTable implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 15;
    private List<String> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

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

    public ViewsTable(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split(String.valueOf(this.delimiter));
        StringBuffer uuidStringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");


        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[0].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.id = UUID.fromString(uuidStringBuffer.toString());

        this.deleted = fields[1].replace(String.valueOf(this.enclosure), "").equals("1");

        this.isskills = fields[2].replace(String.valueOf(this.enclosure), "").equals("1");

        this.vbase2id = Long.valueOf(fields[3].replace(String.valueOf(this.enclosure), ""));

        this.sectionname = fields[4].replace(String.valueOf(this.enclosure), "");

        this.lookupuptypesvalue = fields[5].replace(String.valueOf(this.enclosure), "");

        this.version = Long.valueOf(fields[6].replace(String.valueOf(this.enclosure), ""));

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[7].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.modifiedby = UUID.fromString(uuidStringBuffer.toString());

        this.sectionlookup = fields[8].replace(String.valueOf(this.enclosure), "");

        this.skilltype = fields[9].replace(String.valueOf(this.enclosure), "");

        try {
            this.created = new Timestamp(simpleDateFormat.parse(fields[10].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp created " + fields[10].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[11].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.createdby = UUID.fromString(uuidStringBuffer.toString());

        this.discriminator = fields[12].replace(String.valueOf(this.enclosure), "");

        this.fieldname = fields[13].replace(String.valueOf(this.enclosure), "");

        try {
            this.modified = new Timestamp(simpleDateFormat.parse(fields[14].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp modified " + fields[14].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

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


    public char getDelimiter() {
        return this.delimiter;
    }

    public void setDelimiter(char delimiter) {
        this.delimiter = delimiter;
    }

    public char getEnclosure() {
        return this.enclosure;
    }

    public void setEnclosure(char enclosure) {
        this.enclosure = enclosure;
    }

    public Integer getColumnNumber() {
        return this.columnNum;
    }

    public List<String> getColumnNames() {
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
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.id.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(deleted ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(isskills ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.vbase2id);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.sectionname);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.lookupuptypesvalue);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.version);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.modifiedby.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.sectionlookup);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.skilltype);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.created);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.createdby.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.discriminator);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.fieldname);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.modified);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
