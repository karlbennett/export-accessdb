package org.youthnet.export.domain.vb25;


public class TblOppArrangements {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 4;

    private Integer aid;
    private Integer oid;
    private String opparrangements;
    private String details;


    public TblOppArrangements(String record) {
        String[] fields = record.split(DELIMITER);


        this.aid = Integer.parseInt(fields[0].substring(1, fields[0].length() - 1));
        this.oid = Integer.parseInt(fields[1].substring(1, fields[1].length() - 1));
        this.opparrangements = fields[2].substring(1, fields[2].length() - 1);
        this.details = fields[3].substring(1, fields[3].length() - 1);
    }

    public Integer getAid() {
        return this.aid;
    }

    public Integer getOid() {
        return this.oid;
    }

    public String getOpparrangements() {
        return this.opparrangements;
    }

    public String getDetails() {
        return this.details;
    }

}
