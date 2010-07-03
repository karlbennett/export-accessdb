package org.youthnet.export.domain.vb25;


public class TblOppAreasOfInterest {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 3;

    private Long areaid;
    private Long oid;
    private String areasofinterest;


    public TblOppAreasOfInterest(String record) {
        String[] fields = record.split(DELIMITER);


        try {
            this.areaid = Long.parseLong(fields[0].substring(1, fields[0].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars areaid Long " + fields[0].substring(1, fields[0].length() - 1)
                    + " in row " + this.areaid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.oid = Long.parseLong(fields[1].substring(1, fields[1].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars oid Long " + fields[1].substring(1, fields[1].length() - 1)
                    + " in row " + this.areaid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.areasofinterest = fields[2].substring(1, fields[2].length() - 1);
    }

    public Long getAreaid() {
        return this.areaid;
    }

    public Long getOid() {
        return this.oid;
    }

    public String getAreasofinterest() {
        return this.areasofinterest;
    }

}
