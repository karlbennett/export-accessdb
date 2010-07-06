package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class TblOppSuitability implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 3;

    private List<String> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private Long id;
    private Long oid;
    private Long sid;


    public TblOppSuitability(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.id = Long.valueOf(fields[0].replace(String.valueOf(this.enclosure), ""));
        this.oid = Long.valueOf(fields[1].replace(String.valueOf(this.enclosure), ""));
        this.sid = Long.valueOf(fields[2].replace(String.valueOf(this.enclosure), ""));
    }

    public Long getId() {
        return this.id;
    }

    public Long getOid() {
        return this.oid;
    }

    public Long getSid() {
        return this.sid;
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
            columnNames.add("ID");
            columnNames.add("OID");
            columnNames.add("SID");
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.id);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.oid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.sid);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
