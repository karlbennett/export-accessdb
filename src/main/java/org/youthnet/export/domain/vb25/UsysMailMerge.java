package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class UsysMailMerge implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 3;

    private List<String> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private Long no;
    private String option;
    private String fields;


    public UsysMailMerge(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.no = Long.valueOf(fields[0].replace(String.valueOf(this.enclosure), ""));
        this.option = fields[1].replace(String.valueOf(this.enclosure), "");
        this.fields = fields[2].replace(String.valueOf(this.enclosure), "");
    }

    public Long getNo() {
        return this.no;
    }

    public String getOption() {
        return this.option;
    }

    public String getFields() {
        return this.fields;
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
            columnNames.add("No");
            columnNames.add("Option");
            columnNames.add("Fields");
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.no);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.option);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.fields);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
