package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ActivityLogs implements CSVable, ContainsVb2id {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 18;
    private List<String[]> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

    private Boolean isalldayevent;
    private String notes;
    private Boolean showincalender;
    private Timestamp startdate;
    private String starttime;
    private String subject;
    private Long vbase2id;
    private UUID activitytypeid;
    private UUID personhereid;
    private UUID id;
    private Timestamp created;
    private UUID createdby;
    private Boolean deleted;
    private Timestamp modified;
    private UUID modifiedby;
    private Long version;
    private Timestamp enddate;
    private String endtime;

    public ActivityLogs() {
    }

    public ActivityLogs(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));
        StringBuffer uuidStringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");


        this.isalldayevent = fields[0].replace(String.valueOf(this.enclosure), "").equals("1");

        this.notes = fields[1].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.showincalender = fields[2].replace(String.valueOf(this.enclosure), "").equals("1");

        try {
            this.startdate = (fields[3].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[3].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp startdate " + fields[3].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        this.starttime = fields[4].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.subject = fields[5].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.vbase2id = (fields[6].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[6].replace(String.valueOf(this.enclosure), ""));

        if (fields[7].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.activitytypeid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[7].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.activitytypeid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[8].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.personhereid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[8].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.personhereid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[9].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.id = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[9].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.id = UUID.fromString(uuidStringBuffer.toString());
        }

        try {
            this.created = (fields[10].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[10].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp created " + fields[10].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        if (fields[11].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.createdby = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[11].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.createdby = UUID.fromString(uuidStringBuffer.toString());
        }

        this.deleted = fields[12].replace(String.valueOf(this.enclosure), "").equals("1");

        try {
            this.modified = (fields[13].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[13].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp modified " + fields[13].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        if (fields[14].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.modifiedby = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[14].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.modifiedby = UUID.fromString(uuidStringBuffer.toString());
        }

        this.version = (fields[15].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[15].replace(String.valueOf(this.enclosure), ""));

        try {
            this.enddate = (fields[16].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[16].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp enddate " + fields[16].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        this.endtime = fields[17].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

    }


    public Boolean getIsAllDayEvent() {
        return this.isalldayevent;
    }

    public void setIsAllDayEvent(Boolean isalldayevent) {
        this.isalldayevent = isalldayevent;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getShowInCalender() {
        return this.showincalender;
    }

    public void setShowInCalender(Boolean showincalender) {
        this.showincalender = showincalender;
    }

    public Timestamp getStartDate() {
        return this.startdate;
    }

    public void setStartDate(Timestamp startdate) {
        this.startdate = startdate;
    }

    public String getStartTime() {
        return this.starttime;
    }

    public void setStartTime(String starttime) {
        this.starttime = starttime;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Long getVbase2Id() {
        return this.vbase2id;
    }

    public void setVbase2Id(Long vbase2id) {
        this.vbase2id = vbase2id;
    }

    public UUID getActivityTypeId() {
        return this.activitytypeid;
    }

    public void setActivityTypeId(UUID activitytypeid) {
        this.activitytypeid = activitytypeid;
    }

    public UUID getPersonHereId() {
        return this.personhereid;
    }

    public void setPersonHereId(UUID personhereid) {
        this.personhereid = personhereid;
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

    public Timestamp getEndDate() {
        return this.enddate;
    }

    public void setEndDate(Timestamp enddate) {
        this.enddate = enddate;
    }

    public String getEndTime() {
        return this.endtime;
    }

    public void setEndTime(String endtime) {
        this.endtime = endtime;
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
            this.columnNames.add(new String[]{"IsAllDayEvent", "Boolean"});
            this.columnNames.add(new String[]{"Notes", "String"});
            this.columnNames.add(new String[]{"ShowInCalender", "Boolean"});
            this.columnNames.add(new String[]{"StartDate", "Timestamp"});
            this.columnNames.add(new String[]{"StartTime", "String"});
            this.columnNames.add(new String[]{"Subject", "String"});
            this.columnNames.add(new String[]{"Vbase2Id", "Long"});
            this.columnNames.add(new String[]{"ActivityTypeId", "UUID"});
            this.columnNames.add(new String[]{"PersonHereId", "UUID"});
            this.columnNames.add(new String[]{"Id", "UUID"});
            this.columnNames.add(new String[]{"Created", "Timestamp"});
            this.columnNames.add(new String[]{"CreatedBy", "UUID"});
            this.columnNames.add(new String[]{"Deleted", "Boolean"});
            this.columnNames.add(new String[]{"Modified", "Timestamp"});
            this.columnNames.add(new String[]{"ModifiedBy", "UUID"});
            this.columnNames.add(new String[]{"Version", "Long"});
            this.columnNames.add(new String[]{"EndDate", "Timestamp"});
            this.columnNames.add(new String[]{"EndTime", "String"});
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.isalldayevent != null && this.isalldayevent ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.notes == null ? "" :
                this.notes.length() < 250 ? this.notes.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.notes.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.showincalender != null && this.showincalender ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.startdate == null ? "" : this.startdate);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.starttime == null ? "" :
                this.starttime.length() < 250 ? this.starttime.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.starttime.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.subject == null ? "" :
                this.subject.length() < 250 ? this.subject.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.subject.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.vbase2id == null ? "" : this.vbase2id);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.activitytypeid == null ? "" : this.activitytypeid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.personhereid == null ? "" : this.personhereid.toString().replace("-", ""));
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
        recordStringBuffer.append(this.enddate == null ? "" : this.enddate);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.endtime == null ? "" :
                this.endtime.length() < 250 ? this.endtime.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.endtime.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
