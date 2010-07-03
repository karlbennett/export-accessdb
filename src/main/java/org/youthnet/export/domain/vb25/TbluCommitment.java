package org.youthnet.export.domain.vb25;


public class TbluCommitment {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 4;

    private String commitment;
    private Boolean active;
    private Integer id;
    private Boolean demodata;


    public TbluCommitment(String record) {
        String[] fields = record.split(DELIMITER);


        this.commitment = fields[0].substring(1, fields[0].length() - 1);
        this.active = fields[1].substring(1, fields[1].length() - 1).equals("1");
        this.id = Integer.parseInt(fields[2].substring(1, fields[2].length() - 1));
        this.demodata = fields[3].substring(1, fields[3].length() - 1).equals("1");
    }

    public String getCommitment() {
        return this.commitment;
    }

    public Boolean getActive() {
        return this.active;
    }

    public Integer getId() {
        return this.id;
    }

    public Boolean getDemodata() {
        return this.demodata;
    }

}
