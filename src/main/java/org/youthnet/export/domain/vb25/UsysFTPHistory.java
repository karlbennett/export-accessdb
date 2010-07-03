package org.youthnet.export.domain.vb25;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UsysFTPHistory {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 3;

    private Long hid;
    private Timestamp posteddate;
    private String otherinfo;


    public UsysFTPHistory(String record) {
        String[] fields = record.split(DELIMITER);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        try {
            this.hid = Long.parseLong(fields[0].substring(1, fields[0].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars hid Long " + fields[0].substring(1, fields[0].length() - 1)
                    + " in row " + this.hid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.posteddate = new Timestamp(
                    simpleDateFormat.parse(fields[1].substring(1, fields[1].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars posteddate Timestamp " + fields[1].substring(1, fields[1].length() - 1)
                    + " in row " + this.hid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.otherinfo = fields[2].substring(1, fields[2].length() - 1);
    }

    public Long getHid() {
        return this.hid;
    }

    public Timestamp getPosteddate() {
        return this.posteddate;
    }

    public String getOtherinfo() {
        return this.otherinfo;
    }

}
