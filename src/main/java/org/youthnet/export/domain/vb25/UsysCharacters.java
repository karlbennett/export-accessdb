package org.youthnet.export.domain.vb25;


public class UsysCharacters {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 2;

    private String character;
    private String explanation;


    public UsysCharacters(String record) {
        String[] fields = record.split(DELIMITER);


        this.character = fields[0].substring(1, fields[0].length() - 1);
        this.explanation = fields[1].substring(1, fields[1].length() - 1);
    }

    public String getCharacter() {
        return this.character;
    }

    public String getExplanation() {
        return this.explanation;
    }

}
