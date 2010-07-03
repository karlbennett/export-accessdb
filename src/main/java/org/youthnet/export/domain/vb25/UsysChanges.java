package org.youthnet.export.domain.vb25;


public class UsysChanges {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 4;

    private Integer no;
    private String change;
    private String description;
    private Boolean done;


    public UsysChanges(String record) {
        String[] fields = record.split(DELIMITER);


        this.no = Integer.parseInt(fields[0].substring(1, fields[0].length() - 1));
        this.change = fields[1].substring(1, fields[1].length() - 1);
        this.description = fields[2].substring(1, fields[2].length() - 1);
        this.done = fields[3].substring(1, fields[3].length() - 1).equals("1");
    }

    public Integer getNo() {
        return this.no;
    }

    public String getChange() {
        return this.change;
    }

    public String getDescription() {
        return this.description;
    }

    public Boolean getDone() {
        return this.done;
    }

}
