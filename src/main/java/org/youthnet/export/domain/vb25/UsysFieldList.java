package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class UsysFieldList implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 3;

    private List<String> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private String field;
    private String area;
    private Short order;


    public UsysFieldList(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.field = fields[0].replace(String.valueOf(this.enclosure), "");
        this.area = fields[1].replace(String.valueOf(this.enclosure), "");
        this.order = Short.valueOf(fields[2].replace(String.valueOf(this.enclosure), ""));
    }

    public String getField() {
        return this.field;
    }

    public String getArea() {
        return this.area;
    }

    public Short getOrder() {
        return this.order;
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
            columnNames.add("Field");
            columnNames.add("Area");
            columnNames.add("Order");
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.field);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.area);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.order);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
