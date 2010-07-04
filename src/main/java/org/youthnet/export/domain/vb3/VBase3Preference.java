package org.youthnet.export.domain.vb3;


import java.sql.Timestamp;
import java.util.UUID;


public class VBase3Preference {

    private Long version;
    private UUID defaultcountyid;
    private Boolean usedefaultcountry;
    private UUID languageid;
    private Long colourtheme;
    private Timestamp created;
    private Timestamp modified;
    private String applicationname;
    private UUID modifiedby;
    private Boolean usingvisualnotification;
    private Boolean usingaudionotification;
    private Boolean usinglognotification;
    private UUID id;
    private Boolean deleted;
    private UUID createdby;
    private String copyright;
    private Long dataschemaversion;
    private Boolean usedefaultcounty;
    private UUID defaultcountryid;

    public VBase3Preference() {
    }

    public UUID getDefaultCountyId() {
        return this.defaultcountyid;
    }

    public void setDefaultCountyId(UUID defaultcountyid) {
        this.defaultcountyid = defaultcountyid;
    }

    public Boolean getUseDefaultCountry() {
        return this.usedefaultcountry;
    }

    public void setUseDefaultCountry(Boolean usedefaultcountry) {
        this.usedefaultcountry = usedefaultcountry;
    }

    public Boolean getUsingVisualNotification() {
        return this.usingvisualnotification;
    }

    public void setUsingVisualNotification(Boolean usingvisualnotification) {
        this.usingvisualnotification = usingvisualnotification;
    }

    public Boolean getUsingAudioNotification() {
        return this.usingaudionotification;
    }

    public void setUsingAudioNotification(Boolean usingaudionotification) {
        this.usingaudionotification = usingaudionotification;
    }

    public Boolean getUsingLogNotification() {
        return this.usinglognotification;
    }

    public void setUsingLogNotification(Boolean usinglognotification) {
        this.usinglognotification = usinglognotification;
    }

    public UUID getLanguageId() {
        return this.languageid;
    }

    public void setLanguageId(UUID languageid) {
        this.languageid = languageid;
    }

    public Long getColourTheme() {
        return this.colourtheme;
    }

    public void setColourTheme(Long colourtheme) {
        this.colourtheme = colourtheme;
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

    public String getCopyright() {
        return this.copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getApplicationName() {
        return this.applicationname;
    }

    public void setApplicationName(String applicationname) {
        this.applicationname = applicationname;
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

    public Long getDataSchemaVersion() {
        return this.dataschemaversion;
    }

    public void setDataSchemaVersion(Long dataschemaversion) {
        this.dataschemaversion = dataschemaversion;
    }

    public Boolean getUseDefaultCounty() {
        return this.usedefaultcounty;
    }

    public void setUseDefaultCounty(Boolean usedefaultcounty) {
        this.usedefaultcounty = usedefaultcounty;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public UUID getDefaultCountryId() {
        return this.defaultcountryid;
    }

    public void setDefaultCountryId(UUID defaultcountryid) {
        this.defaultcountryid = defaultcountryid;
    }
}
