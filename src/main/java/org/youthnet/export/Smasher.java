package org.youthnet.export;

import com.healthmarketscience.jackcess.Column;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;
import org.apache.commons.lang.StringEscapeUtils;
import org.youthnet.export.domain.vb3.Lookups;
import org.youthnet.export.migration.*;
import org.youthnet.export.util.CSVUtil;
import org.youthnet.export.util.JavaCodeUtil;
import org.youthnet.export.util.SQLCodeUtil;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.*;

/**
 * User: karl
 * Date: 28-Jun-2010
 */
public class Smasher {

    public static final String OUTPUT_DIR = "smashed";
    public static final String CSV_DIR = "csv";
    public static final String SQL_DIR = "sql";
    public static final String SQL_PRE = "pre";
    public static final String SQL_POST = "post";
    public static final String LOGS_DIR = "logs";
    public static final String JAVA_DIR = "java";
    public static final String MIGRATED_DIR = "migrated";
    public static final char CSV_ENCLOSURE = '¬';
    public static final char CSV_DELIMITER = '|';

    public static void main(String[] args) {

        if (args.length > 0) {
            File accessDBFile = new File(args[0]);
            BufferedWriter fileOutWriter = null;

            Migratable migratable = null;

            try {
                Database accessDatabase = Database.open(accessDBFile);
                Set<String> tableNames = accessDatabase.getTableNames();

                File outputDir = new File(OUTPUT_DIR);
                if (!outputDir.isDirectory()) outputDir.mkdir();

                outputDir = new File(OUTPUT_DIR + "/" + CSV_DIR);
                if (!outputDir.isDirectory()) outputDir.mkdir();

                outputDir = new File(OUTPUT_DIR + "/" + SQL_DIR);
                if (!outputDir.isDirectory()) outputDir.mkdir();

                outputDir = new File(OUTPUT_DIR + "/" + SQL_DIR + "/" + SQL_PRE);
                if (!outputDir.isDirectory()) outputDir.mkdir();

                outputDir = new File(OUTPUT_DIR + "/" + SQL_DIR + "/" + SQL_POST);
                if (!outputDir.isDirectory()) outputDir.mkdir();

                outputDir = new File(OUTPUT_DIR + "/" + LOGS_DIR);
                if (!outputDir.isDirectory()) outputDir.mkdir();

                outputDir = new File(OUTPUT_DIR + "/" + JAVA_DIR);
                if (!outputDir.isDirectory()) outputDir.mkdir();

                outputDir = new File(OUTPUT_DIR + "/" + MIGRATED_DIR);
                if (!outputDir.isDirectory()) outputDir.mkdir();

                System.out.println("Tables:");

                for (String tableName : tableNames) {
                    Table table = accessDatabase.getTable(tableName);
                    System.out.println("    Processing table: " + tableName
                            + " Number of rows: " + table.getRowCount());


                    fileOutWriter = new BufferedWriter(new FileWriter(OUTPUT_DIR + "/" + tableName + ".ctl"));
                    fileOutWriter.write(generateCTLString(table));
                    fileOutWriter.flush();
                    fileOutWriter.close();

                    fileOutWriter = new BufferedWriter(new FileWriter(OUTPUT_DIR + "/" + SQL_DIR + "/" + SQL_PRE
                            + "/create" + tableName + ".sql"));
                    fileOutWriter.write(generateSQLCreateString(table));
                    fileOutWriter.flush();
                    fileOutWriter.close();

                    fileOutWriter = new BufferedWriter(new FileWriter(OUTPUT_DIR + "/" + JAVA_DIR + "/"
                            + JavaCodeUtil.toUpperFirst(tableName) + ".java"));
                    fileOutWriter.write(generateJavaClass(table));
                    fileOutWriter.flush();
                    fileOutWriter.close();

                    fileOutWriter = new BufferedWriter(new FileWriter(OUTPUT_DIR + "/" + CSV_DIR + "/" + tableName
                            + ".csv"));
                    outputRowCSVString(table, fileOutWriter);
                    fileOutWriter.flush();
                    fileOutWriter.close();
                }

                fileOutWriter = new BufferedWriter(new FileWriter(OUTPUT_DIR + "/" + SQL_DIR + "/" + SQL_PRE
                        + "/dropTables.sql"));
                fileOutWriter.write(generateSQLDropString(accessDatabase));
                fileOutWriter.flush();
                fileOutWriter.close();

                fileOutWriter = new BufferedWriter(new FileWriter(OUTPUT_DIR + "/" + SQL_DIR + "/" + SQL_PRE
                        + "/runTableCreates.sh"));
                fileOutWriter.write(generateSQLCreateRunScript(accessDatabase));
                fileOutWriter.flush();
                fileOutWriter.close();

                fileOutWriter = new BufferedWriter(new FileWriter(OUTPUT_DIR + "/" + SQL_DIR + "/" + SQL_PRE
                        + "/runTableDops.sh"));
                fileOutWriter.write(generateSQLDropRunScript());
                fileOutWriter.flush();
                fileOutWriter.close();

                fileOutWriter = new BufferedWriter(new FileWriter(OUTPUT_DIR + "/runSQLLoader.sh"));
                fileOutWriter.write(generateSQLLoaderRunScript(accessDatabase));
                fileOutWriter.flush();
                fileOutWriter.close();

                System.out.println("Migrating lookups.");
                migratable = new LookupsMigration();
                migratable.migrate(OUTPUT_DIR + "/" + CSV_DIR + "/", OUTPUT_DIR + "/" + MIGRATED_DIR + "/");

                Map<String, Map<String, Lookups>> lookupsMap =
                        CSVUtil.createDiscriminatorValueMap(OUTPUT_DIR + "/" + MIGRATED_DIR +
                                "/Lookups.csv", Lookups.class);

                System.out.println("Migrating volunteers.");
                migratable = new VolunteersMigration(lookupsMap);
                migratable.migrate(OUTPUT_DIR + "/" + CSV_DIR + "/", OUTPUT_DIR + "/" + MIGRATED_DIR + "/");

                System.out.println("Migrating organisation.");
                migratable = new OrganisationsMigration(lookupsMap);
                migratable.migrate(OUTPUT_DIR + "/" + CSV_DIR + "/", OUTPUT_DIR + "/" + MIGRATED_DIR + "/");

                System.out.println("Migrating organisation.");
                migratable = new OrganisationVuoMigration(lookupsMap);
                migratable.migrate(OUTPUT_DIR + "/" + CSV_DIR + "/", OUTPUT_DIR + "/" + MIGRATED_DIR + "/");

                System.out.println("Migrating opportunities.");
                migratable = new OpportunitiesMigration(lookupsMap);
                migratable.migrate(OUTPUT_DIR + "/" + CSV_DIR + "/", OUTPUT_DIR + "/" + MIGRATED_DIR + "/");

                System.out.println("Migrating activity logs.");
                migratable = new ActivityLogsMigration(lookupsMap);
                migratable.migrate(OUTPUT_DIR + "/" + CSV_DIR + "/", OUTPUT_DIR + "/" + MIGRATED_DIR + "/");

            } catch (IOException e) {
                System.out.println("Error processing the ms access file.\n Error: " + e.getMessage());
            } finally {
                if (fileOutWriter != null) {
                    try {
                        fileOutWriter.close();
                    } catch (IOException e) {
                        System.out.println("Failed to close the file output stream: " + e.getMessage());
                    }
                }
            }
        } else {
            System.out.println("Usage: Smasher <path to access file>");
        }
    }

