package org.youthnet.export.domain.vb25;


public class UsysChartCriteria {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 6;

    private String chart;
    private String user;
    private String inenglish;
    private String whereclause;
    private String criteria;
    private String altwhereclause;


    public UsysChartCriteria(String record) {
        String[] fields = record.split(DELIMITER);


        this.chart = fields[0].substring(1, fields[0].length() - 1);
        this.user = fields[1].substring(1, fields[1].length() - 1);
        this.inenglish = fields[2].substring(1, fields[2].length() - 1);
        this.whereclause = fields[3].substring(1, fields[3].length() - 1);
        this.criteria = fields[4].substring(1, fields[4].length() - 1);
        this.altwhereclause = fields[5].substring(1, fields[5].length() - 1);
    }

    public String getChart() {
        return this.chart;
    }

    public String getUser() {
        return this.user;
    }

    public String getInenglish() {
        return this.inenglish;
    }

    public String getWhereclause() {
        return this.whereclause;
    }

    public String getCriteria() {
        return this.criteria;
    }

    public String getAltwhereclause() {
        return this.altwhereclause;
    }

}
