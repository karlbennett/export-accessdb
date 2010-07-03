package org.youthnet.export.domain.vb25;


public class UsysChartTitles {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 6;

    private String chart;
    private String user;
    private String top;
    private String left;
    private String right;
    private String bottom;


    public UsysChartTitles(String record) {
        String[] fields = record.split(DELIMITER);


        this.chart = fields[0].substring(1, fields[0].length() - 1);
        this.user = fields[1].substring(1, fields[1].length() - 1);
        this.top = fields[2].substring(1, fields[2].length() - 1);
        this.left = fields[3].substring(1, fields[3].length() - 1);
        this.right = fields[4].substring(1, fields[4].length() - 1);
        this.bottom = fields[5].substring(1, fields[5].length() - 1);
    }

    public String getChart() {
        return this.chart;
    }

    public String getUser() {
        return this.user;
    }

    public String getTop() {
        return this.top;
    }

    public String getLeft() {
        return this.left;
    }

    public String getRight() {
        return this.right;
    }

    public String getBottom() {
        return this.bottom;
    }

}
