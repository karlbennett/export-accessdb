package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Opportunities implements CSVable, ContainsVb2id {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 35;
    private List<String[]> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

    private String benefits;
    private Long commitmentam;
    private Long commitmenteve;
    private Boolean isvirtualremote;
    private Long commitmentpm;
    private Boolean locationspubliclyviewable;
    private String description;
    private Float monetaryvalueperhour;
    private Boolean isactive;
    private Boolean usesharedintcondets;
    private String ownid;
    private Boolean isdatespecific;
    private Boolean usesharedpubliccontactdetails;
    private Boolean publishtodoit;
    private Boolean isoneoff;
    private Long vbase2id;
    private String requirements;
    private Boolean isresidential;
    private UUID organisationid;
    private String shortdescription;
    private Boolean issharedinternalcontactpublic;
    private UUID sharedinternalcontactdetailsid;
    private Timestamp specificenddate;
    private UUID sharedpubliccontactdetailsid;
    private Timestamp specificstartdate;
    private String title;
    private UUID id;
    private Timestamp created;
    private UUID createdby;
    private Boolean deleted;
    private Timestamp modified;
    private UUID modifiedby;
    private Long version;
    private Timestamp advertisingenddate;
    private Timestamp advertisingstartdate;

    public Opportunities() {
    }

    public Opportunities(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));
        StringBuffer uuidStringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");


        this.benefits = fields[0].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.commitmentam = (fields[1].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[1].replace(String.valueOf(this.enclosure), ""));

        this.commitmenteve = (fields[2].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[2].replace(String.valueOf(this.enclosure), ""));

        this.isvirtualremote = fields[3].replace(String.valueOf(this.enclosure), "").equals("1");

        this.commitmentpm = (fields[4].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[4].replace(String.valueOf(this.enclosure), ""));

        this.locationspubliclyviewable = fields[5].replace(String.valueOf(this.enclosure), "").equals("1");

        this.description = fields[6].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.monetaryvalueperhour = (fields[7].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Float.valueOf(fields[7].replace(String.valueOf(this.enclosure), ""));

        this.isactive = fields[8].replace(String.valueOf(this.enclosure), "").equals("1");

        this.usesharedintcondets = fields[9].replace(String.valueOf(this.enclosure), "").equals("1");

        this.ownid = fields[10].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.isdatespecific = fields[11].replace(String.valueOf(this.enclosure), "").equals("1");

        this.usesharedpubliccontactdetails = fields[12].replace(String.valueOf(this.enclosure), "").equals("1");

        this.publishtodoit = fields[13].replace(String.valueOf(this.enclosure), "").equals("1");

        this.isoneoff = fields[14].replace(String.valueOf(this.enclosure), "").equals("1");

        this.vbase2id = (fields[15].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[15].replace(String.valueOf(this.enclosure), ""));

        this.requirements = fields[16].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.isresidential = fields[17].replace(String.valueOf(this.enclosure), "").equals("1");

        if (fields[18].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.organisationid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[18].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.organisationid = UUID.fromString(uuidStringBuffer.toString());
        }

        this.shortdescription = fields[19].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.issharedinternalcontactpublic = fields[20].replace(String.valueOf(this.enclosure), "").equals("1");

        if (fields[21].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.sharedinternalcontactdetailsid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[21].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.sharedinternalcontactdetailsid = UUID.fromString(uuidStringBuffer.toString());
        }

        try {
            this.specificenddate = (fields[22].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[22].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp specificenddate " + fields[22].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        if (fields[23].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.sharedpubliccontactdetailsid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[23].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.sharedpubliccontactdetailsid = UUID.fromString(uuidStringBuffer.toString());
        }

        try {
            this.specificstartdate = (fields[24].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[24].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp specificstartdate " + fields[24].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        this.title = fields[25].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        if (fields[26].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.id = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[26].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.id = UUID.fromString(uuidStringBuffer.toString());
        }

        try {
            this.created = (fields[27].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[27].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp created " + fields[27].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        if (fields[28].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.createdby = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[28].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.createdby = UUID.fromString(uuidStringBuffer.toString());
        }

        this.deleted = fields[29].replace(String.valueOf(this.enclosure), "").equals("1");

        try {
            this.modified = (fields[30].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[30].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp modified " + fields[30].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        if (fields[31].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.modifiedby = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[31].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.modifiedby = UUID.fromString(uuidStringBuffer.toString());
        }

        this.version = (fields[32].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[32].replace(String.valueOf(this.enclosure), ""));

        try {
            this.advertisingenddate = (fields[33].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[33].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp advertisingenddate " + fields[33].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        try {
            this.advertisingstartdate = (fields[34].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[34].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp advertisingstartdate " + fields[34].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

    }


    public String getBenefits() {
        return this.benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public Long getCommitmentAm() {
        return this.commitmentam;
    }

    public void setCommitmentAm(Long commitmentam) {
        this.commitmentam = commitmentam;
    }

    public Long getCommitmentEve() {
        return this.commitmenteve;
    }

    public void setCommitmentEve(Long commitmenteve) {
        this.commitmenteve = commitmenteve;
    }

    public Boolean getIsVirtualRemote() {
        return this.isvirtualremote;
    }

    public void setIsVirtualRemote(Boolean isvirtualremote) {
        this.isvirtualremote = isvirtualremote;
    }

    public Long getCommitmentPm() {
        return this.commitmentpm;
    }

    public void setCommitmentPm(Long commitmentpm) {
        this.commitmentpm = commitmentpm;
    }

    public Boolean getLocationsPubliclyViewable() {
        return this.locationspubliclyviewable;
    }

    public void setLocationsPubliclyViewable(Boolean locationspubliclyviewable) {
        this.locationspubliclyviewable = locationspubliclyviewable;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getMonetaryValuePerHour() {
        return this.monetaryvalueperhour;
    }

    public void setMonetaryValuePerHour(Float monetaryvalueperhour) {
        this.monetaryvalueperhour = monetaryvalueperhour;
    }

    public Boolean getIsActive() {
        return this.isactive;
    }

    public void setIsActive(Boolean isactive) {
        this.isactive = isactive;
    }

    public Boolean getUseSharedIntConDets() {
        return this.usesharedintcondets;
    }

    public void setUseSharedIntConDets(Boolean usesharedintcondets) {
        this.usesharedintcondets = usesharedintcondets;
    }

    public String getOwnId() {
        return this.ownid;
    }

    public void setOwnId(String ownid) {
        this.ownid = ownid;
    }

    public Boolean getIsDateSpecific() {
        return this.isdatespecific;
    }

    public void setIsDateSpecific(Boolean isdatespecific) {
        this.isdatespecific = isdatespecific;
    }

    public Boolean getUseSharedPublicContactDetails() {
        return this.usesharedpubliccontactdetails;
    }

    public void setUseSharedPublicContactDetails(Boolean usesharedpubliccontactdetails) {
        this.usesharedpubliccontactdetails = usesharedpubliccontactdetails;
    }

    public Boolean getPublishToDoIt() {
        return this.publishtodoit;
    }

    public void setPublishToDoIt(Boolean publishtodoit) {
        this.publishtodoit = publishtodoit;
    }

    public Boolean getIsOneOff() {
        return this.isoneoff;
    }

    public void setIsOneOff(Boolean isoneoff) {
        this.isoneoff = isoneoff;
    }

    public Long getVbase2Id() {
        return this.vbase2id;
    }

    public void setVbase2Id(Long vbase2id) {
        this.vbase2id = vbase2id;
    }

    public String getRequirements() {
        return this.requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Boolean getIsResidential() {
        return this.isresidential;
    }

    public void setIsResidential(Boolean isresidential) {
        this.isresidential = isresidential;
    }

    public UUID getOrganisationId() {
        return this.organisationid;
    }

    public void setOrganisationId(UUID organisationid) {
        this.organisationid = organisationid;
    }

    public String getShortDescription() {
        return this.shortdescription;
    }

    public void setShortDescription(String shortdescription) {
        this.shortdescription = shortdescription;
    }

    public Boolean getIsSharedInternalContactPublic() {
        return this.issharedinternalcontactpublic;
    }

    public void setIsSharedInternalContactPublic(Boolean issharedinternalcontactpublic) {
        this.issharedinternalcontactpublic = issharedinternalcontactpublic;
    }

    public UUID getSharedInternalContactDetailsId() {
        return this.sharedinternalcontactdetailsid;
    }

    public void setSharedInternalContactDetailsId(UUID sharedinternalcontactdetailsid) {
        this.sharedinternalcontactdetailsid = sharedinternalcontactdetailsid;
    }

    public Timestamp getSpecificEndDate() {
        return this.specificenddate;
    }

    public void setSpecificEndDate(Timestamp specificenddate) {
        this.specificenddate = specificenddate;
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Timestamp getAdvertisingEndDate() {
        return this.advertisingenddate;
    }

    public void setAdvertisingEndDate(Timestamp advertisingenddate) {
        this.advertisingenddate = advertisingenddate;
    }

    public Timestamp getAdvertisingStartDate() {
        return this.advertisingstartdate;
    }

    public void setAdvertisingStartDate(Timestamp advertisingstartdate) {
        this.advertisingstartdate = advertisingstartdate;
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
            this.columnNames.add(new String[]{"Benefits", "String"});
            this.columnNames.add(new String[]{"CommitmentAm", "Long"});
            this.columnNames.add(new String[]{"CommitmentEve", "Long"});
            this.columnNames.add(new String[]{"IsVirtualRemote", "Boolean"});
            this.columnNames.add(new String[]{"CommitmentPm", "Long"});
            this.columnNames.add(new String[]{"LocationsPubliclyViewable", "Boolean"});
            this.columnNames.add(new String[]{"Description", "String"});
            this.columnNames.add(new String[]{"MonetaryValuePerHour", "Float"});
            this.columnNames.add(new String[]{"IsActive", "Boolean"});
            this.columnNames.add(new String[]{"UseSharedIntConDets", "Boolean"});
            this.columnNames.add(new String[]{"OwnId", "String"});
            this.columnNames.add(new String[]{"IsDateSpecific", "Boolean"});
            this.columnNames.add(new String[]{"UseSharedPublicContactDetails", "Boolean"});
            this.columnNames.add(new String[]{"PublishToDoIt", "Boolean"});
            this.columnNames.add(new String[]{"IsOneOff", "Boolean"});
            this.columnNames.add(new String[]{"Vbase2Id", "Long"});
            this.columnNames.add(new String[]{"Requirements", "String"});
            this.columnNames.add(new String[]{"IsResidential", "Boolean"});
            this.columnNames.add(new String[]{"OrganisationId", "UUID"});
            this.columnNames.add(new String[]{"ShortDescription", "String"});
            this.columnNames.add(new String[]{"IsSharedInternalContactPublic", "Boolean"});
            this.columnNames.add(new String[]{"SharedInternalContactDetailsId", "UUID"});
            this.columnNames.add(new String[]{"SpecificEndDate", "Timestamp"});
            this.columnNames.add(new String[]{"SharedPublicContactDetailsId", "UUID"});
            this.columnNames.add(new String[]{"SpecificStartDate", "Timestamp"});
            this.columnNames.add(new String[]{"Title", "String"});
            this.columnNames.add(new String[]{"Id", "UUID"});
            this.columnNames.add(new String[]{"Created", "Timestamp"});
            this.columnNames.add(new String[]{"CreatedBy", "UUID"});
            this.columnNames.add(new String[]{"Deleted", "Boolean"});
            this.columnNames.add(new String[]{"Modified", "Timestamp"});
            this.columnNames.add(new String[]{"ModifiedBy", "UUID"});
            this.columnNames.add(new String[]{"Version", "Long"});
            this.columnNames.add(new String[]{"AdvertisingEndDate", "Timestamp"});
            this.columnNames.add(new String[]{"AdvertisingStartDate", "Timestamp"});
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.benefits == null ? "" :
                this.benefits.length() < 240 ? this.benefits.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.benefits.substring(0, 240).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.commitmentam == null ? "" : this.commitmentam);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.commitmenteve == null ? "" : this.commitmenteve);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.isvirtualremote != null && this.isvirtualremote ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.commitmentpm == null ? "" : this.commitmentpm);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.locationspubliclyviewable != null && this.locationspubliclyviewable ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.description == null ? "" :
                this.description.length() < 240 ? this.description.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.description.substring(0, 240).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.monetaryvalueperhour == null ? "" : this.monetaryvalueperhour);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.isactive != null && this.isactive ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.usesharedintcondets != null && this.usesharedintcondets ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.ownid == null ? "" :
                this.ownid.length() < 240 ? this.ownid.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.ownid.substring(0, 240).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.isdatespecific != null && this.isdatespecific ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.usesharedpubliccontactdetails != null && this.usesharedpubliccontactdetails ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.publishtodoit != null && this.publishtodoit ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.isoneoff != null && this.isoneoff ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.vbase2id == null ? "" : this.vbase2id);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.requirements == null ? "" :
                this.requirements.length() < 240 ? this.requirements.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.requirements.substring(0, 240).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.isresidential != null && this.isresidential ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.organisationid == null ? "" : this.organisationid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.shortdescription == null ? "" :
                this.shortdescription.length() < 240 ? this.shortdescription.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.shortdescription.substring(0, 240).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.issharedinternalcontactpublic != null && this.issharedinternalcontactpublic ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.sharedinternalcontactdetailsid == null ? "" : this.sharedinternalcontactdetailsid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.specificenddate == null ? "" : this.specificenddate);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.sharedpubliccontactdetailsid == null ? "" : this.sharedpubliccontactdetailsid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.specificstartdate == null ? "" : this.specificstartdate);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.title == null ? "" :
                this.title.length() < 240 ? this.title.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.title.substring(0, 240).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
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
        recordStringBuffer.append(this.advertisingenddate == null ? "" : this.advertisingenddate);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.advertisingstartdate == null ? "" : this.advertisingstartdate);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
