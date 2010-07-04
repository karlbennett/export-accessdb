package org.youthnet.export.domain.vb3;


import java.sql.Timestamp;
import java.util.UUID;


public class Contacts {

    private Long version;
    private String mobile;
    private String jobtitle;
    private Timestamp created;
    private Boolean usingaddressemail;
    private String fax;
    private Long vbase2id;
    private String firstname;
    private String department;
    private Boolean usingaddresstel;
    private Timestamp modified;
    private String notes;
    private UUID titleid;
    private Boolean usingaddressfax;
    private UUID modifiedby;
    private String surname;
    private String email;
    private String preferredname;
    private Boolean isactive;
    private UUID id;
    private Boolean useasmaincontact;
    private Boolean deleted;
    private UUID createdby;
    private String tel;

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

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Long getVbase2Id() {
        return this.vbase2id;
    }

    public void setVbase2Id(Long vbase2id) {
        this.vbase2id = vbase2id;
    }

    public String getFirstName() {
        return this.firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
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

    public UUID getModifiedBy() {
        return this.modifiedby;
    }

    public void setModifiedBy(UUID modifiedby) {
        this.modifiedby = modifiedby;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public Timestamp getCreated() {
        return this.created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Boolean getUseAsMainContact() {
        return this.useasmaincontact;
    }

    public void setUseAsMainContact(Boolean useasmaincontact) {
        this.useasmaincontact = useasmaincontact;
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
}
