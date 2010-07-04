package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class OrganisationCampsAndInits implements CSVable {

    private String delimiter = "|";
    private String enclosure = "¬";
    private Integer columnNum = 2;
    private List<String> columnNames = null;
    private StringBuffer record = new StringBuffer();

    private UUID organisationid;
    private UUID lookupid;

    public OrganisationCampsAndInits() {
    }

    public UUID getOrganisationId() {
        return this.organisationid;
    }

    public void setOrganisationId(UUID organisationid) {
        this.organisationid = organisationid;
    }

    public UUID getLookupId() {
        return this.lookupid;
    }

    public void setLookupId(UUID lookupid) {
        this.lookupid = lookupid;
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
            this.columnNames.add("OrganisationId");
            this.columnNames.add("LookupId");
        }

        return this.columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.organisationid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.lookupid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
