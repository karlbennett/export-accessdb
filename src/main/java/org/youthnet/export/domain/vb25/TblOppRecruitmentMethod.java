package org.youthnet.export.domain.vb25;


public class TblOppRecruitmentMethod {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 3;

    private Integer rid;
    private Integer oid;
    private String recruitmentmethod;


    public TblOppRecruitmentMethod(String record) {
        String[] fields = record.split(DELIMITER);


        this.rid = Integer.parseInt(fields[0].substring(1, fields[0].length() - 1));
        this.oid = Integer.parseInt(fields[1].substring(1, fields[1].length() - 1));
        this.recruitmentmethod = fields[2].substring(1, fields[2].length() - 1);
    }

    public Integer getRid() {
        return this.rid;
    }

    public Integer getOid() {
        return this.oid;
    }

    public String getRecruitmentmethod() {
        return this.recruitmentmethod;
    }

}
