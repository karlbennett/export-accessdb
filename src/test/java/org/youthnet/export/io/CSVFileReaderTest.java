package org.youthnet.export.io;

import org.junit.Test;

import java.io.FileReader;

import static org.junit.Assert.assertEquals;

/**
 * User: karl
 * Date: 05-Jul-2010
 */
public class CSVFileReaderTest {
    @Test
    public void testReadRecord() throws Exception {
        CSVFileReader csvFileReader = new CSVFileReader(new FileReader("src/test/resources/tblActivityLog.csv"));

        assertEquals("record n equal", "¬1¬|¬A - V-  Residential Volunteering Opportunities in the UK¬|¬1. Vol¬|¬¬|¬¬|¬¬|¬¬|¬Letter Sent to Emma Hardaker Jones¬|¬¬|¬2001-04-26 00:00:00.0¬|¬2001-04-26 00:00:00.0¬|¬0¬|¬¬|¬¬|¬1¬|¬Timebank Letter¬|¬2001-04-26 00:00:00.0¬|¬¬|¬¬|¬0¬|¬0¬|¬This record was a correspondence in version 1 of V-Base.¬|¬2001-08-28 00:00:00.0¬|¬2010-03-31 16:46:07.0¬|¬Eileen¬|", csvFileReader.readRecord());
        assertEquals("record n equal", "¬63¬|¬A - V - Postal Matching¬|¬1. Vol¬|¬761¬|¬¬|¬¬|¬¬|¬Letter Sent to Laura Hamilton¬|¬¬|¬2001-06-22 00:00:00.0¬|¬2001-06-22 00:00:00.0¬|¬0¬|¬¬|¬¬|¬1¬|¬Opportunities Letter¬|¬2001-06-22 00:00:00.0¬|¬¬|¬¬|¬0¬|¬0¬|¬This record was a correspondence in version 1 of V-Base.¬|¬2001-08-28 00:00:00.0¬|¬2002-01-08 12:50:44.0¬|¬Sarah¬|", csvFileReader.readRecord());
        assertEquals("record n equal", "¬64¬|¬A - V - Appointment¬|¬1. Vol¬|¬764¬|¬¬|¬¬|¬¬|¬Letter Sent to Ilka Walkley¬|¬¬|¬2001-06-22 00:00:00.0¬|¬2001-06-22 00:00:00.0¬|¬0¬|¬¬|¬¬|¬1¬|¬Appointment Letter¬|¬2001-06-22 00:00:00.0¬|¬¬|¬¬|¬0¬|¬0¬|¬This record was a correspondence in version 1 of V-Base.¬|¬2001-08-28 00:00:00.0¬|¬2002-01-11 12:08:14.0¬|¬Sarah¬|", csvFileReader.readRecord());
        assertEquals("record n equal", "¬94¬|¬A - V - Appointment¬|¬1. Vol¬|¬818¬|¬¬|¬¬|¬¬|¬Letter Sent to Finbar Taylor¬|¬¬|¬2001-07-17 00:00:00.0¬|¬2001-07-17 00:00:00.0¬|¬0¬|¬¬|¬¬|¬1¬|¬Appointment Letter¬|¬2001-07-17 00:00:00.0¬|¬¬|¬¬|¬0¬|¬0¬|¬This record was a correspondence in version 1 of V-Base.¬|¬2001-08-28 00:00:00.0¬|¬2002-01-11 12:00:48.0¬|¬Sarah¬|", csvFileReader.readRecord());
        assertEquals("record n equal", "¬154¬|¬A - V - Appointment¬|¬1. Vol¬|¬916¬|¬¬|¬¬|¬¬|¬Letter Sent to Karishma Chandaria¬|¬¬|¬2001-08-16 09:00:00.0¬|¬2001-08-16 09:15:00.0¬|¬0¬|¬¬|¬¬|¬0¬|¬Appointment Letter¬|¬2001-08-16 00:00:00.0¬|¬¬|¬¬|¬0¬|¬0¬|¬This record was a correspondence in version 1 of V-Base.¬|¬2001-08-28 00:00:00.0¬|¬2002-03-12 11:36:42.0¬|¬Sarah¬|", csvFileReader.readRecord());
        assertEquals("record n equal", "¬159¬|¬A - V - Appointment¬|¬1. Vol¬|¬1522¬|¬¬|¬¬|¬¬|¬Letter Sent to Nazma Begun¬|¬¬|¬2001-08-21 00:00:00.0¬|¬2001-08-21 00:00:00.0¬|¬0¬|¬¬|¬¬|¬1¬|¬Appointment Letter¬|¬2001-08-21 00:00:00.0¬|¬¬|¬¬|¬0¬|¬0¬|¬This record was a correspondence in version 1 of V-Base.¬|¬2001-08-28 00:00:00.0¬|¬2002-01-08 11:27:52.0¬|¬Sarah¬|", csvFileReader.readRecord());
        assertEquals("record n equal", "¬165¬|¬A - V - Appointment¬|¬1. Vol¬|¬11923¬|¬¬|¬¬|¬¬|¬Letter Sent to Maria Bosson¬|¬¬|¬2001-08-24 00:00:00.0¬|¬2001-08-24 00:00:00.0¬|¬0¬|¬¬|¬¬|¬1¬|¬Opportunities Letter¬|¬2001-08-24 00:00:00.0¬|¬¬|¬¬|¬0¬|¬0¬|¬This record was a correspondence in version 1 of V-Base.¬|¬2001-08-28 00:00:00.0¬|¬2004-12-22 12:18:27.0¬|¬Eileen¬|", csvFileReader.readRecord());
        assertEquals("record n equal", "¬194¬|¬A - V - Appointment¬|¬1. Vol¬|¬277¬|¬¬|¬¬|¬¬|¬Letter Sent to Mary Kernick¬|¬¬|¬2001-01-22 00:00:00.0¬|¬2001-01-22 00:00:00.0¬|¬0¬|¬¬|¬¬|¬1¬|¬Appointment Letter¬|¬2001-01-22 00:00:00.0¬|¬¬|¬¬|¬0¬|¬0¬|¬This record was a correspondence in version 1 of V-Base.¬|¬2001-08-28 00:00:00.0¬|¬2002-01-08 13:43:15.0¬|¬Sarah¬|", csvFileReader.readRecord());
        assertEquals("record n equal", "¬216¬|¬A - V - Appointment¬|¬1. Vol¬|¬320¬|¬¬|¬¬|¬¬|¬Letter Sent to Sarah Adams¬|¬¬|¬2001-02-01 00:00:00.0¬|¬2001-02-01 00:00:00.0¬|¬0¬|¬¬|¬¬|¬1¬|¬Appointment Letter¬|¬2001-02-01 00:00:00.0¬|¬¬|¬¬|¬0¬|¬0¬|¬This record was a correspondence in version 1 of V-Base.¬|¬2001-08-28 00:00:00.0¬|¬2002-01-08 11:11:55.0¬|¬Sarah¬|", csvFileReader.readRecord());
        assertEquals("record n equal", "¬340¬|¬A - V - Appointment¬|¬1. Vol¬|¬22396¬|¬¬|¬¬|¬¬|¬Volunteer Appointment - Salvatore Vezza¬|¬lee¬|¬2001-09-03 15:30:00.0¬|¬2001-09-03 16:00:00.0¬|¬0¬|¬¬|¬¬|¬0¬|¬Appointment Letter¬|¬2001-08-28 00:00:00.0¬|¬¬|¬¬|¬1¬|¬0¬|¬¬|¬2001-08-28 00:00:00.0¬|¬2006-08-17 15:30:31.0¬|¬sheila¬|", csvFileReader.readRecord());
    }
}
