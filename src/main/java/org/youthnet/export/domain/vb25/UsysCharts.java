package org.youthnet.export.domain.vb25;


public class UsysCharts {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 6;

    private String chart;
    private String select;
    private String selectwhere;
    private String groupby;
    private String table;
    private Short order;


    public UsysCharts(String record) {
        String[] fields = record.split(DELIMITER);


        this.chart = fields[0].substring(1, fields[0].length() - 1);
        this.select = fields[1].substring(1, fields[1].length() - 1);
        this.selectwhere = fields[2].substring(1, fields[2].length() - 1);
        this.groupby = fields[3].substring(1, fields[3].length() - 1);
        this.table = fields[4].substring(1, fields[4].length() - 1);
        this.order = Short.parseShort(fields[5].substring(1, fields[5].length() - 1));
    }

    public String getChart() {
        return this.chart;
    }

    public String getSelect() {
        return this.select;
    }

    public String getSelectwhere() {
        return this.selectwhere;
    }

    public String getGroupby() {
        return this.groupby;
    }

    public String getTable() {
        return this.table;
    }

    public Short getOrder() {
        return this.order;
    }

}
