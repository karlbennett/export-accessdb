package org.youthnet.export.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

/**
 * User: karl
 * Date: 04-Jul-2010
 */
public class CSVFileReader extends BufferedReader {

    private static final int BUFFER_SIZE = 1024;
    private char[] buffer = new char[BUFFER_SIZE]; // Buffer to hold the chars read in from the file.

    private int offset = BUFFER_SIZE; // Initialise the offset so that nothing is returned from the very first buffer copy.
    char endChar = 0; // Char to hold the last record in the buffer. Used to check if the last buffer read finished at the end of a record.
    // Variable to hole the number of chars read from the file. Set it to the buffer size for the initial read so that we know we are not at the
    // end of the file.
    int charsRead = BUFFER_SIZE;

    private static char DELIMITER = '|';
    private static char ENCLOSURE = '¬';

    public CSVFileReader(Reader reader) {
        super(reader);
    }

    public String readRecord() throws IOException {

        StringBuffer record = new StringBuffer(); // The string buffer to hold the final record.


        do {
            if (charsRead > 0) { // If there are more characters to read.
                if (charsRead < buffer.length) { // If we have reached the end of the file.
                    record.append(Arrays.copyOfRange(buffer, 0, charsRead)); // Read in the last few characters.
                    offset = buffer.length; // Set the offset to the length of the buffer to make sure nothing more is read.
                    charsRead = -1; // Set characters read to -1 becuase we have reached the end of the file.
                    return record.toString(); // Return the last record.
                }

                if (endChar == DELIMITER && buffer[0] == '\n') { // If the last buffer finished at the end of a record...
                    offset = 1; // Set the offset to 1 so next time round the buffer is searched from the beginning just after the new line.
                    endChar = 0; // Reset the end char.
                    return record.toString(); // Return the completed record.
                }

                // Check the buffer starting from where the last record left off to see if it contains the end of a record.
                int endOfRecord = findRecordEnd(Arrays.copyOfRange(buffer, offset, buffer.length));

                if (endOfRecord >= 0) { // If it does.
                    endOfRecord += offset; // Add the offset to the end of the record to get the actual index within the buffer.
                    // Append the last of the record to the record string buffer.
                    record.append(Arrays.copyOfRange(buffer, offset, endOfRecord));
                    // Set the offset to the index of the start of the next record within the buffer while making sure that it doesn't overrun the buffer.
                    offset = endOfRecord + 1;
                    return record.toString(); // Return the completed record.
                }

                // If all else fails...
                record.append(Arrays.copyOfRange(buffer, offset, buffer.length)); // Copy any uncopied chars into the record.
                // Record the last character in the buffer just in case the buffer end equals the record end.
                endChar = buffer[buffer.length - 1];
                offset = 0; // Set the offset to 0 so that the next buffer copy starts from the beginning.
            }
        } while ((charsRead = super.read(buffer)) > 0);

        return null;
    }

    private int findRecordEnd(char[] buffer) {
        for (int i = 0; i < buffer.length - 2; i++) {
            if (buffer[i] == DELIMITER && buffer[i + 1] == '\n') return i + 1;
        }

        return -1;
    }

    public static char getDelimiter() {
        return DELIMITER;
    }

    public static void setDelimiter(char delimiter) {
        CSVFileReader.DELIMITER = delimiter;
    }
}
