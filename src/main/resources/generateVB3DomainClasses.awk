#! /usr/bin/awk -f

BEGIN {
        FS=" \(";
        tableName = "";
        sqlToJava["varchar2(150"] = "String";
        sqlToJava["varchar2(320"] = "String";
        sqlToJava["raw(16)"] = "UUID";
        sqlToJava["varchar2(100"] = "String";
        sqlToJava["float"] = "Float";
        sqlToJava["number(1,0)"] = "Boolean";
        sqlToJava["number(19,0)"] = "Long";
        sqlToJava["number(10,0)"] = "Long";
        sqlToJava["varchar(30)"] = "String";
        sqlToJava["varchar2(1"] = "String";
        sqlToJava["varchar2(5"] = "String";
        sqlToJava["blob"] = "byte[]";
        sqlToJava["varchar2(255"] = "String";
        sqlToJava["timestamp"] = "Timestamp";
        sqlToJava["varchar2(250"] = "String";
        sqlToJava["varchar2(2000"] = "String";
        sqlToJava["varchar2(86"] = "String";
        sqlToJava["varchar2(36"] = "String";
        sqlToJava["varchar2(50"] = "String";
        sqlToJava["varchar2(40"] = "String";
        sqlToJava["varchar2(30"] = "String";
        sqlToJava["varchar2(20"] = "String";
    }

{
oldline=$0;
split($1, createTableArray, " ");
tableName = createTableArray[3];
sub(/, primary key$/, "", $2);
columnNum = split($2, columnArray, ", ");
split("", attributes);
split("", methods);
for(i in columnArray) {
    split(columnArray[i], columnNameArray, " ");

    attributes[tolower(columnNameArray[1])] = sqlToJava[columnNameArray[2]];

    firstletter=substr(columnNameArray[1], 1, 1);
	sub(/^[a-zA-Z]/,toupper(firstletter),columnNameArray[1]);
    methods[columnNameArray[1]] = sqlToJava[columnNameArray[2]];
}

print "package org.youthnet.export.domain.vb3;" > tableName ".java";
printf "\n\n" >> tableName ".java";
print "import java.util.UUID;" >> tableName ".java";
print "import java.sql.Timestamp;" >> tableName ".java";
printf "\n\n" >> tableName ".java";
print "public class " tableName " {" >> tableName ".java";
print "" >> tableName ".java";
for (attribute in attributes) print "\tprivate " attributes[attribute] " " attribute ";" >> tableName ".java";
print "" >> tableName ".java";
print "\tpublic " tableName "() {}" >> tableName ".java";
print "" >> tableName ".java";
for (method in methods) {
    print "\tpublic " methods[method] " get" method "() {" >> tableName ".java";
    print "\t\treturn this." tolower(method) ";" >> tableName ".java";
    print "\t}" >> tableName ".java";
    print "" >> tableName ".java";
    print "\tpublic void set" method "(" methods[method] " " tolower(method) ") {" >> tableName ".java";
    print "\t\tthis." tolower(method) " = " tolower(method) ";" >> tableName ".java";
    print "\t}" >> tableName ".java";
}
print "}" >> tableName ".java";
}

END {}
