package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.vb3.lookups.*;

import java.util.HashSet;
import java.util.Set;


public class Organisation extends GenericDTO {


    private Integer vbase2Id;
    private boolean isVuo;
    private String name;
    private String ownId;
    private String registeredCharityNumber;
    private Set<OrganisationContact> organisationContacts = new HashSet<OrganisationContact>(0);
    private Set<OrganisationAddress> organisationAddresses = new HashSet<OrganisationAddress>(0);
    private String missionStatement;
    private String description;
    private String openingHours;
    private Set<CauseInterest> causesInterests = new HashSet<CauseInterest>(0);
    private Set<OrganisationType> types = new HashSet<OrganisationType>(0);
    private Set<GeographicalArea> organisationGeographicalAreas = new HashSet<GeographicalArea>(0);
    private HowHeard howHeard;
    private String howHeardDetails;
    private Set<NewPolicyEntry> orgNewPolicyEntries = new HashSet<NewPolicyEntry>(0);
    private Set<QualityStdsAccrPolicyEntry> qualityStdsAccrPolicyEntries = new HashSet<QualityStdsAccrPolicyEntry>(0);
    private Set<TaggedData> tags = new HashSet<TaggedData>(0);
    private Set<CampaignsAndInitiatives> campaignsAndInitiatives = new HashSet<CampaignsAndInitiatives>(0);
    private boolean isActive;


    public Organisation() {
    }


    public Organisation(String name) {
        this.name = name;
    }


    public Organisation(Integer vbase2Id, boolean isVuo, String name, String ownId, String registeredCharityNumber, Set<OrganisationAddress> organisationAddresses, String missionStatement, String description, String openingHours, Set<CauseInterest> causesInterests, Set<OrganisationType> types, Set<GeographicalArea> organisationGeographicalAreas, HowHeard howHeard, String howHeardDetails, Set<NewPolicyEntry> orgNewPolicyEntries, Set<QualityStdsAccrPolicyEntry> qualityStdsAccrPolicyEntries, Set<TaggedData> tags, Set<CampaignsAndInitiatives> campaignsAndInitiatives) {
        this.vbase2Id = vbase2Id;
        this.isVuo = isVuo;
        this.name = name;
        this.ownId = ownId;
        this.registeredCharityNumber = registeredCharityNumber;
        this.organisationAddresses = organisationAddresses;
        this.missionStatement = missionStatement;
        this.description = description;
        this.openingHours = openingHours;
        this.causesInterests = causesInterests;
        this.types = types;
        this.organisationGeographicalAreas = organisationGeographicalAreas;
        this.howHeard = howHeard;
        this.howHeardDetails = howHeardDetails;
        this.orgNewPolicyEntries = orgNewPolicyEntries;
        this.qualityStdsAccrPolicyEntries = qualityStdsAccrPolicyEntries;
        this.tags = tags;
        this.campaignsAndInitiatives = campaignsAndInitiatives;
    }


    public Integer getVbase2Id() {
        return this.vbase2Id;
    }


    public void setVbase2Id(Integer vbase2Id) {
        this.vbase2Id = vbase2Id;
    }


    public boolean isIsVuo() {
        return this.isVuo;
    }


    public void setIsVuo(boolean isVuo) {
        this.isVuo = isVuo;
    }


    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getOwnId() {
        return this.ownId;
    }


    public void setOwnId(String ownId) {
        this.ownId = ownId;
    }


    public String getRegisteredCharityNumber() {
        return this.registeredCharityNumber;
    }


    public void setRegisteredCharityNumber(String registeredCharityNumber) {
        this.registeredCharityNumber = registeredCharityNumber;
    }


    public Set<OrganisationContact> getOrganisationContacts() {
    }


    public void setOrganisationContacts(Set<OrganisationContact> organisationContacts) {
        this.organisationContacts = organisationContacts;
    }


    public Set<OrganisationAddress> getOrganisationAddresses() {
        return this.organisationAddresses;
    }


    public void setOrganisationAddresses(Set<OrganisationAddress> organisationAddresses) {
        this.organisationAddresses = organisationAddresses;
    }


    public String getMissionStatement() {
        return this.missionStatement;
    }


    public void setMissionStatement(String missionStatement) {
        this.missionStatement = missionStatement;
    }


    public String getDescription() {
        return this.description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getOpeningHours() {
        return this.openingHours;
    }


    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }


    public Set<CauseInterest> getCausesInterests() {
        return this.causesInterests;
    }


    public void setCausesInterests(Set<CauseInterest> causesInterests) {
        this.causesInterests = causesInterests;
    }


    public Set<OrganisationType> getTypes() {
        return this.types;
    }


    public void setTypes(Set<OrganisationType> types) {
        this.types = types;
    }


    public Set<GeographicalArea> getOrganisationGeographicalAreas() {
        return this.organisationGeographicalAreas;
    }


    public void setOrganisationGeographicalAreas(Set<GeographicalArea> organisationGeographicalAreas) {
        this.organisationGeographicalAreas = organisationGeographicalAreas;
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


    public Set<NewPolicyEntry> getOrgNewPolicyEntries() {
        return this.orgNewPolicyEntries;
    }


    public void setOrgNewPolicyEntries(Set<NewPolicyEntry> orgNewPolicyEntries) {
        this.orgNewPolicyEntries = orgNewPolicyEntries;
    }


    public Set<QualityStdsAccrPolicyEntry> getQualityStdsAccrPolicyEntries() {
        return this.qualityStdsAccrPolicyEntries;
    }


    public void setQualityStdsAccrPolicyEntries(Set<QualityStdsAccrPolicyEntry> qualityStdsAccrPolicyEntries) {
        this.qualityStdsAccrPolicyEntries = qualityStdsAccrPolicyEntries;
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
}
