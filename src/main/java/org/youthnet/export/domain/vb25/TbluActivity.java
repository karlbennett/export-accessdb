package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class TbluActivity implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 12;

    private List<String> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private String activity;
    private Boolean active;
    private Boolean showincalendar;
    private Boolean showopplink;
    private Boolean showhoursworked;
    private Boolean alldayevent;
    private String type;
    private Boolean uselink;
    private String linkcaption;
    private Boolean caldefault;
    private Boolean keep;
    private Boolean demodata;


    public TbluActivity() {
    }

    public TbluActivity(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.activity = fields[0].replace(String.valueOf(this.enclosure), "");
        this.active = fields[1].replace(String.valueOf(this.enclosure), "").equals("1");
        this.showincalendar = fields[2].replace(String.valueOf(this.enclosure), "").equals("1");
        this.showopplink = fields[3].replace(String.valueOf(this.enclosure), "").equals("1");
        this.showhoursworked = fields[4].replace(String.valueOf(this.enclosure), "").equals("1");
        this.alldayevent = fields[5].replace(String.valueOf(this.enclosure), "").equals("1");
        this.type = fields[6].replace(String.valueOf(this.enclosure), "");
        this.uselink = fields[7].replace(String.valueOf(this.enclosure), "").equals("1");
        this.linkcaption = fields[8].replace(String.valueOf(this.enclosure), "");
        this.caldefault = fields[9].replace(String.valueOf(this.enclosure), "").equals("1");
        this.keep = fields[10].replace(String.valueOf(this.enclosure), "").equals("1");
        this.demodata = fields[11].replace(String.valueOf(this.enclosure), "").equals("1");
    }

    public String getActivity() {
        return this.activity;
    }

    public Boolean getActive() {
        return this.active;
    }

    public Boolean getShowincalendar() {
        return this.showincalendar;
    }

    public Boolean getShowopplink() {
        return this.showopplink;
    }

    public Boolean getShowhoursworked() {
        return this.showhoursworked;
    }

    public Boolean getAlldayevent() {
        return this.alldayevent;
    }

    public String getType() {
        return this.type;
    }

    public Boolean getUselink() {
        return this.uselink;
    }

    public String getLinkcaption() {
        return this.linkcaption;
    }

    public Boolean getCaldefault() {
        return this.caldefault;
    }

    public Boolean getKeep() {
        return this.keep;
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
            columnNames.add("Activity");
            columnNames.add("Active");
            columnNames.add("ShowInCalendar");
            columnNames.add("ShowOppLink");
            columnNames.add("ShowHoursWorked");
            columnNames.add("AllDayEvent");
            columnNames.add("Type");
            columnNames.add("UseLink");
            columnNames.add("LinkCaption");
            columnNames.add("CalDefault");
            columnNames.add("Keep");
            columnNames.add("DemoData");
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.activity == null ? "" : this.activity);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.active ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.showincalendar ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.showopplink ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.showhoursworked ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.alldayevent ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.type == null ? "" : this.type);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.uselink ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.linkcaption == null ? "" : this.linkcaption);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.caldefault ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.keep ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.demodata ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
