package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.List;
import java.util.ArrayList;


public class UsysReportsSpecial implements CSVable {

	private char delimiter = '|';
	private char enclosure = '¬';

	public static final int COLUMN_NUM = 8;

	private List<String> columnNames = null;

	private StringBuffer record = new StringBuffer();

	private String report;
	private Short type;
	private String sql;
	private String entsql;
	private String actsql;
	private String subsql;
	private String subentsql;
	private String subactsql;


	public UsysReportsSpecial() {}

	public UsysReportsSpecial(String record) {
		init(record);
	}

	public void init(String record) {
		String[] fields = record.split("\\" + String.valueOf(this.delimiter));


		this.report = fields[0].replace(String.valueOf(this.enclosure), "");
		this.type = (fields[1].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Short.valueOf(fields[1].replace(String.valueOf(this.enclosure), ""));
		this.sql = fields[2].replace(String.valueOf(this.enclosure), "");
		this.entsql = fields[3].replace(String.valueOf(this.enclosure), "");
		this.actsql = fields[4].replace(String.valueOf(this.enclosure), "");
		this.subsql = fields[5].replace(String.valueOf(this.enclosure), "");
		this.subentsql = fields[6].replace(String.valueOf(this.enclosure), "");
		this.subactsql = fields[7].replace(String.valueOf(this.enclosure), "");
	}

	public String getReport() {
		return this.report;
	}

	public Short getType() {
		return this.type;
	}

	public String getSql() {
		return this.sql;
	}

	public String getEntsql() {
		return this.entsql;
	}

	public String getActsql() {
		return this.actsql;
	}

	public String getSubsql() {
		return this.subsql;
	}

	public String getSubentsql() {
		return this.subentsql;
	}

	public String getSubactsql() {
		return this.subactsql;
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
			columnNames.add("Type");
			columnNames.add("SQL");
			columnNames.add("EntSQL");
			columnNames.add("ActSQL");
			columnNames.add("SubSQL");
			columnNames.add("SubEntSQL");
			columnNames.add("SubActSQL");
		}

		return columnNames;	}

	public String getRecord() {
		record.setLength(0);

		record.append(this.enclosure);
		record.append(this.report == null ? "" : this.report);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.type == null ? "" : this.type);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.sql == null ? "" : this.sql);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.entsql == null ? "" : this.entsql);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.actsql == null ? "" : this.actsql);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.subsql == null ? "" : this.subsql);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.subentsql == null ? "" : this.subentsql);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.subactsql == null ? "" : this.subactsql);
		record.append(this.enclosure);
		record.append(this.delimiter);

		return record.toString();
	}
}
