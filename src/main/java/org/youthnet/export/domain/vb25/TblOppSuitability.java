package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class TblOppSuitability implements CSVable, ContainsOid {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 3;

    private List<String[]> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private Long id;
    private Long oid;
    private Long sid;


    public TblOppSuitability() {
    }

    public TblOppSuitability(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.id = (fields[0].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[0].replace(String.valueOf(this.enclosure), ""));
        this.oid = (fields[1].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[1].replace(String.valueOf(this.enclosure), ""));
        this.sid = (fields[2].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[2].replace(String.valueOf(this.enclosure), ""));
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

    public void setEnclosure(char enclosure) {
        this.enclosure = enclosure;
    }

    public Integer getColumnNumber() {
        return COLUMN_NUM;
    }

    public List<String[]> getColumnNames() {
        if (this.columnNames == null) {
            columnNames = new ArrayList<String[]>();
            columnNames.add(new String[]{"ID, Long"});
            columnNames.add(new String[]{"OID, Long"});
            columnNames.add(new String[]{"SID, Long"});
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
        record.append(this.oid == null ? "" : this.oid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.sid == null ? "" : this.sid);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
