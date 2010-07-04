package org.youthnet.export.domain;

import java.util.List;

/**
 * User: karl
 * Date: 04-Jul-2010
 */
public interface CSVable {

    public void setDelimiter(String delimiter);

    public void setEnclosure(String enclosure);

    public Integer getClumnNumber();

    public List<String> getClumnNames();

    public String getRecord();
}
