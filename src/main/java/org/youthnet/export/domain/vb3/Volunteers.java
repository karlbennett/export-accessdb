package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Volunteers implements CSVable {

    private String delimiter = "|";
    private String enclosure = "¬";
    private Integer columnNum = 36;
    private List<String> columnNames = null;
    private StringBuffer record = new StringBuffer();

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

    public UUID getGenderId() {
        return this.genderid;
    }

    public void setGenderId(UUID genderid) {
        this.genderid = genderid;
    }

    public String getQualificationsAndExperience() {
        return this.qualificationsandexperience;
    }

    public void setQualificationsAndExperience(String qualificationsandexperience) {
        this.qualificationsandexperience = qualificationsandexperience;
    }

    public UUID getHowHeardId() {
        return this.howheardid;
    }

    public void setHowHeardId(UUID howheardid) {
        this.howheardid = howheardid;
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

    public String getOwnId() {
        return this.ownid;
    }

    public void setOwnId(String ownid) {
        this.ownid = ownid;
    }

    public Boolean getAgreesToBeContacted() {
        return this.agreestobecontacted;
    }

    public void setAgreesToBeContacted(Boolean agreestobecontacted) {
        this.agreestobecontacted = agreestobecontacted;
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

    public UUID getAgeRangeId() {
        return this.agerangeid;
    }

    public void setAgeRangeId(UUID agerangeid) {
        this.agerangeid = agerangeid;
    }

    public UUID getNationalityId() {
        return this.nationalityid;
    }

    public void setNationalityId(UUID nationalityid) {
        this.nationalityid = nationalityid;
    }

    public Long getAmCommitment() {
        return this.amcommitment;
    }

    public void setAmCommitment(Long amcommitment) {
        this.amcommitment = amcommitment;
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

    public UUID getEmploymentStatusId() {
        return this.employmentstatusid;
    }

    public void setEmploymentStatusId(UUID employmentstatusid) {
        this.employmentstatusid = employmentstatusid;
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
            this.columnNames.add("GenderId");
            this.columnNames.add("HowHeardId");
            this.columnNames.add("QualificationsAndExperience");
            this.columnNames.add("PmCommitment");
            this.columnNames.add("TransportId");
            this.columnNames.add("AgreesToBeContacted");
            this.columnNames.add("OwnId");
            this.columnNames.add("DateOfBirth");
            this.columnNames.add("LastName");
            this.columnNames.add("DisabilityStatusId");
            this.columnNames.add("Id");
            this.columnNames.add("Deleted");
            this.columnNames.add("EthnicityId");
            this.columnNames.add("SexualOrientationId");
            this.columnNames.add("AmCommitment");
            this.columnNames.add("NationalityId");
            this.columnNames.add("AgeRangeId");
            this.columnNames.add("EmploymentStatusId");
            this.columnNames.add("Vbase2Id");
            this.columnNames.add("FirstName");
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
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.genderid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.howheardid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.qualificationsandexperience);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.pmcommitment);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.transportid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.agreestobecontacted);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.ownid);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.dateofbirth);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.lastname);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.disabilitystatusid.toString().replace("-", ""));
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
        record.append(this.ethnicityid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.sexualorientationid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.amcommitment);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.nationalityid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.agerangeid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.employmentstatusid.toString().replace("-", ""));
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
        record.append(this.evecommitment);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.disabilitydetails);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.howhearddetails);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.titleid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.version);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.modifiedby.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.availabilitystatusid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.drivinglicenceid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.preferredname);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.othermotivations);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.isactive);
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
        record.append(this.placementstatusid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.modified);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.religionid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
