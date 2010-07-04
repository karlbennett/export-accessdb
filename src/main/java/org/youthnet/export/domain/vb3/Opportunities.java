package org.youthnet.export.domain.vb3;


import java.sql.Timestamp;
import java.util.UUID;


public class Opportunities {

    private UUID sharedinternalcontactdetailsid;
    private UUID sharedpubliccontactdetailsid;
    private Long version;
    private String title;
    private Timestamp specificstartdate;
    private String ownid;
    private Timestamp advertisingstartdate;
    private Boolean isoneoff;
    private Long commitmenteve;
    private Timestamp created;
    private Boolean isdatespecific;
    private String description;
    private Boolean usesharedintcondets;
    private Long vbase2id;
    private Boolean isvirtualremote;
    private UUID organisationid;
    private Timestamp modified;
    private String requirements;
    private Boolean locationspubliclyviewable;
    private UUID modifiedby;
    private String shortdescription;
    private String benefits;
    private Long commitmentpm;
    private Boolean isactive;
    private UUID id;
    private Boolean isresidential;
    private Boolean deleted;
    private UUID createdby;
    private Timestamp specificenddate;
    private Long commitmentam;
    private Timestamp advertisingenddate;
    private Boolean issharedinternalcontactpublic;
    private Boolean publishtodoit;
    private Float monetaryvalueperhour;
    private Boolean usesharedpubliccontactdetails;

    public Opportunities() {
    }

    public UUID getSharedInternalContactDetailsId() {
        return this.sharedinternalcontactdetailsid;
    }

    public void setSharedInternalContactDetailsId(UUID sharedinternalcontactdetailsid) {
        this.sharedinternalcontactdetailsid = sharedinternalcontactdetailsid;
    }

    public UUID getSharedPublicContactDetailsId() {
        return this.sharedpubliccontactdetailsid;
    }

    public void setSharedPublicContactDetailsId(UUID sharedpubliccontactdetailsid) {
        this.sharedpubliccontactdetailsid = sharedpubliccontactdetailsid;
    }

    public Timestamp getSpecificStartDate() {
        return this.specificstartdate;
    }

    public void setSpecificStartDate(Timestamp specificstartdate) {
        this.specificstartdate = specificstartdate;
    }

    public String getShortDescription() {
        return this.shortdescription;
    }

    public void setShortDescription(String shortdescription) {
        this.shortdescription = shortdescription;
    }

    public String getOwnId() {
        return this.ownid;
    }

    public void setOwnId(String ownid) {
        this.ownid = ownid;
    }

    public String getBenefits() {
        return this.benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public Timestamp getAdvertisingStartDate() {
        return this.advertisingstartdate;
    }

    public void setAdvertisingStartDate(Timestamp advertisingstartdate) {
        this.advertisingstartdate = advertisingstartdate;
    }

    public Long getCommitmentEve() {
        return this.commitmenteve;
    }

    public void setCommitmentEve(Long commitmenteve) {
        this.commitmenteve = commitmenteve;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getIsDateSpecific() {
        return this.isdatespecific;
    }

    public void setIsDateSpecific(Boolean isdatespecific) {
        this.isdatespecific = isdatespecific;
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

    public Boolean getIsVirtualRemote() {
        return this.isvirtualremote;
    }

    public void setIsVirtualRemote(Boolean isvirtualremote) {
        this.isvirtualremote = isvirtualremote;
    }

    public UUID getOrganisationId() {
        return this.organisationid;
    }

    public void setOrganisationId(UUID organisationid) {
        this.organisationid = organisationid;
    }

    public Boolean getPublishToDoIt() {
        return this.publishtodoit;
    }

    public void setPublishToDoIt(Boolean publishtodoit) {
        this.publishtodoit = publishtodoit;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getModifiedBy() {
        return this.modifiedby;
    }

    public void setModifiedBy(UUID modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Long getCommitmentPm() {
        return this.commitmentpm;
    }

    public void setCommitmentPm(Long commitmentpm) {
        this.commitmentpm = commitmentpm;
    }

    public Boolean getIsActive() {
        return this.isactive;
    }

    public void setIsActive(Boolean isactive) {
        this.isactive = isactive;
    }

    public Boolean getIsOneOff() {
        return this.isoneoff;
    }

    public void setIsOneOff(Boolean isoneoff) {
        this.isoneoff = isoneoff;
    }

    public Timestamp getCreated() {
        return this.created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Boolean getIsResidential() {
        return this.isresidential;
    }

    public void setIsResidential(Boolean isresidential) {
        this.isresidential = isresidential;
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

    public Boolean getUseSharedIntConDets() {
        return this.usesharedintcondets;
    }

    public void setUseSharedIntConDets(Boolean usesharedintcondets) {
        this.usesharedintcondets = usesharedintcondets;
    }

    public Timestamp getSpecificEndDate() {
        return this.specificenddate;
    }

    public void setSpecificEndDate(Timestamp specificenddate) {
        this.specificenddate = specificenddate;
    }

    public Long getCommitmentAm() {
        return this.commitmentam;
    }

    public void setCommitmentAm(Long commitmentam) {
        this.commitmentam = commitmentam;
    }

    public Timestamp getAdvertisingEndDate() {
        return this.advertisingenddate;
    }

    public void setAdvertisingEndDate(Timestamp advertisingenddate) {
        this.advertisingenddate = advertisingenddate;
    }

    public Boolean getIsSharedInternalContactPublic() {
        return this.issharedinternalcontactpublic;
    }

    public void setIsSharedInternalContactPublic(Boolean issharedinternalcontactpublic) {
        this.issharedinternalcontactpublic = issharedinternalcontactpublic;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public String getRequirements() {
        return this.requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Float getMonetaryValuePerHour() {
        return this.monetaryvalueperhour;
    }

    public void setMonetaryValuePerHour(Float monetaryvalueperhour) {
        this.monetaryvalueperhour = monetaryvalueperhour;
    }

    public Boolean getUseSharedPublicContactDetails() {
        return this.usesharedpubliccontactdetails;
    }

    public void setUseSharedPublicContactDetails(Boolean usesharedpubliccontactdetails) {
        this.usesharedpubliccontactdetails = usesharedpubliccontactdetails;
    }

    public Boolean getLocationsPubliclyViewable() {
        return this.locationspubliclyviewable;
    }

    public void setLocationsPubliclyViewable(Boolean locationspubliclyviewable) {
        this.locationspubliclyviewable = locationspubliclyviewable;
    }
}
