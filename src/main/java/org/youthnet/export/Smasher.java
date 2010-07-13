package org.youthnet.export;

import com.healthmarketscience.jackcess.Column;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;
import org.apache.commons.lang.StringEscapeUtils;
import org.youthnet.export.domain.vb3.Lookups;
import org.youthnet.export.migration.*;
import org.youthnet.export.util.CSVUtil;
import org.youthnet.export.util.JavaCodeUtil;
import org.youthnet.export.util.SQLCodeUtil;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.*;

/**
 * User: karl
 * Date: 28-Jun-2010
 */
public class Smasher {

    public static final String OUTPUT_DIR = "smashed";
    public static final String CSV_DIR = "csv";
    public static final String SQL_DIR = "sql";
    public static final String SQL_PRE = "pre";
    public static final String SQL_POST = "post";
    public static final String LOGS_DIR = "logs";
    public static final String JAVA_DIR = "java";
    public static final String MIGRATED_DIR = "migrated";
    public static final char CSV_ENCLOSURE = '¬';
    public static final char CSV_DELIMITER = '|';

    public static final Map<String, Map<String, Integer>> TABLE_COLUMN_MAP;

    static {
        Map<String, Map<String, Integer>> tableColumnMap = new HashMap<String, Map<String, Integer>>();

        tableColumnMap.put("tblvoltypeofactivity", new HashMap<String, Integer>());
        tableColumnMap.get("tblvoltypeofactivity").put("actid", 0);
        tableColumnMap.get("tblvoltypeofactivity").put("vid", 1);
        tableColumnMap.get("tblvoltypeofactivity").put("typeofactivity", 2);
        tableColumnMap.get("tblvoltypeofactivity").put("delimiter", 3);
        tableColumnMap.get("tblvoltypeofactivity").put("enclosure", 4);
        tableColumnMap.get("tblvoltypeofactivity").put("columnnumber", 5);
        tableColumnMap.get("tblvoltypeofactivity").put("record", 6);

        tableColumnMap.put("tbluagerange", new HashMap<String, Integer>());
        tableColumnMap.get("tbluagerange").put("agerange", 0);
        tableColumnMap.get("tbluagerange").put("active", 1);
        tableColumnMap.get("tbluagerange").put("order", 2);
        tableColumnMap.get("tbluagerange").put("demodata", 3);
        tableColumnMap.get("tbluagerange").put("delimiter", 4);
        tableColumnMap.get("tbluagerange").put("enclosure", 5);
        tableColumnMap.get("tbluagerange").put("columnnumber", 6);
        tableColumnMap.get("tbluagerange").put("record", 7);

        tableColumnMap.put("tblugeographicalarea", new HashMap<String, Integer>());
        tableColumnMap.get("tblugeographicalarea").put("geographicalarea", 0);
        tableColumnMap.get("tblugeographicalarea").put("active", 1);
        tableColumnMap.get("tblugeographicalarea").put("demodata", 2);
        tableColumnMap.get("tblugeographicalarea").put("delimiter", 3);
        tableColumnMap.get("tblugeographicalarea").put("enclosure", 4);
        tableColumnMap.get("tblugeographicalarea").put("columnnumber", 5);
        tableColumnMap.get("tblugeographicalarea").put("record", 6);

        tableColumnMap.put("tbluopparrangements", new HashMap<String, Integer>());
        tableColumnMap.get("tbluopparrangements").put("opparrangements", 0);
        tableColumnMap.get("tbluopparrangements").put("active", 1);
        tableColumnMap.get("tbluopparrangements").put("demodata", 2);
        tableColumnMap.get("tbluopparrangements").put("delimiter", 3);
        tableColumnMap.get("tbluopparrangements").put("enclosure", 4);
        tableColumnMap.get("tbluopparrangements").put("columnnumber", 5);
        tableColumnMap.get("tbluopparrangements").put("record", 6);

        tableColumnMap.put("usysgridformat", new HashMap<String, Integer>());
        tableColumnMap.get("usysgridformat").put("user", 0);
        tableColumnMap.get("usysgridformat").put("selected", 1);
        tableColumnMap.get("usysgridformat").put("delimiter", 2);
        tableColumnMap.get("usysgridformat").put("enclosure", 3);
        tableColumnMap.get("usysgridformat").put("columnnumber", 4);
        tableColumnMap.get("usysgridformat").put("record", 5);

        tableColumnMap.put("usysreportactlogactivities", new HashMap<String, Integer>());
        tableColumnMap.get("usysreportactlogactivities").put("activity", 0);
        tableColumnMap.get("usysreportactlogactivities").put("user", 1);
        tableColumnMap.get("usysreportactlogactivities").put("delimiter", 2);
        tableColumnMap.get("usysreportactlogactivities").put("enclosure", 3);
        tableColumnMap.get("usysreportactlogactivities").put("columnnumber", 4);
        tableColumnMap.get("usysreportactlogactivities").put("record", 5);

        tableColumnMap.put("usysreportstatsactivities", new HashMap<String, Integer>());
        tableColumnMap.get("usysreportstatsactivities").put("activity", 0);
        tableColumnMap.get("usysreportstatsactivities").put("user", 1);
        tableColumnMap.get("usysreportstatsactivities").put("delimiter", 2);
        tableColumnMap.get("usysreportstatsactivities").put("enclosure", 3);
        tableColumnMap.get("usysreportstatsactivities").put("columnnumber", 4);
        tableColumnMap.get("usysreportstatsactivities").put("record", 5);

        tableColumnMap.put("tbloppspecial", new HashMap<String, Integer>());
        tableColumnMap.get("tbloppspecial").put("sid", 0);
        tableColumnMap.get("tbloppspecial").put("oid", 1);
        tableColumnMap.get("tbloppspecial").put("special", 2);
        tableColumnMap.get("tbloppspecial").put("delimiter", 3);
        tableColumnMap.get("tbloppspecial").put("enclosure", 4);
        tableColumnMap.get("tbloppspecial").put("columnnumber", 5);
        tableColumnMap.get("tbloppspecial").put("record", 6);

        tableColumnMap.put("tblureligion", new HashMap<String, Integer>());
        tableColumnMap.get("tblureligion").put("religion", 0);
        tableColumnMap.get("tblureligion").put("active", 1);
        tableColumnMap.get("tblureligion").put("demodata", 2);
        tableColumnMap.get("tblureligion").put("delimiter", 3);
        tableColumnMap.get("tblureligion").put("enclosure", 4);
        tableColumnMap.get("tblureligion").put("columnnumber", 5);
        tableColumnMap.get("tblureligion").put("record", 6);

        tableColumnMap.put("usysmailingdefaultsview", new HashMap<String, Integer>());
        tableColumnMap.get("usysmailingdefaultsview").put("no", 0);
        tableColumnMap.get("usysmailingdefaultsview").put("option", 1);
        tableColumnMap.get("usysmailingdefaultsview").put("value", 2);
        tableColumnMap.get("usysmailingdefaultsview").put("delimiter", 3);
        tableColumnMap.get("usysmailingdefaultsview").put("enclosure", 4);
        tableColumnMap.get("usysmailingdefaultsview").put("columnnumber", 5);
        tableColumnMap.get("usysmailingdefaultsview").put("record", 6);

        tableColumnMap.put("usysqbfvolspecial", new HashMap<String, Integer>());
        tableColumnMap.get("usysqbfvolspecial").put("user", 0);
        tableColumnMap.get("usysqbfvolspecial").put("special", 1);
        tableColumnMap.get("usysqbfvolspecial").put("delimiter", 2);
        tableColumnMap.get("usysqbfvolspecial").put("enclosure", 3);
        tableColumnMap.get("usysqbfvolspecial").put("columnnumber", 4);
        tableColumnMap.get("usysqbfvolspecial").put("record", 5);

        tableColumnMap.put("usyspivotscriteria", new HashMap<String, Integer>());
        tableColumnMap.get("usyspivotscriteria").put("pivot", 0);
        tableColumnMap.get("usyspivotscriteria").put("user", 1);
        tableColumnMap.get("usyspivotscriteria").put("startdate", 2);
        tableColumnMap.get("usyspivotscriteria").put("enddate", 3);
        tableColumnMap.get("usyspivotscriteria").put("dateoption", 4);
        tableColumnMap.get("usyspivotscriteria").put("sql", 5);
        tableColumnMap.get("usyspivotscriteria").put("delimiter", 6);
        tableColumnMap.get("usyspivotscriteria").put("enclosure", 7);
        tableColumnMap.get("usyspivotscriteria").put("columnnumber", 8);
        tableColumnMap.get("usyspivotscriteria").put("record", 9);

        tableColumnMap.put("tblustatus", new HashMap<String, Integer>());
        tableColumnMap.get("tblustatus").put("status", 0);
        tableColumnMap.get("tblustatus").put("active", 1);
        tableColumnMap.get("tblustatus").put("default", 2);
        tableColumnMap.get("tblustatus").put("demodata", 3);
        tableColumnMap.get("tblustatus").put("delimiter", 4);
        tableColumnMap.get("tblustatus").put("enclosure", 5);
        tableColumnMap.get("tblustatus").put("columnnumber", 6);
        tableColumnMap.get("tblustatus").put("record", 7);

        tableColumnMap.put("usysqbfopptypeofactivity", new HashMap<String, Integer>());
        tableColumnMap.get("usysqbfopptypeofactivity").put("user", 0);
        tableColumnMap.get("usysqbfopptypeofactivity").put("typeofactivity", 1);
        tableColumnMap.get("usysqbfopptypeofactivity").put("delimiter", 2);
        tableColumnMap.get("usysqbfopptypeofactivity").put("enclosure", 3);
        tableColumnMap.get("usysqbfopptypeofactivity").put("columnnumber", 4);
        tableColumnMap.get("usysqbfopptypeofactivity").put("record", 5);

        tableColumnMap.put("tbluspecial", new HashMap<String, Integer>());
        tableColumnMap.get("tbluspecial").put("special", 0);
        tableColumnMap.get("tbluspecial").put("active", 1);
        tableColumnMap.get("tbluspecial").put("demodata", 2);
        tableColumnMap.get("tbluspecial").put("delimiter", 3);
        tableColumnMap.get("tbluspecial").put("enclosure", 4);
        tableColumnMap.get("tbluspecial").put("columnnumber", 5);
        tableColumnMap.get("tbluspecial").put("record", 6);

        tableColumnMap.put("usysqbfvoltime", new HashMap<String, Integer>());
        tableColumnMap.get("usysqbfvoltime").put("user", 0);
        tableColumnMap.get("usysqbfvoltime").put("day", 1);
        tableColumnMap.get("usysqbfvoltime").put("timeslot", 2);
        tableColumnMap.get("usysqbfvoltime").put("delimiter", 3);
        tableColumnMap.get("usysqbfvoltime").put("enclosure", 4);
        tableColumnMap.get("usysqbfvoltime").put("columnnumber", 5);
        tableColumnMap.get("usysqbfvoltime").put("record", 6);

        tableColumnMap.put("containsoid", new HashMap<String, Integer>());
        tableColumnMap.get("containsoid").put("oid;", 0);

        tableColumnMap.put("tbluhowheard", new HashMap<String, Integer>());
        tableColumnMap.get("tbluhowheard").put("howheard", 0);
        tableColumnMap.get("tbluhowheard").put("active", 1);
        tableColumnMap.get("tbluhowheard").put("demodata", 2);
        tableColumnMap.get("tbluhowheard").put("delimiter", 3);
        tableColumnMap.get("tbluhowheard").put("enclosure", 4);
        tableColumnMap.get("tbluhowheard").put("columnnumber", 5);
        tableColumnMap.get("tbluhowheard").put("record", 6);

        tableColumnMap.put("tbludisabilitystatus", new HashMap<String, Integer>());
        tableColumnMap.get("tbludisabilitystatus").put("disabilitystatus", 0);
        tableColumnMap.get("tbludisabilitystatus").put("active", 1);
        tableColumnMap.get("tbludisabilitystatus").put("demodata", 2);
        tableColumnMap.get("tbludisabilitystatus").put("delimiter", 3);
        tableColumnMap.get("tbludisabilitystatus").put("enclosure", 4);
        tableColumnMap.get("tbludisabilitystatus").put("columnnumber", 5);
        tableColumnMap.get("tbludisabilitystatus").put("record", 6);

        tableColumnMap.put("tblopptime", new HashMap<String, Integer>());
        tableColumnMap.get("tblopptime").put("tid", 0);
        tableColumnMap.get("tblopptime").put("oid", 1);
        tableColumnMap.get("tblopptime").put("day", 2);
        tableColumnMap.get("tblopptime").put("timeslot", 3);
        tableColumnMap.get("tblopptime").put("delimiter", 4);
        tableColumnMap.get("tblopptime").put("enclosure", 5);
        tableColumnMap.get("tblopptime").put("columnnumber", 6);
        tableColumnMap.get("tblopptime").put("record", 7);

        tableColumnMap.put("tblusuitability", new HashMap<String, Integer>());
        tableColumnMap.get("tblusuitability").put("suitability", 0);
        tableColumnMap.get("tblusuitability").put("active", 1);
        tableColumnMap.get("tblusuitability").put("id", 2);
        tableColumnMap.get("tblusuitability").put("demodata", 3);
        tableColumnMap.get("tblusuitability").put("delimiter", 4);
        tableColumnMap.get("tblusuitability").put("enclosure", 5);
        tableColumnMap.get("tblusuitability").put("columnnumber", 6);
        tableColumnMap.get("tblusuitability").put("record", 7);

        tableColumnMap.put("tblactivitylog", new HashMap<String, Integer>());
        tableColumnMap.get("tblactivitylog").put("lid", 0);
        tableColumnMap.get("tblactivitylog").put("activity", 1);
        tableColumnMap.get("tblactivitylog").put("type", 2);
        tableColumnMap.get("tblactivitylog").put("vid", 3);
        tableColumnMap.get("tblactivitylog").put("oid", 4);
        tableColumnMap.get("tblactivitylog").put("orgid", 5);
        tableColumnMap.get("tblactivitylog").put("linkedoid", 6);
        tableColumnMap.get("tblactivitylog").put("subject", 7);
        tableColumnMap.get("tblactivitylog").put("owner", 8);
        tableColumnMap.get("tblactivitylog").put("starttime", 9);
        tableColumnMap.get("tblactivitylog").put("endtime", 10);
        tableColumnMap.get("tblactivitylog").put("alarm", 11);
        tableColumnMap.get("tblactivitylog").put("alarmstarttime", 12);
        tableColumnMap.get("tblactivitylog").put("alarmperiod", 13);
        tableColumnMap.get("tblactivitylog").put("alldayevent", 14);
        tableColumnMap.get("tblactivitylog").put("correspondence", 15);
        tableColumnMap.get("tblactivitylog").put("datecorrsent", 16);
        tableColumnMap.get("tblactivitylog").put("linkedlid", 17);
        tableColumnMap.get("tblactivitylog").put("backlid", 18);
        tableColumnMap.get("tblactivitylog").put("showincalendar", 19);
        tableColumnMap.get("tblactivitylog").put("esttotalhours", 20);
        tableColumnMap.get("tblactivitylog").put("notes", 21);
        tableColumnMap.get("tblactivitylog").put("datefirstentered", 22);
        tableColumnMap.get("tblactivitylog").put("datelastupdated", 23);
        tableColumnMap.get("tblactivitylog").put("lastupdatedby", 24);
        tableColumnMap.get("tblactivitylog").put("delimiter", 25);
        tableColumnMap.get("tblactivitylog").put("enclosure", 26);
        tableColumnMap.get("tblactivitylog").put("columnnumber", 27);
        tableColumnMap.get("tblactivitylog").put("record", 28);

        tableColumnMap.put("usystimeslots", new HashMap<String, Integer>());
        tableColumnMap.get("usystimeslots").put("found", 0);
        tableColumnMap.get("usystimeslots").put("readable", 1);
        tableColumnMap.get("usystimeslots").put("delimiter", 2);
        tableColumnMap.get("usystimeslots").put("enclosure", 3);
        tableColumnMap.get("usystimeslots").put("columnnumber", 4);
        tableColumnMap.get("usystimeslots").put("record", 5);

        tableColumnMap.put("tblvoltime", new HashMap<String, Integer>());
        tableColumnMap.get("tblvoltime").put("tid", 0);
        tableColumnMap.get("tblvoltime").put("vid", 1);
        tableColumnMap.get("tblvoltime").put("day", 2);
        tableColumnMap.get("tblvoltime").put("timeslot", 3);
        tableColumnMap.get("tblvoltime").put("delimiter", 4);
        tableColumnMap.get("tblvoltime").put("enclosure", 5);
        tableColumnMap.get("tblvoltime").put("columnnumber", 6);
        tableColumnMap.get("tblvoltime").put("record", 7);

        tableColumnMap.put("tbloppsuitability", new HashMap<String, Integer>());
        tableColumnMap.get("tbloppsuitability").put("id", 0);
        tableColumnMap.get("tbloppsuitability").put("oid", 1);
        tableColumnMap.get("tbloppsuitability").put("sid", 2);
        tableColumnMap.get("tbloppsuitability").put("delimiter", 3);
        tableColumnMap.get("tbloppsuitability").put("enclosure", 4);
        tableColumnMap.get("tbloppsuitability").put("columnnumber", 5);
        tableColumnMap.get("tbloppsuitability").put("record", 6);

        tableColumnMap.put("usysbackup", new HashMap<String, Integer>());
        tableColumnMap.get("usysbackup").put("lastdate", 0);
        tableColumnMap.get("usysbackup").put("filename", 1);
        tableColumnMap.get("usysbackup").put("includedate", 2);
        tableColumnMap.get("usysbackup").put("delimiter", 3);
        tableColumnMap.get("usysbackup").put("enclosure", 4);
        tableColumnMap.get("usysbackup").put("columnnumber", 5);
        tableColumnMap.get("usysbackup").put("record", 6);

        tableColumnMap.put("usyschartcriteria", new HashMap<String, Integer>());
        tableColumnMap.get("usyschartcriteria").put("chart", 0);
        tableColumnMap.get("usyschartcriteria").put("user", 1);
        tableColumnMap.get("usyschartcriteria").put("inenglish", 2);
        tableColumnMap.get("usyschartcriteria").put("whereclause", 3);
        tableColumnMap.get("usyschartcriteria").put("criteria", 4);
        tableColumnMap.get("usyschartcriteria").put("altwhereclause", 5);
        tableColumnMap.get("usyschartcriteria").put("delimiter", 6);
        tableColumnMap.get("usyschartcriteria").put("enclosure", 7);
        tableColumnMap.get("usyschartcriteria").put("columnnumber", 8);
        tableColumnMap.get("usyschartcriteria").put("record", 9);

        tableColumnMap.put("usysftphistory", new HashMap<String, Integer>());
        tableColumnMap.get("usysftphistory").put("hid", 0);
        tableColumnMap.get("usysftphistory").put("posteddate", 1);
        tableColumnMap.get("usysftphistory").put("otherinfo", 2);
        tableColumnMap.get("usysftphistory").put("delimiter", 3);
        tableColumnMap.get("usysftphistory").put("enclosure", 4);
        tableColumnMap.get("usysftphistory").put("columnnumber", 5);
        tableColumnMap.get("usysftphistory").put("record", 6);

        tableColumnMap.put("usysqbfoppspecificdates", new HashMap<String, Integer>());
        tableColumnMap.get("usysqbfoppspecificdates").put("user", 0);
        tableColumnMap.get("usysqbfoppspecificdates").put("specificstartdate", 1);
        tableColumnMap.get("usysqbfoppspecificdates").put("specificenddate", 2);
        tableColumnMap.get("usysqbfoppspecificdates").put("delimiter", 3);
        tableColumnMap.get("usysqbfoppspecificdates").put("enclosure", 4);
        tableColumnMap.get("usysqbfoppspecificdates").put("columnnumber", 5);
        tableColumnMap.get("usysqbfoppspecificdates").put("record", 6);

        tableColumnMap.put("tblurecruitmentmethod", new HashMap<String, Integer>());
        tableColumnMap.get("tblurecruitmentmethod").put("recruitmentmethod", 0);
        tableColumnMap.get("tblurecruitmentmethod").put("active", 1);
        tableColumnMap.get("tblurecruitmentmethod").put("demodata", 2);
        tableColumnMap.get("tblurecruitmentmethod").put("delimiter", 3);
        tableColumnMap.get("tblurecruitmentmethod").put("enclosure", 4);
        tableColumnMap.get("tblurecruitmentmethod").put("columnnumber", 5);
        tableColumnMap.get("tblurecruitmentmethod").put("record", 6);

        tableColumnMap.put("usysuserlicence", new HashMap<String, Integer>());
        tableColumnMap.get("usysuserlicence").put("licence", 0);
        tableColumnMap.get("usysuserlicence").put("delimiter", 1);
        tableColumnMap.get("usysuserlicence").put("enclosure", 2);
        tableColumnMap.get("usysuserlicence").put("columnnumber", 3);
        tableColumnMap.get("usysuserlicence").put("record", 4);

        tableColumnMap.put("usysdemodata", new HashMap<String, Integer>());
        tableColumnMap.get("usysdemodata").put("demodata", 0);
        tableColumnMap.get("usysdemodata").put("delimiter", 1);
        tableColumnMap.get("usysdemodata").put("enclosure", 2);
        tableColumnMap.get("usysdemodata").put("columnnumber", 3);
        tableColumnMap.get("usysdemodata").put("record", 4);

        tableColumnMap.put("usysqbfoppgeographicalarea", new HashMap<String, Integer>());
        tableColumnMap.get("usysqbfoppgeographicalarea").put("user", 0);
        tableColumnMap.get("usysqbfoppgeographicalarea").put("geographicalarea", 1);
        tableColumnMap.get("usysqbfoppgeographicalarea").put("delimiter", 2);
        tableColumnMap.get("usysqbfoppgeographicalarea").put("enclosure", 3);
        tableColumnMap.get("usysqbfoppgeographicalarea").put("columnnumber", 4);
        tableColumnMap.get("usysqbfoppgeographicalarea").put("record", 5);

        tableColumnMap.put("tblucommitment", new HashMap<String, Integer>());
        tableColumnMap.get("tblucommitment").put("commitment", 0);
        tableColumnMap.get("tblucommitment").put("active", 1);
        tableColumnMap.get("tblucommitment").put("id", 2);
        tableColumnMap.get("tblucommitment").put("demodata", 3);
        tableColumnMap.get("tblucommitment").put("delimiter", 4);
        tableColumnMap.get("tblucommitment").put("enclosure", 5);
        tableColumnMap.get("tblucommitment").put("columnnumber", 6);
        tableColumnMap.get("tblucommitment").put("record", 7);

        tableColumnMap.put("tbluethnicity", new HashMap<String, Integer>());
        tableColumnMap.get("tbluethnicity").put("ethnicity", 0);
        tableColumnMap.get("tbluethnicity").put("active", 1);
        tableColumnMap.get("tbluethnicity").put("demodata", 2);
        tableColumnMap.get("tbluethnicity").put("delimiter", 3);
        tableColumnMap.get("tbluethnicity").put("enclosure", 4);
        tableColumnMap.get("tbluethnicity").put("columnnumber", 5);
        tableColumnMap.get("tbluethnicity").put("record", 6);

        tableColumnMap.put("usysregistration", new HashMap<String, Integer>());
        tableColumnMap.get("usysregistration").put("shortname", 0);
        tableColumnMap.get("usysregistration").put("address1", 1);
        tableColumnMap.get("usysregistration").put("address2", 2);
        tableColumnMap.get("usysregistration").put("town", 3);
        tableColumnMap.get("usysregistration").put("county", 4);
        tableColumnMap.get("usysregistration").put("postcode", 5);
        tableColumnMap.get("usysregistration").put("tel1", 6);
        tableColumnMap.get("usysregistration").put("fax", 7);
        tableColumnMap.get("usysregistration").put("email", 8);
        tableColumnMap.get("usysregistration").put("www", 9);
        tableColumnMap.get("usysregistration").put("defaultorg", 10);
        tableColumnMap.get("usysregistration").put("datefirstentered", 11);
        tableColumnMap.get("usysregistration").put("datelastupdated", 12);
        tableColumnMap.get("usysregistration").put("lastupdatedby", 13);
        tableColumnMap.get("usysregistration").put("delimiter", 14);
        tableColumnMap.get("usysregistration").put("enclosure", 15);
        tableColumnMap.get("usysregistration").put("columnnumber", 16);
        tableColumnMap.get("usysregistration").put("record", 17);

        tableColumnMap.put("tbloppcommitment", new HashMap<String, Integer>());
        tableColumnMap.get("tbloppcommitment").put("id", 0);
        tableColumnMap.get("tbloppcommitment").put("oid", 1);
        tableColumnMap.get("tbloppcommitment").put("cid", 2);
        tableColumnMap.get("tbloppcommitment").put("delimiter", 3);
        tableColumnMap.get("tbloppcommitment").put("enclosure", 4);
        tableColumnMap.get("tbloppcommitment").put("columnnumber", 5);
        tableColumnMap.get("tbloppcommitment").put("record", 6);

        tableColumnMap.put("usyschanges", new HashMap<String, Integer>());
        tableColumnMap.get("usyschanges").put("no", 0);
        tableColumnMap.get("usyschanges").put("change", 1);
        tableColumnMap.get("usyschanges").put("description", 2);
        tableColumnMap.get("usyschanges").put("done", 3);
        tableColumnMap.get("usyschanges").put("delimiter", 4);
        tableColumnMap.get("usyschanges").put("enclosure", 5);
        tableColumnMap.get("usyschanges").put("columnnumber", 6);
        tableColumnMap.get("usyschanges").put("record", 7);

        tableColumnMap.put("tblutypeofdrivinglicence", new HashMap<String, Integer>());
        tableColumnMap.get("tblutypeofdrivinglicence").put("typeofdrivinglicence", 0);
        tableColumnMap.get("tblutypeofdrivinglicence").put("active", 1);
        tableColumnMap.get("tblutypeofdrivinglicence").put("demodata", 2);
        tableColumnMap.get("tblutypeofdrivinglicence").put("delimiter", 3);
        tableColumnMap.get("tblutypeofdrivinglicence").put("enclosure", 4);
        tableColumnMap.get("tblutypeofdrivinglicence").put("columnnumber", 5);
        tableColumnMap.get("tblutypeofdrivinglicence").put("record", 6);

        tableColumnMap.put("tblugender", new HashMap<String, Integer>());
        tableColumnMap.get("tblugender").put("gender", 0);
        tableColumnMap.get("tblugender").put("active", 1);
        tableColumnMap.get("tblugender").put("demodata", 2);
        tableColumnMap.get("tblugender").put("delimiter", 3);
        tableColumnMap.get("tblugender").put("enclosure", 4);
        tableColumnMap.get("tblugender").put("columnnumber", 5);
        tableColumnMap.get("tblugender").put("record", 6);

        tableColumnMap.put("usysqbfvolareasofinterest", new HashMap<String, Integer>());
        tableColumnMap.get("usysqbfvolareasofinterest").put("user", 0);
        tableColumnMap.get("usysqbfvolareasofinterest").put("areasofinterest", 1);
        tableColumnMap.get("usysqbfvolareasofinterest").put("delimiter", 2);
        tableColumnMap.get("usysqbfvolareasofinterest").put("enclosure", 3);
        tableColumnMap.get("usysqbfvolareasofinterest").put("columnnumber", 4);
        tableColumnMap.get("usysqbfvolareasofinterest").put("record", 5);

        tableColumnMap.put("tblutype", new HashMap<String, Integer>());
        tableColumnMap.get("tblutype").put("type", 0);
        tableColumnMap.get("tblutype").put("demodata", 1);
        tableColumnMap.get("tblutype").put("delimiter", 2);
        tableColumnMap.get("tblutype").put("enclosure", 3);
        tableColumnMap.get("tblutype").put("columnnumber", 4);
        tableColumnMap.get("tblutype").put("record", 5);

        tableColumnMap.put("usysreportcriteria", new HashMap<String, Integer>());
        tableColumnMap.get("usysreportcriteria").put("report", 0);
        tableColumnMap.get("usysreportcriteria").put("user", 1);
        tableColumnMap.get("usysreportcriteria").put("startdate", 2);
        tableColumnMap.get("usysreportcriteria").put("enddate", 3);
        tableColumnMap.get("usysreportcriteria").put("dateoption", 4);
        tableColumnMap.get("usysreportcriteria").put("sql", 5);
        tableColumnMap.get("usysreportcriteria").put("delimiter", 6);
        tableColumnMap.get("usysreportcriteria").put("enclosure", 7);
        tableColumnMap.get("usysreportcriteria").put("columnnumber", 8);
        tableColumnMap.get("usysreportcriteria").put("record", 9);

        tableColumnMap.put("usyspreviousmenu", new HashMap<String, Integer>());
        tableColumnMap.get("usyspreviousmenu").put("id", 0);
        tableColumnMap.get("usyspreviousmenu").put("user", 1);
        tableColumnMap.get("usyspreviousmenu").put("name", 2);
        tableColumnMap.get("usyspreviousmenu").put("type", 3);
        tableColumnMap.get("usyspreviousmenu").put("delimiter", 4);
        tableColumnMap.get("usyspreviousmenu").put("enclosure", 5);
        tableColumnMap.get("usyspreviousmenu").put("columnnumber", 6);
        tableColumnMap.get("usyspreviousmenu").put("record", 7);

        tableColumnMap.put("usyscompact", new HashMap<String, Integer>());
        tableColumnMap.get("usyscompact").put("lastdate", 0);
        tableColumnMap.get("usyscompact").put("delimiter", 1);
        tableColumnMap.get("usyscompact").put("enclosure", 2);
        tableColumnMap.get("usyscompact").put("columnnumber", 3);
        tableColumnMap.get("usyscompact").put("record", 4);

        tableColumnMap.put("tbludriving", new HashMap<String, Integer>());
        tableColumnMap.get("tbludriving").put("driving", 0);
        tableColumnMap.get("tbludriving").put("active", 1);
        tableColumnMap.get("tbludriving").put("demodata", 2);
        tableColumnMap.get("tbludriving").put("delimiter", 3);
        tableColumnMap.get("tbludriving").put("enclosure", 4);
        tableColumnMap.get("tbludriving").put("columnnumber", 5);
        tableColumnMap.get("tbludriving").put("record", 6);

        tableColumnMap.put("usyscharts", new HashMap<String, Integer>());
        tableColumnMap.get("usyscharts").put("chart", 0);
        tableColumnMap.get("usyscharts").put("select", 1);
        tableColumnMap.get("usyscharts").put("selectwhere", 2);
        tableColumnMap.get("usyscharts").put("groupby", 3);
        tableColumnMap.get("usyscharts").put("table", 4);
        tableColumnMap.get("usyscharts").put("order", 5);
        tableColumnMap.get("usyscharts").put("delimiter", 6);
        tableColumnMap.get("usyscharts").put("enclosure", 7);
        tableColumnMap.get("usyscharts").put("columnnumber", 8);
        tableColumnMap.get("usyscharts").put("record", 9);

        tableColumnMap.put("usysqbfoppspecial", new HashMap<String, Integer>());
        tableColumnMap.get("usysqbfoppspecial").put("user", 0);
        tableColumnMap.get("usysqbfoppspecial").put("special", 1);
        tableColumnMap.get("usysqbfoppspecial").put("delimiter", 2);
        tableColumnMap.get("usysqbfoppspecial").put("enclosure", 3);
        tableColumnMap.get("usysqbfoppspecial").put("columnnumber", 4);
        tableColumnMap.get("usysqbfoppspecial").put("record", 5);

        tableColumnMap.put("usysqbfoppcommitment", new HashMap<String, Integer>());
        tableColumnMap.get("usysqbfoppcommitment").put("user", 0);
        tableColumnMap.get("usysqbfoppcommitment").put("id", 1);
        tableColumnMap.get("usysqbfoppcommitment").put("commitment", 2);
        tableColumnMap.get("usysqbfoppcommitment").put("delimiter", 3);
        tableColumnMap.get("usysqbfoppcommitment").put("enclosure", 4);
        tableColumnMap.get("usysqbfoppcommitment").put("columnnumber", 5);
        tableColumnMap.get("usysqbfoppcommitment").put("record", 6);

        tableColumnMap.put("containsvid", new HashMap<String, Integer>());
        tableColumnMap.get("containsvid").put("vid;", 0);

        tableColumnMap.put("tblvolspecial", new HashMap<String, Integer>());
        tableColumnMap.get("tblvolspecial").put("sid", 0);
        tableColumnMap.get("tblvolspecial").put("vid", 1);
        tableColumnMap.get("tblvolspecial").put("special", 2);
        tableColumnMap.get("tblvolspecial").put("delimiter", 3);
        tableColumnMap.get("tblvolspecial").put("enclosure", 4);
        tableColumnMap.get("tblvolspecial").put("columnnumber", 5);
        tableColumnMap.get("tblvolspecial").put("record", 6);

        tableColumnMap.put("tbloppareasofinterest", new HashMap<String, Integer>());
        tableColumnMap.get("tbloppareasofinterest").put("areaid", 0);
        tableColumnMap.get("tbloppareasofinterest").put("oid", 1);
        tableColumnMap.get("tbloppareasofinterest").put("areasofinterest", 2);
        tableColumnMap.get("tbloppareasofinterest").put("delimiter", 3);
        tableColumnMap.get("tbloppareasofinterest").put("enclosure", 4);
        tableColumnMap.get("tbloppareasofinterest").put("columnnumber", 5);
        tableColumnMap.get("tbloppareasofinterest").put("record", 6);

        tableColumnMap.put("tblmailings", new HashMap<String, Integer>());
        tableColumnMap.get("tblmailings").put("mailing", 0);
        tableColumnMap.get("tblmailings").put("no", 1);
        tableColumnMap.get("tblmailings").put("description", 2);
        tableColumnMap.get("tblmailings").put("fields", 3);
        tableColumnMap.get("tblmailings").put("icon", 4);
        tableColumnMap.get("tblmailings").put("email", 5);
        tableColumnMap.get("tblmailings").put("owner", 6);
        tableColumnMap.get("tblmailings").put("datefirstentered", 7);
        tableColumnMap.get("tblmailings").put("datelastupdated", 8);
        tableColumnMap.get("tblmailings").put("lastupdatedby", 9);
        tableColumnMap.get("tblmailings").put("delimiter", 10);
        tableColumnMap.get("tblmailings").put("enclosure", 11);
        tableColumnMap.get("tblmailings").put("columnnumber", 12);
        tableColumnMap.get("tblmailings").put("record", 13);

        tableColumnMap.put("tbluemploymentstatus", new HashMap<String, Integer>());
        tableColumnMap.get("tbluemploymentstatus").put("employmentstatus", 0);
        tableColumnMap.get("tbluemploymentstatus").put("active", 1);
        tableColumnMap.get("tbluemploymentstatus").put("demodata", 2);
        tableColumnMap.get("tbluemploymentstatus").put("delimiter", 3);
        tableColumnMap.get("tbluemploymentstatus").put("enclosure", 4);
        tableColumnMap.get("tbluemploymentstatus").put("columnnumber", 5);
        tableColumnMap.get("tbluemploymentstatus").put("record", 6);

        tableColumnMap.put("usysqbfopptime", new HashMap<String, Integer>());
        tableColumnMap.get("usysqbfopptime").put("user", 0);
        tableColumnMap.get("usysqbfopptime").put("day", 1);
        tableColumnMap.get("usysqbfopptime").put("timeslot", 2);
        tableColumnMap.get("usysqbfopptime").put("delimiter", 3);
        tableColumnMap.get("usysqbfopptime").put("enclosure", 4);
        tableColumnMap.get("usysqbfopptime").put("columnnumber", 5);
        tableColumnMap.get("usysqbfopptime").put("record", 6);

        tableColumnMap.put("tblopparrangements", new HashMap<String, Integer>());
        tableColumnMap.get("tblopparrangements").put("aid", 0);
        tableColumnMap.get("tblopparrangements").put("oid", 1);
        tableColumnMap.get("tblopparrangements").put("opparrangements", 2);
        tableColumnMap.get("tblopparrangements").put("details", 3);
        tableColumnMap.get("tblopparrangements").put("delimiter", 4);
        tableColumnMap.get("tblopparrangements").put("enclosure", 5);
        tableColumnMap.get("tblopparrangements").put("columnnumber", 6);
        tableColumnMap.get("tblopparrangements").put("record", 7);

        tableColumnMap.put("tblutypeofactivity", new HashMap<String, Integer>());
        tableColumnMap.get("tblutypeofactivity").put("typeofactivity", 0);
        tableColumnMap.get("tblutypeofactivity").put("active", 1);
        tableColumnMap.get("tblutypeofactivity").put("demodata", 2);
        tableColumnMap.get("tblutypeofactivity").put("delimiter", 3);
        tableColumnMap.get("tblutypeofactivity").put("enclosure", 4);
        tableColumnMap.get("tblutypeofactivity").put("columnnumber", 5);
        tableColumnMap.get("tblutypeofactivity").put("record", 6);

        tableColumnMap.put("usysqbfvoltypeofactivity", new HashMap<String, Integer>());
        tableColumnMap.get("usysqbfvoltypeofactivity").put("user", 0);
        tableColumnMap.get("usysqbfvoltypeofactivity").put("typeofactivity", 1);
        tableColumnMap.get("usysqbfvoltypeofactivity").put("delimiter", 2);
        tableColumnMap.get("usysqbfvoltypeofactivity").put("enclosure", 3);
        tableColumnMap.get("usysqbfvoltypeofactivity").put("columnnumber", 4);
        tableColumnMap.get("usysqbfvoltypeofactivity").put("record", 5);

        tableColumnMap.put("containsorgid", new HashMap<String, Integer>());
        tableColumnMap.get("containsorgid").put("orgid;", 0);

        tableColumnMap.put("usysfavourites", new HashMap<String, Integer>());
        tableColumnMap.get("usysfavourites").put("user", 0);
        tableColumnMap.get("usysfavourites").put("type", 1);
        tableColumnMap.get("usysfavourites").put("id", 2);
        tableColumnMap.get("usysfavourites").put("delimiter", 3);
        tableColumnMap.get("usysfavourites").put("enclosure", 4);
        tableColumnMap.get("usysfavourites").put("columnnumber", 5);
        tableColumnMap.get("usysfavourites").put("record", 6);

        tableColumnMap.put("usysreportsspecial", new HashMap<String, Integer>());
        tableColumnMap.get("usysreportsspecial").put("report", 0);
        tableColumnMap.get("usysreportsspecial").put("type", 1);
        tableColumnMap.get("usysreportsspecial").put("sql", 2);
        tableColumnMap.get("usysreportsspecial").put("entsql", 3);
        tableColumnMap.get("usysreportsspecial").put("actsql", 4);
        tableColumnMap.get("usysreportsspecial").put("subsql", 5);
        tableColumnMap.get("usysreportsspecial").put("subentsql", 6);
        tableColumnMap.get("usysreportsspecial").put("subactsql", 7);
        tableColumnMap.get("usysreportsspecial").put("delimiter", 8);
        tableColumnMap.get("usysreportsspecial").put("enclosure", 9);
        tableColumnMap.get("usysreportsspecial").put("columnnumber", 10);
        tableColumnMap.get("usysreportsspecial").put("record", 11);

        tableColumnMap.put("usysreminder", new HashMap<String, Integer>());
        tableColumnMap.get("usysreminder").put("reminder", 0);
        tableColumnMap.get("usysreminder").put("period", 1);
        tableColumnMap.get("usysreminder").put("no", 2);
        tableColumnMap.get("usysreminder").put("order", 3);
        tableColumnMap.get("usysreminder").put("promptfortime", 4);
        tableColumnMap.get("usysreminder").put("alarmtime", 5);
        tableColumnMap.get("usysreminder").put("active", 6);
        tableColumnMap.get("usysreminder").put("delimiter", 7);
        tableColumnMap.get("usysreminder").put("enclosure", 8);
        tableColumnMap.get("usysreminder").put("columnnumber", 9);
        tableColumnMap.get("usysreminder").put("record", 10);

        tableColumnMap.put("usyscharacters", new HashMap<String, Integer>());
        tableColumnMap.get("usyscharacters").put("character", 0);
        tableColumnMap.get("usyscharacters").put("explanation", 1);
        tableColumnMap.get("usyscharacters").put("delimiter", 2);
        tableColumnMap.get("usyscharacters").put("enclosure", 3);
        tableColumnMap.get("usyscharacters").put("columnnumber", 4);
        tableColumnMap.get("usyscharacters").put("record", 5);

        tableColumnMap.put("tblopprecruitmentmethod", new HashMap<String, Integer>());
        tableColumnMap.get("tblopprecruitmentmethod").put("rid", 0);
        tableColumnMap.get("tblopprecruitmentmethod").put("oid", 1);
        tableColumnMap.get("tblopprecruitmentmethod").put("recruitmentmethod", 2);
        tableColumnMap.get("tblopprecruitmentmethod").put("delimiter", 3);
        tableColumnMap.get("tblopprecruitmentmethod").put("enclosure", 4);
        tableColumnMap.get("tblopprecruitmentmethod").put("columnnumber", 5);
        tableColumnMap.get("tblopprecruitmentmethod").put("record", 6);

        tableColumnMap.put("usysconfig", new HashMap<String, Integer>());
        tableColumnMap.get("usysconfig").put("user", 0);
        tableColumnMap.get("usysconfig").put("option", 1);
        tableColumnMap.get("usysconfig").put("value", 2);
        tableColumnMap.get("usysconfig").put("delimiter", 3);
        tableColumnMap.get("usysconfig").put("enclosure", 4);
        tableColumnMap.get("usysconfig").put("columnnumber", 5);
        tableColumnMap.get("usysconfig").put("record", 6);

        tableColumnMap.put("usysfieldlist", new HashMap<String, Integer>());
        tableColumnMap.get("usysfieldlist").put("field", 0);
        tableColumnMap.get("usysfieldlist").put("area", 1);
        tableColumnMap.get("usysfieldlist").put("order", 2);
        tableColumnMap.get("usysfieldlist").put("delimiter", 3);
        tableColumnMap.get("usysfieldlist").put("enclosure", 4);
        tableColumnMap.get("usysfieldlist").put("columnnumber", 5);
        tableColumnMap.get("usysfieldlist").put("record", 6);

        tableColumnMap.put("tbluactivity", new HashMap<String, Integer>());
        tableColumnMap.get("tbluactivity").put("activity", 0);
        tableColumnMap.get("tbluactivity").put("active", 1);
        tableColumnMap.get("tbluactivity").put("showincalendar", 2);
        tableColumnMap.get("tbluactivity").put("showopplink", 3);
        tableColumnMap.get("tbluactivity").put("showhoursworked", 4);
        tableColumnMap.get("tbluactivity").put("alldayevent", 5);
        tableColumnMap.get("tbluactivity").put("type", 6);
        tableColumnMap.get("tbluactivity").put("uselink", 7);
        tableColumnMap.get("tbluactivity").put("linkcaption", 8);
        tableColumnMap.get("tbluactivity").put("caldefault", 9);
        tableColumnMap.get("tbluactivity").put("keep", 10);
        tableColumnMap.get("tbluactivity").put("demodata", 11);
        tableColumnMap.get("tbluactivity").put("delimiter", 12);
        tableColumnMap.get("tbluactivity").put("enclosure", 13);
        tableColumnMap.get("tbluactivity").put("columnnumber", 14);
        tableColumnMap.get("tbluactivity").put("record", 15);

        tableColumnMap.put("usysmailmerge", new HashMap<String, Integer>());
        tableColumnMap.get("usysmailmerge").put("no", 0);
        tableColumnMap.get("usysmailmerge").put("option", 1);
        tableColumnMap.get("usysmailmerge").put("fields", 2);
        tableColumnMap.get("usysmailmerge").put("delimiter", 3);
        tableColumnMap.get("usysmailmerge").put("enclosure", 4);
        tableColumnMap.get("usysmailmerge").put("columnnumber", 5);
        tableColumnMap.get("usysmailmerge").put("record", 6);

        tableColumnMap.put("usyscharttitles", new HashMap<String, Integer>());
        tableColumnMap.get("usyscharttitles").put("chart", 0);
        tableColumnMap.get("usyscharttitles").put("user", 1);
        tableColumnMap.get("usyscharttitles").put("top", 2);
        tableColumnMap.get("usyscharttitles").put("left", 3);
        tableColumnMap.get("usyscharttitles").put("right", 4);
        tableColumnMap.get("usyscharttitles").put("bottom", 5);
        tableColumnMap.get("usyscharttitles").put("delimiter", 6);
        tableColumnMap.get("usyscharttitles").put("enclosure", 7);
        tableColumnMap.get("usyscharttitles").put("columnnumber", 8);
        tableColumnMap.get("usyscharttitles").put("record", 9);

        tableColumnMap.put("usysdefaults", new HashMap<String, Integer>());
        tableColumnMap.get("usysdefaults").put("no", 0);
        tableColumnMap.get("usysdefaults").put("option", 1);
        tableColumnMap.get("usysdefaults").put("value", 2);
        tableColumnMap.get("usysdefaults").put("delimiter", 3);
        tableColumnMap.get("usysdefaults").put("enclosure", 4);
        tableColumnMap.get("usysdefaults").put("columnnumber", 5);
        tableColumnMap.get("usysdefaults").put("record", 6);

        tableColumnMap.put("tblvolareasofinterest", new HashMap<String, Integer>());
        tableColumnMap.get("tblvolareasofinterest").put("areaid", 0);
        tableColumnMap.get("tblvolareasofinterest").put("vid", 1);
        tableColumnMap.get("tblvolareasofinterest").put("areasofinterest", 2);
        tableColumnMap.get("tblvolareasofinterest").put("delimiter", 3);
        tableColumnMap.get("tblvolareasofinterest").put("enclosure", 4);
        tableColumnMap.get("tblvolareasofinterest").put("columnnumber", 5);
        tableColumnMap.get("tblvolareasofinterest").put("record", 6);

        tableColumnMap.put("usysqbfvolgeographicalarea", new HashMap<String, Integer>());
        tableColumnMap.get("usysqbfvolgeographicalarea").put("user", 0);
        tableColumnMap.get("usysqbfvolgeographicalarea").put("geographicalarea", 1);
        tableColumnMap.get("usysqbfvolgeographicalarea").put("delimiter", 2);
        tableColumnMap.get("usysqbfvolgeographicalarea").put("enclosure", 3);
        tableColumnMap.get("usysqbfvolgeographicalarea").put("columnnumber", 4);
        tableColumnMap.get("usysqbfvolgeographicalarea").put("record", 5);

        tableColumnMap.put("usysmailingdefaults", new HashMap<String, Integer>());
        tableColumnMap.get("usysmailingdefaults").put("mailing", 0);
        tableColumnMap.get("usysmailingdefaults").put("option", 1);
        tableColumnMap.get("usysmailingdefaults").put("value", 2);
        tableColumnMap.get("usysmailingdefaults").put("delimiter", 3);
        tableColumnMap.get("usysmailingdefaults").put("enclosure", 4);
        tableColumnMap.get("usysmailingdefaults").put("columnnumber", 5);
        tableColumnMap.get("usysmailingdefaults").put("record", 6);

        tableColumnMap.put("tblvol", new HashMap<String, Integer>());
        tableColumnMap.get("tblvol").put("vid", 0);
        tableColumnMap.get("tblvol").put("firstname", 1);
        tableColumnMap.get("tblvol").put("lastname", 2);
        tableColumnMap.get("tblvol").put("title", 3);
        tableColumnMap.get("tblvol").put("salutation", 4);
        tableColumnMap.get("tblvol").put("address1", 5);
        tableColumnMap.get("tblvol").put("address2", 6);
        tableColumnMap.get("tblvol").put("town", 7);
        tableColumnMap.get("tblvol").put("county", 8);
        tableColumnMap.get("tblvol").put("postcode", 9);
        tableColumnMap.get("tblvol").put("telday", 10);
        tableColumnMap.get("tblvol").put("televening", 11);
        tableColumnMap.get("tblvol").put("fax", 12);
        tableColumnMap.get("tblvol").put("email", 13);
        tableColumnMap.get("tblvol").put("geographicalarea", 14);
        tableColumnMap.get("tblvol").put("howheard", 15);
        tableColumnMap.get("tblvol").put("previouswork", 16);
        tableColumnMap.get("tblvol").put("status", 17);
        tableColumnMap.get("tblvol").put("dob", 18);
        tableColumnMap.get("tblvol").put("gender", 19);
        tableColumnMap.get("tblvol").put("agerange", 20);
        tableColumnMap.get("tblvol").put("employmentstatus", 21);
        tableColumnMap.get("tblvol").put("ethnicity", 22);
        tableColumnMap.get("tblvol").put("religion", 23);
        tableColumnMap.get("tblvol").put("nationality", 24);
        tableColumnMap.get("tblvol").put("disabilitystatus", 25);
        tableColumnMap.get("tblvol").put("driving", 26);
        tableColumnMap.get("tblvol").put("typeofdrivinglicence", 27);
        tableColumnMap.get("tblvol").put("datefirstentered", 28);
        tableColumnMap.get("tblvol").put("datelastupdated", 29);
        tableColumnMap.get("tblvol").put("lastupdatedby", 30);
        tableColumnMap.get("tblvol").put("telfaxsearch", 31);
        tableColumnMap.get("tblvol").put("mobile", 32);
        tableColumnMap.get("tblvol").put("contactable", 33);
        tableColumnMap.get("tblvol").put("webid", 34);
        tableColumnMap.get("tblvol").put("demodata", 35);
        tableColumnMap.get("tblvol").put("delimiter", 36);
        tableColumnMap.get("tblvol").put("enclosure", 37);
        tableColumnMap.get("tblvol").put("columnnumber", 38);
        tableColumnMap.get("tblvol").put("record", 39);

        tableColumnMap.put("tblucorrespondence", new HashMap<String, Integer>());
        tableColumnMap.get("tblucorrespondence").put("correspondence", 0);
        tableColumnMap.get("tblucorrespondence").put("active", 1);
        tableColumnMap.get("tblucorrespondence").put("followupletter", 2);
        tableColumnMap.get("tblucorrespondence").put("templatepath", 3);
        tableColumnMap.get("tblucorrespondence").put("demodata", 4);
        tableColumnMap.get("tblucorrespondence").put("delimiter", 5);
        tableColumnMap.get("tblucorrespondence").put("enclosure", 6);
        tableColumnMap.get("tblucorrespondence").put("columnnumber", 7);
        tableColumnMap.get("tblucorrespondence").put("record", 8);

        tableColumnMap.put("tblorg", new HashMap<String, Integer>());
        tableColumnMap.get("tblorg").put("orgid", 0);
        tableColumnMap.get("tblorg").put("orgenteredid", 1);
        tableColumnMap.get("tblorg").put("name", 2);
        tableColumnMap.get("tblorg").put("address1", 3);
        tableColumnMap.get("tblorg").put("address2", 4);
        tableColumnMap.get("tblorg").put("town", 5);
        tableColumnMap.get("tblorg").put("county", 6);
        tableColumnMap.get("tblorg").put("postcode", 7);
        tableColumnMap.get("tblorg").put("tel1", 8);
        tableColumnMap.get("tblorg").put("fax", 9);
        tableColumnMap.get("tblorg").put("email", 10);
        tableColumnMap.get("tblorg").put("www", 11);
        tableColumnMap.get("tblorg").put("geographicalarea", 12);
        tableColumnMap.get("tblorg").put("directions", 13);
        tableColumnMap.get("tblorg").put("firstname", 14);
        tableColumnMap.get("tblorg").put("lastname", 15);
        tableColumnMap.get("tblorg").put("title", 16);
        tableColumnMap.get("tblorg").put("salutation", 17);
        tableColumnMap.get("tblorg").put("jobtitle", 18);
        tableColumnMap.get("tblorg").put("contacttel1", 19);
        tableColumnMap.get("tblorg").put("contactfax", 20);
        tableColumnMap.get("tblorg").put("contactemail", 21);
        tableColumnMap.get("tblorg").put("contactwww", 22);
        tableColumnMap.get("tblorg").put("mission", 23);
        tableColumnMap.get("tblorg").put("activities", 24);
        tableColumnMap.get("tblorg").put("datefirstentered", 25);
        tableColumnMap.get("tblorg").put("datelastupdated", 26);
        tableColumnMap.get("tblorg").put("lastupdatedby", 27);
        tableColumnMap.get("tblorg").put("contactaddress1", 28);
        tableColumnMap.get("tblorg").put("contactaddress2", 29);
        tableColumnMap.get("tblorg").put("contacttown", 30);
        tableColumnMap.get("tblorg").put("contactcounty", 31);
        tableColumnMap.get("tblorg").put("contactpostcode", 32);
        tableColumnMap.get("tblorg").put("telfaxsearch", 33);
        tableColumnMap.get("tblorg").put("demodata", 34);
        tableColumnMap.get("tblorg").put("delimiter", 35);
        tableColumnMap.get("tblorg").put("enclosure", 36);
        tableColumnMap.get("tblorg").put("columnnumber", 37);
        tableColumnMap.get("tblorg").put("record", 38);

        tableColumnMap.put("usysreports", new HashMap<String, Integer>());
        tableColumnMap.get("usysreports").put("report", 0);
        tableColumnMap.get("usysreports").put("order", 1);
        tableColumnMap.get("usysreports").put("sql", 2);
        tableColumnMap.get("usysreports").put("orientation", 3);
        tableColumnMap.get("usysreports").put("bottommargin", 4);
        tableColumnMap.get("usysreports").put("activereport", 5);
        tableColumnMap.get("usysreports").put("select", 6);
        tableColumnMap.get("usysreports").put("entsql", 7);
        tableColumnMap.get("usysreports").put("actsql", 8);
        tableColumnMap.get("usysreports").put("subreport", 9);
        tableColumnMap.get("usysreports").put("subselect", 10);
        tableColumnMap.get("usysreports").put("subsql", 11);
        tableColumnMap.get("usysreports").put("subentsql", 12);
        tableColumnMap.get("usysreports").put("subactsql", 13);
        tableColumnMap.get("usysreports").put("usespecial", 14);
        tableColumnMap.get("usysreports").put("delimiter", 15);
        tableColumnMap.get("usysreports").put("enclosure", 16);
        tableColumnMap.get("usysreports").put("columnnumber", 17);
        tableColumnMap.get("usysreports").put("record", 18);

        tableColumnMap.put("tblopp", new HashMap<String, Integer>());
        tableColumnMap.get("tblopp").put("oid", 0);
        tableColumnMap.get("tblopp").put("orgid", 1);
        tableColumnMap.get("tblopp").put("oppenteredid", 2);
        tableColumnMap.get("tblopp").put("title", 3);
        tableColumnMap.get("tblopp").put("contact", 4);
        tableColumnMap.get("tblopp").put("address1", 5);
        tableColumnMap.get("tblopp").put("address2", 6);
        tableColumnMap.get("tblopp").put("town", 7);
        tableColumnMap.get("tblopp").put("county", 8);
        tableColumnMap.get("tblopp").put("postcode", 9);
        tableColumnMap.get("tblopp").put("tel1", 10);
        tableColumnMap.get("tblopp").put("fax", 11);
        tableColumnMap.get("tblopp").put("email", 12);
        tableColumnMap.get("tblopp").put("geographicalarea", 13);
        tableColumnMap.get("tblopp").put("monetaryvalue", 14);
        tableColumnMap.get("tblopp").put("active", 15);
        tableColumnMap.get("tblopp").put("includeonweb", 16);
        tableColumnMap.get("tblopp").put("oneoff", 17);
        tableColumnMap.get("tblopp").put("includevbaddress", 18);
        tableColumnMap.get("tblopp").put("oppstartdate", 19);
        tableColumnMap.get("tblopp").put("oppenddate", 20);
        tableColumnMap.get("tblopp").put("description", 21);
        tableColumnMap.get("tblopp").put("skillsqualifications", 22);
        tableColumnMap.get("tblopp").put("directions", 23);
        tableColumnMap.get("tblopp").put("datefirstentered", 24);
        tableColumnMap.get("tblopp").put("datelastupdated", 25);
        tableColumnMap.get("tblopp").put("lastupdatedby", 26);
        tableColumnMap.get("tblopp").put("useorgcontact", 27);
        tableColumnMap.get("tblopp").put("telfaxsearch", 28);
        tableColumnMap.get("tblopp").put("virtualvol", 29);
        tableColumnMap.get("tblopp").put("residential", 30);
        tableColumnMap.get("tblopp").put("specificstartdate", 31);
        tableColumnMap.get("tblopp").put("specificenddate", 32);
        tableColumnMap.get("tblopp").put("shortdescription", 33);
        tableColumnMap.get("tblopp").put("demodata", 34);
        tableColumnMap.get("tblopp").put("delimiter", 35);
        tableColumnMap.get("tblopp").put("enclosure", 36);
        tableColumnMap.get("tblopp").put("columnnumber", 37);
        tableColumnMap.get("tblopp").put("record", 38);

        tableColumnMap.put("usysqbfoppareasofinterest", new HashMap<String, Integer>());
        tableColumnMap.get("usysqbfoppareasofinterest").put("user", 0);
        tableColumnMap.get("usysqbfoppareasofinterest").put("areasofinterest", 1);
        tableColumnMap.get("usysqbfoppareasofinterest").put("delimiter", 2);
        tableColumnMap.get("usysqbfoppareasofinterest").put("enclosure", 3);
        tableColumnMap.get("usysqbfoppareasofinterest").put("columnnumber", 4);
        tableColumnMap.get("usysqbfoppareasofinterest").put("record", 5);

        tableColumnMap.put("tblunationality", new HashMap<String, Integer>());
        tableColumnMap.get("tblunationality").put("nationality", 0);
        tableColumnMap.get("tblunationality").put("active", 1);
        tableColumnMap.get("tblunationality").put("demodata", 2);
        tableColumnMap.get("tblunationality").put("delimiter", 3);
        tableColumnMap.get("tblunationality").put("enclosure", 4);
        tableColumnMap.get("tblunationality").put("columnnumber", 5);
        tableColumnMap.get("tblunationality").put("record", 6);

        tableColumnMap.put("usyslogo", new HashMap<String, Integer>());
        tableColumnMap.get("usyslogo").put("logo", 0);
        tableColumnMap.get("usyslogo").put("delimiter", 1);
        tableColumnMap.get("usyslogo").put("enclosure", 2);
        tableColumnMap.get("usyslogo").put("columnnumber", 3);
        tableColumnMap.get("usyslogo").put("record", 4);

        tableColumnMap.put("tbluareasofinterest", new HashMap<String, Integer>());
        tableColumnMap.get("tbluareasofinterest").put("areasofinterest", 0);
        tableColumnMap.get("tbluareasofinterest").put("active", 1);
        tableColumnMap.get("tbluareasofinterest").put("demodata", 2);
        tableColumnMap.get("tbluareasofinterest").put("delimiter", 3);
        tableColumnMap.get("tbluareasofinterest").put("enclosure", 4);
        tableColumnMap.get("tbluareasofinterest").put("columnnumber", 5);
        tableColumnMap.get("tbluareasofinterest").put("record", 6);

        tableColumnMap.put("tblmailingslist", new HashMap<String, Integer>());
        tableColumnMap.get("tblmailingslist").put("mid", 0);
        tableColumnMap.get("tblmailingslist").put("mailing", 1);
        tableColumnMap.get("tblmailingslist").put("vid", 2);
        tableColumnMap.get("tblmailingslist").put("oid", 3);
        tableColumnMap.get("tblmailingslist").put("orgid", 4);
        tableColumnMap.get("tblmailingslist").put("emailpreference", 5);
        tableColumnMap.get("tblmailingslist").put("delimiter", 6);
        tableColumnMap.get("tblmailingslist").put("enclosure", 7);
        tableColumnMap.get("tblmailingslist").put("columnnumber", 8);
        tableColumnMap.get("tblmailingslist").put("record", 9);

        tableColumnMap.put("usysqbfoppsuitability", new HashMap<String, Integer>());
        tableColumnMap.get("usysqbfoppsuitability").put("user", 0);
        tableColumnMap.get("usysqbfoppsuitability").put("id", 1);
        tableColumnMap.get("usysqbfoppsuitability").put("suitability", 2);
        tableColumnMap.get("usysqbfoppsuitability").put("delimiter", 3);
        tableColumnMap.get("usysqbfoppsuitability").put("enclosure", 4);
        tableColumnMap.get("usysqbfoppsuitability").put("columnnumber", 5);
        tableColumnMap.get("usysqbfoppsuitability").put("record", 6);

        tableColumnMap.put("tblopptypeofactivity", new HashMap<String, Integer>());
        tableColumnMap.get("tblopptypeofactivity").put("actid", 0);
        tableColumnMap.get("tblopptypeofactivity").put("oid", 1);
        tableColumnMap.get("tblopptypeofactivity").put("typeofactivity", 2);
        tableColumnMap.get("tblopptypeofactivity").put("delimiter", 3);
        tableColumnMap.get("tblopptypeofactivity").put("enclosure", 4);
        tableColumnMap.get("tblopptypeofactivity").put("columnnumber", 5);
        tableColumnMap.get("tblopptypeofactivity").put("record", 6);

        tableColumnMap.put("usyspivots", new HashMap<String, Integer>());
        tableColumnMap.get("usyspivots").put("id", 0);
        tableColumnMap.get("usyspivots").put("pivot", 1);
        tableColumnMap.get("usyspivots").put("row", 2);
        tableColumnMap.get("usyspivots").put("column", 3);
        tableColumnMap.get("usyspivots").put("data", 4);
        tableColumnMap.get("usyspivots").put("sql", 5);
        tableColumnMap.get("usyspivots").put("select", 6);
        tableColumnMap.get("usyspivots").put("entsql", 7);
        tableColumnMap.get("usyspivots").put("actsql", 8);
        tableColumnMap.get("usyspivots").put("delimiter", 9);
        tableColumnMap.get("usyspivots").put("enclosure", 10);
        tableColumnMap.get("usyspivots").put("columnnumber", 11);
        tableColumnMap.get("usyspivots").put("record", 12);

        TABLE_COLUMN_MAP = Collections.unmodifiableMap(tableColumnMap);
    }

