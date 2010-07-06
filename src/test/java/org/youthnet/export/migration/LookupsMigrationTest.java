package org.youthnet.export.migration;

import org.junit.Test;

import java.io.File;

/**
 * User: LookupsMigrationTest
 * Date: 06-Jul-2010
 */
public class LookupsMigrationTest {
    Migratable lookupsMigration;

    @Test
    public void testMigrate() throws Exception {
        File outputDir = new File("test");
        if (!outputDir.isDirectory()) outputDir.mkdir();
        lookupsMigration = new LookupsMigration();
        lookupsMigration.migrate("src/test/resources/", "test/");
    }
}
