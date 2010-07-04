package org.youthnet.export.domain.vb3;


import java.util.UUID;


public class OpportunityArrPolicyEntry {

    private UUID policyid;
    private UUID opportunityid;

    public OpportunityArrPolicyEntry() {
    }

    public UUID getPolicyId() {
        return this.policyid;
    }

    public void setPolicyId(UUID policyid) {
        this.policyid = policyid;
    }

    public UUID getOpportunityId() {
        return this.opportunityid;
    }

    public void setOpportunityId(UUID opportunityid) {
        this.opportunityid = opportunityid;
    }
}
