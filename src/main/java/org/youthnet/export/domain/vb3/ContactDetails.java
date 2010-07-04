package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ContactDetails implements CSVable {

    private String delimiter = "|";
    private String enclosure = "¬";
    private Integer columnNum = 24;
    private List<String> columnNames = null;
    private StringBuffer record = new StringBuffer();

    private Boolean usecustomorgname;
    private String customtelephone;
    private UUID organisationaddressid;
    private String customemail;
    private UUID id;
    private Boolean deleted;
    private String customorgname;
    private UUID addressid;
    private UUID contactid;
    private Boolean usevuodetails;
    private Long version;
    private Boolean usecustomperson;
    private UUID modifiedby;
    private Boolean usecustomaddress;
    private Timestamp created;
    private UUID createdby;
    private String telephonesource;
    private String customfax;
    private String emailsource;
    private String webaddresssource;
    private String customwebaddress;
    private Timestamp modified;
    private UUID orgcontactid;
    private String faxsource;

    public ContactDetails() {
    }

    public String getCustomTelephone() {
        return this.customtelephone;
    }

    public void setCustomTelephone(String customtelephone) {
        this.customtelephone = customtelephone;
    }

    public Boolean getUseCustomOrgName() {
        return this.usecustomorgname;
    }

    public void setUseCustomOrgName(Boolean usecustomorgname) {
        this.usecustomorgname = usecustomorgname;
    }

    public UUID getOrganisationAddressId() {
        return this.organisationaddressid;
    }

    public void setOrganisationAddressId(UUID organisationaddressid) {
        this.organisationaddressid = organisationaddressid;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCustomEmail() {
        return this.customemail;
    }

    public void setCustomEmail(String customemail) {
        this.customemail = customemail;
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

    public Boolean getUseCustomPerson() {
        return this.usecustomperson;
    }

    public void setUseCustomPerson(Boolean usecustomperson) {
        this.usecustomperson = usecustomperson;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
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

    public String getCustomWebAddress() {
        return this.customwebaddress;
    }

    public void setCustomWebAddress(String customwebaddress) {
        this.customwebaddress = customwebaddress;
    }

    public String getWebAddressSource() {
        return this.webaddresssource;
    }

    public void setWebAddressSource(String webaddresssource) {
        this.webaddresssource = webaddresssource;
    }

    public String getEmailSource() {
        return this.emailsource;
    }

    public void setEmailSource(String emailsource) {
        this.emailsource = emailsource;
    }

    public UUID getOrgContactId() {
        return this.orgcontactid;
    }

    public void setOrgContactId(UUID orgcontactid) {
        this.orgcontactid = orgcontactid;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public String getFaxSource() {
        return this.faxsource;
    }

    public void setFaxSource(String faxsource) {
        this.faxsource = faxsource;
    }


    public String getDelimiter() {
        return this.delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getEnclosure() {
        return this.enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public Integer getClumnNumber() {
        return this.columnNum;
    }

    public List<String> getClumnNames() {
        if (this.columnNames == null) {
            this.columnNames = new ArrayList<String>();
            this.columnNames.add("UseCustomOrgName");
            this.columnNames.add("CustomTelephone");
            this.columnNames.add("OrganisationAddressId");
            this.columnNames.add("CustomEmail");
            this.columnNames.add("Id");
            this.columnNames.add("Deleted");
            this.columnNames.add("CustomOrgName");
            this.columnNames.add("AddressId");
            this.columnNames.add("ContactId");
            this.columnNames.add("UseVuoDetails");
            this.columnNames.add("Version");
            this.columnNames.add("UseCustomPerson");
            this.columnNames.add("ModifiedBy");
            this.columnNames.add("UseCustomAddress");
            this.columnNames.add("Created");
            this.columnNames.add("CreatedBy");
            this.columnNames.add("TelephoneSource");
            this.columnNames.add("CustomFax");
            this.columnNames.add("EmailSource");
            this.columnNames.add("WebAddressSource");
            this.columnNames.add("CustomWebAddress");
            this.columnNames.add("Modified");
            this.columnNames.add("OrgContactId");
            this.columnNames.add("FaxSource");
        }

        return this.columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.usecustomorgname);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.customtelephone);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.organisationaddressid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.customemail);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.id.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.deleted);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.customorgname);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.addressid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.contactid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.usevuodetails);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.version);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.usecustomperson);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.modifiedby.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.usecustomaddress);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.created);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.createdby.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.telephonesource);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.customfax);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.emailsource);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.webaddresssource);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.customwebaddress);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.modified);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.orgcontactid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.faxsource);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
