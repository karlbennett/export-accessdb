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
    private List<String[]> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

    private String website;
    private UUID addressid;
    private UUID orgaddconinfoid;
    private String directions;
    private String email;
    private String emergencytelephone;
    private String fax;
    private String friendlyname;
    private Boolean isdefaultaddress;
    private String organisationname;
    private String telephone;
    private Boolean usecustomorganisationname;

    public OrganisationAddresses() {
    }

    public OrganisationAddresses(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));
        StringBuffer uuidStringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");


        this.website = fields[0].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        if (fields[1].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.addressid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[1].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.addressid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[2].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.orgaddconinfoid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[2].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.orgaddconinfoid = UUID.fromString(uuidStringBuffer.toString());
        }

        this.directions = fields[3].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.email = fields[4].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.emergencytelephone = fields[5].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.fax = fields[6].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.friendlyname = fields[7].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.isdefaultaddress = fields[8].replace(String.valueOf(this.enclosure), "").equals("1");

        this.organisationname = fields[9].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.telephone = fields[10].replace(String.valueOf(this.enclosure), "").replace("[[DELM]]", String.valueOf(this.delimiter)).replace("[[ENCL]]", String.valueOf(this.enclosure));

        this.usecustomorganisationname = fields[11].replace(String.valueOf(this.enclosure), "").equals("1");

    }


    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public UUID getAddressId() {
        return this.addressid;
    }

    public void setAddressId(UUID addressid) {
        this.addressid = addressid;
    }

    public UUID getOrgAddConInfoId() {
        return this.orgaddconinfoid;
    }

    public void setOrgAddConInfoId(UUID orgaddconinfoid) {
        this.orgaddconinfoid = orgaddconinfoid;
    }

    public String getDirections() {
        return this.directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmergencyTelephone() {
        return this.emergencytelephone;
    }

    public void setEmergencyTelephone(String emergencytelephone) {
        this.emergencytelephone = emergencytelephone;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFriendlyName() {
        return this.friendlyname;
    }

    public void setFriendlyName(String friendlyname) {
        this.friendlyname = friendlyname;
    }

    public Boolean getIsDefaultAddress() {
        return this.isdefaultaddress;
    }

    public void setIsDefaultAddress(Boolean isdefaultaddress) {
        this.isdefaultaddress = isdefaultaddress;
    }

    public String getOrganisationName() {
        return this.organisationname;
    }

    public void setOrganisationName(String organisationname) {
        this.organisationname = organisationname;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean getUseCustomOrganisationName() {
        return this.usecustomorganisationname;
    }

    public void setUseCustomOrganisationName(Boolean usecustomorganisationname) {
        this.usecustomorganisationname = usecustomorganisationname;
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
            this.columnNames.add(new String[]{"Website", "String"});
            this.columnNames.add(new String[]{"AddressId", "UUID"});
            this.columnNames.add(new String[]{"OrgAddConInfoId", "UUID"});
            this.columnNames.add(new String[]{"Directions", "String"});
            this.columnNames.add(new String[]{"Email", "String"});
            this.columnNames.add(new String[]{"EmergencyTelephone", "String"});
            this.columnNames.add(new String[]{"Fax", "String"});
            this.columnNames.add(new String[]{"FriendlyName", "String"});
            this.columnNames.add(new String[]{"IsDefaultAddress", "Boolean"});
            this.columnNames.add(new String[]{"OrganisationName", "String"});
            this.columnNames.add(new String[]{"Telephone", "String"});
            this.columnNames.add(new String[]{"UseCustomOrganisationName", "Boolean"});
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.website == null ? "" :
                this.website.length() < 250 ? this.website.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.website.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.addressid == null ? "" : this.addressid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.orgaddconinfoid == null ? "" : this.orgaddconinfoid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.directions == null ? "" :
                this.directions.length() < 250 ? this.directions.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.directions.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.email == null ? "" :
                this.email.length() < 250 ? this.email.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.email.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.emergencytelephone == null ? "" :
                this.emergencytelephone.length() < 250 ? this.emergencytelephone.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.emergencytelephone.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.fax == null ? "" :
                this.fax.length() < 250 ? this.fax.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.fax.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.friendlyname == null ? "" :
                this.friendlyname.length() < 250 ? this.friendlyname.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.friendlyname.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.isdefaultaddress != null && this.isdefaultaddress ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.organisationname == null ? "" :
                this.organisationname.length() < 250 ? this.organisationname.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.organisationname.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.telephone == null ? "" :
                this.telephone.length() < 250 ? this.telephone.replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]") :
                        this.telephone.substring(0, 250).replace(String.valueOf(this.delimiter), "[[DELM]]").replace(String.valueOf(this.enclosure), "[[ENCL]]"));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.usecustomorganisationname != null && this.usecustomorganisationname ? 1 : 0);
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
