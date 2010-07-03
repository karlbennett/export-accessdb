package org.youthnet.export.domain.vb25;


public class UsysPreviousMenu {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 4;

    private Long id;
    private String user;
    private String name;
    private Short type;


    public UsysPreviousMenu(String record) {
        String[] fields = record.split(DELIMITER);


        try {
            this.id = Long.parseLong(fields[0].substring(1, fields[0].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars id Long " + fields[0].substring(1, fields[0].length() - 1)
                    + " in row " + this.id + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.user = fields[1].substring(1, fields[1].length() - 1);
        this.name = fields[2].substring(1, fields[2].length() - 1);
        try {
            this.type = Short.parseShort(fields[3].substring(1, fields[3].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars type Short " + fields[3].substring(1, fields[3].length() - 1)
                    + " in row " + this.id + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
    }

    public Long getId() {
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
