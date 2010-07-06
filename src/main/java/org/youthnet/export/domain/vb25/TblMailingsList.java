package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class TblMailingsList implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 6;

    private List<String> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private Long mid;
    private String mailing;
    private Long vid;
    private Long oid;
    private Long orgid;
    private Boolean emailpreference;


    public TblMailingsList(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.mid = Long.valueOf(fields[0].replace(String.valueOf(this.enclosure), ""));
        this.mailing = fields[1].replace(String.valueOf(this.enclosure), "");
        this.vid = Long.valueOf(fields[2].replace(String.valueOf(this.enclosure), ""));
        this.oid = Long.valueOf(fields[3].replace(String.valueOf(this.enclosure), ""));
        this.orgid = Long.valueOf(fields[4].replace(String.valueOf(this.enclosure), ""));
        this.emailpreference = fields[5].replace(String.valueOf(this.enclosure), "").equals("1");
    }

    public Long getMid() {
        return this.mid;
    }

    public String getMailing() {
        return this.mailing;
    }

    public Long getVid() {
        return this.vid;
    }

    public Long getOid() {
        return this.oid;
    }

    public Long getOrgid() {
        return this.orgid;
    }

    public Boolean getEmailpreference() {
        return this.emailpreference;
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
            columnNames.add("MID");
            columnNames.add("Mailing");
            columnNames.add("VID");
            columnNames.add("OID");
            columnNames.add("OrgID");
            columnNames.add("EmailPreference");
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.mid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.mailing);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.vid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.oid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.orgid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.emailpreference ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
