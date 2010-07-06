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
public interface Migratable {

    public abstract void migrate(String csvDir, String outputDir);

}
