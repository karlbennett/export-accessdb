package org.youthnet.export.domain.vb25;


public class UsysUserLicence {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 1;

    private Short licence;


    public UsysUserLicence(String record) {
        String[] fields = record.split(DELIMITER);


        try {
            this.licence = Short.parseShort(fields[0].substring(1, fields[0].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars licence Short " + fields[0].substring(1, fields[0].length() - 1)
                    + " in row " + this.licence + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
    }

    public Short getLicence() {
        return this.licence;
    }

}
