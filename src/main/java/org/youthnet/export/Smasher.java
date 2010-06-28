package org.youthnet.export;

import com.healthmarketscience.jackcess.Column;
import com.healthmarketscience.jackcess.Cursor;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;
import org.apache.commons.lang.StringEscapeUtils;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;

/**
 * User: karl
 * Date: 28-Jun-2010
 */
public class Smasher {

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
                    insertSQL = createColumnSQLString(table.getColumns(), tableName);
                    fileOutWriter = new BufferedWriter(new FileWriter("output/" + tableName + ".csv"));
//                    fileOutWriter.write(createRowSQLString(table, insertSQL));
                    outputRowSQLString(table, insertSQL, fileOutWriter);
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
            System.out.println("Usage: Smasher <path to access file>");
        }
    }

    private static String createColumnCSVString(List<Column> strings) {
        StringBuffer columnStringBuffer = new StringBuffer();

        for (Column column : strings) {
            columnStringBuffer.append(column.getName());
            columnStringBuffer.append(",");
        }

        columnStringBuffer.replace(columnStringBuffer.length() - 1, columnStringBuffer.length(), "");

        return columnStringBuffer.toString();
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

    private static String createRowCSVString(Table table) {
        List<Column> columns = table.getColumns();
        StringBuffer rowStringBuffer = new StringBuffer();

        try {
            for (Map<String, Object> row : table) {
                for (Column column : columns) {
                    Object value = row.get(column.getName());
                    if (value != null) {
                        if (value instanceof String) {
                            rowStringBuffer.append(StringEscapeUtils.escapeSql(((String) value).trim())
                                    .replaceAll("\\\\'", "\\\\\\\\'"));
                        } else if (value instanceof java.util.Date) {
                            rowStringBuffer.append(((Date) value).getTime());
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
                    rowStringBuffer.append(",");
                }
                rowStringBuffer.replace(rowStringBuffer.length() - 1, rowStringBuffer.length(), "");
                rowStringBuffer.append("\n");
            }
        } catch (IllegalStateException e) {
            System.out.println("Problem process file: " + e.getMessage());
        }

        return rowStringBuffer.toString();
    }

    private static String createRowSQLString(Table table, String insertSQL) {
        List<Column> columns = table.getColumns();
        StringBuffer rowStringBuffer = new StringBuffer();

        Map<String, Object> row = null;
        for (int i = 0; i < table.getRowCount(); i++) {
            try {
                row = table.getNextRow();

                if (row != null) {

                    rowStringBuffer.append(insertSQL);

                    for (Column column : columns) {
                        rowStringBuffer.append("'");
                        Object value = row.get(column.getName());

                        if (value != null) {
                            if (value instanceof String) {
                                rowStringBuffer.append(StringEscapeUtils.escapeSql(((String) value).trim())
                                        .replaceAll("\\\\'", "\\\\\\\\'"));
                            } else if (value instanceof java.util.Date) {
                                rowStringBuffer.append(((Date) value).getTime());
                            } else if (value instanceof Boolean) {
                                if (((Boolean) value)) {
                                    rowStringBuffer.append(1);
                                } else {
                                    rowStringBuffer.append(0);
                                }
                            } else {
                                rowStringBuffer.append(value);
                            }
//                            rowStringBuffer.append(value.toString());
                        }
                        rowStringBuffer.append("', ");
                    }

                    rowStringBuffer.replace(rowStringBuffer.length() - 2, rowStringBuffer.length(), ");");
                    rowStringBuffer.append("\n");
                }
            } catch (IOException e) {
                System.out.println("Problem reading from " + table.getName() + " table. Error: " + e.getMessage());
            }

        }


        return rowStringBuffer.toString();
    }

    private static boolean outputRowSQLString(Table table, String insertSQL, BufferedWriter bufferedWriter) {
        List<Column> columns = table.getColumns();
        StringBuffer rowStringBuffer = new StringBuffer();

        Object id = null;

        Map<String, Object> row = null;
        for (int i = 0; i < table.getRowCount(); i++) {
            try {
                row = table.getNextRow();

                if (row != null) {

                    rowStringBuffer.setLength(0);
                    rowStringBuffer.append(insertSQL);

                    for (Column column : columns) {
                        rowStringBuffer.append("'");
                        Object value = row.get(column.getName());

                        if (column.getName().equals("LID")) id = value;

                        if (value != null) {
                            if (value instanceof String) {
                                rowStringBuffer.append(StringEscapeUtils.escapeSql(((String) value).trim())
                                        .replaceAll("\\\\'", "\\\\\\\\'"));
                            } else if (value instanceof java.util.Date) {
                                rowStringBuffer.append(((Date) value).getTime());
                            } else if (value instanceof Boolean) {
                                if (((Boolean) value)) {
                                    rowStringBuffer.append(1);
                                } else {
                                    rowStringBuffer.append(0);
                                }
                            } else {
                                rowStringBuffer.append(value);
                            }
//                            rowStringBuffer.append(value.toString());
                        }
                        rowStringBuffer.append("', ");
                    }

                    rowStringBuffer.replace(rowStringBuffer.length() - 2, rowStringBuffer.length(), ");");
                    rowStringBuffer.append("\n");
                    bufferedWriter.write(rowStringBuffer.toString());
                }
            } catch (IOException e) {
                System.out.println("Problem reading column number " + id + " from " + table.getName() + " table. Error: " + e.getMessage());
            }

        }

        return true;
    }

    private static List<String> getColumnNames(Table table) {
        List<String> columnNames = new ArrayList<String>();

        for (Column column : table.getColumns()) {
            columnNames.add(column.getName());
        }

        return columnNames;
    }
}
