package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.vb3.lookups.TelephoneType;


public class VolunteerContactTelephone extends VolunteerContactInfo {


    private Volunteer contactDetails;
    private TelephoneType type;
    private String number;


    public VolunteerContactTelephone() {
    }


    public VolunteerContactTelephone(String number) {
        this.number = number;
    }


    public VolunteerContactTelephone(boolean isActive, boolean isDefault, String notes, Volunteer contactDetails, TelephoneType type, String number) {
        this.contactDetails = contactDetails;
        this.type = type;
        this.number = number;
    }


    public Volunteer getContactDetails() {
        return this.contactDetails;
    }


    public void setContactDetails(Volunteer contactDetails) {
        this.contactDetails = contactDetails;
    }


    public TelephoneType getType() {
        return this.type;
    }


    public void setType(TelephoneType type) {
        this.type = type;
    }


    public String getNumber() {
        return this.number;
    }


    public void setNumber(String number) {
        this.number = number;
    }
}
