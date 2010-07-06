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
firstletter = substr(createTableArray[3], 1, 1);
sub(/^[a-zA-Z]/,toupper(firstletter),createTableArray[3]);
tableName = createTableArray[3];

sub(/, primary key$/, "", $2);
columnNum = split($2, columnArray, ", ");

split("", attributes);
split("", methods);

for(i in columnArray) {
    split(columnArray[i], columnNameArray, " ");

    firstletter = substr(columnNameArray[1], 1, 1);
	sub(/^[a-zA-Z]/,toupper(firstletter),columnNameArray[1]);
    methods[columnNameArray[1]] = sqlToJava[columnNameArray[2]];
    types[sqlToJava[columnNameArray[2]]] = "true";
}

print "package org.youthnet.export.domain.vb3;" > tableName ".java";
printf "\n\n" >> tableName ".java";

print "import org.youthnet.export.domain.CSVable;" >> tableName ".java";
print "import java.util.UUID;" >> tableName ".java";
if ("Timestamp" in types) {
    print "import java.sql.Timestamp;" >> tableName ".java";
    print "import java.text.ParseException;" >> tableName ".java";
    print "import java.text.SimpleDateFormat;" >> tableName ".java";
}
print "import java.util.List;" >> tableName ".java";
print "import java.util.ArrayList;" >> tableName ".java";
printf "\n\n" >> tableName ".java";

print "public class " tableName " implements CSVable{" >> tableName ".java";
print "" >> tableName ".java";

print "\tprivate char delimiter = '|';" >> tableName ".java";
print "\tprivate char enclosure = '¬';" >> tableName ".java";
print "\tprivate Integer columnNum = " columnNum ";" >> tableName ".java";
print "\tprivate List<String> columnNames = null;" >> tableName ".java";
print "\tprivate StringBuffer recordStringBuffer = new StringBuffer();" >> tableName ".java";
print "" >> tableName ".java";

for (method in methods) print "\tprivate " methods[method] " " tolower(method) ";" >> tableName ".java";
print "" >> tableName ".java";

print "\tpublic " tableName "() {}" >> tableName ".java";
print "" >> tableName ".java";

print "\tpublic " tableName "(String record) {" >> tableName ".java";
print "\t\tinit(record);" >> tableName ".java";
print "\t}" >> tableName ".java";
print "" >> tableName ".java";

print "\tpublic void init(String record) {" >> tableName ".java";
print "\t\tString[] fields = record.split(\"\\\\\" + String.valueOf(this.delimiter));" >> tableName ".java";
print "\t\tStringBuffer uuidStringBuffer = new StringBuffer();" >> tableName ".java";
if ("Timestamp" in types) print "\t\tSimpleDateFormat simpleDateFormat = new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss.S\");" >> tableName ".java";
print "" >> tableName ".java";
print "" >> tableName ".java";
count = 0;
for (method in methods) {
    if (methods[method] == "String") print "\t\tthis." tolower(method) " = fields[" count "].replace(String.valueOf(this.enclosure), \"\");" >> tableName ".java";

    if (methods[method] == "UUID") {
        print "\t\tuuidStringBuffer.setLength(0);" >> tableName ".java";
        print "\t\tuuidStringBuffer.append(fields[" count "].replace(String.valueOf(this.enclosure), \"\"));" >> tableName ".java";
        print "\t\tuuidStringBuffer.insert(8, '-');" >> tableName ".java";
        print "\t\tuuidStringBuffer.insert(13, '-');" >> tableName ".java";
        print "\t\tuuidStringBuffer.insert(18, '-');" >> tableName ".java";
        print "\t\tuuidStringBuffer.insert(23, '-');" >> tableName ".java";
        print "\t\tthis." tolower(method) " = UUID.fromString(uuidStringBuffer.toString());" >> tableName ".java";
    }

    if (methods[method] == "Long") print "\t\tthis." tolower(method) " = Long.valueOf(fields[" count "].replace(String.valueOf(this.enclosure), \"\"));" >> tableName ".java";

    if (methods[method] == "Float") print "\t\tthis." tolower(method) " = Float.valueOf(fields[" count "].replace(String.valueOf(this.enclosure), \"\"));" >> tableName ".java";

    if (methods[method] == "Boolean") print "\t\tthis." tolower(method) " = fields[" count "].replace(String.valueOf(this.enclosure), \"\").equals(\"1\");" >> tableName ".java";

    if (methods[method] == "byte[]") print "\t\tthis." tolower(method) " = fields[" count "].replace(String.valueOf(this.enclosure), \"\").getBytes();" >> tableName ".java";

    if (methods[method] == "Timestamp") {
        print "\t\ttry {" >> tableName ".java";
        print "\t\t\tthis." tolower(method) " = new Timestamp(simpleDateFormat.parse(fields[" count "].replace(String.valueOf(this.enclosure), \"\")).getTime());" >> tableName ".java";
        print "\t\t} catch (ParseException e) {" >> tableName ".java";
        print "\t\t\tSystem.out.println(\"Could not pars " methods[method] " " tolower(method) " \" + fields[" count "].replace(String.valueOf(this.enclosure), \"\") + \" for table \" + this.getClass().getName() + \". Error: \" + e.getMessage());" >> tableName ".java";
        print "\t\t}" >> tableName ".java";
    }
    print "" >> tableName ".java";

    count++;
}
print "\t}" >> tableName ".java";
print "" >> tableName ".java";
print "" >> tableName ".java";


