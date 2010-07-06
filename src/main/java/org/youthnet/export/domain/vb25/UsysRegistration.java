package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class UsysRegistration implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 14;

    private List<String> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private String shortname;
    private String address1;
    private String address2;
    private String town;
    private String county;
    private String postcode;
    private String tel1;
    private String fax;
    private String email;
    private String www;
    private Boolean defaultorg;
    private Timestamp datefirstentered;
    private Timestamp datelastupdated;
    private String lastupdatedby;


    public UsysRegistration(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        this.shortname = fields[0].replace(String.valueOf(this.enclosure), "");
        this.address1 = fields[1].replace(String.valueOf(this.enclosure), "");
        this.address2 = fields[2].replace(String.valueOf(this.enclosure), "");
        this.town = fields[3].replace(String.valueOf(this.enclosure), "");
        this.county = fields[4].replace(String.valueOf(this.enclosure), "");
        this.postcode = fields[5].replace(String.valueOf(this.enclosure), "");
        this.tel1 = fields[6].replace(String.valueOf(this.enclosure), "");
        this.fax = fields[7].replace(String.valueOf(this.enclosure), "");
        this.email = fields[8].replace(String.valueOf(this.enclosure), "");
        this.www = fields[9].replace(String.valueOf(this.enclosure), "");
        this.defaultorg = fields[10].replace(String.valueOf(this.enclosure), "").equals("1");
        try {
            this.datefirstentered = new Timestamp(
                    simpleDateFormat.parse(fields[11].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datefirstentered Timestamp " + fields[11].replace(String.valueOf(this.enclosure), "")
                    + " in row " + this.shortname + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.datelastupdated = new Timestamp(
                    simpleDateFormat.parse(fields[12].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datelastupdated Timestamp " + fields[12].replace(String.valueOf(this.enclosure), "")
                    + " in row " + this.shortname + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.lastupdatedby = fields[13].replace(String.valueOf(this.enclosure), "");
    }

    public String getShortname() {
        return this.shortname;
    }

    public String getAddress1() {
        return this.address1;
    }

    public String getAddress2() {
        return this.address2;
    }

    public String getTown() {
        return this.town;
    }

    public String getCounty() {
        return this.county;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public String getTel1() {
        return this.tel1;
    }

    public String getFax() {
        return this.fax;
    }

    public String getEmail() {
        return this.email;
    }

    public String getWww() {
        return this.www;
    }

    public Boolean getDefaultorg() {
        return this.defaultorg;
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
            columnNames.add("ShortName");
            columnNames.add("Address1");
            columnNames.add("Address2");
            columnNames.add("Town");
            columnNames.add("County");
            columnNames.add("Postcode");
            columnNames.add("Tel1");
            columnNames.add("Fax");
            columnNames.add("Email");
            columnNames.add("WWW");
            columnNames.add("DefaultOrg");
            columnNames.add("DateFirstEntered");
            columnNames.add("DateLastUpdated");
            columnNames.add("LastUpdatedBy");
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.shortname);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.address1);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.address2);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.town);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.county);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.postcode);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.tel1);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.fax);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.email);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.www);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.defaultorg ? 1 : 0);
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
