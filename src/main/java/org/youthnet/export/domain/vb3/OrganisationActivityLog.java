package org.youthnet.export.domain.vb3;


public class OrganisationActivityLog extends GenericDTO {


    private Organisation organisation;
    private OrganisationContact contact;
    private ActivityLog activityLog;


    public OrganisationActivityLog() {
    }


    public OrganisationActivityLog(Organisation organisation, OrganisationContact contact, ActivityLog activityLog) {
        this.organisation = organisation;
        this.contact = contact;
        this.activityLog = activityLog;
    }


    public Organisation getOrganisation() {
        return this.organisation;
    }


    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }


    public OrganisationContact getContact() {
        return this.contact;
    }


    public void setContact(OrganisationContact contact) {
        this.contact = contact;
    }


    public ActivityLog getActivityLog() {
        return this.activityLog;
    }


    public void setActivityLog(ActivityLog activityLog) {
        this.activityLog = activityLog;
    }
}
