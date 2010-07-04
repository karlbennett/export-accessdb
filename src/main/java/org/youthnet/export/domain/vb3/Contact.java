package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.vb3.lookups.Title;


public class Contact extends GenericDTO {


    private Integer vbase2Id;
    private Title title;
    private String firstName;
    private String surname;
    private String preferredName;
    private String jobTitle;
    private String department;
    private String email;
    private boolean usingAddressEmail;
    private String tel;
    private String fax;
    private boolean usingAddressFax;
    private boolean usingAddressTel;
    private String mobile;
    private String notes;
    private boolean isActive;
    private boolean useAsMainContact;


    public Contact() {
    }


    public Contact(Integer vbase2Id, Title title, String firstName, String surname, String preferredName, String jobTitle, String department, String email, boolean usingAddressEmail, String tel, String fax, boolean usingAddressFax, boolean usingAddressTel, String mobile, String notes, boolean isActive, boolean useAsMainContact) {
        this.vbase2Id = vbase2Id;
        this.title = title;
        this.firstName = firstName;
        this.surname = surname;
        this.preferredName = preferredName;
        this.jobTitle = jobTitle;
        this.department = department;
        this.email = email;
        this.usingAddressEmail = usingAddressEmail;
        this.tel = tel;
        this.fax = fax;
        this.usingAddressFax = usingAddressFax;
        this.usingAddressTel = usingAddressTel;
        this.mobile = mobile;
        this.notes = notes;
        this.isActive = isActive;
        this.useAsMainContact = useAsMainContact;
    }


    public Integer getVbase2Id() {
        return this.vbase2Id;
    }


    public void setVbase2Id(Integer vbase2Id) {
        this.vbase2Id = vbase2Id;
    }


    public Title getTitle() {
        return this.title;
    }


    public void setTitle(Title title) {
        this.title = title;
    }


    public String getFirstName() {
        return this.firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getSurname() {
        return this.surname;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getPreferredName() {
        return this.preferredName;
    }


    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }


    public String getJobTitle() {
        return this.jobTitle;
    }


    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }


    public String getDepartment() {
        return this.department;
    }


    public void setDepartment(String department) {
        this.department = department;
    }


    public String getEmail() {
        return this.email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public boolean isUsingAddressEmail() {
        return this.usingAddressEmail;
    }


    public void setUsingAddressEmail(boolean usingAddressEmail) {
        this.usingAddressEmail = usingAddressEmail;
    }


    public String getTel() {
        return this.tel;
    }


    public void setTel(String tel) {
        this.tel = tel;
    }


    public String getFax() {
        return this.fax;
    }


    public void setFax(String fax) {
        this.fax = fax;
    }


    public boolean isUsingAddressFax() {
        return this.usingAddressFax;
    }


    public void setUsingAddressFax(boolean usingAddressFax) {
        this.usingAddressFax = usingAddressFax;
    }


    public boolean isUsingAddressTel() {
        return this.usingAddressTel;
    }


    public void setUsingAddressTel(boolean usingAddressTel) {
        this.usingAddressTel = usingAddressTel;
    }


    public String getMobile() {
        return this.mobile;
    }


    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public String getNotes() {
        return this.notes;
    }


    public void setNotes(String notes) {
        this.notes = notes;
    }


    public boolean isIsActive() {
        return this.isActive;
    }


    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }


    public boolean isUseAsMainContact() {
        return this.useAsMainContact;
    }


    public void setUseAsMainContact(boolean useAsMainContact) {
        this.useAsMainContact = useAsMainContact;
    }
}
