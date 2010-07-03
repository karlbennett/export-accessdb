package org.youthnet.export.domain.vb25;


public class TblVolTime {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 4;

    private Integer tid;
    private Integer vid;
    private String day;
    private String timeslot;


    public TblVolTime(String record) {
        String[] fields = record.split(DELIMITER);


        this.tid = Integer.parseInt(fields[0].substring(1, fields[0].length() - 1));
        this.vid = Integer.parseInt(fields[1].substring(1, fields[1].length() - 1));
        this.day = fields[2].substring(1, fields[2].length() - 1);
        this.timeslot = fields[3].substring(1, fields[3].length() - 1);
    }

    public Integer getTid() {
        return this.tid;
    }

    public Integer getVid() {
        return this.vid;
    }

    public String getDay() {
        return this.day;
    }

    public String getTimeslot() {
        return this.timeslot;
    }

}
