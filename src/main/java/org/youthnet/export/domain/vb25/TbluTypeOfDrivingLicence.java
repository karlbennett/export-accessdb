package org.youthnet.export.domain.vb25;


public class TbluTypeOfDrivingLicence {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 3;

    private String typeofdrivinglicence;
    private Boolean active;
    private Boolean demodata;


    public TbluTypeOfDrivingLicence(String record) {
        String[] fields = record.split(DELIMITER);


        this.typeofdrivinglicence = fields[0].substring(1, fields[0].length() - 1);
        this.active = fields[1].substring(1, fields[1].length() - 1).equals("1");
        this.demodata = fields[2].substring(1, fields[2].length() - 1).equals("1");
    }

    public String getTypeofdrivinglicence() {
        return this.typeofdrivinglicence;
    }

    public Boolean getActive() {
        return this.active;
    }

    public Boolean getDemodata() {
        return this.demodata;
    }

}
