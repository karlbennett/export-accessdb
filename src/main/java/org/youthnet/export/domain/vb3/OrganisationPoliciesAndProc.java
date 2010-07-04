package org.youthnet.export.domain.vb3;


import java.util.UUID;


public class OrganisationPoliciesAndProc {

    private UUID ownerid;
    private UUID policyid;

    public OrganisationPoliciesAndProc() {
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
