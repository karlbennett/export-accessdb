#! /usr/bin/awk -f

BEGIN {
    bean = "";
    constantCount = 0;
    typeToValue["List<String>"] = "null";
    typeToValue["Boolean"] = "true";
    typeToValue["UUID"] = "UUID.randomUUID()";
    typeToValue["Long"] = "99999L";
    typeToValue["Float"] = "1.2f";
    typeToValue["Integer"] = "1";
    typeToValue["StringBuffer"] = "new StringBuffer(\"Test String Buffer.\")";
    typeToValue["String"] = "\"Test String.\"";
    typeToValue["Timestamp"] = "new Timestamp(new Date().getTime())";
    }

{
if (match($0, /^public (class|interface)( abstract)? [a-zA-Z0-9]+/) > 0) {
    sub(/ abstract/, "", $0);

    firstletter=substr($3, 1, 1);
	sub(/^[a-zA-Z]/,tolower(firstletter),$3);
    bean = $3;

    print "Bean: " bean;
}

if (match($0, /^[ ]+private /) > 0) {
    sub(/;/, "", $3);
    print "private static final " $2 " " toupper($3) " = " typeToValue[$2] ";";
    
    constants[constantCount, 0] = toupper($3);
    constants[constantCount, 1] = $2;
    constants[tolower($3)] = toupper($3);
    types[$2] = "blah";
    constantCount++;
}

if (match($0, /^[ ]+public [a-zA-Z0-9]+(\<[a-zA-Z0-9]+\>)? get[a-zA-Z0-9]+\(/) > 0) {
    split($3, getterArray, "(");
    getter = getterArray[1];
    sub(/get/, "", $3);
    sub(/\(\)/, "" , $3);

    getters[toupper($3)] = getter;
}

if (match($0, /^[ ]+public void set[a-zA-Z0-9]+\(/) > 0) {
    split($3, setterArray, "(");
    setter = setterArray[1];
    sub(/set/, "", $3);
    sub(/\([a-zA-Z0-9]+/, "" , $3);

    print bean "." setter "(" constants[tolower($3)] ");";
}
}

END {
    print "";
    print "";
    testString = "";
    for (i = 0; i < constantCount; i++) {
        if (constants[i, 1] == "UUID") testString = testString "+ \"¬\" + " constants[i, 0] ".toString().replace(\"-\", \"\") + \"¬\" + \"|\"\n";
        else if (constants[i, 1] == "Boolean") testString = testString "+ \"¬\" + (" constants[i, 0] " ? 1 : 0) + \"¬\" + \"|\"\n";
        else testString = testString "+ \"¬\" + " constants[i, 0] " + \"¬\" + \"|\"\n";
    }
    sub(/^\+ /, "", testString);
    sub(/\n$/, ";", testString);
    printf "String testRecord = " testString "\n";
    print "";
    print "assertEquals(\"record equal\", testRecord, " bean ".getRecord());";

    print "";
    print "";

    for (i = 0; i < constantCount; i++) {
        print "assertEquals(\"" tolower(constants[i, 0]) " equals\", " constants[i, 0] ", " bean "." getters[constants[i, 0]] "());";
    }

    print "";
    print "";
    for (type in types) print "Type: " type;
}
