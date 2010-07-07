package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class TblOpp implements CSVable, ContainsOid, ContainsOrgid {

	private char delimiter = '|';
	private char enclosure = '¬';

	public static final int COLUMN_NUM = 35;

	private List<String> columnNames = null;

	private StringBuffer record = new StringBuffer();

	private Long oid;
	private Long orgid;
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


	public TblOpp() {}

	public TblOpp(String record) {
		init(record);
	}

	public void init(String record) {
		String[] fields = record.split("\\" + String.valueOf(this.delimiter));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

		this.oid = (fields[0].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[0].replace(String.valueOf(this.enclosure), ""));
		this.orgid = (fields[1].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[1].replace(String.valueOf(this.enclosure), ""));
		this.oppenteredid = fields[2].replace(String.valueOf(this.enclosure), "");
		this.title = fields[3].replace(String.valueOf(this.enclosure), "");
		this.contact = fields[4].replace(String.valueOf(this.enclosure), "");
		this.address1 = fields[5].replace(String.valueOf(this.enclosure), "");
		this.address2 = fields[6].replace(String.valueOf(this.enclosure), "");
		this.town = fields[7].replace(String.valueOf(this.enclosure), "");
		this.county = fields[8].replace(String.valueOf(this.enclosure), "");
		this.postcode = fields[9].replace(String.valueOf(this.enclosure), "");
		this.tel1 = fields[10].replace(String.valueOf(this.enclosure), "");
		this.fax = fields[11].replace(String.valueOf(this.enclosure), "");
		this.email = fields[12].replace(String.valueOf(this.enclosure), "");
		this.geographicalarea = fields[13].replace(String.valueOf(this.enclosure), "");
		try{
			this.monetaryvalue = (fields[14].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new BigDecimal(fields[14].replace(String.valueOf(this.enclosure), ""));
		} catch (NumberFormatException e) {
			System.out.println("Could not pars monetaryvalue BigDecimal " + fields[14].substring(1, fields[14].length() - 1)
				+ " in row " + this.oid+ " for table " + this.getClass().getName() + ". Error: "+ e.getMessage());
		}
		this.active = fields[15].replace(String.valueOf(this.enclosure), "").equals("1");
		this.includeonweb = fields[16].replace(String.valueOf(this.enclosure), "").equals("1");
		this.oneoff = fields[17].replace(String.valueOf(this.enclosure), "").equals("1");
		this.includevbaddress = fields[18].replace(String.valueOf(this.enclosure), "").equals("1");
		try {
			this.oppstartdate = (fields[19].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
				simpleDateFormat.parse(fields[19].replace(String.valueOf(this.enclosure), "")).getTime());
		} catch (ParseException e) {
			System.out.println("Could not pars oppstartdate Timestamp " + fields[19].replace(String.valueOf(this.enclosure), "")
				+ " in row " + this.oid+ " for table " + this.getClass().getName() + ". Error: "+ e.getMessage());
		}
		try {
			this.oppenddate = (fields[20].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
				simpleDateFormat.parse(fields[20].replace(String.valueOf(this.enclosure), "")).getTime());
		} catch (ParseException e) {
			System.out.println("Could not pars oppenddate Timestamp " + fields[20].replace(String.valueOf(this.enclosure), "")
				+ " in row " + this.oid+ " for table " + this.getClass().getName() + ". Error: "+ e.getMessage());
		}
		this.description = fields[21].replace(String.valueOf(this.enclosure), "");
		this.skillsqualifications = fields[22].replace(String.valueOf(this.enclosure), "");
		this.directions = fields[23].replace(String.valueOf(this.enclosure), "");
		try {
			this.datefirstentered = (fields[24].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
				simpleDateFormat.parse(fields[24].replace(String.valueOf(this.enclosure), "")).getTime());
		} catch (ParseException e) {
			System.out.println("Could not pars datefirstentered Timestamp " + fields[24].replace(String.valueOf(this.enclosure), "")
				+ " in row " + this.oid+ " for table " + this.getClass().getName() + ". Error: "+ e.getMessage());
		}
		try {
			this.datelastupdated = (fields[25].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
				simpleDateFormat.parse(fields[25].replace(String.valueOf(this.enclosure), "")).getTime());
		} catch (ParseException e) {
			System.out.println("Could not pars datelastupdated Timestamp " + fields[25].replace(String.valueOf(this.enclosure), "")
				+ " in row " + this.oid+ " for table " + this.getClass().getName() + ". Error: "+ e.getMessage());
		}
		this.lastupdatedby = fields[26].replace(String.valueOf(this.enclosure), "");
		this.useorgcontact = fields[27].replace(String.valueOf(this.enclosure), "").equals("1");
		this.telfaxsearch = fields[28].replace(String.valueOf(this.enclosure), "");
		this.virtualvol = fields[29].replace(String.valueOf(this.enclosure), "").equals("1");
		this.residential = fields[30].replace(String.valueOf(this.enclosure), "").equals("1");
		try {
			this.specificstartdate = (fields[31].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
				simpleDateFormat.parse(fields[31].replace(String.valueOf(this.enclosure), "")).getTime());
		} catch (ParseException e) {
			System.out.println("Could not pars specificstartdate Timestamp " + fields[31].replace(String.valueOf(this.enclosure), "")
				+ " in row " + this.oid+ " for table " + this.getClass().getName() + ". Error: "+ e.getMessage());
		}
		try {
			this.specificenddate = (fields[32].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
				simpleDateFormat.parse(fields[32].replace(String.valueOf(this.enclosure), "")).getTime());
		} catch (ParseException e) {
			System.out.println("Could not pars specificenddate Timestamp " + fields[32].replace(String.valueOf(this.enclosure), "")
				+ " in row " + this.oid+ " for table " + this.getClass().getName() + ". Error: "+ e.getMessage());
		}
		this.shortdescription = fields[33].replace(String.valueOf(this.enclosure), "");
		this.demodata = fields[34].replace(String.valueOf(this.enclosure), "").equals("1");
	}

	public Long getOid() {
		return this.oid;
	}

	public Long getOrgid() {
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
			columnNames.add("OID");
			columnNames.add("OrgID");
			columnNames.add("OppEnteredID");
			columnNames.add("Title");
			columnNames.add("Contact");
			columnNames.add("Address1");
			columnNames.add("Address2");
			columnNames.add("Town");
			columnNames.add("County");
			columnNames.add("Postcode");
			columnNames.add("Tel1");
			columnNames.add("Fax");
			columnNames.add("Email");
			columnNames.add("GeographicalArea");
			columnNames.add("MonetaryValue");
			columnNames.add("Active");
			columnNames.add("IncludeOnWeb");
			columnNames.add("OneOff");
			columnNames.add("IncludeVBAddress");
			columnNames.add("OppStartDate");
			columnNames.add("OppEndDate");
			columnNames.add("Description");
			columnNames.add("SkillsQualifications");
			columnNames.add("Directions");
			columnNames.add("DateFirstEntered");
			columnNames.add("DateLastUpdated");
			columnNames.add("LastUpdatedBy");
			columnNames.add("UseOrgContact");
			columnNames.add("TelFaxSearch");
			columnNames.add("VirtualVol");
			columnNames.add("Residential");
			columnNames.add("SpecificStartDate");
			columnNames.add("SpecificEndDate");
			columnNames.add("ShortDescription");
			columnNames.add("DemoData");
		}

		return columnNames;	}

	public String getRecord() {
		record.setLength(0);

		record.append(this.enclosure);
		record.append(this.oid == null ? "" : this.oid);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.orgid == null ? "" : this.orgid);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.oppenteredid == null ? "" : this.oppenteredid);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.title == null ? "" : this.title);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.contact == null ? "" : this.contact);
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
		record.append(this.geographicalarea == null ? "" : this.geographicalarea);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.monetaryvalue == null ? "" : this.monetaryvalue);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.active != null && active ? 1 : 0);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.includeonweb != null && includeonweb ? 1 : 0);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.oneoff != null && oneoff ? 1 : 0);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.includevbaddress != null && includevbaddress ? 1 : 0);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.oppstartdate == null ? "" : this.oppstartdate);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.oppenddate == null ? "" : this.oppenddate);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.description == null ? "" : this.description);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.skillsqualifications == null ? "" : this.skillsqualifications);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.directions == null ? "" : this.directions);
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
		record.append(this.useorgcontact != null && useorgcontact ? 1 : 0);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.telfaxsearch == null ? "" : this.telfaxsearch);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.virtualvol != null && virtualvol ? 1 : 0);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.residential != null && residential ? 1 : 0);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.specificstartdate == null ? "" : this.specificstartdate);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.specificenddate == null ? "" : this.specificenddate);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.shortdescription == null ? "" : this.shortdescription);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.demodata != null && demodata ? 1 : 0);
		record.append(this.enclosure);
		record.append(this.delimiter);

		return record.toString();
	}
}
