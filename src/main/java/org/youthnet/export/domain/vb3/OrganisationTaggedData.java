package org.youthnet.export.domain.vb3;


import java.util.UUID;


public class OrganisationTaggedData {

    private UUID organisationid;
    private UUID lookupid;

    public OrganisationTaggedData() {
    }

    public UUID getOrganisationId() {
        return this.organisationid;
    }

    public void setOrganisationId(UUID organisationid) {
        this.organisationid = organisationid;
    }

    public UUID getLookupId() {
        return this.lookupid;
    }

    public void setLookupId(UUID lookupid) {
        this.lookupid = lookupid;
    }
}
