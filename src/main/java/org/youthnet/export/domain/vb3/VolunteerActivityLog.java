package org.youthnet.export.domain.vb3;


public class VolunteerActivityLog extends GenericDTO {


    private Volunteer volunteer;
    private ActivityLog activityLog;


    public VolunteerActivityLog() {
    }


    public VolunteerActivityLog(Volunteer volunteer, ActivityLog activityLog) {
        this.volunteer = volunteer;
        this.activityLog = activityLog;
    }


    public Volunteer getVolunteer() {
        return this.volunteer;
    }


    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }


    public ActivityLog getActivityLog() {
        return this.activityLog;
    }


    public void setActivityLog(ActivityLog activityLog) {
        this.activityLog = activityLog;
    }
}
