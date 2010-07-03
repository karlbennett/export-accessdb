package org.youthnet.export.domain.vb25;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UsysQBFOppSpecificDates {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 3;

    private String user;
    private Timestamp specificstartdate;
    private Timestamp specificenddate;


    public UsysQBFOppSpecificDates(String record) {
        String[] fields = record.split(DELIMITER);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        this.user = fields[0].substring(1, fields[0].length() - 1);
        try {
            this.specificstartdate = new Timestamp(
                    simpleDateFormat.parse(fields[1].substring(1, fields[1].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars specificstartdate Timestamp " + fields[1].substring(1, fields[1].length() - 1)
                    + " in row " + this.user + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.specificenddate = new Timestamp(
                    simpleDateFormat.parse(fields[2].substring(1, fields[2].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars specificenddate Timestamp " + fields[2].substring(1, fields[2].length() - 1)
                    + " in row " + this.user + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
    }

    public String getUser() {
        return this.user;
    }

    public Timestamp getSpecificstartdate() {
        return this.specificstartdate;
    }

    public Timestamp getSpecificenddate() {
        return this.specificenddate;
    }

}
