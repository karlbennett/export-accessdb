package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class UsysDefaults implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 3;

    private List<String> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private Short no;
    private String option;
    private String value;


    public UsysDefaults() {
    }

    public UsysDefaults(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.no = (fields[0].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Short.valueOf(fields[0].replace(String.valueOf(this.enclosure), ""));
        this.option = fields[1].replace(String.valueOf(this.enclosure), "");
        this.value = fields[2].replace(String.valueOf(this.enclosure), "");
    }

    public Short getNo() {
        return this.no;
    }

    public String getOption() {
        return this.option;
    }

    public String getValue() {
        return this.value;
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
            columnNames.add("No");
            columnNames.add("Option");
            columnNames.add("Value");
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.no == null ? "" : this.no);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.option == null ? "" : this.option);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.value == null ? "" : this.value);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
