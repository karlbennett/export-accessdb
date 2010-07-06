package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class TbluCorrespondence implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 5;

    private List<String> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private String correspondence;
    private Boolean active;
    private Boolean followupletter;
    private String templatepath;
    private Boolean demodata;


    public TbluCorrespondence() {
    }

    public TbluCorrespondence(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.correspondence = fields[0].replace(String.valueOf(this.enclosure), "");
        this.active = fields[1].replace(String.valueOf(this.enclosure), "").equals("1");
        this.followupletter = fields[2].replace(String.valueOf(this.enclosure), "").equals("1");
        this.templatepath = fields[3].replace(String.valueOf(this.enclosure), "");
        this.demodata = fields[4].replace(String.valueOf(this.enclosure), "").equals("1");
    }

    public String getCorrespondence() {
        return this.correspondence;
    }

    public Boolean getActive() {
        return this.active;
    }

    public Boolean getFollowupletter() {
        return this.followupletter;
    }

    public String getTemplatepath() {
        return this.templatepath;
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

    public List<String> getColumnNames() {
        if (this.columnNames == null) {
            columnNames = new ArrayList<String>();
            columnNames.add("Correspondence");
            columnNames.add("Active");
            columnNames.add("FollowupLetter");
            columnNames.add("TemplatePath");
            columnNames.add("DemoData");
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.correspondence == null ? "" : this.correspondence);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.active ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.followupletter ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.templatepath == null ? "" : this.templatepath);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.demodata ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
