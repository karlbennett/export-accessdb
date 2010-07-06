package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class OpportunityAddSpecSuitabs implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 2;
    private List<String> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

    private UUID opportunityid;
    private UUID lookupid;

    public OpportunityAddSpecSuitabs() {
    }

    public OpportunityAddSpecSuitabs(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split(String.valueOf(this.delimiter));
        StringBuffer uuidStringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");


        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[0].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.opportunityid = UUID.fromString(uuidStringBuffer.toString());

        uuidStringBuffer.setLength(0);
        uuidStringBuffer.append(fields[1].replace(String.valueOf(this.enclosure), ""));
        uuidStringBuffer.insert(8, '-');
        uuidStringBuffer.insert(13, '-');
        uuidStringBuffer.insert(18, '-');
        uuidStringBuffer.insert(23, '-');
        this.lookupid = UUID.fromString(uuidStringBuffer.toString());

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
            this.columnNames.add("OpportunityId");
            this.columnNames.add("LookupId");
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.opportunityid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.lookupid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