    public static void main(String[] args) {

        if (args.length > 0) {
            File accessDBFile = new File(args[0]);
            BufferedWriter fileOutWriter = null;

            Migratable migratable = null;

            try {
                Database accessDatabase = Database.open(accessDBFile);
                Set<String> tableNames = accessDatabase.getTableNames();

                File outputDir = new File(OUTPUT_DIR);
                if (!outputDir.isDirectory()) outputDir.mkdir();

                outputDir = new File(OUTPUT_DIR + "/" + CSV_DIR);
                if (!outputDir.isDirectory()) outputDir.mkdir();

                outputDir = new File(OUTPUT_DIR + "/" + SQL_DIR);
                if (!outputDir.isDirectory()) outputDir.mkdir();

                outputDir = new File(OUTPUT_DIR + "/" + SQL_DIR + "/" + SQL_PRE);
                if (!outputDir.isDirectory()) outputDir.mkdir();

                outputDir = new File(OUTPUT_DIR + "/" + SQL_DIR + "/" + SQL_POST);
                if (!outputDir.isDirectory()) outputDir.mkdir();

                outputDir = new File(OUTPUT_DIR + "/" + LOGS_DIR);
                if (!outputDir.isDirectory()) outputDir.mkdir();

                outputDir = new File(OUTPUT_DIR + "/" + JAVA_DIR);
                if (!outputDir.isDirectory()) outputDir.mkdir();

                outputDir = new File(OUTPUT_DIR + "/" + MIGRATED_DIR);
                if (!outputDir.isDirectory()) outputDir.mkdir();

                System.out.println("Tables:");

                for (String tableName : tableNames) {
                    Table table = accessDatabase.getTable(tableName);
                    System.out.println("    Processing table: " + tableName
                            + " Number of rows: " + table.getRowCount());


                    fileOutWriter = new BufferedWriter(new FileWriter(OUTPUT_DIR + "/" + tableName + ".ctl"));
                    fileOutWriter.write(generateCTLString(table));
                    fileOutWriter.flush();
                    fileOutWriter.close();

                    fileOutWriter = new BufferedWriter(new FileWriter(OUTPUT_DIR + "/" + SQL_DIR + "/" + SQL_PRE
                            + "/create" + tableName + ".sql"));
                    fileOutWriter.write(generateSQLCreateString(table));
                    fileOutWriter.flush();
                    fileOutWriter.close();

                    fileOutWriter = new BufferedWriter(new FileWriter(OUTPUT_DIR + "/" + JAVA_DIR + "/"
                            + JavaCodeUtil.toUpperFirst(tableName) + ".java"));
                    fileOutWriter.write(generateJavaClass(table));
                    fileOutWriter.flush();
                    fileOutWriter.close();

                    fileOutWriter = new BufferedWriter(new FileWriter(OUTPUT_DIR + "/" + CSV_DIR + "/" + tableName
                            + ".csv"));
                    outputRowCSVString(table, fileOutWriter);
                    fileOutWriter.flush();
                    fileOutWriter.close();
                }

                fileOutWriter = new BufferedWriter(new FileWriter(OUTPUT_DIR + "/" + SQL_DIR + "/" + SQL_PRE
                        + "/dropTables.sql"));
                fileOutWriter.write(generateSQLDropString(accessDatabase));
                fileOutWriter.flush();
                fileOutWriter.close();

                fileOutWriter = new BufferedWriter(new FileWriter(OUTPUT_DIR + "/" + SQL_DIR + "/" + SQL_PRE
                        + "/runTableCreates.sh"));
                fileOutWriter.write(generateSQLCreateRunScript(accessDatabase));
                fileOutWriter.flush();
                fileOutWriter.close();

                fileOutWriter = new BufferedWriter(new FileWriter(OUTPUT_DIR + "/" + SQL_DIR + "/" + SQL_PRE
                        + "/runTableDops.sh"));
                fileOutWriter.write(generateSQLDropRunScript());
                fileOutWriter.flush();
                fileOutWriter.close();

                fileOutWriter = new BufferedWriter(new FileWriter(OUTPUT_DIR + "/runSQLLoader.sh"));
                fileOutWriter.write(generateSQLLoaderRunScript(accessDatabase));
                fileOutWriter.flush();
                fileOutWriter.close();

                System.out.println("Migrating lookups.");
                migratable = new LookupsMigration();
                migratable.migrate(OUTPUT_DIR + "/" + CSV_DIR + "/", OUTPUT_DIR + "/" + MIGRATED_DIR + "/");

                Map<String, Map<String, Lookups>> lookupsMap =
                        CSVUtil.createDiscriminatorValueMap(OUTPUT_DIR + "/" + MIGRATED_DIR +
                                "/Lookups.csv", Lookups.class);

                System.out.println("Migrating volunteers.");
                migratable = new VolunteersMigration(lookupsMap);
                migratable.migrate(OUTPUT_DIR + "/" + CSV_DIR + "/", OUTPUT_DIR + "/" + MIGRATED_DIR + "/");

                System.out.println("Migrating organisation.");
                migratable = new OrganisationsMigration(lookupsMap);
                migratable.migrate(OUTPUT_DIR + "/" + CSV_DIR + "/", OUTPUT_DIR + "/" + MIGRATED_DIR + "/");

                System.out.println("Migrating organisation.");
                migratable = new OrganisationVuoMigration(lookupsMap);
                migratable.migrate(OUTPUT_DIR + "/" + CSV_DIR + "/", OUTPUT_DIR + "/" + MIGRATED_DIR + "/");

                System.out.println("Migrating opportunities.");
                migratable = new OpportunitiesMigration(lookupsMap);
                migratable.migrate(OUTPUT_DIR + "/" + CSV_DIR + "/", OUTPUT_DIR + "/" + MIGRATED_DIR + "/");

                System.out.println("Migrating activity logs.");
                migratable = new ActivityLogsMigration(lookupsMap);
                migratable.migrate(OUTPUT_DIR + "/" + CSV_DIR + "/", OUTPUT_DIR + "/" + MIGRATED_DIR + "/");

            } catch (IOException e) {
                System.out.println("Error processing the ms access file.\n Error: " + e.getMessage());
            } finally {
                if (fileOutWriter != null) {
                    try {
                        fileOutWriter.close();
                    } catch (IOException e) {
                        System.out.println("Failed to close the file output stream: " + e.getMessage());
                    }
                }
            }
        } else {
            System.out.println("Usage: Smasher <path to access file>");
        }
    }

