package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class OrganisationAddresses implements CSVable {

    private String delimiter = "|";
    private String enclosure = "¬";
    private Integer columnNum = 12;
    private List<String> columnNames = null;
    private StringBuffer record = new StringBuffer();

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
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.orgaddconinfoid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.usecustomorganisationname);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.email);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.directions);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.telephone);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.friendlyname);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.addressid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.emergencytelephone);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.isdefaultaddress);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.fax);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.website);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.organisationname);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
