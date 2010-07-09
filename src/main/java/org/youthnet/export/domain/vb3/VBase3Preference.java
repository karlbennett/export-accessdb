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
    private List<String[]> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

    private String copyright;
    private Long dataschemaversion;
    private UUID defaultcountryid;
    private UUID defaultcountyid;
    private UUID languageid;
    private Boolean usedefaultcountry;
    private Boolean usedefaultcounty;
    private Boolean usingaudionotification;
    private Boolean usinglognotification;
    private Boolean usingvisualnotification;
    private UUID id;
    private Timestamp created;
    private UUID createdby;
    private Boolean deleted;
    private Timestamp modified;
    private UUID modifiedby;
    private Long version;
    private String applicationname;
    private Long colourtheme;

    public VBase3Preference() {
    }

    public VBase3Preference(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));
        StringBuffer uuidStringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");


        this.copyright = fields[0].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.dataschemaversion = (fields[1].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[1].replace(String.valueOf(this.enclosure), ""));

        if (fields[2].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.defaultcountryid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[2].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.defaultcountryid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[3].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.defaultcountyid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[3].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.defaultcountyid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[4].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.languageid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[4].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.languageid = UUID.fromString(uuidStringBuffer.toString());
        }

        this.usedefaultcountry = fields[5].replace(String.valueOf(this.enclosure), "").equals("1");

        this.usedefaultcounty = fields[6].replace(String.valueOf(this.enclosure), "").equals("1");

        this.usingaudionotification = fields[7].replace(String.valueOf(this.enclosure), "").equals("1");

        this.usinglognotification = fields[8].replace(String.valueOf(this.enclosure), "").equals("1");

        this.usingvisualnotification = fields[9].replace(String.valueOf(this.enclosure), "").equals("1");

        if (fields[10].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.id = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[10].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.id = UUID.fromString(uuidStringBuffer.toString());
        }

        try {
            this.created = (fields[11].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[11].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp created " + fields[11].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        if (fields[12].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.createdby = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[12].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.createdby = UUID.fromString(uuidStringBuffer.toString());
        }

        this.deleted = fields[13].replace(String.valueOf(this.enclosure), "").equals("1");

        try {
            this.modified = (fields[14].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[14].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp modified " + fields[14].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        if (fields[15].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.modifiedby = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[15].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.modifiedby = UUID.fromString(uuidStringBuffer.toString());
        }

        this.version = (fields[16].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[16].replace(String.valueOf(this.enclosure), ""));

        this.applicationname = fields[17].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.colourtheme = (fields[18].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[18].replace(String.valueOf(this.enclosure), ""));

    }


    public String getCopyright() {
        return this.copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Long getDataSchemaVersion() {
        return this.dataschemaversion;
    }

    public void setDataSchemaVersion(Long dataschemaversion) {
        this.dataschemaversion = dataschemaversion;
    }

    public UUID getDefaultCountryId() {
        return this.defaultcountryid;
    }

    public void setDefaultCountryId(UUID defaultcountryid) {
        this.defaultcountryid = defaultcountryid;
    }

    public UUID getDefaultCountyId() {
        return this.defaultcountyid;
    }

    public void setDefaultCountyId(UUID defaultcountyid) {
        this.defaultcountyid = defaultcountyid;
    }

    public UUID getLanguageId() {
        return this.languageid;
    }

    public void setLanguageId(UUID languageid) {
        this.languageid = languageid;
    }

    public Boolean getUseDefaultCountry() {
        return this.usedefaultcountry;
    }

    public void setUseDefaultCountry(Boolean usedefaultcountry) {
        this.usedefaultcountry = usedefaultcountry;
    }

    public Boolean getUseDefaultCounty() {
        return this.usedefaultcounty;
    }

    public void setUseDefaultCounty(Boolean usedefaultcounty) {
        this.usedefaultcounty = usedefaultcounty;
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

    public Boolean getUsingVisualNotification() {
        return this.usingvisualnotification;
    }

    public void setUsingVisualNotification(Boolean usingvisualnotification) {
        this.usingvisualnotification = usingvisualnotification;
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

    public String getApplicationName() {
        return this.applicationname;
    }

    public void setApplicationName(String applicationname) {
        this.applicationname = applicationname;
    }

    public Long getColourTheme() {
        return this.colourtheme;
    }

    public void setColourTheme(Long colourtheme) {
        this.colourtheme = colourtheme;
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
            this.columnNames.add(new String[]{"Copyright", "String"});
            this.columnNames.add(new String[]{"DataSchemaVersion", "Long"});
            this.columnNames.add(new String[]{"DefaultCountryId", "UUID"});
            this.columnNames.add(new String[]{"DefaultCountyId", "UUID"});
            this.columnNames.add(new String[]{"LanguageId", "UUID"});
            this.columnNames.add(new String[]{"UseDefaultCountry", "Boolean"});
            this.columnNames.add(new String[]{"UseDefaultCounty", "Boolean"});
            this.columnNames.add(new String[]{"UsingAudioNotification", "Boolean"});
            this.columnNames.add(new String[]{"UsingLogNotification", "Boolean"});
            this.columnNames.add(new String[]{"UsingVisualNotification", "Boolean"});
            this.columnNames.add(new String[]{"Id", "UUID"});
            this.columnNames.add(new String[]{"Created", "Timestamp"});
            this.columnNames.add(new String[]{"CreatedBy", "UUID"});
            this.columnNames.add(new String[]{"Deleted", "Boolean"});
            this.columnNames.add(new String[]{"Modified", "Timestamp"});
            this.columnNames.add(new String[]{"ModifiedBy", "UUID"});
            this.columnNames.add(new String[]{"Version", "Long"});
            this.columnNames.add(new String[]{"ApplicationName", "String"});
            this.columnNames.add(new String[]{"ColourTheme", "Long"});
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.copyright == null ? "" :
                this.copyright.length() < 250 ? this.copyright.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.copyright.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.dataschemaversion == null ? "" : this.dataschemaversion);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.defaultcountryid == null ? "" : this.defaultcountryid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.defaultcountyid == null ? "" : this.defaultcountyid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.languageid == null ? "" : this.languageid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.usedefaultcountry != null && this.usedefaultcountry ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.usedefaultcounty != null && this.usedefaultcounty ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.usingaudionotification != null && this.usingaudionotification ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.usinglognotification != null && this.usinglognotification ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.usingvisualnotification != null && this.usingvisualnotification ? 1 : 0);
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
        recordStringBuffer.append(this.applicationname == null ? "" :
                this.applicationname.length() < 250 ? this.applicationname.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.applicationname.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.colourtheme == null ? "" : this.colourtheme);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
