package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class UsersRoles implements CSVable {

    private String delimiter = "|";
    private String enclosure = "¬";
    private Integer columnNum = 2;
    private List<String> columnNames = null;
    private StringBuffer record = new StringBuffer();

    private UUID userid;
    private UUID roleid;

    public UsersRoles() {
    }

    public UUID getUserId() {
        return this.userid;
    }

    public void setUserId(UUID userid) {
        this.userid = userid;
    }

    public UUID getRoleId() {
        return this.roleid;
    }

    public void setRoleId(UUID roleid) {
        this.roleid = roleid;
    }


    public String getDelimiter() {
        return this.delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getEnclosure() {
        return this.enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public Integer getClumnNumber() {
        return this.columnNum;
    }

    public List<String> getClumnNames() {
        if (this.columnNames == null) {
            this.columnNames = new ArrayList<String>();
            this.columnNames.add("UserId");
            this.columnNames.add("RoleId");
        }

        return this.columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.userid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.roleid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
