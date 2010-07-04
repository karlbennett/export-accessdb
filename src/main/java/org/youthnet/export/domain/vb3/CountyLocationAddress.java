package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.vb3.lookups.County;
import org.youthnet.export.domain.vb3.lookups.GeographicalArea;

import java.util.Set;


public class CountyLocationAddress extends LocationBase {


    private County County;


    public CountyLocationAddress() {
    }


    public CountyLocationAddress(String DisplayString, Opportunity owner, LocationTypes locationType, ContactDetails contactDetails, ContactDetails publicContactDetails, boolean UseCustomOrgName, String CustomOrgName, PublicContactDetailsSource publicContactDetailsSource, Set<GeographicalArea> geographicalAreas, boolean IsActive, County County) {
        this.County = County;
    }


    public County getCounty() {
        return this.County;
    }


    public void setCounty(County County) {
        this.County = County;
    }
}
