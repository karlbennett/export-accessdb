package org.youthnet.export.domain.vb3;


import java.util.UUID;


public class OrganisaitonQualityStdsAccr {

    private UUID ownerid;
    private UUID policyid;

    public OrganisaitonQualityStdsAccr() {
    }

    public UUID getOwnerId() {
        return this.ownerid;
    }

    public void setOwnerId(UUID ownerid) {
        this.ownerid = ownerid;
    }

    public UUID getPolicyId() {
        return this.policyid;
    }

    public void setPolicyId(UUID policyid) {
        this.policyid = policyid;
    }
}
