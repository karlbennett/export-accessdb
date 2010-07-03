package org.youthnet.export.domain.vb25;


public class TbluActivity {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 12;

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


    public TbluActivity(String record) {
        String[] fields = record.split(DELIMITER);


        this.activity = fields[0].substring(1, fields[0].length() - 1);
        this.active = fields[1].substring(1, fields[1].length() - 1).equals("1");
        this.showincalendar = fields[2].substring(1, fields[2].length() - 1).equals("1");
        this.showopplink = fields[3].substring(1, fields[3].length() - 1).equals("1");
        this.showhoursworked = fields[4].substring(1, fields[4].length() - 1).equals("1");
        this.alldayevent = fields[5].substring(1, fields[5].length() - 1).equals("1");
        this.type = fields[6].substring(1, fields[6].length() - 1);
        this.uselink = fields[7].substring(1, fields[7].length() - 1).equals("1");
        this.linkcaption = fields[8].substring(1, fields[8].length() - 1);
        this.caldefault = fields[9].substring(1, fields[9].length() - 1).equals("1");
        this.keep = fields[10].substring(1, fields[10].length() - 1).equals("1");
        this.demodata = fields[11].substring(1, fields[11].length() - 1).equals("1");
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

}