    private static String generateSQLCreateRunScript(Database database) {
        StringBuffer columnStringBuffer = new StringBuffer();
        Set<String> tableNames = database.getTableNames();

        columnStringBuffer.append("if [ -n $1 -a -n $2 ]; then\n");

        for (String tableName : tableNames) {
            columnStringBuffer.append(" echo \"Processing: ");
            columnStringBuffer.append(tableName);
            columnStringBuffer.append("\"\n sqlplus -S $1/$2@oradb.dev.thesite.org.uk:1521/oradev @create");
            columnStringBuffer.append(tableName);
            columnStringBuffer.append(".sql\n\n");
        }

        columnStringBuffer.append("else\n   echo \"Usage: $0 <username> <password>\"\nfi\n");

        return columnStringBuffer.toString();
    }

    private static String generateSQLDropRunScript() {
        StringBuffer columnStringBuffer = new StringBuffer();

        columnStringBuffer.append("if [ -n $1 -a -n $2 ]; then\n");

        columnStringBuffer.append(" sqlplus -S $1/$2@oradb.dev.thesite.org.uk:1521/oradev @dropTables.sql\n");

        columnStringBuffer.append("else\n   echo \"Usage: $0 <username> <password>\"\nfi\n");

        return columnStringBuffer.toString();
    }

