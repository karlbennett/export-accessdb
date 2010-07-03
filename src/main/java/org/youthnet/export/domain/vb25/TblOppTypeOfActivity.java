package org.youthnet.export.domain.vb25;


public class TblOppTypeOfActivity {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 3;

    private Integer actid;
    private Integer oid;
    private String typeofactivity;


    public TblOppTypeOfActivity(String record) {
        String[] fields = record.split(DELIMITER);


        this.actid = Integer.parseInt(fields[0].substring(1, fields[0].length() - 1));
        this.oid = Integer.parseInt(fields[1].substring(1, fields[1].length() - 1));
        this.typeofactivity = fields[2].substring(1, fields[2].length() - 1);
    }

    public Integer getActid() {
        return this.actid;
    }

    public Integer getOid() {
        return this.oid;
    }

    public String getTypeofactivity() {
        return this.typeofactivity;
    }

}
