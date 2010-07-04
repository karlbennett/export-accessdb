package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.vb3.lookups.Arrangement;
import org.youthnet.export.domain.vb3.lookups.ArrangementStatus;


public class ArrangementsRecordEntry extends PolicyEntry {


    private Arrangement policy;
    private ArrangementStatus policyStatus;


    public ArrangementsRecordEntry() {
    }


    public ArrangementsRecordEntry(Integer vbase2Id, String comments, Arrangement policy, ArrangementStatus policyStatus) {
        this.policy = policy;
        this.policyStatus = policyStatus;
    }


    public Arrangement getPolicy() {
        return this.policy;
    }


    public void setPolicy(Arrangement policy) {
        this.policy = policy;
    }


    public ArrangementStatus getPolicyStatus() {
        return this.policyStatus;
    }


    public void setPolicyStatus(ArrangementStatus policyStatus) {
        this.policyStatus = policyStatus;
    }
}
