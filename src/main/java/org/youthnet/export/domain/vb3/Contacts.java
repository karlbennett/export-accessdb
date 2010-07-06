package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Contacts implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 24;
    private List<String> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

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

    public Contacts(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split(String.valueOf(this.delimiter));
        StringBuffer uuidStringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");


        this.surname = fields[0].replace(String.valueOf(this.enclosure), "");

        this.jobtitle = fields[1].replace(String.valueOf(this.enclosure), "");

        this.email = fields[2].replace(String.valueOf(this.enclosure), "");

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[3].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.id = UUID.fromString(uuidStringBuffer.toString());

        this.deleted = fields[4].replace(String.valueOf(this.enclosure), "").equals("1");

        this.usingaddressemail = fields[5].replace(String.valueOf(this.enclosure), "").equals("1");

        this.firstname = fields[6].replace(String.valueOf(this.enclosure), "");

        this.vbase2id = Long.valueOf(fields[7].replace(String.valueOf(this.enclosure), ""));

        this.tel = fields[8].replace(String.valueOf(this.enclosure), "");

        this.usingaddresstel = fields[9].replace(String.valueOf(this.enclosure), "").equals("1");

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[10].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.titleid = UUID.fromString(uuidStringBuffer.toString());

        this.usingaddressfax = fields[11].replace(String.valueOf(this.enclosure), "").equals("1");

        this.version = Long.valueOf(fields[12].replace(String.valueOf(this.enclosure), ""));

        this.mobile = fields[13].replace(String.valueOf(this.enclosure), "");

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[14].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.modifiedby = UUID.fromString(uuidStringBuffer.toString());

        this.preferredname = fields[15].replace(String.valueOf(this.enclosure), "");

        this.isactive = fields[16].replace(String.valueOf(this.enclosure), "").equals("1");

        this.useasmaincontact = fields[17].replace(String.valueOf(this.enclosure), "").equals("1");

        try {
            this.created = new Timestamp(simpleDateFormat.parse(fields[18].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp created " + fields[18].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[19].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.createdby = UUID.fromString(uuidStringBuffer.toString());

        this.fax = fields[20].replace(String.valueOf(this.enclosure), "");

        this.department = fields[21].replace(String.valueOf(this.enclosure), "");

        try {
            this.modified = new Timestamp(simpleDateFormat.parse(fields[22].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp modified " + fields[22].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        this.notes = fields[23].replace(String.valueOf(this.enclosure), "");

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
            this.columnNames.add("Surname");
            this.columnNames.add("JobTitle");
            this.columnNames.add("Email");
            this.columnNames.add("Id");
            this.columnNames.add("Deleted");
            this.columnNames.add("UsingAddressEmail");
            this.columnNames.add("FirstName");
            this.columnNames.add("Vbase2Id");
            this.columnNames.add("Tel");
            this.columnNames.add("UsingAddressTel");
            this.columnNames.add("TitleId");
            this.columnNames.add("UsingAddressFax");
            this.columnNames.add("Version");
            this.columnNames.add("Mobile");
            this.columnNames.add("ModifiedBy");
            this.columnNames.add("PreferredName");
            this.columnNames.add("IsActive");
            this.columnNames.add("UseAsMainContact");
            this.columnNames.add("Created");
            this.columnNames.add("CreatedBy");
            this.columnNames.add("Fax");
            this.columnNames.add("Department");
            this.columnNames.add("Modified");
            this.columnNames.add("Notes");
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.surname);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.jobtitle);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.email);
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
        recordStringBuffer.append(usingaddressemail ? 1 : 0);
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
        recordStringBuffer.append(this.tel);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(usingaddresstel ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.titleid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(usingaddressfax ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.version);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.mobile);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.modifiedby.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.preferredname);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(isactive ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(useasmaincontact ? 1 : 0);
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
        recordStringBuffer.append(this.fax);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.department);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.modified);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.notes);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
