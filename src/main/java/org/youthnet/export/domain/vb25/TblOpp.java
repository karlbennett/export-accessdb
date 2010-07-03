package org.youthnet.export.domain.vb25;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TblOpp {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 35;

    private Integer oid;
    private Integer orgid;
    private String oppenteredid;
    private String title;
    private String contact;
    private String address1;
    private String address2;
    private String town;
    private String county;
    private String postcode;
    private String tel1;
    private String fax;
    private String email;
    private String geographicalarea;
    private BigDecimal monetaryvalue;
    private Boolean active;
    private Boolean includeonweb;
    private Boolean oneoff;
    private Boolean includevbaddress;
    private Timestamp oppstartdate;
    private Timestamp oppenddate;
    private String description;
    private String skillsqualifications;
    private String directions;
    private Timestamp datefirstentered;
    private Timestamp datelastupdated;
    private String lastupdatedby;
    private Boolean useorgcontact;
    private String telfaxsearch;
    private Boolean virtualvol;
    private Boolean residential;
    private Timestamp specificstartdate;
    private Timestamp specificenddate;
    private String shortdescription;
    private Boolean demodata;


    public TblOpp(String record) {
        String[] fields = record.split(DELIMITER);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        this.oid = Integer.parseInt(fields[0].substring(1, fields[0].length() - 1));
        this.orgid = Integer.parseInt(fields[1].substring(1, fields[1].length() - 1));
        this.oppenteredid = fields[2].substring(1, fields[2].length() - 1);
        this.title = fields[3].substring(1, fields[3].length() - 1);
        this.contact = fields[4].substring(1, fields[4].length() - 1);
        this.address1 = fields[5].substring(1, fields[5].length() - 1);
        this.address2 = fields[6].substring(1, fields[6].length() - 1);
        this.town = fields[7].substring(1, fields[7].length() - 1);
        this.county = fields[8].substring(1, fields[8].length() - 1);
        this.postcode = fields[9].substring(1, fields[9].length() - 1);
        this.tel1 = fields[10].substring(1, fields[10].length() - 1);
        this.fax = fields[11].substring(1, fields[11].length() - 1);
        this.email = fields[12].substring(1, fields[12].length() - 1);
        this.geographicalarea = fields[13].substring(1, fields[13].length() - 1);
        this.monetaryvalue = new BigDecimal(fields[14].substring(1, fields[14].length() - 1));
        this.active = fields[15].substring(1, fields[15].length() - 1).equals("1");
        this.includeonweb = fields[16].substring(1, fields[16].length() - 1).equals("1");
        this.oneoff = fields[17].substring(1, fields[17].length() - 1).equals("1");
        this.includevbaddress = fields[18].substring(1, fields[18].length() - 1).equals("1");
        try {
            this.oppstartdate = new Timestamp(
                    simpleDateFormat.parse(fields[19].substring(1, fields[19].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars oppstartdate date " + fields[19].substring(1, fields[19].length() - 1)
                    + " in row " + this.oid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.oppenddate = new Timestamp(
                    simpleDateFormat.parse(fields[20].substring(1, fields[20].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars oppenddate date " + fields[20].substring(1, fields[20].length() - 1)
                    + " in row " + this.oid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.description = fields[21].substring(1, fields[21].length() - 1);
        this.skillsqualifications = fields[22].substring(1, fields[22].length() - 1);
        this.directions = fields[23].substring(1, fields[23].length() - 1);
        try {
            this.datefirstentered = new Timestamp(
                    simpleDateFormat.parse(fields[24].substring(1, fields[24].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datefirstentered date " + fields[24].substring(1, fields[24].length() - 1)
                    + " in row " + this.oid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.datelastupdated = new Timestamp(
                    simpleDateFormat.parse(fields[25].substring(1, fields[25].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datelastupdated date " + fields[25].substring(1, fields[25].length() - 1)
                    + " in row " + this.oid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.lastupdatedby = fields[26].substring(1, fields[26].length() - 1);
        this.useorgcontact = fields[27].substring(1, fields[27].length() - 1).equals("1");
        this.telfaxsearch = fields[28].substring(1, fields[28].length() - 1);
        this.virtualvol = fields[29].substring(1, fields[29].length() - 1).equals("1");
        this.residential = fields[30].substring(1, fields[30].length() - 1).equals("1");
        try {
            this.specificstartdate = new Timestamp(
                    simpleDateFormat.parse(fields[31].substring(1, fields[31].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars specificstartdate date " + fields[31].substring(1, fields[31].length() - 1)
                    + " in row " + this.oid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.specificenddate = new Timestamp(
                    simpleDateFormat.parse(fields[32].substring(1, fields[32].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars specificenddate date " + fields[32].substring(1, fields[32].length() - 1)
                    + " in row " + this.oid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.shortdescription = fields[33].substring(1, fields[33].length() - 1);
        this.demodata = fields[34].substring(1, fields[34].length() - 1).equals("1");
    }

    public Integer getOid() {
        return this.oid;
    }

    public Integer getOrgid() {
        return this.orgid;
    }

    public String getOppenteredid() {
        return this.oppenteredid;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContact() {
        return this.contact;
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

    public String getGeographicalarea() {
        return this.geographicalarea;
    }

    public BigDecimal getMonetaryvalue() {
        return this.monetaryvalue;
    }

    public Boolean getActive() {
        return this.active;
    }

    public Boolean getIncludeonweb() {
        return this.includeonweb;
    }

    public Boolean getOneoff() {
        return this.oneoff;
    }

    public Boolean getIncludevbaddress() {
        return this.includevbaddress;
    }

    public Timestamp getOppstartdate() {
        return this.oppstartdate;
    }

    public Timestamp getOppenddate() {
        return this.oppenddate;
    }

    public String getDescription() {
        return this.description;
    }

    public String getSkillsqualifications() {
        return this.skillsqualifications;
    }

    public String getDirections() {
        return this.directions;
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

    public Boolean getUseorgcontact() {
        return this.useorgcontact;
    }

    public String getTelfaxsearch() {
        return this.telfaxsearch;
    }

    public Boolean getVirtualvol() {
        return this.virtualvol;
    }

    public Boolean getResidential() {
        return this.residential;
    }

    public Timestamp getSpecificstartdate() {
        return this.specificstartdate;
    }

    public Timestamp getSpecificenddate() {
        return this.specificenddate;
    }

    public String getShortdescription() {
        return this.shortdescription;
    }

    public Boolean getDemodata() {
        return this.demodata;
    }

}
