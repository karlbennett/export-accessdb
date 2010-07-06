package org.youthnet.export.domain.vb3;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * User: karl
 * Date: 04-Jul-2010
 */
public class OpportunitiesTest {
    private static final String BENEFITS = "Test String.";
    private static final Long COMMITMENTAM = 99999L;
    private static final Long COMMITMENTEVE = 99999L;
    private static final Boolean ISVIRTUALREMOTE = true;
    private static final Long COMMITMENTPM = 99999L;
    private static final Boolean LOCATIONSPUBLICLYVIEWABLE = true;
    private static final String DESCRIPTION = "Test String.";
    private static final Float MONETARYVALUEPERHOUR = 1.2f;
    private static final Boolean ISACTIVE = true;
    private static final Boolean USESHAREDINTCONDETS = true;
    private static final String OWNID = "Test String.";
    private static final Boolean ISDATESPECIFIC = true;
    private static final Boolean USESHAREDPUBLICCONTACTDETAILS = true;
    private static final Boolean PUBLISHTODOIT = true;
    private static final Boolean ISONEOFF = true;
    private static final Long VBASE2ID = 99999L;
    private static final String REQUIREMENTS = "Test String.";
    private static final Boolean ISRESIDENTIAL = true;
    private static final UUID ORGANISATIONID = UUID.randomUUID();
    private static final String SHORTDESCRIPTION = "Test String.";
    private static final Boolean ISSHAREDINTERNALCONTACTPUBLIC = true;
    private static final UUID SHAREDINTERNALCONTACTDETAILSID = UUID.randomUUID();
    private static final Timestamp SPECIFICENDDATE = new Timestamp(new Date().getTime());
    private static final UUID SHAREDPUBLICCONTACTDETAILSID = UUID.randomUUID();
    private static final Timestamp SPECIFICSTARTDATE = new Timestamp(new Date().getTime());
    private static final String TITLE = "Test String.";
    private static final UUID ID = UUID.randomUUID();
    private static final Timestamp CREATED = new Timestamp(new Date().getTime());
    private static final UUID CREATEDBY = UUID.randomUUID();
    private static final Boolean DELETED = true;
    private static final Timestamp MODIFIED = new Timestamp(new Date().getTime());
    private static final UUID MODIFIEDBY = UUID.randomUUID();
    private static final Long VERSION = 99999L;
    private static final Timestamp ADVERTISINGENDDATE = new Timestamp(new Date().getTime());
    private static final Timestamp ADVERTISINGSTARTDATE = new Timestamp(new Date().getTime());

    String testRecord = "¬" + BENEFITS + "¬" + "|"
            + "¬" + COMMITMENTAM + "¬" + "|"
            + "¬" + COMMITMENTEVE + "¬" + "|"
            + "¬" + (ISVIRTUALREMOTE ? 1 : 0) + "¬" + "|"
            + "¬" + COMMITMENTPM + "¬" + "|"
            + "¬" + (LOCATIONSPUBLICLYVIEWABLE ? 1 : 0) + "¬" + "|"
            + "¬" + DESCRIPTION + "¬" + "|"
            + "¬" + MONETARYVALUEPERHOUR + "¬" + "|"
            + "¬" + (ISACTIVE ? 1 : 0) + "¬" + "|"
            + "¬" + (USESHAREDINTCONDETS ? 1 : 0) + "¬" + "|"
            + "¬" + OWNID + "¬" + "|"
            + "¬" + (ISDATESPECIFIC ? 1 : 0) + "¬" + "|"
            + "¬" + (USESHAREDPUBLICCONTACTDETAILS ? 1 : 0) + "¬" + "|"
            + "¬" + (PUBLISHTODOIT ? 1 : 0) + "¬" + "|"
            + "¬" + (ISONEOFF ? 1 : 0) + "¬" + "|"
            + "¬" + VBASE2ID + "¬" + "|"
            + "¬" + REQUIREMENTS + "¬" + "|"
            + "¬" + (ISRESIDENTIAL ? 1 : 0) + "¬" + "|"
            + "¬" + ORGANISATIONID.toString().replace("-", "") + "¬" + "|"
            + "¬" + SHORTDESCRIPTION + "¬" + "|"
            + "¬" + (ISSHAREDINTERNALCONTACTPUBLIC ? 1 : 0) + "¬" + "|"
            + "¬" + SHAREDINTERNALCONTACTDETAILSID.toString().replace("-", "") + "¬" + "|"
            + "¬" + SPECIFICENDDATE + "¬" + "|"
            + "¬" + SHAREDPUBLICCONTACTDETAILSID.toString().replace("-", "") + "¬" + "|"
            + "¬" + SPECIFICSTARTDATE + "¬" + "|"
            + "¬" + TITLE + "¬" + "|"
            + "¬" + ID.toString().replace("-", "") + "¬" + "|"
            + "¬" + CREATED + "¬" + "|"
            + "¬" + CREATEDBY.toString().replace("-", "") + "¬" + "|"
            + "¬" + (DELETED ? 1 : 0) + "¬" + "|"
            + "¬" + MODIFIED + "¬" + "|"
            + "¬" + MODIFIEDBY.toString().replace("-", "") + "¬" + "|"
            + "¬" + VERSION + "¬" + "|"
            + "¬" + ADVERTISINGENDDATE + "¬" + "|"
            + "¬" + ADVERTISINGSTARTDATE + "¬" + "|";

