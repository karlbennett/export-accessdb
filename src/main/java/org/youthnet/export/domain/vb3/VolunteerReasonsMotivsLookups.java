package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class VolunteerReasonsMotivsLookups implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';
    private Integer columnNum = 2;
    private List<String[]> columnNames = null;
    private StringBuffer recordStringBuffer = new StringBuffer();

    private UUID volunteerid;
    private UUID lookupid;

    public VolunteerReasonsMotivsLookups() {
    }

    public VolunteerReasonsMotivsLookups(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));
        StringBuffer uuidStringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");


        if (fields[0].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.volunteerid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[0].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.volunteerid = UUID.fromString(uuidStringBuffer.toString());
        }

        if (fields[1].replace(String.valueOf(this.enclosure), "").equals("")) {
            uuidStringBuffer.setLength(0);
            this.lookupid = null;
        } else {
            uuidStringBuffer.setLength(0);
            uuidStringBuffer.append(fields[1].replace(String.valueOf(this.enclosure), ""));
            uuidStringBuffer.insert(8, '-');
            uuidStringBuffer.insert(13, '-');
            uuidStringBuffer.insert(18, '-');
            uuidStringBuffer.insert(23, '-');
            this.lookupid = UUID.fromString(uuidStringBuffer.toString());
        }

    }


    public UUID getVolunteerId() {
        return this.volunteerid;
    }

    public void setVolunteerId(UUID volunteerid) {
        this.volunteerid = volunteerid;
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

    public List<String[]> getColumnNames() {
        if (this.columnNames == null) {
            this.columnNames = new ArrayList<String[]>();
            this.columnNames.add(new String[]{"VolunteerId", "UUID"});
            this.columnNames.add(new String[]{"LookupId", "UUID"});
        }

        return this.columnNames;
    }

    public String getRecord() {
        recordStringBuffer.setLength(0);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.volunteerid == null ? "" : this.volunteerid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.lookupid == null ? "" : this.lookupid.toString().replace("-", ""));
        recordStringBuffer.append(this.enclosure);
        recordStringBuffer.append(this.delimiter);

        return recordStringBuffer.toString();
    }
}
