package org.youthnet.export.domain.vb25;


public class TblVolAreasOfInterest {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 3;

    private Integer areaid;
    private Integer vid;
    private String areasofinterest;


    public TblVolAreasOfInterest(String record) {
        String[] fields = record.split(DELIMITER);


        this.areaid = Integer.parseInt(fields[0].substring(1, fields[0].length() - 1));
        this.vid = Integer.parseInt(fields[1].substring(1, fields[1].length() - 1));
        this.areasofinterest = fields[2].substring(1, fields[2].length() - 1);
    }

    public Integer getAreaid() {
        return this.areaid;
    }

    public Integer getVid() {
        return this.vid;
    }

    public String getAreasofinterest() {
        return this.areasofinterest;
    }

}
