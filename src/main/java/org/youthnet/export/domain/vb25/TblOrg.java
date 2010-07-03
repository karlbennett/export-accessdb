package org.youthnet.export.domain.vb25;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TblOrg {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 35;

    private Integer orgid;
    private String orgenteredid;
    private String name;
    private String address1;
    private String address2;
    private String town;
    private String county;
    private String postcode;
    private String tel1;
    private String fax;
    private String email;
    private String www;
    private String geographicalarea;
    private String directions;
    private String firstname;
    private String lastname;
    private String title;
    private String salutation;
    private String jobtitle;
    private String contacttel1;
    private String contactfax;
    private String contactemail;
    private String contactwww;
    private String mission;
    private String activities;
    private Timestamp datefirstentered;
    private Timestamp datelastupdated;
    private String lastupdatedby;
    private String contactaddress1;
    private String contactaddress2;
    private String contacttown;
    private String contactcounty;
    private String contactpostcode;
    private String telfaxsearch;
    private Boolean demodata;


    public TblOrg(String record) {
        String[] fields = record.split(DELIMITER);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        this.orgid = Integer.parseInt(fields[0].substring(1, fields[0].length() - 1));
        this.orgenteredid = fields[1].substring(1, fields[1].length() - 1);
        this.name = fields[2].substring(1, fields[2].length() - 1);
        this.address1 = fields[3].substring(1, fields[3].length() - 1);
        this.address2 = fields[4].substring(1, fields[4].length() - 1);
        this.town = fields[5].substring(1, fields[5].length() - 1);
        this.county = fields[6].substring(1, fields[6].length() - 1);
        this.postcode = fields[7].substring(1, fields[7].length() - 1);
        this.tel1 = fields[8].substring(1, fields[8].length() - 1);
        this.fax = fields[9].substring(1, fields[9].length() - 1);
        this.email = fields[10].substring(1, fields[10].length() - 1);
        this.www = fields[11].substring(1, fields[11].length() - 1);
        this.geographicalarea = fields[12].substring(1, fields[12].length() - 1);
        this.directions = fields[13].substring(1, fields[13].length() - 1);
        this.firstname = fields[14].substring(1, fields[14].length() - 1);
        this.lastname = fields[15].substring(1, fields[15].length() - 1);
        this.title = fields[16].substring(1, fields[16].length() - 1);
        this.salutation = fields[17].substring(1, fields[17].length() - 1);
        this.jobtitle = fields[18].substring(1, fields[18].length() - 1);
        this.contacttel1 = fields[19].substring(1, fields[19].length() - 1);
        this.contactfax = fields[20].substring(1, fields[20].length() - 1);
        this.contactemail = fields[21].substring(1, fields[21].length() - 1);
        this.contactwww = fields[22].substring(1, fields[22].length() - 1);
        this.mission = fields[23].substring(1, fields[23].length() - 1);
        this.activities = fields[24].substring(1, fields[24].length() - 1);
        try {
            this.datefirstentered = new Timestamp(
                    simpleDateFormat.parse(fields[25].substring(1, fields[25].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datefirstentered date " + fields[25].substring(1, fields[25].length() - 1)
                    + " in row " + this.orgid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.datelastupdated = new Timestamp(
                    simpleDateFormat.parse(fields[26].substring(1, fields[26].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datelastupdated date " + fields[26].substring(1, fields[26].length() - 1)
                    + " in row " + this.orgid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.lastupdatedby = fields[27].substring(1, fields[27].length() - 1);
        this.contactaddress1 = fields[28].substring(1, fields[28].length() - 1);
        this.contactaddress2 = fields[29].substring(1, fields[29].length() - 1);
        this.contacttown = fields[30].substring(1, fields[30].length() - 1);
        this.contactcounty = fields[31].substring(1, fields[31].length() - 1);
        this.contactpostcode = fields[32].substring(1, fields[32].length() - 1);
        this.telfaxsearch = fields[33].substring(1, fields[33].length() - 1);
        this.demodata = fields[34].substring(1, fields[34].length() - 1).equals("1");
    }

    public Integer getOrgid() {
        return this.orgid;
    }

    public String getOrgenteredid() {
        return this.orgenteredid;
    }

    public String getName() {
        return this.name;
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

    public String getGeographicalarea() {
        return this.geographicalarea;
    }

    public String getDirections() {
        return this.directions;
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

    public String getJobtitle() {
        return this.jobtitle;
    }

    public String getContacttel1() {
        return this.contacttel1;
    }

    public String getContactfax() {
        return this.contactfax;
    }

    public String getContactemail() {
        return this.contactemail;
    }

    public String getContactwww() {
        return this.contactwww;
    }

    public String getMission() {
        return this.mission;
    }

    public String getActivities() {
        return this.activities;
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

    public String getContactaddress1() {
        return this.contactaddress1;
    }

    public String getContactaddress2() {
        return this.contactaddress2;
    }

    public String getContacttown() {
        return this.contacttown;
    }

    public String getContactcounty() {
        return this.contactcounty;
    }

    public String getContactpostcode() {
        return this.contactpostcode;
    }

    public String getTelfaxsearch() {
        return this.telfaxsearch;
    }

    public Boolean getDemodata() {
        return this.demodata;
    }

}
