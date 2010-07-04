package org.youthnet.export.domain.vb3;


public class ViewsTable extends GenericDTO {


    private Integer vbase2Id;
    private String fieldName;
    private String sectionName;
    private String sectionLookup;
    private String lookupUpTypesValue;
    private String discriminator;
    private boolean isSKills;
    private String skillType;


    public ViewsTable() {
    }


    public ViewsTable(Integer vbase2Id, String fieldName, String sectionName, String sectionLookup, String lookupUpTypesValue, String discriminator, boolean isSKills, String skillType) {
        this.vbase2Id = vbase2Id;
        this.fieldName = fieldName;
        this.sectionName = sectionName;
        this.sectionLookup = sectionLookup;
        this.lookupUpTypesValue = lookupUpTypesValue;
        this.discriminator = discriminator;
        this.isSKills = isSKills;
        this.skillType = skillType;
    }


    public Integer getVbase2Id() {
        return this.vbase2Id;
    }


    public void setVbase2Id(Integer vbase2Id) {
        this.vbase2Id = vbase2Id;
    }


    public String getFieldName() {
        return this.fieldName;
    }


    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }


    public String getSectionName() {
        return this.sectionName;
    }


    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }


    public String getSectionLookup() {
        return this.sectionLookup;
    }


    public void setSectionLookup(String sectionLookup) {
        this.sectionLookup = sectionLookup;
    }


    public String getLookupUpTypesValue() {
        return this.lookupUpTypesValue;
    }


    public void setLookupUpTypesValue(String lookupUpTypesValue) {
        this.lookupUpTypesValue = lookupUpTypesValue;
    }


    public String getDiscriminator() {
        return this.discriminator;
    }


    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }


    public boolean isIsSKills() {
        return this.isSKills;
    }


    public void setIsSKills(boolean isSKills) {
        this.isSKills = isSKills;
    }


    public String getSkillType() {
        return this.skillType;
    }


    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }
}
