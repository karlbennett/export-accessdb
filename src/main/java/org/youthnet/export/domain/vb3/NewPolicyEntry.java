package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.vb3.lookups.Policy;
import org.youthnet.export.domain.vb3.lookups.PolicyStatus;


public class NewPolicyEntry extends PolicyEntry {


    private Policy policy;
    private PolicyStatus policyStatus;


    public NewPolicyEntry() {
    }


    public NewPolicyEntry(Integer vbase2Id, String comments, Policy policy, PolicyStatus policyStatus) {
        this.policy = policy;
        this.policyStatus = policyStatus;
    }


    public Policy getPolicy() {
        return this.policy;
    }


    public void setPolicy(Policy policy) {
        this.policy = policy;
    }


    public PolicyStatus getPolicyStatus() {
        return this.policyStatus;
    }


    public void setPolicyStatus(PolicyStatus policyStatus) {
        this.policyStatus = policyStatus;
    }
}
