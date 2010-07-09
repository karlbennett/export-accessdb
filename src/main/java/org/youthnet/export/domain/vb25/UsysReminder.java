package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class UsysReminder implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 7;

    private List<String[]> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private String reminder;
    private String period;
    private Short no;
    private Short order;
    private Boolean promptfortime;
    private String alarmtime;
    private Boolean active;


    public UsysReminder() {
    }

    public UsysReminder(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.reminder = fields[0].replace(String.valueOf(this.enclosure), "");
        this.period = fields[1].replace(String.valueOf(this.enclosure), "");
        this.no = (fields[2].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Short.valueOf(fields[2].replace(String.valueOf(this.enclosure), ""));
        this.order = (fields[3].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Short.valueOf(fields[3].replace(String.valueOf(this.enclosure), ""));
        this.promptfortime = fields[4].replace(String.valueOf(this.enclosure), "").equals("1");
        this.alarmtime = fields[5].replace(String.valueOf(this.enclosure), "");
        this.active = fields[6].replace(String.valueOf(this.enclosure), "").equals("1");
    }

    public String getReminder() {
        return this.reminder;
    }

    public String getPeriod() {
        return this.period;
    }

    public Short getNo() {
        return this.no;
    }

    public Short getOrder() {
        return this.order;
    }

    public Boolean getPromptfortime() {
        return this.promptfortime;
    }

    public String getAlarmtime() {
        return this.alarmtime;
    }

    public Boolean getActive() {
        return this.active;
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
            columnNames.add(new String[]{"Reminder, String"});
            columnNames.add(new String[]{"Period, String"});
            columnNames.add(new String[]{"No, Short"});
            columnNames.add(new String[]{"Order, Short"});
            columnNames.add(new String[]{"PromptForTime, Boolean"});
            columnNames.add(new String[]{"AlarmTime, String"});
            columnNames.add(new String[]{"Active, Boolean"});
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.reminder == null ? "" : this.reminder);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.period == null ? "" : this.period);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.no == null ? "" : this.no);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.order == null ? "" : this.order);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.promptfortime != null && promptfortime ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.alarmtime == null ? "" : this.alarmtime);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.active != null && active ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
