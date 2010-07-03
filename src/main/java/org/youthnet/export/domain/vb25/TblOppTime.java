package org.youthnet.export.domain.vb25;


public class TblOppTime {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 4;

    private Integer tid;
    private Integer oid;
    private String day;
    private String timeslot;


    public TblOppTime(String record) {
        String[] fields = record.split(DELIMITER);


        this.tid = Integer.parseInt(fields[0].substring(1, fields[0].length() - 1));
        this.oid = Integer.parseInt(fields[1].substring(1, fields[1].length() - 1));
        this.day = fields[2].substring(1, fields[2].length() - 1);
        this.timeslot = fields[3].substring(1, fields[3].length() - 1);
    }

    public Integer getTid() {
        return this.tid;
    }

    public Integer getOid() {
        return this.oid;
    }

    public String getDay() {
        return this.day;
    }

    public String getTimeslot() {
        return this.timeslot;
    }

}
