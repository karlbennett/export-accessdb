package org.youthnet.export.domain.vb25;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TblActivityLog {

    private static final String DELIMITER = "\\|";

    public static final int COLUMN_NUM = 25;

    private Long lid;
    private String activity;
    private String type;
    private Long vid;
    private Long oid;
    private Long orgid;
    private Long linkedoid;
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
    private Long linkedlid;
    private Long backlid;
    private Boolean showincalendar;
    private Short esttotalhours;
    private String notes;
    private Timestamp datefirstentered;
    private Timestamp datelastupdated;
    private String lastupdatedby;


    public TblActivityLog(String record) {
        String[] fields = record.split(DELIMITER);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        try {
            this.lid = Long.parseLong(fields[0].substring(1, fields[0].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars lid Long " + fields[0].substring(1, fields[0].length() - 1)
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.activity = fields[1].substring(1, fields[1].length() - 1);
        this.type = fields[2].substring(1, fields[2].length() - 1);
        try {
            this.vid = Long.parseLong(fields[3].substring(1, fields[3].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars vid Long " + fields[3].substring(1, fields[3].length() - 1)
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.oid = Long.parseLong(fields[4].substring(1, fields[4].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars oid Long " + fields[4].substring(1, fields[4].length() - 1)
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.orgid = Long.parseLong(fields[5].substring(1, fields[5].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars orgid Long " + fields[5].substring(1, fields[5].length() - 1)
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.linkedoid = Long.parseLong(fields[6].substring(1, fields[6].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars linkedoid Long " + fields[6].substring(1, fields[6].length() - 1)
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.subject = fields[7].substring(1, fields[7].length() - 1);
        this.owner = fields[8].substring(1, fields[8].length() - 1);
        try {
            this.starttime = new Timestamp(
                    simpleDateFormat.parse(fields[9].substring(1, fields[9].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars starttime Timestamp " + fields[9].substring(1, fields[9].length() - 1)
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.endtime = new Timestamp(
                    simpleDateFormat.parse(fields[10].substring(1, fields[10].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars endtime Timestamp " + fields[10].substring(1, fields[10].length() - 1)
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.alarm = fields[11].substring(1, fields[11].length() - 1).equals("1");
        try {
            this.alarmstarttime = new Timestamp(
                    simpleDateFormat.parse(fields[12].substring(1, fields[12].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars alarmstarttime Timestamp " + fields[12].substring(1, fields[12].length() - 1)
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.alarmperiod = fields[13].substring(1, fields[13].length() - 1);
        this.alldayevent = fields[14].substring(1, fields[14].length() - 1).equals("1");
        this.correspondence = fields[15].substring(1, fields[15].length() - 1);
        try {
            this.datecorrsent = new Timestamp(
                    simpleDateFormat.parse(fields[16].substring(1, fields[16].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datecorrsent Timestamp " + fields[16].substring(1, fields[16].length() - 1)
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.linkedlid = Long.parseLong(fields[17].substring(1, fields[17].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars linkedlid Long " + fields[17].substring(1, fields[17].length() - 1)
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.backlid = Long.parseLong(fields[18].substring(1, fields[18].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars backlid Long " + fields[18].substring(1, fields[18].length() - 1)
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.showincalendar = fields[19].substring(1, fields[19].length() - 1).equals("1");
        try {
            this.esttotalhours = Short.parseShort(fields[20].substring(1, fields[20].length() - 1));
        } catch (NumberFormatException e) {
            System.out.println("Could not pars esttotalhours Short " + fields[20].substring(1, fields[20].length() - 1)
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.notes = fields[21].substring(1, fields[21].length() - 1);
        try {
            this.datefirstentered = new Timestamp(
                    simpleDateFormat.parse(fields[22].substring(1, fields[22].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datefirstentered Timestamp " + fields[22].substring(1, fields[22].length() - 1)
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.datelastupdated = new Timestamp(
                    simpleDateFormat.parse(fields[23].substring(1, fields[23].length() - 1)).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datelastupdated Timestamp " + fields[23].substring(1, fields[23].length() - 1)
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.lastupdatedby = fields[24].substring(1, fields[24].length() - 1);
    }

    public Long getLid() {
        return this.lid;
    }

    public String getActivity() {
        return this.activity;
    }

    public String getType() {
        return this.type;
    }

    public Long getVid() {
        return this.vid;
    }

    public Long getOid() {
        return this.oid;
    }

    public Long getOrgid() {
        return this.orgid;
    }

    public Long getLinkedoid() {
        return this.linkedoid;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getOwner() {
        return this.owner;
    }

    public Timestamp getStarttime() {
        return this.starttime;
    }

    public Timestamp getEndtime() {
        return this.endtime;
    }

    public Boolean getAlarm() {
        return this.alarm;
    }

    public Timestamp getAlarmstarttime() {
        return this.alarmstarttime;
    }

    public String getAlarmperiod() {
        return this.alarmperiod;
    }

    public Boolean getAlldayevent() {
        return this.alldayevent;
    }

    public String getCorrespondence() {
        return this.correspondence;
    }

    public Timestamp getDatecorrsent() {
        return this.datecorrsent;
    }

    public Long getLinkedlid() {
        return this.linkedlid;
    }

    public Long getBacklid() {
        return this.backlid;
    }

    public Boolean getShowincalendar() {
        return this.showincalendar;
    }

    public Short getEsttotalhours() {
        return this.esttotalhours;
    }

    public String getNotes() {
        return this.notes;
    }

    public Timestamp getDatefirstentered() {
        return this.datefirstentered;
    }

    public Timestamp getDatelastupdated() {
        return this.datelastupdated;
    }

    public String getLastupdatedby() {
        return this.lastupdatedby;
    }

}
