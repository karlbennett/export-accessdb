package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class TblMailings implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 10;

    private List<String> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private String mailing;
    private Short no;
    private String description;
    private String fields;
    private Short icon;
    private Boolean email;
    private String owner;
    private Timestamp datefirstentered;
    private Timestamp datelastupdated;
    private String lastupdatedby;


    public TblMailings() {
    }

    public TblMailings(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        this.mailing = fields[0].replace(String.valueOf(this.enclosure), "");
        this.no = (fields[1].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Short.valueOf(fields[1].replace(String.valueOf(this.enclosure), ""));
        this.description = fields[2].replace(String.valueOf(this.enclosure), "");
        this.fields = fields[3].replace(String.valueOf(this.enclosure), "");
        this.icon = (fields[4].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Short.valueOf(fields[4].replace(String.valueOf(this.enclosure), ""));
        this.email = fields[5].replace(String.valueOf(this.enclosure), "").equals("1");
        this.owner = fields[6].replace(String.valueOf(this.enclosure), "");
        try {
            this.datefirstentered = (fields[7].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
                    simpleDateFormat.parse(fields[7].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datefirstentered Timestamp " + fields[7].replace(String.valueOf(this.enclosure), "")
                    + " in row " + this.mailing + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.datelastupdated = (fields[8].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
                    simpleDateFormat.parse(fields[8].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datelastupdated Timestamp " + fields[8].replace(String.valueOf(this.enclosure), "")
                    + " in row " + this.mailing + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.lastupdatedby = fields[9].replace(String.valueOf(this.enclosure), "");
    }

    public String getMailing() {
        return this.mailing;
    }

    public Short getNo() {
        return this.no;
    }

    public String getDescription() {
        return this.description;
    }

    public String getFields() {
        return this.fields;
    }

    public Short getIcon() {
        return this.icon;
    }

    public Boolean getEmail() {
        return this.email;
    }

    public String getOwner() {
        return this.owner;
    }

    public Timestamp getDatefirstentered() {
        return this.datefirstentered;
    }

    public Timestamp getDatelastupdated() {
        return this.datelastupdated;
    }

    public String getLastupdatedby() {
        return this.lastupdatedby;
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
            columnNames.add("Mailing");
            columnNames.add("No");
            columnNames.add("Description");
            columnNames.add("Fields");
            columnNames.add("Icon");
            columnNames.add("Email");
            columnNames.add("Owner");
            columnNames.add("DateFirstEntered");
            columnNames.add("DateLastUpdated");
            columnNames.add("LastUpdatedBy");
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.mailing);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.no);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.description);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.fields);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.icon);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.email ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.owner);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.datefirstentered);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.datelastupdated);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.lastupdatedby);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
