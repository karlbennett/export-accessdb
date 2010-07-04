package org.youthnet.export.domain.vb3;


import java.util.UUID;


public class UsersRoles {

    private UUID userid;
    private UUID roleid;

    public UsersRoles() {
    }

    public UUID getUserId() {
        return this.userid;
    }

    public void setUserId(UUID userid) {
        this.userid = userid;
    }

    public UUID getRoleId() {
        return this.roleid;
    }

    public void setRoleId(UUID roleid) {
        this.roleid = roleid;
    }
}
