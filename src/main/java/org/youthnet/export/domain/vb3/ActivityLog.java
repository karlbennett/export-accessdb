package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.vb3.lookups.ActivityType;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class ActivityLog extends GenericDTO {


    private Integer vbase2Id;
    private Date startDate;
    private Date endDate;
    private boolean isAllDayEvent;
    private boolean showInCalender;
    private String startTime;
    private String endTime;
    private String subject;
    private String notes;
    private ActivityType activityType;
    private OrganisationContact personHere;
    private Set<VolunteerActivityLog> volunteerActivityLogs = new HashSet<VolunteerActivityLog>(0);
    private Set<OrganisationActivityLog> organisationActivityLogs = new HashSet<OrganisationActivityLog>(0);
    private Set<OpportunityActivityLog> opportunityActivityLogs = new HashSet<OpportunityActivityLog>(0);


    public ActivityLog() {
    }


    public ActivityLog(Integer vbase2Id, Date startDate, Date endDate, boolean isAllDayEvent, boolean showInCalender, String startTime, String endTime, String subject, String notes, ActivityType activityType, OrganisationContact personHere, Set<VolunteerActivityLog> volunteerActivityLogs, Set<OrganisationActivityLog> organisationActivityLogs, Set<OpportunityActivityLog> opportunityActivityLogs) {
        this.vbase2Id = vbase2Id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isAllDayEvent = isAllDayEvent;
        this.showInCalender = showInCalender;
        this.startTime = startTime;
        this.endTime = endTime;
        this.subject = subject;
        this.notes = notes;
        this.activityType = activityType;
        this.personHere = personHere;
        this.volunteerActivityLogs = volunteerActivityLogs;
        this.organisationActivityLogs = organisationActivityLogs;
        this.opportunityActivityLogs = opportunityActivityLogs;
    }


    public Integer getVbase2Id() {
        return this.vbase2Id;
    }


    public void setVbase2Id(Integer vbase2Id) {
        this.vbase2Id = vbase2Id;
    }


    public Date getStartDate() {
        return this.startDate;
    }


    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public Date getEndDate() {
        return this.endDate;
    }


    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public boolean isIsAllDayEvent() {
        return this.isAllDayEvent;
    }


    public void setIsAllDayEvent(boolean isAllDayEvent) {
        this.isAllDayEvent = isAllDayEvent;
    }


    public boolean isShowInCalender() {
        return this.showInCalender;
    }


    public void setShowInCalender(boolean showInCalender) {
        this.showInCalender = showInCalender;
    }


    public String getStartTime() {
        return this.startTime;
    }


    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


    public String getEndTime() {
        return this.endTime;
    }


    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    public String getSubject() {
        return this.subject;
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getNotes() {
        return this.notes;
    }


    public void setNotes(String notes) {
        this.notes = notes;
    }


    public ActivityType getActivityType() {
        return this.activityType;
    }


    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }


    public OrganisationContact getPersonHere() {
        return this.personHere;
    }


    public void setPersonHere(OrganisationContact personHere) {
        this.personHere = personHere;
    }


    public Set<VolunteerActivityLog> getVolunteerActivityLogs() {
        return this.volunteerActivityLogs;
    }


    public void setVolunteerActivityLogs(Set<VolunteerActivityLog> volunteerActivityLogs) {
        this.volunteerActivityLogs = volunteerActivityLogs;
    }


    public Set<OrganisationActivityLog> getOrganisationActivityLogs() {
        return this.organisationActivityLogs;
    }


    public void setOrganisationActivityLogs(Set<OrganisationActivityLog> organisationActivityLogs) {
        this.organisationActivityLogs = organisationActivityLogs;
    }


    public Set<OpportunityActivityLog> getOpportunityActivityLogs() {
        return this.opportunityActivityLogs;
    }


    public void setOpportunityActivityLogs(Set<OpportunityActivityLog> opportunityActivityLogs) {
        this.opportunityActivityLogs = opportunityActivityLogs;
    }
}
