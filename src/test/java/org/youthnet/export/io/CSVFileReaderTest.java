package org.youthnet.export.io;

import org.junit.Ignore;
import org.junit.Test;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * User: karl
 * Date: 05-Jul-2010
 */
public class CSVFileReaderTest {

    @Test
    public void testReadRecord() throws IOException {
        CSVFileReader csvFileReader = new CSVFileReader(new FileReader("src/test/resources/tblActivityLog.csv"));

        assertEquals("record 1 equal", "¬1¬|¬A - V-  Residential Volunteering Opportunities in the UK¬|¬1. Vol¬|¬¬|¬¬|¬¬|¬¬|¬Letter Sent to Emma Hardaker Jones¬|¬¬|¬2001-04-26 00:00:00.0¬|¬2001-04-26 00:00:00.0¬|¬0¬|¬¬|¬¬|¬1¬|¬Timebank Letter¬|¬2001-04-26 00:00:00.0¬|¬¬|¬¬|¬0¬|¬0¬|¬This record was a correspondence in version 1 of V-Base.¬|¬2001-08-28 00:00:00.0¬|¬2010-03-31 16:46:07.0¬|¬Eileen¬|", csvFileReader.readRecord());
        assertEquals("record 2 equal", "¬63¬|¬A - V - Postal Matching¬|¬1. Vol¬|¬761¬|¬¬|¬¬|¬¬|¬Letter Sent to Laura Hamilton¬|¬¬|¬2001-06-22 00:00:00.0¬|¬2001-06-22 00:00:00.0¬|¬0¬|¬¬|¬¬|¬1¬|¬Opportunities Letter¬|¬2001-06-22 00:00:00.0¬|¬¬|¬¬|¬0¬|¬0¬|¬This record was a correspondence in version 1 of V-Base.¬|¬2001-08-28 00:00:00.0¬|¬2002-01-08 12:50:44.0¬|¬Sarah¬|", csvFileReader.readRecord());
        assertEquals("record 3 equal", "¬64¬|¬A - V - Appointment¬|¬1. Vol¬|¬764¬|¬¬|¬¬|¬¬|¬Letter Sent to Ilka Walkley¬|¬¬|¬2001-06-22 00:00:00.0¬|¬2001-06-22 00:00:00.0¬|¬0¬|¬¬|¬¬|¬1¬|¬Appointment Letter¬|¬2001-06-22 00:00:00.0¬|¬¬|¬¬|¬0¬|¬0¬|¬This record was a correspondence in version 1 of V-Base.¬|¬2001-08-28 00:00:00.0¬|¬2002-01-11 12:08:14.0¬|¬Sarah¬|", csvFileReader.readRecord());
        assertEquals("record 4 equal", "¬94¬|¬A - V - Appointment¬|¬1. Vol¬|¬818¬|¬¬|¬¬|¬¬|¬Letter Sent to Finbar Taylor¬|¬¬|¬2001-07-17 00:00:00.0¬|¬2001-07-17 00:00:00.0¬|¬0¬|¬¬|¬¬|¬1¬|¬Appointment Letter¬|¬2001-07-17 00:00:00.0¬|¬¬|¬¬|¬0¬|¬0¬|¬This record was a correspondence in version 1 of V-Base.¬|¬2001-08-28 00:00:00.0¬|¬2002-01-11 12:00:48.0¬|¬Sarah¬|", csvFileReader.readRecord());
        assertEquals("record 5 equal", "¬154¬|¬A - V - Appointment¬|¬1. Vol¬|¬916¬|¬¬|¬¬|¬¬|¬Letter Sent to Karishma Chandaria¬|¬¬|¬2001-08-16 09:00:00.0¬|¬2001-08-16 09:15:00.0¬|¬0¬|¬¬|¬¬|¬0¬|¬Appointment Letter¬|¬2001-08-16 00:00:00.0¬|¬¬|¬¬|¬0¬|¬0¬|¬This record was a correspondence in version 1 of V-Base.¬|¬2001-08-28 00:00:00.0¬|¬2002-03-12 11:36:42.0¬|¬Sarah¬|", csvFileReader.readRecord());
        assertEquals("record 6 equal", "¬159¬|¬A - V - Appointment¬|¬1. Vol¬|¬1522¬|¬¬|¬¬|¬¬|¬Letter Sent to Nazma Begun¬|¬¬|¬2001-08-21 00:00:00.0¬|¬2001-08-21 00:00:00.0¬|¬0¬|¬¬|¬¬|¬1¬|¬Appointment Letter¬|¬2001-08-21 00:00:00.0¬|¬¬|¬¬|¬0¬|¬0¬|¬This record was a correspondence in version 1 of V-Base.¬|¬2001-08-28 00:00:00.0¬|¬2002-01-08 11:27:52.0¬|¬Sarah¬|", csvFileReader.readRecord());
        assertEquals("record 7 equal", "¬165¬|¬A - V - Appointment¬|¬1. Vol¬|¬11923¬|¬¬|¬¬|¬¬|¬Letter Sent to Maria Bosson¬|¬¬|¬2001-08-24 00:00:00.0¬|¬2001-08-24 00:00:00.0¬|¬0¬|¬¬|¬¬|¬1¬|¬Opportunities Letter¬|¬2001-08-24 00:00:00.0¬|¬¬|¬¬|¬0¬|¬0¬|¬This record was a correspondence in version 1 of V-Base.¬|¬2001-08-28 00:00:00.0¬|¬2004-12-22 12:18:27.0¬|¬Eileen¬|", csvFileReader.readRecord());
        assertEquals("record 8 equal", "¬194¬|¬A - V - Appointment¬|¬1. Vol¬|¬277¬|¬¬|¬¬|¬¬|¬Letter Sent to Mary Kernick¬|¬¬|¬2001-01-22 00:00:00.0¬|¬2001-01-22 00:00:00.0¬|¬0¬|¬¬|¬¬|¬1¬|¬Appointment Letter¬|¬2001-01-22 00:00:00.0¬|¬¬|¬¬|¬0¬|¬0¬|¬This record was a correspondence in version 1 of V-Base.¬|¬2001-08-28 00:00:00.0¬|¬2002-01-08 13:43:15.0¬|¬Sarah¬|", csvFileReader.readRecord());
        assertEquals("record 9 equal", "¬216¬|¬A - V - Appointment¬|¬1. Vol¬|¬320¬|¬¬|¬¬|¬¬|¬Letter Sent to Sarah Adams¬|¬¬|¬2001-02-01 00:00:00.0¬|¬2001-02-01 00:00:00.0¬|¬0¬|¬¬|¬¬|¬1¬|¬Appointment Letter¬|¬2001-02-01 00:00:00.0¬|¬¬|¬¬|¬0¬|¬0¬|¬This record was a correspondence in version 1 of V-Base.¬|¬2001-08-28 00:00:00.0¬|¬2002-01-08 11:11:55.0¬|¬Sarah¬|", csvFileReader.readRecord());
        assertEquals("record 10 equal", "¬340¬|¬A - V - Appointment¬|¬1. Vol¬|¬22396¬|¬¬|¬¬|¬¬|¬Volunteer Appointment - Salvatore Vezza¬|¬lee¬|¬2001-09-03 15:30:00.0¬|¬2001-09-03 16:00:00.0¬|¬0¬|¬¬|¬¬|¬0¬|¬Appointment Letter¬|¬2001-08-28 00:00:00.0¬|¬¬|¬¬|¬1¬|¬0¬|¬¬|¬2001-08-28 00:00:00.0¬|¬2006-08-17 15:30:31.0¬|¬sheila¬|", csvFileReader.readRecord());
    }

