package org.youthnet.export.domain.vb3;

import static org.junit.Assert.*;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

/**
 * User: karl
 * Date: 04-Jul-2010
 */
public class ActivityLogsTest {
    private static final Timestamp ENDDATE = new Timestamp(new Date().getTime());
    private static final Boolean SHOWINCALENDER = true;
    private static final UUID ID = UUID.randomUUID();
    private static final Timestamp STARTDATE = new Timestamp(new Date().getTime());
    private static final Boolean DELETED = true;
    private static final Long VBASE2ID = 99999L;
    private static final String ENDTIME = "Test String.";
    private static final String STARTTIME = "Test String.";
    private static final Long VERSION = 99999L;
    private static final UUID MODIFIEDBY = UUID.randomUUID();
    private static final String SUBJECT = "Test String.";
    private static final Boolean ISALLDAYEVENT = true;
    private static final UUID PERSONHEREID = UUID.randomUUID();
    private static final Timestamp CREATED = new Timestamp(new Date().getTime());
    private static final UUID CREATEDBY = UUID.randomUUID();
    private static final UUID ACTIVITYTYPEID = UUID.randomUUID();
    private static final Timestamp MODIFIED = new Timestamp(new Date().getTime());
    private static final String NOTES = "Test String.";

    @Test
    public void testActivityLog() {
        ActivityLogs activityLogs = new ActivityLogs();

        activityLogs.setEndDate(ENDDATE);
        activityLogs.setShowInCalender(SHOWINCALENDER);
        activityLogs.setStartDate(STARTDATE);
        activityLogs.setId(ID);
        activityLogs.setDeleted(DELETED);
        activityLogs.setVbase2Id(VBASE2ID);
        activityLogs.setEndTime(ENDTIME);
        activityLogs.setStartTime(STARTTIME);
        activityLogs.setVersion(VERSION);
        activityLogs.setModifiedBy(MODIFIEDBY);
        activityLogs.setSubject(SUBJECT);
        activityLogs.setIsAllDayEvent(ISALLDAYEVENT);
        activityLogs.setPersonHereId(PERSONHEREID);
        activityLogs.setCreated(CREATED);
        activityLogs.setCreatedBy(CREATEDBY);
        activityLogs.setActivityTypeId(ACTIVITYTYPEID);
        activityLogs.setModified(MODIFIED);
        activityLogs.setNotes(NOTES);

        System.out.println(activityLogs.getRecord());

        String testRecord = "¬" + ENDDATE + "¬|"
        + "¬" + SHOWINCALENDER + "¬|"
        + "¬" + ID.toString().replace("-", "") + "¬|"
        + "¬" + STARTDATE + "¬|"
        + "¬" + DELETED + "¬|"
        + "¬" + VBASE2ID + "¬|"
        + "¬" + ENDTIME + "¬|"
        + "¬" + STARTTIME + "¬|"
        + "¬" + VERSION + "¬|"
        + "¬" + MODIFIEDBY.toString().replace("-", "") + "¬|"
        + "¬" + SUBJECT + "¬|"
        + "¬" + ISALLDAYEVENT + "¬|"
        + "¬" + PERSONHEREID.toString().replace("-", "") + "¬|"
        + "¬" + CREATED + "¬|"
        + "¬" + CREATEDBY.toString().replace("-", "") + "¬|"
        + "¬" + ACTIVITYTYPEID.toString().replace("-", "") + "¬|"
        + "¬" + MODIFIED + "¬|"
        + "¬" + NOTES + "¬|";

        assertEquals("record equal", testRecord, activityLogs.getRecord());
    }
}
