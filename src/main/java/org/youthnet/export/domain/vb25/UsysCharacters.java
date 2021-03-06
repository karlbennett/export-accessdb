package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class UsysCharacters implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 2;

    private List<String[]> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private String character;
    private String explanation;


    public UsysCharacters() {
    }

    public UsysCharacters(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.character = fields[0].replace(String.valueOf(this.enclosure), "");
        this.explanation = fields[1].replace(String.valueOf(this.enclosure), "");
    }

    public String getCharacter() {
        return this.character;
    }

    public String getExplanation() {
        return this.explanation;
    }

    public char getDelimiter() {
        return this.delimiter;
    }

    public void setDelimiter(char delimiter) {
        this.delimiter = delimiter;
    }

    public char getEnclosure() {
        return this.enclosure;
    }

    public void setEnclosure(char enclosure) {
        this.enclosure = enclosure;
    }

    public Integer getColumnNumber() {
        return COLUMN_NUM;
    }

    public List<String[]> getColumnNames() {
        if (this.columnNames == null) {
            columnNames = new ArrayList<String[]>();
            columnNames.add(new String[]{"Character, String"});
            columnNames.add(new String[]{"Explanation, String"});
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.character == null ? "" : this.character);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.explanation == null ? "" : this.explanation);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
