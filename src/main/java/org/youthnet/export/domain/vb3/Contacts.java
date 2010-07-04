package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Contacts implements CSVable {

    private String delimiter = "|";
    private String enclosure = "¬";
    private Integer columnNum = 24;
    private List<String> columnNames = null;
    private StringBuffer record = new StringBuffer();

    private String surname;
    private String jobtitle;
    private String email;
    private UUID id;
    private Boolean deleted;
    private Boolean usingaddressemail;
    private String tel;
    private Long vbase2id;
    private String firstname;
    private Boolean usingaddresstel;
    private UUID titleid;
    private Boolean usingaddressfax;
    private Long version;
    private UUID modifiedby;
    private String mobile;
    private String preferredname;
    private Boolean isactive;
    private Timestamp created;
    private Boolean useasmaincontact;
    private UUID createdby;
    private String fax;
    private String department;
    private Timestamp modified;
    private String notes;

    public Contacts() {
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJobTitle() {
        return this.jobtitle;
    }

    public void setJobTitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Boolean getUsingAddressEmail() {
        return this.usingaddressemail;
    }

    public void setUsingAddressEmail(Boolean usingaddressemail) {
        this.usingaddressemail = usingaddressemail;
    }

    public String getFirstName() {
        return this.firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public Long getVbase2Id() {
        return this.vbase2id;
    }

    public void setVbase2Id(Long vbase2id) {
        this.vbase2id = vbase2id;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Boolean getUsingAddressTel() {
        return this.usingaddresstel;
    }

    public void setUsingAddressTel(Boolean usingaddresstel) {
        this.usingaddresstel = usingaddresstel;
    }

    public UUID getTitleId() {
        return this.titleid;
    }

    public void setTitleId(UUID titleid) {
        this.titleid = titleid;
    }

    public Boolean getUsingAddressFax() {
        return this.usingaddressfax;
    }

    public void setUsingAddressFax(Boolean usingaddressfax) {
        this.usingaddressfax = usingaddressfax;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public UUID getModifiedBy() {
        return this.modifiedby;
    }

    public void setModifiedBy(UUID modifiedby) {
        this.modifiedby = modifiedby;
    }

    public String getPreferredName() {
        return this.preferredname;
    }

    public void setPreferredName(String preferredname) {
        this.preferredname = preferredname;
    }

    public Boolean getIsActive() {
        return this.isactive;
    }

    public void setIsActive(Boolean isactive) {
        this.isactive = isactive;
    }

    public Boolean getUseAsMainContact() {
        return this.useasmaincontact;
    }

    public void setUseAsMainContact(Boolean useasmaincontact) {
        this.useasmaincontact = useasmaincontact;
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

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
            this.columnNames.add("Surname");
            this.columnNames.add("JobTitle");
            this.columnNames.add("Email");
            this.columnNames.add("Id");
            this.columnNames.add("Deleted");
            this.columnNames.add("UsingAddressEmail");
            this.columnNames.add("Tel");
            this.columnNames.add("Vbase2Id");
            this.columnNames.add("FirstName");
            this.columnNames.add("UsingAddressTel");
            this.columnNames.add("TitleId");
            this.columnNames.add("UsingAddressFax");
            this.columnNames.add("Version");
            this.columnNames.add("ModifiedBy");
            this.columnNames.add("Mobile");
            this.columnNames.add("PreferredName");
            this.columnNames.add("IsActive");
            this.columnNames.add("Created");
            this.columnNames.add("UseAsMainContact");
            this.columnNames.add("CreatedBy");
            this.columnNames.add("Fax");
            this.columnNames.add("Department");
            this.columnNames.add("Modified");
            this.columnNames.add("Notes");
        }

        return this.columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.surname);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.jobtitle);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.email);
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
        record.append(this.usingaddressemail);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.tel);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.vbase2id);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.firstname);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.usingaddresstel);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.titleid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.usingaddressfax);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.version);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.modifiedby.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.mobile);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.preferredname);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.isactive);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.created);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.useasmaincontact);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.createdby.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.fax);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.department);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.modified);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.notes);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
