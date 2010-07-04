package org.youthnet.export.domain.vb3;


import java.util.UUID;


public class OpportunityAddSpecSuitabs {

    private UUID opportunityid;
    private UUID lookupid;

    public OpportunityAddSpecSuitabs() {
    }

    public UUID getOpportunityId() {
        return this.opportunityid;
    }

    public void setOpportunityId(UUID opportunityid) {
        this.opportunityid = opportunityid;
    }

    public UUID getLookupId() {
        return this.lookupid;
    }

    public void setLookupId(UUID lookupid) {
        this.lookupid = lookupid;
    }
}
