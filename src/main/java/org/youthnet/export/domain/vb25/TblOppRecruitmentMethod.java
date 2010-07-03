package org.youthnet.export.domain.vb25;


public class TblOppRecruitmentMethod {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 3;

    private Long rid;
    private Long oid;
    private String recruitmentmethod;


    public TblOppRecruitmentMethod(String record) {
        String[] fields = record.split(DELIMITER);


        try {
            this.rid = Long.parseLong(fields[0].substring(1, fields[0].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars rid Long " + fields[0].substring(1, fields[0].length() - 1)
                    + " in row " + this.rid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.oid = Long.parseLong(fields[1].substring(1, fields[1].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars oid Long " + fields[1].substring(1, fields[1].length() - 1)
                    + " in row " + this.rid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.recruitmentmethod = fields[2].substring(1, fields[2].length() - 1);
    }

    public Long getRid() {
        return this.rid;
    }

    public Long getOid() {
        return this.oid;
    }

    public String getRecruitmentmethod() {
        return this.recruitmentmethod;
    }

}
