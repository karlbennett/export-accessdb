package org.youthnet.export.domain.vb25;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TblMailings {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 10;

    private String mailing;
    private Short no;
    private String description;
    private String fields;
    private Short icon;
    private Boolean email;
    private String owner;
    private Timestamp datefirstentered;
    private Timestamp datelastupdated;
    private String lastupdatedby;


    public TblMailings(String record) {
        String[] fields = record.split(DELIMITER);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        this.mailing = fields[0].substring(1, fields[0].length() - 1);
        this.no = Short.parseShort(fields[1].substring(1, fields[1].length() - 1));
        this.description = fields[2].substring(1, fields[2].length() - 1);
        this.fields = fields[3].substring(1, fields[3].length() - 1);
        this.icon = Short.parseShort(fields[4].substring(1, fields[4].length() - 1));
        this.email = fields[5].substring(1, fields[5].length() - 1).equals("1");
        this.owner = fields[6].substring(1, fields[6].length() - 1);
        try {
            this.datefirstentered = new Timestamp(
                    simpleDateFormat.parse(fields[7].substring(1, fields[7].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datefirstentered date " + fields[7].substring(1, fields[7].length() - 1)
                    + " in row " + this.mailing + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.datelastupdated = new Timestamp(
                    simpleDateFormat.parse(fields[8].substring(1, fields[8].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datelastupdated date " + fields[8].substring(1, fields[8].length() - 1)
                    + " in row " + this.mailing + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.lastupdatedby = fields[9].substring(1, fields[9].length() - 1);
    }

    public String getMailing() {
        return this.mailing;
    }

    public Short getNo() {
        return this.no;
    }

    public String getDescription() {
        return this.description;
    }

    public String getFields() {
        return this.fields;
    }

    public Short getIcon() {
        return this.icon;
    }

    public Boolean getEmail() {
        return this.email;
    }

    public String getOwner() {
        return this.owner;
    }

    public Timestamp getDatefirstentered() {
        return this.datefirstentered;
    }

    public Timestamp getDatelastupdated() {
        return this.datelastupdated;
    }

    public String getLastupdatedby() {
        return this.lastupdatedby;
    }

}
