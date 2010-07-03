package org.youthnet.export.domain.vb25;


public class TbluCorrespondence {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 5;

    private String correspondence;
    private Boolean active;
    private Boolean followupletter;
    private String templatepath;
    private Boolean demodata;


    public TbluCorrespondence(String record) {
        String[] fields = record.split(DELIMITER);


        this.correspondence = fields[0].substring(1, fields[0].length() - 1);
        this.active = fields[1].substring(1, fields[1].length() - 1).equals("1");
        this.followupletter = fields[2].substring(1, fields[2].length() - 1).equals("1");
        this.templatepath = fields[3].substring(1, fields[3].length() - 1);
        this.demodata = fields[4].substring(1, fields[4].length() - 1).equals("1");
    }

    public String getCorrespondence() {
        return this.correspondence;
    }

    public Boolean getActive() {
        return this.active;
    }

    public Boolean getFollowupletter() {
        return this.followupletter;
    }

    public String getTemplatepath() {
        return this.templatepath;
    }

    public Boolean getDemodata() {
        return this.demodata;
    }

}
