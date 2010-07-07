package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.util.ArrayList;
import java.util.List;


public class UsysReports implements CSVable {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 15;

    private List<String> columnNames = null;

    private StringBuffer record = new StringBuffer();

    private String report;
    private Short order;
    private String sql;
    private Short orientation;
    private Short bottommargin;
    private String activereport;
    private String select;
    private String entsql;
    private String actsql;
    private Boolean subreport;
    private String subselect;
    private String subsql;
    private String subentsql;
    private String subactsql;
    private Boolean usespecial;


    public UsysReports() {
    }

    public UsysReports(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));


        this.report = fields[0].replace(String.valueOf(this.enclosure), "");
        this.order = (fields[1].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Short.valueOf(fields[1].replace(String.valueOf(this.enclosure), ""));
        this.sql = fields[2].replace(String.valueOf(this.enclosure), "");
        this.orientation = (fields[3].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Short.valueOf(fields[3].replace(String.valueOf(this.enclosure), ""));
        this.bottommargin = (fields[4].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Short.valueOf(fields[4].replace(String.valueOf(this.enclosure), ""));
        this.activereport = fields[5].replace(String.valueOf(this.enclosure), "");
        this.select = fields[6].replace(String.valueOf(this.enclosure), "");
        this.entsql = fields[7].replace(String.valueOf(this.enclosure), "");
        this.actsql = fields[8].replace(String.valueOf(this.enclosure), "");
        this.subreport = fields[9].replace(String.valueOf(this.enclosure), "").equals("1");
        this.subselect = fields[10].replace(String.valueOf(this.enclosure), "");
        this.subsql = fields[11].replace(String.valueOf(this.enclosure), "");
        this.subentsql = fields[12].replace(String.valueOf(this.enclosure), "");
        this.subactsql = fields[13].replace(String.valueOf(this.enclosure), "");
        this.usespecial = fields[14].replace(String.valueOf(this.enclosure), "").equals("1");
    }

    public String getReport() {
        return this.report;
    }

    public Short getOrder() {
        return this.order;
    }

    public String getSql() {
        return this.sql;
    }

    public Short getOrientation() {
        return this.orientation;
    }

    public Short getBottommargin() {
        return this.bottommargin;
    }

    public String getActivereport() {
        return this.activereport;
    }

    public String getSelect() {
        return this.select;
    }

    public String getEntsql() {
        return this.entsql;
    }

    public String getActsql() {
        return this.actsql;
    }

    public Boolean getSubreport() {
        return this.subreport;
    }

    public String getSubselect() {
        return this.subselect;
    }

    public String getSubsql() {
        return this.subsql;
    }

    public String getSubentsql() {
        return this.subentsql;
    }

    public String getSubactsql() {
        return this.subactsql;
    }

    public Boolean getUsespecial() {
        return this.usespecial;
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

    public List<String> getColumnNames() {
        if (this.columnNames == null) {
            columnNames = new ArrayList<String>();
            columnNames.add("Report");
            columnNames.add("Order");
            columnNames.add("SQL");
            columnNames.add("Orientation");
            columnNames.add("BottomMargin");
            columnNames.add("ActiveReport");
            columnNames.add("Select");
            columnNames.add("EntSQL");
            columnNames.add("ActSQL");
            columnNames.add("SubReport");
            columnNames.add("SubSelect");
            columnNames.add("SubSQL");
            columnNames.add("SubEntSQL");
            columnNames.add("SubActSQL");
            columnNames.add("UseSpecial");
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.report == null ? "" : this.report);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.order == null ? "" : this.order);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.sql == null ? "" : this.sql);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.orientation == null ? "" : this.orientation);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.bottommargin == null ? "" : this.bottommargin);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.activereport == null ? "" : this.activereport);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.select == null ? "" : this.select);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.entsql == null ? "" : this.entsql);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.actsql == null ? "" : this.actsql);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.subreport != null && subreport ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.subselect == null ? "" : this.subselect);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.subsql == null ? "" : this.subsql);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.subentsql == null ? "" : this.subentsql);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.subactsql == null ? "" : this.subactsql);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.usespecial != null && usespecial ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
