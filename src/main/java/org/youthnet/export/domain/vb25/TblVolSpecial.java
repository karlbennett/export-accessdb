package org.youthnet.export.domain.vb25;


public class TblVolSpecial {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 3;

    private Long sid;
    private Long vid;
    private String special;


    public TblVolSpecial(String record) {
        String[] fields = record.split(DELIMITER);


        try {
            this.sid = Long.parseLong(fields[0].substring(1, fields[0].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars sid Long " + fields[0].substring(1, fields[0].length() - 1)
                    + " in row " + this.sid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.vid = Long.parseLong(fields[1].substring(1, fields[1].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars vid Long " + fields[1].substring(1, fields[1].length() - 1)
                    + " in row " + this.sid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.special = fields[2].substring(1, fields[2].length() - 1);
    }

    public Long getSid() {
        return this.sid;
    }

    public Long getVid() {
        return this.vid;
    }

    public String getSpecial() {
        return this.special;
    }

}
