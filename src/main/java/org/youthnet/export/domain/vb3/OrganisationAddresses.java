package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class OrganisationAddresses implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 12;
    private List<String> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

    private UUID orgaddconinfoid;
    private Boolean usecustomorganisationname;
    private String email;
    private String directions;
    private String telephone;
    private String friendlyname;
    private UUID addressid;
    private String emergencytelephone;
    private Boolean isdefaultaddress;
    private String fax;
    private String website;
    private String organisationname;

    public OrganisationAddresses() {
    }

    public OrganisationAddresses(String record) {
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
        this.orgaddconinfoid = UUID.fromString(uuidStringBuffer.toString());

        this.usecustomorganisationname = fields[1].replace(String.valueOf(this.enclosure), "").equals("1");

        this.email = fields[2].replace(String.valueOf(this.enclosure), "");

        this.directions = fields[3].replace(String.valueOf(this.enclosure), "");

        this.telephone = fields[4].replace(String.valueOf(this.enclosure), "");

        this.friendlyname = fields[5].replace(String.valueOf(this.enclosure), "");

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[6].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.addressid = UUID.fromString(uuidStringBuffer.toString());

        this.emergencytelephone = fields[7].replace(String.valueOf(this.enclosure), "");

        this.isdefaultaddress = fields[8].replace(String.valueOf(this.enclosure), "").equals("1");

        this.fax = fields[9].replace(String.valueOf(this.enclosure), "");

        this.website = fields[10].replace(String.valueOf(this.enclosure), "");

        this.organisationname = fields[11].replace(String.valueOf(this.enclosure), "");

    }


    public UUID getOrgAddConInfoId() {
        return this.orgaddconinfoid;
    }

    public void setOrgAddConInfoId(UUID orgaddconinfoid) {
        this.orgaddconinfoid = orgaddconinfoid;
    }

    public Boolean getUseCustomOrganisationName() {
        return this.usecustomorganisationname;
    }

    public void setUseCustomOrganisationName(Boolean usecustomorganisationname) {
        this.usecustomorganisationname = usecustomorganisationname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDirections() {
        return this.directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFriendlyName() {
        return this.friendlyname;
    }

    public void setFriendlyName(String friendlyname) {
        this.friendlyname = friendlyname;
    }

    public UUID getAddressId() {
        return this.addressid;
    }

    public void setAddressId(UUID addressid) {
        this.addressid = addressid;
    }

    public String getEmergencyTelephone() {
        return this.emergencytelephone;
    }

    public void setEmergencyTelephone(String emergencytelephone) {
        this.emergencytelephone = emergencytelephone;
    }

    public Boolean getIsDefaultAddress() {
        return this.isdefaultaddress;
    }

    public void setIsDefaultAddress(Boolean isdefaultaddress) {
        this.isdefaultaddress = isdefaultaddress;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getOrganisationName() {
        return this.organisationname;
    }

    public void setOrganisationName(String organisationname) {
        this.organisationname = organisationname;
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
            this.columnNames.add("OrgAddConInfoId");
            this.columnNames.add("UseCustomOrganisationName");
            this.columnNames.add("Email");
            this.columnNames.add("Directions");
            this.columnNames.add("Telephone");
            this.columnNames.add("FriendlyName");
            this.columnNames.add("AddressId");
            this.columnNames.add("EmergencyTelephone");
            this.columnNames.add("IsDefaultAddress");
            this.columnNames.add("Fax");
            this.columnNames.add("Website");
            this.columnNames.add("OrganisationName");
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.orgaddconinfoid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(usecustomorganisationname ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.email);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.directions);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.telephone);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.friendlyname);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.addressid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.emergencytelephone);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(isdefaultaddress ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.fax);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.website);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.organisationname);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
