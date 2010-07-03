package org.youthnet.export.domain.vb25;


public class UsysReports {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 15;

    private String report;
    private Short order;
    private String sql;
    private Short orientation;
    private Short bottommargin;
    private String activereport;
    private String select;
    private String entsql;
    private String actsql;
    private Boolean subreport;
    private String subselect;
    private String subsql;
    private String subentsql;
    private String subactsql;
    private Boolean usespecial;


    public UsysReports(String record) {
        String[] fields = record.split(DELIMITER);


        this.report = fields[0].substring(1, fields[0].length() - 1);
        try {
            this.order = Short.parseShort(fields[1].substring(1, fields[1].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars order Short " + fields[1].substring(1, fields[1].length() - 1)
                    + " in row " + this.report + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.sql = fields[2].substring(1, fields[2].length() - 1);
        try {
            this.orientation = Short.parseShort(fields[3].substring(1, fields[3].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars orientation Short " + fields[3].substring(1, fields[3].length() - 1)
                    + " in row " + this.report + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.bottommargin = Short.parseShort(fields[4].substring(1, fields[4].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars bottommargin Short " + fields[4].substring(1, fields[4].length() - 1)
                    + " in row " + this.report + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.activereport = fields[5].substring(1, fields[5].length() - 1);
        this.select = fields[6].substring(1, fields[6].length() - 1);
        this.entsql = fields[7].substring(1, fields[7].length() - 1);
        this.actsql = fields[8].substring(1, fields[8].length() - 1);
        this.subreport = fields[9].substring(1, fields[9].length() - 1).equals("1");
        this.subselect = fields[10].substring(1, fields[10].length() - 1);
        this.subsql = fields[11].substring(1, fields[11].length() - 1);
        this.subentsql = fields[12].substring(1, fields[12].length() - 1);
        this.subactsql = fields[13].substring(1, fields[13].length() - 1);
        this.usespecial = fields[14].substring(1, fields[14].length() - 1).equals("1");
    }

    public String getReport() {
        return this.report;
    }

    public Short getOrder() {
        return this.order;
    }

    public String getSql() {
        return this.sql;
    }

    public Short getOrientation() {
        return this.orientation;
    }

    public Short getBottommargin() {
        return this.bottommargin;
    }

    public String getActivereport() {
        return this.activereport;
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

    public Boolean getSubreport() {
        return this.subreport;
    }

    public String getSubselect() {
        return this.subselect;
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

    public Boolean getUsespecial() {
        return this.usespecial;
    }

}