    private static String generateSQLCreateRunScript(Database database) {
        StringBuffer columnStringBuffer = new StringBuffer();
        Set<String> tableNames = database.getTableNames();

        columnStringBuffer.append("if [ -n $1 -a -n $2 ]; then\n");

        for (String tableName : tableNames) {
            columnStringBuffer.append(" echo \"Processing: ");
            columnStringBuffer.append(tableName);
            columnStringBuffer.append("\"\n sqlplus -S $1/$2@oradb.dev.thesite.org.uk:1521/oradev @create");
            columnStringBuffer.append(tableName);
            columnStringBuffer.append(".sql\n\n");
        }

        columnStringBuffer.append("else\n   echo \"Usage: $0 <username> <password>\"\nfi\n");

        return columnStringBuffer.toString();
    }

    private static String generateSQLDropRunScript() {
        StringBuffer columnStringBuffer = new StringBuffer();

        columnStringBuffer.append("if [ -n $1 -a -n $2 ]; then\n");

        columnStringBuffer.append(" sqlplus -S $1/$2@oradb.dev.thesite.org.uk:1521/oradev @dropTables.sql\n");

        columnStringBuffer.append("else\n   echo \"Usage: $0 <username> <password>\"\nfi\n");

        return columnStringBuffer.toString();
    }

