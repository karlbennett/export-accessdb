package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.vb3.lookups.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Volunteer extends GenericDTO {


    private Title title;
    private String firstName;
    private String lastName;
    private String ownId;
    private String preferredName;
    private Integer vbase2Id;
    private boolean agreesToBeContacted;
    private Set<VolunteerContactTelephone> contactTelephones = new HashSet<VolunteerContactTelephone>(0);
    private Set<VolunteerContactEmail> contactEmails = new HashSet<VolunteerContactEmail>(0);
    private Set<VolunteerAddress> addresses = new HashSet<VolunteerAddress>(0);
    private Date dateOfBirth;
    private String disabilityDetails;
    private Gender gender;
    private AgeRange ageRange;
    private EmploymentStatus employmentStatus;
    private Ethnicity ethnicity;
    private Nationality nationality;
    private DrivingLicence drivingLicence;
    private Religion religion;
    private DisabilityStatus disabilityStatus;
    private Transport transport;
    private SexualOrientation sexualOrientation;
    private Set<DisabilityType> disabilityTypes = new HashSet<DisabilityType>(0);
    private String qualificationsAndExperience;
    private Set<Skill> currentSkills = new HashSet<Skill>(0);
    private Set<Skill> wantedSkills = new HashSet<Skill>(0);
    private Set<TypeOfActivity> typeOfActivity = new HashSet<TypeOfActivity>(0);
    private Set<CauseInterest> causesInterests = new HashSet<CauseInterest>(0);
    private Integer amCommitment;
    private Integer pmCommitment;
    private Integer eveCommitment;
    private Set<CommitmentType> commitmentType = new HashSet<CommitmentType>(0);
    private AvailabilityStatus availabilityStatus;
    private Set<GeographicalArea> areas = new HashSet<GeographicalArea>(0);
    private Set<MotivationsForVolunteering> reasonsMotivations = new HashSet<MotivationsForVolunteering>(0);
    private String otherMotivations;
    private HowHeard howHeard;
    private String howHeardDetails;
    private Set<TaggedData> tags = new HashSet<TaggedData>(0);
    private Set<CampaignsAndInitiatives> campaignsAndInitiatives = new HashSet<CampaignsAndInitiatives>(0);
    private boolean isActive;
    private PlacementStatus placementStatus;


    public Volunteer() {
    }


    public Volunteer(Title title, String firstName, String lastName, String ownId, String preferredName, Integer vbase2Id, boolean agreesToBeContacted, Set<VolunteerContactTelephone> contactTelephones, Set<VolunteerContactEmail> contactEmails, Set<VolunteerAddress> addresses, Date dateOfBirth, String disabilityDetails, Gender gender, AgeRange ageRange, EmploymentStatus employmentStatus, Ethnicity ethnicity, Nationality nationality, DrivingLicence drivingLicence, Religion religion, DisabilityStatus disabilityStatus, Transport transport, SexualOrientation sexualOrientation, Set<DisabilityType> disabilityTypes, String qualificationsAndExperience, Set<Skill> currentSkills, Set<Skill> wantedSkills, Set<TypeOfActivity> typeOfActivity, Set<CauseInterest> causesInterests, Integer amCommitment, Integer pmCommitment, Integer eveCommitment, Set<CommitmentType> commitmentType, AvailabilityStatus availabilityStatus, Set<GeographicalArea> areas, Set<MotivationsForVolunteering> reasonsMotivations, String otherMotivations, HowHeard howHeard, String howHeardDetails, Set<TaggedData> tags, Set<CampaignsAndInitiatives> campaignsAndInitiatives) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ownId = ownId;
        this.preferredName = preferredName;
        this.vbase2Id = vbase2Id;
        this.agreesToBeContacted = agreesToBeContacted;
        this.contactTelephones = contactTelephones;
        this.contactEmails = contactEmails;
        this.addresses = addresses;
        this.dateOfBirth = dateOfBirth;
        this.disabilityDetails = disabilityDetails;
        this.gender = gender;
        this.ageRange = ageRange;
        this.employmentStatus = employmentStatus;
        this.ethnicity = ethnicity;
        this.nationality = nationality;
        this.drivingLicence = drivingLicence;
        this.religion = religion;
        this.disabilityStatus = disabilityStatus;
        this.transport = transport;
        this.sexualOrientation = sexualOrientation;
        this.disabilityTypes = disabilityTypes;
        this.qualificationsAndExperience = qualificationsAndExperience;
        this.currentSkills = currentSkills;
        this.wantedSkills = wantedSkills;
        this.typeOfActivity = typeOfActivity;
        this.causesInterests = causesInterests;
        this.amCommitment = amCommitment;
        this.pmCommitment = pmCommitment;
        this.eveCommitment = eveCommitment;
        this.commitmentType = commitmentType;
        this.availabilityStatus = availabilityStatus;
        this.areas = areas;
        this.reasonsMotivations = reasonsMotivations;
        this.otherMotivations = otherMotivations;
        this.howHeard = howHeard;
        this.howHeardDetails = howHeardDetails;
        this.tags = tags;
        this.campaignsAndInitiatives = campaignsAndInitiatives;
    }


    public Title getTitle() {
        return this.title;
    }


    public void setTitle(Title title) {
        this.title = title;
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


    public String getOwnId() {
        return this.ownId;
    }


    public void setOwnId(String ownId) {
        this.ownId = ownId;
    }


    public String getPreferredName() {
        return this.preferredName;
    }


    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }


    public Integer getVbase2Id() {
        return this.vbase2Id;
    }


    public void setVbase2Id(Integer vbase2Id) {
        this.vbase2Id = vbase2Id;
    }


    public boolean isAgreesToBeContacted() {
        return this.agreesToBeContacted;
    }


    public void setAgreesToBeContacted(boolean agreesToBeContacted) {
        this.agreesToBeContacted = agreesToBeContacted;
    }


    public Set<VolunteerContactTelephone> getContactTelephones() {
        return this.contactTelephones;
    }


    public void setContactTelephones(Set<VolunteerContactTelephone> contactTelephones) {
        this.contactTelephones = contactTelephones;
    }


    public Set<VolunteerContactEmail> getContactEmails() {
        return this.contactEmails;
    }


    public void setContactEmails(Set<VolunteerContactEmail> contactEmails) {
        this.contactEmails = contactEmails;
    }


    public Set<VolunteerAddress> getAddresses() {
        return this.addresses;
    }


    public void setAddresses(Set<VolunteerAddress> addresses) {
        this.addresses = addresses;
    }


    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }


    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public String getDisabilityDetails() {
        return this.disabilityDetails;
    }


    public void setDisabilityDetails(String disabilityDetails) {
        this.disabilityDetails = disabilityDetails;
    }


    public Gender getGender() {
        return this.gender;
    }


    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public AgeRange getAgeRange() {
        return this.ageRange;
    }


    public void setAgeRange(AgeRange ageRange) {
        this.ageRange = ageRange;
    }


    public EmploymentStatus getEmploymentStatus() {
        return this.employmentStatus;
    }


    public void setEmploymentStatus(EmploymentStatus employmentStatus) {
        this.employmentStatus = employmentStatus;
    }


    public Ethnicity getEthnicity() {
        return this.ethnicity;
    }


    public void setEthnicity(Ethnicity ethnicity) {
        this.ethnicity = ethnicity;
    }


    public Nationality getNationality() {
        return this.nationality;
    }


    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }


    public DrivingLicence getDrivingLicence() {
        return this.drivingLicence;
    }


    public void setDrivingLicence(DrivingLicence drivingLicence) {
        this.drivingLicence = drivingLicence;
    }


    public Religion getReligion() {
        return this.religion;
    }


    public void setReligion(Religion religion) {
        this.religion = religion;
    }


    public DisabilityStatus getDisabilityStatus() {
        return this.disabilityStatus;
    }


    public void setDisabilityStatus(DisabilityStatus disabilityStatus) {
        this.disabilityStatus = disabilityStatus;
    }


    public Transport getTransport() {
        return this.transport;
    }


    public void setTransport(Transport transport) {
        this.transport = transport;
    }


    public SexualOrientation getSexualOrientation() {
        return this.sexualOrientation;
    }


    public void setSexualOrientation(SexualOrientation sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }


    public Set<DisabilityType> getDisabilityTypes() {
        return this.disabilityTypes;
    }


    public void setDisabilityTypes(Set<DisabilityType> disabilityTypes) {
        this.disabilityTypes = disabilityTypes;
    }


    public String getQualificationsAndExperience() {
        return this.qualificationsAndExperience;
    }


    public void setQualificationsAndExperience(String qualificationsAndExperience) {
        this.qualificationsAndExperience = qualificationsAndExperience;
    }


    public Set<Skill> getCurrentSkills() {
        return this.currentSkills;
    }


    public void setCurrentSkills(Set<Skill> currentSkills) {
        this.currentSkills = currentSkills;
    }


    public Set<Skill> getWantedSkills() {
        return this.wantedSkills;
    }


    public void setWantedSkills(Set<Skill> wantedSkills) {
        this.wantedSkills = wantedSkills;
    }


    public Set<TypeOfActivity> getTypeOfActivity() {
        return this.typeOfActivity;
    }


    public void setTypeOfActivity(Set<TypeOfActivity> typeOfActivity) {
        this.typeOfActivity = typeOfActivity;
    }


    public Set<CauseInterest> getCausesInterests() {
        return this.causesInterests;
    }


    public void setCausesInterests(Set<CauseInterest> causesInterests) {
        this.causesInterests = causesInterests;
    }


    public Integer getAmCommitment() {
        return this.amCommitment;
    }


    public void setAmCommitment(Integer amCommitment) {
        this.amCommitment = amCommitment;
    }


    public Integer getPmCommitment() {
        return this.pmCommitment;
    }


    public void setPmCommitment(Integer pmCommitment) {
        this.pmCommitment = pmCommitment;
    }


    public Integer getEveCommitment() {
        return this.eveCommitment;
    }


    public void setEveCommitment(Integer eveCommitment) {
        this.eveCommitment = eveCommitment;
    }


    public Set<CommitmentType> getCommitmentType() {
        return this.commitmentType;
    }


    public void setCommitmentType(Set<CommitmentType> commitmentType) {
        this.commitmentType = commitmentType;
    }


    public AvailabilityStatus getAvailabilityStatus() {
        return this.availabilityStatus;
    }


    public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }


    public Set<GeographicalArea> getAreas() {
        return this.areas;
    }


    public void setAreas(Set<GeographicalArea> areas) {
        this.areas = areas;
    }


    public Set<MotivationsForVolunteering> getReasonsMotivations() {
        return this.reasonsMotivations;
    }


    public void setReasonsMotivations(Set<MotivationsForVolunteering> reasonsMotivations) {
        this.reasonsMotivations = reasonsMotivations;
    }


    public String getOtherMotivations() {
        return this.otherMotivations;
    }


    public void setOtherMotivations(String otherMotivations) {
        this.otherMotivations = otherMotivations;
    }


    public HowHeard getHowHeard() {
        return this.howHeard;
    }


    public void setHowHeard(HowHeard howHeard) {
        this.howHeard = howHeard;
    }


    public String getHowHeardDetails() {
        return this.howHeardDetails;
    }


    public void setHowHeardDetails(String howHeardDetails) {
        this.howHeardDetails = howHeardDetails;
    }


    public Set<TaggedData> getTags() {
        return this.tags;
    }


    public void setTags(Set<TaggedData> tags) {
        this.tags = tags;
    }


    public Set<CampaignsAndInitiatives> getCampaignsAndInitiatives() {
        return this.campaignsAndInitiatives;
    }


    public void setCampaignsAndInitiatives(Set<CampaignsAndInitiatives> campaignsAndInitiatives) {
        this.campaignsAndInitiatives = campaignsAndInitiatives;
    }


    public boolean isIsActive() {
        return this.isActive;
    }


    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }


    public PlacementStatus getPlacementStatus() {
    }


    public void setPlacementStatus(PlacementStatus placementStatus) {
        this.placementStatus = placementStatus;
    }
}
