package org.youthnet.export.migration;

import org.youthnet.export.domain.vb25.TblOrg;
import org.youthnet.export.domain.vb3.*;
import org.youthnet.export.io.CSVFileReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

/**
 * User: OrganisationsMigration
 * Date: 06-Jul-2010
 */
public class OrganisationsMigration implements Migratable {

    @Override
    public void migrate(String csvDir, String outputDir) {
        CSVFileReader csvFileReader = null;
        BufferedWriter organisationsWriter = null;
        BufferedWriter organisationAddressWriter = null;
        BufferedWriter organisationContactWriter = null;

        BufferedWriter addressesWriter = null;
        BufferedWriter contactsWriter = null;


        try {
            csvFileReader = new CSVFileReader(new FileReader(csvDir + "tblOrg.csv"));
            organisationsWriter = new BufferedWriter(new FileWriter(outputDir + "Organisations.csv"));
            organisationAddressWriter = new BufferedWriter(new FileWriter(outputDir + "OrganisationAddress.csv"));
            organisationContactWriter = new BufferedWriter(new FileWriter(outputDir + "OrganisationContact.csv"));

            addressesWriter = new BufferedWriter(new FileWriter(outputDir + "Addresses.csv"));
            contactsWriter = new BufferedWriter(new FileWriter(outputDir + "Contacts.csv"));

            TblOrg tblOrg = null;
            Organisations organisations = null;
            OrganisationAddresses organisationAddresses = null;
            OrganisationAddresses contactOrganisationAddresses = null;
            OrganisationContacts organisationContacts = null;
            OrganisationContacts contactOrganisationContacts = null;
            Addresses addresses = null;
            Addresses contactAddresses = null;
            Contacts contacts = null;
            String record = "";
            while ((record = csvFileReader.readRecord()) != null) {
                tblOrg = new TblOrg(record);
                organisations = new Organisations();
                organisationContacts = new OrganisationContacts();
                contacts = new Contacts();

                // -- Migrate the organisations root  data --
                organisations.setId(UUID.randomUUID()); // Create an ID for the new organisation.
                organisations.setIsActive(true); // Make it active.
                organisations.setDescription(tblOrg.getActivities()); // Migrate field.
                organisations.setHowHeardDetails(null); // There is no migration mapping for this.
                organisations.setMissionStatement(tblOrg.getMission()); // Migrate field.
                organisations.setName(tblOrg.getName()); // Migrate field.
                organisations.setOpeningHours(null); // There is no migration mapping for this.
                organisations.setVbase2Id(tblOrg.getOrgid()); // Migrate field.

                // -- Migrate the organisations generic address data --
                // If the organisation has an address, migrate it.
                if (tblOrg.getAddress1() != null && !tblOrg.getAddress1().equals("")) {
                    addresses = new Addresses();
                    organisationAddresses = new OrganisationAddresses();

                    addresses.setId(UUID.randomUUID());
                    addresses.setAddress1(tblOrg.getAddress1()); // Migrate field.
                    // If the vb2.5 address one does not match the vb 2.5 address two then add it to the new vb3 address.
                    if (tblOrg.getAddress2() != null // Stop any null pointer exceptions.
                            && !tblOrg.getAddress1().toLowerCase().equals(tblOrg.getAddress2().toLowerCase())) {
                        addresses.setAddress2(tblOrg.getAddress2());
                    }
                    addresses.setAddress3(null); // There is no migration mapping for this.
                    addresses.setCountryId(null); // TODO: Set the organisation address country lookup
                    addresses.setCountyId(null); // TODO: Set the organisation address county lookup
                    addresses.setPostCode(tblOrg.getPostcode()); // Migrate field.
                    addresses.setTown(tblOrg.getTown()); // Migrate field.
                    addresses.setDirections(tblOrg.getDirections()); // Migrate field.
                    addresses.setVbase2Id(organisations.getVbase2Id()); // Migrate field.


                    // -- Migrate the organisation specific address data --
                    // Associate this new organisation address to the new organisation.
                    organisationAddresses.setOrgAddConInfoId(organisations.getId());
                    // Associate this new organisation address to the new address.
                    organisationAddresses.setAddressId(addresses.getId());
                    organisationAddresses.setOrganisationName(organisations.getName()); // Create some denormalised data...
                    organisationAddresses.setUseCustomOrganisationName(false);
                    organisationAddresses.setEmail(tblOrg.getEmail()); // Migrate field.
                    organisationAddresses.setFax(tblOrg.getFax()); // Migrate field.
                    organisationAddresses.setTelephone(tblOrg.getTel1()); // Migrate field.
                    organisationAddresses.setWebsite(tblOrg.getWww()); // Migrate field.
                    organisationAddresses.setDirections(addresses.getDirections()); // Create some denormalised data...
                    organisationAddresses.setFriendlyName("Main"); // Set this to be the main address.
                    organisationAddresses.setIsDefaultAddress(true); // Set this to be the default address.
                }


                // -- Migrate the organisation generic contact data --
                contacts.setId(UUID.randomUUID());
                contacts.setDepartment(null); // There is no migration mapping for this.

                // Check to see if the contact can use the addresses email address.
                // This is the case when the contacts email is empty or when the contact and address emails are equal.
                contacts.setUsingAddressEmail(
                        tblOrg.getContactemail() == null || tblOrg.getContactemail().equals("") ||
                                tblOrg.getContactemail().toLowerCase().equals(tblOrg.getEmail().toLowerCase()));
                // Otherwise migrate in the new contact email.
                if (!contacts.getUsingAddressEmail()) contacts.setEmail(tblOrg.getContactemail());

                // Check to see if the contact can use the addresses telephone number.
                // This is the case when the contacts telephone number is empty or when the contact and address telephone numbers are
                // equal.
                contacts.setUsingAddressTel(
                        tblOrg.getContacttel1() == null || tblOrg.getContacttel1().equals("") ||
                                tblOrg.getContacttel1().toLowerCase().equals(tblOrg.getTel1().toLowerCase()));
                // Otherwise migrate in the new telephone number.
                if (!contacts.getUsingAddressTel()) contacts.setTel(tblOrg.getContacttel1());

                contacts.setFirstName(tblOrg.getFirstname());
                contacts.setSurname(tblOrg.getLastname());
                contacts.setTitleId(null); // TODO: Set the organisation contact title lookup
                contacts.setIsActive(true);
                contacts.setJobTitle(tblOrg.getJobtitle());
                contacts.setMobile(null);
                contacts.setNotes(null);

                // If the contact has supplied there
                if (tblOrg.getFirstname() != null) contacts.setPreferredName(tblOrg.getFirstname());
                else if (tblOrg.getLastname() != null)
                    contacts.setPreferredName(tblOrg.getTitle() + tblOrg.getLastname());
                else contacts.setPreferredName(tblOrg.getTitle());

                contacts.setUseAsMainContact(true);  // Only one in V-Base 2.5
                // If the contact fax is empty use the one from the related address.
                contacts.setUsingAddressFax(tblOrg.getContactfax() == null || tblOrg.getContactfax().equals(""));

                // -- Relate the organisation, contact, and address ---
                organisationContacts.setContactId(contacts.getId()); // Wrap the contact with an organisation relation.
                organisationContacts.setOrganisationId(organisations.getId()); // Relate the organisation to the contact.
                // If the address exists relate it to the contact.
                if (addresses != null) organisationContacts.setOrganisationAddressId(addresses.getId());


                // -- Migrate the organisation contacts address --
                // If the organisation has a contact address that is different from the organisation address migrate it.
                if (tblOrg.getContactaddress1() != null && !tblOrg.getContactaddress1().equals("") &&
                        tblOrg.getContactaddress1().toLowerCase().equals(tblOrg.getAddress1().toLowerCase())) {
                    contactAddresses = new Addresses();
                    contactOrganisationAddresses = new OrganisationAddresses();
                    contactOrganisationContacts = new OrganisationContacts();

                    contactAddresses.setId(UUID.randomUUID());
                    contactAddresses.setAddress1(tblOrg.getContactaddress1()); // Migrate field.
                    // If the vb2.5 contact address one does not match the vb 2.5 contact address two then add it to the new vb3 address.
                    if (tblOrg.getContactaddress2() != null // Stop any null pointer exceptions.
                            && !tblOrg.getContactaddress1().toLowerCase().equals(tblOrg.getContactaddress2().toLowerCase())) {
                        contactAddresses.setAddress2(tblOrg.getContactaddress2());
                    }
                    contactAddresses.setAddress3(null); // There is no migration mapping for this.
                    contactAddresses.setCountryId(null); // TODO: Set the organisation contact address country lookup
                    contactAddresses.setCountyId(null); // TODO: Set the organisation contact address county lookup
                    contactAddresses.setPostCode(tblOrg.getContactpostcode()); // Migrate field.
                    contactAddresses.setTown(tblOrg.getContacttown()); // Migrate field.
                    contactAddresses.setVbase2Id(organisations.getVbase2Id()); // Migrate field.

                    // -- Migrate the organisation specific address data --
                    // Associate this new organisation contact address to the new organisation.
                    contactOrganisationAddresses.setOrgAddConInfoId(organisations.getId());
                    // Associate this new organisation contact address to the new contact address.
                    contactOrganisationAddresses.setAddressId(contactAddresses.getId());
                    contactOrganisationAddresses.setOrganisationName(organisations.getName()); // Create some denormalised data...
                    contactOrganisationAddresses.setUseCustomOrganisationName(false);
                    // If there is no address or if the organisation and contact website urls are different migrate the contact website url.
                    if (addresses == null || !tblOrg.getWww().toLowerCase().equals(tblOrg.getContactwww().toLowerCase())) {
                        contactOrganisationAddresses.setWebsite(tblOrg.getContactwww());
                    }
                    organisationAddresses.setFriendlyName("Contact Address 1"); // Set this to be a contact address.
                    // If an organisation address does not already exist set this to be the default address.
                    organisationAddresses.setIsDefaultAddress(addresses == null);

                    // -- Relate the organisation, contact, and address ---
                    // Wrap the previous contact with another organisation relation.
                    contactOrganisationContacts.setContactId(contacts.getId());
                    // Relate the organisation to the contact.
                    contactOrganisationContacts.setOrganisationId(organisations.getId());
                    // Relate the contact address to the contact.
                    contactOrganisationContacts.setOrganisationAddressId(addresses.getId());
                }


                // -- Write the new records to their files --
                organisationsWriter.write(organisations.getRecord() + "\n");

                addressesWriter.write(addresses.getRecord() + "\n");
                addressesWriter.write(contactAddresses.getRecord() + "\n");

                organisationAddressWriter.write(organisationAddresses.getRecord() + "\n");
                organisationAddressWriter.write(contactOrganisationAddresses.getRecord() + "\n");

                contactsWriter.write(contacts.getRecord() + "\n");

                organisationContactWriter.write(organisationContacts.getRecord() + "\n");
                organisationContactWriter.write(contactOrganisationContacts.getRecord() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error while migrating organisations. Error:" + e.getMessage());
        } finally {
            try {
                if (csvFileReader != null) csvFileReader.close();
                if (organisationsWriter != null) organisationsWriter.close();
                if (organisationAddressWriter != null) organisationAddressWriter.close();
                if (organisationContactWriter != null) organisationContactWriter.close();
                if (addressesWriter != null) addressesWriter.close();
                if (contactsWriter != null) contactsWriter.close();
            } catch (IOException e) {
                System.out.println("Error closing organisations streams. Error:" + e.getMessage());
            }

        }

    }
}
