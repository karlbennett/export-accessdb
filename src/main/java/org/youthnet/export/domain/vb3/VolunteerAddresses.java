package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class VolunteerAddresses implements CSVable {

    private String delimiter = "|";
    private String enclosure = "¬";
    private Integer columnNum = 5;
    private List<String> columnNames = null;
    private StringBuffer record = new StringBuffer();

    private UUID addressid;
    private String name;
    private Boolean isdefaultaddress;
    private Boolean isactive;
    private UUID volunteerid;

    public VolunteerAddresses() {
    }

    public UUID getAddressId() {
        return this.addressid;
    }

    public void setAddressId(UUID addressid) {
        this.addressid = addressid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsDefaultAddress() {
        return this.isdefaultaddress;
    }

    public void setIsDefaultAddress(Boolean isdefaultaddress) {
        this.isdefaultaddress = isdefaultaddress;
    }

    public Boolean getIsActive() {
        return this.isactive;
    }

    public void setIsActive(Boolean isactive) {
        this.isactive = isactive;
    }

    public UUID getVolunteerId() {
        return this.volunteerid;
    }

    public void setVolunteerId(UUID volunteerid) {
        this.volunteerid = volunteerid;
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
            this.columnNames.add("AddressId");
            this.columnNames.add("Name");
            this.columnNames.add("IsDefaultAddress");
            this.columnNames.add("IsActive");
            this.columnNames.add("VolunteerId");
        }

        return this.columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.addressid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.name);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.isdefaultaddress);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.isactive);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.volunteerid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
