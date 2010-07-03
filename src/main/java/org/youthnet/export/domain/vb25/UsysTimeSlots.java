package org.youthnet.export.domain.vb25;


public class UsysTimeSlots {

    private static final String DELIMITER = "|";

    public static final int COLUMN_NUM = 2;

    private String found;
    private String readable;


    public UsysTimeSlots(String record) {
        String[] fields = record.split(DELIMITER);


        this.found = fields[0].substring(1, fields[0].length() - 1);
        this.readable = fields[1].substring(1, fields[1].length() - 1);
    }

    public String getFound() {
        return this.found;
    }

    public String getReadable() {
        return this.readable;
    }

}
