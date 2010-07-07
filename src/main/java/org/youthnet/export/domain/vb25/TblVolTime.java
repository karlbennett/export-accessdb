package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.List;
import java.util.ArrayList;


public class TblVolTime implements CSVable, ContainsVid {

	private char delimiter = '|';
	private char enclosure = '¬';

	public static final int COLUMN_NUM = 4;

	private List<String> columnNames = null;

	private StringBuffer record = new StringBuffer();

	private Long tid;
	private Long vid;
	private String day;
	private String timeslot;


	public TblVolTime() {}

	public TblVolTime(String record) {
		init(record);
	}

	public void init(String record) {
		String[] fields = record.split("\\" + String.valueOf(this.delimiter));


		this.tid = (fields[0].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[0].replace(String.valueOf(this.enclosure), ""));
		this.vid = (fields[1].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[1].replace(String.valueOf(this.enclosure), ""));
		this.day = fields[2].replace(String.valueOf(this.enclosure), "");
		this.timeslot = fields[3].replace(String.valueOf(this.enclosure), "");
	}

	public Long getTid() {
		return this.tid;
	}

	public Long getVid() {
		return this.vid;
	}

	public String getDay() {
		return this.day;
	}

	public String getTimeslot() {
		return this.timeslot;
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
			columnNames.add("TID");
			columnNames.add("VID");
			columnNames.add("Day");
			columnNames.add("Timeslot");
		}

		return columnNames;	}

	public String getRecord() {
		record.setLength(0);

		record.append(this.enclosure);
		record.append(this.tid == null ? "" : this.tid);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.vid == null ? "" : this.vid);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.day == null ? "" : this.day);
		record.append(this.enclosure);
		record.append(this.delimiter);
		record.append(this.enclosure);
		record.append(this.timeslot == null ? "" : this.timeslot);
		record.append(this.enclosure);
		record.append(this.delimiter);

		return record.toString();
	}
}
