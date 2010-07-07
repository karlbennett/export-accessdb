package org.youthnet.export.migration;

import org.youthnet.export.domain.vb25.*;
import org.youthnet.export.domain.vb3.Addresses;
import org.youthnet.export.domain.vb3.VolunteerAddresses;
import org.youthnet.export.domain.vb3.Volunteers;
import org.youthnet.export.io.CSVFileReader;
import org.youthnet.export.util.CSVUtil;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * User: VolunteersMigration
 * Date: 06-Jul-2010
 */
public class VolunteersMigration implements Migratable {
    @Override
    public void migrate(String csvDir, String outputDir) {
        CSVFileReader csvFileReader = null;
        BufferedWriter volunteersWriter = null;
        BufferedWriter volunteerAddressesWriter = null;

        BufferedWriter addressesWriter = null;

        try {
            csvFileReader = new CSVFileReader(new FileReader(csvDir + "tblVol.csv"));

            volunteersWriter = new BufferedWriter(new FileWriter(outputDir + "Volunteers.csv"));
            volunteerAddressesWriter = new BufferedWriter(new FileWriter(outputDir + "VolunteerAddress.csv"));

            addressesWriter = new BufferedWriter(new FileWriter(outputDir + "Address.csv"));

            Map<Long, List<TblVolTime>> tblVolTimes = CSVUtil.createVidMap(csvDir + "tblVolTime.csv", TblVolTime.class);
            Map<Long, List<TblVolAreasOfInterest>> tblVolAreasOfInterests =
                    CSVUtil.createVidMap(csvDir + "tblVolAreasOfInterest.csv", TblVolAreasOfInterest.class);
            Map<Long, List<TblVolTypeOfActivity>> tblVolTypeOfActivities =
                    CSVUtil.createVidMap(csvDir + "tblVolTypeOfActivity.csv", TblVolTypeOfActivity.class);
            Map<Long, List<TblVolSpecial>> tblVolSpecials =
                    CSVUtil.createVidMap(csvDir + "tblVolSpecial.csv", TblVolSpecial.class);

            TblVol tblVol = null;
            Volunteers volunteers = null;
            VolunteerAddresses volunteerAddresses = null;
            Addresses addresses = null;
            String record = "";
            while ((record = csvFileReader.readRecord()) != null) {
                tblVol = new TblVol(record);
                volunteers = new Volunteers();

                volunteers.setId(UUID.randomUUID());
                volunteers.setIsActive(true);
                volunteers.setFirstName(tblVol.getFirstname());
                volunteers.setLastName(tblVol.getLastname());

                volunteersWriter.write(volunteers.getRecord() + "\n");
            }

        } catch (IOException e) {
            System.out.println("Error while migrating volunteers. Error:" + e.getMessage());
        } finally {
            try {
                if (csvFileReader != null) csvFileReader.close();
                if (volunteersWriter != null) volunteersWriter.close();
                if (volunteerAddressesWriter != null) volunteerAddressesWriter.close();
                if (addressesWriter != null) addressesWriter.close();
            } catch (IOException e) {
                System.out.println("Error closing volunteers streams. Error:" + e.getMessage());
            }

        }
    }
}
