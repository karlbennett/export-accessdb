package org.youthnet.export.migration;

import org.junit.Test;
import org.youthnet.export.domain.vb3.Lookups;
import org.youthnet.export.util.CSVUtil;

import java.io.File;

/**
 * User: ActivityLogsMigrationTest
 * Date: 07-Jul-2010
 */
public class ActivityLogsMigrationTest {

    Migratable activityLogsMigration;

    @Test
    public void testMigrate() throws Exception {
        File outputDir = new File("test");
        if (!outputDir.isDirectory()) outputDir.mkdir();
        activityLogsMigration = new ActivityLogsMigration(
                CSVUtil.createDiscriminatorValueMap("test/Lookups.csv", Lookups.class));
        activityLogsMigration.migrate("src/test/resources/", "test/");
    }
}
