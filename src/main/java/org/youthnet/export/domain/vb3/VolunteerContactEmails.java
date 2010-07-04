package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class VolunteerContactEmails implements CSVable {

    private String delimiter = "|";
    private String enclosure = "¬";
    private Integer columnNum = 4;
    private List<String> columnNames = null;
    private StringBuffer record = new StringBuffer();

    private String email;
    private UUID volunteercontactinfoid;
    private UUID telephonetypeid;
    private UUID volunteerid;

    public VolunteerContactEmails() {
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getVolunteerContactInfoId() {
        return this.volunteercontactinfoid;
    }

    public void setVolunteerContactInfoId(UUID volunteercontactinfoid) {
        this.volunteercontactinfoid = volunteercontactinfoid;
    }

    public UUID getTelephoneTypeId() {
        return this.telephonetypeid;
    }

    public void setTelephoneTypeId(UUID telephonetypeid) {
        this.telephonetypeid = telephonetypeid;
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
            this.columnNames.add("Email");
            this.columnNames.add("VolunteerContactInfoId");
            this.columnNames.add("TelephoneTypeId");
            this.columnNames.add("VolunteerId");
        }

        return this.columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.email);
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.volunteercontactinfoid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.telephonetypeid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.volunteerid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
