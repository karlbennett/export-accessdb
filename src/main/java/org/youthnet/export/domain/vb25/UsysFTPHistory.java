package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class UsysFTPHistory implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 3;

    private List<String[]> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private Long hid;
    private Timestamp posteddate;
    private String otherinfo;


    public UsysFTPHistory() {
    }

    public UsysFTPHistory(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        this.hid = (fields[0].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[0].replace(String.valueOf(this.enclosure), ""));
        try {
            this.posteddate = (fields[1].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
                    simpleDateFormat.parse(fields[1].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars posteddate Timestamp " + fields[1].replace(String.valueOf(this.enclosure), "")
                    + " in row " + this.hid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.otherinfo = fields[2].replace(String.valueOf(this.enclosure), "");
    }

    public Long getHid() {
        return this.hid;
    }

    public Timestamp getPosteddate() {
        return this.posteddate;
    }

    public String getOtherinfo() {
        return this.otherinfo;
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

    public List<String[]> getColumnNames() {
        if (this.columnNames == null) {
            columnNames = new ArrayList<String[]>();
            columnNames.add(new String[]{"HID, Long"});
            columnNames.add(new String[]{"PostedDate, Timestamp"});
            columnNames.add(new String[]{"OtherInfo, String"});
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.hid == null ? "" : this.hid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.posteddate == null ? "" : this.posteddate);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.otherinfo == null ? "" : this.otherinfo);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
