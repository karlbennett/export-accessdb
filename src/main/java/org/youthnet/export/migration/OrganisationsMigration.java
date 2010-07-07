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
            OrganisationContacts organisationContacts = null;
            Addresses addresses = null;
            Contacts contacts = null;
            String record = "";
            while ((record = csvFileReader.readRecord()) != null) {
                tblOrg = new TblOrg(record);
                organisations = new Organisations();
                organisationAddresses = new OrganisationAddresses();
                organisationContacts = new OrganisationContacts();
                addresses = new Addresses();
                contacts = new Contacts();

                organisations.setId(UUID.randomUUID());
                organisations.setIsActive(true);
                organisations.setDescription(tblOrg.getActivities());
                organisations.setHowHeardDetails(null);
                organisations.setMissionStatement(tblOrg.getMission());
                organisations.setName(tblOrg.getName());
                organisations.setOpeningHours(null);
                organisations.setVbase2Id(tblOrg.getOrgid());

                organisationsWriter.write(organisations.getRecord() + "\n");
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
                System.out.println("Error closing streams. Error:" + e.getMessage());
            }

        }

    }
}
