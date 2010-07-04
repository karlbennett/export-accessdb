package org.youthnet.export.domain.vb3;


import java.util.UUID;


public class VolunteerContactTelephones {

    private String tel_number;
    private UUID volunteercontactinfoid;
    private UUID telephonetypeid;
    private UUID volunteerid;

    public VolunteerContactTelephones() {
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

    public String getTel_number() {
        return this.tel_number;
    }

    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }

    public UUID getVolunteerId() {
        return this.volunteerid;
    }

    public void setVolunteerId(UUID volunteerid) {
        this.volunteerid = volunteerid;
    }
}
