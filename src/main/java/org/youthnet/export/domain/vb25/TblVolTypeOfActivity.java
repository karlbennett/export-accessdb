package org.youthnet.export.domain.vb25;


public class TblVolTypeOfActivity {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 3;

    private Long actid;
    private Long vid;
    private String typeofactivity;


    public TblVolTypeOfActivity(String record) {
        String[] fields = record.split(DELIMITER);


        try {
            this.actid = Long.parseLong(fields[0].substring(1, fields[0].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars actid Long " + fields[0].substring(1, fields[0].length() - 1)
                    + " in row " + this.actid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.vid = Long.parseLong(fields[1].substring(1, fields[1].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars vid Long " + fields[1].substring(1, fields[1].length() - 1)
                    + " in row " + this.actid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.typeofactivity = fields[2].substring(1, fields[2].length() - 1);
    }

    public Long getActid() {
        return this.actid;
    }

    public Long getVid() {
        return this.vid;
    }

    public String getTypeofactivity() {
        return this.typeofactivity;
    }

}
