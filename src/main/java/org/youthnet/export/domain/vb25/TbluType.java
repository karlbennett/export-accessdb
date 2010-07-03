package org.youthnet.export.domain.vb25;


public class TbluType {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 2;

    private String type;
    private Boolean demodata;


    public TbluType(String record) {
        String[] fields = record.split(DELIMITER);


        this.type = fields[0].substring(1, fields[0].length() - 1);
        this.demodata = fields[1].substring(1, fields[1].length() - 1).equals("1");
    }

    public String getType() {
        return this.type;
    }

    public Boolean getDemodata() {
        return this.demodata;
    }

}
