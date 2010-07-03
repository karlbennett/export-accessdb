package org.youthnet.export.domain.vb25;


public class TblMailingsList {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 6;

    private Long mid;
    private String mailing;
    private Long vid;
    private Long oid;
    private Long orgid;
    private Boolean emailpreference;


    public TblMailingsList(String record) {
        String[] fields = record.split(DELIMITER);


        try {
            this.mid = Long.parseLong(fields[0].substring(1, fields[0].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars mid Long " + fields[0].substring(1, fields[0].length() - 1)
                    + " in row " + this.mid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.mailing = fields[1].substring(1, fields[1].length() - 1);
        try {
            this.vid = Long.parseLong(fields[2].substring(1, fields[2].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars vid Long " + fields[2].substring(1, fields[2].length() - 1)
                    + " in row " + this.mid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.oid = Long.parseLong(fields[3].substring(1, fields[3].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars oid Long " + fields[3].substring(1, fields[3].length() - 1)
                    + " in row " + this.mid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.orgid = Long.parseLong(fields[4].substring(1, fields[4].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars orgid Long " + fields[4].substring(1, fields[4].length() - 1)
                    + " in row " + this.mid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.emailpreference = fields[5].substring(1, fields[5].length() - 1).equals("1");
    }

    public Long getMid() {
        return this.mid;
    }

    public String getMailing() {
        return this.mailing;
    }

    public Long getVid() {
        return this.vid;
    }

    public Long getOid() {
        return this.oid;
    }

    public Long getOrgid() {
        return this.orgid;
    }

    public Boolean getEmailpreference() {
        return this.emailpreference;
    }

}
