package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Locations implements CSVable, ContainsDiscriminator {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 23;
    private List<String[]> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

    private String displaystring;
    private Boolean isactive;
    private String locationtype;
    private UUID countyid;
    private String publiccontactdetailssource;
    private UUID addressid;
    private Boolean usecustomorgname;
    private UUID orgaddressid;
    private Boolean usecustomaddress;
    private UUID regionid;
    private Boolean useforcontactdetails;
    private UUID contactdetailsid;
    private UUID opportunitylocationid;
    private UUID publiccontactdetailsid;
    private String discriminator;
    private UUID id;
    private Timestamp created;
    private UUID createdby;
    private Boolean deleted;
    private Timestamp modified;
    private UUID modifiedby;
    private Long version;
    private String customorgname;

    public Locations() {
    }

    public Locations(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));
        StringBuffer uuidStringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");


        this.displaystring = fields[0].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.isactive = fields[1].replace(String.valueOf(this.enclosure), "").equals("1");

        this.locationtype = fields[2].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        if (fields[3].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.countyid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[3].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.countyid = UUID.fromString(uuidStringBuffer.toString());
        }

        this.publiccontactdetailssource = fields[4].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        if (fields[5].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.addressid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[5].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.addressid = UUID.fromString(uuidStringBuffer.toString());
        }

        this.usecustomorgname = fields[6].replace(String.valueOf(this.enclosure), "").equals("1");

        if (fields[7].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.orgaddressid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[7].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.orgaddressid = UUID.fromString(uuidStringBuffer.toString());
        }

        this.usecustomaddress = fields[8].replace(String.valueOf(this.enclosure), "").equals("1");

        if (fields[9].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.regionid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[9].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.regionid = UUID.fromString(uuidStringBuffer.toString());
        }

        this.useforcontactdetails = fields[10].replace(String.valueOf(this.enclosure), "").equals("1");

        if (fields[11].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.contactdetailsid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[11].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.contactdetailsid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[12].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.opportunitylocationid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[12].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.opportunitylocationid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[13].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.publiccontactdetailsid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[13].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.publiccontactdetailsid = UUID.fromString(uuidStringBuffer.toString());
        }

        this.discriminator = fields[14].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        if (fields[15].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.id = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[15].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.id = UUID.fromString(uuidStringBuffer.toString());
        }

        try {
            this.created = (fields[16].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[16].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp created " + fields[16].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        if (fields[17].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.createdby = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[17].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.createdby = UUID.fromString(uuidStringBuffer.toString());
        }

        this.deleted = fields[18].replace(String.valueOf(this.enclosure), "").equals("1");

        try {
            this.modified = (fields[19].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(simpleDateFormat.parse(fields[19].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp modified " + fields[19].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        if (fields[20].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.modifiedby = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[20].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.modifiedby = UUID.fromString(uuidStringBuffer.toString());
        }

        this.version = (fields[21].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[21].replace(String.valueOf(this.enclosure), ""));

        this.customorgname = fields[22].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

    }


    public String getDisplayString() {
        return this.displaystring;
    }

    public void setDisplayString(String displaystring) {
        this.displaystring = displaystring;
    }

    public Boolean getIsActive() {
        return this.isactive;
    }

    public void setIsActive(Boolean isactive) {
        this.isactive = isactive;
    }

    public String getLocationType() {
        return this.locationtype;
    }

    public void setLocationType(String locationtype) {
        this.locationtype = locationtype;
    }

    public UUID getCountyId() {
        return this.countyid;
    }

    public void setCountyId(UUID countyid) {
        this.countyid = countyid;
    }

    public String getPublicContactDetailsSource() {
        return this.publiccontactdetailssource;
    }

    public void setPublicContactDetailsSource(String publiccontactdetailssource) {
        this.publiccontactdetailssource = publiccontactdetailssource;
    }

    public UUID getAddressId() {
        return this.addressid;
    }

    public void setAddressId(UUID addressid) {
        this.addressid = addressid;
    }

    public Boolean getUseCustomOrgName() {
        return this.usecustomorgname;
    }

    public void setUseCustomOrgName(Boolean usecustomorgname) {
        this.usecustomorgname = usecustomorgname;
    }

    public UUID getOrgAddressId() {
        return this.orgaddressid;
    }

    public void setOrgAddressId(UUID orgaddressid) {
        this.orgaddressid = orgaddressid;
    }

    public Boolean getUseCustomAddress() {
        return this.usecustomaddress;
    }

    public void setUseCustomAddress(Boolean usecustomaddress) {
        this.usecustomaddress = usecustomaddress;
    }

    public UUID getRegionId() {
        return this.regionid;
    }

    public void setRegionId(UUID regionid) {
        this.regionid = regionid;
    }

    public Boolean getUseForContactDetails() {
        return this.useforcontactdetails;
    }

    public void setUseForContactDetails(Boolean useforcontactdetails) {
        this.useforcontactdetails = useforcontactdetails;
    }

    public UUID getContactDetailsId() {
        return this.contactdetailsid;
    }

    public void setContactDetailsId(UUID contactdetailsid) {
        this.contactdetailsid = contactdetailsid;
    }

    public UUID getOpportunityLocationId() {
        return this.opportunitylocationid;
    }

    public void setOpportunityLocationId(UUID opportunitylocationid) {
        this.opportunitylocationid = opportunitylocationid;
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

    public String getCustomOrgName() {
        return this.customorgname;
    }

    public void setCustomOrgName(String customorgname) {
        this.customorgname = customorgname;
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
            this.columnNames.add(new String[]{"DisplayString", "String"});
            this.columnNames.add(new String[]{"IsActive", "Boolean"});
            this.columnNames.add(new String[]{"LocationType", "String"});
            this.columnNames.add(new String[]{"CountyId", "UUID"});
            this.columnNames.add(new String[]{"PublicContactDetailsSource", "String"});
            this.columnNames.add(new String[]{"AddressId", "UUID"});
            this.columnNames.add(new String[]{"UseCustomOrgName", "Boolean"});
            this.columnNames.add(new String[]{"OrgAddressId", "UUID"});
            this.columnNames.add(new String[]{"UseCustomAddress", "Boolean"});
            this.columnNames.add(new String[]{"RegionId", "UUID"});
            this.columnNames.add(new String[]{"UseForContactDetails", "Boolean"});
            this.columnNames.add(new String[]{"ContactDetailsId", "UUID"});
            this.columnNames.add(new String[]{"OpportunityLocationId", "UUID"});
            this.columnNames.add(new String[]{"PublicContactDetailsId", "UUID"});
            this.columnNames.add(new String[]{"Discriminator", "String"});
            this.columnNames.add(new String[]{"Id", "UUID"});
            this.columnNames.add(new String[]{"Created", "Timestamp"});
            this.columnNames.add(new String[]{"CreatedBy", "UUID"});
            this.columnNames.add(new String[]{"Deleted", "Boolean"});
            this.columnNames.add(new String[]{"Modified", "Timestamp"});
            this.columnNames.add(new String[]{"ModifiedBy", "UUID"});
            this.columnNames.add(new String[]{"Version", "Long"});
            this.columnNames.add(new String[]{"CustomOrgName", "String"});
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.displaystring == null ? "" : this.displaystring.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.isactive != null && this.isactive ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.locationtype == null ? "" : this.locationtype.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.countyid == null ? "" : this.countyid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.publiccontactdetailssource == null ? "" : this.publiccontactdetailssource.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.addressid == null ? "" : this.addressid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.usecustomorgname != null && this.usecustomorgname ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.orgaddressid == null ? "" : this.orgaddressid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.usecustomaddress != null && this.usecustomaddress ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.regionid == null ? "" : this.regionid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.useforcontactdetails != null && this.useforcontactdetails ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.contactdetailsid == null ? "" : this.contactdetailsid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.opportunitylocationid == null ? "" : this.opportunitylocationid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.publiccontactdetailsid == null ? "" : this.publiccontactdetailsid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.discriminator == null ? "" : this.discriminator.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
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
        recordStringBuffer.append(this.customorgname == null ? "" : this.customorgname.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
