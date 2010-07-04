package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class OpportunitySelectionMethods implements CSVable {

    private String delimiter = "|";
    private String enclosure = "¬";
    private Integer columnNum = 2;
    private List<String> columnNames = null;
    private StringBuffer record = new StringBuffer();

    private UUID opportunityid;
    private UUID lookupid;

    public OpportunitySelectionMethods() {
    }

    public UUID getOpportunityId() {
        return this.opportunityid;
    }

    public void setOpportunityId(UUID opportunityid) {
        this.opportunityid = opportunityid;
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
            this.columnNames.add("OpportunityId");
            this.columnNames.add("LookupId");
        }

        return this.columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.opportunityid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.lookupid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
