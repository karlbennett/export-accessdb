package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class UsysChartTitles implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 6;

    private List<String> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private String chart;
    private String user;
    private String top;
    private String left;
    private String right;
    private String bottom;


    public UsysChartTitles(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.chart = fields[0].replace(String.valueOf(this.enclosure), "");
        this.user = fields[1].replace(String.valueOf(this.enclosure), "");
        this.top = fields[2].replace(String.valueOf(this.enclosure), "");
        this.left = fields[3].replace(String.valueOf(this.enclosure), "");
        this.right = fields[4].replace(String.valueOf(this.enclosure), "");
        this.bottom = fields[5].replace(String.valueOf(this.enclosure), "");
    }

    public String getChart() {
        return this.chart;
    }

    public String getUser() {
        return this.user;
    }

    public String getTop() {
        return this.top;
    }

    public String getLeft() {
        return this.left;
    }

    public String getRight() {
        return this.right;
    }

    public String getBottom() {
        return this.bottom;
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
            columnNames.add("Chart");
            columnNames.add("User");
            columnNames.add("Top");
            columnNames.add("Left");
            columnNames.add("Right");
            columnNames.add("Bottom");
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.chart);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.user);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.top);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.left);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.right);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.bottom);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
