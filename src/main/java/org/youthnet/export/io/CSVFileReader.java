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

    private int newOffset = -1; // Initialise the offset as -1 so that we read in the first buffer.
    char lastChar = 0; // Char to hold the character that was last seen in the buffer.
    private int charsRead = 0;

    private static char DELIMITER = '|';
    private static char ENCLOSURE = '¬';

    public CSVFileReader(Reader reader) {
        super(reader);
    }

    public String readRecord() throws IOException {

        StringBuffer record = new StringBuffer(); // The string buffer to hold the final record.

        int recordEnd = 0;

        while (true) {
            if (newOffset < 0) {
                if ((charsRead = super.read(buffer)) == -1) return null;
                newOffset = 0;
            }
            recordEnd = findRecordEnd(buffer, newOffset);
            if (recordEnd >= 0) {
                recordEnd++;
                record.append(Arrays.copyOfRange(buffer, newOffset, recordEnd));
                if (charsRead < buffer.length && charsRead == recordEnd) {
                    newOffset = -1;
                } else newOffset = recordEnd;
                return record.toString();
            }
            record.append(Arrays.copyOfRange(buffer, newOffset, buffer.length));
            newOffset = recordEnd;
        }
    }

    private int findRecordEnd(char[] buffer, int startIndex) {
        for (int i = startIndex; i < buffer.length; i++) {
            if (lastChar == DELIMITER && buffer[i] == '\n') {
                lastChar = buffer[i];
                return i;
            }
            lastChar = buffer[i];
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
