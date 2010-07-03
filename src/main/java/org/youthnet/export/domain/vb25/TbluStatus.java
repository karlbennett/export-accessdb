package org.youthnet.export.domain.vb25;


public class TbluStatus {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 4;

    private String status;
    private Boolean active;
    private Boolean _default;
    private Boolean demodata;


    public TbluStatus(String record) {
        String[] fields = record.split(DELIMITER);


        this.status = fields[0].substring(1, fields[0].length() - 1);
        this.active = fields[1].substring(1, fields[1].length() - 1).equals("1");
        this._default = fields[2].substring(1, fields[2].length() - 1).equals("1");
        this.demodata = fields[3].substring(1, fields[3].length() - 1).equals("1");
    }

    public String getStatus() {
        return this.status;
    }

    public Boolean getActive() {
        return this.active;
    }

    public Boolean getDefault() {
        return this._default;
    }

    public Boolean getDemodata() {
        return this.demodata;
    }

}
