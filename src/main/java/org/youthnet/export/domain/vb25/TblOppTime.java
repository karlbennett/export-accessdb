package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class TblOppTime implements CSVable, ContainsOid {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 4;

    private List<String[]> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private Long tid;
    private Long oid;
    private String day;
    private String timeslot;


    public TblOppTime() {
    }

    public TblOppTime(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.tid = (fields[0].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[0].replace(String.valueOf(this.enclosure), ""));
        this.oid = (fields[1].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[1].replace(String.valueOf(this.enclosure), ""));
        this.day = fields[2].replace(String.valueOf(this.enclosure), "");
        this.timeslot = fields[3].replace(String.valueOf(this.enclosure), "");
    }

    public Long getTid() {
        return this.tid;
    }

    public Long getOid() {
        return this.oid;
    }

    public String getDay() {
        return this.day;
    }

    public String getTimeslot() {
        return this.timeslot;
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
            columnNames.add(new String[]{"TID, Long"});
            columnNames.add(new String[]{"OID, Long"});
            columnNames.add(new String[]{"Day, String"});
            columnNames.add(new String[]{"Timeslot, String"});
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.tid == null ? "" : this.tid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.oid == null ? "" : this.oid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.day == null ? "" : this.day);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.timeslot == null ? "" : this.timeslot);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