    @Test
    public void testReadToEnd() throws IOException {
        CSVFileReader csvFileReader = new CSVFileReader(new FileReader("src/test/resources/tblActivityLog.csv"));

        String oldRecord = "";
        String record = "";

        while ((oldRecord = csvFileReader.readRecord()) != null) {
            record = oldRecord;
        }

        String testRecord = "¬137111¬|¬Z - Organisation Vol Opp DEACTIVATED¬|¬3. Org¬|¬¬|¬¬|¬1515¬|¬¬|¬Z - Organisation Vol Opp DEACTIVATED - The Whitaker Centre (Equinox Care)¬|¬cha cha¬|¬2010-04-16 00:00:00.0¬|¬2010-04-16 00:00:00.0¬|¬0¬|¬¬|¬¬|¬1¬|¬¬|¬¬|¬¬|¬¬|¬0¬|¬0¬|¬-------------------------------------------------------------------------------- From: Mark Palframan [mailto:Mark.Palframan@ort.equinoxcare.org.uk]  Sent: 14 April 2010 13:23 To: VCC Reception Subject: Vacancy update at the Whitaker Centre   Please remove the vacancy for volunteer IT tutor from our listings, thanks.     We have recruited two very good volunteers, Mark Richmond and Faruque Ahmed, who have now been here for two months so we no longer require any more.  (I’m not sure if these two came through yourselves or not. My records don’t list this.)  They have been assisting our clients with developing their IT skills, accessing the internet, sending emails and looking for work.  It is going very well at the moment and we are very pleased with the contribution which they are making to the work of our day centre.        Mark Palframan  Service Manager  Equinox Whitaker Centre and Outreach   020 7263 4140¬|¬2010-04-16 00:00:00.0¬|¬2010-04-16 14:45:57.0¬|¬cha cha¬| ";

        assertEquals("record 10 equal", testRecord, record.replace('\n', ' '));
    }
}
