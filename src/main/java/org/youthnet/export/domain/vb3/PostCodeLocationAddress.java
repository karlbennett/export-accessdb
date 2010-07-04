package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.vb3.lookups.GeographicalArea;

import java.util.Set;


public class PostCodeLocationAddress extends LocationBase {


    private boolean UseCustomAddress;
    private Address CustomAddress;
    private OrganisationAddress orgAddress;
    private boolean UseForContactDetails;


    public PostCodeLocationAddress() {
    }


    public PostCodeLocationAddress(String DisplayString, Opportunity owner, LocationTypes locationType, ContactDetails contactDetails, ContactDetails publicContactDetails, boolean UseCustomOrgName, String CustomOrgName, PublicContactDetailsSource publicContactDetailsSource, Set<GeographicalArea> geographicalAreas, boolean IsActive, boolean UseCustomAddress, Address CustomAddress, OrganisationAddress orgAddress, boolean UseForContactDetails) {
        this.UseCustomAddress = UseCustomAddress;
        this.CustomAddress = CustomAddress;
        this.orgAddress = orgAddress;
        this.UseForContactDetails = UseForContactDetails;
    }


    public boolean isUseCustomAddress() {
        return this.UseCustomAddress;
    }


    public void setUseCustomAddress(boolean UseCustomAddress) {
        this.UseCustomAddress = UseCustomAddress;
    }


    public Address getCustomAddress() {
        return this.CustomAddress;
    }


    public void setCustomAddress(Address CustomAddress) {
        this.CustomAddress = CustomAddress;
    }


    public OrganisationAddress getOrgAddress() {
        return this.orgAddress;
    }


    public void setOrgAddress(OrganisationAddress orgAddress) {
        this.orgAddress = orgAddress;
    }


    public boolean isUseForContactDetails() {
        return this.UseForContactDetails;
    }


    public void setUseForContactDetails(boolean UseForContactDetails) {
        this.UseForContactDetails = UseForContactDetails;
    }
}
