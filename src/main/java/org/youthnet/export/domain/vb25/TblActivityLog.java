package org.youthnet.export.domain.vb25;

import org.youthnet.export.domain.CSVable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class TblActivityLog implements CSVable, ContainsVid, ContainsOid, ContainsOrgid {

    private char delimiter = '|';
    private char enclosure = '¬';

    public static final int COLUMN_NUM = 25;

    private List<String[]> columnNames = null;

    private StringBuffer record = new StringBuffer();

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


    public TblActivityLog() {
    }

    public TblActivityLog(String record) {
        init(record);
    }

    public void init(String record) {
        String[] fields = record.split("\\" + String.valueOf(this.delimiter));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        this.lid = (fields[0].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[0].replace(String.valueOf(this.enclosure), ""));
        this.activity = fields[1].replace(String.valueOf(this.enclosure), "");
        this.type = fields[2].replace(String.valueOf(this.enclosure), "");
        this.vid = (fields[3].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[3].replace(String.valueOf(this.enclosure), ""));
        this.oid = (fields[4].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[4].replace(String.valueOf(this.enclosure), ""));
        this.orgid = (fields[5].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[5].replace(String.valueOf(this.enclosure), ""));
        this.linkedoid = (fields[6].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[6].replace(String.valueOf(this.enclosure), ""));
        this.subject = fields[7].replace(String.valueOf(this.enclosure), "");
        this.owner = fields[8].replace(String.valueOf(this.enclosure), "");
        try {
            this.starttime = (fields[9].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
                    simpleDateFormat.parse(fields[9].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars starttime Timestamp " + fields[9].replace(String.valueOf(this.enclosure), "")
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.endtime = (fields[10].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
                    simpleDateFormat.parse(fields[10].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars endtime Timestamp " + fields[10].replace(String.valueOf(this.enclosure), "")
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.alarm = fields[11].replace(String.valueOf(this.enclosure), "").equals("1");
        try {
            this.alarmstarttime = (fields[12].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
                    simpleDateFormat.parse(fields[12].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars alarmstarttime Timestamp " + fields[12].replace(String.valueOf(this.enclosure), "")
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.alarmperiod = fields[13].replace(String.valueOf(this.enclosure), "");
        this.alldayevent = fields[14].replace(String.valueOf(this.enclosure), "").equals("1");
        this.correspondence = fields[15].replace(String.valueOf(this.enclosure), "");
        try {
            this.datecorrsent = (fields[16].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
                    simpleDateFormat.parse(fields[16].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datecorrsent Timestamp " + fields[16].replace(String.valueOf(this.enclosure), "")
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.linkedlid = (fields[17].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[17].replace(String.valueOf(this.enclosure), ""));
        this.backlid = (fields[18].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Long.valueOf(fields[18].replace(String.valueOf(this.enclosure), ""));
        this.showincalendar = fields[19].replace(String.valueOf(this.enclosure), "").equals("1");
        this.esttotalhours = (fields[20].replace(String.valueOf(this.enclosure), "").equals("")) ? null : Short.valueOf(fields[20].replace(String.valueOf(this.enclosure), ""));
        this.notes = fields[21].replace(String.valueOf(this.enclosure), "");
        try {
            this.datefirstentered = (fields[22].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
                    simpleDateFormat.parse(fields[22].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datefirstentered Timestamp " + fields[22].replace(String.valueOf(this.enclosure), "")
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        try {
            this.datelastupdated = (fields[23].replace(String.valueOf(this.enclosure), "").equals("")) ? null : new Timestamp(
                    simpleDateFormat.parse(fields[23].replace(String.valueOf(this.enclosure), "")).getTime());
        } catch (ParseException e) {
            System.out.println("Could not pars datelastupdated Timestamp " + fields[23].replace(String.valueOf(this.enclosure), "")
                    + " in row " + this.lid + " for table " + this.getClass().getName() + ". Error: " + e.getMessage());
        }
        this.lastupdatedby = fields[24].replace(String.valueOf(this.enclosure), "");
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

    public char getDelimiter() {
        return this.delimiter;
    }

    public void setDelimiter(char delimiter) {
        this.delimiter = delimiter;
    }

    public char getEnclosure() {
        return this.enclosure;
    }

    public void setEnclosure(char enclosure) {
        this.enclosure = enclosure;
    }

    public Integer getColumnNumber() {
        return COLUMN_NUM;
    }

    public List<String[]> getColumnNames() {
        if (this.columnNames == null) {
            columnNames = new ArrayList<String[]>();
            columnNames.add(new String[]{"LID, Long"});
            columnNames.add(new String[]{"Activity, String"});
            columnNames.add(new String[]{"Type, String"});
            columnNames.add(new String[]{"VID, Long"});
            columnNames.add(new String[]{"OID, Long"});
            columnNames.add(new String[]{"OrgID, Long"});
            columnNames.add(new String[]{"LinkedOID, Long"});
            columnNames.add(new String[]{"Subject, String"});
            columnNames.add(new String[]{"Owner, String"});
            columnNames.add(new String[]{"StartTime, Timestamp"});
            columnNames.add(new String[]{"EndTime, Timestamp"});
            columnNames.add(new String[]{"Alarm, Boolean"});
            columnNames.add(new String[]{"AlarmStartTime, Timestamp"});
            columnNames.add(new String[]{"AlarmPeriod, String"});
            columnNames.add(new String[]{"AllDayEvent, Boolean"});
            columnNames.add(new String[]{"Correspondence, String"});
            columnNames.add(new String[]{"DateCorrSent, Timestamp"});
            columnNames.add(new String[]{"LinkedLID, Long"});
            columnNames.add(new String[]{"BackLID, Long"});
            columnNames.add(new String[]{"ShowInCalendar, Boolean"});
            columnNames.add(new String[]{"EstTotalHours, Short"});
            columnNames.add(new String[]{"Notes, String"});
            columnNames.add(new String[]{"DateFirstEntered, Timestamp"});
            columnNames.add(new String[]{"DateLastUpdated, Timestamp"});
            columnNames.add(new String[]{"LastUpdatedBy, String"});
        }

        return columnNames;
    }

    public String getRecord() {
        record.setLength(0);

        record.append(this.enclosure);
        record.append(this.lid == null ? "" : this.lid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.activity == null ? "" : this.activity);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.type == null ? "" : this.type);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.vid == null ? "" : this.vid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.oid == null ? "" : this.oid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.orgid == null ? "" : this.orgid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.linkedoid == null ? "" : this.linkedoid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.subject == null ? "" : this.subject);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.owner == null ? "" : this.owner);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.starttime == null ? "" : this.starttime);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.endtime == null ? "" : this.endtime);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.alarm != null && alarm ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.alarmstarttime == null ? "" : this.alarmstarttime);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.alarmperiod == null ? "" : this.alarmperiod);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.alldayevent != null && alldayevent ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.correspondence == null ? "" : this.correspondence);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.datecorrsent == null ? "" : this.datecorrsent);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.linkedlid == null ? "" : this.linkedlid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.backlid == null ? "" : this.backlid);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.showincalendar != null && showincalendar ? 1 : 0);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.esttotalhours == null ? "" : this.esttotalhours);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.notes == null ? "" : this.notes);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.datefirstentered == null ? "" : this.datefirstentered);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.datelastupdated == null ? "" : this.datelastupdated);
        record.append(this.enclosure);
        record.append(this.delimiter);
        record.append(this.enclosure);
        record.append(this.lastupdatedby == null ? "" : this.lastupdatedby);
        record.append(this.enclosure);
        record.append(this.delimiter);

        return record.toString();
    }
}
