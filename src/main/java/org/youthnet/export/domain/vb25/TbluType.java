package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.List;
import java.util.ArrayList;


public class TbluType implements CSVable {

	private char delimiter = '|';
	private char enclosure = '¬';

	public static final int COLUMN_NUM = 2;

	private List<String> columnNames = null;

	private StringBuffer record = new StringBuffer();

	private String type;
	private Boolean demodata;


	public TbluType() {}

	public TbluType(String record) {
		init(record);
	}

	public void init(String record) {
		String[] fields = record.split("\\" + String.valueOf(this.delimiter));


		this.type = fields[0].replace(String.valueOf(this.enclosure), "");
		this.demodata = fields[1].replace(String.valueOf(this.enclosure), "").equals("1");
	}

	public String getType() {
		return this.type;
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
			columnNames.add("Type");
			columnNames.add("DemoData");
		}

		return columnNames;	}

	public String getRecord() {
		record.setLength(0);

		record.append(this.enclosure);
		record.append(this.type == null ? "" : this.type);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.demodata != null && demodata ? 1 : 0);
		record.append(this.enclosure);
		record.append(this.delimiter);

		return record.toString();
	}
}
