package org.youthnet.export.migration;

import org.junit.Test;
import org.youthnet.export.domain.vb3.Lookups;
import org.youthnet.export.util.CSVUtil;

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
        organisationVioMigration = new OrganisationVuoMigration(
                CSVUtil.createDiscriminatorValueMap("test/Lookups.csv", Lookups.class));
        organisationVioMigration.migrate("src/test/resources/", "test/");
    }
}
