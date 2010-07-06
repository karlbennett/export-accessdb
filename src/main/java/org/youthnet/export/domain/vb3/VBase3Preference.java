package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class VBase3Preference implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 19;
    private List<String> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

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

    public VBase3Preference(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));
        StringBuffer uuidStringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");


        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[0].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.defaultcountyid = UUID.fromString(uuidStringBuffer.toString());

        this.usedefaultcountry = fields[1].replace(String.valueOf(this.enclosure), "").equals("1");

        this.usingvisualnotification = fields[2].replace(String.valueOf(this.enclosure), "").equals("1");

        this.usingaudionotification = fields[3].replace(String.valueOf(this.enclosure), "").equals("1");

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[4].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.languageid = UUID.fromString(uuidStringBuffer.toString());

        this.usinglognotification = fields[5].replace(String.valueOf(this.enclosure), "").equals("1");

        this.colourtheme = Long.valueOf(fields[6].replace(String.valueOf(this.enclosure), ""));

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[7].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.id = UUID.fromString(uuidStringBuffer.toString());

        this.copyright = fields[8].replace(String.valueOf(this.enclosure), "");

        this.deleted = fields[9].replace(String.valueOf(this.enclosure), "").equals("1");

        this.applicationname = fields[10].replace(String.valueOf(this.enclosure), "");

        this.version = Long.valueOf(fields[11].replace(String.valueOf(this.enclosure), ""));

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[12].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.modifiedby = UUID.fromString(uuidStringBuffer.toString());

        try {
            this.created = new Timestamp(simpleDateFormat.parse(fields[13].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp created " + fields[13].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[14].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.createdby = UUID.fromString(uuidStringBuffer.toString());

        this.dataschemaversion = Long.valueOf(fields[15].replace(String.valueOf(this.enclosure), ""));

        this.usedefaultcounty = fields[16].replace(String.valueOf(this.enclosure), "").equals("1");

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[17].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.defaultcountryid = UUID.fromString(uuidStringBuffer.toString());

        try {
            this.modified = new Timestamp(simpleDateFormat.parse(fields[18].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp modified " + fields[18].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

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
            this.columnNames.add("DefaultCountyId");
            this.columnNames.add("UseDefaultCountry");
            this.columnNames.add("UsingVisualNotification");
            this.columnNames.add("UsingAudioNotification");
            this.columnNames.add("LanguageId");
            this.columnNames.add("UsingLogNotification");
            this.columnNames.add("ColourTheme");
            this.columnNames.add("Id");
            this.columnNames.add("Copyright");
            this.columnNames.add("Deleted");
            this.columnNames.add("ApplicationName");
            this.columnNames.add("Version");
            this.columnNames.add("ModifiedBy");
            this.columnNames.add("Created");
            this.columnNames.add("CreatedBy");
            this.columnNames.add("DataSchemaVersion");
            this.columnNames.add("UseDefaultCounty");
            this.columnNames.add("DefaultCountryId");
            this.columnNames.add("Modified");
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.defaultcountyid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(usedefaultcountry ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(usingvisualnotification ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(usingaudionotification ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.languageid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(usinglognotification ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.colourtheme);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.id.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.copyright);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(deleted ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.applicationname);
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
        recordStringBuffer.append(this.created);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.createdby.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.dataschemaversion);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(usedefaultcounty ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.defaultcountryid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.modified);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
