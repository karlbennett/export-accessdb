package org.youthnet.export.migration;

import org.junit.Test;

import java.io.File;

/**
 * User: VolunteersMigrationTest
 * Date: 07-Jul-2010
 */
public class VolunteersMigrationTest {
    
    Migratable volumnteersMigration;

    @Test
    public void testMigrate() throws Exception {
        File outputDir = new File("test");
        if (!outputDir.isDirectory()) outputDir.mkdir();
        volumnteersMigration = new VolunteersMigration();
        volumnteersMigration.migrate("src/test/resources/", "test/");
    }
}
