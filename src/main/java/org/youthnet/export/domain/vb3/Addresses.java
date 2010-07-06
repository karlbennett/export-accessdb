package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Addresses implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 16;
    private List<String> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

    private String town;
    private String directions;
    private UUID id;
    private Boolean deleted;
    private Long vbase2id;
    private String address1;
    private String address2;
    private String postcode;
    private String address3;
    private Long version;
    private UUID modifiedby;
    private UUID countryid;
    private Timestamp created;
    private UUID createdby;
    private Timestamp modified;
    private UUID countyid;

    public Addresses() {
    }

    public Addresses(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split(String.valueOf(this.delimiter));
        StringBuffer uuidStringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");


        this.town = fields[0].replace(String.valueOf(this.enclosure), "");

        this.directions = fields[1].replace(String.valueOf(this.enclosure), "");

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[2].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.id = UUID.fromString(uuidStringBuffer.toString());

        this.deleted = fields[3].replace(String.valueOf(this.enclosure), "").equals("1");

        this.vbase2id = Long.valueOf(fields[4].replace(String.valueOf(this.enclosure), ""));

        this.address1 = fields[5].replace(String.valueOf(this.enclosure), "");

        this.address2 = fields[6].replace(String.valueOf(this.enclosure), "");

        this.address3 = fields[7].replace(String.valueOf(this.enclosure), "");

        this.postcode = fields[8].replace(String.valueOf(this.enclosure), "");

        this.version = Long.valueOf(fields[9].replace(String.valueOf(this.enclosure), ""));

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[10].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.modifiedby = UUID.fromString(uuidStringBuffer.toString());

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[11].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.countryid = UUID.fromString(uuidStringBuffer.toString());

        try {
            this.created = new Timestamp(simpleDateFormat.parse(fields[12].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp created " + fields[12].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[13].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.createdby = UUID.fromString(uuidStringBuffer.toString());

        try {
            this.modified = new Timestamp(simpleDateFormat.parse(fields[14].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars Timestamp modified " + fields[14].replace(String.valueOf(this.enclosure), "") + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[15].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.countyid = UUID.fromString(uuidStringBuffer.toString());

    }


    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDirections() {
        return this.directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
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

    public Long getVbase2Id() {
        return this.vbase2id;
    }

    public void setVbase2Id(Long vbase2id) {
        this.vbase2id = vbase2id;
    }

    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostCode() {
        return this.postcode;
    }

    public void setPostCode(String postcode) {
        this.postcode = postcode;
    }

    public String getAddress3() {
        return this.address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
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

    public UUID getCountryId() {
        return this.countryid;
    }

    public void setCountryId(UUID countryid) {
        this.countryid = countryid;
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
            this.columnNames.add("Town");
            this.columnNames.add("Directions");
            this.columnNames.add("Id");
            this.columnNames.add("Deleted");
            this.columnNames.add("Vbase2Id");
            this.columnNames.add("Address1");
            this.columnNames.add("Address2");
            this.columnNames.add("Address3");
            this.columnNames.add("PostCode");
            this.columnNames.add("Version");
            this.columnNames.add("ModifiedBy");
            this.columnNames.add("CountryId");
            this.columnNames.add("Created");
            this.columnNames.add("CreatedBy");
            this.columnNames.add("Modified");
            this.columnNames.add("CountyId");
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.town);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.directions);
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
        recordStringBuffer.append(this.vbase2id);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.address1);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.address2);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.address3);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.postcode);
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
        recordStringBuffer.append(this.countryid.toString().replace("-", ""));
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
        recordStringBuffer.append(this.modified);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.countyid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
