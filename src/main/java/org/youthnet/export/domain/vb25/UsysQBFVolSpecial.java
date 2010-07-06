package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class UsysQBFVolSpecial implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 2;

    private List<String> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private String user;
    private String special;


    public UsysQBFVolSpecial(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.user = fields[0].replace(String.valueOf(this.enclosure), "");
        this.special = fields[1].replace(String.valueOf(this.enclosure), "");
    }

    public String getUser() {
        return this.user;
    }

    public String getSpecial() {
        return this.special;
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

    public void setEnclosure(char delimiter) {
        this.enclosure = enclosure;
    }

    public Integer getColumnNumber() {
        return COLUMN_NUM;
    }

    public List<String> getColumnNames() {
        if (this.columnNames == null) {
            columnNames = new ArrayList<String>();
            columnNames.add("User");
            columnNames.add("Special");
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.user);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.special);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