    private static String generateSQLLoaderRunScript(Database database) {
        StringBuffer columnStringBuffer = new StringBuffer();
        Set<String> tableNames = database.getTableNames();

        columnStringBuffer.append("if [ -n $1 -a -n $2 ]; then\n");

        int count = 1;
        for (String tableName : tableNames) {
            columnStringBuffer.append("echo \"Processing: ");
            columnStringBuffer.append(tableName);
            columnStringBuffer.append("\" && sqlldr $1/$2@oradb.dev.thesite.org.uk:1521/oradev control=");
            columnStringBuffer.append(tableName);
            columnStringBuffer.append(".ctl rows=5000 > ");
            columnStringBuffer.append(LOGS_DIR);
            columnStringBuffer.append("/");
            columnStringBuffer.append(tableName);
            columnStringBuffer.append(".process.log");

            if ((count % 4) == 0) columnStringBuffer.append(" && date&\n\n");
            else columnStringBuffer.append(" && ");

            count++;
        }

        columnStringBuffer.replace(columnStringBuffer.length() - 3, columnStringBuffer.length(), "");

        columnStringBuffer.append("\nelse\n   echo \"Usage: $0 <username> <password>\"\nfi\n");

        return columnStringBuffer.toString();
    }

    private static String generateCTLString(Table table) {
        StringBuffer columnStringBuffer = new StringBuffer();
        String tableName = table.getName();

        columnStringBuffer.append("load data\n");
        columnStringBuffer.append(" infile \"");
        columnStringBuffer.append(CSV_DIR);
        columnStringBuffer.append("/");
        columnStringBuffer.append(tableName);
        columnStringBuffer.append(".csv\" \"str '|\\n'\"\n");
        columnStringBuffer.append(" into table ");
        columnStringBuffer.append(tableName);
        columnStringBuffer.append("\n fields terminated by '\\|' optionally enclosed by '¬' TRAILING NULLCOLS\n (\n");

        for (Column column : table.getColumns()) {

            try {
                switch (column.getSQLType()) {
                    case Types.LONGVARCHAR: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        columnStringBuffer.append(" CHAR(40000)");
                        break;
                    }
                    case Types.VARCHAR: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        columnStringBuffer.append(" CHAR(");
                        columnStringBuffer.append(column.getLength());
                        columnStringBuffer.append(")");
                        break;
                    }
                    case Types.TIMESTAMP: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        columnStringBuffer.append(" TIMESTAMP 'yyyy-mm-dd HH24:MI:SS.FF1'");
                        break;
                    }
                    default: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        break;
                    }
                }
            } catch (SQLException e) {
                System.out.println("        -- Error  could not get type for " + column.getName().toLowerCase()
                        + " name. Error: " + e.getMessage());
            }

            columnStringBuffer.append(",\n");
        }

        columnStringBuffer.replace(columnStringBuffer.length() - 2, columnStringBuffer.length(), "");
        columnStringBuffer.append(")");

        return columnStringBuffer.toString();
    }

    private static String generateVB3CTLString(String tableName, List<String[]> columns) {
        StringBuffer columnStringBuffer = new StringBuffer();

        columnStringBuffer.append("load data\n");
        columnStringBuffer.append(" infile \"");
        columnStringBuffer.append(CSV_DIR);
        columnStringBuffer.append("/");
        columnStringBuffer.append(tableName);
        columnStringBuffer.append(".csv\" \"str '|\\n'\"\n");
        columnStringBuffer.append(" into table ");
        columnStringBuffer.append(tableName);
        columnStringBuffer.append("\n fields terminated by '\\|' optionally enclosed by '¬' TRAILING NULLCOLS\n (\n");

        for (String[] column : columns) {

            if (column[1].equals("String")) {
                columnStringBuffer.append(column[0].toLowerCase());
                columnStringBuffer.append("_");
                columnStringBuffer.append(" CHAR");
            } else if (column[1].equals("Timestamp")) {
                columnStringBuffer.append(column[0].toLowerCase());
                columnStringBuffer.append("_");
                columnStringBuffer.append(" TIMESTAMP 'yyyy-mm-dd HH24:MI:SS.FF1'");
            } else if (column[1].equals("UUID")) {
                columnStringBuffer.append(column[0].toLowerCase());
                columnStringBuffer.append("_");
                columnStringBuffer.append(" RAW(16)");
            } else {
                columnStringBuffer.append(column[0].toLowerCase());
                columnStringBuffer.append("_");
            }

            columnStringBuffer.append(",\n");
        }

        columnStringBuffer.replace(columnStringBuffer.length() - 2, columnStringBuffer.length(), "");
        columnStringBuffer.append(")");

        return columnStringBuffer.toString();
    }

    private static String generateSQLCreateString(Table table) {
        StringBuffer columnStringBuffer = new StringBuffer();
        String tableName = table.getName();

        columnStringBuffer.append("CREATE TABLE ");
        columnStringBuffer.append(tableName);
        columnStringBuffer.append(" (\n");

        for (Column column : table.getColumns()) {

            try {
                switch (column.getSQLType()) {
                    case Types.SMALLINT: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        columnStringBuffer.append(" SMALLINT");
                        break;
                    }
                    case Types.INTEGER: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        columnStringBuffer.append(" NUMBER");
                        break;
                    }
                    case Types.NUMERIC: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        columnStringBuffer.append(" NUMERIC");
                        break;
                    }
                    case Types.BOOLEAN: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        columnStringBuffer.append(" NUMBER(1,0)");
                        break;
                    }
                    case Types.LONGVARCHAR: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        columnStringBuffer.append(" CLOB");
                        break;
                    }
                    case Types.VARCHAR: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        columnStringBuffer.append(" VARCHAR2(");
                        columnStringBuffer.append(column.getLength());
                        columnStringBuffer.append(")");
                        break;
                    }
                    case Types.TIMESTAMP: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        columnStringBuffer.append(" TIMESTAMP");
                        break;
                    }
                }
            } catch (SQLException e) {
                System.out.println("        -- Error  could not get type for " + column.getName().toLowerCase()
                        + " name. Error: " + e.getMessage());
            }

            columnStringBuffer.append(",\n");
        }

        columnStringBuffer.replace(columnStringBuffer.length() - 2, columnStringBuffer.length(), "");
        columnStringBuffer.append("\n);\nQUIT;");

        return columnStringBuffer.toString();
    }

    private static String generateSQLDropString(Database database) {
        StringBuffer columnStringBuffer = new StringBuffer();
        Set<String> tableNames = database.getTableNames();

        for (String tableName : tableNames) {
            columnStringBuffer.append("DROP TABLE ");
            columnStringBuffer.append(tableName);
            columnStringBuffer.append(";\n");
        }

        columnStringBuffer.append("\nQUIT;");

        return columnStringBuffer.toString();
    }

    private static String generateSQLDeleteString(Database database) {
        StringBuffer columnStringBuffer = new StringBuffer();
        Set<String> tableNames = database.getTableNames();

        for (String tableName : tableNames) {
            columnStringBuffer.append("DELETE FROM ");
            columnStringBuffer.append(tableName);
            columnStringBuffer.append(";\n");
        }

        columnStringBuffer.append("\nQUIT;");

        return columnStringBuffer.toString();
    }

    private static String generateJavaClass(Table table) {
        StringBuffer classStringBuffer = new StringBuffer("package org.youthnet.export.domain.vb25;\n\n");
        String tableName = table.getName();
        Set<String> imports = new HashSet<String>(); // Set to hold any imports that might be needed.
        boolean hasDates = false; // Flag to be set if the class contains date types.
        boolean hasVid = false; // Flag to be set if the class contains a vid attribute.
        boolean hasOid = false; // Flag to be set if the class contains a vid attribute.
        boolean hasOrgid = false; // Flag to be set if the class contains a vid attribute.
        // Get the name for the new java class. This will be the tale name with the first letter capitalised.
        String className = JavaCodeUtil.toUpperFirst(tableName);
        List<Column> columns = table.getColumns(); // List to contain the tables columns.
        // Get the number of attributes that the java class, this is equal to the number of columns since that is what they will be made from.
        int attributeNum = columns.size();
        // Create a 2D array to hold the attribute names and related types.
        // This is only every going to be iterated through so it can be a simple 2D array.
        String[][] attributes = new String[attributeNum][2];

        // Populate the attributes array with the names and types for the new java classes attributes..
        String name = ""; // Variable to hold the name of the java attribute.
        Class type = null; // Variable to hold the java type of the attribute.
        String[] typePath = null; // Array to hold the package path and class name of the java type.
        for (int i = 0; i < attributeNum; i++) {
            // Record the column name lower cased fo the attribute name.
            name = columns.get(i).getName().toLowerCase();
            if (name.equals("vid") && !hasVid) hasVid = true; // Record if this class contains a vid.
            if (name.equals("oid") && !hasOid) hasOid = true; // Record if this class contains an oid.
            if (name.equals("orgid") && !hasOrgid) hasOrgid = true; // Record if this class contains an orgid.
            // If the attribute represents a java keyword append an '_' to the start.
            if (JavaCodeUtil.isKeyword(name)) name = "_" + name;
            attributes[i][0] = name;
            try {
                type = JavaCodeUtil.javaTypeForSQLType(columns.get(i).getSQLType()); // Record the java type of the attribute.
                if (!type.getName().contains("lang")) { // If the attribute type is not a default Java type...
                    imports.add("import " + type.getName() + ";");
                    if (type.getSuperclass().getSimpleName().equals("Date") && !hasDates) hasDates = true;
                }
                attributes[i][1] = type.getSimpleName();
            } catch (SQLException e) {
                System.out.println("Could not get SQL type for for column " + attributes[i][0] + " in table "
                        + tableName + ". Error: " + e.getMessage());
            }
        }


        // Add the imports.
        classStringBuffer.append("import org.youthnet.export.domain.CSVable;\n\n");
        for (String imp : imports) {
            classStringBuffer.append(imp);
            classStringBuffer.append("\n");
        }
        classStringBuffer.append("import java.util.List;\n");
        classStringBuffer.append("import java.util.ArrayList;\n");

        // If there are date classes within the imports then also import the classes required to pars dates.
        if (hasDates) {
            classStringBuffer.append("import java.text.ParseException;\nimport java.text.SimpleDateFormat;\n");
        }
        classStringBuffer.append("\n\n");

        // Add the class name and constants.
        classStringBuffer.append("public class ");
        classStringBuffer.append(className);
        classStringBuffer.append(" implements CSVable");
        if (hasVid)
            classStringBuffer.append(", ContainsVid"); // If this class contains a vid implement the supporting interface.
        if (hasOid)
            classStringBuffer.append(", ContainsOid"); // If this class contains an Oid implement the supporting interface.
        if (hasOrgid)
            classStringBuffer.append(", ContainsOrgid"); // If this class contains an Orgid implement the supporting interface.
        classStringBuffer.append(" {\n\n\tprivate char delimiter = '");
        classStringBuffer.append(CSV_DELIMITER);
        classStringBuffer.append("';\n");
        classStringBuffer.append("\tprivate char enclosure = '");
        classStringBuffer.append(CSV_ENCLOSURE);
        classStringBuffer.append("';\n\n");
        classStringBuffer.append("\tpublic static final int COLUMN_NUM = ");
        classStringBuffer.append(attributeNum);
        classStringBuffer.append(";\n\n");
        classStringBuffer.append("\tprivate List<String[]> columnNames = null;\n\n");
        classStringBuffer.append("\tprivate StringBuffer record = new StringBuffer();\n\n");

        StringBuffer initAttributesStringBuffer = new StringBuffer();
        // Add the attributes and create the code that will be used to initialise the attributes..
        for (int i = 0; i < attributes.length; i++) {
            classStringBuffer.append("\tprivate ");
            classStringBuffer.append(attributes[i][1]);
            classStringBuffer.append(" ");
            classStringBuffer.append(attributes[i][0]);
            classStringBuffer.append(";\n");

            if (attributes[i][1].equals("Short")) {
                initAttributesStringBuffer.append("\t\tthis.");
                initAttributesStringBuffer.append(attributes[i][0]);
                initAttributesStringBuffer.append(" = (fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\").equals(\"\")) ? null : Short.valueOf(fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\"));\n");
            }

            if (attributes[i][1].equals("Integer")) {
                initAttributesStringBuffer.append("\t\t\tthis.");
                initAttributesStringBuffer.append(attributes[i][0]);
                initAttributesStringBuffer.append(" = (fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\").equals(\"\")) ? null : Integer.valueOf(fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\"));\n");
            }

            if (attributes[i][1].equals("Long")) {
                initAttributesStringBuffer.append("\t\tthis.");
                initAttributesStringBuffer.append(attributes[i][0]);
                initAttributesStringBuffer.append(" = (fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\").equals(\"\")) ? null : Long.valueOf(fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\"));\n");
            }

            if (attributes[i][1].equals("BigDecimal")) {
                initAttributesStringBuffer.append("\t\ttry{\n\t\t\tthis.");
                initAttributesStringBuffer.append(attributes[i][0]);
                initAttributesStringBuffer.append(" = (fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\").equals(\"\")) ? null : new BigDecimal(fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\"));\n\t\t} catch (NumberFormatException e) {\n\t\t\t");
                initAttributesStringBuffer.append("System.out.println(\"Could not pars ");
                initAttributesStringBuffer.append(attributes[i][0]);
                initAttributesStringBuffer.append(" BigDecimal \" + fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].substring(1, fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].length() - 1)\n\t\t\t\t+ \" in row \" + this.");
                initAttributesStringBuffer.append(attributes[0][0]);
                initAttributesStringBuffer.append("+ \" for table \" + this.getClass().getName() + \". Error: \"");
                initAttributesStringBuffer.append("+ e.getMessage());\n\t\t}\n");
            }

            if (attributes[i][1].equals("String")) {
                initAttributesStringBuffer.append("\t\tthis.");
                initAttributesStringBuffer.append(attributes[i][0]);
                initAttributesStringBuffer.append(" = fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\");\n");
            }

            if (attributes[i][1].equals("Boolean")) {
                initAttributesStringBuffer.append("\t\tthis.");
                initAttributesStringBuffer.append(attributes[i][0]);
                initAttributesStringBuffer.append(" = fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\").equals(\"1\");\n");
            }

            if (attributes[i][1].equals("Date")
                    || attributes[i][1].equals("Time")
                    || attributes[i][1].equals("Timestamp")) {
                initAttributesStringBuffer.append("\t\ttry {\n\t\t\tthis.");
                initAttributesStringBuffer.append(attributes[i][0]);
                initAttributesStringBuffer.append(" = (fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\").equals(\"\")) ? null : new ");
                initAttributesStringBuffer.append(attributes[i][1]);
                initAttributesStringBuffer.append("(\n\t\t\t\tsimpleDateFormat.parse(fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\")).getTime());\n\t\t} catch (ParseException e) {\n");
                initAttributesStringBuffer.append("\t\t\tSystem.out.println(\"Could not pars ");
                initAttributesStringBuffer.append(attributes[i][0]);
                initAttributesStringBuffer.append(" ");
                initAttributesStringBuffer.append(attributes[i][1]);
                initAttributesStringBuffer.append(" \" + fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\")\n\t\t\t\t+ \" in row \" + this.");
                initAttributesStringBuffer.append(attributes[0][0]);
                initAttributesStringBuffer.append("+ \" for table \" + this.getClass().getName() + \". Error: \"");
                initAttributesStringBuffer.append("+ e.getMessage());\n\t\t}\n");
            }
        }
        classStringBuffer.append("\n\n");

        // Add the constructors.
        classStringBuffer.append("\tpublic ");
        classStringBuffer.append(className);
        classStringBuffer.append("() {}\n\n");
        classStringBuffer.append("\tpublic ");
        classStringBuffer.append(className);
        classStringBuffer.append("(String record) {\n\t\tinit(record);\n\t}\n\n");

        // Add the init method.
        classStringBuffer.append("\tpublic void init(String record) {\n\t\tString[] fields = record.split(\"\\\\\" + String.valueOf(this.delimiter));\n");
        if (hasDates) { // If there are date attributes then a date formatter will be needed.
            classStringBuffer.append("\t\tSimpleDateFormat simpleDateFormat = new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss.S\");\n\n");
        } else classStringBuffer.append("\n\n");

        // Add the initialisation code string.
        classStringBuffer.append(initAttributesStringBuffer);
        classStringBuffer.append("\t}\n\n");

        // Add getter methods.
        for (String[] attribute : attributes) {
            classStringBuffer.append("\tpublic ");
            classStringBuffer.append(attribute[1]);
            classStringBuffer.append(" get");
            classStringBuffer.append(JavaCodeUtil.toUpperFirst(attribute[0].replace("_", "")));
            classStringBuffer.append("() {\n\t\treturn this.");
            classStringBuffer.append(attribute[0]);
            classStringBuffer.append(";\n\t}\n\n");
        }

        // Add the delimiter getter/setter.
        classStringBuffer.append("\tpublic char getDelimiter() {\n\t\treturn this.delimiter;\n\t}\n\n");
        classStringBuffer.append("\tpublic void setDelimiter(char delimiter) {\n\t\tthis.delimiter = delimiter;\n\t}\n\n");

        // Add the delimiter getter/setter.
        classStringBuffer.append("\tpublic char getEnclosure() {\n\t\treturn this.enclosure;\n\t}\n\n");
        classStringBuffer.append("\tpublic void setEnclosure(char enclosure) {\n\t\tthis.enclosure = enclosure;\n\t}\n\n");

        // Add column number getter.
        classStringBuffer.append("\tpublic Integer getColumnNumber() {\n\t\treturn COLUMN_NUM;\n\t}\n\n");

        // Add column name getter.
        classStringBuffer.append("\tpublic List<String[]> getColumnNames() {\n\t\tif (this.columnNames == null) {\n\t\t\tcolumnNames = new ArrayList<String[]>();\n");
        for (Column column : columns) {
            classStringBuffer.append("\t\t\tcolumnNames.add(new String[]{\"");
            classStringBuffer.append(column.getName());
            classStringBuffer.append(", ");
            try {
                classStringBuffer.append(JavaCodeUtil.javaTypeForSQLType(column.getSQLType()).getSimpleName());
            } catch (SQLException e) {
                System.out.println("Could not get SQL type for for column " + column.getName() + " in table "
                        + tableName + ". Error: " + e.getMessage());
            }
            classStringBuffer.append("\"});\n");
        }
        classStringBuffer.append("\t\t}\n\n");
        classStringBuffer.append("\t\treturn columnNames;");
        classStringBuffer.append("\t}\n\n");

        // Add column name getter.
        classStringBuffer.append("\tpublic String getRecord() {\n\t\trecord.setLength(0);\n\n");
        for (String[] attribute : attributes) {
            classStringBuffer.append("\t\trecord.append(this.enclosure);\n");
            classStringBuffer.append("\t\trecord.append(this.");
            if (attribute[1].equals("Boolean")) {
                classStringBuffer.append(attribute[0]);
                classStringBuffer.append(" != null && ");
                classStringBuffer.append(attribute[0]);
                classStringBuffer.append(" ? 1 : 0");
            } else {
                classStringBuffer.append(attribute[0]);
                classStringBuffer.append(" == null ? \"\" : this.");
                classStringBuffer.append(attribute[0]);
            }
            classStringBuffer.append(");\n\t\trecord.append(this.enclosure);\n");
            classStringBuffer.append("\t\trecord.append(this.delimiter);\n");
        }
        classStringBuffer.append("\n\t\treturn record.toString();");
        classStringBuffer.append("\n\t}\n");

        // Close off class.
        classStringBuffer.append("}\n");

        return classStringBuffer.toString();
    }

    private static boolean outputRowCSVString(Table table, BufferedWriter bufferedWriter) {
        List<Column> columns = table.getColumns(); // Get the tables column names.
        StringBuffer rowStringBuffer = null; // String buffer to hold the rows.
        String[] values = new String[table.getColumnCount()]; // An array to hold the values of each row in the correct order.
        // An array to hold the index that each value should be placed into the values array.
        int[] indexs = new int[table.getColumnCount()];

        int n = 0;
        for (Column column : columns) {
            try {
                System.out.println("        -- Column name: " + column.getName().toLowerCase()
                        + " length: " + column.getLength() + " type: " + SQLCodeUtil.getSQLTypeName(column.getSQLType()));
            } catch (SQLException e) {
                System.out.println("        -- Error could not get type for (" + column.getName().toLowerCase()
                        + ") name. Error: " + e.getMessage());
            }

            // Build the column index array for this table. If we ever come across a column we do not recognise set the index to -1 to indicate
            // that it should not be used.
            if (TABLE_COLUMN_MAP.get(table.getName().toLowerCase()).get(column.getName().toLowerCase()) != null) {
                indexs[n] = TABLE_COLUMN_MAP.get(table.getName().toLowerCase()).get(column.getName().toLowerCase());
            } else {
                indexs[n] = -1;
                System.out.println("        -- Error an unrecognised column " + column.getName().toLowerCase()
                        + " was found in the " + table.getName() + " table.");
            }
            n++;
        }

        Object id = null; // Variable to hold the id of the row that is being processed.

        Map<String, Object> row = null; // Map to hold the data of the row that has been exctracted from the access table.
        Column column = null; // Variable to hold the data for the column that is being processed.
        for (int i = 0; i < table.getRowCount(); i++) { // Iterate through the rows.
            try {
                row = table.getNextRow(); // Get the next row.

                if (row != null) { // If the row is null don't bother doing anything and move to the next one.

                    for (int j = 0; j < columns.size(); j++) { // Iterate through the columns in this row.
                        // Create a new string buffer for each value so that it's memory footprint is as small as possible to begin with.
                        // Also hopefully the previous string buffer will be garbage collected...
                        rowStringBuffer = new StringBuffer();

                        column = columns.get(j); // Get the next column.
                        Object value = row.get(column.getName()); // Get the value that is related to that column.

                        // If this is the first column assume it is the id and record it for logging.
                        if (j == 0) id = value;

                        rowStringBuffer.append(CSV_ENCLOSURE); // Add an enclosing character to the start of the value.

                        if (value != null) { // If the value is null then don't bother trying to process it.
                            if (value instanceof String) { // The value is a string...
                                String valueString = (String) value; // Cast the value to a string so it's easier to work with.

                                // Check to see if it is an Activity log notes string...
                                if (table.getName().equals("tblActivityLog") && column.getName().equals("Notes")) {
                                    value = extractTextFromRTFNotes(value); // ...if it is extract the plain text from it.
                                    // If the text has successfully been extracted place it into the valueString.
                                    if (value != null) valueString = (String) value;
                                }

                                valueString = valueString.trim(); // Trim the string to remove any surrounding spaces.

                                valueString = StringEscapeUtils.escapeSql(valueString); // Sanitize the string.

                                // Make sure that neither the enclosing or delimiting characters are in the string.
                                valueString = valueString.replaceAll(String.valueOf(CSV_ENCLOSURE), "[[ENCL]]");
                                valueString = valueString.replaceAll("\\" + CSV_DELIMITER, "[[DELM]]");
                                valueString = valueString.replaceAll("\\\\'", "\\\\\\\\'"); // Then escape any single quotes.

                                rowStringBuffer.append(valueString); // Add the final string to the row string buffer.
                            } else if (value instanceof java.util.Date) { // If the value is a date...
                                // ...convert it to a timestamp string.
                                rowStringBuffer.append((new Timestamp(((Date) value).getTime())));
                            } else if (value instanceof Boolean) { // If the value is a boolean...
                                if (((Boolean) value)) {
                                    rowStringBuffer.append(1); // ...convert it to 1 for true...
                                } else {
                                    rowStringBuffer.append(0); // ...or 0 for false.
                                }
                            } else {
                                rowStringBuffer.append(value);
                            }
                        }
                        rowStringBuffer.append(CSV_ENCLOSURE); // Add another enclosing character to the end of the value.
                        rowStringBuffer.append(CSV_DELIMITER); // Add the delimiter to separate the different values.

                        // Add the value to the right position in the row. If we come accross a column we don't now about ignore it.
                        if (indexs[j] > -1) values[indexs[j]] = rowStringBuffer.toString();
                    }

                    rowStringBuffer = new StringBuffer();
                    for (String value : values) {
                        if (value != null) rowStringBuffer.append(value);    
                    }
                    rowStringBuffer.append("\n"); // Add a new line to indicate the end of this record.
                    
                    bufferedWriter.write(rowStringBuffer.toString()); // Write the record out to the file.
                } else {
                    System.out.println("        -- Row " + i + " is null.\n"); // If the row is null log it.
                }
            } catch (IOException e) {
                // If there was a issue with the row log it.
                System.out.println("        -- Problem reading column number " + id + " from " + table.getName() + " table. Error: " + e.getMessage() + "\n");
            }

        }

        return true;
    }

    public static String extractTextFromRTFNotes(Object value) {
        String extractedText = null; // Value to hold the text that is extracted from the rich text. 

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream(); // Stream to used to get the object as a byte array.
            ObjectOutputStream oos = new ObjectOutputStream(bos); // Stream to hold and pipe the object into the byte array stream.
            oos.writeObject(value); // Pipe the object into the byte array stream.
            oos.flush(); // Flush to the stream to make sure it is all in there.
            oos.close(); // Close of the streams since nothing more will be going in.
            bos.close();
            byte[] data = bos.toByteArray(); // Get the object as a byte array.
            ByteArrayInputStream noteStream = new ByteArrayInputStream(data); // Pipe the byte array into an input stream.
            RTFEditorKit rtfEditorKit = new RTFEditorKit(); // Create a swing RTF editor top hold the RTF data that we have.
            // Get the document object for the RTF editor, this is where the RTF data will be placed.
            Document rtfDocument = rtfEditorKit.createDefaultDocument();
            rtfEditorKit.read(noteStream, rtfDocument, 0); // Read the RTF data into the document.
            // Request the plain text from the document and place it into the string that will be returned.
            extractedText = rtfDocument.getText(0, rtfDocument.getLength());
        } catch (BadLocationException e) {
            System.out.println("        -- Error converting ritch text: "
                    + e.getMessage() + "\n");
        } catch (IOException e) {
            System.out.println("        -- Error converting ritch text: "
                    + e.getMessage() + "\n");
        }

        return extractedText; // Return the extracted text.
    }
}
