package org.youthnet.export.util;

import static org.junit.Assert.*;
import org.junit.Test;
import org.youthnet.export.domain.vb25.TblActivityLog;
import org.youthnet.export.domain.vb25.TblVol;

import java.util.List;

/**
 * User: karl
 * Date: 06-Jul-2010
 */
public class CSVUtilTest {

    @Test
    public void testCreateTblActivityLogList() throws Exception {
        List<TblActivityLog> tblActivityLogs = CSVUtil.createDomainList("src/test/resources/tblActivityLog.csv",
                TblActivityLog.class);

        assertEquals("first record id 1", 1L, tblActivityLogs.get(0).getLid().longValue());
        assertEquals("first subject \"Letter Sent to Emma Hardaker Jones\"",
                "Letter Sent to Emma Hardaker Jones", tblActivityLogs.get(0).getSubject());

        int lastIndex = tblActivityLogs.size() - 1;

        assertEquals("last record id 137111", 137111L, tblActivityLogs.get(lastIndex).getLid().longValue());
        assertEquals("last subject \"Z - Organisation Vol Opp DEACTIVATED - The Whitaker Centre (Equinox Care)\"",
                "Z - Organisation Vol Opp DEACTIVATED - The Whitaker Centre (Equinox Care)",
                tblActivityLogs.get(lastIndex).getSubject());


//        assertEquals("list size 114678", 114678, tblActivityLogs.size());

    }

    @Test
    public void testCreateTblVolList() throws Exception {
        List<TblVol> tblVol = CSVUtil.createDomainList("src/test/resources/tblVol.csv",
                TblVol.class);

//        assertEquals("list size 33349", 33349, tblVol.size());

    }
}
