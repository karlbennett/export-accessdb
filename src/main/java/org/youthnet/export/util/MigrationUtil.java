package org.youthnet.export.util;

import org.youthnet.export.domain.vb3.Lookups;

import java.util.Map;
import java.util.UUID;

/**
 * User: karl
 * Date: 12-Jul-2010
 */
public class MigrationUtil {

    private MigrationUtil() {}

    public static Lookups getLookup(Map<String, Map<String, Lookups>> lookupsMap, String discriminator, String value) {
        return lookupsMap.get(discriminator) != null ? lookupsMap.get(discriminator).get(value) : null;
    }

    public static Lookups getLookup(Map<String, Map<String, Lookups>> lookupsMap,
                                               String discriminator,
                                               String value,
                                               String _default) {
        return getLookup(lookupsMap, discriminator, value) != null ? getLookup(lookupsMap, discriminator, value) :
                getLookup(lookupsMap, discriminator, _default) != null ? getLookup(lookupsMap, discriminator, _default) :
                null;
    }

    public static UUID getLookupId(Map<String, Map<String, Lookups>> lookupsMap, String discriminator, String value) {
        Lookups lookup = getLookup(lookupsMap, discriminator, value);
        return lookup != null ? lookup.getId() : null;
    }

    public static UUID getLookupId(Map<String, Map<String, Lookups>> lookupsMap,
                                   String discriminator,
                                   String value,
                                   String _default) {
        Lookups lookup = getLookup(lookupsMap, discriminator, value, _default);
        return lookup != null ? lookup.getId() : null;
    }
}
