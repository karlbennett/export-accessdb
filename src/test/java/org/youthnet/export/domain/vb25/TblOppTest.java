package org.youthnet.export.domain.vb25;

import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * User: karl
 * Date: 03-Jul-2010
 */
public class TblOppTest {

    private static final Long OID = 1L;
    private static final Long ORGID = 2L;
    private static final String OPPENTEREDID = "Some One";
    private static final String TITLE = "Mr";
    private static final String CONTACT = "Some One Else";
    private static final String ADDRESS1 = "That St";
    private static final String ADDRESS2 = "There";
    private static final String TOWN = "Some Town";
    private static final String COUNTY = "That County";
    private static final String POSTCODE = "12345";
    private static final String TEL1 = "1234567";
    private static final String FAX = "1234567";
    private static final String EMAIL = "test@there.com";
    private static final String GEOGRAPHICALAREA = "That Area";
    private static final BigDecimal MONETARYVALUE = new BigDecimal(9999999);
    private static final Boolean ACTIVE = true;
    private static final Boolean INCLUDEONWEB = true;
    private static final Boolean ONEOFF = true;
    private static final Boolean INCLUDEVBADDRESS = true;
    private static final Timestamp OPPSTARTDATE = new Timestamp(new Date().getTime());
    private static final Timestamp OPPENDDATE = new Timestamp(new Date().getTime());
    private static final String DESCRIPTION = "Some description.";
    private static final String SKILLSQUALIFICATIONS = "Some skills.";
    private static final String DIRECTIONS = "Oh over there.";
    private static final Timestamp DATEFIRSTENTERED = new Timestamp(new Date().getTime());
    private static final Timestamp DATELASTUPDATED = new Timestamp(new Date().getTime());
    private static final String LASTUPDATEDBY = "Some other person.";
    private static final Boolean USEORGCONTACT = true;
    private static final String TELFAXSEARCH = "1234567";
    private static final Boolean VIRTUALVOL = false;
    private static final Boolean RESIDENTIAL = true;
    private static final Timestamp SPECIFICSTARTDATE = new Timestamp(new Date().getTime());
    private static final Timestamp SPECIFICENDDATE = new Timestamp(new Date().getTime());
    private static final String SHORTDESCRIPTION = "Some short description.";
    private static final Boolean DEMODATA = false;

    @Test
    public void createTblOppTest() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        
        String rowString = "¬" + OID + "¬|"
                + "¬" + ORGID + "¬|"
                + "¬" + OPPENTEREDID + "¬|"
                + "¬" + TITLE + "¬|"
                + "¬" + CONTACT + "¬|"
                + "¬" + ADDRESS1 + "¬|"
                + "¬" + ADDRESS2 + "¬|"
                + "¬" + TOWN + "¬|"
                + "¬" + COUNTY + "¬|"
                + "¬" + POSTCODE + "¬|"
                + "¬" + TEL1 + "¬|"
                + "¬" + FAX + "¬|"
                + "¬" + EMAIL + "¬|"
                + "¬" + GEOGRAPHICALAREA + "¬|"
                + "¬" + MONETARYVALUE.toString() + "¬|"
                + "¬" + 1 + "¬|"
                + "¬" + 1 + "¬|"
                + "¬" + 1 + "¬|"
                + "¬" + 1 + "¬|"
                + "¬" + simpleDateFormat.format(OPPSTARTDATE) + "¬|"
                + "¬" + simpleDateFormat.format(OPPENDDATE) + "¬|"
                + "¬" + DESCRIPTION + "¬|"
                + "¬" + SKILLSQUALIFICATIONS + "¬|"
                + "¬" + DIRECTIONS + "¬|"
                + "¬" + simpleDateFormat.format(DATEFIRSTENTERED) + "¬|"
                + "¬" + simpleDateFormat.format(DATELASTUPDATED) + "¬|"
                + "¬" + LASTUPDATEDBY + "¬|"
                + "¬" + 1 + "¬|"
                + "¬" + TELFAXSEARCH + "¬|"
                + "¬" + 0 + "¬|"
                + "¬" + 1 + "¬|"
                + "¬" + simpleDateFormat.format(SPECIFICSTARTDATE) + "¬|"
                + "¬" + simpleDateFormat.format(SPECIFICENDDATE) + "¬|"
                + "¬" + SHORTDESCRIPTION + "¬|"
                + "¬" + 0 + "¬|";

