package org.youthnet.export.domain.vb3;


public class OpportunityActivityLog extends GenericDTO {


    private Opportunity opportunity;
    private ActivityLog activityLog;
    private LocationBase opportunityLocation;


    public OpportunityActivityLog() {
    }


    public OpportunityActivityLog(Opportunity opportunity, ActivityLog activityLog, LocationBase opportunityLocation) {
        this.opportunity = opportunity;
        this.activityLog = activityLog;
        this.opportunityLocation = opportunityLocation;
    }


    public Opportunity getOpportunity() {
        return this.opportunity;
    }


    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }


    public ActivityLog getActivityLog() {
        return this.activityLog;
    }


    public void setActivityLog(ActivityLog activityLog) {
        this.activityLog = activityLog;
    }


    public LocationBase getOpportunityLocation() {
        return this.opportunityLocation;
    }


    public void setOpportunityLocation(LocationBase opportunityLocation) {
        this.opportunityLocation = opportunityLocation;
    }
}
