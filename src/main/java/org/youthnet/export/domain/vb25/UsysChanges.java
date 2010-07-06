package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class UsysChanges implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 4;

    private List<String> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private Long no;
    private String change;
    private String description;
    private Boolean done;


    public UsysChanges() {
    }

    public UsysChanges(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.no = (fields[0].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[0].replace(String.valueOf(this.enclosure), ""));
        this.change = fields[1].replace(String.valueOf(this.enclosure), "");
        this.description = fields[2].replace(String.valueOf(this.enclosure), "");
        this.done = fields[3].replace(String.valueOf(this.enclosure), "").equals("1");
    }

    public Long getNo() {
        return this.no;
    }

    public String getChange() {
        return this.change;
    }

    public String getDescription() {
        return this.description;
    }

    public Boolean getDone() {
        return this.done;
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
            columnNames.add("Change");
            columnNames.add("Description");
            columnNames.add("Done");
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
        record.append(this.change == null ? "" : this.change);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.description == null ? "" : this.description);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.done ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
