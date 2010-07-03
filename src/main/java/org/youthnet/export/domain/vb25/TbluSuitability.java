package org.youthnet.export.domain.vb25;


public class TbluSuitability {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 4;

    private String suitability;
    private Boolean active;
    private Long id;
    private Boolean demodata;


    public TbluSuitability(String record) {
        String[] fields = record.split(DELIMITER);


        this.suitability = fields[0].substring(1, fields[0].length() - 1);
        this.active = fields[1].substring(1, fields[1].length() - 1).equals("1");
        try {
            this.id = Long.parseLong(fields[2].substring(1, fields[2].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars id Long " + fields[2].substring(1, fields[2].length() - 1)
                    + " in row " + this.suitability + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.demodata = fields[3].substring(1, fields[3].length() - 1).equals("1");
    }

    public String getSuitability() {
        return this.suitability;
    }

    public Boolean getActive() {
        return this.active;
    }

    public Long getId() {
        return this.id;
    }

    public Boolean getDemodata() {
        return this.demodata;
    }

}
