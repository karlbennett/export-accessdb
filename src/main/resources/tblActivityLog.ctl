load data
 infile "output/tblActivityLog.csv" "str '|\n'"
 into table tblActivityLog
 fields terminated by '|' optionally enclosed by '¬' TRAILING NULLCOLS
 ( LID,
Activity,
Type,
VID,
OID,
OrgID,
LinkedOID,
Subject,
Owner,
StartTime TIMESTAMP 'yyyy-mm-dd HH24:MI:SS.FF1',
EndTime TIMESTAMP 'yyyy-mm-dd HH24:MI:SS.FF1',
Alarm,
AlarmStartTime TIMESTAMP 'yyyy-mm-dd HH24:MI:SS.FF1',
AlarmPeriod,
AllDayEvent,
Correspondence,
DateCorrSent TIMESTAMP 'yyyy-mm-dd HH24:MI:SS.FF1',
LinkedLID,
BackLID,
ShowInCalendar,
EstTotalHours,
Notes CHAR(4000),
DateFirstEntered TIMESTAMP 'yyyy-mm-dd HH24:MI:SS.FF1',
DateLastUpdated TIMESTAMP 'yyyy-mm-dd HH24:MI:SS.FF1',
LastUpdatedBy )
