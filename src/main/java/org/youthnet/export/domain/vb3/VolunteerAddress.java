package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.vb3.lookups.Country;
import org.youthnet.export.domain.vb3.lookups.County;


public class VolunteerAddress extends org.youthnet.vbase.domain.Address {


    private Volunteer contactDetails;
    private String name;
    private boolean isDefaultAddress;
    private boolean isActive;


    public VolunteerAddress() {
    }


    public VolunteerAddress(String name) {
        this.name = name;
    }


    public VolunteerAddress(Integer vbase2Id, String address1, String address2, String address3, String town, County county, Country country, String PostCode, String Directions, Volunteer contactDetails, String name, boolean isDefaultAddress) {
        this.contactDetails = contactDetails;
        this.name = name;
        this.isDefaultAddress = isDefaultAddress;
    }


    public Volunteer getContactDetails() {
        return this.contactDetails;
    }


    public void setContactDetails(Volunteer contactDetails) {
        this.contactDetails = contactDetails;
    }


    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public boolean isIsDefaultAddress() {
        return this.isDefaultAddress;
    }


    public void setIsDefaultAddress(boolean isDefaultAddress) {
        this.isDefaultAddress = isDefaultAddress;
    }


    public boolean isIsActive() {
        return this.isActive;
    }


    public void setIsActive(boolean active) {
        this.isActive = active;
    }
}
