package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Volunteers implements CSVable, ContainsVb2id {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 36;
    private List<String> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

    private Timestamp dateofbirth;
    private String disabilitydetails;
    private Long evecommitment;
    private String preferredname;
    private String firstname;
    private String qualificationsandexperience;
    private String howhearddetails;
    private Long vbase2id;
    private Boolean isactive;
    private UUID howheardid;
    private UUID agerangeid;
    private String lastname;
    private UUID nationalityid;
    private UUID availabilitystatusid;
    private String othermotivations;
    private UUID placementstatusid;
    private UUID disabilitystatusid;
    private String ownid;
    private UUID religionid;
    private UUID drivinglicenceid;
    private Long pmcommitment;
    private UUID sexualorientationid;
    private UUID employmentstatusid;
    private UUID titleid;
    private UUID ethnicityid;
    private UUID transportid;
    private UUID genderid;
    private UUID id;
    private Timestamp created;
    private UUID createdby;
    private Boolean deleted;
    private Timestamp modified;
    private UUID modifiedby;
    private Long version;
    private Boolean agreestobecontacted;
    private Long amcommitment;

    public Volunteers() {
    }

    public Volunteers(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));
        StringBuffer uuidStringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");


        try {
            this.dateofbirth = (fields[0].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[0].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp dateofbirth " + fields[0].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        this.disabilitydetails = fields[1].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.evecommitment = (fields[2].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[2].replace(String.valueOf(this.enclosure), ""));

        this.preferredname = fields[3].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.firstname = fields[4].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.qualificationsandexperience = fields[5].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.howhearddetails = fields[6].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.vbase2id = (fields[7].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[7].replace(String.valueOf(this.enclosure), ""));

        this.isactive = fields[8].replace(String.valueOf(this.enclosure), "").equals("1");

        if (fields[9].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.howheardid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[9].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.howheardid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[10].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.agerangeid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[10].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.agerangeid = UUID.fromString(uuidStringBuffer.toString());
        }

        this.lastname = fields[11].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        if (fields[12].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.nationalityid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[12].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.nationalityid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[13].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.availabilitystatusid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[13].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.availabilitystatusid = UUID.fromString(uuidStringBuffer.toString());
        }

        this.othermotivations = fields[14].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        if (fields[15].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.placementstatusid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[15].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.placementstatusid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[16].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.disabilitystatusid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[16].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.disabilitystatusid = UUID.fromString(uuidStringBuffer.toString());
        }

        this.ownid = fields[17].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        if (fields[18].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.religionid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[18].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.religionid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[19].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.drivinglicenceid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[19].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.drivinglicenceid = UUID.fromString(uuidStringBuffer.toString());
        }

        this.pmcommitment = (fields[20].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[20].replace(String.valueOf(this.enclosure), ""));

        if (fields[21].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.sexualorientationid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[21].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.sexualorientationid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[22].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.employmentstatusid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[22].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.employmentstatusid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[23].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.titleid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[23].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.titleid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[24].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.ethnicityid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[24].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.ethnicityid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[25].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.transportid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[25].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.transportid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[26].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.genderid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[26].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.genderid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[27].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.id = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[27].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.id = UUID.fromString(uuidStringBuffer.toString());
        }

        try {
            this.created = (fields[28].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[28].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp created " + fields[28].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        if (fields[29].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.createdby = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[29].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.createdby = UUID.fromString(uuidStringBuffer.toString());
        }

        this.deleted = fields[30].replace(String.valueOf(this.enclosure), "").equals("1");

        try {
            this.modified = (fields[31].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[31].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp modified " + fields[31].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        if (fields[32].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.modifiedby = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[32].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.modifiedby = UUID.fromString(uuidStringBuffer.toString());
        }

        this.version = (fields[33].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[33].replace(String.valueOf(this.enclosure), ""));

        this.agreestobecontacted = fields[34].replace(String.valueOf(this.enclosure), "").equals("1");

        this.amcommitment = (fields[35].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[35].replace(String.valueOf(this.enclosure), ""));

    }


    public Timestamp getDateOfBirth() {
        return this.dateofbirth;
    }

    public void setDateOfBirth(Timestamp dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getDisabilityDetails() {
        return this.disabilitydetails;
    }

    public void setDisabilityDetails(String disabilitydetails) {
        this.disabilitydetails = disabilitydetails;
    }

    public Long getEveCommitment() {
        return this.evecommitment;
    }

    public void setEveCommitment(Long evecommitment) {
        this.evecommitment = evecommitment;
    }

    public String getPreferredName() {
        return this.preferredname;
    }

    public void setPreferredName(String preferredname) {
        this.preferredname = preferredname;
    }

    public String getFirstName() {
        return this.firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getQualificationsAndExperience() {
        return this.qualificationsandexperience;
    }

    public void setQualificationsAndExperience(String qualificationsandexperience) {
        this.qualificationsandexperience = qualificationsandexperience;
    }

    public String getHowHeardDetails() {
        return this.howhearddetails;
    }

    public void setHowHeardDetails(String howhearddetails) {
        this.howhearddetails = howhearddetails;
    }

    public Long getVbase2Id() {
        return this.vbase2id;
    }

    public void setVbase2Id(Long vbase2id) {
        this.vbase2id = vbase2id;
    }

    public Boolean getIsActive() {
        return this.isactive;
    }

    public void setIsActive(Boolean isactive) {
        this.isactive = isactive;
    }

    public UUID getHowHeardId() {
        return this.howheardid;
    }

    public void setHowHeardId(UUID howheardid) {
        this.howheardid = howheardid;
    }

    public UUID getAgeRangeId() {
        return this.agerangeid;
    }

    public void setAgeRangeId(UUID agerangeid) {
        this.agerangeid = agerangeid;
    }

    public String getLastName() {
        return this.lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public UUID getNationalityId() {
        return this.nationalityid;
    }

    public void setNationalityId(UUID nationalityid) {
        this.nationalityid = nationalityid;
    }

    public UUID getAvailabilityStatusId() {
        return this.availabilitystatusid;
    }

    public void setAvailabilityStatusId(UUID availabilitystatusid) {
        this.availabilitystatusid = availabilitystatusid;
    }

    public String getOtherMotivations() {
        return this.othermotivations;
    }

    public void setOtherMotivations(String othermotivations) {
        this.othermotivations = othermotivations;
    }

    public UUID getPlacementStatusId() {
        return this.placementstatusid;
    }

    public void setPlacementStatusId(UUID placementstatusid) {
        this.placementstatusid = placementstatusid;
    }

    public UUID getDisabilityStatusId() {
        return this.disabilitystatusid;
    }

    public void setDisabilityStatusId(UUID disabilitystatusid) {
        this.disabilitystatusid = disabilitystatusid;
    }

    public String getOwnId() {
        return this.ownid;
    }

    public void setOwnId(String ownid) {
        this.ownid = ownid;
    }

    public UUID getReligionId() {
        return this.religionid;
    }

    public void setReligionId(UUID religionid) {
        this.religionid = religionid;
    }

    public UUID getDrivingLicenceId() {
        return this.drivinglicenceid;
    }

    public void setDrivingLicenceId(UUID drivinglicenceid) {
        this.drivinglicenceid = drivinglicenceid;
    }

    public Long getPmCommitment() {
        return this.pmcommitment;
    }

    public void setPmCommitment(Long pmcommitment) {
        this.pmcommitment = pmcommitment;
    }

    public UUID getSexualOrientationId() {
        return this.sexualorientationid;
    }

    public void setSexualOrientationId(UUID sexualorientationid) {
        this.sexualorientationid = sexualorientationid;
    }

    public UUID getEmploymentStatusId() {
        return this.employmentstatusid;
    }

    public void setEmploymentStatusId(UUID employmentstatusid) {
        this.employmentstatusid = employmentstatusid;
    }

    public UUID getTitleId() {
        return this.titleid;
    }

    public void setTitleId(UUID titleid) {
        this.titleid = titleid;
    }

    public UUID getEthnicityId() {
        return this.ethnicityid;
    }

    public void setEthnicityId(UUID ethnicityid) {
        this.ethnicityid = ethnicityid;
    }

    public UUID getTransportId() {
        return this.transportid;
    }

    public void setTransportId(UUID transportid) {
        this.transportid = transportid;
    }

    public UUID getGenderId() {
        return this.genderid;
    }

    public void setGenderId(UUID genderid) {
        this.genderid = genderid;
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

    public Boolean getAgreesToBeContacted() {
        return this.agreestobecontacted;
    }

    public void setAgreesToBeContacted(Boolean agreestobecontacted) {
        this.agreestobecontacted = agreestobecontacted;
    }

    public Long getAmCommitment() {
        return this.amcommitment;
    }

    public void setAmCommitment(Long amcommitment) {
        this.amcommitment = amcommitment;
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
            this.columnNames.add("DateOfBirth");
            this.columnNames.add("DisabilityDetails");
            this.columnNames.add("EveCommitment");
            this.columnNames.add("PreferredName");
            this.columnNames.add("FirstName");
            this.columnNames.add("QualificationsAndExperience");
            this.columnNames.add("HowHeardDetails");
            this.columnNames.add("Vbase2Id");
            this.columnNames.add("IsActive");
            this.columnNames.add("HowHeardId");
            this.columnNames.add("AgeRangeId");
            this.columnNames.add("LastName");
            this.columnNames.add("NationalityId");
            this.columnNames.add("AvailabilityStatusId");
            this.columnNames.add("OtherMotivations");
            this.columnNames.add("PlacementStatusId");
            this.columnNames.add("DisabilityStatusId");
            this.columnNames.add("OwnId");
            this.columnNames.add("ReligionId");
            this.columnNames.add("DrivingLicenceId");
            this.columnNames.add("PmCommitment");
            this.columnNames.add("SexualOrientationId");
            this.columnNames.add("EmploymentStatusId");
            this.columnNames.add("TitleId");
            this.columnNames.add("EthnicityId");
            this.columnNames.add("TransportId");
            this.columnNames.add("GenderId");
            this.columnNames.add("Id");
            this.columnNames.add("Created");
            this.columnNames.add("CreatedBy");
            this.columnNames.add("Deleted");
            this.columnNames.add("Modified");
            this.columnNames.add("ModifiedBy");
            this.columnNames.add("Version");
            this.columnNames.add("AgreesToBeContacted");
            this.columnNames.add("AmCommitment");
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.dateofbirth == null ? "" : this.dateofbirth);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.disabilitydetails == null ? "" : this.disabilitydetails.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.evecommitment == null ? "" : this.evecommitment);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.preferredname == null ? "" : this.preferredname.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.firstname == null ? "" : this.firstname.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.qualificationsandexperience == null ? "" : this.qualificationsandexperience.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.howhearddetails == null ? "" : this.howhearddetails.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.vbase2id == null ? "" : this.vbase2id);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.isactive != null && this.isactive ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.howheardid == null ? "" : this.howheardid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.agerangeid == null ? "" : this.agerangeid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.lastname == null ? "" : this.lastname.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.nationalityid == null ? "" : this.nationalityid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.availabilitystatusid == null ? "" : this.availabilitystatusid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.othermotivations == null ? "" : this.othermotivations.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.placementstatusid == null ? "" : this.placementstatusid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.disabilitystatusid == null ? "" : this.disabilitystatusid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.ownid == null ? "" : this.ownid.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.religionid == null ? "" : this.religionid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.drivinglicenceid == null ? "" : this.drivinglicenceid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.pmcommitment == null ? "" : this.pmcommitment);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.sexualorientationid == null ? "" : this.sexualorientationid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.employmentstatusid == null ? "" : this.employmentstatusid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.titleid == null ? "" : this.titleid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.ethnicityid == null ? "" : this.ethnicityid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.transportid == null ? "" : this.transportid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.genderid == null ? "" : this.genderid.toString().replace("-", ""));
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
        recordStringBuffer.append(this.agreestobecontacted != null && this.agreestobecontacted ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.amcommitment == null ? "" : this.amcommitment);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
