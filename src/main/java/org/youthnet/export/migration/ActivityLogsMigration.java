package org.youthnet.export.migration;

import org.youthnet.export.domain.vb25.*;
import org.youthnet.export.domain.vb3.ActivityLogs;
import org.youthnet.export.io.CSVFileReader;
import org.youthnet.export.util.CSVUtil;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * User: ActivityLogsMigration
 * Date: 07-Jul-2010
 */
public class ActivityLogsMigration implements Migratable {

    @Override
    public void migrate(String csvDir, String outputDir) {
        CSVFileReader csvFileReader = null;
        BufferedWriter activityLogsWriter = null;

        try {
            csvFileReader = new CSVFileReader(new FileReader(csvDir + "tblActivityLog.csv"));

            activityLogsWriter = new BufferedWriter(new FileWriter(outputDir + "ActivityLogs.csv"));

            List<TblVol> tblVols = CSVUtil.createDomainList(csvDir + "tblVol.csv", TblVol.class);
            List<TblOpp> tblOpps =
                    CSVUtil.createDomainList(csvDir + "tblOpp.csv", TblOpp.class);
            List<TblOrg> tblOrgs = CSVUtil.createDomainList(csvDir + "tblOrg.csv", TblOrg.class);
            List<TbluTypeOfActivity> tbluTypeOfActivities =
                    CSVUtil.createDomainList(csvDir + "tbluTypeOfActivity.csv", TbluTypeOfActivity.class);

            TblActivityLog tblActivityLog = null;
            ActivityLogs activityLogs = null;
            String record = "";
            while ((record = csvFileReader.readRecord()) != null) {
                tblActivityLog = new TblActivityLog(record);
                activityLogs = new ActivityLogs();

                activityLogs.setId(UUID.randomUUID());
                activityLogs.setEndDate(tblActivityLog.getEndtime());
                activityLogs.setIsAllDayEvent(tblActivityLog.getAlldayevent());
                activityLogs.setNotes(tblActivityLog.getNotes());

                activityLogs.setShowInCalender(tblActivityLog.getShowincalendar());
                activityLogs.setStartDate(tblActivityLog.getStarttime());
                activityLogs.setSubject(tblActivityLog.getSubject());
                activityLogs.setVbase2Id(tblActivityLog.getLid());

                activityLogsWriter.write(activityLogs.getRecord() + "\n");
            }

        } catch (IOException e) {
            System.out.println("Error while migrating activity logs. Error:" + e.getMessage());
        } finally {
            try {
                if (csvFileReader != null) csvFileReader.close();
                if (activityLogsWriter != null) activityLogsWriter.close();
            } catch (IOException e) {
                System.out.println("Error closing activity logs streams. Error:" + e.getMessage());
            }

        }
    }
}
