package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class TblOppRecruitmentMethod implements CSVable, ContainsOid {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 3;

    private List<String[]> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private Long rid;
    private Long oid;
    private String recruitmentmethod;


    public TblOppRecruitmentMethod() {
    }

    public TblOppRecruitmentMethod(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.rid = (fields[0].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[0].replace(String.valueOf(this.enclosure), ""));
        this.oid = (fields[1].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[1].replace(String.valueOf(this.enclosure), ""));
        this.recruitmentmethod = fields[2].replace(String.valueOf(this.enclosure), "");
    }

    public Long getRid() {
        return this.rid;
    }

    public Long getOid() {
        return this.oid;
    }

    public String getRecruitmentmethod() {
        return this.recruitmentmethod;
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
            columnNames.add(new String[]{"RID, Long"});
            columnNames.add(new String[]{"OID, Long"});
            columnNames.add(new String[]{"RecruitmentMethod, String"});
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.rid == null ? "" : this.rid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.oid == null ? "" : this.oid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.recruitmentmethod == null ? "" : this.recruitmentmethod);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
