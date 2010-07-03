package org.youthnet.export.domain.vb25;


public class TblVolAreasOfInterest {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 3;

    private Long areaid;
    private Long vid;
    private String areasofinterest;


    public TblVolAreasOfInterest(String record) {
        String[] fields = record.split(DELIMITER);


        try {
            this.areaid = Long.parseLong(fields[0].substring(1, fields[0].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars areaid Long " + fields[0].substring(1, fields[0].length() - 1)
                    + " in row " + this.areaid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.vid = Long.parseLong(fields[1].substring(1, fields[1].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars vid Long " + fields[1].substring(1, fields[1].length() - 1)
                    + " in row " + this.areaid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.areasofinterest = fields[2].substring(1, fields[2].length() - 1);
    }

    public Long getAreaid() {
        return this.areaid;
    }

    public Long getVid() {
        return this.vid;
    }

    public String getAreasofinterest() {
        return this.areasofinterest;
    }

}
