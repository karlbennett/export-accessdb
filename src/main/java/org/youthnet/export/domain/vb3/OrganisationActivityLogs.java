package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class OrganisationActivityLogs implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 10;
    private List<String[]> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

    private UUID organisationid;
    private UUID id;
    private Timestamp created;
    private UUID createdby;
    private Boolean deleted;
    private Timestamp modified;
    private UUID modifiedby;
    private Long version;
    private UUID activitylogid;
    private UUID contactid;

    public OrganisationActivityLogs() {
    }

    public OrganisationActivityLogs(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));
        StringBuffer uuidStringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");


        if (fields[0].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.organisationid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[0].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.organisationid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[1].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.id = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[1].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.id = UUID.fromString(uuidStringBuffer.toString());
        }

        try {
            this.created = (fields[2].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[2].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp created " + fields[2].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        if (fields[3].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.createdby = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[3].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.createdby = UUID.fromString(uuidStringBuffer.toString());
        }

        this.deleted = fields[4].replace(String.valueOf(this.enclosure), "").equals("1");

        try {
            this.modified = (fields[5].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[5].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp modified " + fields[5].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        if (fields[6].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.modifiedby = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[6].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.modifiedby = UUID.fromString(uuidStringBuffer.toString());
        }

        this.version = (fields[7].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[7].replace(String.valueOf(this.enclosure), ""));

        if (fields[8].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.activitylogid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[8].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.activitylogid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[9].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.contactid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[9].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.contactid = UUID.fromString(uuidStringBuffer.toString());
        }

    }


    public UUID getOrganisationId() {
        return this.organisationid;
    }

    public void setOrganisationId(UUID organisationid) {
        this.organisationid = organisationid;
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

    public UUID getActivityLogId() {
        return this.activitylogid;
    }

    public void setActivityLogId(UUID activitylogid) {
        this.activitylogid = activitylogid;
    }

    public UUID getContactId() {
        return this.contactid;
    }

    public void setContactId(UUID contactid) {
        this.contactid = contactid;
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
            this.columnNames.add(new String[]{"OrganisationId", "UUID"});
            this.columnNames.add(new String[]{"Id", "UUID"});
            this.columnNames.add(new String[]{"Created", "Timestamp"});
            this.columnNames.add(new String[]{"CreatedBy", "UUID"});
            this.columnNames.add(new String[]{"Deleted", "Boolean"});
            this.columnNames.add(new String[]{"Modified", "Timestamp"});
            this.columnNames.add(new String[]{"ModifiedBy", "UUID"});
            this.columnNames.add(new String[]{"Version", "Long"});
            this.columnNames.add(new String[]{"ActivityLogId", "UUID"});
            this.columnNames.add(new String[]{"ContactId", "UUID"});
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.organisationid == null ? "" : this.organisationid.toString().replace("-", ""));
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
        recordStringBuffer.append(this.activitylogid == null ? "" : this.activitylogid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.contactid == null ? "" : this.contactid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
