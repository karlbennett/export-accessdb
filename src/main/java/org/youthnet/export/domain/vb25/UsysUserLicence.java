package org.youthnet.export.domain.vb25;


public class UsysUserLicence {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 1;

    private Short licence;


    public UsysUserLicence(String record) {
        String[] fields = record.split(DELIMITER);


        this.licence = Short.parseShort(fields[0].substring(1, fields[0].length() - 1));
    }

    public Short getLicence() {
        return this.licence;
    }

}
