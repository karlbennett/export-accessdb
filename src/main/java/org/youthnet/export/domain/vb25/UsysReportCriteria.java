package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class UsysReportCriteria implements CSVable {

	private char delimiter = '|';
	private char enclosure = '¬';

	public static final int COLUMN_NUM = 6;

	private List<String> columnNames = null;

	private StringBuffer record = new StringBuffer();

	private String report;
	private String user;
	private Timestamp startdate;
	private Timestamp enddate;
	private String dateoption;
	private String sql;


	public UsysReportCriteria() {}

	public UsysReportCriteria(String record) {
		init(record);
	}

	public void init(String record) {
		String[] fields = record.split("\\" + String.valueOf(this.delimiter));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

		this.report = fields[0].replace(String.valueOf(this.enclosure), "");
		this.user = fields[1].replace(String.valueOf(this.enclosure), "");
		try {
			this.startdate = (fields[2].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
				simpleDateFormat.parse(fields[2].replace(String.valueOf(this.enclosure), "")).getTime());
		} catch (ParseException e) {
			System.out.println("Could not pars startdate Timestamp " + fields[2].replace(String.valueOf(this.enclosure), "")
				+ " in row " + this.report+ " for table " + this.getClass().getName() + ". Error: "+ e.getMessage());
		}
		try {
			this.enddate = (fields[3].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
				simpleDateFormat.parse(fields[3].replace(String.valueOf(this.enclosure), "")).getTime());
		} catch (ParseException e) {
			System.out.println("Could not pars enddate Timestamp " + fields[3].replace(String.valueOf(this.enclosure), "")
				+ " in row " + this.report+ " for table " + this.getClass().getName() + ". Error: "+ e.getMessage());
		}
		this.dateoption = fields[4].replace(String.valueOf(this.enclosure), "");
		this.sql = fields[5].replace(String.valueOf(this.enclosure), "");
	}

	public String getReport() {
		return this.report;
	}

	public String getUser() {
		return this.user;
	}

	public Timestamp getStartdate() {
		return this.startdate;
	}

	public Timestamp getEnddate() {
		return this.enddate;
	}

	public String getDateoption() {
		return this.dateoption;
	}

	public String getSql() {
		return this.sql;
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
			columnNames.add("Report");
			columnNames.add("User");
			columnNames.add("StartDate");
			columnNames.add("EndDate");
			columnNames.add("DateOption");
			columnNames.add("SQL");
		}

		return columnNames;	}

	public String getRecord() {
		record.setLength(0);

		record.append(this.enclosure);
		record.append(this.report == null ? "" : this.report);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.user == null ? "" : this.user);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.startdate == null ? "" : this.startdate);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.enddate == null ? "" : this.enddate);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.dateoption == null ? "" : this.dateoption);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.sql == null ? "" : this.sql);
		record.append(this.enclosure);
		record.append(this.delimiter);

		return record.toString();
	}
}
