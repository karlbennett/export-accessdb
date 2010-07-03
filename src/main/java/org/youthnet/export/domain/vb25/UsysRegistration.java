package org.youthnet.export.domain.vb25;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UsysRegistration {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 14;

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
        String[] fields = record.split(DELIMITER);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        this.shortname = fields[0].substring(1, fields[0].length() - 1);
        this.address1 = fields[1].substring(1, fields[1].length() - 1);
        this.address2 = fields[2].substring(1, fields[2].length() - 1);
        this.town = fields[3].substring(1, fields[3].length() - 1);
        this.county = fields[4].substring(1, fields[4].length() - 1);
        this.postcode = fields[5].substring(1, fields[5].length() - 1);
        this.tel1 = fields[6].substring(1, fields[6].length() - 1);
        this.fax = fields[7].substring(1, fields[7].length() - 1);
        this.email = fields[8].substring(1, fields[8].length() - 1);
        this.www = fields[9].substring(1, fields[9].length() - 1);
        this.defaultorg = fields[10].substring(1, fields[10].length() - 1).equals("1");
        try {
            this.datefirstentered = new Timestamp(
                    simpleDateFormat.parse(fields[11].substring(1, fields[11].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datefirstentered date " + fields[11].substring(1, fields[11].length() - 1)
                    + " in row " + this.shortname + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.datelastupdated = new Timestamp(
                    simpleDateFormat.parse(fields[12].substring(1, fields[12].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datelastupdated date " + fields[12].substring(1, fields[12].length() - 1)
                    + " in row " + this.shortname + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.lastupdatedby = fields[13].substring(1, fields[13].length() - 1);
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

}
