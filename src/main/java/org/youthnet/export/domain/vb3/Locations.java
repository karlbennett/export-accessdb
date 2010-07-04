package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Locations implements CSVable {

    private String delimiter = "|";
    private String enclosure = "¬";
    private Integer columnNum = 23;
    private List<String> columnNames = null;
    private StringBuffer record = new StringBuffer();

    private Boolean usecustomorgname;
    private UUID id;
    private Boolean deleted;
    private UUID orgaddressid;
    private UUID regionid;
    private String customorgname;
    private UUID addressid;
    private Boolean useforcontactdetails;
    private String displaystring;
    private UUID contactdetailsid;
    private Long version;
    private UUID modifiedby;
    private Boolean usecustomaddress;
    private UUID opportunitylocationid;
    private Boolean isactive;
    private Timestamp created;
    private String locationtype;
    private UUID createdby;
    private UUID publiccontactdetailsid;
    private String discriminator;
    private String publiccontactdetailssource;
    private Timestamp modified;
    private UUID countyid;

    public Locations() {
    }

    public Boolean getUseCustomOrgName() {
        return this.usecustomorgname;
    }

    public void setUseCustomOrgName(Boolean usecustomorgname) {
        this.usecustomorgname = usecustomorgname;
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

    public UUID getOrgAddressId() {
        return this.orgaddressid;
    }

    public void setOrgAddressId(UUID orgaddressid) {
        this.orgaddressid = orgaddressid;
    }

    public UUID getRegionId() {
        return this.regionid;
    }

    public void setRegionId(UUID regionid) {
        this.regionid = regionid;
    }

    public String getCustomOrgName() {
        return this.customorgname;
    }

    public void setCustomOrgName(String customorgname) {
        this.customorgname = customorgname;
    }

    public UUID getAddressId() {
        return this.addressid;
    }

    public void setAddressId(UUID addressid) {
        this.addressid = addressid;
    }

    public Boolean getUseForContactDetails() {
        return this.useforcontactdetails;
    }

    public void setUseForContactDetails(Boolean useforcontactdetails) {
        this.useforcontactdetails = useforcontactdetails;
    }

    public String getDisplayString() {
        return this.displaystring;
    }

    public void setDisplayString(String displaystring) {
        this.displaystring = displaystring;
    }

    public UUID getContactDetailsId() {
        return this.contactdetailsid;
    }

    public void setContactDetailsId(UUID contactdetailsid) {
        this.contactdetailsid = contactdetailsid;
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

    public Boolean getUseCustomAddress() {
        return this.usecustomaddress;
    }

    public void setUseCustomAddress(Boolean usecustomaddress) {
        this.usecustomaddress = usecustomaddress;
    }

    public Boolean getIsActive() {
        return this.isactive;
    }

    public void setIsActive(Boolean isactive) {
        this.isactive = isactive;
    }

    public UUID getOpportunityLocationId() {
        return this.opportunitylocationid;
    }

    public void setOpportunityLocationId(UUID opportunitylocationid) {
        this.opportunitylocationid = opportunitylocationid;
    }

    public String getLocationType() {
        return this.locationtype;
    }

    public void setLocationType(String locationtype) {
        this.locationtype = locationtype;
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

    public UUID getPublicContactDetailsId() {
        return this.publiccontactdetailsid;
    }

    public void setPublicContactDetailsId(UUID publiccontactdetailsid) {
        this.publiccontactdetailsid = publiccontactdetailsid;
    }

    public String getPublicContactDetailsSource() {
        return this.publiccontactdetailssource;
    }

    public void setPublicContactDetailsSource(String publiccontactdetailssource) {
        this.publiccontactdetailssource = publiccontactdetailssource;
    }

    public String getDiscriminator() {
        return this.discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public UUID getCountyId() {
        return this.countyid;
    }

    public void setCountyId(UUID countyid) {
        this.countyid = countyid;
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
            this.columnNames.add("UseCustomOrgName");
            this.columnNames.add("Id");
            this.columnNames.add("Deleted");
            this.columnNames.add("OrgAddressId");
            this.columnNames.add("RegionId");
            this.columnNames.add("CustomOrgName");
            this.columnNames.add("AddressId");
            this.columnNames.add("UseForContactDetails");
            this.columnNames.add("DisplayString");
            this.columnNames.add("ContactDetailsId");
            this.columnNames.add("Version");
            this.columnNames.add("ModifiedBy");
            this.columnNames.add("UseCustomAddress");
            this.columnNames.add("OpportunityLocationId");
            this.columnNames.add("IsActive");
            this.columnNames.add("Created");
            this.columnNames.add("LocationType");
            this.columnNames.add("CreatedBy");
            this.columnNames.add("PublicContactDetailsId");
            this.columnNames.add("Discriminator");
            this.columnNames.add("PublicContactDetailsSource");
            this.columnNames.add("Modified");
            this.columnNames.add("CountyId");
        }

        return this.columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.usecustomorgname);
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
        record.append(this.orgaddressid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.regionid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.customorgname);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.addressid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.useforcontactdetails);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.displaystring);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.contactdetailsid.toString().replace("-", ""));
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
        record.append(this.usecustomaddress);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.opportunitylocationid.toString().replace("-", ""));
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
        record.append(this.locationtype);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.createdby.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.publiccontactdetailsid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.discriminator);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.publiccontactdetailssource);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.modified);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.countyid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
