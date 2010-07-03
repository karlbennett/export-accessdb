package org.youthnet.export.domain.vb25;


public class TblMailingsList {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 6;

    private Integer mid;
    private String mailing;
    private Integer vid;
    private Integer oid;
    private Integer orgid;
    private Boolean emailpreference;


    public TblMailingsList(String record) {
        String[] fields = record.split(DELIMITER);


        this.mid = Integer.parseInt(fields[0].substring(1, fields[0].length() - 1));
        this.mailing = fields[1].substring(1, fields[1].length() - 1);
        this.vid = Integer.parseInt(fields[2].substring(1, fields[2].length() - 1));
        this.oid = Integer.parseInt(fields[3].substring(1, fields[3].length() - 1));
        this.orgid = Integer.parseInt(fields[4].substring(1, fields[4].length() - 1));
        this.emailpreference = fields[5].substring(1, fields[5].length() - 1).equals("1");
    }

    public Integer getMid() {
        return this.mid;
    }

    public String getMailing() {
        return this.mailing;
    }

    public Integer getVid() {
        return this.vid;
    }

    public Integer getOid() {
        return this.oid;
    }

    public Integer getOrgid() {
        return this.orgid;
    }

    public Boolean getEmailpreference() {
        return this.emailpreference;
    }

}
