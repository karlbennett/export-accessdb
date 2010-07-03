package org.youthnet.export.domain.vb25;


public class UsysMailMerge {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 3;

    private Integer no;
    private String option;
    private String fields;


    public UsysMailMerge(String record) {
        String[] fields = record.split(DELIMITER);


        this.no = Integer.parseInt(fields[0].substring(1, fields[0].length() - 1));
        this.option = fields[1].substring(1, fields[1].length() - 1);
        this.fields = fields[2].substring(1, fields[2].length() - 1);
    }

    public Integer getNo() {
        return this.no;
    }

    public String getOption() {
        return this.option;
    }

    public String getFields() {
        return this.fields;
    }

}
