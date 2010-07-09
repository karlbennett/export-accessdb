package org.youthnet.export.migration;

import org.junit.Test;
import org.youthnet.export.domain.vb3.Lookups;
import org.youthnet.export.util.CSVUtil;

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
        volumnteersMigration = new VolunteersMigration(
                CSVUtil.createDiscriminatorValueMap("test/Lookups.csv", Lookups.class));
        volumnteersMigration.migrate("src/test/resources/", "test/");
    }
}
