#! /usr/bin/awk -f

BEGIN {
    tableName = "";
    columnCount = 0;
    }

{
if (match($0, /^public (class|interface)( abstract)? [a-zA-Z0-9]+/) > 0) {
    sub(/ abstract/, "", $0);

    tableName = tolower($3);

    print "tableColumnMap.put(\"" tableName "\", new HashMap<String, Integer>());";
}

if (match($0, /^[ ]+public [a-zA-Z0-9]+(\<[a-zA-Z0-9]+\>)? get[a-zA-Z0-9]+\(/) > 0) {
    split($3, getterArray, "(");
    getter = getterArray[1];
    sub(/get/, "", $3);
    sub(/\(\)/, "" , $3);

    getters[columnCount] = tolower($3);

    columnCount++;
}

}

END {
    for (i = 0; i < columnCount; i++ ) print "tableColumnMap.get(\"" tableName "\").put(\"" getters[i] "\", " i ");";
    print "";
}
