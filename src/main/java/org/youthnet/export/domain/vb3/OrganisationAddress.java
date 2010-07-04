package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.vb3.lookups.Country;
import org.youthnet.export.domain.vb3.lookups.County;

import java.util.HashSet;
import java.util.Set;


public class OrganisationAddress extends Address {


    private Set<OrganisationContact> Contacts = new HashSet<OrganisationContact>(0);
    private Organisation OrganisationAddressInfo;
    private String friendlyName;
    private String organisationName;
    private boolean useCustomOrganisationName;
    private String email;
    private String tel;
    private String emergencyTelephone;
    private String fax;
    private String website;
    private String directions;
    private boolean isDefaultAddress;


    public OrganisationAddress() {
    }


    public OrganisationAddress(Integer vbase2Id, String address1, String address2, String address3, String town, County county, Country country, String PostCode, String Directions, Set<OrganisationContact> Contacts, Organisation OrganisationAddressInfo, String friendlyName, String organisationName, boolean useCustomOrganisationName, String email, String tel, String emergencyTelephone, String fax, String website, String directions, boolean isDefaultAddress) {
        this.Contacts = Contacts;
        this.OrganisationAddressInfo = OrganisationAddressInfo;
        this.friendlyName = friendlyName;
        this.organisationName = organisationName;
        this.useCustomOrganisationName = useCustomOrganisationName;
        this.email = email;
        this.tel = tel;
        this.emergencyTelephone = emergencyTelephone;
        this.fax = fax;
        this.website = website;
        this.isDefaultAddress = isDefaultAddress;
    }


    public Set<OrganisationContact> getContacts() {
        return this.Contacts;
    }


    public void setContacts(Set<OrganisationContact> Contacts) {
        this.Contacts = Contacts;
    }


    public Organisation getOrganisationAddressInfo() {
        return this.OrganisationAddressInfo;
    }


    public void setOrganisationAddressInfo(Organisation OrganisationAddressInfo) {
        this.OrganisationAddressInfo = OrganisationAddressInfo;
    }


    public String getFriendlyName() {
        return this.friendlyName;
    }


    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }


    public String getOrganisationName() {
        return this.organisationName;
    }


    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }


    public boolean isUseCustomOrganisationName() {
        return this.useCustomOrganisationName;
    }


    public void setUseCustomOrganisationName(boolean useCustomOrganisationName) {
        this.useCustomOrganisationName = useCustomOrganisationName;
    }


    public String getEmail() {
        return this.email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getTel() {
        return this.tel;
    }


    public void setTel(String tel) {
        this.tel = tel;
    }


    public String getEmergencyTelephone() {
        return this.emergencyTelephone;
    }


    public void setEmergencyTelephone(String emergencyTelephone) {
        this.emergencyTelephone = emergencyTelephone;
    }


    public String getFax() {
        return this.fax;
    }


    public void setFax(String fax) {
        this.fax = fax;
    }


    public String getWebsite() {
        return this.website;
    }


    public void setWebsite(String website) {
        this.website = website;
    }


    public String getDirections() {
        return this.directions;
    }


    public void setDirections(String directions) {
        this.directions = directions;
    }


    public boolean isIsDefaultAddress() {
        return this.isDefaultAddress;
    }


    public void setIsDefaultAddress(boolean isDefaultAddress) {
        this.isDefaultAddress = isDefaultAddress;
    }
}
