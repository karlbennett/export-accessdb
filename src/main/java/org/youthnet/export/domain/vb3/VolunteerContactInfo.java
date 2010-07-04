package org.youthnet.export.domain.vb3;


public class VolunteerContactInfo extends GenericDTO {


    private boolean isActive;
    private boolean isDefault;
    private String notes;


    public VolunteerContactInfo() {
    }


    public VolunteerContactInfo(boolean isActive, boolean isDefault, String notes) {
        this.isActive = isActive;
        this.isDefault = isDefault;
        this.notes = notes;
    }


    public boolean isIsActive() {
        return this.isActive;
    }


    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }


    public boolean isIsDefault() {
        return this.isDefault;
    }


    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }


    public String getNotes() {
        return this.notes;
    }


    public void setNotes(String notes) {
        this.notes = notes;
    }
}
