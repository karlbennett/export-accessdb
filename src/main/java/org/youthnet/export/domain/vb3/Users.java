package org.youthnet.export.domain.vb3;


import java.sql.Timestamp;
import java.util.UUID;


public class Users {

    private Long version;
    private Timestamp lastloginattempt;
    private String phonenumber;
    private String lastname;
    private String fullname;
    private Boolean isenabled;
    private Timestamp created;
    private Long vbase2id;
    private String firstname;
    private Timestamp modified;
    private String password;
    private Boolean iscredentialsexpired;
    private String passwordhint;
    private UUID modifiedby;
    private UUID id;
    private Boolean deleted;
    private UUID createdby;
    private Timestamp lstloggedin;
    private Long badloginattempts;
    private Timestamp accountlastvalidated;
    private Boolean isaccountlocked;
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

    public Boolean getIsCredentialsExpired() {
        return this.iscredentialsexpired;
    }

    public void setIsCredentialsExpired(Boolean iscredentialsexpired) {
        this.iscredentialsexpired = iscredentialsexpired;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getPasswordHint() {
        return this.passwordhint;
    }

    public void setPasswordHint(String passwordhint) {
        this.passwordhint = passwordhint;
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsAccountExpired() {
        return this.isaccountexpired;
    }

    public void setIsAccountExpired(Boolean isaccountexpired) {
        this.isaccountexpired = isaccountexpired;
    }

    public String getUserName() {
        return this.username;
    }

    public void setUserName(String username) {
        this.username = username;
    }
}
