package org.youthnet.export.domain.vb25;


public class TblOppAreasOfInterest {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 3;

    private Integer areaid;
    private Integer oid;
    private String areasofinterest;


    public TblOppAreasOfInterest(String record) {
        String[] fields = record.split(DELIMITER);


        this.areaid = Integer.parseInt(fields[0].substring(1, fields[0].length() - 1));
        this.oid = Integer.parseInt(fields[1].substring(1, fields[1].length() - 1));
        this.areasofinterest = fields[2].substring(1, fields[2].length() - 1);
    }

    public Integer getAreaid() {
        return this.areaid;
    }

    public Integer getOid() {
        return this.oid;
    }

    public String getAreasofinterest() {
        return this.areasofinterest;
    }

}
