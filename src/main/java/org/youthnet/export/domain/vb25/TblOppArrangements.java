package org.youthnet.export.domain.vb25;


public class TblOppArrangements {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 4;

    private Long aid;
    private Long oid;
    private String opparrangements;
    private String details;


    public TblOppArrangements(String record) {
        String[] fields = record.split(DELIMITER);


        try {
            this.aid = Long.parseLong(fields[0].substring(1, fields[0].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars aid Long " + fields[0].substring(1, fields[0].length() - 1)
                    + " in row " + this.aid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.oid = Long.parseLong(fields[1].substring(1, fields[1].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars oid Long " + fields[1].substring(1, fields[1].length() - 1)
                    + " in row " + this.aid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.opparrangements = fields[2].substring(1, fields[2].length() - 1);
        this.details = fields[3].substring(1, fields[3].length() - 1);
    }

    public Long getAid() {
        return this.aid;
    }

    public Long getOid() {
        return this.oid;
    }

    public String getOpparrangements() {
        return this.opparrangements;
    }

    public String getDetails() {
        return this.details;
    }

}
