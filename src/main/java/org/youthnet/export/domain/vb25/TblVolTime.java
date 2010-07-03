package org.youthnet.export.domain.vb25;


public class TblVolTime {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 4;

    private Long tid;
    private Long vid;
    private String day;
    private String timeslot;


    public TblVolTime(String record) {
        String[] fields = record.split(DELIMITER);


        try {
            this.tid = Long.parseLong(fields[0].substring(1, fields[0].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars tid Long " + fields[0].substring(1, fields[0].length() - 1)
                    + " in row " + this.tid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.vid = Long.parseLong(fields[1].substring(1, fields[1].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars vid Long " + fields[1].substring(1, fields[1].length() - 1)
                    + " in row " + this.tid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.day = fields[2].substring(1, fields[2].length() - 1);
        this.timeslot = fields[3].substring(1, fields[3].length() - 1);
    }

    public Long getTid() {
        return this.tid;
    }

    public Long getVid() {
        return this.vid;
    }

    public String getDay() {
        return this.day;
    }

    public String getTimeslot() {
        return this.timeslot;
    }

}
