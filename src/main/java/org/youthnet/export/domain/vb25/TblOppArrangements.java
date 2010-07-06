package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class TblOppArrangements implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 4;

    private List<String> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private Long aid;
    private Long oid;
    private String opparrangements;
    private String details;


    public TblOppArrangements(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.aid = Long.valueOf(fields[0].replace(String.valueOf(this.enclosure), ""));
        this.oid = Long.valueOf(fields[1].replace(String.valueOf(this.enclosure), ""));
        this.opparrangements = fields[2].replace(String.valueOf(this.enclosure), "");
        this.details = fields[3].replace(String.valueOf(this.enclosure), "");
    }

    public Long getAid() {
        return this.aid;
    }

    public Long getOid() {
        return this.oid;
    }

    public String getOpparrangements() {
        return this.opparrangements;
    }

    public String getDetails() {
        return this.details;
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
            columnNames.add("AID");
            columnNames.add("OID");
            columnNames.add("OppArrangements");
            columnNames.add("Details");
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.aid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.oid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.opparrangements);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.details);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
