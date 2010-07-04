package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class OrganisationPoliciesAndProc implements CSVable {

    private String delimiter = "|";
    private String enclosure = "¬";
    private Integer columnNum = 2;
    private List<String> columnNames = null;
    private StringBuffer record = new StringBuffer();

    private UUID ownerid;
    private UUID policyid;

    public OrganisationPoliciesAndProc() {
    }

    public UUID getOwnerId() {
        return this.ownerid;
    }

    public void setOwnerId(UUID ownerid) {
        this.ownerid = ownerid;
    }

    public UUID getPolicyId() {
        return this.policyid;
    }

    public void setPolicyId(UUID policyid) {
        this.policyid = policyid;
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
            this.columnNames.add("OwnerId");
            this.columnNames.add("PolicyId");
        }

        return this.columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.ownerid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        record.append(this.enclosure);
        record.append(this.policyid.toString().replace("-", ""));
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
