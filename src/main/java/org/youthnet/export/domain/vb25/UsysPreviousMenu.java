package org.youthnet.export.domain.vb25;


public class UsysPreviousMenu {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 4;

    private Integer id;
    private String user;
    private String name;
    private Short type;


    public UsysPreviousMenu(String record) {
        String[] fields = record.split(DELIMITER);


        this.id = Integer.parseInt(fields[0].substring(1, fields[0].length() - 1));
        this.user = fields[1].substring(1, fields[1].length() - 1);
        this.name = fields[2].substring(1, fields[2].length() - 1);
        this.type = Short.parseShort(fields[3].substring(1, fields[3].length() - 1));
    }

    public Integer getId() {
        return this.id;
    }

    public String getUser() {
        return this.user;
    }

    public String getName() {
        return this.name;
    }

    public Short getType() {
        return this.type;
    }

}
