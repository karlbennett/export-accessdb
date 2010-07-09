package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class UsysTimeSlots implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 2;

    private List<String[]> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private String found;
    private String readable;


    public UsysTimeSlots() {
    }

    public UsysTimeSlots(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.found = fields[0].replace(String.valueOf(this.enclosure), "");
        this.readable = fields[1].replace(String.valueOf(this.enclosure), "");
    }

    public String getFound() {
        return this.found;
    }

    public String getReadable() {
        return this.readable;
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
        return COLUMN_NUM;
    }

    public List<String[]> getColumnNames() {
        if (this.columnNames == null) {
            columnNames = new ArrayList<String[]>();
            columnNames.add(new String[]{"Found, String"});
            columnNames.add(new String[]{"Readable, String"});
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.found == null ? "" : this.found);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.readable == null ? "" : this.readable);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
