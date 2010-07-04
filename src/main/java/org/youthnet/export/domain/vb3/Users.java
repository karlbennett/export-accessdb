package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Users implements CSVable {

    private String delimiter = "|";
    private String enclosure = "¬";
    private Integer columnNum = 23;
    private List<String> columnNames = null;
    private StringBuffer record = new StringBuffer();

    private Timestamp lastloginattempt;
    private String lastname;
    private String fullname;
    private Boolean isenabled;
    private UUID id;
    private Boolean deleted;
    private Timestamp lstloggedin;
    private Timestamp accountlastvalidated;
    private Long vbase2id;
    private String firstname;
    private Boolean iscredentialsexpired;
    private Long version;
    private String passwordhint;
    private UUID modifiedby;
    private String phonenumber;
    private Timestamp created;
    private UUID createdby;
    private Long badloginattempts;
    private Boolean isaccountlocked;
    private Timestamp modified;
    private String password;
    private Boolean isaccountexpired;
    private String username;

    public Users() {
    }

    public Timestamp getLastLogInAttempt() {
        return this.lastloginattempt;
    }

    public void setLastLogInAttempt(Timestamp lastloginattempt) {
        this.lastloginattempt = lastloginattempt;
    }

    public String getLastName() {
        return this.lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getFullName() {
        return this.fullname;
    }

    public void setFullName(String fullname) {
        this.fullname = fullname;
    }

    public Boolean getIsEnabled() {
        return this.isenabled;
    }

    public void setIsEnabled(Boolean isenabled) {
        this.isenabled = isenabled;
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

    public Timestamp getLstLoggedIn() {
        return this.lstloggedin;
    }

    public void setLstLoggedIn(Timestamp lstloggedin) {
        this.lstloggedin = lstloggedin;
    }

    public Timestamp getAccountLastValidated() {
        return this.accountlastvalidated;
    }

    public void setAccountLastValidated(Timestamp accountlastvalidated) {
        this.accountlastvalidated = accountlastvalidated;
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

    public Boolean getIsCredentialsExpired() {
        return this.iscredentialsexpired;
    }

    public void setIsCredentialsExpired(Boolean iscredentialsexpired) {
        this.iscredentialsexpired = iscredentialsexpired;
    }

    public String getPasswordHint() {
        return this.passwordhint;
    }

    public void setPasswordHint(String passwordhint) {
        this.passwordhint = passwordhint;
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

    public String getPhoneNumber() {
        return this.phonenumber;
    }

    public void setPhoneNumber(String phonenumber) {
        this.phonenumber = phonenumber;
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

    public Long getBadLogInAttempts() {
        return this.badloginattempts;
    }

    public void setBadLogInAttempts(Long badloginattempts) {
        this.badloginattempts = badloginattempts;
    }

    public Boolean getIsAccountLocked() {
        return this.isaccountlocked;
    }

    public void setIsAccountLocked(Boolean isaccountlocked) {
        this.isaccountlocked = isaccountlocked;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public Boolean getIsAccountExpired() {
        return this.isaccountexpired;
    }

    public void setIsAccountExpired(Boolean isaccountexpired) {
        this.isaccountexpired = isaccountexpired;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return this.username;
    }

    public void setUserName(String username) {
        this.username = username;
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
            this.columnNames.add("LastLogInAttempt");
            this.columnNames.add("LastName");
            this.columnNames.add("FullName");
            this.columnNames.add("IsEnabled");
            this.columnNames.add("Id");
            this.columnNames.add("Deleted");
            this.columnNames.add("LstLoggedIn");
            this.columnNames.add("AccountLastValidated");
            this.columnNames.add("Vbase2Id");
            this.columnNames.add("FirstName");
            this.columnNames.add("IsCredentialsExpired");
            this.columnNames.add("Version");
            this.columnNames.add("PasswordHint");
            this.columnNames.add("ModifiedBy");
            this.columnNames.add("PhoneNumber");
            this.columnNames.add("Created");
            this.columnNames.add("CreatedBy");
            this.columnNames.add("BadLogInAttempts");
            this.columnNames.add("IsAccountLocked");
            this.columnNames.add("Modified");
            this.columnNames.add("Password");
            this.columnNames.add("IsAccountExpired");
            this.columnNames.add("UserName");
        }

        return this.columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.lastloginattempt);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.lastname);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.fullname);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.isenabled);
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
        record.append(this.lstloggedin);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.accountlastvalidated);
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
        record.append(this.iscredentialsexpired);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.version);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.passwordhint);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.modifiedby.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.phonenumber);
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
        record.append(this.badloginattempts);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.isaccountlocked);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.modified);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.password);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.isaccountexpired);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.username);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
