package org.youthnet.export.domain.vb25;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TblVol {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 36;

    private Integer vid;
    private String firstname;
    private String lastname;
    private String title;
    private String salutation;
    private String address1;
    private String address2;
    private String town;
    private String county;
    private String postcode;
    private String telday;
    private String televening;
    private String fax;
    private String email;
    private String geographicalarea;
    private String howheard;
    private String previouswork;
    private String status;
    private Timestamp dob;
    private String gender;
    private String agerange;
    private String employmentstatus;
    private String ethnicity;
    private String religion;
    private String nationality;
    private String disabilitystatus;
    private String driving;
    private String typeofdrivinglicence;
    private Timestamp datefirstentered;
    private Timestamp datelastupdated;
    private String lastupdatedby;
    private String telfaxsearch;
    private String mobile;
    private Boolean contactable;
    private String webid;
    private Boolean demodata;


    public TblVol(String record) {
        String[] fields = record.split(DELIMITER);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        this.vid = Integer.parseInt(fields[0].substring(1, fields[0].length() - 1));
        this.firstname = fields[1].substring(1, fields[1].length() - 1);
        this.lastname = fields[2].substring(1, fields[2].length() - 1);
        this.title = fields[3].substring(1, fields[3].length() - 1);
        this.salutation = fields[4].substring(1, fields[4].length() - 1);
        this.address1 = fields[5].substring(1, fields[5].length() - 1);
        this.address2 = fields[6].substring(1, fields[6].length() - 1);
        this.town = fields[7].substring(1, fields[7].length() - 1);
        this.county = fields[8].substring(1, fields[8].length() - 1);
        this.postcode = fields[9].substring(1, fields[9].length() - 1);
        this.telday = fields[10].substring(1, fields[10].length() - 1);
        this.televening = fields[11].substring(1, fields[11].length() - 1);
        this.fax = fields[12].substring(1, fields[12].length() - 1);
        this.email = fields[13].substring(1, fields[13].length() - 1);
        this.geographicalarea = fields[14].substring(1, fields[14].length() - 1);
        this.howheard = fields[15].substring(1, fields[15].length() - 1);
        this.previouswork = fields[16].substring(1, fields[16].length() - 1);
        this.status = fields[17].substring(1, fields[17].length() - 1);
        try {
            this.dob = new Timestamp(
                    simpleDateFormat.parse(fields[18].substring(1, fields[18].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars dob date " + fields[18].substring(1, fields[18].length() - 1)
                    + " in row " + this.vid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.gender = fields[19].substring(1, fields[19].length() - 1);
        this.agerange = fields[20].substring(1, fields[20].length() - 1);
        this.employmentstatus = fields[21].substring(1, fields[21].length() - 1);
        this.ethnicity = fields[22].substring(1, fields[22].length() - 1);
        this.religion = fields[23].substring(1, fields[23].length() - 1);
        this.nationality = fields[24].substring(1, fields[24].length() - 1);
        this.disabilitystatus = fields[25].substring(1, fields[25].length() - 1);
        this.driving = fields[26].substring(1, fields[26].length() - 1);
        this.typeofdrivinglicence = fields[27].substring(1, fields[27].length() - 1);
        try {
            this.datefirstentered = new Timestamp(
                    simpleDateFormat.parse(fields[28].substring(1, fields[28].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datefirstentered date " + fields[28].substring(1, fields[28].length() - 1)
                    + " in row " + this.vid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.datelastupdated = new Timestamp(
                    simpleDateFormat.parse(fields[29].substring(1, fields[29].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datelastupdated date " + fields[29].substring(1, fields[29].length() - 1)
                    + " in row " + this.vid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.lastupdatedby = fields[30].substring(1, fields[30].length() - 1);
        this.telfaxsearch = fields[31].substring(1, fields[31].length() - 1);
        this.mobile = fields[32].substring(1, fields[32].length() - 1);
        this.contactable = fields[33].substring(1, fields[33].length() - 1).equals("1");
        this.webid = fields[34].substring(1, fields[34].length() - 1);
        this.demodata = fields[35].substring(1, fields[35].length() - 1).equals("1");
    }

    public Integer getVid() {
        return this.vid;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSalutation() {
        return this.salutation;
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

    public String getTelday() {
        return this.telday;
    }

    public String getTelevening() {
        return this.televening;
    }

    public String getFax() {
        return this.fax;
    }

    public String getEmail() {
        return this.email;
    }

    public String getGeographicalarea() {
        return this.geographicalarea;
    }

    public String getHowheard() {
        return this.howheard;
    }

    public String getPreviouswork() {
        return this.previouswork;
    }

    public String getStatus() {
        return this.status;
    }

    public Timestamp getDob() {
        return this.dob;
    }

    public String getGender() {
        return this.gender;
    }

    public String getAgerange() {
        return this.agerange;
    }

    public String getEmploymentstatus() {
        return this.employmentstatus;
    }

    public String getEthnicity() {
        return this.ethnicity;
    }

    public String getReligion() {
        return this.religion;
    }

    public String getNationality() {
        return this.nationality;
    }

    public String getDisabilitystatus() {
        return this.disabilitystatus;
    }

    public String getDriving() {
        return this.driving;
    }

    public String getTypeofdrivinglicence() {
        return this.typeofdrivinglicence;
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

    public String getTelfaxsearch() {
        return this.telfaxsearch;
    }

    public String getMobile() {
        return this.mobile;
    }

    public Boolean getContactable() {
        return this.contactable;
    }

    public String getWebid() {
        return this.webid;
    }

    public Boolean getDemodata() {
        return this.demodata;
    }

}
