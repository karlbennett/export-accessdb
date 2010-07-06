package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Organisations implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 18;
    private List<String> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

    private String registeredcharitynumber;
    private UUID howheardid;
    private String ownid;
    private UUID id;
    private Boolean deleted;
    private Long vbase2id;
    private String openinghours;
    private String howhearddetails;
    private String name;
    private Long version;
    private UUID modifiedby;
    private Boolean isactive;
    private Timestamp created;
    private UUID createdby;
    private String description;
    private Boolean isvuo;
    private String missionstatement;
    private Timestamp modified;

    public Organisations() {
    }

    public Organisations(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split(String.valueOf(this.delimiter));
        StringBuffer uuidStringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");


        this.registeredcharitynumber = fields[0].replace(String.valueOf(this.enclosure), "");

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[1].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.howheardid = UUID.fromString(uuidStringBuffer.toString());

        this.ownid = fields[2].replace(String.valueOf(this.enclosure), "");

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[3].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.id = UUID.fromString(uuidStringBuffer.toString());

        this.deleted = fields[4].replace(String.valueOf(this.enclosure), "").equals("1");

        this.openinghours = fields[5].replace(String.valueOf(this.enclosure), "");

        this.vbase2id = Long.valueOf(fields[6].replace(String.valueOf(this.enclosure), ""));

        this.howhearddetails = fields[7].replace(String.valueOf(this.enclosure), "");

        this.name = fields[8].replace(String.valueOf(this.enclosure), "");

        this.version = Long.valueOf(fields[9].replace(String.valueOf(this.enclosure), ""));

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[10].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.modifiedby = UUID.fromString(uuidStringBuffer.toString());

        this.isactive = fields[11].replace(String.valueOf(this.enclosure), "").equals("1");

        try {
            this.created = new Timestamp(simpleDateFormat.parse(fields[12].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp created " + fields[12].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[13].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.createdby = UUID.fromString(uuidStringBuffer.toString());

        this.description = fields[14].replace(String.valueOf(this.enclosure), "");

        this.isvuo = fields[15].replace(String.valueOf(this.enclosure), "").equals("1");

        this.missionstatement = fields[16].replace(String.valueOf(this.enclosure), "");

        try {
            this.modified = new Timestamp(simpleDateFormat.parse(fields[17].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp modified " + fields[17].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

    }


    public String getRegisteredCharityNumber() {
        return this.registeredcharitynumber;
    }

    public void setRegisteredCharityNumber(String registeredcharitynumber) {
        this.registeredcharitynumber = registeredcharitynumber;
    }

    public UUID getHowHeardId() {
        return this.howheardid;
    }

    public void setHowHeardId(UUID howheardid) {
        this.howheardid = howheardid;
    }

    public String getOwnId() {
        return this.ownid;
    }

    public void setOwnId(String ownid) {
        this.ownid = ownid;
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

    public Long getVbase2Id() {
        return this.vbase2id;
    }

    public void setVbase2Id(Long vbase2id) {
        this.vbase2id = vbase2id;
    }

    public String getOpeningHours() {
        return this.openinghours;
    }

    public void setOpeningHours(String openinghours) {
        this.openinghours = openinghours;
    }

    public String getHowHeardDetails() {
        return this.howhearddetails;
    }

    public void setHowHeardDetails(String howhearddetails) {
        this.howhearddetails = howhearddetails;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public UUID getCreatedBy() {
        return this.createdby;
    }

    public void setCreatedBy(UUID createdby) {
        this.createdby = createdby;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsVuo() {
        return this.isvuo;
    }

    public void setIsVuo(Boolean isvuo) {
        this.isvuo = isvuo;
    }

    public String getMissionStatement() {
        return this.missionstatement;
    }

    public void setMissionStatement(String missionstatement) {
        this.missionstatement = missionstatement;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
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
            this.columnNames.add("RegisteredCharityNumber");
            this.columnNames.add("HowHeardId");
            this.columnNames.add("OwnId");
            this.columnNames.add("Id");
            this.columnNames.add("Deleted");
            this.columnNames.add("OpeningHours");
            this.columnNames.add("Vbase2Id");
            this.columnNames.add("HowHeardDetails");
            this.columnNames.add("Name");
            this.columnNames.add("Version");
            this.columnNames.add("ModifiedBy");
            this.columnNames.add("IsActive");
            this.columnNames.add("Created");
            this.columnNames.add("CreatedBy");
            this.columnNames.add("Description");
            this.columnNames.add("IsVuo");
            this.columnNames.add("MissionStatement");
            this.columnNames.add("Modified");
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.registeredcharitynumber);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.howheardid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.ownid);
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
        recordStringBuffer.append(this.openinghours);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.vbase2id);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.howhearddetails);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.name);
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
        recordStringBuffer.append(isactive ? 1 : 0);
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
        recordStringBuffer.append(this.description);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(isvuo ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.missionstatement);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.modified);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
