package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.vb3.lookups.GeographicalArea;
import org.youthnet.export.domain.vb3.lookups.Region;

import java.util.Set;


public class RegionLocationAddress extends LocationBase {


    private Region region;


    public RegionLocationAddress() {
    }


    public RegionLocationAddress(String DisplayString, Opportunity owner, LocationTypes locationType, ContactDetails contactDetails, ContactDetails publicContactDetails, boolean UseCustomOrgName, String CustomOrgName, PublicContactDetailsSource publicContactDetailsSource, Set<GeographicalArea> geographicalAreas, boolean IsActive, Region region) {
        this.region = region;
    }


    public Region getRegion() {
        return this.region;
    }


    public void setRegion(Region region) {
        this.region = region;
    }
}
