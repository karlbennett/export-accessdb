package org.youthnet.export;

import com.healthmarketscience.jackcess.Column;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringEscapeUtils;

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

    public static final String CSV_ENCLOSURE = "¬";
    public static final String CSV_DELIMITER = "|";
    public static final String SQL_ENCLOSURE = "'";
    public static final String SQL_DELIMITER = ", ";

    public static void main(String[] args) {

        if (args.length > 0) {
            File accessDBFile = new File(args[0]);
            BufferedWriter fileOutWriter = null;
            try {
                Database accessDatabase = Database.open(accessDBFile);
                Set<String> tableNames = accessDatabase.getTableNames();

                File outputDir = new File("output");
                if (!outputDir.isDirectory()) outputDir.mkdir();

                System.out.println("Tables:");

                String insertSQL = "";
                for (String tableName : tableNames) {
                    Table table = accessDatabase.getTable(tableName);
                    System.out.println("    Processing table: " + tableName
                            + " Number of rows: " + table.getRowCount());

                    if (args[0].equals("-sql")) {
                        fileOutWriter = new BufferedWriter(new FileWriter("output/" + tableName + ".sql"));
                        insertSQL = createColumnSQLString(table.getColumns(), tableName);
                        outputRowSQLString(table, insertSQL, fileOutWriter);
                    } else {
                        fileOutWriter = new BufferedWriter(new FileWriter("output/" + tableName + ".ctl"));
                        fileOutWriter.write("load data\n" +
                                " infile \"" + tableName + ".csv\" \"str '|\n'\"\n" +
                                " into table " + tableName + "\n" +
                                " fields terminated by '\\|' optionally enclosed by '¬' TRAILING NULLCOLS\n" +
                                " ( " + createColumnCSVString(table.getColumns()) + " )");
                        fileOutWriter.flush();
                        fileOutWriter.close();

                        fileOutWriter = new BufferedWriter(new FileWriter("output/" + tableName + ".csv"));
                        outputRowCSVString(table, fileOutWriter);
                    }
                    fileOutWriter.flush();
                    fileOutWriter.close();
                }
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
            System.out.println("Usage: Smasher [-sql] <path to access file>");
        }
    }

    private static String createColumnSQLString(List<Column> strings, String tableName) {
        StringBuffer columnStringBuffer = new StringBuffer("INSERT INTO ");
        columnStringBuffer.append(tableName);
        columnStringBuffer.append("(");

        for (Column column : strings) {
            try {
                if (Types.DATE == column.getSQLType()) {
                    columnStringBuffer.append(column.getName());
                    columnStringBuffer.append(" TIMESTAMP 'yyyy-mm-dd HH24:MI:SS.FF1'");
                } else columnStringBuffer.append(column.getName());
            } catch (SQLException e) {
                System.out.println("        -- Error cvreating the date column name. Error: " + e.getMessage());
            }
            columnStringBuffer.append(", ");
        }

        columnStringBuffer.replace(columnStringBuffer.length() - 2, columnStringBuffer.length(), "");
        columnStringBuffer.append(") VALUES (");

        return columnStringBuffer.toString();
    }

    private static String createColumnCSVString(List<Column> strings) {
        StringBuffer columnStringBuffer = new StringBuffer();

        for (Column column : strings) {

            try {
                switch(column.getSQLType()) {
                    case Types.LONGVARCHAR: {
                        columnStringBuffer.append(column.getName());
                        columnStringBuffer.append(" CHAR(40000)");
                        break;
                    }
                    case Types.TIMESTAMP: {
                        columnStringBuffer.append(column.getName());
                        columnStringBuffer.append(" TIMESTAMP 'yyyy-mm-dd HH24:MI:SS.FF1'");
                        break;
                    }
                    default: columnStringBuffer.append(column.getName());
                }
            } catch (SQLException e) {
                System.out.println("        -- Error  could not get type for " + column.getName() + " name. Error: "
                        + e.getMessage());
            }


            columnStringBuffer.append(",\n");
        }

        columnStringBuffer.replace(columnStringBuffer.length() - 2, columnStringBuffer.length(), "");

        return columnStringBuffer.toString();
    }

    private static boolean outputRowSQLString(Table table, String insertSQL, BufferedWriter bufferedWriter) {
        List<Column> columns = table.getColumns();
        StringBuffer rowStringBuffer = new StringBuffer();

        Object id = null;

        Map<String, Object> row = null;
        Column column = null;
        for (int i = 0; i < table.getRowCount(); i++) {
            try {
                row = table.getNextRow();
                rowStringBuffer.setLength(0);

                if (row != null) {

                    rowStringBuffer.append(insertSQL);

                    for (int j = 0; j < columns.size(); j++) {
                        column = columns.get(j);
                        Object value = row.get(column.getName());

                        if (column.equals("LID")) id = value;

                        rowStringBuffer.append(SQL_ENCLOSURE);
                        if (value != null) {
                            if (table.getName().equals("tblActivityLog") && column.getName().equals("Notes")) {
                                try {
                                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                                    ObjectOutputStream oos = new ObjectOutputStream(bos);
                                    oos.writeObject(value);
                                    oos.flush();
                                    oos.close();
                                    bos.close();
                                    byte[] data = bos.toByteArray();
                                    RTFEditorKit rtfEditorKit = new RTFEditorKit();
                                    Document rtfDocument = rtfEditorKit.createDefaultDocument();
                                    ByteArrayInputStream noteStream = new ByteArrayInputStream(data);
                                    rtfEditorKit.read(noteStream, rtfDocument, 0);
                                    rowStringBuffer.append(rtfDocument.getText(0, rtfDocument.getLength()));
                                } catch (BadLocationException e) {
                                    System.out.println("        -- Error converting ritch text: "
                                            + e.getMessage() + "\n");
                                } catch (IOException e) {
                                    System.out.println("        -- Error converting ritch text: "
                                            + e.getMessage() + "\n");
                                    rowStringBuffer.append(StringEscapeUtils.escapeSql(((String) value).trim())
                                            .replaceAll("\\\\'", "\\\\\\\\'"));
                                }
                            } else if (value instanceof String) {
                                rowStringBuffer.append("'");
                                rowStringBuffer.append(StringEscapeUtils.escapeSql(((String) value).trim())
                                        .replaceAll("\\\\'", "\\\\\\\\'"));
                                rowStringBuffer.append("', ");
                            } else if (value instanceof java.util.Date) {
                                rowStringBuffer.replace(rowStringBuffer.length() - 1, rowStringBuffer.length(), "");
                                rowStringBuffer.append("TIMESTAMP ");
                                rowStringBuffer.append(SQL_ENCLOSURE);
                                rowStringBuffer.append((new Timestamp(((Date) value).getTime())));
                            } else if (value instanceof Boolean) {
                                if (((Boolean) value)) {
                                    rowStringBuffer.append(1);
                                } else {
                                    rowStringBuffer.append(0);
                                }
                            } else {
                                rowStringBuffer.append("'");
                                rowStringBuffer.append(value);
                            }
                        }
                        rowStringBuffer.append(SQL_ENCLOSURE);
                        rowStringBuffer.append(SQL_DELIMITER);
                    }

                    rowStringBuffer.replace(rowStringBuffer.length() - 1, rowStringBuffer.length(), ");");
                    rowStringBuffer.append("\n");
                    bufferedWriter.write(rowStringBuffer.toString());
                } else {
                    System.out.println("        -- Row " + i + " is null.\n");
                }
            } catch (IOException e) {
                System.out.println("        -- Problem reading column number " + id + " from " + table.getName() + " table. Error: " + e.getMessage() + "\n");
            }
        }

        return true;
    }

    private static boolean outputRowCSVString(Table table, BufferedWriter bufferedWriter) {
        List<Column> columns = table.getColumns(); // Get the tables column names.
        StringBuffer rowStringBuffer = null; // String buffer to hold the rows.

        for (Column column : columns) {
            try {
                System.out.println("        -- Column name: " + column.getName()
                        + " length: " + column.getLength() + " type: " + getSQLType(column.getSQLType()));
            } catch (SQLException e) {
                System.out.println("        -- Error  could not get type for " + column.getName() + " name. Error: "
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

                                // If the value string is longer than a normal varchar2 or it is a LONGVARCHAR (SQL TYPE -1)...
                                try {
                                    if (column.getSQLType() == -1 || column.getLength() > 255) {
                                        // ...then base64 encode it.
                                        valueString = Base64.encodeBase64String(valueString.getBytes());
                                    } else {
                                        // Else just make sure that neither the enclosing or delimiting characters are in the string.
                                        valueString = valueString.replaceAll("¬", "(TICK)");
                                        valueString = valueString.replaceAll("\\|", "(PIPE)");
                                        valueString = valueString.replaceAll("\\\\'", "\\\\\\\\'"); // Then escape any single quotes.
                                    }
                                } catch (SQLException e) {
                                    System.out.println("        -- Error  could not get type for " + column.getName()
                                            + " name. Error: " + e.getMessage());
                                }

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
