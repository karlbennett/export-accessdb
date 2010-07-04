package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.vb3.lookups.Title;


public class OrganisationContact extends org.youthnet.vbase.domain.Contact {


    private Organisation organisation;
    private OrganisationAddress organisationAddress;


    public OrganisationContact() {
    }


    public OrganisationContact(Integer vbase2Id, Title title, String firstName, String surname, String preferredName, String jobTitle, String department, String email, boolean usingAddressEmail, String tel, String fax, boolean usingAddressFax, boolean usingAddressTel, String mobile, String notes, boolean isActive, boolean useAsMainContact, OrganisationAddress organisationAddress) {
        this.organisationAddress = organisationAddress;
    }


    public Organisation getOrganisation() {
    }


    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }


    public OrganisationAddress getOrganisationAddress() {
        return this.organisationAddress;
    }


    public void setOrganisationAddress(OrganisationAddress organisationAddress) {
        this.organisationAddress = organisationAddress;
    }
}
