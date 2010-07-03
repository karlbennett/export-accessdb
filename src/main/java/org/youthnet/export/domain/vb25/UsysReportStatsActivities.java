package org.youthnet.export.domain.vb25;


public class UsysReportStatsActivities {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 2;

    private String activity;
    private String user;


    public UsysReportStatsActivities(String record) {
        String[] fields = record.split(DELIMITER);


        this.activity = fields[0].substring(1, fields[0].length() - 1);
        this.user = fields[1].substring(1, fields[1].length() - 1);
    }

    public String getActivity() {
        return this.activity;
    }

    public String getUser() {
        return this.user;
    }

}
