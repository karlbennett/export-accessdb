package org.youthnet.export.migration;

import org.youthnet.export.domain.vb25.*;
import org.youthnet.export.domain.vb3.Lookups;
import org.youthnet.export.io.CSVFileReader;

import java.io.*;
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
        BufferedReader bufferedReader = null;

        CSVFileReader csvFileReader = null;

        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(
                    getClass().getClassLoader().getResourceAsStream("lookup.sql")));
            csvFileReader = new CSVFileReader(new FileReader(csvDir + "tbluActivity.csv"));

            bufferedWriter = new BufferedWriter(new FileWriter(outputDir + "Lookups.csv"));

            String line = "";
            Lookups lookups = null;
            Map<String, Byte> duplicateMap = new HashMap<String, Byte>();
            String[] lineArray = null;
            StringBuffer uuidStringBuffer = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("INSERT INTO Lookups")) {
                    if (line.contains("AppliesToVolunteers, AppliesToOrganisations, AppliesToOpportunities")) {
                        line = line.replace("(", "").replace("'", "").replace(")", "");
                        lineArray = line.split(",");
                        lookups = new Lookups();
                        lookups.setDeleted(lineArray[11].split(" ")[2].trim().equals("1"));
                        lookups.setVersion(Long.valueOf(lineArray[12].trim()));
                        lookups.setDiscriminator(lineArray[13].trim());
                        lookups.setSortOrder(Long.valueOf(lineArray[14].trim()));
                        lookups.setIsActive(lineArray[15].trim().equals("1"));
                        lookups.setIsUserEditable(lineArray[16].trim().equals("1"));
                        uuidStringBuffer.setLength(0);
                        uuidStringBuffer.append(lineArray[17].trim().replace("hextoraw", ""));
                        uuidStringBuffer.insert(8, '-');
                        uuidStringBuffer.insert(13, '-');
                        uuidStringBuffer.insert(18, '-');
                        uuidStringBuffer.insert(23, '-');
                        lookups.setId(UUID.fromString(uuidStringBuffer.toString()));
                        lookups.setValue(lineArray[18].trim());
                        lookups.setAppliesToVolunteers(lineArray[19].trim().equals("1"));
                        lookups.setAppliesToOrganisations(lineArray[20].trim().equals("1"));
                        lookups.setAppliesToOpportunities(lineArray[21].trim().equals("1"));
//                        uuidStringBuffer.setLength(0);
//                        uuidStringBuffer.append(lineArray[22].trim().replace("hextoraw", ""));
//                        uuidStringBuffer.insert(8, '-');
//                        uuidStringBuffer.insert(13, '-');
//                        uuidStringBuffer.insert(18, '-');
//                        uuidStringBuffer.insert(23, '-');
//                        lookups.setOwnerId(UUID.fromString(uuidStringBuffer.toString()));

                    } else {
                        line = line.replace("(", "").replace("'", "").replace(")", "");
                        lineArray = line.split(",");
                        lookups = new Lookups();
                        lookups.setDeleted(lineArray[7].split(" ")[2].trim().equals("1"));
                        lookups.setVersion(Long.valueOf(lineArray[8].trim()));
                        lookups.setDiscriminator(lineArray[9].trim());
                        lookups.setSortOrder(Long.valueOf(lineArray[10].trim()));
                        lookups.setIsActive(lineArray[11].trim().equals("1"));
                        lookups.setIsUserEditable(lineArray[12].trim().equals("1"));
                        uuidStringBuffer.setLength(0);
                        uuidStringBuffer.append(lineArray[13].trim().replace("hextoraw", ""));
                        uuidStringBuffer.insert(8, '-');
                        uuidStringBuffer.insert(13, '-');
                        uuidStringBuffer.insert(18, '-');
                        uuidStringBuffer.insert(23, '-');
                        lookups.setId(UUID.fromString(uuidStringBuffer.toString()));
                        lookups.setValue(lineArray[14]);
                    }
                    bufferedWriter.write(lookups.getRecord() + "\n");
                    duplicateMap.put(lookups.getValue().toLowerCase(), (byte) 1);
                }
            }

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
            csvFileReader.close();
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
            csvFileReader.close();
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
            csvFileReader.close();
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
            csvFileReader.close();
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
            csvFileReader.close();
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
            csvFileReader.close();
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
            csvFileReader.close();
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
                if (bufferedReader != null) bufferedReader.close();
                if (csvFileReader != null) csvFileReader.close();
                if (bufferedWriter != null) {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing lookups streams. Error:" + e.getMessage());
            }

        }
    }
}
