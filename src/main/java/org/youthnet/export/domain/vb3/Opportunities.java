package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Opportunities implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 35;
    private List<String> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

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

    public Opportunities(String record) {
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
        this.sharedinternalcontactdetailsid = UUID.fromString(uuidStringBuffer.toString());

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[1].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.sharedpubliccontactdetailsid = UUID.fromString(uuidStringBuffer.toString());

        try {
            this.specificstartdate = new Timestamp(simpleDateFormat.parse(fields[2].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp specificstartdate " + fields[2].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        this.benefits = fields[3].replace(String.valueOf(this.enclosure), "");

        this.ownid = fields[4].replace(String.valueOf(this.enclosure), "");

        this.shortdescription = fields[5].replace(String.valueOf(this.enclosure), "");

        try {
            this.advertisingstartdate = new Timestamp(simpleDateFormat.parse(fields[6].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp advertisingstartdate " + fields[6].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        this.commitmenteve = Long.valueOf(fields[7].replace(String.valueOf(this.enclosure), ""));

        this.isdatespecific = fields[8].replace(String.valueOf(this.enclosure), "").equals("1");

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[9].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.id = UUID.fromString(uuidStringBuffer.toString());

        this.deleted = fields[10].replace(String.valueOf(this.enclosure), "").equals("1");

        this.isvirtualremote = fields[11].replace(String.valueOf(this.enclosure), "").equals("1");

        this.vbase2id = Long.valueOf(fields[12].replace(String.valueOf(this.enclosure), ""));

        this.publishtodoit = fields[13].replace(String.valueOf(this.enclosure), "").equals("1");

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[14].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.organisationid = UUID.fromString(uuidStringBuffer.toString());

        this.title = fields[15].replace(String.valueOf(this.enclosure), "");

        this.version = Long.valueOf(fields[16].replace(String.valueOf(this.enclosure), ""));

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[17].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.modifiedby = UUID.fromString(uuidStringBuffer.toString());

        this.commitmentpm = Long.valueOf(fields[18].replace(String.valueOf(this.enclosure), ""));

        this.isactive = fields[19].replace(String.valueOf(this.enclosure), "").equals("1");

        this.isoneoff = fields[20].replace(String.valueOf(this.enclosure), "").equals("1");

        this.isresidential = fields[21].replace(String.valueOf(this.enclosure), "").equals("1");

        try {
            this.created = new Timestamp(simpleDateFormat.parse(fields[22].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp created " + fields[22].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[23].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.createdby = UUID.fromString(uuidStringBuffer.toString());

        this.description = fields[24].replace(String.valueOf(this.enclosure), "");

        this.usesharedintcondets = fields[25].replace(String.valueOf(this.enclosure), "").equals("1");

        try {
            this.specificenddate = new Timestamp(simpleDateFormat.parse(fields[26].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp specificenddate " + fields[26].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        this.commitmentam = Long.valueOf(fields[27].replace(String.valueOf(this.enclosure), ""));

        this.issharedinternalcontactpublic = fields[28].replace(String.valueOf(this.enclosure), "").equals("1");

        try {
            this.advertisingenddate = new Timestamp(simpleDateFormat.parse(fields[29].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp advertisingenddate " + fields[29].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        try {
            this.modified = new Timestamp(simpleDateFormat.parse(fields[30].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp modified " + fields[30].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        this.monetaryvalueperhour = Float.valueOf(fields[31].replace(String.valueOf(this.enclosure), ""));

        this.requirements = fields[32].replace(String.valueOf(this.enclosure), "");

        this.usesharedpubliccontactdetails = fields[33].replace(String.valueOf(this.enclosure), "").equals("1");

        this.locationspubliclyviewable = fields[34].replace(String.valueOf(this.enclosure), "").equals("1");

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
            this.columnNames.add("SharedInternalContactDetailsId");
            this.columnNames.add("SharedPublicContactDetailsId");
            this.columnNames.add("SpecificStartDate");
            this.columnNames.add("Benefits");
            this.columnNames.add("OwnId");
            this.columnNames.add("ShortDescription");
            this.columnNames.add("AdvertisingStartDate");
            this.columnNames.add("CommitmentEve");
            this.columnNames.add("IsDateSpecific");
            this.columnNames.add("Id");
            this.columnNames.add("Deleted");
            this.columnNames.add("IsVirtualRemote");
            this.columnNames.add("Vbase2Id");
            this.columnNames.add("PublishToDoIt");
            this.columnNames.add("OrganisationId");
            this.columnNames.add("Title");
            this.columnNames.add("Version");
            this.columnNames.add("ModifiedBy");
            this.columnNames.add("CommitmentPm");
            this.columnNames.add("IsActive");
            this.columnNames.add("IsOneOff");
            this.columnNames.add("IsResidential");
            this.columnNames.add("Created");
            this.columnNames.add("CreatedBy");
            this.columnNames.add("Description");
            this.columnNames.add("UseSharedIntConDets");
            this.columnNames.add("SpecificEndDate");
            this.columnNames.add("CommitmentAm");
            this.columnNames.add("IsSharedInternalContactPublic");
            this.columnNames.add("AdvertisingEndDate");
            this.columnNames.add("Modified");
            this.columnNames.add("MonetaryValuePerHour");
            this.columnNames.add("Requirements");
            this.columnNames.add("UseSharedPublicContactDetails");
            this.columnNames.add("LocationsPubliclyViewable");
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.sharedinternalcontactdetailsid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.sharedpubliccontactdetailsid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.specificstartdate);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.benefits);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.ownid);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.shortdescription);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.advertisingstartdate);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.commitmenteve);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(isdatespecific ? 1 : 0);
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
        recordStringBuffer.append(isvirtualremote ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.vbase2id);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(publishtodoit ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.organisationid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.title);
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
        recordStringBuffer.append(this.commitmentpm);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(isactive ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(isoneoff ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(isresidential ? 1 : 0);
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
        recordStringBuffer.append(usesharedintcondets ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.specificenddate);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.commitmentam);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(issharedinternalcontactpublic ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.advertisingenddate);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.modified);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.monetaryvalueperhour);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.requirements);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(usesharedpubliccontactdetails ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(locationspubliclyviewable ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
