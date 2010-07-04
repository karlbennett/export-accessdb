package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.vb3.lookups.QualityStdsAndAccreditations;
import org.youthnet.export.domain.vb3.lookups.QualityStdsAndAccreditationsStatus;


public class QualityStdsAccrPolicyEntry extends PolicyEntry {


    private QualityStdsAndAccreditations policy;
    private QualityStdsAndAccreditationsStatus policyStatus;


    public QualityStdsAccrPolicyEntry() {
    }


    public QualityStdsAccrPolicyEntry(Integer vbase2Id, String comments, QualityStdsAndAccreditations policy, QualityStdsAndAccreditationsStatus policyStatus) {
        this.policy = policy;
        this.policyStatus = policyStatus;
    }


    public QualityStdsAndAccreditations getPolicy() {
        return this.policy;
    }


    public void setPolicy(QualityStdsAndAccreditations policy) {
        this.policy = policy;
    }


    public QualityStdsAndAccreditationsStatus getPolicyStatus() {
        return this.policyStatus;
    }


    public void setPolicyStatus(QualityStdsAndAccreditationsStatus policyStatus) {
        this.policyStatus = policyStatus;
    }
}
