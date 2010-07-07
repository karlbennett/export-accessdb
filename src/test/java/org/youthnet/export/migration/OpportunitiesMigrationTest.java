package org.youthnet.export.migration;

import org.junit.Test;

import java.io.File;

/**
 * User: OpportunitiesMigrationTest
 * Date: 07-Jul-2010
 */
public class OpportunitiesMigrationTest {

    Migratable opportunitiesMigration;

    @Test
    public void testMigrate() throws Exception {
        File outputDir = new File("test");
        if (!outputDir.isDirectory()) outputDir.mkdir();
        opportunitiesMigration = new OpportunitiesMigration();
        opportunitiesMigration.migrate("src/test/resources/", "test/");
    }
}
