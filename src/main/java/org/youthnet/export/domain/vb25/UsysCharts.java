package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.List;
import java.util.ArrayList;


public class UsysCharts implements CSVable {

	private char delimiter = '|';
	private char enclosure = '¬';

	public static final int COLUMN_NUM = 6;

	private List<String> columnNames = null;

	private StringBuffer record = new StringBuffer();

	private String chart;
	private String select;
	private String selectwhere;
	private String groupby;
	private String table;
	private Short order;


	public UsysCharts() {}

	public UsysCharts(String record) {
		init(record);
	}

	public void init(String record) {
		String[] fields = record.split("\\" + String.valueOf(this.delimiter));


		this.chart = fields[0].replace(String.valueOf(this.enclosure), "");
		this.select = fields[1].replace(String.valueOf(this.enclosure), "");
		this.selectwhere = fields[2].replace(String.valueOf(this.enclosure), "");
		this.groupby = fields[3].replace(String.valueOf(this.enclosure), "");
		this.table = fields[4].replace(String.valueOf(this.enclosure), "");
		this.order = (fields[5].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Short.valueOf(fields[5].replace(String.valueOf(this.enclosure), ""));
	}

	public String getChart() {
		return this.chart;
	}

	public String getSelect() {
		return this.select;
	}

	public String getSelectwhere() {
		return this.selectwhere;
	}

	public String getGroupby() {
		return this.groupby;
	}

	public String getTable() {
		return this.table;
	}

	public Short getOrder() {
		return this.order;
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
			columnNames.add("Select");
			columnNames.add("SelectWhere");
			columnNames.add("GroupBy");
			columnNames.add("Table");
			columnNames.add("Order");
		}

		return columnNames;	}

	public String getRecord() {
		record.setLength(0);

		record.append(this.enclosure);
		record.append(this.chart == null ? "" : this.chart);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.select == null ? "" : this.select);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.selectwhere == null ? "" : this.selectwhere);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.groupby == null ? "" : this.groupby);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.table == null ? "" : this.table);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.order == null ? "" : this.order);
		record.append(this.enclosure);
		record.append(this.delimiter);

		return record.toString();
	}
}
