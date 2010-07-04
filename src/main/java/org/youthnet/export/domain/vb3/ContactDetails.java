package org.youthnet.export.domain.vb3;


import java.sql.Timestamp;
import java.util.UUID;


public class ContactDetails {

    private Long version;
    private UUID organisationaddressid;
    private String customemail;
    private Timestamp created;
    private String telephonesource;
    private String emailsource;
    private String customwebaddress;
    private String customorgname;
    private UUID addressid;
    private UUID contactid;
    private Timestamp modified;
    private UUID orgcontactid;
    private Boolean usevuodetails;
    private Boolean usecustomperson;
    private UUID modifiedby;
    private Boolean usecustomorgname;
    private String customtelephone;
    private Boolean usecustomaddress;
    private UUID id;
    private Boolean deleted;
    private UUID createdby;
    private String customfax;
    private String webaddresssource;
    private String faxsource;

    public ContactDetails() {
    }

    public Boolean getUseCustomOrgName() {
        return this.usecustomorgname;
    }

    public void setUseCustomOrgName(Boolean usecustomorgname) {
        this.usecustomorgname = usecustomorgname;
    }

    public String getCustomTelephone() {
        return this.customtelephone;
    }

    public void setCustomTelephone(String customtelephone) {
        this.customtelephone = customtelephone;
    }

    public UUID getOrganisationAddressId() {
        return this.organisationaddressid;
    }

    public void setOrganisationAddressId(UUID organisationaddressid) {
        this.organisationaddressid = organisationaddressid;
    }

    public String getCustomEmail() {
        return this.customemail;
    }

    public void setCustomEmail(String customemail) {
        this.customemail = customemail;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getCustomOrgName() {
        return this.customorgname;
    }

    public void setCustomOrgName(String customorgname) {
        this.customorgname = customorgname;
    }

    public UUID getAddressId() {
        return this.addressid;
    }

    public void setAddressId(UUID addressid) {
        this.addressid = addressid;
    }

    public UUID getContactId() {
        return this.contactid;
    }

    public void setContactId(UUID contactid) {
        this.contactid = contactid;
    }

    public Boolean getUseVuoDetails() {
        return this.usevuodetails;
    }

    public void setUseVuoDetails(Boolean usevuodetails) {
        this.usevuodetails = usevuodetails;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Boolean getUseCustomPerson() {
        return this.usecustomperson;
    }

    public void setUseCustomPerson(Boolean usecustomperson) {
        this.usecustomperson = usecustomperson;
    }

    public UUID getModifiedBy() {
        return this.modifiedby;
    }

    public void setModifiedBy(UUID modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Boolean getUseCustomAddress() {
        return this.usecustomaddress;
    }

    public void setUseCustomAddress(Boolean usecustomaddress) {
        this.usecustomaddress = usecustomaddress;
    }

    public Timestamp getCreated() {
        return this.created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public UUID getCreatedBy() {
        return this.createdby;
    }

    public void setCreatedBy(UUID createdby) {
        this.createdby = createdby;
    }

    public String getTelephoneSource() {
        return this.telephonesource;
    }

    public void setTelephoneSource(String telephonesource) {
        this.telephonesource = telephonesource;
    }

    public String getCustomFax() {
        return this.customfax;
    }

    public void setCustomFax(String customfax) {
        this.customfax = customfax;
    }

    public String getEmailSource() {
        return this.emailsource;
    }

    public void setEmailSource(String emailsource) {
        this.emailsource = emailsource;
    }

    public String getWebAddressSource() {
        return this.webaddresssource;
    }

    public void setWebAddressSource(String webaddresssource) {
        this.webaddresssource = webaddresssource;
    }

    public String getCustomWebAddress() {
        return this.customwebaddress;
    }

    public void setCustomWebAddress(String customwebaddress) {
        this.customwebaddress = customwebaddress;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public UUID getOrgContactId() {
        return this.orgcontactid;
    }

    public void setOrgContactId(UUID orgcontactid) {
        this.orgcontactid = orgcontactid;
    }

    public String getFaxSource() {
        return this.faxsource;
    }

    public void setFaxSource(String faxsource) {
        this.faxsource = faxsource;
    }
}
