package org.youthnet.export.util;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * User: karl
 * Date: 03-Jul-2010
 */
public class JavaCodeUtil {

    private static List<String> keyWords = null;

    private JavaCodeUtil() {
    }

    public static boolean isKeyword(String word) {
        if (keyWords == null) {
            keyWords = new ArrayList<String>();
            keyWords.add("abstract");
            keyWords.add("continue");
            keyWords.add("for");
            keyWords.add("new");
            keyWords.add("switch");
            keyWords.add("assert");
            keyWords.add("default");
            keyWords.add("goto");
            keyWords.add("package");
            keyWords.add("synchronized");
            keyWords.add("boolean");
            keyWords.add("do");
            keyWords.add("if");
            keyWords.add("private");
            keyWords.add("this");
            keyWords.add("break");
            keyWords.add("double");
            keyWords.add("implements");
            keyWords.add("protected");
            keyWords.add("throw");
            keyWords.add("byte");
            keyWords.add("else");
            keyWords.add("import");
            keyWords.add("public");
            keyWords.add("throws");
            keyWords.add("case");
            keyWords.add("enum");
            keyWords.add("instanceof");
            keyWords.add("return");
            keyWords.add("transient");
            keyWords.add("catch");
            keyWords.add("extends");
            keyWords.add("int");
            keyWords.add("short");
            keyWords.add("try");
            keyWords.add("char");
            keyWords.add("final");
            keyWords.add("interface");
            keyWords.add("static");
            keyWords.add("void");
            keyWords.add("class");
            keyWords.add("finally");
            keyWords.add("long");
            keyWords.add("strictfp");
            keyWords.add("volatile");
            keyWords.add("const");
            keyWords.add("float");
            keyWords.add("native");
            keyWords.add("super");
            keyWords.add("while");
        }

        return keyWords.contains(word);
    }

    public static Class javaTypeForSQLType(int sqlType) {
        switch (sqlType) {
            case Types.BIT:
                return Boolean.class;
            case Types.TINYINT:
                return Byte.class;
            case Types.SMALLINT:
                return Short.class;
            case Types.INTEGER:
                return Long.class; // Should be Integer.class but Access longs show as integers.
            case Types.BIGINT:
                return Long.class;
            case Types.FLOAT:
                return Double.class;
            case Types.REAL:
                return Float.class;
            case Types.DOUBLE:
                return Double.class;
            case Types.NUMERIC:
                return java.math.BigDecimal.class;
            case Types.DECIMAL:
                return java.math.BigDecimal.class;
            case Types.CHAR:
                return String.class;
            case Types.VARCHAR:
                return String.class;
            case Types.LONGVARCHAR:
                return String.class;
            case Types.DATE:
                return java.sql.Date.class;
            case Types.TIME:
                return java.sql.Time.class;
            case Types.TIMESTAMP:
                return java.sql.Timestamp.class;
            case Types.BINARY:
                return byte[].class;
            case Types.VARBINARY:
                return byte[].class;
            case Types.LONGVARBINARY:
                return byte[].class;
            case Types.NULL:
                return null;
            case Types.OTHER:
                return Object.class;
            case Types.JAVA_OBJECT:
                return Object.class;
            case Types.DISTINCT:
                return Object.class;
            case Types.STRUCT:
                return Object.class;
            case Types.ARRAY:
                return Object[].class;
            case Types.BLOB:
                return byte[].class;
            case Types.CLOB:
                return String.class;
            case Types.REF:
                return Object.class;
            case Types.DATALINK:
                return Object.class;
            case Types.BOOLEAN:
                return Boolean.class;
            case Types.ROWID:
                return Object.class;
            case Types.NCHAR:
                return String.class;
            case Types.NVARCHAR:
                return String.class;
            case Types.LONGNVARCHAR:
                return String.class;
            case Types.NCLOB:
                return String.class;
            case Types.SQLXML:
                return String.class;
        }

        return null;
    }

    public static String toUpperFirst(String str) {
        return str.replaceFirst("^" + str.substring(0, 1), str.substring(0, 1).toUpperCase());
    }
}

