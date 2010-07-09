package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class UsysQBFOppSuitability implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 3;

    private List<String[]> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private String user;
    private Long id;
    private String suitability;


    public UsysQBFOppSuitability() {
    }

    public UsysQBFOppSuitability(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.user = fields[0].replace(String.valueOf(this.enclosure), "");
        this.id = (fields[1].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[1].replace(String.valueOf(this.enclosure), ""));
        this.suitability = fields[2].replace(String.valueOf(this.enclosure), "");
    }

    public String getUser() {
        return this.user;
    }

    public Long getId() {
        return this.id;
    }

    public String getSuitability() {
        return this.suitability;
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
            columnNames.add(new String[]{"User, String"});
            columnNames.add(new String[]{"ID, Long"});
            columnNames.add(new String[]{"Suitability, String"});
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.user == null ? "" : this.user);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.id == null ? "" : this.id);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.suitability == null ? "" : this.suitability);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
