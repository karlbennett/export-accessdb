package org.youthnet.export.domain.vb25;


public class UsysLogo {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 1;

    private String logo;


    public UsysLogo(String record) {
        String[] fields = record.split(DELIMITER);


        this.logo = fields[0].substring(1, fields[0].length() - 1);
    }

    public String getLogo() {
        return this.logo;
    }

}
