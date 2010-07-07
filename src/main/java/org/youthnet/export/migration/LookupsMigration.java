package org.youthnet.export.migration;

import org.youthnet.export.domain.vb25.*;
import org.youthnet.export.domain.vb3.Lookups;
import org.youthnet.export.io.CSVFileReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * User: LookupsMigration
 * Date: 06-Jul-2010
 */
public class LookupsMigration implements Migratable {

    @Override
    public void migrate(String csvDir, String outputDir) {
        CSVFileReader csvFileReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            csvFileReader = new CSVFileReader(new FileReader(csvDir + "tbluActivity.csv"));
            bufferedWriter = new BufferedWriter(new FileWriter(outputDir + "Lookups.csv"));

            Map<String, Byte> duplicateMap = new HashMap<String, Byte>();
            Lookups lookups = null;

            TbluActivity tbluActivity = null;
            String record = "";
            while ((record = csvFileReader.readRecord()) != null) {
                tbluActivity = new TbluActivity(record);
                lookups = new Lookups();

                lookups.setDiscriminator("ActivityType");
                lookups.setId(UUID.randomUUID());
                lookups.setIsActive(tbluActivity.getActive());
                lookups.setValue(tbluActivity.getActivity());
                lookups.setIsUserEditable(!tbluActivity.getKeep());
                lookups.setAppliesToOpportunities(true);
                lookups.setAppliesToOrganisations(true);
                lookups.setAppliesToVolunteers(true);
                lookups.setSortOrder(0L);

                // Make sure not to add duplicate lookups
                if (duplicateMap.get(lookups.getValue().toLowerCase()) == null) {
                    bufferedWriter.write(lookups.getRecord() + "\n");
                    duplicateMap.put(lookups.getValue().toLowerCase(), (byte) 1);
                }
            }

            duplicateMap = new HashMap<String, Byte>();
            TbluOppArrangements tbluOppArrangements = null;
            csvFileReader = new CSVFileReader(new FileReader(csvDir + "tbluOppArrangements.csv"));
            record = "";
            while ((record = csvFileReader.readRecord()) != null) {
                tbluOppArrangements = new TbluOppArrangements(record);
                lookups = new Lookups();

                lookups.setDiscriminator("Arrangement");
                lookups.setId(UUID.randomUUID());
                lookups.setIsActive(tbluOppArrangements.getActive());
                lookups.setValue(tbluOppArrangements.getOpparrangements());
                lookups.setIsUserEditable(true);
                lookups.setSortOrder(0L);

                if (duplicateMap.get(lookups.getValue().toLowerCase()) == null) {
                    bufferedWriter.write(lookups.getRecord() + "\n");
                    duplicateMap.put(lookups.getValue().toLowerCase(), (byte) 1);
                }
            }

            duplicateMap = new HashMap<String, Byte>();
            TbluDriving tbluDriving = null;
            csvFileReader = new CSVFileReader(new FileReader(csvDir + "tbluDriving.csv"));
            record = "";
            while ((record = csvFileReader.readRecord()) != null) {
                tbluDriving = new TbluDriving(record);
                lookups = new Lookups();

                lookups.setDiscriminator("Transport");
                lookups.setId(UUID.randomUUID());
                lookups.setIsActive(true);
                lookups.setValue(tbluDriving.getDriving());
                lookups.setIsUserEditable(false);
                lookups.setSortOrder(0L);

                if (duplicateMap.get(lookups.getValue().toLowerCase()) == null) {
                    bufferedWriter.write(lookups.getRecord() + "\n");
                    duplicateMap.put(lookups.getValue().toLowerCase(), (byte) 1);
                }
            }

            duplicateMap = new HashMap<String, Byte>();
            TbluGeographicalArea tbluGeographicalArea = null;
            csvFileReader = new CSVFileReader(new FileReader(csvDir + "tbluGeographicalArea.csv"));
            record = "";
            while ((record = csvFileReader.readRecord()) != null) {
                tbluGeographicalArea = new TbluGeographicalArea(record);
                lookups = new Lookups();

                lookups.setDiscriminator("GeographicalArea");
                lookups.setId(UUID.randomUUID());
                lookups.setIsActive(tbluGeographicalArea.getActive());
                lookups.setValue(tbluGeographicalArea.getGeographicalarea());
                lookups.setIsUserEditable(true);
                lookups.setSortOrder(0L);

                if (duplicateMap.get(lookups.getValue().toLowerCase()) == null) {
                    bufferedWriter.write(lookups.getRecord() + "\n");
                    duplicateMap.put(lookups.getValue().toLowerCase(), (byte) 1);
                }
            }

            duplicateMap = new HashMap<String, Byte>();
            TbluHowHeard tbluHowHeard = null;
            csvFileReader = new CSVFileReader(new FileReader(csvDir + "tbluHowHeard.csv"));
            record = "";
            while ((record = csvFileReader.readRecord()) != null) {
                tbluHowHeard = new TbluHowHeard(record);
                lookups = new Lookups();

                lookups.setDiscriminator("HowHeard");
                lookups.setId(UUID.randomUUID());
                lookups.setIsActive(tbluHowHeard.getActive());
                lookups.setValue(tbluHowHeard.getHowheard());
                lookups.setIsUserEditable(true);
                lookups.setSortOrder(0L);

                if (duplicateMap.get(lookups.getValue().toLowerCase()) == null) {
                    bufferedWriter.write(lookups.getRecord() + "\n");
                    duplicateMap.put(lookups.getValue().toLowerCase(), (byte) 1);
                }
            }

            duplicateMap = new HashMap<String, Byte>();
            TbluNationality tbluNationality = null;
            csvFileReader = new CSVFileReader(new FileReader(csvDir + "tbluNationality.csv"));
            record = "";
            while ((record = csvFileReader.readRecord()) != null) {
                tbluNationality = new TbluNationality(record);
                lookups = new Lookups();

                lookups.setDiscriminator("Nationality");
                lookups.setId(UUID.randomUUID());
                lookups.setIsActive(tbluNationality.getActive());
                lookups.setValue(tbluNationality.getNationality());
                lookups.setIsUserEditable(true);
                lookups.setSortOrder(0L);

                if (duplicateMap.get(lookups.getValue().toLowerCase()) == null) {
                    bufferedWriter.write(lookups.getRecord() + "\n");
                    duplicateMap.put(lookups.getValue().toLowerCase(), (byte) 1);
                }
            }

            duplicateMap = new HashMap<String, Byte>();
            TbluReligion tbluReligion = null;
            csvFileReader = new CSVFileReader(new FileReader(csvDir + "tbluReligion.csv"));
            record = "";
            while ((record = csvFileReader.readRecord()) != null) {
                tbluReligion = new TbluReligion(record);
                lookups = new Lookups();

                lookups.setDiscriminator("Religion");
                lookups.setId(UUID.randomUUID());
                lookups.setIsActive(true);
                lookups.setValue(tbluReligion.getReligion());
                lookups.setIsUserEditable(true);
                lookups.setSortOrder(0L);

                if (duplicateMap.get(lookups.getValue().toLowerCase()) == null) {
                    bufferedWriter.write(lookups.getRecord() + "\n");
                    duplicateMap.put(lookups.getValue().toLowerCase(), (byte) 1);
                }
            }

            duplicateMap = new HashMap<String, Byte>();
            TbluSpecial tbluSpecial = null;
            csvFileReader = new CSVFileReader(new FileReader(csvDir + "tbluSpecial.csv"));
            record = "";
            while ((record = csvFileReader.readRecord()) != null) {
                tbluSpecial = new TbluSpecial(record);
                lookups = new Lookups();

                lookups.setDiscriminator("TaggedData");
                lookups.setId(UUID.randomUUID());
                lookups.setIsActive(true);
                lookups.setValue(tbluSpecial.getSpecial());
                lookups.setIsUserEditable(true);
                lookups.setSortOrder(0L);

                if (duplicateMap.get(lookups.getValue().toLowerCase()) == null) {
                    bufferedWriter.write(lookups.getRecord() + "\n");
                    duplicateMap.put(lookups.getValue().toLowerCase(), (byte) 1);
                }
            }

        } catch (IOException e) {
            System.out.println("Error while migrating lookups. Error:" + e.getMessage());
        } finally {
            try {
                if (csvFileReader != null) csvFileReader.close();
                if (bufferedWriter != null) bufferedWriter.close();
            } catch (IOException e) {
                System.out.println("Error closing streams. Error:" + e.getMessage());
            }

        }
    }
}
