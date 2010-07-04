package org.youthnet.export.domain.vb3.lookups;


public class ActivityType extends LookupBase {


    private boolean appliesToVolunteers;
    private boolean appliesToOrganisations;
    private boolean appliesToOpportunities;


    public ActivityType() {
    }


    public ActivityType(Integer vBase2Id, UuidUserType languageId, String value, boolean isActive, Integer sortOrder, boolean isUserEditable, UuidUserType ownerId, boolean appliesToVolunteers, boolean appliesToOrganisations, boolean appliesToOpportunities) {
        this.appliesToVolunteers = appliesToVolunteers;
        this.appliesToOrganisations = appliesToOrganisations;
        this.appliesToOpportunities = appliesToOpportunities;
    }


    public boolean isAppliesToVolunteers() {
        return this.appliesToVolunteers;
    }


    public void setAppliesToVolunteers(boolean appliesToVolunteers) {
        this.appliesToVolunteers = appliesToVolunteers;
    }


    public boolean isAppliesToOrganisations() {
        return this.appliesToOrganisations;
    }


    public void setAppliesToOrganisations(boolean appliesToOrganisations) {
        this.appliesToOrganisations = appliesToOrganisations;
    }


    public boolean isAppliesToOpportunities() {
        return this.appliesToOpportunities;
    }


    public void setAppliesToOpportunities(boolean appliesToOpportunities) {
        this.appliesToOpportunities = appliesToOpportunities;
    }
}
