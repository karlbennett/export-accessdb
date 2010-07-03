package org.youthnet.export.domain.vb25;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * User: karl
 * Date: 03-Jul-2010
 */
public class TblActivityLog {

    private static final String DELIMITER = "|";

    private Integer lid;
    private String activity;
    private String type;
    private Integer vid;
    private Integer oid;
    private Integer orgid;
    private Integer linkedoid;
    private String subject;
    private String owner;
    private Timestamp starttime;
    private Timestamp endtime;
    private Boolean alarm;
    private Timestamp alarmstarttime;
    private String alarmperiod;
    private Boolean alldayevent;
    private String correspondence;
    private Timestamp datecorrsent;
    private Integer linkedlid;
    private Integer backlid;
    private Boolean showincalendar;
    private Integer esttotalhours;
    private String notes;
    private Timestamp datefirstentered;
    private Timestamp datelastupdated;
    private String lastupdatedby;

    public TblActivityLog(String record) {
        String[] fields = record.split(DELIMITER);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        this.lid = Integer.getInteger(fields[0].substring(1, fields[0].length() - 1));
        this.activity = fields[1].substring(1, fields[1].length() - 1);
        this.type = fields[2].substring(1, fields[2].length() - 1);
        this.vid = Integer.getInteger(fields[3].substring(1, fields[3].length() - 1));
        this.oid = Integer.getInteger(fields[4].substring(1, fields[4].length() - 1));
        this.orgid = Integer.getInteger(fields[5].substring(1, fields[5].length() - 1));
        this.linkedoid = Integer.getInteger(fields[6].substring(1, fields[6].length() - 1));
        this.subject = fields[7].substring(1, fields[7].length() - 1);
        this.owner = fields[8].substring(1, fields[8].length() - 1);
        try {
            this.starttime = new Timestamp(
                    simpleDateFormat.parse(fields[9].substring(1, fields[9].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars starttime date " + fields[9].substring(1, fields[9].length() - 1)
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.endtime = new Timestamp(
                    simpleDateFormat.parse(fields[10].substring(1, fields[10].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars endtime date " + fields[9].substring(1, fields[9].length() - 1)
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.alarm = fields[11].substring(1, fields[11].length() - 1).equals("1");
        try {
            this.alarmstarttime = new Timestamp(
                    simpleDateFormat.parse(fields[12].substring(1, fields[12].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars alarmstarttime date " + fields[9].substring(1, fields[9].length() - 1)
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.alarmperiod = fields[13].substring(1, fields[13].length() - 1);
        this.alldayevent = fields[14].substring(1, fields[14].length() - 1).equals("1");
        this.correspondence = fields[15].substring(1, fields[15].length() - 1);
        try {
            this.datecorrsent = new Timestamp(
                    simpleDateFormat.parse(fields[16].substring(1, fields[16].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datecorrsent date " + fields[9].substring(1, fields[9].length() - 1)
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.linkedlid = Integer.getInteger(fields[17].substring(1, fields[17].length() - 1));
        this.backlid = Integer.getInteger(fields[18].substring(1, fields[18].length() - 1));
        this.showincalendar = fields[19].substring(1, fields[19].length() - 1).equals("1");
        this.esttotalhours = Integer.getInteger(fields[20].substring(1, fields[20].length() - 1));
        this.notes = fields[21].substring(1, fields[21].length() - 1);
        try {
            this.datefirstentered = new Timestamp(
                    simpleDateFormat.parse(fields[22].substring(1, fields[22].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datefirstentered date " + fields[9].substring(1, fields[9].length() - 1)
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.datelastupdated = new Timestamp(
                    simpleDateFormat.parse(fields[23].substring(1, fields[23].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datelastupdated date " + fields[9].substring(1, fields[9].length() - 1)
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.lastupdatedby = fields[24].substring(1, fields[24].length() - 1);
    }

    public Integer getLid() {
        return lid;
    }

    public String getActivity() {
        return activity;
    }

    public String getType() {
        return type;
    }

    public Integer getVid() {
        return vid;
    }

    public Integer getOid() {
        return oid;
    }

    public Integer getOrgid() {
        return orgid;
    }

    public Integer getLinkedoid() {
        return linkedoid;
    }

    public String getSubject() {
        return subject;
    }

    public String getOwner() {
        return owner;
    }

    public Timestamp getStarttime() {
        return starttime;
    }

    public Timestamp getEndtime() {
        return endtime;
    }

    public Boolean getAlarm() {
        return alarm;
    }

    public Timestamp getAlarmstarttime() {
        return alarmstarttime;
    }

    public String getAlarmperiod() {
        return alarmperiod;
    }

    public Boolean getAlldayevent() {
        return alldayevent;
    }

    public String getCorrespondence() {
        return correspondence;
    }

    public Timestamp getDatecorrsent() {
        return datecorrsent;
    }

    public Integer getLinkedlid() {
        return linkedlid;
    }

    public Integer getBacklid() {
        return backlid;
    }

    public Boolean getShowincalendar() {
        return showincalendar;
    }

    public Integer getEsttotalhours() {
        return esttotalhours;
    }

    public String getNotes() {
        return notes;
    }

    public Timestamp getDatefirstentered() {
        return datefirstentered;
    }

    public Timestamp getDatelastupdated() {
        return datelastupdated;
    }

    public String getLastupdatedby() {
        return lastupdatedby;
    }
}
