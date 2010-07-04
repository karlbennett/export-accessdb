package org.youthnet.export.domain.vb3;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Users extends GenericDTO {


    private Integer vbase2Id;
    private boolean isAccountExpired;
    private boolean isAccountLocked;
    private boolean isCredentialsExpired;
    private boolean isEnabled;
    private String userName;
    private String password;
    private String passwordHint;
    private String firstName;
    private String lastName;
    private String fullName;
    private String phoneNumber;
    private Date accountLastValidated;
    private Date lstLoggedIn;
    private Date lastLogInAttempt;
    private Integer badLogInAttempts;
    private Set<Role> roles = new HashSet<Role>(0);


    public Users() {
    }


    public Users(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    public Users(Integer vbase2Id, boolean isAccountExpired, boolean isAccountLocked, boolean isCredentialsExpired, boolean isEnabled, String userName, String password, String passwordHint, String firstName, String lastName, String fullName, String phoneNumber, Date accountLastValidated, Date lstLoggedIn, Date lastLogInAttempt, Integer badLogInAttempts, Set<Role> roles) {
        this.vbase2Id = vbase2Id;
        this.isAccountExpired = isAccountExpired;
        this.isAccountLocked = isAccountLocked;
        this.isCredentialsExpired = isCredentialsExpired;
        this.isEnabled = isEnabled;
        this.userName = userName;
        this.password = password;
        this.passwordHint = passwordHint;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.accountLastValidated = accountLastValidated;
        this.lstLoggedIn = lstLoggedIn;
        this.lastLogInAttempt = lastLogInAttempt;
        this.badLogInAttempts = badLogInAttempts;
        this.roles = roles;
    }


    public Integer getVbase2Id() {
        return this.vbase2Id;
    }


    public void setVbase2Id(Integer vbase2Id) {
        this.vbase2Id = vbase2Id;
    }


    public boolean isIsAccountExpired() {
        return this.isAccountExpired;
    }


    public void setIsAccountExpired(boolean isAccountExpired) {
        this.isAccountExpired = isAccountExpired;
    }


    public boolean isIsAccountLocked() {
        return this.isAccountLocked;
    }


    public void setIsAccountLocked(boolean isAccountLocked) {
        this.isAccountLocked = isAccountLocked;
    }


    public boolean isIsCredentialsExpired() {
        return this.isCredentialsExpired;
    }


    public void setIsCredentialsExpired(boolean isCredentialsExpired) {
        this.isCredentialsExpired = isCredentialsExpired;
    }


    public boolean isIsEnabled() {
        return this.isEnabled;
    }


    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }


    public String getUserName() {
        return this.userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return this.password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getPasswordHint() {
        return this.passwordHint;
    }


    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }


    public String getFirstName() {
        return this.firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return this.lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getFullName() {
        return this.fullName;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getPhoneNumber() {
        return this.phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public Date getAccountLastValidated() {
        return this.accountLastValidated;
    }


    public void setAccountLastValidated(Date accountLastValidated) {
        this.accountLastValidated = accountLastValidated;
    }


    public Date getLstLoggedIn() {
        return this.lstLoggedIn;
    }


    public void setLstLoggedIn(Date lstLoggedIn) {
        this.lstLoggedIn = lstLoggedIn;
    }


    public Date getLastLogInAttempt() {
        return this.lastLogInAttempt;
    }


    public void setLastLogInAttempt(Date lastLogInAttempt) {
        this.lastLogInAttempt = lastLogInAttempt;
    }


    public Integer getBadLogInAttempts() {
        return this.badLogInAttempts;
    }


    public void setBadLogInAttempts(Integer badLogInAttempts) {
        this.badLogInAttempts = badLogInAttempts;
    }


    public Set<Role> getRoles() {
        return this.roles;
    }


    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
