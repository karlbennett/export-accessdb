package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Lookups implements CSVable, ContainsVb2id, ContainsDiscriminator, ContainsValue {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 18;
    private List<String[]> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

    private Boolean isusereditable;
    private UUID languageid;
    private UUID ownerid;
    private Long sortorder;
    private Long vbase2id;
    private String value;
    private Boolean appliestoopportunities;
    private Boolean appliestoorganisations;
    private Boolean appliestovolunteers;
    private String discriminator;
    private UUID id;
    private Timestamp created;
    private UUID createdby;
    private Boolean deleted;
    private Timestamp modified;
    private UUID modifiedby;
    private Long version;
    private Boolean isactive;

    public Lookups() {
    }

    public Lookups(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));
        if(fields.length < 19) System.out.println(record);
        StringBuffer uuidStringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");


        this.isusereditable = fields[0].replace(String.valueOf(this.enclosure), "").equals("1");

        if (fields[1].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.languageid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[1].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.languageid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[2].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.ownerid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[2].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.ownerid = UUID.fromString(uuidStringBuffer.toString());
        }

        this.sortorder = (fields[3].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[3].replace(String.valueOf(this.enclosure), ""));

        this.vbase2id = (fields[4].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[4].replace(String.valueOf(this.enclosure), ""));

        this.value = fields[5].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.appliestoopportunities = fields[6].replace(String.valueOf(this.enclosure), "").equals("1");

        this.appliestoorganisations = fields[7].replace(String.valueOf(this.enclosure), "").equals("1");

        this.appliestovolunteers = fields[8].replace(String.valueOf(this.enclosure), "").equals("1");

        this.discriminator = fields[9].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        if (fields[10].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.id = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[10].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.id = UUID.fromString(uuidStringBuffer.toString());
        }

        try {
            this.created = (fields[11].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[11].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp created " + fields[11].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        if (fields[12].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.createdby = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[12].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.createdby = UUID.fromString(uuidStringBuffer.toString());
        }

        this.deleted = fields[13].replace(String.valueOf(this.enclosure), "").equals("1");

        try {
            this.modified = (fields[14].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[14].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp modified " + fields[14].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        if (fields[15].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.modifiedby = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[15].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.modifiedby = UUID.fromString(uuidStringBuffer.toString());
        }

        this.version = (fields[16].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[16].replace(String.valueOf(this.enclosure), ""));

        this.isactive = fields[17].replace(String.valueOf(this.enclosure), "").equals("1");

    }


    public Boolean getIsUserEditable() {
        return this.isusereditable;
    }

    public void setIsUserEditable(Boolean isusereditable) {
        this.isusereditable = isusereditable;
    }

    public UUID getLanguageId() {
        return this.languageid;
    }

    public void setLanguageId(UUID languageid) {
        this.languageid = languageid;
    }

    public UUID getOwnerId() {
        return this.ownerid;
    }

    public void setOwnerId(UUID ownerid) {
        this.ownerid = ownerid;
    }

    public Long getSortOrder() {
        return this.sortorder;
    }

    public void setSortOrder(Long sortorder) {
        this.sortorder = sortorder;
    }

    public Long getVbase2Id() {
        return this.vbase2id;
    }

    public void setVbase2Id(Long vbase2id) {
        this.vbase2id = vbase2id;
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

    public Boolean getAppliesToOrganisations() {
        return this.appliestoorganisations;
    }

    public void setAppliesToOrganisations(Boolean appliestoorganisations) {
        this.appliestoorganisations = appliestoorganisations;
    }

    public Boolean getAppliesToVolunteers() {
        return this.appliestovolunteers;
    }

    public void setAppliesToVolunteers(Boolean appliestovolunteers) {
        this.appliestovolunteers = appliestovolunteers;
    }

    public String getDiscriminator() {
        return this.discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public UUID getModifiedBy() {
        return this.modifiedby;
    }

    public void setModifiedBy(UUID modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Boolean getIsActive() {
        return this.isactive;
    }

    public void setIsActive(Boolean isactive) {
        this.isactive = isactive;
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

    public List<String[]> getColumnNames() {
        if (this.columnNames == null) {
            this.columnNames = new ArrayList<String[]>();
            this.columnNames.add(new String[]{"IsUserEditable", "Boolean"});
            this.columnNames.add(new String[]{"LanguageId", "UUID"});
            this.columnNames.add(new String[]{"OwnerId", "UUID"});
            this.columnNames.add(new String[]{"SortOrder", "Long"});
            this.columnNames.add(new String[]{"Vbase2Id", "Long"});
            this.columnNames.add(new String[]{"Value", "String"});
            this.columnNames.add(new String[]{"AppliesToOpportunities", "Boolean"});
            this.columnNames.add(new String[]{"AppliesToOrganisations", "Boolean"});
            this.columnNames.add(new String[]{"AppliesToVolunteers", "Boolean"});
            this.columnNames.add(new String[]{"Discriminator", "String"});
            this.columnNames.add(new String[]{"Id", "UUID"});
            this.columnNames.add(new String[]{"Created", "Timestamp"});
            this.columnNames.add(new String[]{"CreatedBy", "UUID"});
            this.columnNames.add(new String[]{"Deleted", "Boolean"});
            this.columnNames.add(new String[]{"Modified", "Timestamp"});
            this.columnNames.add(new String[]{"ModifiedBy", "UUID"});
            this.columnNames.add(new String[]{"Version", "Long"});
            this.columnNames.add(new String[]{"IsActive", "Boolean"});
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.isusereditable != null && this.isusereditable ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.languageid == null ? "" : this.languageid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.ownerid == null ? "" : this.ownerid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.sortorder == null ? "" : this.sortorder);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.vbase2id == null ? "" : this.vbase2id);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.value == null ? "" :
                this.value.length() < 240 ? this.value.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.value.substring(0, 240).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.appliestoopportunities != null && this.appliestoopportunities ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.appliestoorganisations != null && this.appliestoorganisations ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.appliestovolunteers != null && this.appliestovolunteers ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.discriminator == null ? "" :
                this.discriminator.length() < 240 ? this.discriminator.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.discriminator.substring(0, 240).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.id == null ? "" : this.id.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.created == null ? "" : this.created);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.createdby == null ? "" : this.createdby.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.deleted != null && this.deleted ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.modified == null ? "" : this.modified);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.modifiedby == null ? "" : this.modifiedby.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.version == null ? "" : this.version);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.isactive != null && this.isactive ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