    @Test
    public void testBuildOpportunities() {
        Opportunities opportunities = new Opportunities();

        opportunities.setBenefits(BENEFITS);
        opportunities.setCommitmentAm(COMMITMENTAM);
        opportunities.setCommitmentEve(COMMITMENTEVE);
        opportunities.setIsVirtualRemote(ISVIRTUALREMOTE);
        opportunities.setCommitmentPm(COMMITMENTPM);
        opportunities.setLocationsPubliclyViewable(LOCATIONSPUBLICLYVIEWABLE);
        opportunities.setDescription(DESCRIPTION);
        opportunities.setMonetaryValuePerHour(MONETARYVALUEPERHOUR);
        opportunities.setIsActive(ISACTIVE);
        opportunities.setUseSharedIntConDets(USESHAREDINTCONDETS);
        opportunities.setOwnId(OWNID);
        opportunities.setIsDateSpecific(ISDATESPECIFIC);
        opportunities.setUseSharedPublicContactDetails(USESHAREDPUBLICCONTACTDETAILS);
        opportunities.setPublishToDoIt(PUBLISHTODOIT);
        opportunities.setIsOneOff(ISONEOFF);
        opportunities.setVbase2Id(VBASE2ID);
        opportunities.setRequirements(REQUIREMENTS);
        opportunities.setIsResidential(ISRESIDENTIAL);
        opportunities.setOrganisationId(ORGANISATIONID);
        opportunities.setShortDescription(SHORTDESCRIPTION);
        opportunities.setIsSharedInternalContactPublic(ISSHAREDINTERNALCONTACTPUBLIC);
        opportunities.setSharedInternalContactDetailsId(SHAREDINTERNALCONTACTDETAILSID);
        opportunities.setSpecificEndDate(SPECIFICENDDATE);
        opportunities.setSharedPublicContactDetailsId(SHAREDPUBLICCONTACTDETAILSID);
        opportunities.setSpecificStartDate(SPECIFICSTARTDATE);
        opportunities.setTitle(TITLE);
        opportunities.setId(ID);
        opportunities.setCreated(CREATED);
        opportunities.setCreatedBy(CREATEDBY);
        opportunities.setDeleted(DELETED);
        opportunities.setModified(MODIFIED);
        opportunities.setModifiedBy(MODIFIEDBY);
        opportunities.setVersion(VERSION);
        opportunities.setAdvertisingEndDate(ADVERTISINGENDDATE);
        opportunities.setAdvertisingStartDate(ADVERTISINGSTARTDATE);

        assertEquals("record equal", testRecord, opportunities.getRecord());
    }

