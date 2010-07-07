package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.List;
import java.util.ArrayList;


public class UsysChartCriteria implements CSVable {

	private char delimiter = '|';
	private char enclosure = '¬';

	public static final int COLUMN_NUM = 6;

	private List<String> columnNames = null;

	private StringBuffer record = new StringBuffer();

	private String chart;
	private String user;
	private String inenglish;
	private String whereclause;
	private String criteria;
	private String altwhereclause;


	public UsysChartCriteria() {}

	public UsysChartCriteria(String record) {
		init(record);
	}

	public void init(String record) {
		String[] fields = record.split("\\" + String.valueOf(this.delimiter));


		this.chart = fields[0].replace(String.valueOf(this.enclosure), "");
		this.user = fields[1].replace(String.valueOf(this.enclosure), "");
		this.inenglish = fields[2].replace(String.valueOf(this.enclosure), "");
		this.whereclause = fields[3].replace(String.valueOf(this.enclosure), "");
		this.criteria = fields[4].replace(String.valueOf(this.enclosure), "");
		this.altwhereclause = fields[5].replace(String.valueOf(this.enclosure), "");
	}

	public String getChart() {
		return this.chart;
	}

	public String getUser() {
		return this.user;
	}

	public String getInenglish() {
		return this.inenglish;
	}

	public String getWhereclause() {
		return this.whereclause;
	}

	public String getCriteria() {
		return this.criteria;
	}

	public String getAltwhereclause() {
		return this.altwhereclause;
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
			columnNames.add("Chart");
			columnNames.add("User");
			columnNames.add("InEnglish");
			columnNames.add("WhereClause");
			columnNames.add("Criteria");
			columnNames.add("AltWhereClause");
		}

		return columnNames;	}

	public String getRecord() {
		record.setLength(0);

		record.append(this.enclosure);
		record.append(this.chart == null ? "" : this.chart);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.user == null ? "" : this.user);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.inenglish == null ? "" : this.inenglish);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.whereclause == null ? "" : this.whereclause);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.criteria == null ? "" : this.criteria);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.altwhereclause == null ? "" : this.altwhereclause);
		record.append(this.enclosure);
		record.append(this.delimiter);

		return record.toString();
	}
}
