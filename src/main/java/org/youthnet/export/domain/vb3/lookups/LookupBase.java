package org.youthnet.export.domain.vb3.lookups;


import org.youthnet.export.domain.vb3.GenericDTO;


public class LookupBase extends GenericDTO {


    private Integer vBase2Id;
    private UuidUserType languageId;
    private String value;
    private boolean isActive;
    private Integer sortOrder;
    private boolean isUserEditable;
    private UuidUserType ownerId;


    public LookupBase() {
    }


    public LookupBase(Integer vBase2Id, UuidUserType languageId, String value, boolean isActive, Integer sortOrder, boolean isUserEditable, UuidUserType ownerId) {
        this.vBase2Id = vBase2Id;
        this.languageId = languageId;
        this.value = value;
        this.isActive = isActive;
        this.sortOrder = sortOrder;
        this.isUserEditable = isUserEditable;
        this.ownerId = ownerId;
    }


    public Integer getvBase2Id() {
        return this.vBase2Id;
    }


    public void setvBase2Id(Integer vBase2Id) {
        this.vBase2Id = vBase2Id;
    }


    public UuidUserType getLanguageId() {
        return this.languageId;
    }


    public void setLanguageId(UuidUserType languageId) {
        this.languageId = languageId;
    }


    public String getValue() {
        return this.value;
    }


    public void setValue(String value) {
        this.value = value;
    }


    public boolean isIsActive() {
        return this.isActive;
    }


    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }


    public Integer getSortOrder() {
        return this.sortOrder;
    }


    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }


    public boolean isIsUserEditable() {
        return this.isUserEditable;
    }


    public void setIsUserEditable(boolean isUserEditable) {
        this.isUserEditable = isUserEditable;
    }


    public UuidUserType getOwnerId() {
        return this.ownerId;
    }


    public void setOwnerId(UuidUserType ownerId) {
        this.ownerId = ownerId;
    }
}
