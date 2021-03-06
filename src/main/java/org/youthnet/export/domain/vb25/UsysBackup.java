package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class UsysBackup implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 3;

    private List<String[]> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private Timestamp lastdate;
    private String filename;
    private Boolean includedate;


    public UsysBackup() {
    }

    public UsysBackup(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        try {
            this.lastdate = (fields[0].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
                    simpleDateFormat.parse(fields[0].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars lastdate Timestamp " + fields[0].replace(String.valueOf(this.enclosure), "")
                    + " in row " + this.lastdate + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.filename = fields[1].replace(String.valueOf(this.enclosure), "");
        this.includedate = fields[2].replace(String.valueOf(this.enclosure), "").equals("1");
    }

    public Timestamp getLastdate() {
        return this.lastdate;
    }

    public String getFilename() {
        return this.filename;
    }

    public Boolean getIncludedate() {
        return this.includedate;
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
            columnNames.add(new String[]{"LastDate, Timestamp"});
            columnNames.add(new String[]{"FileName, String"});
            columnNames.add(new String[]{"IncludeDate, Boolean"});
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.lastdate == null ? "" : this.lastdate);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.filename == null ? "" : this.filename);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.includedate != null && includedate ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
