package org.youthnet.export.domain.vb25;


public class TbluSpecial {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 3;

    private String special;
    private Boolean active;
    private Boolean demodata;


    public TbluSpecial(String record) {
        String[] fields = record.split(DELIMITER);


        this.special = fields[0].substring(1, fields[0].length() - 1);
        this.active = fields[1].substring(1, fields[1].length() - 1).equals("1");
        this.demodata = fields[2].substring(1, fields[2].length() - 1).equals("1");
    }

    public String getSpecial() {
        return this.special;
    }

    public Boolean getActive() {
        return this.active;
    }

    public Boolean getDemodata() {
        return this.demodata;
    }

}
