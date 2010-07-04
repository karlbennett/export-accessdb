package org.youthnet.export.domain.vb3;


public class PolicyEntry extends GenericDTO {


    private Integer vbase2Id;
    private String comments;


    public PolicyEntry() {
    }


    public PolicyEntry(Integer vbase2Id, String comments) {
        this.vbase2Id = vbase2Id;
        this.comments = comments;
    }


    public Integer getVbase2Id() {
        return this.vbase2Id;
    }


    public void setVbase2Id(Integer vbase2Id) {
        this.vbase2Id = vbase2Id;
    }


    public String getComments() {
        return this.comments;
    }


    public void setComments(String comments) {
        this.comments = comments;
    }
}
