package org.youthnet.export;

import com.healthmarketscience.jackcess.Column;
import com.healthmarketscience.jackcess.Cursor;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;
import org.apache.commons.lang.StringEscapeUtils;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;

/**
 * User: karl
 * Date: 28-Jun-2010
 */
public class Smasher {

    public static final String CSV_ENCLOSURE = "\"";
    public static final String CSV_DELIMITER = ",";
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
                                " infile 'output/" + tableName + ".csv'\n" +
                                " into table " + tableName + "\n" +
                                " fields terminated by \",\" optionally enclosed by '\"'\n" +
                                " ( " + createColumnCSVString(table.getColumns())  + " )");
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
            columnStringBuffer.append(column.getName());
            columnStringBuffer.append(", ");
        }

        columnStringBuffer.replace(columnStringBuffer.length() - 2, columnStringBuffer.length(), "");
        columnStringBuffer.append(") VALUES (");

        return columnStringBuffer.toString();
    }

    private static String createColumnCSVString(List<Column> strings) {
        StringBuffer columnStringBuffer = new StringBuffer();

        for (Column column : strings) {
            columnStringBuffer.append(column.getName());
            columnStringBuffer.append(", ");
        }

        columnStringBuffer.replace(columnStringBuffer.length() - 2, columnStringBuffer.length(), "");

        return columnStringBuffer.toString();
    }

    private static boolean outputRowSQLString(Table table, String insertSQL, BufferedWriter bufferedWriter) {
        List<Column> columns = table.getColumns();
        StringBuffer rowStringBuffer = new StringBuffer();

        Object id = null;

        Map<Object, List> bigMap = new HashMap<Object, List>();

        Map<String, Object> row = null;
        Column column = null;
        List values = null;
        for (int i = 0; i < table.getRowCount(); i++) {
            try {
                row = table.getNextRow();
                rowStringBuffer.setLength(0);

                if (row != null) {

                    values = new ArrayList();

                    rowStringBuffer.append(insertSQL);

                    for (int j = 0; j < columns.size(); j++) {
                        column = columns.get(j);
                        Object value = row.get(column.getName());

                        values.add(value);

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

                    bigMap.put(values.get(0), values);
                } else {
                    System.out.println("        -- Row " + i + " is null.\n");
                }
            } catch (IOException e) {
                System.out.println("        -- Problem reading column number " + id + " from " + table.getName() + " table. Error: " + e.getMessage() + "\n");
            }
        }

        System.out.println("        -- Map size: " + bigMap.size());

        return true;
    }

    private static boolean outputRowCSVString(Table table, BufferedWriter bufferedWriter) {
        List<Column> columns = table.getColumns();
        StringBuffer rowStringBuffer = new StringBuffer();

        Map<Object, List> bigMap = new HashMap<Object, List>();

        Object id = null;

        Map<String, Object> row = null;
        Column column = null;
        List values = null;
        for (int i = 0; i < table.getRowCount(); i++) {
            try {
                row = table.getNextRow();
                rowStringBuffer.setLength(0);

                if (row != null) {

                    values = new ArrayList();

                    for (int j = 0; j < columns.size(); j++) {
                        column = columns.get(j);
                        Object value = row.get(column.getName());

                        values.add(value);

                        if (column.equals("LID")) id = value;

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
                                    rowStringBuffer.append(CSV_ENCLOSURE);
                                    rowStringBuffer.append(rtfDocument.getText(0, rtfDocument.getLength()));
                                    rowStringBuffer.append(CSV_ENCLOSURE);
                                } catch (BadLocationException e) {
                                    System.out.println("        -- Error converting ritch text: "
                                            + e.getMessage() + "\n");
                                } catch (IOException e) {
                                    System.out.println("        -- Error converting ritch text: "
                                            + e.getMessage() + "\n");
                                    rowStringBuffer.append(CSV_ENCLOSURE);
                                    rowStringBuffer.append(StringEscapeUtils.escapeSql(((String) value).trim())
                                        .replaceAll("\\\\'", "\\\\\\\\'"));
                                    rowStringBuffer.append(CSV_ENCLOSURE);
                                }
                            } else if (value instanceof String) {
                                rowStringBuffer.append(CSV_ENCLOSURE);
                                rowStringBuffer.append(StringEscapeUtils.escapeSql(((String) value).trim())
                                        .replaceAll("\\\\'", "\\\\\\\\'"));
                                rowStringBuffer.append(CSV_ENCLOSURE);
                            } else if (value instanceof java.util.Date) {
                                rowStringBuffer.append(CSV_ENCLOSURE);
                                rowStringBuffer.append((new Timestamp(((Date) value).getTime())));
                                rowStringBuffer.append(CSV_ENCLOSURE);
                            } else if (value instanceof Boolean) {
                                if (((Boolean) value)) {
                                    rowStringBuffer.append(1);
                                } else {
                                    rowStringBuffer.append(0);
                                }
                            } else {
                                rowStringBuffer.append(value);
                            }
                        }
                        rowStringBuffer.append(CSV_DELIMITER);
                    }

                    rowStringBuffer.replace(rowStringBuffer.length() - 1, rowStringBuffer.length(), "");
                    rowStringBuffer.append("\n");
                    bufferedWriter.write(rowStringBuffer.toString());

                    bigMap.put(values.get(0), values);
                } else {
                    System.out.println("        -- Row " + i + " is null.\n");
                }
            } catch (IOException e) {
                System.out.println("        -- Problem reading column number " + id + " from " + table.getName() + " table. Error: " + e.getMessage() + "\n");
            }

        }

        System.out.println("        -- Map size: " + bigMap.size());

        return true;
    }
}
