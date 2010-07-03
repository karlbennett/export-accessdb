package org.youthnet.export.domain.vb25;


public class UsysQBFOppSuitability {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 3;

    private String user;
    private Long id;
    private String suitability;


    public UsysQBFOppSuitability(String record) {
        String[] fields = record.split(DELIMITER);


        this.user = fields[0].substring(1, fields[0].length() - 1);
        try {
            this.id = Long.parseLong(fields[1].substring(1, fields[1].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars id Long " + fields[1].substring(1, fields[1].length() - 1)
                    + " in row " + this.user + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.suitability = fields[2].substring(1, fields[2].length() - 1);
    }

    public String getUser() {
        return this.user;
    }

    public Long getId() {
        return this.id;
    }

    public String getSuitability() {
        return this.suitability;
    }

}
