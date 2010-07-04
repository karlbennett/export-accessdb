package org.youthnet.export.domain.vb3;


import java.util.UUID;


public class OrganisationAddresses {

    private String emergencytelephone;
    private String friendlyname;
    private String fax;
    private UUID addressid;
    private String website;
    private UUID orgaddconinfoid;
    private Boolean usecustomorganisationname;
    private Boolean isdefaultaddress;
    private String email;
    private String directions;
    private String telephone;
    private String organisationname;

    public OrganisationAddresses() {
    }

    public UUID getOrgAddConInfoId() {
        return this.orgaddconinfoid;
    }

    public void setOrgAddConInfoId(UUID orgaddconinfoid) {
        this.orgaddconinfoid = orgaddconinfoid;
    }

    public Boolean getUseCustomOrganisationName() {
        return this.usecustomorganisationname;
    }

    public void setUseCustomOrganisationName(Boolean usecustomorganisationname) {
        this.usecustomorganisationname = usecustomorganisationname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDirections() {
        return this.directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFriendlyName() {
        return this.friendlyname;
    }

    public void setFriendlyName(String friendlyname) {
        this.friendlyname = friendlyname;
    }

    public UUID getAddressId() {
        return this.addressid;
    }

    public void setAddressId(UUID addressid) {
        this.addressid = addressid;
    }

    public String getEmergencyTelephone() {
        return this.emergencytelephone;
    }

    public void setEmergencyTelephone(String emergencytelephone) {
        this.emergencytelephone = emergencytelephone;
    }

    public Boolean getIsDefaultAddress() {
        return this.isdefaultaddress;
    }

    public void setIsDefaultAddress(Boolean isdefaultaddress) {
        this.isdefaultaddress = isdefaultaddress;
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

    public String getOrganisationName() {
        return this.organisationname;
    }

    public void setOrganisationName(String organisationname) {
        this.organisationname = organisationname;
    }
}
