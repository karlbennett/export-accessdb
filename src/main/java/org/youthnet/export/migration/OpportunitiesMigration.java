package org.youthnet.export.migration;

import org.youthnet.export.domain.vb25.*;
import org.youthnet.export.domain.vb3.*;
import org.youthnet.export.io.CSVFileReader;
import org.youthnet.export.util.CSVUtil;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * User: OpportunitiesMigration
 * Date: 06-Jul-2010
 */
public class OpportunitiesMigration implements Migratable {

    public static final Map<String, Integer> WEEK_MAP;

    static {
        Map<String, Integer> weekMap = new HashMap<String, Integer>();
        weekMap.put("sat", 1);
        weekMap.put("sun", 2);
        weekMap.put("mon", 4);
        weekMap.put("tue", 8);
        weekMap.put("wed", 16);
        weekMap.put("thurs", 32);
        weekMap.put("fri", 64);

        WEEK_MAP = Collections.unmodifiableMap(weekMap);
    }

    private Map<String, Map<String, Lookups>> lookupsMap;

    public OpportunitiesMigration(Map<String, Map<String, Lookups>> lookupsMap) {
        this.lookupsMap = lookupsMap;
    }

    @Override
    public void migrate(String csvDir, String outputDir) {
        CSVFileReader csvFileReader = null;
        BufferedWriter opportunitiesWriter = null;

        BufferedWriter addressWriter = null;
        BufferedWriter locationsWriter = null;
        BufferedWriter contactWriter = null;
        BufferedWriter contactDetailsWriter = null;

        BufferedWriter policyEntryiesWriter = null;
        BufferedWriter opportunityArrPolicyEntriesWriter = null;

        BufferedWriter opportunityTagsWriter = null;
        BufferedWriter opportunityTypesOfActivitiesWriter = null;
        BufferedWriter opportunityCausesInterestsWriter = null;
        BufferedWriter opportunitySelectionMethodsWriter = null;

        try {
            csvFileReader = new CSVFileReader(new FileReader(csvDir + "tblOpp.csv"));
            opportunitiesWriter = new BufferedWriter(new FileWriter(outputDir + "Opportunities.csv"));

            // Append to existing records created by OrganisationVuoMigration, OrganisationsMigration, VolunteersMigration.
            addressWriter = new BufferedWriter(new FileWriter(outputDir + "Addresses.csv", true));
            locationsWriter = new BufferedWriter(new FileWriter(outputDir + "Locations.csv"));
            // Append to existing records created by OrganisationsMigration.
            contactWriter = new BufferedWriter(new FileWriter(outputDir + "Contacts.csv", true));
            contactDetailsWriter = new BufferedWriter(new FileWriter(outputDir + "ContactDetails.csv"));

            policyEntryiesWriter = new BufferedWriter(new FileWriter(outputDir + "PolicyEntries.csv"));
            opportunityArrPolicyEntriesWriter = new BufferedWriter(new FileWriter(outputDir + "OpportunityArrPolicyEntry.csv"));

            opportunityTagsWriter = new BufferedWriter(new FileWriter(outputDir + "OpportunityTags.csv"));
            opportunityTypesOfActivitiesWriter = new BufferedWriter(new FileWriter(outputDir + "OpportunityTypesOfActivity.csv"));
            opportunityCausesInterestsWriter = new BufferedWriter(new FileWriter(outputDir + "OpportunityCausesInterests.csv"));
            opportunitySelectionMethodsWriter = new BufferedWriter(new FileWriter(outputDir + "OpportunitySelectionMethods.csv"));

            Map<Long, Organisations> organisationVb2idMap =
                    CSVUtil.createVb2idMap(outputDir + "Organisations.csv", Organisations.class);

            Organisations vuoOrganisation = null;
            for (Organisations organisation : organisationVb2idMap.values()) { // Find the vuo organisation to get it's address.
                if (organisation.getIsVuo()) vuoOrganisation = organisation;
            }

            UUID vuoAddressId = null;
            if (vuoOrganisation != null) { // If the vuo organisation was found find it's address id.
                for (OrganisationAddresses organisationAddress :
                        CSVUtil.createDomainList(outputDir + "OrganisationAddresses.csv", OrganisationAddresses.class)) {
                    if (organisationAddress.getOrgAddConInfoId().equals(vuoOrganisation.getId())) {
                        vuoAddressId = organisationAddress.getAddressId();
                    }
                }
            }

            Map<Long, List<TblOppTime>> tblOppTimes = CSVUtil.createOidMap(csvDir + "tblOppTime.csv", TblOppTime.class);
            Map<Long, List<TblOppArrangements>> tblOppArrangementses =
                    CSVUtil.createOidMap(csvDir + "tblOppArrangements.csv", TblOppArrangements.class);
            Map<Long, List<TblOppSpecial>> tblOppSpecials =
                    CSVUtil.createOidMap(csvDir + "tblOppSpecial.csv", TblOppSpecial.class);
            Map<Long, List<TblOppTypeOfActivity>> tblOppTypeOfActivities =
                    CSVUtil.createOidMap(csvDir + "tblOppTypeOfActivity.csv", TblOppTypeOfActivity.class);
            Map<Long, List<TblOppAreasOfInterest>> tblOppAreasOfInterests =
                    CSVUtil.createOidMap(csvDir + "tblOppAreasOfInterest.csv", TblOppAreasOfInterest.class);
            Map<Long, List<TblOppRecruitmentMethod>> tblOppRecruitmentMethods =
                    CSVUtil.createOidMap(csvDir + "tblOppRecruitmentMethod.csv", TblOppRecruitmentMethod.class);

            TblOpp tblOpp = null;
            Opportunities opportunities = null;
            Addresses address = null;
            Locations locations = null;
            Contacts contact = null;
            ContactDetails contactDetails = null;
            ContactDetails vuoContactDetails = null;
            List<PolicyEntries> policyEntryies = null;
            List<OpportunityArrPolicyEntry> opportunityArrPolicyEntries = null;
            List<OpportunityTags> opportunityTags = null;
            List<OpportunityTypesOfActivity> opportunityTypesOfActivities = null;
            List<OpportunityCausesInterests> opportunityCausesInterests = null;
            List<OpportunitySelectionMethods> opportunitySelectionMethods = null;
            String record = "";
            while ((record = csvFileReader.readRecord()) != null) {
                tblOpp = new TblOpp(record);
                opportunities = new Opportunities();
                address = null;
                locations = null;
                contact = null;
                contactDetails = null;
                vuoContactDetails = null;
                policyEntryies = null;
                opportunityArrPolicyEntries = null;
                opportunityTypesOfActivities = null;
                opportunityCausesInterests = null;
                opportunitySelectionMethods = null;

                opportunities.setId(UUID.randomUUID());
                opportunities.setVbase2Id(tblOpp.getOid());
                opportunities.setTitle(tblOpp.getTitle());
                opportunities.setOwnId(tblOpp.getOppenteredid());
                opportunities.setOrganisationId(
                        organisationVb2idMap.get(opportunities.getVbase2Id()) == null ?
                                null : organisationVb2idMap.get(opportunities.getVbase2Id()).getId());
                opportunities.setUseSharedIntConDets(true);
                opportunities.setIsSharedInternalContactPublic(!tblOpp.getIncludevbaddress());
                opportunities.setUseSharedPublicContactDetails(true);
                opportunities.setBenefits(null); // Not available in V-Base 2.5
                opportunities.setDescription(tblOpp.getDescription());

                if (tblOpp.getShortdescription() != null && !tblOpp.getShortdescription().equals("")) {
                    opportunities.setShortDescription(tblOpp.getShortdescription());
                } else if (tblOpp.getDescription().length() > 250) {
                    opportunities.setShortDescription(tblOpp.getDescription().substring(0, 247) + "...");
                } else opportunities.setShortDescription(tblOpp.getDescription());

                opportunities.setMonetaryValuePerHour(tblOpp.getMonetaryvalue().floatValue());
                opportunities.setIsVirtualRemote(tblOpp.getVirtualvol());
                opportunities.setIsResidential(tblOpp.getResidential());
                opportunities.setIsOneOff(tblOpp.getOneoff());
                opportunities.setIsDateSpecific(tblOpp.getSpecificstartdate() != null);
                opportunities.setSpecificStartDate(opportunities.getIsDateSpecific() ? tblOpp.getSpecificstartdate() : null);
                opportunities.setSpecificEndDate(opportunities.getIsDateSpecific() ? tblOpp.getSpecificenddate() : null);
                opportunities.setCommitmentAm(createCommitment(tblOppTimes.get(opportunities.getVbase2Id()), "AM"));
                opportunities.setCommitmentPm(createCommitment(tblOppTimes.get(opportunities.getVbase2Id()), "AM"));
                opportunities.setCommitmentEve(createCommitment(tblOppTimes.get(opportunities.getVbase2Id()), "AM"));
                opportunities.setAdvertisingStartDate(tblOpp.getOppstartdate());
                opportunities.setAdvertisingEndDate(tblOpp.getOppenddate());
                opportunities.setPublishToDoIt(tblOpp.getIncludeonweb() != null && tblOpp.getIncludeonweb());
                opportunities.setIsActive(tblOpp.getActive());
                opportunities.setRequirements(tblOpp.getSkillsqualifications());

                if (tblOpp.getAddress1() != null && !tblOpp.getAddress1().equals("")) {
                    address = new Addresses();
                    locations = new Locations();
                    contact = new Contacts();
                    contactDetails = new ContactDetails();

                    address.setId(UUID.randomUUID());
                    address.setVbase2Id(opportunities.getVbase2Id());
                    address.setAddress1(tblOpp.getAddress1());
                    address.setAddress2(tblOpp.getAddress2());
                    address.setAddress3(null);
                    address.setTown(tblOpp.getTown());
                    address.setCountryId(lookupsMap.get("country") != null &&
                            lookupsMap.get("country").get("uk") != null ?
                            lookupsMap.get("country").get("uk").getId() : null);
                    address.setCountyId(lookupsMap.get("county") != null &&
                            lookupsMap.get("county").get(tblOpp.getCounty().toLowerCase()) != null ?
                            lookupsMap.get("county").get(tblOpp.getCounty().toLowerCase()).getId() : null);
                    address.setPostCode(tblOpp.getPostcode());

                    locations.setId(UUID.randomUUID());
                    locations.setAddressId(address.getId());
                    locations.setOpportunityLocationId(opportunities.getId());
                    locations.setDisplayString(opportunities.getOwnId());
                    locations.setUseCustomAddress(true);
                    locations.setIsActive(true);
                    locations.setDiscriminator("PostCodeLocationAddress");
                    locations.setLocationType("POSTCODE");

                    contact.setId(UUID.randomUUID());
                    contact.setTitleId(lookupsMap.get("title") != null &&
                        lookupsMap.get("title").get("-") != null ? lookupsMap.get("title").get("-").getId() : null);

                    if (tblOpp.getContact() != null && !tblOpp.getContact().equals("")) {
                        String[] contactArray = tblOpp.getContact().split(" ");
                        if (contactArray.length > 0) {
                            contact.setFirstName(contactArray[0]);
                            contact.setPreferredName(contactArray[0]);

                            if (contactArray.length > 1) contact.setSurname(contactArray[1]);
                        }
                    }

                    contact.setIsActive(true);
                    contact.setUseAsMainContact(true);

                    contactDetails.setId(UUID.randomUUID());
                    contactDetails.setAddressId(address.getId());
                    contactDetails.setContactId(contact.getId());
                    contactDetails.setUseCustomAddress(true);
                    contactDetails.setUseCustomPerson(true);
                    contactDetails.setCustomTelephone(tblOpp.getTel1());
                    contactDetails.setCustomFax(tblOpp.getFax());
                    contactDetails.setCustomEmail(tblOpp.getEmail());
                    contactDetails.setTelephoneSource("CUSTOM");
                    contactDetails.setFaxSource("CUSTOM");
                    contactDetails.setEmailSource("CUSTOM");
                    contactDetails.setWebAddressSource("CUSTOM");

                    opportunities.setSharedInternalContactDetailsId(contactDetails.getId());

                    if (opportunities.getIsSharedInternalContactPublic()) {
                        opportunities.setSharedPublicContactDetailsId(contactDetails.getId());
                    } else if (vuoAddressId != null) {
                        vuoContactDetails = new ContactDetails();

                        vuoContactDetails.setId(UUID.randomUUID());
                        vuoContactDetails.setUseVuoDetails(true);
                        vuoContactDetails.setOrganisationAddressId(vuoAddressId);
                        vuoContactDetails.setTelephoneSource("ADDRESS");
                        vuoContactDetails.setFaxSource("ADDRESS");
                        vuoContactDetails.setEmailSource("ADDRESS");
                        vuoContactDetails.setWebAddressSource("ADDRESS");

                        opportunities.setSharedPublicContactDetailsId(vuoContactDetails.getId());
                    }
                }

                if (tblOppArrangementses.get(opportunities.getVbase2Id()) != null) {
                    policyEntryies = new ArrayList<PolicyEntries>();
                    opportunityArrPolicyEntries = new ArrayList<OpportunityArrPolicyEntry>();

                    PolicyEntries policyEntry = null;
                    OpportunityArrPolicyEntry opportunityArrPolicyEntry = null;
                    for (TblOppArrangements arrangement : tblOppArrangementses.get(opportunities.getVbase2Id())) {
                        policyEntry = new PolicyEntries();
                        opportunityArrPolicyEntry = new OpportunityArrPolicyEntry();

                        policyEntry.setId(UUID.randomUUID());
                        policyEntry.setDiscriminator("A");
                        policyEntry.setPolicyId(lookupsMap.get("arrangement") != null &&
                            lookupsMap.get("arrangement").get(arrangement.getOpparrangements().toLowerCase()) != null ?
                            lookupsMap.get("arrangement").get(arrangement.getOpparrangements().toLowerCase()).getId() :
                                null);
                        policyEntry.setPolicyStatusId(lookupsMap.get("arrangementstatus") != null &&
                            lookupsMap.get("arrangementstatus").get(arrangement.getDetails().toLowerCase()) != null ?
                            lookupsMap.get("arrangementstatus").get(arrangement.getDetails().toLowerCase()).getId() :
                                null); // TODO put back to lookupsMap.get("arrangementstatus").get("-").getId() 
                        policyEntry.setComments(arrangement.getDetails());

                        opportunityArrPolicyEntry.setOpportunityId(opportunities.getId());
                        opportunityArrPolicyEntry.setPolicyId(policyEntry.getId());

                        policyEntryies.add(policyEntry);
                        opportunityArrPolicyEntries.add(opportunityArrPolicyEntry);
                    }
                }

                if (tblOppSpecials.get(opportunities.getVbase2Id()) != null) {
                    opportunityTags = new ArrayList<OpportunityTags>();

                    OpportunityTags opportunityTag = null;
                    for (TblOppSpecial special : tblOppSpecials.get(opportunities.getVbase2Id())) {
                        opportunityTag = new OpportunityTags();
                        opportunityTag.setOpportunityId(opportunities.getId());
                        opportunityTag.setLookupId(lookupsMap.get("taggeddata") != null &&
                            lookupsMap.get("taggeddata").get(special.getSpecial().toLowerCase()) != null ?
                            lookupsMap.get("taggeddata").get(special.getSpecial().toLowerCase()).getId() :
                                null);

                        opportunityTags.add(opportunityTag);
                    }
                }

                if (tblOppTypeOfActivities.get(opportunities.getVbase2Id()) != null) {
                    opportunityTypesOfActivities = new ArrayList<OpportunityTypesOfActivity>();

                    OpportunityTypesOfActivity opportunityTypesOfActivity = null;
                    for (TblOppTypeOfActivity activity : tblOppTypeOfActivities.get(opportunities.getVbase2Id())) {
                        opportunityTypesOfActivity = new OpportunityTypesOfActivity();
                        opportunityTypesOfActivity.setOpportunityId(opportunities.getId());
                        opportunityTypesOfActivity.setLookupId(lookupsMap.get("typeofactivity") != null &&
                            lookupsMap.get("typeofactivity").get(activity.getTypeofactivity().toLowerCase()) != null ?
                            lookupsMap.get("typeofactivity").get(activity.getTypeofactivity().toLowerCase()).getId() :
                                null);

                        opportunityTypesOfActivities.add(opportunityTypesOfActivity);
                    }
                }

                if (tblOppAreasOfInterests.get(opportunities.getVbase2Id()) != null) {
                    opportunityCausesInterests = new ArrayList<OpportunityCausesInterests>();

                    OpportunityCausesInterests opportunityCausesInterest = null;
                    for (TblOppAreasOfInterest interest : tblOppAreasOfInterests.get(opportunities.getVbase2Id())) {
                        opportunityCausesInterest = new OpportunityCausesInterests();
                        opportunityCausesInterest.setOpportunityId(opportunities.getId());
                        opportunityCausesInterest.setLookupId(lookupsMap.get("causeinterest") != null &&
                            lookupsMap.get("causeinterest").get(interest.getAreasofinterest().toLowerCase()) != null ?
                            lookupsMap.get("causeinterest").get(interest.getAreasofinterest().toLowerCase()).getId() :
                                null);

                        opportunityCausesInterests.add(opportunityCausesInterest);
                    }
                }

                if (tblOppRecruitmentMethods.get(opportunities.getVbase2Id()) != null) {
                    opportunitySelectionMethods = new ArrayList<OpportunitySelectionMethods>();

                    OpportunitySelectionMethods opportunitySelectionMethod = null;
                    for (TblOppRecruitmentMethod method : tblOppRecruitmentMethods.get(opportunities.getVbase2Id())) {
                        opportunitySelectionMethod = new OpportunitySelectionMethods();
                        opportunitySelectionMethod.setOpportunityId(opportunities.getId());
                        opportunitySelectionMethod.setLookupId(lookupsMap.get("selectionmethod") != null &&
                            lookupsMap.get("selectionmethod").get(method.getRecruitmentmethod().toLowerCase()) != null ?
                            lookupsMap.get("selectionmethod").get(method.getRecruitmentmethod().toLowerCase()).getId() :
                                null);

                        opportunitySelectionMethods.add(opportunitySelectionMethod);
                    }
                }

                opportunitiesWriter.write(opportunities.getRecord() + "\n");

                if (address != null) addressWriter.write(address.getRecord() + "\n");
                if (locations != null) locationsWriter.write(locations.getRecord() + "\n");
                if (contact != null) contactWriter.write(contact.getRecord() + "\n");
                if (contactDetails != null) contactDetailsWriter.write(contactDetails.getRecord() + "\n");
                if (vuoContactDetails != null) contactDetailsWriter.write(vuoContactDetails.getRecord() + "\n");

                if (policyEntryies != null) {
                    for (PolicyEntries policyEntry : policyEntryies) {
                        policyEntryiesWriter.write(policyEntry.getRecord() + "\n");
                    }
                }
                if (opportunityArrPolicyEntries != null) {
                    for (OpportunityArrPolicyEntry arrPolicyEntry : opportunityArrPolicyEntries) {
                        opportunityArrPolicyEntriesWriter.write(arrPolicyEntry.getRecord() + "\n");
                    }
                }
                if (opportunityTags != null) {
                    for (OpportunityTags opportunityTag : opportunityTags) {
                        opportunityTagsWriter.write(opportunityTag.getRecord() + "\n");
                    }
                }
                if (opportunityTypesOfActivities != null) {
                    for (OpportunityTypesOfActivity typesOfActivity : opportunityTypesOfActivities) {
                        opportunityTypesOfActivitiesWriter.write(typesOfActivity.getRecord() + "\n");
                    }
                }
                if (opportunityCausesInterests != null) {
                    for (OpportunityCausesInterests causesInterest : opportunityCausesInterests) {
                        opportunityCausesInterestsWriter.write(causesInterest.getRecord() + "\n");
                    }
                }
                if (opportunitySelectionMethods != null) {
                    for (OpportunitySelectionMethods selectionMethod : opportunitySelectionMethods) {
                        opportunitySelectionMethodsWriter.write(selectionMethod.getRecord() + "\n");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error while migrating opportunities. Error:" + e.getMessage());
        } finally {
            try {
                if (csvFileReader != null) csvFileReader.close();
                if (opportunitiesWriter != null) {
                    opportunitiesWriter.flush();
                    opportunitiesWriter.close();
                }
                if (addressWriter != null) {
                    addressWriter.flush();
                    addressWriter.close();
                }
                if (locationsWriter != null) {
                    locationsWriter.flush();
                    locationsWriter.close();
                }
                if (contactWriter != null) {
                    contactWriter.flush();
                    contactWriter.close();
                }
                if (contactDetailsWriter != null) {
                    contactDetailsWriter.flush();
                    contactDetailsWriter.close();
                }
                if (policyEntryiesWriter != null) {
                    policyEntryiesWriter.flush();
                    policyEntryiesWriter.close();
                }
                if (opportunityArrPolicyEntriesWriter != null) {
                    opportunityArrPolicyEntriesWriter.flush();
                    opportunityArrPolicyEntriesWriter.close();
                }
                if (opportunityTagsWriter != null) {
                    opportunityTagsWriter.flush();
                    opportunityTagsWriter.close();
                }
                if (opportunityTypesOfActivitiesWriter != null) {
                    opportunityTypesOfActivitiesWriter.flush();
                    opportunityTypesOfActivitiesWriter.close();
                }
                if (opportunityCausesInterestsWriter != null) {
                    opportunityCausesInterestsWriter.flush();
                    opportunityCausesInterestsWriter.close();
                }
                if (opportunitySelectionMethodsWriter != null) {
                    opportunitySelectionMethodsWriter.flush();
                    opportunitySelectionMethodsWriter.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing opportunities streams. Error:" + e.getMessage());
            }

        }
    }

    private Long createCommitment(List<TblOppTime> tblOppTimes, String time) {
        Long commitment = 0L;
        if (tblOppTimes != null) { // Prevent null pointer exception.
            for (TblOppTime tblOppTime : tblOppTimes) {
                if (tblOppTime.getTimeslot().equals(time)) {
                    commitment = commitment + WEEK_MAP.get(tblOppTime.getDay().toLowerCase());
                }
            }
        }

        return commitment;
    }
}
