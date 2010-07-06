package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class TblVol implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 36;

    private List<String> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private Long vid;
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


    public TblVol() {
    }

    public TblVol(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        this.vid = (fields[0].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[0].replace(String.valueOf(this.enclosure), ""));
        this.firstname = fields[1].replace(String.valueOf(this.enclosure), "");
        this.lastname = fields[2].replace(String.valueOf(this.enclosure), "");
        this.title = fields[3].replace(String.valueOf(this.enclosure), "");
        this.salutation = fields[4].replace(String.valueOf(this.enclosure), "");
        this.address1 = fields[5].replace(String.valueOf(this.enclosure), "");
        this.address2 = fields[6].replace(String.valueOf(this.enclosure), "");
        this.town = fields[7].replace(String.valueOf(this.enclosure), "");
        this.county = fields[8].replace(String.valueOf(this.enclosure), "");
        this.postcode = fields[9].replace(String.valueOf(this.enclosure), "");
        this.telday = fields[10].replace(String.valueOf(this.enclosure), "");
        this.televening = fields[11].replace(String.valueOf(this.enclosure), "");
        this.fax = fields[12].replace(String.valueOf(this.enclosure), "");
        this.email = fields[13].replace(String.valueOf(this.enclosure), "");
        this.geographicalarea = fields[14].replace(String.valueOf(this.enclosure), "");
        this.howheard = fields[15].replace(String.valueOf(this.enclosure), "");
        this.previouswork = fields[16].replace(String.valueOf(this.enclosure), "");
        this.status = fields[17].replace(String.valueOf(this.enclosure), "");
        try {
            this.dob = (fields[18].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
                    simpleDateFormat.parse(fields[18].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars dob Timestamp " + fields[18].replace(String.valueOf(this.enclosure), "")
                    + " in row " + this.vid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.gender = fields[19].replace(String.valueOf(this.enclosure), "");
        this.agerange = fields[20].replace(String.valueOf(this.enclosure), "");
        this.employmentstatus = fields[21].replace(String.valueOf(this.enclosure), "");
        this.ethnicity = fields[22].replace(String.valueOf(this.enclosure), "");
        this.religion = fields[23].replace(String.valueOf(this.enclosure), "");
        this.nationality = fields[24].replace(String.valueOf(this.enclosure), "");
        this.disabilitystatus = fields[25].replace(String.valueOf(this.enclosure), "");
        this.driving = fields[26].replace(String.valueOf(this.enclosure), "");
        this.typeofdrivinglicence = fields[27].replace(String.valueOf(this.enclosure), "");
        try {
            this.datefirstentered = (fields[28].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
                    simpleDateFormat.parse(fields[28].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datefirstentered Timestamp " + fields[28].replace(String.valueOf(this.enclosure), "")
                    + " in row " + this.vid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.datelastupdated = (fields[29].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
                    simpleDateFormat.parse(fields[29].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datelastupdated Timestamp " + fields[29].replace(String.valueOf(this.enclosure), "")
                    + " in row " + this.vid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.lastupdatedby = fields[30].replace(String.valueOf(this.enclosure), "");
        this.telfaxsearch = fields[31].replace(String.valueOf(this.enclosure), "");
        this.mobile = fields[32].replace(String.valueOf(this.enclosure), "");
        this.contactable = fields[33].replace(String.valueOf(this.enclosure), "").equals("1");
        this.webid = fields[34].replace(String.valueOf(this.enclosure), "");
        this.demodata = fields[35].replace(String.valueOf(this.enclosure), "").equals("1");
    }

    public Long getVid() {
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

    public List<String> getColumnNames() {
        if (this.columnNames == null) {
            columnNames = new ArrayList<String>();
            columnNames.add("VID");
            columnNames.add("FirstName");
            columnNames.add("LastName");
            columnNames.add("Title");
            columnNames.add("Salutation");
            columnNames.add("Address1");
            columnNames.add("Address2");
            columnNames.add("Town");
            columnNames.add("County");
            columnNames.add("Postcode");
            columnNames.add("TelDay");
            columnNames.add("TelEvening");
            columnNames.add("Fax");
            columnNames.add("Email");
            columnNames.add("GeographicalArea");
            columnNames.add("HowHeard");
            columnNames.add("PreviousWork");
            columnNames.add("Status");
            columnNames.add("DOB");
            columnNames.add("Gender");
            columnNames.add("AgeRange");
            columnNames.add("EmploymentStatus");
            columnNames.add("Ethnicity");
            columnNames.add("Religion");
            columnNames.add("Nationality");
            columnNames.add("DisabilityStatus");
            columnNames.add("Driving");
            columnNames.add("TypeOfDrivingLicence");
            columnNames.add("DateFirstEntered");
            columnNames.add("DateLastUpdated");
            columnNames.add("LastUpdatedBy");
            columnNames.add("TelFaxSearch");
            columnNames.add("Mobile");
            columnNames.add("Contactable");
            columnNames.add("WebID");
            columnNames.add("DemoData");
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.vid == null ? "" : this.vid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.firstname == null ? "" : this.firstname);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.lastname == null ? "" : this.lastname);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.title == null ? "" : this.title);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.salutation == null ? "" : this.salutation);
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
        record.append(this.telday == null ? "" : this.telday);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.televening == null ? "" : this.televening);
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
        record.append(this.geographicalarea == null ? "" : this.geographicalarea);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.howheard == null ? "" : this.howheard);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.previouswork == null ? "" : this.previouswork);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.status == null ? "" : this.status);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.dob == null ? "" : this.dob);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.gender == null ? "" : this.gender);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.agerange == null ? "" : this.agerange);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.employmentstatus == null ? "" : this.employmentstatus);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.ethnicity == null ? "" : this.ethnicity);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.religion == null ? "" : this.religion);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.nationality == null ? "" : this.nationality);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.disabilitystatus == null ? "" : this.disabilitystatus);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.driving == null ? "" : this.driving);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.typeofdrivinglicence == null ? "" : this.typeofdrivinglicence);
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
        record.append(this.enclosure);
        record.append(this.telfaxsearch == null ? "" : this.telfaxsearch);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.mobile == null ? "" : this.mobile);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.contactable ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.webid == null ? "" : this.webid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.demodata ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
