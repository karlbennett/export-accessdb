package org.youthnet.export.domain.vb3;


import java.util.Date;


public abstract class GenericDTO {


    private UuidUserType id;
    private int version;
    private Date created;
    private Date modified;
    private UuidUserType createdBy;
    private UuidUserType modifiedBy;
    private boolean deleted;


    public UuidUserType getId() {
        return this.id;
    }


    public void setId(UuidUserType id) {
        this.id = id;
    }


    public int getVersion() {
    }


    public void setVersion(int version) {
        this.version = version;
    }


    public Date getCreated() {
    }


    public void setCreated(Date created) {
        this.created = created;
    }


    public Date getModified() {
    }


    public void setModified(Date modified) {
        this.modified = modified;
    }


    public UuidUserType getCreatedBy() {
    }


    public void setCreatedBy(UuidUserType createdBy) {
        this.createdBy = createdBy;
    }


    public UuidUserType getModifiedBy() {
    }


    public void setModifiedBy(UuidUserType modifiedBy) {
        this.modifiedBy = modifiedBy;
    }


    public boolean isDeleted() {
    }


    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