for (method in methods) {
    print "\tpublic " methods[method] " get" method "() {" >> tableName ".java";
    print "\t\treturn this." tolower(method) ";" >> tableName ".java";
    print "\t}" >> tableName ".java";
    print "" >> tableName ".java";
    print "\tpublic void set" method "(" methods[method] " " tolower(method) ") {" >> tableName ".java";
    print "\t\tthis." tolower(method) " = " tolower(method) ";" >> tableName ".java";
    print "\t}" >> tableName ".java";
    print "" >> tableName ".java";
}
print "" >> tableName ".java";

print "\tpublic char getDelimiter() {" >> tableName ".java";
print "\t\treturn this.delimiter;" >> tableName ".java";
print "\t}" >> tableName ".java";
print "" >> tableName ".java";

print "\tpublic void setDelimiter(char delimiter) {" >> tableName ".java";
print "\t\tthis.delimiter = delimiter;" >> tableName ".java";
print "\t}" >> tableName ".java";
print "" >> tableName ".java";

print "\tpublic char getEnclosure() {" >> tableName ".java";
print "\t\treturn this.enclosure;" >> tableName ".java";
print "\t}" >> tableName ".java";
print "" >> tableName ".java";

print "\tpublic void setEnclosure(char enclosure) {" >> tableName ".java";
print "\t\tthis.enclosure = enclosure;" >> tableName ".java";
print "\t}" >> tableName ".java";
print "" >> tableName ".java";

print "\tpublic Integer getColumnNumber() {" >> tableName ".java";
print "\t\treturn this.columnNum;" >> tableName ".java";
print "\t}" >> tableName ".java";
print "" >> tableName ".java";

print "\tpublic List<String> getColumnNames() {" >> tableName ".java";
print "\t\tif (this.columnNames == null) {" >> tableName ".java";
print "\t\t\tthis.columnNames = new ArrayList<String>();" >> tableName ".java";
for (method in methods) print "\t\t\tthis.columnNames.add(\"" method "\");" >> tableName ".java";
print "\t\t}" >> tableName ".java";
print "" >> tableName ".java";
print "\t\treturn this.columnNames;" >> tableName ".java";
print "\t}" >> tableName ".java";
print "" >> tableName ".java";

print "\tpublic String getRecord() {" >> tableName ".java";
print "\t\trecordStringBuffer.setLength(0);" >> tableName ".java";
print "" >> tableName ".java";
#recordString = "";
for (method in methods) {
    #recordString = recordString "+ this.enclosure + this." attribute " + this.enclosure + this.delimiter\n";
    print "\t\trecordStringBuffer.append(this.enclosure);" >> tableName ".java";
    if (methods[method] == "UUID") {
        print "\t\trecordStringBuffer.append(this." tolower(method) ".toString().replace(\"-\",\"\"));" >> tableName ".java";
    } else if (methods[method] == "Boolean") {
        print "\t\trecordStringBuffer.append(" tolower(method) " ? 1 : 0);" >> tableName ".java";
    } else print "\t\trecordStringBuffer.append(this." tolower(method) ");" >> tableName ".java";
    print "\t\trecordStringBuffer.append(this.enclosure);" >> tableName ".java";
    print "\t\trecordStringBuffer.append(this.delimiter);" >> tableName ".java";
    print "" >> tableName ".java";
}
#sub(/^\+ /, "", recordString);
#sub(/$/, " + \"\\n\";", recordString);
#printf "\t\treturn " recordString "\n" >> tableName ".java";
print "\t\treturn recordStringBuffer.toString();" >> tableName ".java";
print "\t}" >> tableName ".java";

print "}" >> tableName ".java";
}

END {}
