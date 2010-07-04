package org.youthnet.export.domain.vb3;


import java.sql.Timestamp;
import java.util.UUID;


public class QueriesForViews {

    private Long version;
    private String sqlquery;
    private Timestamp created;
    private String hqlquery;
    private Long vbase2id;
    private Timestamp modified;
    private UUID modifiedby;
    private String queryname;
    private UUID id;
    private Boolean deleted;
    private UUID createdby;

    public QueriesForViews() {
    }

    public String getSqlQuery() {
        return this.sqlquery;
    }

    public void setSqlQuery(String sqlquery) {
        this.sqlquery = sqlquery;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getHqlQuery() {
        return this.hqlquery;
    }

    public void setHqlQuery(String hqlquery) {
        this.hqlquery = hqlquery;
    }

    public Long getVbase2Id() {
        return this.vbase2id;
    }

    public void setVbase2Id(Long vbase2id) {
        this.vbase2id = vbase2id;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public UUID getModifiedBy() {
        return this.modifiedby;
    }

    public void setModifiedBy(UUID modifiedby) {
        this.modifiedby = modifiedby;
    }

    public String getQueryName() {
        return this.queryname;
    }

    public void setQueryName(String queryname) {
        this.queryname = queryname;
    }

    public Timestamp getCreated() {
        return this.created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public UUID getCreatedBy() {
        return this.createdby;
    }

    public void setCreatedBy(UUID createdby) {
        this.createdby = createdby;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }
}
