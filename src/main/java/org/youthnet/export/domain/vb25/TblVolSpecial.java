package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class TblVolSpecial implements CSVable, ContainsVid {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 3;

    private List<String[]> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private Long sid;
    private Long vid;
    private String special;


    public TblVolSpecial() {
    }

    public TblVolSpecial(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.sid = (fields[0].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[0].replace(String.valueOf(this.enclosure), ""));
        this.vid = (fields[1].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[1].replace(String.valueOf(this.enclosure), ""));
        this.special = fields[2].replace(String.valueOf(this.enclosure), "");
    }

    public Long getSid() {
        return this.sid;
    }

    public Long getVid() {
        return this.vid;
    }

    public String getSpecial() {
        return this.special;
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
            columnNames.add(new String[]{"SID, Long"});
            columnNames.add(new String[]{"VID, Long"});
            columnNames.add(new String[]{"Special, String"});
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.sid == null ? "" : this.sid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.vid == null ? "" : this.vid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.special == null ? "" : this.special);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
