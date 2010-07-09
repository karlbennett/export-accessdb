package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class TbluSuitability implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 4;

    private List<String[]> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private String suitability;
    private Boolean active;
    private Long id;
    private Boolean demodata;


    public TbluSuitability() {
    }

    public TbluSuitability(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.suitability = fields[0].replace(String.valueOf(this.enclosure), "");
        this.active = fields[1].replace(String.valueOf(this.enclosure), "").equals("1");
        this.id = (fields[2].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[2].replace(String.valueOf(this.enclosure), ""));
        this.demodata = fields[3].replace(String.valueOf(this.enclosure), "").equals("1");
    }

    public String getSuitability() {
        return this.suitability;
    }

    public Boolean getActive() {
        return this.active;
    }

    public Long getId() {
        return this.id;
    }

    public Boolean getDemodata() {
        return this.demodata;
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
            columnNames.add(new String[]{"Suitability, String"});
            columnNames.add(new String[]{"Active, Boolean"});
            columnNames.add(new String[]{"ID, Long"});
            columnNames.add(new String[]{"DemoData, Boolean"});
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.suitability == null ? "" : this.suitability);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.active != null && active ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.id == null ? "" : this.id);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.demodata != null && demodata ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
