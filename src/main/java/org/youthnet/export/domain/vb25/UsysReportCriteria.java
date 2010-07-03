package org.youthnet.export.domain.vb25;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UsysReportCriteria {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 6;

    private String report;
    private String user;
    private Timestamp startdate;
    private Timestamp enddate;
    private String dateoption;
    private String sql;


    public UsysReportCriteria(String record) {
        String[] fields = record.split(DELIMITER);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        this.report = fields[0].substring(1, fields[0].length() - 1);
        this.user = fields[1].substring(1, fields[1].length() - 1);
        try {
            this.startdate = new Timestamp(
                    simpleDateFormat.parse(fields[2].substring(1, fields[2].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars startdate Timestamp " + fields[2].substring(1, fields[2].length() - 1)
                    + " in row " + this.report + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.enddate = new Timestamp(
                    simpleDateFormat.parse(fields[3].substring(1, fields[3].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars enddate Timestamp " + fields[3].substring(1, fields[3].length() - 1)
                    + " in row " + this.report + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.dateoption = fields[4].substring(1, fields[4].length() - 1);
        this.sql = fields[5].substring(1, fields[5].length() - 1);
    }

    public String getReport() {
        return this.report;
    }

    public String getUser() {
        return this.user;
    }

    public Timestamp getStartdate() {
        return this.startdate;
    }

    public Timestamp getEnddate() {
        return this.enddate;
    }

    public String getDateoption() {
        return this.dateoption;
    }

    public String getSql() {
        return this.sql;
    }

}
