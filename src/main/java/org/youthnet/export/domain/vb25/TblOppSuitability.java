package org.youthnet.export.domain.vb25;


public class TblOppSuitability {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 3;

    private Long id;
    private Long oid;
    private Long sid;


    public TblOppSuitability(String record) {
        String[] fields = record.split(DELIMITER);


        try {
            this.id = Long.parseLong(fields[0].substring(1, fields[0].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars id Long " + fields[0].substring(1, fields[0].length() - 1)
                    + " in row " + this.id + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.oid = Long.parseLong(fields[1].substring(1, fields[1].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars oid Long " + fields[1].substring(1, fields[1].length() - 1)
                    + " in row " + this.id + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.sid = Long.parseLong(fields[2].substring(1, fields[2].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars sid Long " + fields[2].substring(1, fields[2].length() - 1)
                    + " in row " + this.id + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
    }

    public Long getId() {
        return this.id;
    }

    public Long getOid() {
        return this.oid;
    }

    public Long getSid() {
        return this.sid;
    }

}
