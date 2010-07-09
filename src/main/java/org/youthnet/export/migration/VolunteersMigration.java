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
 * User: VolunteersMigration
 * Date: 06-Jul-2010
 */
public class VolunteersMigration implements Migratable {

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
    private Map<String, UUID> availabilityStatusMap;

    public VolunteersMigration(Map<String, Map<String, Lookups>> lookupsMap) {
        this.lookupsMap = lookupsMap;

        availabilityStatusMap = new HashMap<String, UUID>();
        availabilityStatusMap.put("available", lookupsMap.get("availabilitystatus").get("available") != null ?
                lookupsMap.get("availabilitystatus").get("available").getId() : null);
        availabilityStatusMap.put("registered an interest", lookupsMap.get("availabilitystatus").get("available") != null ?
                lookupsMap.get("availabilitystatus").get("available").getId() : null);
        availabilityStatusMap.put("not available", lookupsMap.get("availabilitystatus").get("unavailable") != null ?
                lookupsMap.get("availabilitystatus").get("unavailable").getId() : null);
        availabilityStatusMap.put("placed", lookupsMap.get("availabilitystatus").get("unknown") != null ?
                lookupsMap.get("availabilitystatus").get("unknown").getId() : null);
        availabilityStatusMap.put("special skills", lookupsMap.get("availabilitystatus").get("unknown") != null ?
                lookupsMap.get("availabilitystatus").get("unknown").getId() : null);
    }

