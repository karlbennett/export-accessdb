package org.youthnet.export.domain.vb25;


public class UsysPivots {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 9;

    private Long id;
    private String pivot;
    private String row;
    private String column;
    private String data;
    private String sql;
    private String select;
    private String entsql;
    private String actsql;


    public UsysPivots(String record) {
        String[] fields = record.split(DELIMITER);


        try {
            this.id = Long.parseLong(fields[0].substring(1, fields[0].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars id Long " + fields[0].substring(1, fields[0].length() - 1)
                    + " in row " + this.id + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.pivot = fields[1].substring(1, fields[1].length() - 1);
        this.row = fields[2].substring(1, fields[2].length() - 1);
        this.column = fields[3].substring(1, fields[3].length() - 1);
        this.data = fields[4].substring(1, fields[4].length() - 1);
        this.sql = fields[5].substring(1, fields[5].length() - 1);
        this.select = fields[6].substring(1, fields[6].length() - 1);
        this.entsql = fields[7].substring(1, fields[7].length() - 1);
        this.actsql = fields[8].substring(1, fields[8].length() - 1);
    }

    public Long getId() {
        return this.id;
    }

    public String getPivot() {
        return this.pivot;
    }

    public String getRow() {
        return this.row;
    }

    public String getColumn() {
        return this.column;
    }

    public String getData() {
        return this.data;
    }

    public String getSql() {
        return this.sql;
    }

    public String getSelect() {
        return this.select;
    }

    public String getEntsql() {
        return this.entsql;
    }

    public String getActsql() {
        return this.actsql;
    }

}
