package org.youthnet.export.domain.vb3;


public class Role extends GenericDTO {


    private Integer vbase2Id;
    private UuidUserType userId;
    private String name;
    private String description;


    public Role() {
    }


    public Role(Integer vbase2Id, UuidUserType userId, String name, String description) {
        this.vbase2Id = vbase2Id;
        this.userId = userId;
        this.name = name;
        this.description = description;
    }


    public Integer getVbase2Id() {
        return this.vbase2Id;
    }


    public void setVbase2Id(Integer vbase2Id) {
        this.vbase2Id = vbase2Id;
    }


    public UuidUserType getUserId() {
        return this.userId;
    }


    public void setUserId(UuidUserType userId) {
        this.userId = userId;
    }


    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return this.description;
    }


    public void setDescription(String description) {
        this.description = description;
    }
}