    @Test
    public void testInitActivityLog() throws Exception {
        Opportunities opportunities = new Opportunities(testRecord);

        assertEquals("record equal", testRecord, opportunities.getRecord());

        assertEquals("benefits equals", BENEFITS, opportunities.getBenefits());
        assertEquals("commitmentam equals", COMMITMENTAM, opportunities.getCommitmentAm());
        assertEquals("commitmenteve equals", COMMITMENTEVE, opportunities.getCommitmentEve());
        assertEquals("isvirtualremote equals", ISVIRTUALREMOTE, opportunities.getIsVirtualRemote());
        assertEquals("commitmentpm equals", COMMITMENTPM, opportunities.getCommitmentPm());
        assertEquals("locationspubliclyviewable equals", LOCATIONSPUBLICLYVIEWABLE, opportunities.getLocationsPubliclyViewable());
        assertEquals("description equals", DESCRIPTION, opportunities.getDescription());
        assertEquals("monetaryvalueperhour equals", MONETARYVALUEPERHOUR, opportunities.getMonetaryValuePerHour());
        assertEquals("isactive equals", ISACTIVE, opportunities.getIsActive());
        assertEquals("usesharedintcondets equals", USESHAREDINTCONDETS, opportunities.getUseSharedIntConDets());
        assertEquals("ownid equals", OWNID, opportunities.getOwnId());
        assertEquals("isdatespecific equals", ISDATESPECIFIC, opportunities.getIsDateSpecific());
        assertEquals("usesharedpubliccontactdetails equals", USESHAREDPUBLICCONTACTDETAILS, opportunities.getUseSharedPublicContactDetails());
        assertEquals("publishtodoit equals", PUBLISHTODOIT, opportunities.getPublishToDoIt());
        assertEquals("isoneoff equals", ISONEOFF, opportunities.getIsOneOff());
        assertEquals("vbase2id equals", VBASE2ID, opportunities.getVbase2Id());
        assertEquals("requirements equals", REQUIREMENTS, opportunities.getRequirements());
        assertEquals("isresidential equals", ISRESIDENTIAL, opportunities.getIsResidential());
        assertEquals("organisationid equals", ORGANISATIONID, opportunities.getOrganisationId());
        assertEquals("shortdescription equals", SHORTDESCRIPTION, opportunities.getShortDescription());
        assertEquals("issharedinternalcontactpublic equals", ISSHAREDINTERNALCONTACTPUBLIC, opportunities.getIsSharedInternalContactPublic());
        assertEquals("sharedinternalcontactdetailsid equals", SHAREDINTERNALCONTACTDETAILSID, opportunities.getSharedInternalContactDetailsId());
        assertEquals("specificenddate equals", SPECIFICENDDATE, opportunities.getSpecificEndDate());
        assertEquals("sharedpubliccontactdetailsid equals", SHAREDPUBLICCONTACTDETAILSID, opportunities.getSharedPublicContactDetailsId());
        assertEquals("specificstartdate equals", SPECIFICSTARTDATE, opportunities.getSpecificStartDate());
        assertEquals("title equals", TITLE, opportunities.getTitle());
        assertEquals("id equals", ID, opportunities.getId());
        assertEquals("created equals", CREATED, opportunities.getCreated());
        assertEquals("createdby equals", CREATEDBY, opportunities.getCreatedBy());
        assertEquals("deleted equals", DELETED, opportunities.getDeleted());
        assertEquals("modified equals", MODIFIED, opportunities.getModified());
        assertEquals("modifiedby equals", MODIFIEDBY, opportunities.getModifiedBy());
        assertEquals("version equals", VERSION, opportunities.getVersion());
        assertEquals("advertisingenddate equals", ADVERTISINGENDDATE, opportunities.getAdvertisingEndDate());
        assertEquals("advertisingstartdate equals", ADVERTISINGSTARTDATE, opportunities.getAdvertisingStartDate());

        Opportunities newOpportunities = new Opportunities(testRecord);

        assertEquals("new record equal", testRecord, newOpportunities.getRecord());
    }
}