    private static String generateSQLLoaderRunScript(Database database) {
        StringBuffer columnStringBuffer = new StringBuffer();
        Set<String> tableNames = database.getTableNames();

        columnStringBuffer.append("if [ -n $1 -a -n $2 ]; then\n");

        int count = 1;
        for (String tableName : tableNames) {
            columnStringBuffer.append("echo \"Processing: ");
            columnStringBuffer.append(tableName);
            columnStringBuffer.append("\" && sqlldr $1/$2@oradb.dev.thesite.org.uk:1521/oradev control=");
            columnStringBuffer.append(tableName);
            columnStringBuffer.append(".ctl rows=5000 > ");
            columnStringBuffer.append(LOGS_DIR);
            columnStringBuffer.append("/");
            columnStringBuffer.append(tableName);
            columnStringBuffer.append(".process.log");

            if ((count % 4) == 0) columnStringBuffer.append(" && date&\n\n");
            else columnStringBuffer.append(" && ");

            count++;
        }

        columnStringBuffer.replace(columnStringBuffer.length() - 3, columnStringBuffer.length(), "");

        columnStringBuffer.append("\nelse\n   echo \"Usage: $0 <username> <password>\"\nfi\n");

        return columnStringBuffer.toString();
    }

    private static String generateCTLString(Table table) {
        StringBuffer columnStringBuffer = new StringBuffer();
        String tableName = table.getName();

        columnStringBuffer.append("load data\n");
        columnStringBuffer.append(" infile \"");
        columnStringBuffer.append(CSV_DIR);
        columnStringBuffer.append("/");
        columnStringBuffer.append(tableName);
        columnStringBuffer.append(".csv\" \"str '|\\n'\"\n");
        columnStringBuffer.append(" into table ");
        columnStringBuffer.append(tableName);
        columnStringBuffer.append("\n fields terminated by '\\|' optionally enclosed by '¬' TRAILING NULLCOLS\n (\n");

        for (Column column : table.getColumns()) {

            try {
                switch (column.getSQLType()) {
                    case Types.LONGVARCHAR: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        columnStringBuffer.append(" CHAR(40000)");
                        break;
                    }
                    case Types.VARCHAR: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        columnStringBuffer.append(" CHAR(");
                        columnStringBuffer.append(column.getLength());
                        columnStringBuffer.append(")");
                        break;
                    }
                    case Types.TIMESTAMP: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        columnStringBuffer.append(" TIMESTAMP 'yyyy-mm-dd HH24:MI:SS.FF1'");
                        break;
                    }
                    default: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        break;
                    }
                }
            } catch (SQLException e) {
                System.out.println("        -- Error  could not get type for " + column.getName().toLowerCase()
                        + " name. Error: " + e.getMessage());
            }

            columnStringBuffer.append(",\n");
        }

        columnStringBuffer.replace(columnStringBuffer.length() - 2, columnStringBuffer.length(), "");
        columnStringBuffer.append(")");

        return columnStringBuffer.toString();
    }

    private static String generateSQLCreateString(Table table) {
        StringBuffer columnStringBuffer = new StringBuffer();
        String tableName = table.getName();

        columnStringBuffer.append("CREATE TABLE ");
        columnStringBuffer.append(tableName);
        columnStringBuffer.append(" (\n");

        for (Column column : table.getColumns()) {

            try {
                switch (column.getSQLType()) {
                    case Types.SMALLINT: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        columnStringBuffer.append(" SMALLINT");
                        break;
                    }
                    case Types.INTEGER: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        columnStringBuffer.append(" NUMBER");
                        break;
                    }
                    case Types.NUMERIC: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        columnStringBuffer.append(" NUMERIC");
                        break;
                    }
                    case Types.BOOLEAN: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        columnStringBuffer.append(" NUMBER(1,0)");
                        break;
                    }
                    case Types.LONGVARCHAR: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        columnStringBuffer.append(" CLOB");
                        break;
                    }
                    case Types.VARCHAR: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        columnStringBuffer.append(" VARCHAR2(");
                        columnStringBuffer.append(column.getLength());
                        columnStringBuffer.append(")");
                        break;
                    }
                    case Types.TIMESTAMP: {
                        columnStringBuffer.append(column.getName().toLowerCase());
                        columnStringBuffer.append("_");
                        columnStringBuffer.append(" TIMESTAMP");
                        break;
                    }
                }
            } catch (SQLException e) {
                System.out.println("        -- Error  could not get type for " + column.getName().toLowerCase()
                        + " name. Error: " + e.getMessage());
            }

            columnStringBuffer.append(",\n");
        }

        columnStringBuffer.replace(columnStringBuffer.length() - 2, columnStringBuffer.length(), "");
        columnStringBuffer.append("\n);\nQUIT;");

        return columnStringBuffer.toString();
    }

    private static String generateSQLDropString(Database database) {
        StringBuffer columnStringBuffer = new StringBuffer();
        Set<String> tableNames = database.getTableNames();

        for (String tableName : tableNames) {
            columnStringBuffer.append("DROP TABLE ");
            columnStringBuffer.append(tableName);
            columnStringBuffer.append(";\n");
        }

        columnStringBuffer.append("\nQUIT;");

        return columnStringBuffer.toString();
    }

    private static String generateSQLDeleteString(Database database) {
        StringBuffer columnStringBuffer = new StringBuffer();
        Set<String> tableNames = database.getTableNames();

        for (String tableName : tableNames) {
            columnStringBuffer.append("DELETE FROM ");
            columnStringBuffer.append(tableName);
            columnStringBuffer.append(";\n");
        }

        columnStringBuffer.append("\nQUIT;");

        return columnStringBuffer.toString();
    }

    private static String generateJavaClass(Table table) {
        StringBuffer classStringBuffer = new StringBuffer("package org.youthnet.export.domain.vb25;\n\n");
        String tableName = table.getName();
        Set<String> imports = new HashSet<String>(); // Set to hold any imports that might be needed.
        boolean hasDates = false; // Flag to be set if the class contains date types.
        boolean hasVid = false; // Flag to be set if the class contains a vid attribute.
        boolean hasOid = false; // Flag to be set if the class contains a vid attribute.
        boolean hasOrgid = false; // Flag to be set if the class contains a vid attribute.
        // Get the name for the new java class. This will be the tale name with the first letter capitalised.
        String className = JavaCodeUtil.toUpperFirst(tableName);
        List<Column> columns = table.getColumns(); // List to contain the tables columns.
        // Get the number of attributes that the java class, this is equal to the number of columns since that is what they will be made from.
        int attributeNum = columns.size();
        // Create a 2D array to hold the attribute names and related types.
        // This is only every going to be iterated through so it can be a simple 2D array.
        String[][] attributes = new String[attributeNum][2];

        // Populate the attributes array with the names and types for the new java classes attributes..
        String name = ""; // Variable to hold the name of the java attribute.
        Class type = null; // Variable to hold the java type of the attribute.
        String[] typePath = null; // Array to hold the package path and class name of the java type.
        for (int i = 0; i < attributeNum; i++) {
            // Record the column name lower cased fo the attribute name.
            name = columns.get(i).getName().toLowerCase();
            if (name.equals("vid") && !hasVid) hasVid = true; // Record if this class contains a vid.
            if (name.equals("oid") && !hasOid) hasOid = true; // Record if this class contains an oid.
            if (name.equals("orgid") && !hasOrgid) hasOrgid = true; // Record if this class contains an orgid.
            // If the attribute represents a java keyword append an '_' to the start.
            if (JavaCodeUtil.isKeyword(name)) name = "_" + name;
            attributes[i][0] = name;
            try {
                type = JavaCodeUtil.javaTypeForSQLType(columns.get(i).getSQLType()); // Record the java type of the attribute.
                if (!type.getName().contains("lang")) { // If the attribute type is not a default Java type...
                    imports.add("import " + type.getName() + ";");
                    if (type.getSuperclass().getSimpleName().equals("Date") && !hasDates) hasDates = true;
                }
                attributes[i][1] = type.getSimpleName();
            } catch (SQLException e) {
                System.out.println("Could not get SQL type for for column " + attributes[i][0] + " in table "
                        + tableName + ". Error: " + e.getMessage());
            }
        }


        // Add the imports.
        classStringBuffer.append("import org.youthnet.export.domain.CSVable;\n\n");
        for (String imp : imports) {
            classStringBuffer.append(imp);
            classStringBuffer.append("\n");
        }
        classStringBuffer.append("import java.util.List;\n");
        classStringBuffer.append("import java.util.ArrayList;\n");

        // If there are date classes within the imports then also import the classes required to pars dates.
        if (hasDates) {
            classStringBuffer.append("import java.text.ParseException;\nimport java.text.SimpleDateFormat;\n");
        }
        classStringBuffer.append("\n\n");

        // Add the class name and constants.
        classStringBuffer.append("public class ");
        classStringBuffer.append(className);
        classStringBuffer.append(" implements CSVable");
        if (hasVid)
            classStringBuffer.append(", ContainsVid"); // If this class contains a vid implement the supporting interface.
        if (hasOid)
            classStringBuffer.append(", ContainsOid"); // If this class contains an Oid implement the supporting interface.
        if (hasOrgid)
            classStringBuffer.append(", ContainsOrgid"); // If this class contains an Orgid implement the supporting interface.
        classStringBuffer.append(" {\n\n\tprivate char delimiter = '");
        classStringBuffer.append(CSV_DELIMITER);
        classStringBuffer.append("';\n");
        classStringBuffer.append("\tprivate char enclosure = '");
        classStringBuffer.append(CSV_ENCLOSURE);
        classStringBuffer.append("';\n\n");
        classStringBuffer.append("\tpublic static final int COLUMN_NUM = ");
        classStringBuffer.append(attributeNum);
        classStringBuffer.append(";\n\n");
        classStringBuffer.append("\tprivate List<String[]> columnNames = null;\n\n");
        classStringBuffer.append("\tprivate StringBuffer record = new StringBuffer();\n\n");

        StringBuffer initAttributesStringBuffer = new StringBuffer();
        // Add the attributes and create the code that will be used to initialise the attributes..
        for (int i = 0; i < attributes.length; i++) {
            classStringBuffer.append("\tprivate ");
            classStringBuffer.append(attributes[i][1]);
            classStringBuffer.append(" ");
            classStringBuffer.append(attributes[i][0]);
            classStringBuffer.append(";\n");

            if (attributes[i][1].equals("Short")) {
                initAttributesStringBuffer.append("\t\tthis.");
                initAttributesStringBuffer.append(attributes[i][0]);
                initAttributesStringBuffer.append(" = (fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\").equals(\"\")) ? null : Short.valueOf(fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\"));\n");
            }

            if (attributes[i][1].equals("Integer")) {
                initAttributesStringBuffer.append("\t\t\tthis.");
                initAttributesStringBuffer.append(attributes[i][0]);
                initAttributesStringBuffer.append(" = (fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\").equals(\"\")) ? null : Integer.valueOf(fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\"));\n");
            }

            if (attributes[i][1].equals("Long")) {
                initAttributesStringBuffer.append("\t\tthis.");
                initAttributesStringBuffer.append(attributes[i][0]);
                initAttributesStringBuffer.append(" = (fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\").equals(\"\")) ? null : Long.valueOf(fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\"));\n");
            }

            if (attributes[i][1].equals("BigDecimal")) {
                initAttributesStringBuffer.append("\t\ttry{\n\t\t\tthis.");
                initAttributesStringBuffer.append(attributes[i][0]);
                initAttributesStringBuffer.append(" = (fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\").equals(\"\")) ? null : new BigDecimal(fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\"));\n\t\t} catch (NumberFormatException e) {\n\t\t\t");
                initAttributesStringBuffer.append("System.out.println(\"Could not pars ");
                initAttributesStringBuffer.append(attributes[i][0]);
                initAttributesStringBuffer.append(" BigDecimal \" + fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].substring(1, fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].length() - 1)\n\t\t\t\t+ \" in row \" + this.");
                initAttributesStringBuffer.append(attributes[0][0]);
                initAttributesStringBuffer.append("+ \" for table \" + this.getClass().getName() + \". Error: \"");
                initAttributesStringBuffer.append("+ e.getMessage());\n\t\t}\n");
            }

            if (attributes[i][1].equals("String")) {
                initAttributesStringBuffer.append("\t\tthis.");
                initAttributesStringBuffer.append(attributes[i][0]);
                initAttributesStringBuffer.append(" = fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\");\n");
            }

            if (attributes[i][1].equals("Boolean")) {
                initAttributesStringBuffer.append("\t\tthis.");
                initAttributesStringBuffer.append(attributes[i][0]);
                initAttributesStringBuffer.append(" = fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\").equals(\"1\");\n");
            }

            if (attributes[i][1].equals("Date")
                    || attributes[i][1].equals("Time")
                    || attributes[i][1].equals("Timestamp")) {
                initAttributesStringBuffer.append("\t\ttry {\n\t\t\tthis.");
                initAttributesStringBuffer.append(attributes[i][0]);
                initAttributesStringBuffer.append(" = (fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\").equals(\"\")) ? null : new ");
                initAttributesStringBuffer.append(attributes[i][1]);
                initAttributesStringBuffer.append("(\n\t\t\t\tsimpleDateFormat.parse(fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\")).getTime());\n\t\t} catch (ParseException e) {\n");
                initAttributesStringBuffer.append("\t\t\tSystem.out.println(\"Could not pars ");
                initAttributesStringBuffer.append(attributes[i][0]);
                initAttributesStringBuffer.append(" ");
                initAttributesStringBuffer.append(attributes[i][1]);
                initAttributesStringBuffer.append(" \" + fields[");
                initAttributesStringBuffer.append(i);
                initAttributesStringBuffer.append("].replace(String.valueOf(this.enclosure), \"\")\n\t\t\t\t+ \" in row \" + this.");
                initAttributesStringBuffer.append(attributes[0][0]);
                initAttributesStringBuffer.append("+ \" for table \" + this.getClass().getName() + \". Error: \"");
                initAttributesStringBuffer.append("+ e.getMessage());\n\t\t}\n");
            }
        }
        classStringBuffer.append("\n\n");

        // Add the constructors.
        classStringBuffer.append("\tpublic ");
        classStringBuffer.append(className);
        classStringBuffer.append("() {}\n\n");
        classStringBuffer.append("\tpublic ");
        classStringBuffer.append(className);
        classStringBuffer.append("(String record) {\n\t\tinit(record);\n\t}\n\n");

        // Add the init method.
        classStringBuffer.append("\tpublic void init(String record) {\n\t\tString[] fields = record.split(\"\\\\\" + String.valueOf(this.delimiter));\n");
        if (hasDates) { // If there are date attributes then a date formatter will be needed.
            classStringBuffer.append("\t\tSimpleDateFormat simpleDateFormat = new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss.S\");\n\n");
        } else classStringBuffer.append("\n\n");

        // Add the initialisation code string.
        classStringBuffer.append(initAttributesStringBuffer);
        classStringBuffer.append("\t}\n\n");

        // Add getter methods.
        for (String[] attribute : attributes) {
            classStringBuffer.append("\tpublic ");
            classStringBuffer.append(attribute[1]);
            classStringBuffer.append(" get");
            classStringBuffer.append(JavaCodeUtil.toUpperFirst(attribute[0].replace("_", "")));
            classStringBuffer.append("() {\n\t\treturn this.");
            classStringBuffer.append(attribute[0]);
            classStringBuffer.append(";\n\t}\n\n");
        }

        // Add the delimiter getter/setter.
        classStringBuffer.append("\tpublic char getDelimiter() {\n\t\treturn this.delimiter;\n\t}\n\n");
        classStringBuffer.append("\tpublic void setDelimiter(char delimiter) {\n\t\tthis.delimiter = delimiter;\n\t}\n\n");

        // Add the delimiter getter/setter.
        classStringBuffer.append("\tpublic char getEnclosure() {\n\t\treturn this.enclosure;\n\t}\n\n");
        classStringBuffer.append("\tpublic void setEnclosure(char enclosure) {\n\t\tthis.enclosure = enclosure;\n\t}\n\n");

        // Add column number getter.
        classStringBuffer.append("\tpublic Integer getColumnNumber() {\n\t\treturn COLUMN_NUM;\n\t}\n\n");

        // Add column name getter.
        classStringBuffer.append("\tpublic List<String[]> getColumnNames() {\n\t\tif (this.columnNames == null) {\n\t\t\tcolumnNames = new ArrayList<String[]>();\n");
        for (Column column : columns) {
            classStringBuffer.append("\t\t\tcolumnNames.add(new String[]{\"");
            classStringBuffer.append(column.getName());
            classStringBuffer.append(", ");
            try {
                classStringBuffer.append(JavaCodeUtil.javaTypeForSQLType(column.getSQLType()).getSimpleName());
            } catch (SQLException e) {
                System.out.println("Could not get SQL type for for column " + column.getName() + " in table "
                        + tableName + ". Error: " + e.getMessage());
            }
            classStringBuffer.append("\"});\n");
        }
        classStringBuffer.append("\t\t}\n\n");
        classStringBuffer.append("\t\treturn columnNames;");
        classStringBuffer.append("\t}\n\n");

        // Add column name getter.
        classStringBuffer.append("\tpublic String getRecord() {\n\t\trecord.setLength(0);\n\n");
        for (String[] attribute : attributes) {
            classStringBuffer.append("\t\trecord.append(this.enclosure);\n");
            classStringBuffer.append("\t\trecord.append(this.");
            if (attribute[1].equals("Boolean")) {
                classStringBuffer.append(attribute[0]);
                classStringBuffer.append(" != null && ");
                classStringBuffer.append(attribute[0]);
                classStringBuffer.append(" ? 1 : 0");
            } else {
                classStringBuffer.append(attribute[0]);
                classStringBuffer.append(" == null ? \"\" : this.");
                classStringBuffer.append(attribute[0]);
            }
            classStringBuffer.append(");\n\t\trecord.append(this.enclosure);\n");
            classStringBuffer.append("\t\trecord.append(this.delimiter);\n");
        }
        classStringBuffer.append("\n\t\treturn record.toString();");
        classStringBuffer.append("\n\t}\n");

        // Close off class.
        classStringBuffer.append("}\n");

        return classStringBuffer.toString();
    }

    private static boolean outputRowCSVString(Table table, BufferedWriter bufferedWriter) {
        List<Column> columns = table.getColumns(); // Get the tables column names.
        StringBuffer rowStringBuffer = null; // String buffer to hold the rows.

        for (Column column : columns) {
            try {
                System.out.println("        -- Column name: " + column.getName().toLowerCase()
                        + " length: " + column.getLength() + " type: " + SQLCodeUtil.getSQLTypeName(column.getSQLType()));
            } catch (SQLException e) {
                System.out.println("        -- Error  could not get type for " + column.getName().toLowerCase()
                        + " name. Error: " + e.getMessage());
            }
        }

        Object id = null; // Variable to hold the id of the row that is being processed.

        Map<String, Object> row = null; // Map to hold the data of the row that has been exctracted from the access table.
        Column column = null; // Variable to hold the data for the column that is being processed.
        for (int i = 0; i < table.getRowCount(); i++) { // Iterate through the rows.
            try {
                row = table.getNextRow(); // Get the next row.
                // Create a new string buffer so that it's memory footprint is as small as possible to begin with.
                // Also hopefully the previous string buffer will be garbage collected...
                rowStringBuffer = new StringBuffer();

                if (row != null) { // If the row is null don't bother doing anything and move to the next one.

                    for (int j = 0; j < columns.size(); j++) { // Iterate through the columns in this row.
                        column = columns.get(j); // Get the next column.
                        Object value = row.get(column.getName()); // Get the value that is related to that column.

                        // If this is the first column assume it is the id and record it for logging.
                        if (j == 0) id = value;

                        rowStringBuffer.append(CSV_ENCLOSURE); // Add an enclosing character to the start of the value.

                        if (value != null) { // If the value is null then don't bother trying to process it.
                            if (value instanceof String) { // The value is a string...
                                String valueString = (String) value; // Cast the value to a string so it's easier to work with.

                                // Check to see if it is an Activity log notes string...
                                if (table.getName().equals("tblActivityLog") && column.getName().equals("Notes")) {
                                    value = extractTextFromRTFNotes(value); // ...if it is extract the plain text from it.
                                    // If the text has successfully been extracted place it into the valueString.
                                    if (value != null) valueString = (String) value;
                                }

                                valueString = valueString.trim(); // Trim the string to remove any surrounding spaces.

                                valueString = StringEscapeUtils.escapeSql(valueString); // Sanitize the string.

                                // Make sure that neither the enclosing or delimiting characters are in the string.
                                valueString = valueString.replaceAll(String.valueOf(CSV_ENCLOSURE), "[[ENCL]]");
                                valueString = valueString.replaceAll("\\" + CSV_DELIMITER, "[[DELM]]");
                                valueString = valueString.replaceAll("\\\\'", "\\\\\\\\'"); // Then escape any single quotes.

                                rowStringBuffer.append(valueString); // Add the final string to the row string buffer.
                            } else if (value instanceof java.util.Date) { // If the value is a date...
                                // ...convert it to a timestamp string.
                                rowStringBuffer.append((new Timestamp(((Date) value).getTime())));
                            } else if (value instanceof Boolean) { // If the value is a boolean...
                                if (((Boolean) value)) {
                                    rowStringBuffer.append(1); // ...convert it to 1 for true...
                                } else {
                                    rowStringBuffer.append(0); // ...or 0 for false.
                                }
                            } else {
                                rowStringBuffer.append(value);
                            }
                        }
                        rowStringBuffer.append(CSV_ENCLOSURE); // Add another enclosing character to the end of the value.
                        rowStringBuffer.append(CSV_DELIMITER); // Add the delimiter to separate the different values.
                    }

                    rowStringBuffer.append("\n"); // Add a new line to indicate the end of this record.
                    bufferedWriter.write(rowStringBuffer.toString()); // Write the record out to the file.
                } else {
                    System.out.println("        -- Row " + i + " is null.\n"); // If the row is null log it.
                }
            } catch (IOException e) {
                // If there was a issue with the row log it.
                System.out.println("        -- Problem reading column number " + id + " from " + table.getName() + " table. Error: " + e.getMessage() + "\n");
            }

        }

        return true;
    }

    public static String extractTextFromRTFNotes(Object value) {
        String extractedText = null; // Value to hold the text that is extracted from the rich text. 

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream(); // Stream to used to get the object as a byte array.
            ObjectOutputStream oos = new ObjectOutputStream(bos); // Stream to hold and pipe the object into the byte array stream.
            oos.writeObject(value); // Pipe the object into the byte array stream.
            oos.flush(); // Flush to the stream to make sure it is all in there.
            oos.close(); // Close of the streams since nothing more will be going in.
            bos.close();
            byte[] data = bos.toByteArray(); // Get the object as a byte array.
            ByteArrayInputStream noteStream = new ByteArrayInputStream(data); // Pipe the byte array into an input stream.
            RTFEditorKit rtfEditorKit = new RTFEditorKit(); // Create a swing RTF editor top hold the RTF data that we have.
            // Get the document object for the RTF editor, this is where the RTF data will be placed.
            Document rtfDocument = rtfEditorKit.createDefaultDocument();
            rtfEditorKit.read(noteStream, rtfDocument, 0); // Read the RTF data into the document.
            // Request the plain text from the document and place it into the string that will be returned.
            extractedText = rtfDocument.getText(0, rtfDocument.getLength());
        } catch (BadLocationException e) {
            System.out.println("        -- Error converting ritch text: "
                    + e.getMessage() + "\n");
        } catch (IOException e) {
            System.out.println("        -- Error converting ritch text: "
                    + e.getMessage() + "\n");
        }

        return extractedText; // Return the extracted text.
    }
}