        System.out.println(rowString);

        TblOpp tblOpp = new TblOpp(rowString);

        assertEquals("oid equals", OID, tblOpp.getOid());
        assertEquals("orgid equals", ORGID, tblOpp.getOrgid());
        assertEquals("oppenteredid equals", OPPENTEREDID, tblOpp.getOppenteredid());
        assertEquals("title equals", TITLE, tblOpp.getTitle());
        assertEquals("contact equals", CONTACT, tblOpp.getContact());
        assertEquals("address1 equals", ADDRESS1, tblOpp.getAddress1());
        assertEquals("address2 equals", ADDRESS2, tblOpp.getAddress2());
        assertEquals("town equals", TOWN, tblOpp.getTown());
        assertEquals("county equals", COUNTY, tblOpp.getCounty());
        assertEquals("postcode equals", POSTCODE, tblOpp.getPostcode());
        assertEquals("tel1 equals", TEL1, tblOpp.getTel1());
        assertEquals("faax equals", FAX, tblOpp.getFax());
        assertEquals("email equals", EMAIL, tblOpp.getEmail());
        assertEquals("geographicalarea equals", GEOGRAPHICALAREA, tblOpp.getGeographicalarea());
        assertEquals("monetaryvalue equals", MONETARYVALUE, tblOpp.getMonetaryvalue());
        assertEquals("active equals", ACTIVE, tblOpp.getActive());
        assertEquals("includeeonweb equals", INCLUDEONWEB, tblOpp.getIncludeonweb());
        assertEquals("oneoff equals", ONEOFF, tblOpp.getOneoff());
        assertEquals("includevbaddress equals", INCLUDEVBADDRESS, tblOpp.getIncludevbaddress());
        assertEquals("oppstartdate equals", OPPSTARTDATE, tblOpp.getOppstartdate());
        assertEquals("oppenddate equals", OPPENDDATE, tblOpp.getOppenddate());
        assertEquals("description equals", DESCRIPTION, tblOpp.getDescription());
        assertEquals("skillsqualifications equals", SKILLSQUALIFICATIONS, tblOpp.getSkillsqualifications());
        assertEquals("directions equals", DIRECTIONS, tblOpp.getDirections());
        assertEquals("datefirstentered equals", DATEFIRSTENTERED, tblOpp.getDatefirstentered());
        assertEquals("datelastupdated equals", DATELASTUPDATED, tblOpp.getDatelastupdated());
        assertEquals("lastupdatedby equals", LASTUPDATEDBY, tblOpp.getLastupdatedby());
        assertEquals("useorgcontact equals", USEORGCONTACT, tblOpp.getUseorgcontact());
        assertEquals("telfaxsearch equals", TELFAXSEARCH, tblOpp.getTelfaxsearch());
        assertEquals("virtualvol equals", VIRTUALVOL, tblOpp.getVirtualvol());
        assertEquals("residential equals", RESIDENTIAL, tblOpp.getResidential());
        assertEquals("specificstartdate equals", SPECIFICSTARTDATE, tblOpp.getSpecificstartdate());
        assertEquals("specificenddate equals", SPECIFICENDDATE, tblOpp.getSpecificenddate());
        assertEquals("shortdescription equals", SHORTDESCRIPTION, tblOpp.getShortdescription());
        assertEquals("demodata equals", DEMODATA, tblOpp.getDemodata());
    }
}
