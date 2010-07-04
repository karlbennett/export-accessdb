package org.youthnet.export.domain.vb3;


import java.util.UUID;


public class VolunteerContactEmails {

    private UUID volunteercontactinfoid;
    private UUID telephonetypeid;
    private String email;
    private UUID volunteerid;

    public VolunteerContactEmails() {
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getVolunteerContactInfoId() {
        return this.volunteercontactinfoid;
    }

    public void setVolunteerContactInfoId(UUID volunteercontactinfoid) {
        this.volunteercontactinfoid = volunteercontactinfoid;
    }

    public UUID getTelephoneTypeId() {
        return this.telephonetypeid;
    }

    public void setTelephoneTypeId(UUID telephonetypeid) {
        this.telephonetypeid = telephonetypeid;
    }

    public UUID getVolunteerId() {
        return this.volunteerid;
    }

    public void setVolunteerId(UUID volunteerid) {
        this.volunteerid = volunteerid;
    }
}
