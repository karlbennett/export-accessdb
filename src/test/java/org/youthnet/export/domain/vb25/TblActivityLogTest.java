package org.youthnet.export.domain.vb25;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * User: karl
 * Date: 03-Jul-2010
 */
public class TblActivityLogTest {

    private static final Long LID = 1L;
    private static final String ACTIVITY = "A - V-  Residential Volunteering Opportunities in the UK";
    private static final String TYPE = "1. Vol";
    private static final Long VID = 100L;
    private static final Long OID = 101L;
    private static final Long ORGID = 102L;
    private static final Long LINKEDOID = 103L;
    private static final String SUBJECT = "Letter Sent to Emma Hardaker Jones";
    private static final String OWNER = "Some One";
    private static final Timestamp STARTTIME = new Timestamp(new Date().getTime());
    private static final Timestamp ENDTIME = new Timestamp(new Date().getTime());
    private static final Boolean ALARM = false;
    private static final Timestamp ALARMSTARTTIME = new Timestamp(new Date().getTime());
    private static final String ALARMPERIOD = "Around then";
    private static final Boolean ALLDAYEVENT = true;
    private static final String CORRESPONDENCE = "Timebank Letter";
    private static final Timestamp DATECORRSENT = new Timestamp(new Date().getTime());
    private static final Long LINKEDLID = 104L;
    private static final Long BACKLID = 105L;
    private static final Boolean SHOWINCALENDAR = false;
    private static final Short ESTTOTALHOURS = 2;
    private static final String NOTES = "This record was a correspondence in version 1 of V-Base.";
    private static final Timestamp DATEFIRSTENTERED = new Timestamp(new Date().getTime());
    private static final Timestamp DATELASTUPDATED = new Timestamp(new Date().getTime());
    private static final String LASTUPDATEDBY = "Eileen";


    @Test
    public void createTblActivityLogTest() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        String rowString = "¬" + LID + "¬|"
                + "¬" + ACTIVITY + "¬|"
                + "¬" + TYPE + "¬|"
                + "¬" + VID + "¬|"
                + "¬" + OID + "¬|"
                + "¬" + ORGID + "¬|"
                + "¬" + LINKEDOID + "¬|"
                + "¬" + SUBJECT + "¬|"
                + "¬" + OWNER + "¬|"
                + "¬" + simpleDateFormat.format(STARTTIME) + "¬|"
                + "¬" + simpleDateFormat.format(ENDTIME) + "¬|"
                + "¬" + (ALARM ? 1 : 0) + "¬|"
                + "¬" + simpleDateFormat.format(ALARMSTARTTIME) + "¬|"
                + "¬" + ALARMPERIOD + "¬|"
                + "¬" + (ALLDAYEVENT ? 1 : 0) + "¬|"
                + "¬" + CORRESPONDENCE + "¬|"
                + "¬" + simpleDateFormat.format(DATECORRSENT) + "¬|"
                + "¬" + LINKEDLID + "¬|"
                + "¬" + BACKLID + "¬|"
                + "¬" + (SHOWINCALENDAR ? 1 : 0) + "¬|"
                + "¬" + ESTTOTALHOURS + "¬|"
                + "¬" + NOTES + "¬|"
                + "¬" + simpleDateFormat.format(DATEFIRSTENTERED) + "¬|"
                + "¬" + simpleDateFormat.format(DATELASTUPDATED) + "¬|"
                + "¬" + LASTUPDATEDBY + "¬|";

        TblActivityLog tblActivityLog = new TblActivityLog(rowString);

        assertEquals("lid equal", LID, tblActivityLog.getLid());
        assertEquals("activity equal", ACTIVITY, tblActivityLog.getActivity());
        assertEquals("type equal", TYPE, tblActivityLog.getType());
        assertEquals("vid equal", VID, tblActivityLog.getVid());
        assertEquals("oid equal", OID, tblActivityLog.getOid());
        assertEquals("orgid equal", ORGID, tblActivityLog.getOrgid());
        assertEquals("linkedoid equal", LINKEDOID, tblActivityLog.getLinkedoid());
        assertEquals("subject equal", SUBJECT, tblActivityLog.getSubject());
        assertEquals("owner equal", OWNER, tblActivityLog.getOwner());
        assertEquals("starttime equal", STARTTIME, tblActivityLog.getStarttime());
        assertEquals("endtime equal", ENDTIME, tblActivityLog.getEndtime());
        assertEquals("alarm equal", ALARM, tblActivityLog.getAlarm());
        assertEquals("alrmstarttime equal", ALARMSTARTTIME, tblActivityLog.getAlarmstarttime());
        assertEquals("alarmperiod equal", ALARMPERIOD, tblActivityLog.getAlarmperiod());
        assertEquals("alldayevent equal", ALLDAYEVENT, tblActivityLog.getAlldayevent());
        assertEquals("correspondence equal", CORRESPONDENCE, tblActivityLog.getCorrespondence());
        assertEquals("datecorrsent equal", DATECORRSENT, tblActivityLog.getDatecorrsent());
        assertEquals("linkedid equal", LINKEDLID, tblActivityLog.getLinkedlid());
        assertEquals("backlid equal", BACKLID, tblActivityLog.getBacklid());
        assertEquals("showincalendar equal", SHOWINCALENDAR, tblActivityLog.getShowincalendar());
        assertEquals("esttotalhours equal", ESTTOTALHOURS, tblActivityLog.getEsttotalhours());
        assertEquals("notes equal", NOTES, tblActivityLog.getNotes());
        assertEquals("datefirstentered equal", DATEFIRSTENTERED, tblActivityLog.getDatefirstentered());
        assertEquals("datelastupdated equal", DATELASTUPDATED, tblActivityLog.getDatelastupdated());
        assertEquals("lastupdatedby equal", LASTUPDATEDBY, tblActivityLog.getLastupdatedby());
    }
}
