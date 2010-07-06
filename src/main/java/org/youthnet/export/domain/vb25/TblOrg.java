package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class TblOrg implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 35;

    private List<String> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private Long orgid;
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


    public TblOrg() {
    }

    public TblOrg(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        this.orgid = (fields[0].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[0].replace(String.valueOf(this.enclosure), ""));
        this.orgenteredid = fields[1].replace(String.valueOf(this.enclosure), "");
        this.name = fields[2].replace(String.valueOf(this.enclosure), "");
        this.address1 = fields[3].replace(String.valueOf(this.enclosure), "");
        this.address2 = fields[4].replace(String.valueOf(this.enclosure), "");
        this.town = fields[5].replace(String.valueOf(this.enclosure), "");
        this.county = fields[6].replace(String.valueOf(this.enclosure), "");
        this.postcode = fields[7].replace(String.valueOf(this.enclosure), "");
        this.tel1 = fields[8].replace(String.valueOf(this.enclosure), "");
        this.fax = fields[9].replace(String.valueOf(this.enclosure), "");
        this.email = fields[10].replace(String.valueOf(this.enclosure), "");
        this.www = fields[11].replace(String.valueOf(this.enclosure), "");
        this.geographicalarea = fields[12].replace(String.valueOf(this.enclosure), "");
        this.directions = fields[13].replace(String.valueOf(this.enclosure), "");
        this.firstname = fields[14].replace(String.valueOf(this.enclosure), "");
        this.lastname = fields[15].replace(String.valueOf(this.enclosure), "");
        this.title = fields[16].replace(String.valueOf(this.enclosure), "");
        this.salutation = fields[17].replace(String.valueOf(this.enclosure), "");
        this.jobtitle = fields[18].replace(String.valueOf(this.enclosure), "");
        this.contacttel1 = fields[19].replace(String.valueOf(this.enclosure), "");
        this.contactfax = fields[20].replace(String.valueOf(this.enclosure), "");
        this.contactemail = fields[21].replace(String.valueOf(this.enclosure), "");
        this.contactwww = fields[22].replace(String.valueOf(this.enclosure), "");
        this.mission = fields[23].replace(String.valueOf(this.enclosure), "");
        this.activities = fields[24].replace(String.valueOf(this.enclosure), "");
        try {
            this.datefirstentered = (fields[25].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
                    simpleDateFormat.parse(fields[25].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datefirstentered Timestamp " + fields[25].replace(String.valueOf(this.enclosure), "")
                    + " in row " + this.orgid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.datelastupdated = (fields[26].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
                    simpleDateFormat.parse(fields[26].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datelastupdated Timestamp " + fields[26].replace(String.valueOf(this.enclosure), "")
                    + " in row " + this.orgid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.lastupdatedby = fields[27].replace(String.valueOf(this.enclosure), "");
        this.contactaddress1 = fields[28].replace(String.valueOf(this.enclosure), "");
        this.contactaddress2 = fields[29].replace(String.valueOf(this.enclosure), "");
        this.contacttown = fields[30].replace(String.valueOf(this.enclosure), "");
        this.contactcounty = fields[31].replace(String.valueOf(this.enclosure), "");
        this.contactpostcode = fields[32].replace(String.valueOf(this.enclosure), "");
        this.telfaxsearch = fields[33].replace(String.valueOf(this.enclosure), "");
        this.demodata = fields[34].replace(String.valueOf(this.enclosure), "").equals("1");
    }

    public Long getOrgid() {
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
            columnNames.add("OrgID");
            columnNames.add("OrgEnteredID");
            columnNames.add("Name");
            columnNames.add("Address1");
            columnNames.add("Address2");
            columnNames.add("Town");
            columnNames.add("County");
            columnNames.add("Postcode");
            columnNames.add("Tel1");
            columnNames.add("Fax");
            columnNames.add("Email");
            columnNames.add("WWW");
            columnNames.add("GeographicalArea");
            columnNames.add("Directions");
            columnNames.add("FirstName");
            columnNames.add("LastName");
            columnNames.add("Title");
            columnNames.add("Salutation");
            columnNames.add("JobTitle");
            columnNames.add("ContactTel1");
            columnNames.add("ContactFax");
            columnNames.add("ContactEmail");
            columnNames.add("ContactWWW");
            columnNames.add("Mission");
            columnNames.add("Activities");
            columnNames.add("DateFirstEntered");
            columnNames.add("DateLastUpdated");
            columnNames.add("LastUpdatedBy");
            columnNames.add("ContactAddress1");
            columnNames.add("ContactAddress2");
            columnNames.add("ContactTown");
            columnNames.add("ContactCounty");
            columnNames.add("ContactPostcode");
            columnNames.add("TelFaxSearch");
            columnNames.add("DemoData");
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.orgid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.orgenteredid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.name);
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
        record.append(this.geographicalarea);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.directions);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.firstname);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.lastname);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.title);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.salutation);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.jobtitle);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.contacttel1);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.contactfax);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.contactemail);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.contactwww);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.mission);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.activities);
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
        record.append(this.enclosure);
        record.append(this.contactaddress1);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.contactaddress2);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.contacttown);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.contactcounty);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.contactpostcode);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.telfaxsearch);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.demodata ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
