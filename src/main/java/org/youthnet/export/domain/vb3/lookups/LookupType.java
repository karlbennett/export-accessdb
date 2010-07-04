package org.youthnet.export.domain.vb3.lookups;


import org.youthnet.export.domain.vb3.GenericDTO;


public class LookupType extends GenericDTO {


    private String value;
    private boolean canEdit;
    private boolean isVisible;


    public LookupType() {
    }


    public LookupType(String value, boolean canEdit, boolean isVisible) {
        this.value = value;
        this.canEdit = canEdit;
        this.isVisible = isVisible;
    }


    public String getValue() {
        return this.value;
    }


    public void setValue(String value) {
        this.value = value;
    }


    public boolean isCanEdit() {
        return this.canEdit;
    }


    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }


    public boolean isIsVisible() {
        return this.isVisible;
    }


    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
}
