package org.youthnet.export.domain.vb3;


import java.sql.Timestamp;
import java.util.UUID;


public class Locations {

    private Long version;
    private Timestamp created;
    private UUID regionid;
    private String discriminator;
    private String publiccontactdetailssource;
    private String customorgname;
    private UUID addressid;
    private Boolean useforcontactdetails;
    private Timestamp modified;
    private UUID contactdetailsid;
    private UUID modifiedby;
    private Boolean usecustomorgname;
    private Boolean usecustomaddress;
    private UUID opportunitylocationid;
    private Boolean isactive;
    private UUID id;
    private String locationtype;
    private Boolean deleted;
    private UUID createdby;
    private UUID publiccontactdetailsid;
    private UUID orgaddressid;
    private String displaystring;
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

    public UUID getOpportunityLocationId() {
        return this.opportunitylocationid;
    }

    public void setOpportunityLocationId(UUID opportunitylocationid) {
        this.opportunitylocationid = opportunitylocationid;
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

    public String getLocationType() {
        return this.locationtype;
    }

    public void setLocationType(String locationtype) {
        this.locationtype = locationtype;
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

    public String getDiscriminator() {
        return this.discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    public String getPublicContactDetailsSource() {
        return this.publiccontactdetailssource;
    }

    public void setPublicContactDetailsSource(String publiccontactdetailssource) {
        this.publiccontactdetailssource = publiccontactdetailssource;
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
}
