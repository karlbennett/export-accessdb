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

    private int offset = BUFFER_SIZE  - 1; // Initialise the offset so that nothing is returned from the very first buffer copy.

    public CSVFileReader(Reader reader) {
        super(reader);
    }

    public String readRecord() throws IOException {

        StringBuffer record = new StringBuffer(); // The string buffer to hold the final record.
        char endChar = 0; // Char to hold the last record in the buffer. Used to check if the last buffer read finished at the end of a record.
        int charsRead = 0; // Variable to hole the number of chars read from the file.

        do {
            if (endChar == '|' && buffer[0] == '\n') { // If the last buffer finished at the end of a record...
                offset = 1; // Set the offset to 1 so next time round the buffer is searched from the beginning just after the new line.
                return record.toString(); // Return the completed record.
            }

            // Check the buffer starting from where the last record left off to see if it contains the end of a record.
            int endOfRecord = findRecordEnd(Arrays.copyOfRange(buffer, offset, buffer.length));

            if (endOfRecord >= 0) { // If it does.
                endOfRecord += offset; // Add the offset to the end of the record to get the actual index within the buffer.
                // Append the last of the record to the record string buffer.
                record.append(Arrays.copyOfRange(buffer, offset, endOfRecord));
                // Set the offset to the index of the start of the next record within the buffer while making sure that it doesn't overrun the buffer.
                if ((offset = (endOfRecord + 1)) >= buffer.length) offset--;
                return record.toString(); // Return the completed record.
            }

            // If all else fails...
            record.append(Arrays.copyOfRange(buffer, offset, buffer.length)); // Copy any uncopied chars into the record.
            // Record the last character in the buffer just in case the buffer end equals the record end.
            endChar = buffer[buffer.length - 1];
            offset = 0; // Set the offset to 0 so that the next buffer copy starts from the beginning.
        } while ((charsRead = super.read(buffer)) > 0);

        return null;
    }

    private int findRecordEnd(char[] buffer) {
        for(int i = 0; i < buffer.length - 2; i++) {
            if (buffer[i] == '|' && buffer[i + 1] == '\n') return i + 1;
        }

        return -1;
    }
}
