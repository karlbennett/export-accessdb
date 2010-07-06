package org.youthnet.export.migration;

import org.youthnet.export.domain.CSVable;
import org.youthnet.export.io.CSVFileReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * User: karl
 * Date: 06-Jul-2010
 */
public abstract class MigrationObject<T extends CSVable> {

    protected static CSVFileReader csvFileReader;
    private static BufferedWriter bufferedWriter;

    public MigrationObject(String outFile) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(outFile));
    }

    public abstract void migrate(String csvDir) throws IOException;

    protected boolean writeRecord(T domainObject) {
        try {
            bufferedWriter.write(domainObject.getRecord() + "\n");
        } catch (IOException e) {
            System.out.println("Failed to write to " + domainObject.getClass().getSimpleName() + " csv file.");
            return false;
        }

        return true;
    }

    protected boolean closeWriter() {
        try {
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Failed to close writer.");
            return false;
        }

        return true;
    }
}
