package org.youthnet.export.domain.vb25;


public class UsysReminder {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 7;

    private String reminder;
    private String period;
    private Short no;
    private Short order;
    private Boolean promptfortime;
    private String alarmtime;
    private Boolean active;


    public UsysReminder(String record) {
        String[] fields = record.split(DELIMITER);


        this.reminder = fields[0].substring(1, fields[0].length() - 1);
        this.period = fields[1].substring(1, fields[1].length() - 1);
        try {
            this.no = Short.parseShort(fields[2].substring(1, fields[2].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars no Short " + fields[2].substring(1, fields[2].length() - 1)
                    + " in row " + this.reminder + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.order = Short.parseShort(fields[3].substring(1, fields[3].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars order Short " + fields[3].substring(1, fields[3].length() - 1)
                    + " in row " + this.reminder + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.promptfortime = fields[4].substring(1, fields[4].length() - 1).equals("1");
        this.alarmtime = fields[5].substring(1, fields[5].length() - 1);
        this.active = fields[6].substring(1, fields[6].length() - 1).equals("1");
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

}
