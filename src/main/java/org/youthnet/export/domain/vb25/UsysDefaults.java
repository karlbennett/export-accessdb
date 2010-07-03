package org.youthnet.export.domain.vb25;


public class UsysDefaults {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 3;

    private Short no;
    private String option;
    private String value;


    public UsysDefaults(String record) {
        String[] fields = record.split(DELIMITER);


        this.no = Short.parseShort(fields[0].substring(1, fields[0].length() - 1));
        this.option = fields[1].substring(1, fields[1].length() - 1);
        this.value = fields[2].substring(1, fields[2].length() - 1);
    }

    public Short getNo() {
        return this.no;
    }

    public String getOption() {
        return this.option;
    }

    public String getValue() {
        return this.value;
    }

}
