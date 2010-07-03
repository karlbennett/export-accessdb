package org.youthnet.export.domain.vb25;


public class TbluReligion {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 3;

    private String religion;
    private Boolean active;
    private Boolean demodata;


    public TbluReligion(String record) {
        String[] fields = record.split(DELIMITER);


        this.religion = fields[0].substring(1, fields[0].length() - 1);
        this.active = fields[1].substring(1, fields[1].length() - 1).equals("1");
        this.demodata = fields[2].substring(1, fields[2].length() - 1).equals("1");
    }

    public String getReligion() {
        return this.religion;
    }

    public Boolean getActive() {
        return this.active;
    }

    public Boolean getDemodata() {
        return this.demodata;
    }

}
