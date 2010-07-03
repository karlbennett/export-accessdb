package org.youthnet.export.domain.vb25;


public class TblOppSpecial {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 3;

    private Integer sid;
    private Integer oid;
    private String special;


    public TblOppSpecial(String record) {
        String[] fields = record.split(DELIMITER);


        this.sid = Integer.parseInt(fields[0].substring(1, fields[0].length() - 1));
        this.oid = Integer.parseInt(fields[1].substring(1, fields[1].length() - 1));
        this.special = fields[2].substring(1, fields[2].length() - 1);
    }

    public Integer getSid() {
        return this.sid;
    }

    public Integer getOid() {
        return this.oid;
    }

    public String getSpecial() {
        return this.special;
    }

}
