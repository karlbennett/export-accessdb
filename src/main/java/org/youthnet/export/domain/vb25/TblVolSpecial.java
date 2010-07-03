package org.youthnet.export.domain.vb25;


public class TblVolSpecial {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 3;

    private Integer sid;
    private Integer vid;
    private String special;


    public TblVolSpecial(String record) {
        String[] fields = record.split(DELIMITER);


        this.sid = Integer.parseInt(fields[0].substring(1, fields[0].length() - 1));
        this.vid = Integer.parseInt(fields[1].substring(1, fields[1].length() - 1));
        this.special = fields[2].substring(1, fields[2].length() - 1);
    }

    public Integer getSid() {
        return this.sid;
    }

    public Integer getVid() {
        return this.vid;
    }

    public String getSpecial() {
        return this.special;
    }

}
