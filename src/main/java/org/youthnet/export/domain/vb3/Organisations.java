package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Organisations implements CSVable, ContainsVb2id {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 18;
    private List<String[]> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

    private Boolean isactive;
    private Boolean isvuo;
    private String missionstatement;
    private String name;
    private String openinghours;
    private String ownid;
    private String registeredcharitynumber;
    private Long vbase2id;
    private UUID howheardid;
    private UUID id;
    private Timestamp created;
    private UUID createdby;
    private Boolean deleted;
    private Timestamp modified;
    private UUID modifiedby;
    private Long version;
    private String description;
    private String howhearddetails;

    public Organisations() {
    }

    public Organisations(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));
        StringBuffer uuidStringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");


        this.isactive = fields[0].replace(String.valueOf(this.enclosure), "").equals("1");

        this.isvuo = fields[1].replace(String.valueOf(this.enclosure), "").equals("1");

        this.missionstatement = fields[2].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.name = fields[3].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.openinghours = fields[4].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.ownid = fields[5].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.registeredcharitynumber = fields[6].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.vbase2id = (fields[7].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[7].replace(String.valueOf(this.enclosure), ""));

        if (fields[8].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.howheardid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[8].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.howheardid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[9].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.id = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[9].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.id = UUID.fromString(uuidStringBuffer.toString());
        }

        try {
            this.created = (fields[10].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[10].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp created " + fields[10].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        if (fields[11].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.createdby = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[11].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.createdby = UUID.fromString(uuidStringBuffer.toString());
        }

        this.deleted = fields[12].replace(String.valueOf(this.enclosure), "").equals("1");

        try {
            this.modified = (fields[13].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[13].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp modified " + fields[13].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        if (fields[14].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.modifiedby = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[14].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.modifiedby = UUID.fromString(uuidStringBuffer.toString());
        }

        this.version = (fields[15].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[15].replace(String.valueOf(this.enclosure), ""));

        this.description = fields[16].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.howhearddetails = fields[17].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

    }


    public Boolean getIsActive() {
        return this.isactive;
    }

    public void setIsActive(Boolean isactive) {
        this.isactive = isactive;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpeningHours() {
        return this.openinghours;
    }

    public void setOpeningHours(String openinghours) {
        this.openinghours = openinghours;
    }

    public String getOwnId() {
        return this.ownid;
    }

    public void setOwnId(String ownid) {
        this.ownid = ownid;
    }

    public String getRegisteredCharityNumber() {
        return this.registeredcharitynumber;
    }

    public void setRegisteredCharityNumber(String registeredcharitynumber) {
        this.registeredcharitynumber = registeredcharitynumber;
    }

    public Long getVbase2Id() {
        return this.vbase2id;
    }

    public void setVbase2Id(Long vbase2id) {
        this.vbase2id = vbase2id;
    }

    public UUID getHowHeardId() {
        return this.howheardid;
    }

    public void setHowHeardId(UUID howheardid) {
        this.howheardid = howheardid;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public UUID getModifiedBy() {
        return this.modifiedby;
    }

    public void setModifiedBy(UUID modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHowHeardDetails() {
        return this.howhearddetails;
    }

    public void setHowHeardDetails(String howhearddetails) {
        this.howhearddetails = howhearddetails;
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

    public List<String[]> getColumnNames() {
        if (this.columnNames == null) {
            this.columnNames = new ArrayList<String[]>();
            this.columnNames.add(new String[]{"IsActive", "Boolean"});
            this.columnNames.add(new String[]{"IsVuo", "Boolean"});
            this.columnNames.add(new String[]{"MissionStatement", "String"});
            this.columnNames.add(new String[]{"Name", "String"});
            this.columnNames.add(new String[]{"OpeningHours", "String"});
            this.columnNames.add(new String[]{"OwnId", "String"});
            this.columnNames.add(new String[]{"RegisteredCharityNumber", "String"});
            this.columnNames.add(new String[]{"Vbase2Id", "Long"});
            this.columnNames.add(new String[]{"HowHeardId", "UUID"});
            this.columnNames.add(new String[]{"Id", "UUID"});
            this.columnNames.add(new String[]{"Created", "Timestamp"});
            this.columnNames.add(new String[]{"CreatedBy", "UUID"});
            this.columnNames.add(new String[]{"Deleted", "Boolean"});
            this.columnNames.add(new String[]{"Modified", "Timestamp"});
            this.columnNames.add(new String[]{"ModifiedBy", "UUID"});
            this.columnNames.add(new String[]{"Version", "Long"});
            this.columnNames.add(new String[]{"Description", "String"});
            this.columnNames.add(new String[]{"HowHeardDetails", "String"});
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.isactive != null && this.isactive ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.isvuo != null && this.isvuo ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.missionstatement == null ? "" :
                this.missionstatement.length() < 250 ? this.missionstatement.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.missionstatement.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.name == null ? "" :
                this.name.length() < 250 ? this.name.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.name.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.openinghours == null ? "" :
                this.openinghours.length() < 250 ? this.openinghours.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.openinghours.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.ownid == null ? "" :
                this.ownid.length() < 250 ? this.ownid.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.ownid.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.registeredcharitynumber == null ? "" :
                this.registeredcharitynumber.length() < 250 ? this.registeredcharitynumber.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.registeredcharitynumber.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.vbase2id == null ? "" : this.vbase2id);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.howheardid == null ? "" : this.howheardid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.id == null ? "" : this.id.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.created == null ? "" : this.created);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.createdby == null ? "" : this.createdby.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.deleted != null && this.deleted ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.modified == null ? "" : this.modified);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.modifiedby == null ? "" : this.modifiedby.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.version == null ? "" : this.version);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.description == null ? "" :
                this.description.length() < 250 ? this.description.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.description.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.howhearddetails == null ? "" :
                this.howhearddetails.length() < 250 ? this.howhearddetails.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.howhearddetails.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
