package org.youthnet.export.domain.vb25;


public class UsysMailingDefaultsView {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 3;

    private Long no;
    private Short option;
    private String value;


    public UsysMailingDefaultsView(String record) {
        String[] fields = record.split(DELIMITER);


        try {
            this.no = Long.parseLong(fields[0].substring(1, fields[0].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars no Long " + fields[0].substring(1, fields[0].length() - 1)
                    + " in row " + this.no + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.option = Short.parseShort(fields[1].substring(1, fields[1].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars option Short " + fields[1].substring(1, fields[1].length() - 1)
                    + " in row " + this.no + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.value = fields[2].substring(1, fields[2].length() - 1);
    }

    public Long getNo() {
        return this.no;
    }

    public Short getOption() {
        return this.option;
    }

    public String getValue() {
        return this.value;
    }

}
