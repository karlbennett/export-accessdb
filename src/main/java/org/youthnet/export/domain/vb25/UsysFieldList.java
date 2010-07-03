package org.youthnet.export.domain.vb25;


public class UsysFieldList {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 3;

    private String field;
    private String area;
    private Short order;


    public UsysFieldList(String record) {
        String[] fields = record.split(DELIMITER);


        this.field = fields[0].substring(1, fields[0].length() - 1);
        this.area = fields[1].substring(1, fields[1].length() - 1);
        try {
            this.order = Short.parseShort(fields[2].substring(1, fields[2].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars order Short " + fields[2].substring(1, fields[2].length() - 1)
                    + " in row " + this.field + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
    }

    public String getField() {
        return this.field;
    }

    public String getArea() {
        return this.area;
    }

    public Short getOrder() {
        return this.order;
    }

}
