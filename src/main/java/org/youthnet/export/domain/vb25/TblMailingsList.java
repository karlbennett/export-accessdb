package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class TblMailingsList implements CSVable, ContainsVid, ContainsOid, ContainsOrgid {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 6;

    private List<String[]> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private Long mid;
    private String mailing;
    private Long vid;
    private Long oid;
    private Long orgid;
    private Boolean emailpreference;


    public TblMailingsList() {
    }

    public TblMailingsList(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.mid = (fields[0].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[0].replace(String.valueOf(this.enclosure), ""));
        this.mailing = fields[1].replace(String.valueOf(this.enclosure), "");
        this.vid = (fields[2].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[2].replace(String.valueOf(this.enclosure), ""));
        this.oid = (fields[3].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[3].replace(String.valueOf(this.enclosure), ""));
        this.orgid = (fields[4].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[4].replace(String.valueOf(this.enclosure), ""));
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

    public void setEnclosure(char enclosure) {
        this.enclosure = enclosure;
    }

    public Integer getColumnNumber() {
        return COLUMN_NUM;
    }

    public List<String[]> getColumnNames() {
        if (this.columnNames == null) {
            columnNames = new ArrayList<String[]>();
            columnNames.add(new String[]{"MID, Long"});
            columnNames.add(new String[]{"Mailing, String"});
            columnNames.add(new String[]{"VID, Long"});
            columnNames.add(new String[]{"OID, Long"});
            columnNames.add(new String[]{"OrgID, Long"});
            columnNames.add(new String[]{"EmailPreference, Boolean"});
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.mid == null ? "" : this.mid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.mailing == null ? "" : this.mailing);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.vid == null ? "" : this.vid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.oid == null ? "" : this.oid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.orgid == null ? "" : this.orgid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.emailpreference != null && emailpreference ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
