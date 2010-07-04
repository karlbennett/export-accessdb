package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.vb3.lookups.EmailType;


public class VolunteerContactEmail extends org.youthnet.vbase.domain.VolunteerContactInfo {


    private Volunteer contactDetails;
    private EmailType type;
    private String email;


    public VolunteerContactEmail() {
    }


    public VolunteerContactEmail(String email) {
        this.email = email;
    }


    public VolunteerContactEmail(boolean isActive, boolean isDefault, String notes, Volunteer contactDetails, EmailType type, String email) {
        this.contactDetails = contactDetails;
        this.type = type;
        this.email = email;
    }


    public Volunteer getContactDetails() {
        return this.contactDetails;
    }


    public void setContactDetails(Volunteer contactDetails) {
        this.contactDetails = contactDetails;
    }


    public EmailType getType() {
        return this.type;
    }


    public void setType(EmailType type) {
        this.type = type;
    }


    public String getEmail() {
        return this.email;
    }


    public void setEmail(String email) {
        this.email = email;
    }
}
