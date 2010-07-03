package org.youthnet.export.domain.vb25;


public class TblOppSuitability {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 3;

    private Integer id;
    private Integer oid;
    private Integer sid;


    public TblOppSuitability(String record) {
        String[] fields = record.split(DELIMITER);


        this.id = Integer.parseInt(fields[0].substring(1, fields[0].length() - 1));
        this.oid = Integer.parseInt(fields[1].substring(1, fields[1].length() - 1));
        this.sid = Integer.parseInt(fields[2].substring(1, fields[2].length() - 1));
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getOid() {
        return this.oid;
    }

    public Integer getSid() {
        return this.sid;
    }

}
