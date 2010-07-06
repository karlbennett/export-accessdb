package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class UsysPreviousMenu implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 4;

    private List<String> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private Long id;
    private String user;
    private String name;
    private Short type;


    public UsysPreviousMenu() {
    }

    public UsysPreviousMenu(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.id = (fields[0].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[0].replace(String.valueOf(this.enclosure), ""));
        this.user = fields[1].replace(String.valueOf(this.enclosure), "");
        this.name = fields[2].replace(String.valueOf(this.enclosure), "");
        this.type = (fields[3].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Short.valueOf(fields[3].replace(String.valueOf(this.enclosure), ""));
    }

    public Long getId() {
        return this.id;
    }

    public String getUser() {
        return this.user;
    }

    public String getName() {
        return this.name;
    }

    public Short getType() {
        return this.type;
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
            columnNames.add("User");
            columnNames.add("Name");
            columnNames.add("Type");
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
        record.append(this.user == null ? "" : this.user);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.name == null ? "" : this.name);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.type == null ? "" : this.type);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
