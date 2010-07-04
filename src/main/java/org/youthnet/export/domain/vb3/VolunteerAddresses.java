package org.youthnet.export.domain.vb3;


import java.util.UUID;


public class VolunteerAddresses {

    private String name;
    private UUID addressid;
    private Boolean isdefaultaddress;
    private Boolean isactive;
    private UUID volunteerid;

    public VolunteerAddresses() {
    }

    public UUID getAddressId() {
        return this.addressid;
    }

    public void setAddressId(UUID addressid) {
        this.addressid = addressid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsDefaultAddress() {
        return this.isdefaultaddress;
    }

    public void setIsDefaultAddress(Boolean isdefaultaddress) {
        this.isdefaultaddress = isdefaultaddress;
    }

    public Boolean getIsActive() {
        return this.isactive;
    }

    public void setIsActive(Boolean isactive) {
        this.isactive = isactive;
    }

    public UUID getVolunteerId() {
        return this.volunteerid;
    }

    public void setVolunteerId(UUID volunteerid) {
        this.volunteerid = volunteerid;
    }
}
