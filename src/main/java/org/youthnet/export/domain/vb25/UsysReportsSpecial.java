package org.youthnet.export.domain.vb25;


public class UsysReportsSpecial {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 8;

    private String report;
    private Short type;
    private String sql;
    private String entsql;
    private String actsql;
    private String subsql;
    private String subentsql;
    private String subactsql;


    public UsysReportsSpecial(String record) {
        String[] fields = record.split(DELIMITER);


        this.report = fields[0].substring(1, fields[0].length() - 1);
        this.type = Short.parseShort(fields[1].substring(1, fields[1].length() - 1));
        this.sql = fields[2].substring(1, fields[2].length() - 1);
        this.entsql = fields[3].substring(1, fields[3].length() - 1);
        this.actsql = fields[4].substring(1, fields[4].length() - 1);
        this.subsql = fields[5].substring(1, fields[5].length() - 1);
        this.subentsql = fields[6].substring(1, fields[6].length() - 1);
        this.subactsql = fields[7].substring(1, fields[7].length() - 1);
    }

    public String getReport() {
        return this.report;
    }

    public Short getType() {
        return this.type;
    }

    public String getSql() {
        return this.sql;
    }

    public String getEntsql() {
        return this.entsql;
    }

    public String getActsql() {
        return this.actsql;
    }

    public String getSubsql() {
        return this.subsql;
    }

    public String getSubentsql() {
        return this.subentsql;
    }

    public String getSubactsql() {
        return this.subactsql;
    }

}
