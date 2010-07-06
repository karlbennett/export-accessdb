package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Volunteers implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 36;
    private List<String> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

    private UUID genderid;
    private UUID howheardid;
    private String qualificationsandexperience;
    private Long pmcommitment;
    private UUID transportid;
    private Boolean agreestobecontacted;
    private String ownid;
    private Timestamp dateofbirth;
    private String lastname;
    private UUID disabilitystatusid;
    private UUID id;
    private Boolean deleted;
    private UUID ethnicityid;
    private UUID sexualorientationid;
    private Long amcommitment;
    private UUID nationalityid;
    private UUID agerangeid;
    private UUID employmentstatusid;
    private Long vbase2id;
    private String firstname;
    private Long evecommitment;
    private String disabilitydetails;
    private String howhearddetails;
    private UUID titleid;
    private Long version;
    private UUID modifiedby;
    private UUID availabilitystatusid;
    private UUID drivinglicenceid;
    private String preferredname;
    private String othermotivations;
    private Boolean isactive;
    private Timestamp created;
    private UUID createdby;
    private UUID placementstatusid;
    private Timestamp modified;
    private UUID religionid;

    public Volunteers() {
    }

    public Volunteers(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split(String.valueOf(this.delimiter));
        StringBuffer uuidStringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");


        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[0].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.genderid = UUID.fromString(uuidStringBuffer.toString());

        this.qualificationsandexperience = fields[1].replace(String.valueOf(this.enclosure), "");

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[2].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.howheardid = UUID.fromString(uuidStringBuffer.toString());

        this.pmcommitment = Long.valueOf(fields[3].replace(String.valueOf(this.enclosure), ""));

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[4].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.transportid = UUID.fromString(uuidStringBuffer.toString());

        this.ownid = fields[5].replace(String.valueOf(this.enclosure), "");

        this.agreestobecontacted = fields[6].replace(String.valueOf(this.enclosure), "").equals("1");

        try {
            this.dateofbirth = new Timestamp(simpleDateFormat.parse(fields[7].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp dateofbirth " + fields[7].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        this.lastname = fields[8].replace(String.valueOf(this.enclosure), "");

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[9].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.disabilitystatusid = UUID.fromString(uuidStringBuffer.toString());

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[10].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.id = UUID.fromString(uuidStringBuffer.toString());

        this.deleted = fields[11].replace(String.valueOf(this.enclosure), "").equals("1");

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[12].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.ethnicityid = UUID.fromString(uuidStringBuffer.toString());

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[13].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.sexualorientationid = UUID.fromString(uuidStringBuffer.toString());

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[14].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.agerangeid = UUID.fromString(uuidStringBuffer.toString());

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[15].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.nationalityid = UUID.fromString(uuidStringBuffer.toString());

        this.amcommitment = Long.valueOf(fields[16].replace(String.valueOf(this.enclosure), ""));

        this.firstname = fields[17].replace(String.valueOf(this.enclosure), "");

        this.vbase2id = Long.valueOf(fields[18].replace(String.valueOf(this.enclosure), ""));

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[19].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.employmentstatusid = UUID.fromString(uuidStringBuffer.toString());

        this.evecommitment = Long.valueOf(fields[20].replace(String.valueOf(this.enclosure), ""));

        this.disabilitydetails = fields[21].replace(String.valueOf(this.enclosure), "");

        this.howhearddetails = fields[22].replace(String.valueOf(this.enclosure), "");

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[23].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.titleid = UUID.fromString(uuidStringBuffer.toString());

        this.version = Long.valueOf(fields[24].replace(String.valueOf(this.enclosure), ""));

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[25].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.modifiedby = UUID.fromString(uuidStringBuffer.toString());

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[26].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.availabilitystatusid = UUID.fromString(uuidStringBuffer.toString());

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[27].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.drivinglicenceid = UUID.fromString(uuidStringBuffer.toString());

        this.preferredname = fields[28].replace(String.valueOf(this.enclosure), "");

        this.othermotivations = fields[29].replace(String.valueOf(this.enclosure), "");

        this.isactive = fields[30].replace(String.valueOf(this.enclosure), "").equals("1");

        try {
            this.created = new Timestamp(simpleDateFormat.parse(fields[31].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp created " + fields[31].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[32].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.createdby = UUID.fromString(uuidStringBuffer.toString());

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[33].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.placementstatusid = UUID.fromString(uuidStringBuffer.toString());

        try {
            this.modified = new Timestamp(simpleDateFormat.parse(fields[34].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp modified " + fields[34].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[35].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.religionid = UUID.fromString(uuidStringBuffer.toString());

    }


    public UUID getGenderId() {
        return this.genderid;
    }

    public void setGenderId(UUID genderid) {
        this.genderid = genderid;
    }

    public UUID getHowHeardId() {
        return this.howheardid;
    }

    public void setHowHeardId(UUID howheardid) {
        this.howheardid = howheardid;
    }

    public String getQualificationsAndExperience() {
        return this.qualificationsandexperience;
    }

    public void setQualificationsAndExperience(String qualificationsandexperience) {
        this.qualificationsandexperience = qualificationsandexperience;
    }

    public Long getPmCommitment() {
        return this.pmcommitment;
    }

    public void setPmCommitment(Long pmcommitment) {
        this.pmcommitment = pmcommitment;
    }

    public UUID getTransportId() {
        return this.transportid;
    }

    public void setTransportId(UUID transportid) {
        this.transportid = transportid;
    }

    public Boolean getAgreesToBeContacted() {
        return this.agreestobecontacted;
    }

    public void setAgreesToBeContacted(Boolean agreestobecontacted) {
        this.agreestobecontacted = agreestobecontacted;
    }

    public String getOwnId() {
        return this.ownid;
    }

    public void setOwnId(String ownid) {
        this.ownid = ownid;
    }

    public Timestamp getDateOfBirth() {
        return this.dateofbirth;
    }

    public void setDateOfBirth(Timestamp dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getLastName() {
        return this.lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public UUID getDisabilityStatusId() {
        return this.disabilitystatusid;
    }

    public void setDisabilityStatusId(UUID disabilitystatusid) {
        this.disabilitystatusid = disabilitystatusid;
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

    public UUID getEthnicityId() {
        return this.ethnicityid;
    }

    public void setEthnicityId(UUID ethnicityid) {
        this.ethnicityid = ethnicityid;
    }

    public UUID getSexualOrientationId() {
        return this.sexualorientationid;
    }

    public void setSexualOrientationId(UUID sexualorientationid) {
        this.sexualorientationid = sexualorientationid;
    }

    public Long getAmCommitment() {
        return this.amcommitment;
    }

    public void setAmCommitment(Long amcommitment) {
        this.amcommitment = amcommitment;
    }

    public UUID getNationalityId() {
        return this.nationalityid;
    }

    public void setNationalityId(UUID nationalityid) {
        this.nationalityid = nationalityid;
    }

    public UUID getAgeRangeId() {
        return this.agerangeid;
    }

    public void setAgeRangeId(UUID agerangeid) {
        this.agerangeid = agerangeid;
    }

    public UUID getEmploymentStatusId() {
        return this.employmentstatusid;
    }

    public void setEmploymentStatusId(UUID employmentstatusid) {
        this.employmentstatusid = employmentstatusid;
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

    public Long getEveCommitment() {
        return this.evecommitment;
    }

    public void setEveCommitment(Long evecommitment) {
        this.evecommitment = evecommitment;
    }

    public String getDisabilityDetails() {
        return this.disabilitydetails;
    }

    public void setDisabilityDetails(String disabilitydetails) {
        this.disabilitydetails = disabilitydetails;
    }

    public String getHowHeardDetails() {
        return this.howhearddetails;
    }

    public void setHowHeardDetails(String howhearddetails) {
        this.howhearddetails = howhearddetails;
    }

    public UUID getTitleId() {
        return this.titleid;
    }

    public void setTitleId(UUID titleid) {
        this.titleid = titleid;
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

    public UUID getAvailabilityStatusId() {
        return this.availabilitystatusid;
    }

    public void setAvailabilityStatusId(UUID availabilitystatusid) {
        this.availabilitystatusid = availabilitystatusid;
    }

    public UUID getDrivingLicenceId() {
        return this.drivinglicenceid;
    }

    public void setDrivingLicenceId(UUID drivinglicenceid) {
        this.drivinglicenceid = drivinglicenceid;
    }

    public String getPreferredName() {
        return this.preferredname;
    }

    public void setPreferredName(String preferredname) {
        this.preferredname = preferredname;
    }

    public String getOtherMotivations() {
        return this.othermotivations;
    }

    public void setOtherMotivations(String othermotivations) {
        this.othermotivations = othermotivations;
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

    public UUID getPlacementStatusId() {
        return this.placementstatusid;
    }

    public void setPlacementStatusId(UUID placementstatusid) {
        this.placementstatusid = placementstatusid;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public UUID getReligionId() {
        return this.religionid;
    }

    public void setReligionId(UUID religionid) {
        this.religionid = religionid;
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
            this.columnNames.add("GenderId");
            this.columnNames.add("QualificationsAndExperience");
            this.columnNames.add("HowHeardId");
            this.columnNames.add("PmCommitment");
            this.columnNames.add("TransportId");
            this.columnNames.add("OwnId");
            this.columnNames.add("AgreesToBeContacted");
            this.columnNames.add("DateOfBirth");
            this.columnNames.add("LastName");
            this.columnNames.add("DisabilityStatusId");
            this.columnNames.add("Id");
            this.columnNames.add("Deleted");
            this.columnNames.add("EthnicityId");
            this.columnNames.add("SexualOrientationId");
            this.columnNames.add("AgeRangeId");
            this.columnNames.add("NationalityId");
            this.columnNames.add("AmCommitment");
            this.columnNames.add("FirstName");
            this.columnNames.add("Vbase2Id");
            this.columnNames.add("EmploymentStatusId");
            this.columnNames.add("EveCommitment");
            this.columnNames.add("DisabilityDetails");
            this.columnNames.add("HowHeardDetails");
            this.columnNames.add("TitleId");
            this.columnNames.add("Version");
            this.columnNames.add("ModifiedBy");
            this.columnNames.add("AvailabilityStatusId");
            this.columnNames.add("DrivingLicenceId");
            this.columnNames.add("PreferredName");
            this.columnNames.add("OtherMotivations");
            this.columnNames.add("IsActive");
            this.columnNames.add("Created");
            this.columnNames.add("CreatedBy");
            this.columnNames.add("PlacementStatusId");
            this.columnNames.add("Modified");
            this.columnNames.add("ReligionId");
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.genderid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.qualificationsandexperience);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.howheardid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.pmcommitment);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.transportid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.ownid);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(agreestobecontacted ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.dateofbirth);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.lastname);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.disabilitystatusid.toString().replace("-", ""));
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
        recordStringBuffer.append(this.ethnicityid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.sexualorientationid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.agerangeid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.nationalityid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.amcommitment);
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
        recordStringBuffer.append(this.employmentstatusid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.evecommitment);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.disabilitydetails);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.howhearddetails);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.titleid.toString().replace("-", ""));
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
        recordStringBuffer.append(this.availabilitystatusid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.drivinglicenceid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.preferredname);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.othermotivations);
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
        recordStringBuffer.append(this.placementstatusid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.modified);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.religionid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