    @Override
    public void migrate(String csvDir, String outputDir) {
        CSVFileReader csvFileReader = null;
        BufferedWriter volunteersWriter = null;

        BufferedWriter volunteerAddressesWriter = null;

        BufferedWriter volunteerContactInfoWriter = null;
        BufferedWriter volunteerContactTelephonesWriter = null;
        BufferedWriter volunteerContactEmailsWriter = null;

        BufferedWriter volunteerGeoAreaLookupsWriter = null;
        BufferedWriter volunteerTypeOfActivityLookupsWriter = null;
        BufferedWriter volunteerCausesIntsLookupsWriter = null;
        BufferedWriter volunteerTagsLookupsWriter = null;

        BufferedWriter addressesWriter = null;


        try {
            csvFileReader = new CSVFileReader(new FileReader(csvDir + "tblVol.csv"));
            volunteersWriter = new BufferedWriter(new FileWriter(outputDir + "Volunteers.csv"));

            volunteerAddressesWriter = new BufferedWriter(new FileWriter(outputDir + "VolunteerAddresses.csv"));

            volunteerContactInfoWriter = new BufferedWriter(new FileWriter(outputDir + "VolunteerContactInfo.csv"));
            volunteerContactTelephonesWriter = new BufferedWriter(new FileWriter(outputDir + "VolunteerContactTelephones.csv"));
            volunteerContactEmailsWriter = new BufferedWriter(new FileWriter(outputDir + "VolunteerContactEmails.csv"));

            volunteerGeoAreaLookupsWriter = new BufferedWriter(new FileWriter(outputDir + "VolunteerGeoAreaLookups.csv"));
            volunteerTypeOfActivityLookupsWriter = new BufferedWriter(new FileWriter(outputDir + "VolunteerTypeOfActivityLookups.csv"));
            volunteerCausesIntsLookupsWriter = new BufferedWriter(new FileWriter(outputDir + "VolunteerCausesIntsLookups.csv"));
            volunteerTagsLookupsWriter = new BufferedWriter(new FileWriter(outputDir + "VolunteerTagsLookups.csv"));

            addressesWriter = new BufferedWriter(new FileWriter(outputDir + "Addresses.csv"));

            Map<Long, List<TblVolTime>> tblVolTimes = CSVUtil.createVidMap(csvDir + "tblVolTime.csv", TblVolTime.class);
            Map<Long, List<TblVolTypeOfActivity>> tblVolTypeOfActivities =
                    CSVUtil.createVidMap(csvDir + "tblVolTypeOfActivity.csv", TblVolTypeOfActivity.class);
            Map<Long, List<TblVolAreasOfInterest>> tblVolAreasOfInterests =
                    CSVUtil.createVidMap(csvDir + "tblVolAreasOfInterest.csv", TblVolAreasOfInterest.class);
            Map<Long, List<TblVolSpecial>> tblVolSpecials =
                    CSVUtil.createVidMap(csvDir + "tblVolSpecial.csv", TblVolSpecial.class);

            TblVol tblVol = null;
            Volunteers volunteers = null;
            VolunteerContactInfo dayTimeContactInfo = null;
            VolunteerContactTelephones dayTimeTelephone = null;
            VolunteerContactInfo eveningContactInfo = null;
            VolunteerContactTelephones eveningTelephone = null;
            VolunteerContactInfo faxContactInfo = null;
            VolunteerContactTelephones faxTelephone = null;
            VolunteerContactInfo mobileContactInfo = null;
            VolunteerContactTelephones mobileTelephone = null;
            VolunteerContactInfo emailContactInfo = null;
            VolunteerContactEmails email = null;
            VolunteerGeoAreaLookups volunteerGeoAreas = null;
            List<VolunteerTypeOfActivityLookups> volunteerTypeOfActivities = null;
            List<VolunteerCausesIntsLookups> volunteerCausesInts = null;
            List<VolunteerTagsLookups> volunteerTags = null;
            VolunteerAddresses volunteerAddresses = null;
            Addresses addresses = null;
            String record = "";
            while ((record = csvFileReader.readRecord()) != null) {
                tblVol = new TblVol(record);
                volunteers = new Volunteers();

                dayTimeContactInfo = null;
                dayTimeTelephone = null;
                eveningContactInfo = null;
                eveningTelephone = null;
                faxContactInfo = null;
                faxTelephone = null;
                mobileContactInfo = null;
                mobileTelephone = null;
                emailContactInfo = null;
                email = null;
                volunteerGeoAreas = null;
                volunteerTypeOfActivities = null;
                volunteerCausesInts = null;
                volunteerTags = null;
                volunteerAddresses = null;
                addresses = null;

                // -- Migrate the volunteer root  data --
                volunteers.setId(UUID.randomUUID());
                volunteers.setVbase2Id(tblVol.getVid());
                volunteers.setIsActive(true);
                volunteers.setTitleId(lookupsMap.get("title") != null &&
                        lookupsMap.get("title").get(tblVol.getTitle().toLowerCase()) != null ?
                        lookupsMap.get("title").get(tblVol.getTitle().toLowerCase()).getId() :
                        null); // TODO put back to lookupsMap.get("title").get("-").getId()
                volunteers.setFirstName(tblVol.getFirstname());
                volunteers.setLastName(tblVol.getLastname());
                volunteers.setPreferredName(tblVol.getSalutation() != null &&
                        !tblVol.getSalutation().trim().equals("") ? tblVol.getSalutation() : tblVol.getFirstname());
                volunteers.setAgreesToBeContacted(tblVol.getContactable());
                volunteers.setDisabilityDetails(tblVol.getDisabilitystatus());
                volunteers.setDateOfBirth(tblVol.getDob());
                volunteers.setGenderId(lookupsMap.get("gender") != null &&
                        lookupsMap.get("gender").get(tblVol.getGender().toLowerCase()) != null ?
                        lookupsMap.get("gender").get(tblVol.getGender().toLowerCase()).getId() :
                        null);
                volunteers.setAgeRangeId(lookupsMap.get("agerange") != null &&
                        lookupsMap.get("agerange").get(tblVol.getAgerange().toLowerCase()) != null ?
                        lookupsMap.get("agerange").get(tblVol.getAgerange().toLowerCase()).getId() :
                        null);
                volunteers.setEmploymentStatusId(lookupsMap.get("employmentstatus") != null &&
                        lookupsMap.get("employmentstatus").get(tblVol.getEmploymentstatus().toLowerCase()) != null ?
                        lookupsMap.get("employmentstatus").get(tblVol.getEmploymentstatus().toLowerCase()).getId() :
                        null);
                volunteers.setEthnicityId(lookupsMap.get("ethnicity") != null &&
                        lookupsMap.get("ethnicity").get(tblVol.getEthnicity().toLowerCase()) != null ?
                        lookupsMap.get("ethnicity").get(tblVol.getEthnicity().toLowerCase()).getId() :
                        null);
                volunteers.setDrivingLicenceId(lookupsMap.get("drivinglicence") != null &&
                        lookupsMap.get("drivinglicence").get(tblVol.getTypeofdrivinglicence().toLowerCase()) != null ?
                        lookupsMap.get("drivinglicence").get(tblVol.getTypeofdrivinglicence().toLowerCase()).getId() :
                        null);
                volunteers.setNationalityId(lookupsMap.get("nationality") != null &&
                        lookupsMap.get("nationality").get(tblVol.getNationality().toLowerCase()) != null ?
                        lookupsMap.get("nationality").get(tblVol.getNationality().toLowerCase()).getId() :
                        null);
                volunteers.setReligionId(lookupsMap.get("religion") != null &&
                        lookupsMap.get("religion").get(tblVol.getReligion().toLowerCase()) != null ?
                        lookupsMap.get("religion").get(tblVol.getReligion().toLowerCase()).getId() :
                        null);
                volunteers.setDisabilityStatusId(lookupsMap.get("disabilityStatus") != null &&
                        lookupsMap.get("disabilityStatus").get(tblVol.getDisabilitystatus().toLowerCase()) != null ?
                        lookupsMap.get("disabilityStatus").get(tblVol.getDisabilitystatus().toLowerCase()).getId() :
                        null);
                volunteers.setTransportId(lookupsMap.get("transport") != null &&
                        lookupsMap.get("transport").get(tblVol.getDriving().toLowerCase()) != null ?
                        lookupsMap.get("transport").get(tblVol.getDriving().toLowerCase()).getId() :
                        null);
                volunteers.setQualificationsAndExperience(tblVol.getPreviouswork());
                volunteers.setAmCommitment(createCommitment(tblVolTimes.get(volunteers.getVbase2Id()), "AM"));
                volunteers.setPmCommitment(createCommitment(tblVolTimes.get(volunteers.getVbase2Id()), "PM"));
                volunteers.setEveCommitment(createCommitment(tblVolTimes.get(volunteers.getVbase2Id()), "EVE"));
                volunteers.setAvailabilityStatusId(availabilityStatusMap.get(tblVol.getStatus().toLowerCase()));
                volunteers.setPlacementStatusId(lookupsMap.get("placementstatus") != null &&
                        lookupsMap.get("placementstatus").get(tblVol.getStatus().toLowerCase()) != null ?
                        lookupsMap.get("placementstatus").get(tblVol.getStatus().toLowerCase()).getId() :
                        lookupsMap.get("placementstatus").get("unknown").getId());
                volunteers.setHowHeardId(lookupsMap.get("howheard") != null &&
                        lookupsMap.get("howheard").get(tblVol.getHowheard().toLowerCase()) != null ?
                        lookupsMap.get("howheard").get(tblVol.getHowheard().toLowerCase()).getId() :
                        null);

                // -- Migrate the volunteer generic address data --
                // If the volunteer has an address, migrate it.
                if (tblVol.getAddress1() != null && !tblVol.getAddress1().equals("")) {
                    addresses = new Addresses();
                    volunteerAddresses = new VolunteerAddresses();

                    addresses.setId(UUID.randomUUID());
                    addresses.setVbase2Id(volunteers.getVbase2Id());
                    addresses.setAddress1(tblVol.getAddress1());
                    addresses.setAddress2(tblVol.getAddress2());
                    addresses.setTown(tblVol.getTown());
                    addresses.setCountryId(lookupsMap.get("country") != null &&
                            lookupsMap.get("country").get("uk") != null ?
                            lookupsMap.get("country").get("uk").getId() : null);
                    addresses.setCountyId(lookupsMap.get("county") != null &&
                            lookupsMap.get("county").get(tblVol.getCounty().toLowerCase()) != null ?
                            lookupsMap.get("county").get(tblVol.getCounty().toLowerCase()).getId() : null);
                    addresses.setPostCode(tblVol.getPostcode());

                    volunteerAddresses.setVolunteerId(volunteers.getId());
                    volunteerAddresses.setName("Unspecified");
                    volunteerAddresses.setAddressId(addresses.getId());
                    volunteerAddresses.setIsActive(true);
                    volunteerAddresses.setIsDefaultAddress(true);
                }

                // -- Migrate the volunteer day time telephone number --
                // If the volunteer has a day time telephone number, migrate it.
                if (tblVol.getTelday() != null && !tblVol.getTelday().equals("")) {
                    dayTimeContactInfo = new VolunteerContactInfo();
                    dayTimeTelephone = new VolunteerContactTelephones();

                    dayTimeContactInfo.setId(UUID.randomUUID());
                    dayTimeContactInfo.setIsActive(true);
                    dayTimeContactInfo.setIsDefault(false);
                    dayTimeContactInfo.setNotes("Daytime");
                    dayTimeTelephone.setVolunteerId(volunteers.getId());
                    dayTimeTelephone.setVolunteerContactInfoId(dayTimeContactInfo.getId());
                    dayTimeTelephone.setTelephoneTypeId(lookupsMap.get("telephonetype") != null &&
                            lookupsMap.get("telephonetype").get("unspecified") != null ?
                            lookupsMap.get("telephonetype").get("unspecified").getId() : null);
                    dayTimeTelephone.setTel_number(tblVol.getTelday());
                }

                // -- Migrate the volunteer evening telephone number --
                // If the volunteer has an evening telephone number, migrate it.
                if (tblVol.getTelevening() != null && !tblVol.getTelevening().equals("")) {
                    eveningContactInfo = new VolunteerContactInfo();
                    eveningTelephone = new VolunteerContactTelephones();

                    eveningContactInfo.setId(UUID.randomUUID());
                    eveningContactInfo.setIsActive(true);
                    eveningContactInfo.setIsDefault(false);
                    eveningContactInfo.setNotes("Evening");
                    eveningTelephone.setVolunteerId(volunteers.getId());
                    eveningTelephone.setVolunteerContactInfoId(eveningContactInfo.getId());
                    eveningTelephone.setTelephoneTypeId(lookupsMap.get("telephonetype") != null &&
                            lookupsMap.get("telephonetype").get("unspecified") != null ?
                            lookupsMap.get("telephonetype").get("unspecified").getId() : null);
                    eveningTelephone.setTel_number(tblVol.getTelevening());
                }

                // -- Migrate the volunteer fax telephone number --
                // If the volunteer has a fax telephone number, migrate it.
                if (tblVol.getFax() != null && !tblVol.getFax().equals("")) {
                    faxContactInfo = new VolunteerContactInfo();
                    faxTelephone = new VolunteerContactTelephones();

                    faxContactInfo.setId(UUID.randomUUID());
                    faxContactInfo.setIsActive(true);
                    faxContactInfo.setIsDefault(false);
                    faxContactInfo.setNotes("");
                    faxTelephone.setVolunteerId(volunteers.getId());
                    faxTelephone.setVolunteerContactInfoId(faxContactInfo.getId());
                    faxTelephone.setTelephoneTypeId(lookupsMap.get("telephonetype") != null &&
                            lookupsMap.get("telephonetype").get("fax") != null ?
                            lookupsMap.get("telephonetype").get("fax").getId() : null);
                    faxTelephone.setTel_number(tblVol.getFax());
                }

                // -- Migrate the volunteer mobile telephone number --
                // If the volunteer has a mobile telephone number, migrate it.
                if (tblVol.getMobile() != null && !tblVol.getMobile().equals("")) {
                    mobileContactInfo = new VolunteerContactInfo();
                    mobileTelephone = new VolunteerContactTelephones();

                    mobileContactInfo.setId(UUID.randomUUID());
                    mobileContactInfo.setIsActive(true);
                    mobileContactInfo.setIsDefault(false);
                    mobileContactInfo.setNotes("");
                    mobileTelephone.setVolunteerId(volunteers.getId());
                    mobileTelephone.setVolunteerContactInfoId(mobileContactInfo.getId());
                    mobileTelephone.setTelephoneTypeId(lookupsMap.get("telephonetype") != null &&
                            lookupsMap.get("telephonetype").get("mobile") != null ?
                            lookupsMap.get("telephonetype").get("mobile").getId() : null);
                    mobileTelephone.setTel_number(tblVol.getMobile());
                }

                // -- Migrate the volunteer email --
                // If the volunteer has a email, migrate it.
                if (tblVol.getEmail() != null && !tblVol.getEmail().equals("")) {
                    emailContactInfo = new VolunteerContactInfo();
                    email = new VolunteerContactEmails();

                    emailContactInfo.setId(UUID.randomUUID());
                    emailContactInfo.setIsActive(true);
                    emailContactInfo.setIsDefault(true);
                    emailContactInfo.setNotes("");
                    email.setVolunteerId(volunteers.getId());
                    email.setVolunteerContactInfoId(emailContactInfo.getId());
                    email.setTelephoneTypeId(lookupsMap.get("emailtype") != null &&
                            lookupsMap.get("emailtype").get("unspecified") != null ?
                            lookupsMap.get("emailtype").get("unspecified").getId() : null);
                    email.setEmail(tblVol.getEmail());
                }

                // -- Migrate the volunteer day time telephone number --
                // If the volunteer has a geographical area, migrate it.
                if (tblVol.getGeographicalarea() != null && !tblVol.getGeographicalarea().equals("")) {
                    volunteerGeoAreas = new VolunteerGeoAreaLookups();

                    volunteerGeoAreas.setVolunteerId(volunteers.getId());
                    volunteerGeoAreas.setLookupId(lookupsMap.get("geographicalarea") != null &&
                        lookupsMap.get("geographicalarea").get(tblVol.getGeographicalarea().toLowerCase()) != null ?
                        lookupsMap.get("geographicalarea").get(tblVol.getGeographicalarea().toLowerCase()).getId() :
                        null);
                }

                // -- Migrate the volunteer type of activities --
                // If the volunteer has type of activities related to it, migrate them.
                if (tblVolTypeOfActivities.get(tblVol.getVid()) != null) {
                    volunteerTypeOfActivities = new ArrayList<VolunteerTypeOfActivityLookups>();
                    VolunteerTypeOfActivityLookups volunteerTypeOfActivity = null;
                    for (TblVolTypeOfActivity activity : tblVolTypeOfActivities.get(tblVol.getVid())) {
                        volunteerTypeOfActivity = new VolunteerTypeOfActivityLookups();
                        volunteerTypeOfActivity.setVolunteerId(volunteers.getId());
                        volunteerTypeOfActivity.setLookupId(lookupsMap.get("typeofactivity") != null &&
                        lookupsMap.get("typeofactivity").get(activity.getTypeofactivity().toLowerCase()) != null ?
                        lookupsMap.get("typeofactivity").get(activity.getTypeofactivity().toLowerCase()).getId() :
                        null);

                        volunteerTypeOfActivities.add(volunteerTypeOfActivity);
                    }
                }

                // -- Migrate the volunteer areas of interest --
                // If the volunteer has areas of interest related to it, migrate them.
                if (tblVolAreasOfInterests.get(tblVol.getVid()) != null) {
                    volunteerCausesInts = new ArrayList<VolunteerCausesIntsLookups>();
                    VolunteerCausesIntsLookups volunteerCausesInt = null;
                    for (TblVolAreasOfInterest areasOfInterest : tblVolAreasOfInterests.get(tblVol.getVid())) {
                        volunteerCausesInt = new VolunteerCausesIntsLookups();
                        volunteerCausesInt.setVolunteerId(volunteers.getId());
                        volunteerCausesInt.setLookupId(lookupsMap.get("causeinterest") != null &&
                        lookupsMap.get("causeinterest").get(areasOfInterest.getAreasofinterest().toLowerCase()) != null ?
                        lookupsMap.get("causeinterest").get(areasOfInterest.getAreasofinterest().toLowerCase()).getId() :
                        null);

                        volunteerCausesInts.add(volunteerCausesInt);
                    }
                }

                // -- Migrate the volunteer specials --
                // If the volunteer has specials related to it, migrate them.
                if (tblVolSpecials.get(tblVol.getVid()) != null) {
                    volunteerTags = new ArrayList<VolunteerTagsLookups>();
                    VolunteerTagsLookups volunteerTag = null;
                    for (TblVolSpecial special : tblVolSpecials.get(tblVol.getVid())) {
                        volunteerTag = new VolunteerTagsLookups();
                        volunteerTag.setVolunteerId(volunteers.getId());
                        volunteerTag.setLookupId(lookupsMap.get("taggeddata") != null &&
                        lookupsMap.get("taggeddata").get(special.getSpecial().toLowerCase()) != null ?
                        lookupsMap.get("taggeddata").get(special.getSpecial().toLowerCase()).getId() :
                        null);

                        volunteerTags.add(volunteerTag);
                    }
                }

                volunteersWriter.write(volunteers.getRecord() + "\n");

                if (volunteerAddresses != null) volunteerAddressesWriter.write(volunteerAddresses.getRecord() + "\n");

                if (dayTimeContactInfo != null) volunteerContactInfoWriter.write(dayTimeContactInfo.getRecord() + "\n");
                if (eveningContactInfo != null) volunteerContactInfoWriter.write(eveningContactInfo.getRecord() + "\n");
                if (faxContactInfo != null) volunteerContactInfoWriter.write(faxContactInfo.getRecord() + "\n");
                if (mobileContactInfo != null) volunteerContactInfoWriter.write(mobileContactInfo.getRecord() + "\n");
                if (emailContactInfo != null) volunteerContactInfoWriter.write(emailContactInfo.getRecord() + "\n");

                if (dayTimeTelephone != null)
                    volunteerContactTelephonesWriter.write(dayTimeTelephone.getRecord() + "\n");
                if (eveningTelephone != null)
                    volunteerContactTelephonesWriter.write(eveningTelephone.getRecord() + "\n");
                if (faxTelephone != null) volunteerContactTelephonesWriter.write(faxTelephone.getRecord() + "\n");
                if (mobileTelephone != null) volunteerContactTelephonesWriter.write(mobileTelephone.getRecord() + "\n");
                if (email != null) volunteerContactEmailsWriter.write(email.getRecord() + "\n");

                if (volunteerGeoAreas != null)
                    volunteerGeoAreaLookupsWriter.write(volunteerGeoAreas.getRecord() + "\n");
                if (volunteerTypeOfActivities != null) {
                    for (VolunteerTypeOfActivityLookups activity : volunteerTypeOfActivities) {
                        volunteerTypeOfActivityLookupsWriter.write(activity.getRecord() + "\n");
                    }
                }
                if (volunteerCausesInts != null) {
                    for (VolunteerCausesIntsLookups causesInt : volunteerCausesInts) {
                        volunteerCausesIntsLookupsWriter.write(causesInt.getRecord() + "\n");
                    }
                }
                if (volunteerTags != null) {
                    for (VolunteerTagsLookups tag : volunteerTags) {
                        volunteerTagsLookupsWriter.write(tag.getRecord() + "\n");
                    }
                }

                if (addresses != null) addressesWriter.write(addresses.getRecord() + "\n");
            }

        } catch (IOException e) {
            System.out.println("Error while migrating volunteers. Error:" + e.getMessage());
        } finally {
            try {
                if (csvFileReader != null) {
                    csvFileReader.close();
                }
                if (volunteersWriter != null) {
                    volunteersWriter.flush();
                    volunteersWriter.close();
                }
                if (volunteerAddressesWriter != null) {
                    volunteerAddressesWriter.flush();
                    volunteerAddressesWriter.close();
                }
                if (volunteerContactInfoWriter != null) {
                    volunteerContactInfoWriter.flush();
                    volunteerContactInfoWriter.close();
                }
                if (volunteerContactTelephonesWriter != null) {
                    volunteerContactTelephonesWriter.flush();
                    volunteerContactTelephonesWriter.close();
                }
                if (volunteerContactEmailsWriter != null) {
                    volunteerContactEmailsWriter.flush();
                    volunteerContactEmailsWriter.close();
                }
                if (volunteerGeoAreaLookupsWriter != null) {
                    volunteerGeoAreaLookupsWriter.flush();
                    volunteerGeoAreaLookupsWriter.close();
                }
                if (volunteerTypeOfActivityLookupsWriter != null) {
                    volunteerTypeOfActivityLookupsWriter.flush();
                    volunteerTypeOfActivityLookupsWriter.close();
                }
                if (volunteerCausesIntsLookupsWriter != null) {
                    volunteerCausesIntsLookupsWriter.flush();
                    volunteerCausesIntsLookupsWriter.close();
                }
                if (volunteerTagsLookupsWriter != null) {
                    volunteerTagsLookupsWriter.flush();
                    volunteerTagsLookupsWriter.close();
                }
                if (addressesWriter != null) {
                    addressesWriter.flush();
                    addressesWriter.close();
                }

            } catch (IOException e) {
                System.out.println("Error closing volunteers streams. Error:" + e.getMessage());
            }

        }
    }

    private Long createCommitment(List<TblVolTime> tblVolTimes, String time) {
        Long commitment = 0L;
        if (tblVolTimes != null) { // Prevent null pointer exception.
            for (TblVolTime tblVolTime : tblVolTimes) {
                if (tblVolTime.getTimeslot().equals(time)) {
                    commitment = commitment + WEEK_MAP.get(tblVolTime.getDay().toLowerCase());
                }
            }
        }

        return commitment;
    }
}
