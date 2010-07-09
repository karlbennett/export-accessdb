package org.youthnet.export.migration;

import org.junit.Test;
import org.youthnet.export.domain.vb3.Lookups;
import org.youthnet.export.util.CSVUtil;

import java.io.File;

/**
 * User: OrganisationsMigrationTest
 * Date: 07-Jul-2010
 */
public class OrganisationsMigrationTest {

    Migratable organisationsMigration;

    @Test
    public void testMigrate() throws Exception {
        File outputDir = new File("test");
        if (!outputDir.isDirectory()) outputDir.mkdir();
        organisationsMigration = new OrganisationsMigration(
                CSVUtil.createDiscriminatorValueMap("test/Lookups.csv", Lookups.class));
        organisationsMigration.migrate("src/test/resources/", "test/");
    }
}
