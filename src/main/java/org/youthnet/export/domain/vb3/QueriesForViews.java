package org.youthnet.export.domain.vb3;


public class QueriesForViews extends GenericDTO {


    private Integer vbase2Id;
    private String queryName;
    private String sqlQuery;
    private String hqlQuery;


    public QueriesForViews() {
    }


    public QueriesForViews(Integer vbase2Id, String queryName, String sqlQuery, String hqlQuery) {
        this.vbase2Id = vbase2Id;
        this.queryName = queryName;
        this.sqlQuery = sqlQuery;
        this.hqlQuery = hqlQuery;
    }


    public Integer getVbase2Id() {
        return this.vbase2Id;
    }


    public void setVbase2Id(Integer vbase2Id) {
        this.vbase2Id = vbase2Id;
    }


    public String getQueryName() {
        return this.queryName;
    }


    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }


    public String getSqlQuery() {
        return this.sqlQuery;
    }


    public void setSqlQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }


    public String getHqlQuery() {
        return this.hqlQuery;
    }


    public void setHqlQuery(String hqlQuery) {
        this.hqlQuery = hqlQuery;
    }
}
