package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class VBase3Preference implements CSVable {

    private String delimiter = "|";
    private String enclosure = "¬";
    private Integer columnNum = 19;
    private List<String> columnNames = null;
    private StringBuffer record = new StringBuffer();

    private UUID defaultcountyid;
    private Boolean usedefaultcountry;
    private Boolean usingvisualnotification;
    private Boolean usingaudionotification;
    private Boolean usinglognotification;
    private UUID languageid;
    private Long colourtheme;
    private UUID id;
    private Boolean deleted;
    private String copyright;
    private String applicationname;
    private Long version;
    private UUID modifiedby;
    private Timestamp created;
    private UUID createdby;
    private Long dataschemaversion;
    private Boolean usedefaultcounty;
    private Timestamp modified;
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

    public UUID getLanguageId() {
        return this.languageid;
    }

    public void setLanguageId(UUID languageid) {
        this.languageid = languageid;
    }

    public Boolean getUsingLogNotification() {
        return this.usinglognotification;
    }

    public void setUsingLogNotification(Boolean usinglognotification) {
        this.usinglognotification = usinglognotification;
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

    public String getCopyright() {
        return this.copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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

    public UUID getDefaultCountryId() {
        return this.defaultcountryid;
    }

    public void setDefaultCountryId(UUID defaultcountryid) {
        this.defaultcountryid = defaultcountryid;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
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
            this.columnNames.add("DefaultCountyId");
            this.columnNames.add("UseDefaultCountry");
            this.columnNames.add("UsingVisualNotification");
            this.columnNames.add("UsingAudioNotification");
            this.columnNames.add("UsingLogNotification");
            this.columnNames.add("LanguageId");
            this.columnNames.add("ColourTheme");
            this.columnNames.add("Id");
            this.columnNames.add("Deleted");
            this.columnNames.add("Copyright");
            this.columnNames.add("ApplicationName");
            this.columnNames.add("Version");
            this.columnNames.add("ModifiedBy");
            this.columnNames.add("Created");
            this.columnNames.add("CreatedBy");
            this.columnNames.add("DataSchemaVersion");
            this.columnNames.add("UseDefaultCounty");
            this.columnNames.add("Modified");
            this.columnNames.add("DefaultCountryId");
        }

        return this.columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.defaultcountyid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.usedefaultcountry);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.usingvisualnotification);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.usingaudionotification);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.usinglognotification);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.languageid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.colourtheme);
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
        record.append(this.copyright);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.applicationname);
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
        record.append(this.created);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.createdby.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.dataschemaversion);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.usedefaultcounty);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.modified);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.defaultcountryid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
