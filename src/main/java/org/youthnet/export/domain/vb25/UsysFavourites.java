package org.youthnet.export.domain.vb25;


public class UsysFavourites {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 3;

    private String user;
    private Integer type;
    private Integer id;


    public UsysFavourites(String record) {
        String[] fields = record.split(DELIMITER);


        this.user = fields[0].substring(1, fields[0].length() - 1);
        this.type = Integer.parseInt(fields[1].substring(1, fields[1].length() - 1));
        this.id = Integer.parseInt(fields[2].substring(1, fields[2].length() - 1));
    }

    public String getUser() {
        return this.user;
    }

    public Integer getType() {
        return this.type;
    }

    public Integer getId() {
        return this.id;
    }

}
