package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Opportunities implements CSVable {

    private String delimiter = "|";
    private String enclosure = "¬";
    private Integer columnNum = 35;
    private List<String> columnNames = null;
    private StringBuffer record = new StringBuffer();

    private UUID sharedinternalcontactdetailsid;
    private UUID sharedpubliccontactdetailsid;
    private Timestamp specificstartdate;
    private String shortdescription;
    private String ownid;
    private String benefits;
    private Timestamp advertisingstartdate;
    private Long commitmenteve;
    private UUID id;
    private Boolean isdatespecific;
    private Boolean deleted;
    private Long vbase2id;
    private Boolean isvirtualremote;
    private UUID organisationid;
    private Boolean publishtodoit;
    private Long version;
    private String title;
    private UUID modifiedby;
    private Long commitmentpm;
    private Boolean isactive;
    private Boolean isoneoff;
    private Timestamp created;
    private Boolean isresidential;
    private UUID createdby;
    private String description;
    private Boolean usesharedintcondets;
    private Timestamp specificenddate;
    private Long commitmentam;
    private Timestamp advertisingenddate;
    private Boolean issharedinternalcontactpublic;
    private Timestamp modified;
    private String requirements;
    private Float monetaryvalueperhour;
    private Boolean usesharedpubliccontactdetails;
    private Boolean locationspubliclyviewable;

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

    public String getBenefits() {
        return this.benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getOwnId() {
        return this.ownid;
    }

    public void setOwnId(String ownid) {
        this.ownid = ownid;
    }

    public String getShortDescription() {
        return this.shortdescription;
    }

    public void setShortDescription(String shortdescription) {
        this.shortdescription = shortdescription;
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

    public Boolean getIsDateSpecific() {
        return this.isdatespecific;
    }

    public void setIsDateSpecific(Boolean isdatespecific) {
        this.isdatespecific = isdatespecific;
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

    public Boolean getIsVirtualRemote() {
        return this.isvirtualremote;
    }

    public void setIsVirtualRemote(Boolean isvirtualremote) {
        this.isvirtualremote = isvirtualremote;
    }

    public Long getVbase2Id() {
        return this.vbase2id;
    }

    public void setVbase2Id(Long vbase2id) {
        this.vbase2id = vbase2id;
    }

    public Boolean getPublishToDoIt() {
        return this.publishtodoit;
    }

    public void setPublishToDoIt(Boolean publishtodoit) {
        this.publishtodoit = publishtodoit;
    }

    public UUID getOrganisationId() {
        return this.organisationid;
    }

    public void setOrganisationId(UUID organisationid) {
        this.organisationid = organisationid;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Boolean getIsResidential() {
        return this.isresidential;
    }

    public void setIsResidential(Boolean isresidential) {
        this.isresidential = isresidential;
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

    public Boolean getIsSharedInternalContactPublic() {
        return this.issharedinternalcontactpublic;
    }

    public void setIsSharedInternalContactPublic(Boolean issharedinternalcontactpublic) {
        this.issharedinternalcontactpublic = issharedinternalcontactpublic;
    }

    public Timestamp getAdvertisingEndDate() {
        return this.advertisingenddate;
    }

    public void setAdvertisingEndDate(Timestamp advertisingenddate) {
        this.advertisingenddate = advertisingenddate;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public Float getMonetaryValuePerHour() {
        return this.monetaryvalueperhour;
    }

    public void setMonetaryValuePerHour(Float monetaryvalueperhour) {
        this.monetaryvalueperhour = monetaryvalueperhour;
    }

    public String getRequirements() {
        return this.requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
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
            this.columnNames.add("SharedInternalContactDetailsId");
            this.columnNames.add("SharedPublicContactDetailsId");
            this.columnNames.add("SpecificStartDate");
            this.columnNames.add("ShortDescription");
            this.columnNames.add("OwnId");
            this.columnNames.add("Benefits");
            this.columnNames.add("AdvertisingStartDate");
            this.columnNames.add("CommitmentEve");
            this.columnNames.add("Id");
            this.columnNames.add("IsDateSpecific");
            this.columnNames.add("Deleted");
            this.columnNames.add("Vbase2Id");
            this.columnNames.add("IsVirtualRemote");
            this.columnNames.add("OrganisationId");
            this.columnNames.add("PublishToDoIt");
            this.columnNames.add("Version");
            this.columnNames.add("Title");
            this.columnNames.add("ModifiedBy");
            this.columnNames.add("CommitmentPm");
            this.columnNames.add("IsActive");
            this.columnNames.add("IsOneOff");
            this.columnNames.add("Created");
            this.columnNames.add("IsResidential");
            this.columnNames.add("CreatedBy");
            this.columnNames.add("Description");
            this.columnNames.add("UseSharedIntConDets");
            this.columnNames.add("SpecificEndDate");
            this.columnNames.add("CommitmentAm");
            this.columnNames.add("AdvertisingEndDate");
            this.columnNames.add("IsSharedInternalContactPublic");
            this.columnNames.add("Modified");
            this.columnNames.add("Requirements");
            this.columnNames.add("MonetaryValuePerHour");
            this.columnNames.add("UseSharedPublicContactDetails");
            this.columnNames.add("LocationsPubliclyViewable");
        }

        return this.columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.sharedinternalcontactdetailsid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.sharedpubliccontactdetailsid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.specificstartdate);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.shortdescription);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.ownid);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.benefits);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.advertisingstartdate);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.commitmenteve);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.id.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.isdatespecific);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.deleted);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.vbase2id);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.isvirtualremote);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.organisationid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.publishtodoit);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.version);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.title);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.modifiedby.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.commitmentpm);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.isactive);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.isoneoff);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.created);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.isresidential);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.createdby.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.description);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.usesharedintcondets);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.specificenddate);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.commitmentam);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.advertisingenddate);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.issharedinternalcontactpublic);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.modified);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.requirements);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.monetaryvalueperhour);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.usesharedpubliccontactdetails);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.locationspubliclyviewable);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
