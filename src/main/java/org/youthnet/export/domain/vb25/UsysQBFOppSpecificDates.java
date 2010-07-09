package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class UsysQBFOppSpecificDates implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 3;

    private List<String[]> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private String user;
    private Timestamp specificstartdate;
    private Timestamp specificenddate;


    public UsysQBFOppSpecificDates() {
    }

    public UsysQBFOppSpecificDates(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        this.user = fields[0].replace(String.valueOf(this.enclosure), "");
        try {
            this.specificstartdate = (fields[1].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
                    simpleDateFormat.parse(fields[1].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars specificstartdate Timestamp " + fields[1].replace(String.valueOf(this.enclosure), "")
                    + " in row " + this.user + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.specificenddate = (fields[2].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
                    simpleDateFormat.parse(fields[2].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars specificenddate Timestamp " + fields[2].replace(String.valueOf(this.enclosure), "")
                    + " in row " + this.user + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
    }

    public String getUser() {
        return this.user;
    }

    public Timestamp getSpecificstartdate() {
        return this.specificstartdate;
    }

    public Timestamp getSpecificenddate() {
        return this.specificenddate;
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
            columnNames.add(new String[]{"User, String"});
            columnNames.add(new String[]{"SpecificStartDate, Timestamp"});
            columnNames.add(new String[]{"SpecificEndDate, Timestamp"});
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.user == null ? "" : this.user);
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

        return record.toString();
    }
}
