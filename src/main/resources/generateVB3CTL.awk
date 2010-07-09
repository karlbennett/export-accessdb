#! /usr/bin/awk -f

BEGIN {
    tableName = "";
    columnCount = 0;
    javaToCtl["String"] = "CHAR";
    javaToCtl["Timestamp"] = "TIMESTAMP 'yyyy-mm-dd HH24:MI:SS.FF1'";
    javaToCtl["UUID"] = "CHAR(32)";
    }

{
if (match($0, /^public (class|interface)( abstract)? [a-zA-Z0-9]+/) > 0) {
    sub(/ abstract/, "", $0);

    tableName = $3;

    print "Table name: " tableName;
}

if (match($0, /^[ ]+private /) > 0) {
    sub(/;/, "", $3);
    print $2 " " $3;

    if ($3 != "delimiter" && $3 != "enclosure" && $3 != "columnNum" && $3 != "columnNames" && $3 != "recordStringBuffer") {
        columns[columnCount, 0] = $3;
        columns[columnCount, 1] = javaToCtl[$2];
        columnCount++;
    }
}

}

END {
    print "";
    print "";
    print "load data" > tableName ".ctl";
    print " infile \"" tableName ".csv\" \"str '|\\n'\"" >> tableName ".ctl";
    print " into table " tableName >> tableName ".ctl";
    print " fields terminated by '|' optionally enclosed by '¬' TRAILING NULLCOLS\n (" >> tableName ".ctl";
    printf "  " columns[0, 0] " " columns[0, 1] >> tableName ".ctl";
    for(i = 1; i < columnCount; i++) printf ",\n  " columns[i, 0] " " columns[i, 1] >> tableName ".ctl";
    print "\n)" >> tableName ".ctl";
}
