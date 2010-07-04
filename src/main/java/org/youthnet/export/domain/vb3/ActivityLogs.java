package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ActivityLogs implements CSVable {

    private String delimiter = "|";
    private String enclosure = "¬";
    private Integer columnNum = 18;
    private List<String> columnNames = null;
    private StringBuffer record = new StringBuffer();

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

    public Timestamp getStartDate() {
        return this.startdate;
    }

    public void setStartDate(Timestamp startdate) {
        this.startdate = startdate;
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
            this.columnNames.add("EndDate");
            this.columnNames.add("ShowInCalender");
            this.columnNames.add("Id");
            this.columnNames.add("StartDate");
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
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.enddate);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.showincalender);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.id.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.startdate);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.deleted);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.vbase2id);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.endtime);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.starttime);
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
        record.append(this.subject);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.isalldayevent);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.personhereid.toString().replace("-", ""));
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
        record.append(this.activitytypeid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.modified);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.notes);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
