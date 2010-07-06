package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class UsysReminder implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 7;

    private List<String> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private String reminder;
    private String period;
    private Short no;
    private Short order;
    private Boolean promptfortime;
    private String alarmtime;
    private Boolean active;


    public UsysReminder(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.reminder = fields[0].replace(String.valueOf(this.enclosure), "");
        this.period = fields[1].replace(String.valueOf(this.enclosure), "");
        this.no = Short.valueOf(fields[2].replace(String.valueOf(this.enclosure), ""));
        this.order = Short.valueOf(fields[3].replace(String.valueOf(this.enclosure), ""));
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

    public void setEnclosure(char delimiter) {
        this.enclosure = enclosure;
    }

    public Integer getColumnNumber() {
        return COLUMN_NUM;
    }

    public List<String> getColumnNames() {
        if (this.columnNames == null) {
            columnNames = new ArrayList<String>();
            columnNames.add("Reminder");
            columnNames.add("Period");
            columnNames.add("No");
            columnNames.add("Order");
            columnNames.add("PromptForTime");
            columnNames.add("AlarmTime");
            columnNames.add("Active");
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.reminder);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.period);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.no);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.order);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.promptfortime ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.alarmtime);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.active ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
