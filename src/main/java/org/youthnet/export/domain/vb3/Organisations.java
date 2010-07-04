package org.youthnet.export.domain.vb3;


import java.sql.Timestamp;
import java.util.UUID;


public class Organisations {

    private String name;
    private Long version;
    private String ownid;
    private Timestamp created;
    private String description;
    private Long vbase2id;
    private String openinghours;
    private String missionstatement;
    private Timestamp modified;
    private String howhearddetails;
    private String registeredcharitynumber;
    private UUID howheardid;
    private UUID modifiedby;
    private Boolean isactive;
    private UUID id;
    private Boolean deleted;
    private UUID createdby;
    private Boolean isvuo;

    public Organisations() {
    }

    public String getRegisteredCharityNumber() {
        return this.registeredcharitynumber;
    }

    public void setRegisteredCharityNumber(String registeredcharitynumber) {
        this.registeredcharitynumber = registeredcharitynumber;
    }

    public UUID getHowHeardId() {
        return this.howheardid;
    }

    public void setHowHeardId(UUID howheardid) {
        this.howheardid = howheardid;
    }

    public String getOwnId() {
        return this.ownid;
    }

    public void setOwnId(String ownid) {
        this.ownid = ownid;
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

    public String getOpeningHours() {
        return this.openinghours;
    }

    public void setOpeningHours(String openinghours) {
        this.openinghours = openinghours;
    }

    public String getHowHeardDetails() {
        return this.howhearddetails;
    }

    public void setHowHeardDetails(String howhearddetails) {
        this.howhearddetails = howhearddetails;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Boolean getIsActive() {
        return this.isactive;
    }

    public void setIsActive(Boolean isactive) {
        this.isactive = isactive;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsVuo() {
        return this.isvuo;
    }

    public void setIsVuo(Boolean isvuo) {
        this.isvuo = isvuo;
    }

    public String getMissionStatement() {
        return this.missionstatement;
    }

    public void setMissionStatement(String missionstatement) {
        this.missionstatement = missionstatement;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }
}
