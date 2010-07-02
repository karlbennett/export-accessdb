package org.youthnet.export;

import com.healthmarketscience.jackcess.Column;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;
import org.apache.commons.lang.StringEscapeUtils;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * User: karl
 * Date: 28-Jun-2010
 */
public class Smasher {

    public static final String CSV_ENCLOSURE = "¬";
    public static final String CSV_DELIMITER = "|";

    public static void main(String[] args) {

        if (args.length > 0) {
            File accessDBFile = new File(args[0]);
            BufferedWriter fileOutWriter = null;
            try {
                Database accessDatabase = Database.open(accessDBFile);
                Set<String> tableNames = accessDatabase.getTableNames();

                File outputDir = new File("output");
                if (!outputDir.isDirectory()) outputDir.mkdir();

                outputDir = new File("output/csv");
                if (!outputDir.isDirectory()) outputDir.mkdir();

                outputDir = new File("output/sql");
                if (!outputDir.isDirectory()) outputDir.mkdir();

                outputDir = new File("output/sql/pre");
                if (!outputDir.isDirectory()) outputDir.mkdir();

                outputDir = new File("output/sql/post");
                if (!outputDir.isDirectory()) outputDir.mkdir();

                outputDir = new File("output/logs");
                if (!outputDir.isDirectory()) outputDir.mkdir();

                System.out.println("Tables:");

                for (String tableName : tableNames) {
                    Table table = accessDatabase.getTable(tableName);
                    System.out.println("    Processing table: " + tableName
                            + " Number of rows: " + table.getRowCount());


                    fileOutWriter = new BufferedWriter(new FileWriter("output/" + tableName + ".ctl"));
                    fileOutWriter.write(generateCTLString(table));
                    fileOutWriter.flush();
                    fileOutWriter.close();

                    fileOutWriter = new BufferedWriter(new FileWriter("output/sql/pre/create" + tableName + ".sql"));
                    fileOutWriter.write(generateSQLCreateString(table));
                    fileOutWriter.flush();
                    fileOutWriter.close();

                    fileOutWriter = new BufferedWriter(new FileWriter("output/csv/" + tableName + ".csv"));
                    outputRowCSVString(table, fileOutWriter);
                    fileOutWriter.flush();
                    fileOutWriter.close();
                }

                fileOutWriter = new BufferedWriter(new FileWriter("output/sql/pre/dropTables.sql"));
                fileOutWriter.write(generateSQLDropString(accessDatabase));
                fileOutWriter.flush();
                fileOutWriter.close();

                fileOutWriter = new BufferedWriter(new FileWriter("output/sql/pre/runTableCreates.sh"));
                fileOutWriter.write(generateSQLCreateRunScript(accessDatabase));
                fileOutWriter.flush();
                fileOutWriter.close();

                fileOutWriter = new BufferedWriter(new FileWriter("output/sql/pre/runTableDops.sh"));
                fileOutWriter.write(generateSQLDropRunScript());
                fileOutWriter.flush();
                fileOutWriter.close();

                fileOutWriter = new BufferedWriter(new FileWriter("output/runSQLLoader.sh"));
                fileOutWriter.write(generateSQLLoaderRunScript(accessDatabase));
                fileOutWriter.flush();
                fileOutWriter.close();
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
            columnStringBuffer.append(".ctl rows=5000 > logs/");
            columnStringBuffer.append(tableName);
            columnStringBuffer.append(".process.log");

            if((count % 4) == 0) columnStringBuffer.append(" && date&\n\n");
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
        columnStringBuffer.append(" infile \"csv/");
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

    private static boolean outputRowCSVString(Table table, BufferedWriter bufferedWriter) {
        List<Column> columns = table.getColumns(); // Get the tables column names.
        StringBuffer rowStringBuffer = null; // String buffer to hold the rows.

        for (Column column : columns) {
            try {
                System.out.println("        -- Column name: " + column.getName().toLowerCase()
                        + " length: " + column.getLength() + " type: " + getSQLType(column.getSQLType()));
            } catch (SQLException e) {
                System.out.println("        -- Error  could not get type for " + column.getName().toLowerCase() + " name. Error: "
                        + e.getMessage());
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
                                valueString = valueString.replaceAll("¬", "(TICK)");
                                valueString = valueString.replaceAll("\\|", "(PIPE)");
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

    private static String getSQLType(int type) {

        switch (type) {

            case Types.BIT:
                return "BIT";
            case Types.TINYINT:
                return "TINYINT";
            case Types.SMALLINT:
                return "SMALLINT";
            case Types.INTEGER:
                return "INTEGER";
            case Types.BIGINT:
                return "BIGINT";
            case Types.FLOAT:
                return "FLOAT";
            case Types.REAL:
                return "REAL";
            case Types.DOUBLE:
                return "DOUBLE";
            case Types.NUMERIC:
                return "NUMERIC";
            case Types.DECIMAL:
                return "DECIMAL";
            case Types.CHAR:
                return "CHAR";
            case Types.VARCHAR:
                return "VARCHAR";
            case Types.LONGVARCHAR:
                return "LONGVARCHAR";
            case Types.DATE:
                return "DATE";
            case Types.TIME:
                return "TIME";
            case Types.TIMESTAMP:
                return "TIMESTAMP";
            case Types.BINARY:
                return "BINARY";
            case Types.VARBINARY:
                return "VARBINARY";
            case Types.LONGVARBINARY:
                return "LONGVARBINARY";
            case Types.NULL:
                return "NULL";
            case Types.OTHER:
                return "OTHER";
            case Types.JAVA_OBJECT:
                return "JAVA_OBJECT";
            case Types.DISTINCT:
                return "DISTINCT";
            case Types.STRUCT:
                return "STRUCT";
            case Types.ARRAY:
                return "ARRAY";
            case Types.BLOB:
                return "BLOB";
            case Types.CLOB:
                return "CLOB";
            case Types.REF:
                return "REF";
            case Types.DATALINK:
                return "DATALINK";
            case Types.BOOLEAN:
                return "BOOLEAN";
            case Types.ROWID:
                return "ROWID";
            case Types.NCHAR:
                return "NCHAR";
            case Types.NVARCHAR:
                return "NVARCHAR";
            case Types.LONGNVARCHAR:
                return "LONGNVARCHAR";
            case Types.NCLOB:
                return "NCLOB";
            case Types.SQLXML:
                return "SQLXML";
        }

        return null;
    }
}
