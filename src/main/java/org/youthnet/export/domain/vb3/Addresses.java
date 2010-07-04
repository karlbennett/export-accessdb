package org.youthnet.export.domain.vb3;


import java.sql.Timestamp;
import java.util.UUID;


public class Addresses {

    private Long version;
    private Timestamp created;
    private Long vbase2id;
    private String postcode;
    private Timestamp modified;
    private UUID modifiedby;
    private String town;
    private String directions;
    private UUID countryid;
    private UUID id;
    private Boolean deleted;
    private UUID createdby;
    private String address1;
    private String address2;
    private String address3;
    private UUID countyid;

    public Addresses() {
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDirections() {
        return this.directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getVbase2Id() {
        return this.vbase2id;
    }

    public void setVbase2Id(Long vbase2id) {
        this.vbase2id = vbase2id;
    }

    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostCode() {
        return this.postcode;
    }

    public void setPostCode(String postcode) {
        this.postcode = postcode;
    }

    public String getAddress3() {
        return this.address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public UUID getModifiedBy() {
        return this.modifiedby;
    }

    public void setModifiedBy(UUID modifiedby) {
        this.modifiedby = modifiedby;
    }

    public UUID getCountryId() {
        return this.countryid;
    }

    public void setCountryId(UUID countryid) {
        this.countryid = countryid;
    }

    public Timestamp getCreated() {
        return this.created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public UUID getCreatedBy() {
        return this.createdby;
    }

    public void setCreatedBy(UUID createdby) {
        this.createdby = createdby;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public UUID getCountyId() {
        return this.countyid;
    }

    public void setCountyId(UUID countyid) {
        this.countyid = countyid;
    }
}
