package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.vb3.lookups.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Opportunity extends GenericDTO {


    private Integer vbase2Id;
    private String title;
    private String ownId;
    private boolean locationsPubliclyViewable;
    private Organisation organisationId;
    private Set<LocationBase> locations = new HashSet<LocationBase>(0);
    private boolean useSharedInternalContactDetails;
    private boolean useSharedPublicContactDetails;
    private boolean isSharedInternalContactPublic;
    private ContactDetails sharedInternalContactDetails;
    private ContactDetails sharedPublicContactDetails;
    private Set<ArrangementsRecordEntry> arrangements = new HashSet<ArrangementsRecordEntry>(0);
    private String requirements;
    private String benefits;
    private Set<Skill> skillsRequired = new HashSet<Skill>(0);
    private Set<Skill> skillsToGain = new HashSet<Skill>(0);
    private String description;
    private String shortDescription;
    private float monetaryValuePerHour;
    private boolean isVirtualRemote;
    private boolean isResidential;
    private boolean isOneOff;
    private boolean isDateSpecific;
    private Date specificStartDate;
    private Date specificEndDate;
    private long commitmentAm;
    private long commitmentPm;
    private long commitmentEve;
    private Set<CommitmentType> commitmentTypes = new HashSet<CommitmentType>(0);
    private Set<TaggedData> tags = new HashSet<TaggedData>(0);
    private Set<CampaignsAndInitiatives> campaignsAndInitiatives = new HashSet<CampaignsAndInitiatives>(0);
    private Set<TypeOfActivity> typeOfActivity = new HashSet<TypeOfActivity>(0);
    private Set<CauseInterest> causesInterests = new HashSet<CauseInterest>(0);
    private Date advertisingStartDate;
    private Date advertisingEndDate;
    private boolean publishToDoIt;
    private boolean isActive;
    private Set<Suitabilities> addSpecSuitabilities = new HashSet<Suitabilities>(0);
    private Set<SelectionMethod> selectionMethods = new HashSet<SelectionMethod>(0);


    public Opportunity() {
    }


    public Opportunity(Integer vbase2Id, String title, String ownId, boolean locationsPubliclyViewable, Organisation organisationId, Set<LocationBase> locations, boolean useSharedInternalContactDetails, boolean useSharedPublicContactDetails, boolean isSharedInternalContactPublic, ContactDetails sharedInternalContactDetails, ContactDetails sharedPublicContactDetails, Set<ArrangementsRecordEntry> arrangements, String requirements, String benefits, Set<Skill> skillsRequired, Set<Skill> skillsToGain, String description, String shortDescription, float monetaryValuePerHour, boolean isVirtualRemote, boolean isResidential, boolean isOneOff, boolean isDateSpecific, Date specificStartDate, Date specificEndDate, long commitmentAm, long commitmentPm, long commitmentEve, Set<CommitmentType> commitmentTypes, Set<TaggedData> tags, Set<CampaignsAndInitiatives> campaignsAndInitiatives, Set<TypeOfActivity> typeOfActivity, Set<CauseInterest> causesInterests, Date advertisingStartDate, Date advertisingEndDate, boolean publishToDoIt, boolean isActive, Set<Suitabilities> addSpecSuitabilities, Set<SelectionMethod> selectionMethods) {
        this.vbase2Id = vbase2Id;
        this.title = title;
        this.ownId = ownId;
        this.locationsPubliclyViewable = locationsPubliclyViewable;
        this.organisationId = organisationId;
        this.locations = locations;
        this.useSharedInternalContactDetails = useSharedInternalContactDetails;
        this.useSharedPublicContactDetails = useSharedPublicContactDetails;
        this.isSharedInternalContactPublic = isSharedInternalContactPublic;
        this.sharedInternalContactDetails = sharedInternalContactDetails;
        this.sharedPublicContactDetails = sharedPublicContactDetails;
        this.arrangements = arrangements;
        this.requirements = requirements;
        this.benefits = benefits;
        this.skillsRequired = skillsRequired;
        this.skillsToGain = skillsToGain;
        this.description = description;
        this.shortDescription = shortDescription;
        this.monetaryValuePerHour = monetaryValuePerHour;
        this.isVirtualRemote = isVirtualRemote;
        this.isResidential = isResidential;
        this.isOneOff = isOneOff;
        this.isDateSpecific = isDateSpecific;
        this.specificStartDate = specificStartDate;
        this.specificEndDate = specificEndDate;
        this.commitmentAm = commitmentAm;
        this.commitmentPm = commitmentPm;
        this.commitmentEve = commitmentEve;
        this.commitmentTypes = commitmentTypes;
        this.tags = tags;
        this.campaignsAndInitiatives = campaignsAndInitiatives;
        this.typeOfActivity = typeOfActivity;
        this.causesInterests = causesInterests;
        this.advertisingStartDate = advertisingStartDate;
        this.advertisingEndDate = advertisingEndDate;
        this.publishToDoIt = publishToDoIt;
        this.isActive = isActive;
        this.addSpecSuitabilities = addSpecSuitabilities;
        this.selectionMethods = selectionMethods;
    }


    public Integer getVbase2Id() {
        return this.vbase2Id;
    }


    public void setVbase2Id(Integer vbase2Id) {
        this.vbase2Id = vbase2Id;
    }


    public String getTitle() {
        return this.title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getOwnId() {
        return this.ownId;
    }


    public void setOwnId(String ownId) {
        this.ownId = ownId;
    }


    public boolean isLocationsPubliclyViewable() {
        return this.locationsPubliclyViewable;
    }


    public void setLocationsPubliclyViewable(boolean locationsPubliclyViewable) {
        this.locationsPubliclyViewable = locationsPubliclyViewable;
    }


    public Organisation getOrganisationId() {
        return this.organisationId;
    }


    public void setOrganisationId(Organisation organisationId) {
        this.organisationId = organisationId;
    }


    public Set<LocationBase> getLocations() {
        return this.locations;
    }


    public void setLocations(Set<LocationBase> locations) {
        this.locations = locations;
    }


    public boolean isUseSharedInternalContactDetails() {
        return this.useSharedInternalContactDetails;
    }


    public void setUseSharedInternalContactDetails(boolean useSharedInternalContactDetails) {
        this.useSharedInternalContactDetails = useSharedInternalContactDetails;
    }


    public boolean isUseSharedPublicContactDetails() {
        return this.useSharedPublicContactDetails;
    }


    public void setUseSharedPublicContactDetails(boolean useSharedPublicContactDetails) {
        this.useSharedPublicContactDetails = useSharedPublicContactDetails;
    }


    public boolean isIsSharedInternalContactPublic() {
        return this.isSharedInternalContactPublic;
    }


    public void setIsSharedInternalContactPublic(boolean isSharedInternalContactPublic) {
        this.isSharedInternalContactPublic = isSharedInternalContactPublic;
    }


    public ContactDetails getSharedInternalContactDetails() {
        return this.sharedInternalContactDetails;
    }


    public void setSharedInternalContactDetails(ContactDetails sharedInternalContactDetails) {
        this.sharedInternalContactDetails = sharedInternalContactDetails;
    }


    public ContactDetails getSharedPublicContactDetails() {
        return this.sharedPublicContactDetails;
    }


    public void setSharedPublicContactDetails(ContactDetails sharedPublicContactDetails) {
        this.sharedPublicContactDetails = sharedPublicContactDetails;
    }


    public Set<ArrangementsRecordEntry> getArrangements() {
        return this.arrangements;
    }


    public void setArrangements(Set<ArrangementsRecordEntry> arrangements) {
        this.arrangements = arrangements;
    }


    public String getRequirements() {
        return this.requirements;
    }


    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }


    public String getBenefits() {
        return this.benefits;
    }


    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }


    public Set<Skill> getSkillsRequired() {
        return this.skillsRequired;
    }


    public void setSkillsRequired(Set<Skill> skillsRequired) {
        this.skillsRequired = skillsRequired;
    }


    public Set<Skill> getSkillsToGain() {
        return this.skillsToGain;
    }


    public void setSkillsToGain(Set<Skill> skillsToGain) {
        this.skillsToGain = skillsToGain;
    }


    public String getDescription() {
        return this.description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getShortDescription() {
        return this.shortDescription;
    }


    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }


    public float getMonetaryValuePerHour() {
        return this.monetaryValuePerHour;
    }


    public void setMonetaryValuePerHour(float monetaryValuePerHour) {
        this.monetaryValuePerHour = monetaryValuePerHour;
    }


    public boolean isIsVirtualRemote() {
        return this.isVirtualRemote;
    }


    public void setIsVirtualRemote(boolean isVirtualRemote) {
        this.isVirtualRemote = isVirtualRemote;
    }


    public boolean isIsResidential() {
        return this.isResidential;
    }


    public void setIsResidential(boolean isResidential) {
        this.isResidential = isResidential;
    }


    public boolean isIsOneOff() {
        return this.isOneOff;
    }


    public void setIsOneOff(boolean isOneOff) {
        this.isOneOff = isOneOff;
    }


    public boolean isIsDateSpecific() {
        return this.isDateSpecific;
    }


    public void setIsDateSpecific(boolean isDateSpecific) {
        this.isDateSpecific = isDateSpecific;
    }


    public Date getSpecificStartDate() {
        return this.specificStartDate;
    }


    public void setSpecificStartDate(Date specificStartDate) {
        this.specificStartDate = specificStartDate;
    }


    public Date getSpecificEndDate() {
        return this.specificEndDate;
    }


    public void setSpecificEndDate(Date specificEndDate) {
        this.specificEndDate = specificEndDate;
    }


    public long getCommitmentAm() {
        return this.commitmentAm;
    }


    public void setCommitmentAm(long commitmentAm) {
        this.commitmentAm = commitmentAm;
    }


    public long getCommitmentPm() {
        return this.commitmentPm;
    }


    public void setCommitmentPm(long commitmentPm) {
        this.commitmentPm = commitmentPm;
    }


    public long getCommitmentEve() {
        return this.commitmentEve;
    }


    public void setCommitmentEve(long commitmentEve) {
        this.commitmentEve = commitmentEve;
    }


    public Set<CommitmentType> getCommitmentTypes() {
        return this.commitmentTypes;
    }


    public void setCommitmentTypes(Set<CommitmentType> commitmentTypes) {
        this.commitmentTypes = commitmentTypes;
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


    public Date getAdvertisingStartDate() {
        return this.advertisingStartDate;
    }


    public void setAdvertisingStartDate(Date advertisingStartDate) {
        this.advertisingStartDate = advertisingStartDate;
    }


    public Date getAdvertisingEndDate() {
        return this.advertisingEndDate;
    }


    public void setAdvertisingEndDate(Date advertisingEndDate) {
        this.advertisingEndDate = advertisingEndDate;
    }


    public boolean isPublishToDoIt() {
        return this.publishToDoIt;
    }


    public void setPublishToDoIt(boolean publishToDoIt) {
        this.publishToDoIt = publishToDoIt;
    }


    public boolean isIsActive() {
        return this.isActive;
    }


    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }


    public Set<Suitabilities> getAddSpecSuitabilities() {
        return this.addSpecSuitabilities;
    }


    public void setAddSpecSuitabilities(Set<Suitabilities> addSpecSuitabilities) {
        this.addSpecSuitabilities = addSpecSuitabilities;
    }


    public Set<SelectionMethod> getSelectionMethods() {
        return this.selectionMethods;
    }


    public void setSelectionMethods(Set<SelectionMethod> selectionMethods) {
        this.selectionMethods = selectionMethods;
    }
}
