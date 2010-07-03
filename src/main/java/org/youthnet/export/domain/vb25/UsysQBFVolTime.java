package org.youthnet.export.domain.vb25;


public class UsysQBFVolTime {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 3;

    private String user;
    private String day;
    private String timeslot;


    public UsysQBFVolTime(String record) {
        String[] fields = record.split(DELIMITER);


        this.user = fields[0].substring(1, fields[0].length() - 1);
        this.day = fields[1].substring(1, fields[1].length() - 1);
        this.timeslot = fields[2].substring(1, fields[2].length() - 1);
    }

    public String getUser() {
        return this.user;
    }

    public String getDay() {
        return this.day;
    }

    public String getTimeslot() {
        return this.timeslot;
    }

}
