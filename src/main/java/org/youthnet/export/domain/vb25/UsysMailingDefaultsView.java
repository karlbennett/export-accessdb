package org.youthnet.export.domain.vb25;


public class UsysMailingDefaultsView {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 3;

    private Integer no;
    private Short option;
    private String value;


    public UsysMailingDefaultsView(String record) {
        String[] fields = record.split(DELIMITER);


        this.no = Integer.parseInt(fields[0].substring(1, fields[0].length() - 1));
        this.option = Short.parseShort(fields[1].substring(1, fields[1].length() - 1));
        this.value = fields[2].substring(1, fields[2].length() - 1);
    }

    public Integer getNo() {
        return this.no;
    }

    public Short getOption() {
        return this.option;
    }

    public String getValue() {
        return this.value;
    }

}
