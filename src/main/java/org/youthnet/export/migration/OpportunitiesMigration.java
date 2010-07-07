package org.youthnet.export.migration;

import org.youthnet.export.domain.vb25.*;
import org.youthnet.export.domain.vb3.Opportunities;
import org.youthnet.export.io.CSVFileReader;
import org.youthnet.export.util.CSVUtil;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * User: OpportunitiesMigration
 * Date: 06-Jul-2010
 */
public class OpportunitiesMigration implements Migratable {
    @Override
    public void migrate(String csvDir, String outputDir) {
        CSVFileReader csvFileReader = null;
        BufferedWriter opportunitiesWriter = null;

        try {
            csvFileReader = new CSVFileReader(new FileReader(csvDir + "tblOpp.csv"));
            opportunitiesWriter = new BufferedWriter(new FileWriter(outputDir + "Opprotunities.csv"));

            List<TblOppTime> tblOppTimes = CSVUtil.createDomainList(csvDir + "tblOppTime.csv", TblOppTime.class);
            List<TblOppSpecial> tblOppSpecials =
                    CSVUtil.createDomainList(csvDir + "tblOppSpecial.csv", TblOppSpecial.class);
            List<TblOppTypeOfActivity> tblOppTypeOfActivities =
                    CSVUtil.createDomainList(csvDir + "tblOppTypeOfActivity.csv", TblOppTypeOfActivity.class);
            List<TblOppAreasOfInterest> tblOppAreasOfInterests =
                    CSVUtil.createDomainList(csvDir + "tblOppAreasOfInterest.csv", TblOppAreasOfInterest.class);
            List<TblOppArrangements> tblOppArrangementses =
                    CSVUtil.createDomainList(csvDir + "tblOppArrangements.csv", TblOppArrangements.class);
            List<TblOppRecruitmentMethod> tblOppRecruitmentMethods =
                    CSVUtil.createDomainList(csvDir + "tblOppRecruitmentMethod.csv", TblOppRecruitmentMethod.class);
            List<UsysRegistration> usysRegistrations =
                    CSVUtil.createDomainList(csvDir + "UsysRegistration.csv", UsysRegistration.class);

            TblOpp tblOpp = null;
            Opportunities opportunities = null;
            String record = "";
            while ((record = csvFileReader.readRecord()) != null) {
                tblOpp = new TblOpp(record);
                opportunities = new Opportunities();

                opportunities.setId(UUID.randomUUID());
                opportunities.setVbase2Id(tblOpp.getOid());
                opportunities.setTitle(tblOpp.getTitle());
                opportunities.setOwnId(tblOpp.getOppenteredid());

                opportunitiesWriter.write(opportunities.getRecord() + "\n");
            }

        } catch (IOException e) {
            System.out.println("Error while migrating volunteers. Error:" + e.getMessage());
        } finally {
            try {
                if (csvFileReader != null) csvFileReader.close();
                if (opportunitiesWriter != null) opportunitiesWriter.close();
            } catch (IOException e) {
                System.out.println("Error closing streams. Error:" + e.getMessage());
            }

        }
    }
}
