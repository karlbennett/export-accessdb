#! /usr/bin/awk -f

BEGIN {
    bean = "";
    typeToValue["List<String>"] = "null";
    typeToValue["Boolean"] = "true";
    typeToValue["UUID"] = "UUID.randomUUID()";
    typeToValue["Long"] = "99999L";
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
    
    constants[tolower($3)] = toupper($3);
    types[$2] = "blah";
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
    for (constant in constants) {
        testString = testString "+ \"¬\" + " constants[constant] " + \"¬\" + \"|\"\n";
    }
    sub(/^\+ /, "", testString);
    sub(/\n$/, ";", testString);
    printf "String testRecord = " testString "\n"
    print "";
    print "assertEquals(\"record equal\", testRecord, " bean ".getRecord());";

    print "";
    print "";
    for (type in types) print "Type: " type;


    }
