package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Users implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 23;
    private List<String> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

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

    public Users(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split(String.valueOf(this.delimiter));
        StringBuffer uuidStringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");


        try {
            this.lastloginattempt = new Timestamp(simpleDateFormat.parse(fields[0].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp lastloginattempt " + fields[0].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        this.lastname = fields[1].replace(String.valueOf(this.enclosure), "");

        this.fullname = fields[2].replace(String.valueOf(this.enclosure), "");

        this.isenabled = fields[3].replace(String.valueOf(this.enclosure), "").equals("1");

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[4].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.id = UUID.fromString(uuidStringBuffer.toString());

        this.deleted = fields[5].replace(String.valueOf(this.enclosure), "").equals("1");

        try {
            this.lstloggedin = new Timestamp(simpleDateFormat.parse(fields[6].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp lstloggedin " + fields[6].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        try {
            this.accountlastvalidated = new Timestamp(simpleDateFormat.parse(fields[7].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp accountlastvalidated " + fields[7].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        this.firstname = fields[8].replace(String.valueOf(this.enclosure), "");

        this.vbase2id = Long.valueOf(fields[9].replace(String.valueOf(this.enclosure), ""));

        this.iscredentialsexpired = fields[10].replace(String.valueOf(this.enclosure), "").equals("1");

        this.passwordhint = fields[11].replace(String.valueOf(this.enclosure), "");

        this.version = Long.valueOf(fields[12].replace(String.valueOf(this.enclosure), ""));

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[13].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.modifiedby = UUID.fromString(uuidStringBuffer.toString());

        this.phonenumber = fields[14].replace(String.valueOf(this.enclosure), "");

        try {
            this.created = new Timestamp(simpleDateFormat.parse(fields[15].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp created " + fields[15].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[16].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.createdby = UUID.fromString(uuidStringBuffer.toString());

        this.badloginattempts = Long.valueOf(fields[17].replace(String.valueOf(this.enclosure), ""));

        this.isaccountlocked = fields[18].replace(String.valueOf(this.enclosure), "").equals("1");

        try {
            this.modified = new Timestamp(simpleDateFormat.parse(fields[19].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp modified " + fields[19].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        this.isaccountexpired = fields[20].replace(String.valueOf(this.enclosure), "").equals("1");

        this.password = fields[21].replace(String.valueOf(this.enclosure), "");

        this.username = fields[22].replace(String.valueOf(this.enclosure), "");

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
            this.columnNames.add("LastLogInAttempt");
            this.columnNames.add("LastName");
            this.columnNames.add("FullName");
            this.columnNames.add("IsEnabled");
            this.columnNames.add("Id");
            this.columnNames.add("Deleted");
            this.columnNames.add("LstLoggedIn");
            this.columnNames.add("AccountLastValidated");
            this.columnNames.add("FirstName");
            this.columnNames.add("Vbase2Id");
            this.columnNames.add("IsCredentialsExpired");
            this.columnNames.add("PasswordHint");
            this.columnNames.add("Version");
            this.columnNames.add("ModifiedBy");
            this.columnNames.add("PhoneNumber");
            this.columnNames.add("Created");
            this.columnNames.add("CreatedBy");
            this.columnNames.add("BadLogInAttempts");
            this.columnNames.add("IsAccountLocked");
            this.columnNames.add("Modified");
            this.columnNames.add("IsAccountExpired");
            this.columnNames.add("Password");
            this.columnNames.add("UserName");
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.lastloginattempt);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.lastname);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.fullname);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(isenabled ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.id.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(deleted ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.lstloggedin);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.accountlastvalidated);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.firstname);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.vbase2id);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(iscredentialsexpired ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.passwordhint);
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
        recordStringBuffer.append(this.phonenumber);
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
        recordStringBuffer.append(this.badloginattempts);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(isaccountlocked ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.modified);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(isaccountexpired ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.password);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.username);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
