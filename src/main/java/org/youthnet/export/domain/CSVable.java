package org.youthnet.export.domain;

import java.util.List;

/**
 * User: karl
 * Date: 04-Jul-2010
 */
public interface CSVable {

    public void init(String record);

    public char getDelimiter();

    public void setDelimiter(char delimiter);

    public char getEnclosure();

    public void setEnclosure(char enclosure);

    public Integer getColumnNumber();

    public List<String> getColumnNames();

    public String getRecord();
}
