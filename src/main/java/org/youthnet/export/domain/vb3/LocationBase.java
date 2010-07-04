package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.vb3.lookups.GeographicalArea;

import java.util.HashSet;
import java.util.Set;


public class LocationBase extends GenericDTO {


    private String DisplayString;
    private Opportunity owner;
    private LocationTypes locationType;
    private ContactDetails contactDetails;
    private ContactDetails publicContactDetails;
    private boolean UseCustomOrgName;
    private String CustomOrgName;
    private PublicContactDetailsSource publicContactDetailsSource;
    private Set<GeographicalArea> geographicalAreas = new HashSet<GeographicalArea>(0);
    private boolean IsActive;


    public LocationBase() {
    }


    public LocationBase(String DisplayString, Opportunity owner, LocationTypes locationType, ContactDetails contactDetails, ContactDetails publicContactDetails, boolean UseCustomOrgName, String CustomOrgName, PublicContactDetailsSource publicContactDetailsSource, Set<GeographicalArea> geographicalAreas, boolean IsActive) {
        this.DisplayString = DisplayString;
        this.owner = owner;
        this.locationType = locationType;
        this.contactDetails = contactDetails;
        this.publicContactDetails = publicContactDetails;
        this.UseCustomOrgName = UseCustomOrgName;
        this.CustomOrgName = CustomOrgName;
        this.publicContactDetailsSource = publicContactDetailsSource;
        this.geographicalAreas = geographicalAreas;
        this.IsActive = IsActive;
    }


    public String getDisplayString() {
        return this.DisplayString;
    }


    public void setDisplayString(String DisplayString) {
        this.DisplayString = DisplayString;
    }


    public Opportunity getOwner() {
        return this.owner;
    }


    public void setOwner(Opportunity owner) {
        this.owner = owner;
    }


    public LocationTypes getLocationType() {
        return this.locationType;
    }


    public void setLocationType(LocationTypes locationType) {
        this.locationType = locationType;
    }


    public ContactDetails getContactDetails() {
        return this.contactDetails;
    }


    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }


    public ContactDetails getPublicContactDetails() {
        return this.publicContactDetails;
    }


    public void setPublicContactDetails(ContactDetails publicContactDetails) {
        this.publicContactDetails = publicContactDetails;
    }


    public boolean isUseCustomOrgName() {
        return this.UseCustomOrgName;
    }


    public void setUseCustomOrgName(boolean UseCustomOrgName) {
        this.UseCustomOrgName = UseCustomOrgName;
    }


    public String getCustomOrgName() {
        return this.CustomOrgName;
    }


    public void setCustomOrgName(String CustomOrgName) {
        this.CustomOrgName = CustomOrgName;
    }


    public PublicContactDetailsSource getPublicContactDetailsSource() {
        return this.publicContactDetailsSource;
    }


    public void setPublicContactDetailsSource(PublicContactDetailsSource publicContactDetailsSource) {
        this.publicContactDetailsSource = publicContactDetailsSource;
    }


    public Set<GeographicalArea> getGeographicalAreas() {
        return this.geographicalAreas;
    }


    public void setGeographicalAreas(Set<GeographicalArea> geographicalAreas) {
        this.geographicalAreas = geographicalAreas;
    }


    public boolean isIsActive() {
        return this.IsActive;
    }


    public void setIsActive(boolean IsActive) {
        this.IsActive = IsActive;
    }
}
