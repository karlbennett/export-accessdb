package org.youthnet.export.domain.vb3;


public class ContactDetails extends GenericDTO {


    private boolean UseCustomAddress;
    private boolean UseCustomPerson;
    private Address orgAddress;
    private Address customAddress;
    private Contact customContact;
    private Contact orgContact;
    private String CustomTelephone;
    private String CustomFax;
    private String CustomWebAddress;
    private String CustomEmail;
    private boolean UseVuoDetails;
    private boolean UseCustomOrgName;
    private String CustomOrgName;
    private ContactDetailsSource telephoneSource;
    private ContactDetailsSource faxSource;
    private ContactDetailsSource emailSource;
    private ContactDetailsSource webAddressSource;


    public ContactDetails() {
    }


    public ContactDetails(boolean UseCustomAddress, boolean UseCustomPerson, Address orgAddress, Address customAddress, Contact customContact, Contact orgContact, String CustomTelephone, String CustomFax, String CustomWebAddress, String CustomEmail, boolean UseVuoDetails, boolean UseCustomOrgName, String CustomOrgName, ContactDetailsSource telephoneSource, ContactDetailsSource faxSource, ContactDetailsSource emailSource, ContactDetailsSource webAddressSource) {
        this.UseCustomAddress = UseCustomAddress;
        this.UseCustomPerson = UseCustomPerson;
        this.orgAddress = orgAddress;
        this.customAddress = customAddress;
        this.customContact = customContact;
        this.orgContact = orgContact;
        this.CustomTelephone = CustomTelephone;
        this.CustomFax = CustomFax;
        this.CustomWebAddress = CustomWebAddress;
        this.CustomEmail = CustomEmail;
        this.UseVuoDetails = UseVuoDetails;
        this.UseCustomOrgName = UseCustomOrgName;
        this.CustomOrgName = CustomOrgName;
        this.telephoneSource = telephoneSource;
        this.faxSource = faxSource;
        this.emailSource = emailSource;
        this.webAddressSource = webAddressSource;
    }


    public boolean isUseCustomAddress() {
        return this.UseCustomAddress;
    }


    public void setUseCustomAddress(boolean UseCustomAddress) {
        this.UseCustomAddress = UseCustomAddress;
    }


    public boolean isUseCustomPerson() {
        return this.UseCustomPerson;
    }


    public void setUseCustomPerson(boolean UseCustomPerson) {
        this.UseCustomPerson = UseCustomPerson;
    }


    public Address getOrgAddress() {
        return this.orgAddress;
    }


    public void setOrgAddress(Address orgAddress) {
        this.orgAddress = orgAddress;
    }


    public Address getCustomAddress() {
        return this.customAddress;
    }


    public void setCustomAddress(Address customAddress) {
        this.customAddress = customAddress;
    }


    public Contact getCustomContact() {
        return this.customContact;
    }


    public void setCustomContact(Contact customContact) {
        this.customContact = customContact;
    }


    public Contact getOrgContact() {
        return this.orgContact;
    }


    public void setOrgContact(Contact orgContact) {
        this.orgContact = orgContact;
    }


    public String getCustomTelephone() {
        return this.CustomTelephone;
    }


    public void setCustomTelephone(String CustomTelephone) {
        this.CustomTelephone = CustomTelephone;
    }


    public String getCustomFax() {
        return this.CustomFax;
    }


    public void setCustomFax(String CustomFax) {
        this.CustomFax = CustomFax;
    }


    public String getCustomWebAddress() {
        return this.CustomWebAddress;
    }


    public void setCustomWebAddress(String CustomWebAddress) {
        this.CustomWebAddress = CustomWebAddress;
    }


    public String getCustomEmail() {
        return this.CustomEmail;
    }


    public void setCustomEmail(String CustomEmail) {
        this.CustomEmail = CustomEmail;
    }


    public boolean isUseVuoDetails() {
        return this.UseVuoDetails;
    }


    public void setUseVuoDetails(boolean UseVuoDetails) {
        this.UseVuoDetails = UseVuoDetails;
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


    public ContactDetailsSource getTelephoneSource() {
        return this.telephoneSource;
    }


    public void setTelephoneSource(ContactDetailsSource telephoneSource) {
        this.telephoneSource = telephoneSource;
    }


    public ContactDetailsSource getFaxSource() {
        return this.faxSource;
    }


    public void setFaxSource(ContactDetailsSource faxSource) {
        this.faxSource = faxSource;
    }


    public ContactDetailsSource getEmailSource() {
        return this.emailSource;
    }


    public void setEmailSource(ContactDetailsSource emailSource) {
        this.emailSource = emailSource;
    }


    public ContactDetailsSource getWebAddressSource() {
        return this.webAddressSource;
    }


    public void setWebAddressSource(ContactDetailsSource webAddressSource) {
        this.webAddressSource = webAddressSource;
    }
}
