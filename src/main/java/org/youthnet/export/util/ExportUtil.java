package org.youthnet.export.util;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Timestamp;
import java.util.*;

/**
 * User: karl
 * Date: 13-Jul-2010
 */
public class ExportUtil {

    private ExportUtil() {
    }

    public static String getValueString(Object value, char delimiter, char enclosure) {
        if (value != null) { // If the value is null then don't bother trying to process it.
            if (value instanceof String) { // The value is a string...
                String valueString = (String) value; // Cast the value to a string so it's easier to work with.

                // Check to see if the string contains rich text...
                if (valueString.contains("{\\rtf")) {
                    value = extractTextFromRTFNotes(value); // ...if it is extract the plain text from it.
                    // If the text has successfully been extracted place it into the valueString.
                    if (value != null) valueString = (String) value;
                }

                valueString = valueString.trim(); // Trim the string to remove any surrounding spaces.

                // Make sure that neither the enclosing or delimiting characters are in the string.
                valueString = valueString.replaceAll(String.valueOf(enclosure), "[[ENCL]]");
                valueString = valueString.replaceAll("\\" + delimiter, "[[DELM]]");
                valueString = valueString.replaceAll("\\\\'", "\\\\\\\\'"); // Then escape any single quotes.

                return valueString; // Add the final string to the row string buffer.
            } else if (value instanceof java.util.Date) { // If the value is a date...
                // ...convert it to a timestamp string.
                return (new Timestamp(((Date) value).getTime())).toString();
            } else if (value instanceof Boolean) { // If the value is a boolean...
                if (((Boolean) value)) {
                    return "1"; // ...convert it to 1 for true...
                } else {
                    return "0"; // ...or 0 for false.
                }
            } else {
                return value.toString();
            }
        }

        return "";
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
            System.out.println("\t\t-- Error converting ritch text: "
                    + e.getMessage() + "\n");
        } catch (IOException e) {
            System.out.println("\t\t-- Error converting ritch text: "
                    + e.getMessage() + "\n");
        }

        return extractedText; // Return the extracted text.
    }

    public static StringBuffer createDelimitedRecord(Map<String, Object> row, int[] indexes, char delimiter,
                                                     char enclosure) {

        if (row != null) { // If the row is null don't bother doing anything and move to the next one.

            StringBuffer rowStringBuffer = null;
            Iterator<String> rowIterator = row.keySet().iterator();
            String[] values = new String[row.size()];

            for (int j = 0; j < row.size(); j++) { // Iterate through the columns in this row.
                // Create a new string buffer for each value so that it's memory footprint is as small as possible to begin with.
                // Also hopefully the previous string buffer will be garbage collected...
                rowStringBuffer = new StringBuffer();

                Object value = row.get(rowIterator.next()); // Get the value that is related to that column.

                rowStringBuffer.append(enclosure); // Add an enclosing character to the start of the value.

                rowStringBuffer.append(ExportUtil.getValueString(value, delimiter, enclosure));

                rowStringBuffer.append(enclosure); // Add another enclosing character to the end of the value.
                rowStringBuffer.append(delimiter); // Add the delimiter to separate the different values.

                // Add the value to the right position in the row. If we come across a column we don't now about ignore it.
                if (indexes[j] > -1) values[indexes[j]] = rowStringBuffer.toString();
            }

            rowStringBuffer = new StringBuffer();
            for (String value : values) {
                if (value != null) rowStringBuffer.append(value);
            }
            rowStringBuffer.append("\n"); // Add a new line to indicate the end of this record.

            return rowStringBuffer;
        }

        return null;
    }
}
