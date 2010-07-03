package org.youthnet.export.domain.vb25;


public class UsysQBFVolSpecial {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 2;

    private String user;
    private String special;


    public UsysQBFVolSpecial(String record) {
        String[] fields = record.split(DELIMITER);


        this.user = fields[0].substring(1, fields[0].length() - 1);
        this.special = fields[1].substring(1, fields[1].length() - 1);
    }

    public String getUser() {
        return this.user;
    }

    public String getSpecial() {
        return this.special;
    }

}
