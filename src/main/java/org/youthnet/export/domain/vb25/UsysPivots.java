package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class UsysPivots implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 9;

    private List<String> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private Long id;
    private String pivot;
    private String row;
    private String column;
    private String data;
    private String sql;
    private String select;
    private String entsql;
    private String actsql;


    public UsysPivots() {
    }

    public UsysPivots(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.id = (fields[0].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[0].replace(String.valueOf(this.enclosure), ""));
        this.pivot = fields[1].replace(String.valueOf(this.enclosure), "");
        this.row = fields[2].replace(String.valueOf(this.enclosure), "");
        this.column = fields[3].replace(String.valueOf(this.enclosure), "");
        this.data = fields[4].replace(String.valueOf(this.enclosure), "");
        this.sql = fields[5].replace(String.valueOf(this.enclosure), "");
        this.select = fields[6].replace(String.valueOf(this.enclosure), "");
        this.entsql = fields[7].replace(String.valueOf(this.enclosure), "");
        this.actsql = fields[8].replace(String.valueOf(this.enclosure), "");
    }

    public Long getId() {
        return this.id;
    }

    public String getPivot() {
        return this.pivot;
    }

    public String getRow() {
        return this.row;
    }

    public String getColumn() {
        return this.column;
    }

    public String getData() {
        return this.data;
    }

    public String getSql() {
        return this.sql;
    }

    public String getSelect() {
        return this.select;
    }

    public String getEntsql() {
        return this.entsql;
    }

    public String getActsql() {
        return this.actsql;
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
            columnNames.add("ID");
            columnNames.add("Pivot");
            columnNames.add("Row");
            columnNames.add("Column");
            columnNames.add("Data");
            columnNames.add("SQL");
            columnNames.add("Select");
            columnNames.add("EntSQL");
            columnNames.add("ActSQL");
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.id == null ? "" : this.id);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.pivot == null ? "" : this.pivot);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.row == null ? "" : this.row);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.column == null ? "" : this.column);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.data == null ? "" : this.data);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.sql == null ? "" : this.sql);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.select == null ? "" : this.select);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.entsql == null ? "" : this.entsql);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.actsql == null ? "" : this.actsql);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
