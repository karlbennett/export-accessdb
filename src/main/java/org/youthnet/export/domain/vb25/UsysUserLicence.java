package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class UsysUserLicence implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 1;

    private List<String> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private Short licence;


    public UsysUserLicence() {
    }

    public UsysUserLicence(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.licence = (fields[0].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Short.valueOf(fields[0].replace(String.valueOf(this.enclosure), ""));
    }

    public Short getLicence() {
        return this.licence;
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

    public List<String> getColumnNames() {
        if (this.columnNames == null) {
            columnNames = new ArrayList<String>();
            columnNames.add("Licence");
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.licence == null ? "" : this.licence);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
