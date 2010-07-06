package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class OpportunityActLogs implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 10;
    private List<String> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

    private UUID activitylogid;
    private UUID id;
    private Boolean deleted;
    private Long version;
    private UUID modifiedby;
    private UUID opportunityid;
    private UUID opportunitylocationid;
    private Timestamp created;
    private UUID createdby;
    private Timestamp modified;

    public OpportunityActLogs() {
    }

    public OpportunityActLogs(String record) {
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
        this.activitylogid = UUID.fromString(uuidStringBuffer.toString());

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[1].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.id = UUID.fromString(uuidStringBuffer.toString());

        this.deleted = fields[2].replace(String.valueOf(this.enclosure), "").equals("1");

        this.version = Long.valueOf(fields[3].replace(String.valueOf(this.enclosure), ""));

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[4].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.modifiedby = UUID.fromString(uuidStringBuffer.toString());

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[5].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.opportunitylocationid = UUID.fromString(uuidStringBuffer.toString());

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[6].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.opportunityid = UUID.fromString(uuidStringBuffer.toString());

        try {
            this.created = new Timestamp(simpleDateFormat.parse(fields[7].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp created " + fields[7].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[8].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.createdby = UUID.fromString(uuidStringBuffer.toString());

        try {
            this.modified = new Timestamp(simpleDateFormat.parse(fields[9].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp modified " + fields[9].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

    }


    public UUID getActivityLogId() {
        return this.activitylogid;
    }

    public void setActivityLogId(UUID activitylogid) {
        this.activitylogid = activitylogid;
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

    public UUID getOpportunityId() {
        return this.opportunityid;
    }

    public void setOpportunityId(UUID opportunityid) {
        this.opportunityid = opportunityid;
    }

    public UUID getOpportunityLocationId() {
        return this.opportunitylocationid;
    }

    public void setOpportunityLocationId(UUID opportunitylocationid) {
        this.opportunitylocationid = opportunitylocationid;
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
            this.columnNames.add("ActivityLogId");
            this.columnNames.add("Id");
            this.columnNames.add("Deleted");
            this.columnNames.add("Version");
            this.columnNames.add("ModifiedBy");
            this.columnNames.add("OpportunityLocationId");
            this.columnNames.add("OpportunityId");
            this.columnNames.add("Created");
            this.columnNames.add("CreatedBy");
            this.columnNames.add("Modified");
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.activitylogid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.id.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(deleted ? 1 : 0);
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
        recordStringBuffer.append(this.opportunitylocationid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.opportunityid.toString().replace("-", ""));
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
        recordStringBuffer.append(this.modified);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
