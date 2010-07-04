package org.youthnet.export.domain.vb3;


import java.sql.Timestamp;
import java.util.UUID;


public class ActivityLogs {

    private Long version;
    private String subject;
    private Timestamp enddate;
    private Boolean isalldayevent;
    private Boolean showincalender;
    private Timestamp created;
    private Timestamp startdate;
    private Long vbase2id;
    private String endtime;
    private Timestamp modified;
    private String notes;
    private String starttime;
    private UUID modifiedby;
    private UUID personhereid;
    private UUID id;
    private Boolean deleted;
    private UUID createdby;
    private UUID activitytypeid;

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
}
