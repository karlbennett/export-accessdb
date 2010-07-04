package org.youthnet.export.domain.vb3;


import java.util.Date;


public class SearchQueries extends GenericDTO {


    private Blob data;
    private boolean isEditable;
    private UuidUserType userId;
    private Date lastUpdated;


    public SearchQueries() {
    }


    public SearchQueries(Blob data, boolean isEditable, UuidUserType userId, Date lastUpdated) {
        this.data = data;
        this.isEditable = isEditable;
        this.userId = userId;
        this.lastUpdated = lastUpdated;
    }


    public Blob getData() {
        return this.data;
    }


    public void setData(Blob data) {
        this.data = data;
    }


    public boolean isIsEditable() {
        return this.isEditable;
    }


    public void setIsEditable(boolean isEditable) {
        this.isEditable = isEditable;
    }


    public UuidUserType getUserId() {
        return this.userId;
    }


    public void setUserId(UuidUserType userId) {
        this.userId = userId;
    }


    public Date getLastUpdated() {
        return this.lastUpdated;
    }


    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
