package org.youthnet.export.migration;

import org.junit.Test;

import java.io.File;

/**
 * User: karl
 * Date: 09-Jul-2010
 */
public class OrganisationVuoMigrationTest {

    Migratable organisationVioMigration;

    @Test
    public void testMigrate() throws Exception {
        File outputDir = new File("test");
        if (!outputDir.isDirectory()) outputDir.mkdir();
        organisationVioMigration = new OrganisationVuoMigration();
        organisationVioMigration.migrate("src/test/resources/", "test/");
    }
}
