package org.youthnet.export.domain.vb3;


import java.util.UUID;


public class LocationAddressLookups {

    private UUID locationaddressid;
    private UUID lookupid;

    public LocationAddressLookups() {
    }

    public UUID getLocationAddressId() {
        return this.locationaddressid;
    }

    public void setLocationAddressId(UUID locationaddressid) {
        this.locationaddressid = locationaddressid;
    }

    public UUID getLookupId() {
        return this.lookupid;
    }

    public void setLookupId(UUID lookupid) {
        this.lookupid = lookupid;
    }
}
