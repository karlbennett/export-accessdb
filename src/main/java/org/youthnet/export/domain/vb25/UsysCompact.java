package org.youthnet.export.domain.vb25;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UsysCompact {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 1;

    private Timestamp lastdate;


    public UsysCompact(String record) {
        String[] fields = record.split(DELIMITER);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        try {
            this.lastdate = new Timestamp(
                    simpleDateFormat.parse(fields[0].substring(1, fields[0].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars lastdate date " + fields[0].substring(1, fields[0].length() - 1)
                    + " in row " + this.lastdate + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
    }

    public Timestamp getLastdate() {
        return this.lastdate;
    }

}
