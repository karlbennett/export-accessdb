package org.youthnet.export.domain.vb25;


public class TbluAgeRange {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 4;

    private String agerange;
    private Boolean active;
    private Integer order;
    private Boolean demodata;


    public TbluAgeRange(String record) {
        String[] fields = record.split(DELIMITER);


        this.agerange = fields[0].substring(1, fields[0].length() - 1);
        this.active = fields[1].substring(1, fields[1].length() - 1).equals("1");
        this.order = Integer.parseInt(fields[2].substring(1, fields[2].length() - 1));
        this.demodata = fields[3].substring(1, fields[3].length() - 1).equals("1");
    }

    public String getAgerange() {
        return this.agerange;
    }

    public Boolean getActive() {
        return this.active;
    }

    public Integer getOrder() {
        return this.order;
    }

    public Boolean getDemodata() {
        return this.demodata;
    }

}
