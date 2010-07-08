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

    @Override
    public void migrate(String csvDir, String outputDir) {
        CSVFileReader csvFileReader = null;
        BufferedWriter opportunitiesWriter = null;

        try {
            csvFileReader = new CSVFileReader(new FileReader(csvDir + "tblOpp.csv"));
            opportunitiesWriter = new BufferedWriter(new FileWriter(outputDir + "Opprotunities.csv"));

            Map<Long, Organisations> organisationVb2idMap =
                    CSVUtil.createVb2idMap(outputDir + "Organisations.csv", Organisations.class);

            Organisations vuoOrganisation = null;
            for (Organisations organisation : organisationVb2idMap.values()) {
                if (organisation.getIsVuo()) vuoOrganisation = organisation;
            }

            Map<Long, List<TblOppTime>> tblOppTimes = CSVUtil.createOidMap(csvDir + "tblOppTime.csv", TblOppTime.class);
            Map<Long, List<TblOppSpecial>> tblOppSpecials =
                    CSVUtil.createOidMap(csvDir + "tblOppSpecial.csv", TblOppSpecial.class);
            Map<Long, List<TblOppTypeOfActivity>> tblOppTypeOfActivities =
                    CSVUtil.createOidMap(csvDir + "tblOppTypeOfActivity.csv", TblOppTypeOfActivity.class);
            Map<Long, List<TblOppAreasOfInterest>> tblOppAreasOfInterests =
                    CSVUtil.createOidMap(csvDir + "tblOppAreasOfInterest.csv", TblOppAreasOfInterest.class);
            Map<Long, List<TblOppArrangements>> tblOppArrangementses =
                    CSVUtil.createOidMap(csvDir + "tblOppArrangements.csv", TblOppArrangements.class);
            Map<Long, List<TblOppRecruitmentMethod>> tblOppRecruitmentMethods =
                    CSVUtil.createOidMap(csvDir + "tblOppRecruitmentMethod.csv", TblOppRecruitmentMethod.class);
            List<UsysRegistration> usysRegistrations =
                    CSVUtil.createDomainList(csvDir + "UsysRegistration.csv", UsysRegistration.class);

            TblOpp tblOpp = null;
            Opportunities opportunities = null;
            Addresses addresses = null;
            Locations locations = null;
            Contacts contacts = null; 
            ContactDetails contactDetails = null;
            ContactDetails vuoContactDetails = null;
            String record = "";
            while ((record = csvFileReader.readRecord()) != null) {
                tblOpp = new TblOpp(record);
                opportunities = new Opportunities();
                addresses = null;
                locations = null;
                contacts = null;
                contactDetails = null;
                vuoContactDetails = null;

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
                    addresses = new Addresses();
                    locations = new Locations();
                    contacts = new Contacts();
                    contactDetails = new ContactDetails();

                    addresses.setId(UUID.randomUUID());
                    addresses.setVbase2Id(opportunities.getVbase2Id());
                    addresses.setAddress1(tblOpp.getAddress1());
                    addresses.setAddress2(tblOpp.getAddress2());
                    addresses.setAddress3(null);
                    addresses.setTown(tblOpp.getTown());
                    addresses.setCountryId(null);
                    addresses.setCountyId(null);
                    addresses.setPostCode(tblOpp.getPostcode());

                    locations.setId(UUID.randomUUID());
                    locations.setAddressId(addresses.getId());
                    locations.setOpportunityLocationId(opportunities.getId());
                    locations.setDisplayString(opportunities.getOwnId());
                    locations.setUseCustomAddress(true); // TODO: Set the opportunity addresses country lookup
                    locations.setIsActive(true); // TODO: Set the opportunity addresses county lookup
                    locations.setDiscriminator("PostCodeLocationAddress");
                    locations.setLocationType("POSTCODE");

                    contacts.setId(UUID.randomUUID());
                    contacts.setTitleId(null);  // TODO: Set the opportunity title lookup

                    if (tblOpp.getContact() != null && !tblOpp.getContact().equals("")) {
                        String[] contactArray = tblOpp.getContact().split(" ");
                        if(contactArray.length > 0) {
                            contacts.setFirstName(contactArray[0]);
                            contacts.setPreferredName(contactArray[0]);

                            if (contactArray.length > 1) contacts.setSurname(contactArray[1]);
                        }
                    }

                    contacts.setIsActive(true);
                    contacts.setUseAsMainContact(true);

                    contactDetails.setId(UUID.randomUUID());
                    contactDetails.setAddressId(addresses.getId());
                    contactDetails.setContactId(contacts.getId());
                    contactDetails.setUseCustomAddress(true);
                    contactDetails.setUseCustomPerson(true);
                    contactDetails.setCustomTelephone(tblOpp.getTel1());
                    contactDetails.setCustomFax(tblOpp.getFax());
                    contactDetails.setCustomEmail(tblOpp.getEmail());
                    contactDetails.setTelephoneSource("CUSTOM");
                    contactDetails.setFaxSource("CUSTOM");
                    contactDetails.setEmailSource("CUSTOM");
                    contactDetails.setWebAddressSource("CUSTOM");
                }

                opportunities.setSharedInternalContactDetailsId(contactDetails.getId());

                if (opportunities.getIsSharedInternalContactPublic()) {
                    opportunities.setSharedPublicContactDetailsId(contactDetails.getId());
                } else if (vuoOrganisation != null) {
                    vuoContactDetails = new ContactDetails();

                    vuoContactDetails.setId(UUID.randomUUID());
                    vuoContactDetails.setUseVuoDetails(true);
                    vuoContactDetails.setOrganisationAddressId(vuoOrganisation.getId());
                    vuoContactDetails.setTelephoneSource("ADDRESS");
                    vuoContactDetails.setFaxSource("ADDRESS");
                    vuoContactDetails.setEmailSource("ADDRESS");
                    vuoContactDetails.setWebAddressSource("ADDRESS");

                    opportunities.setSharedPublicContactDetailsId(vuoContactDetails.getId());
                }

                opportunitiesWriter.write(opportunities.getRecord() + "\n");
            }

        } catch (IOException e) {
            System.out.println("Error while migrating opportunities. Error:" + e.getMessage());
        } finally {
            try {
                if (csvFileReader != null) csvFileReader.close();
                if (opportunitiesWriter != null) opportunitiesWriter.close();
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
