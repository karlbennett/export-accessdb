package org.youthnet.export.domain.vb25;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UsysBackup {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 3;

    private Timestamp lastdate;
    private String filename;
    private Boolean includedate;


    public UsysBackup(String record) {
        String[] fields = record.split(DELIMITER);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        try {
            this.lastdate = new Timestamp(
                    simpleDateFormat.parse(fields[0].substring(1, fields[0].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars lastdate Timestamp " + fields[0].substring(1, fields[0].length() - 1)
                    + " in row " + this.lastdate + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.filename = fields[1].substring(1, fields[1].length() - 1);
        this.includedate = fields[2].substring(1, fields[2].length() - 1).equals("1");
    }

    public Timestamp getLastdate() {
        return this.lastdate;
    }

    public String getFilename() {
        return this.filename;
    }

    public Boolean getIncludedate() {
        return this.includedate;
    }

}
