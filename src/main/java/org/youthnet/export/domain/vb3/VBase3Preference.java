package org.youthnet.export.domain.vb3;


public class VBase3Preference extends GenericDTO {


    private UuidUserType languageId;
    private boolean usingVisualNotification;
    private boolean usingAudioNotification;
    private boolean usingLogNotification;
    private Integer dataSchemaVersion;
    private String applicationName;
    private String copyright;
    private Integer colourTheme;
    private UuidUserType defaultCountyId;
    private UuidUserType defaultCountryId;
    private boolean useDefaultCounty;
    private boolean useDefaultCountry;


    public VBase3Preference() {
    }


    public VBase3Preference(UuidUserType languageId, boolean usingVisualNotification, boolean usingAudioNotification, boolean usingLogNotification, Integer dataSchemaVersion, String applicationName, String copyright, Integer colourTheme, UuidUserType defaultCountyId, UuidUserType defaultCountryId, boolean useDefaultCounty, boolean useDefaultCountry) {
        this.languageId = languageId;
        this.usingVisualNotification = usingVisualNotification;
        this.usingAudioNotification = usingAudioNotification;
        this.usingLogNotification = usingLogNotification;
        this.dataSchemaVersion = dataSchemaVersion;
        this.applicationName = applicationName;
        this.copyright = copyright;
        this.colourTheme = colourTheme;
        this.defaultCountyId = defaultCountyId;
        this.defaultCountryId = defaultCountryId;
        this.useDefaultCounty = useDefaultCounty;
        this.useDefaultCountry = useDefaultCountry;
    }


    public UuidUserType getLanguageId() {
        return this.languageId;
    }


    public void setLanguageId(UuidUserType languageId) {
        this.languageId = languageId;
    }


    public boolean isUsingVisualNotification() {
        return this.usingVisualNotification;
    }


    public void setUsingVisualNotification(boolean usingVisualNotification) {
        this.usingVisualNotification = usingVisualNotification;
    }


    public boolean isUsingAudioNotification() {
        return this.usingAudioNotification;
    }


    public void setUsingAudioNotification(boolean usingAudioNotification) {
        this.usingAudioNotification = usingAudioNotification;
    }


    public boolean isUsingLogNotification() {
        return this.usingLogNotification;
    }


    public void setUsingLogNotification(boolean usingLogNotification) {
        this.usingLogNotification = usingLogNotification;
    }


    public Integer getDataSchemaVersion() {
        return this.dataSchemaVersion;
    }


    public void setDataSchemaVersion(Integer dataSchemaVersion) {
        this.dataSchemaVersion = dataSchemaVersion;
    }


    public String getApplicationName() {
        return this.applicationName;
    }


    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }


    public String getCopyright() {
        return this.copyright;
    }


    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }


    public Integer getColourTheme() {
        return this.colourTheme;
    }


    public void setColourTheme(Integer colourTheme) {
        this.colourTheme = colourTheme;
    }


    public UuidUserType getDefaultCountyId() {
        return this.defaultCountyId;
    }


    public void setDefaultCountyId(UuidUserType defaultCountyId) {
        this.defaultCountyId = defaultCountyId;
    }


    public UuidUserType getDefaultCountryId() {
        return this.defaultCountryId;
    }


    public void setDefaultCountryId(UuidUserType defaultCountryId) {
        this.defaultCountryId = defaultCountryId;
    }


    public boolean isUseDefaultCounty() {
        return this.useDefaultCounty;
    }


    public void setUseDefaultCounty(boolean useDefaultCounty) {
        this.useDefaultCounty = useDefaultCounty;
    }


    public boolean isUseDefaultCountry() {
        return this.useDefaultCountry;
    }


    public void setUseDefaultCountry(boolean useDefaultCountry) {
        this.useDefaultCountry = useDefaultCountry;
    }
}
