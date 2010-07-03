package org.youthnet.export.domain.vb25;


public class UsysDemoData {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 1;

    private Boolean demodata;


    public UsysDemoData(String record) {
        String[] fields = record.split(DELIMITER);


        this.demodata = fields[0].substring(1, fields[0].length() - 1).equals("1");
    }

    public Boolean getDemodata() {
        return this.demodata;
    }

}
