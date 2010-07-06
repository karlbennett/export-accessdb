package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ContactDetails implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 24;
    private List<String> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

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

    public ContactDetails(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split(String.valueOf(this.delimiter));
        StringBuffer uuidStringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");


        this.customtelephone = fields[0].replace(String.valueOf(this.enclosure), "");

        this.usecustomorgname = fields[1].replace(String.valueOf(this.enclosure), "").equals("1");

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[2].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.organisationaddressid = UUID.fromString(uuidStringBuffer.toString());

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[3].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.id = UUID.fromString(uuidStringBuffer.toString());

        this.customemail = fields[4].replace(String.valueOf(this.enclosure), "");

        this.deleted = fields[5].replace(String.valueOf(this.enclosure), "").equals("1");

        this.customorgname = fields[6].replace(String.valueOf(this.enclosure), "");

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[7].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.addressid = UUID.fromString(uuidStringBuffer.toString());

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[8].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.contactid = UUID.fromString(uuidStringBuffer.toString());

        this.usevuodetails = fields[9].replace(String.valueOf(this.enclosure), "").equals("1");

        this.usecustomperson = fields[10].replace(String.valueOf(this.enclosure), "").equals("1");

        this.version = Long.valueOf(fields[11].replace(String.valueOf(this.enclosure), ""));

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[12].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.modifiedby = UUID.fromString(uuidStringBuffer.toString());

        this.usecustomaddress = fields[13].replace(String.valueOf(this.enclosure), "").equals("1");

        try {
            this.created = new Timestamp(simpleDateFormat.parse(fields[14].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp created " + fields[14].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[15].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.createdby = UUID.fromString(uuidStringBuffer.toString());

        this.telephonesource = fields[16].replace(String.valueOf(this.enclosure), "");

        this.customfax = fields[17].replace(String.valueOf(this.enclosure), "");

        this.customwebaddress = fields[18].replace(String.valueOf(this.enclosure), "");

        this.webaddresssource = fields[19].replace(String.valueOf(this.enclosure), "");

        this.emailsource = fields[20].replace(String.valueOf(this.enclosure), "");

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[21].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.orgcontactid = UUID.fromString(uuidStringBuffer.toString());

        try {
            this.modified = new Timestamp(simpleDateFormat.parse(fields[22].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp modified " + fields[22].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        this.faxsource = fields[23].replace(String.valueOf(this.enclosure), "");

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


    public char getDelimiter() {
        return this.delimiter;
    }

    public void setDelimiter(char delimiter) {
        this.delimiter = delimiter;
    }

    public char getEnclosure() {
        return this.enclosure;
    }

    public void setEnclosure(char enclosure) {
        this.enclosure = enclosure;
    }

    public Integer getColumnNumber() {
        return this.columnNum;
    }

    public List<String> getColumnNames() {
        if (this.columnNames == null) {
            this.columnNames = new ArrayList<String>();
            this.columnNames.add("CustomTelephone");
            this.columnNames.add("UseCustomOrgName");
            this.columnNames.add("OrganisationAddressId");
            this.columnNames.add("Id");
            this.columnNames.add("CustomEmail");
            this.columnNames.add("Deleted");
            this.columnNames.add("CustomOrgName");
            this.columnNames.add("AddressId");
            this.columnNames.add("ContactId");
            this.columnNames.add("UseVuoDetails");
            this.columnNames.add("UseCustomPerson");
            this.columnNames.add("Version");
            this.columnNames.add("ModifiedBy");
            this.columnNames.add("UseCustomAddress");
            this.columnNames.add("Created");
            this.columnNames.add("CreatedBy");
            this.columnNames.add("TelephoneSource");
            this.columnNames.add("CustomFax");
            this.columnNames.add("CustomWebAddress");
            this.columnNames.add("WebAddressSource");
            this.columnNames.add("EmailSource");
            this.columnNames.add("OrgContactId");
            this.columnNames.add("Modified");
            this.columnNames.add("FaxSource");
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.customtelephone);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(usecustomorgname ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.organisationaddressid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.id.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.customemail);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(deleted ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.customorgname);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.addressid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.contactid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(usevuodetails ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(usecustomperson ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.version);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.modifiedby.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(usecustomaddress ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.created);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.createdby.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.telephonesource);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.customfax);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.customwebaddress);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.webaddresssource);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.emailsource);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.orgcontactid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.modified);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.faxsource);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
