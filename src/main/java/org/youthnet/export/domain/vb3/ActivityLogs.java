package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ActivityLogs implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 18;
    private List<String> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

    private Timestamp enddate;
    private Boolean showincalender;
    private UUID id;
    private Timestamp startdate;
    private Boolean deleted;
    private Long vbase2id;
    private String endtime;
    private String starttime;
    private Long version;
    private UUID modifiedby;
    private String subject;
    private Boolean isalldayevent;
    private UUID personhereid;
    private Timestamp created;
    private UUID createdby;
    private UUID activitytypeid;
    private Timestamp modified;
    private String notes;

    public ActivityLogs() {
    }

    public ActivityLogs(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split(String.valueOf(this.delimiter));
        StringBuffer uuidStringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");


        try {
            this.enddate = new Timestamp(simpleDateFormat.parse(fields[0].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp enddate " + fields[0].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        this.showincalender = fields[1].replace(String.valueOf(this.enclosure), "").equals("1");

        try {
            this.startdate = new Timestamp(simpleDateFormat.parse(fields[2].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp startdate " + fields[2].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[3].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.id = UUID.fromString(uuidStringBuffer.toString());

        this.deleted = fields[4].replace(String.valueOf(this.enclosure), "").equals("1");

        this.vbase2id = Long.valueOf(fields[5].replace(String.valueOf(this.enclosure), ""));

        this.endtime = fields[6].replace(String.valueOf(this.enclosure), "");

        this.starttime = fields[7].replace(String.valueOf(this.enclosure), "");

        this.version = Long.valueOf(fields[8].replace(String.valueOf(this.enclosure), ""));

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[9].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.modifiedby = UUID.fromString(uuidStringBuffer.toString());

        this.subject = fields[10].replace(String.valueOf(this.enclosure), "");

        this.isalldayevent = fields[11].replace(String.valueOf(this.enclosure), "").equals("1");

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[12].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.personhereid = UUID.fromString(uuidStringBuffer.toString());

        try {
            this.created = new Timestamp(simpleDateFormat.parse(fields[13].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp created " + fields[13].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[14].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.createdby = UUID.fromString(uuidStringBuffer.toString());

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[15].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.activitytypeid = UUID.fromString(uuidStringBuffer.toString());

        try {
            this.modified = new Timestamp(simpleDateFormat.parse(fields[16].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp modified " + fields[16].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        this.notes = fields[17].replace(String.valueOf(this.enclosure), "");

    }


    public Timestamp getEndDate() {
        return this.enddate;
    }

    public void setEndDate(Timestamp enddate) {
        this.enddate = enddate;
    }

    public Boolean getShowInCalender() {
        return this.showincalender;
    }

    public void setShowInCalender(Boolean showincalender) {
        this.showincalender = showincalender;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Timestamp getStartDate() {
        return this.startdate;
    }

    public void setStartDate(Timestamp startdate) {
        this.startdate = startdate;
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

    public String getEndTime() {
        return this.endtime;
    }

    public void setEndTime(String endtime) {
        this.endtime = endtime;
    }

    public String getStartTime() {
        return this.starttime;
    }

    public void setStartTime(String starttime) {
        this.starttime = starttime;
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

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean getIsAllDayEvent() {
        return this.isalldayevent;
    }

    public void setIsAllDayEvent(Boolean isalldayevent) {
        this.isalldayevent = isalldayevent;
    }

    public UUID getPersonHereId() {
        return this.personhereid;
    }

    public void setPersonHereId(UUID personhereid) {
        this.personhereid = personhereid;
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

    public UUID getActivityTypeId() {
        return this.activitytypeid;
    }

    public void setActivityTypeId(UUID activitytypeid) {
        this.activitytypeid = activitytypeid;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
            this.columnNames.add("EndDate");
            this.columnNames.add("ShowInCalender");
            this.columnNames.add("StartDate");
            this.columnNames.add("Id");
            this.columnNames.add("Deleted");
            this.columnNames.add("Vbase2Id");
            this.columnNames.add("EndTime");
            this.columnNames.add("StartTime");
            this.columnNames.add("Version");
            this.columnNames.add("ModifiedBy");
            this.columnNames.add("Subject");
            this.columnNames.add("IsAllDayEvent");
            this.columnNames.add("PersonHereId");
            this.columnNames.add("Created");
            this.columnNames.add("CreatedBy");
            this.columnNames.add("ActivityTypeId");
            this.columnNames.add("Modified");
            this.columnNames.add("Notes");
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.enddate);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(showincalender ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.startdate);
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
        recordStringBuffer.append(this.vbase2id);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.endtime);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.starttime);
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
        recordStringBuffer.append(this.subject);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(isalldayevent ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.personhereid.toString().replace("-", ""));
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
        recordStringBuffer.append(this.activitytypeid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.modified);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.notes);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
