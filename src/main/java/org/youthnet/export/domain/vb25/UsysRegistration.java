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

    private List<String[]> columnNames = null;

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


    public UsysRegistration() {
    }

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
            this.datefirstentered = (fields[11].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
                    simpleDateFormat.parse(fields[11].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datefirstentered Timestamp " + fields[11].replace(String.valueOf(this.enclosure), "")
                    + " in row " + this.shortname + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.datelastupdated = (fields[12].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
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

    public void setEnclosure(char enclosure) {
        this.enclosure = enclosure;
    }

    public Integer getColumnNumber() {
        return COLUMN_NUM;
    }

    public List<String[]> getColumnNames() {
        if (this.columnNames == null) {
            columnNames = new ArrayList<String[]>();
            columnNames.add(new String[]{"ShortName, String"});
            columnNames.add(new String[]{"Address1, String"});
            columnNames.add(new String[]{"Address2, String"});
            columnNames.add(new String[]{"Town, String"});
            columnNames.add(new String[]{"County, String"});
            columnNames.add(new String[]{"Postcode, String"});
            columnNames.add(new String[]{"Tel1, String"});
            columnNames.add(new String[]{"Fax, String"});
            columnNames.add(new String[]{"Email, String"});
            columnNames.add(new String[]{"WWW, String"});
            columnNames.add(new String[]{"DefaultOrg, Boolean"});
            columnNames.add(new String[]{"DateFirstEntered, Timestamp"});
            columnNames.add(new String[]{"DateLastUpdated, Timestamp"});
            columnNames.add(new String[]{"LastUpdatedBy, String"});
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.shortname == null ? "" : this.shortname);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.address1 == null ? "" : this.address1);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.address2 == null ? "" : this.address2);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.town == null ? "" : this.town);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.county == null ? "" : this.county);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.postcode == null ? "" : this.postcode);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.tel1 == null ? "" : this.tel1);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.fax == null ? "" : this.fax);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.email == null ? "" : this.email);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.www == null ? "" : this.www);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.defaultorg != null && defaultorg ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.datefirstentered == null ? "" : this.datefirstentered);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.datelastupdated == null ? "" : this.datelastupdated);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.lastupdatedby == null ? "" : this.lastupdatedby);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
