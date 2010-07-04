package org.youthnet.export.domain.vb3;


import java.util.UUID;


public class VolunteerCurrentSkills {

    private UUID lookupid;
    private UUID volunteerid;

    public VolunteerCurrentSkills() {
    }

    public UUID getLookupId() {
        return this.lookupid;
    }

    public void setLookupId(UUID lookupid) {
        this.lookupid = lookupid;
    }

    public UUID getVolunteerId() {
        return this.volunteerid;
    }

    public void setVolunteerId(UUID volunteerid) {
        this.volunteerid = volunteerid;
    }
}
