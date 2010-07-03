package org.youthnet.export.domain.vb25;


public class UsysMailMerge {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 3;

    private Long no;
    private String option;
    private String fields;


    public UsysMailMerge(String record) {
        String[] fields = record.split(DELIMITER);


        try {
            this.no = Long.parseLong(fields[0].substring(1, fields[0].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars no Long " + fields[0].substring(1, fields[0].length() - 1)
                    + " in row " + this.no + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.option = fields[1].substring(1, fields[1].length() - 1);
        this.fields = fields[2].substring(1, fields[2].length() - 1);
    }

    public Long getNo() {
        return this.no;
    }

    public String getOption() {
        return this.option;
    }

    public String getFields() {
        return this.fields;
    }

}
