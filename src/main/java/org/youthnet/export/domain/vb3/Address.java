package org.youthnet.export.domain.vb3;


import org.youthnet.export.domain.vb3.lookups.Country;
import org.youthnet.export.domain.vb3.lookups.County;


public class Address extends GenericDTO {


    private Integer vbase2Id;
    private String address1;
    private String address2;
    private String address3;
    private String town;
    private County county;
    private Country country;
    private String PostCode;
    private String Directions;


    public Address() {
    }


    public Address(Integer vbase2Id, String address1, String address2, String address3, String town, County county, Country country, String PostCode, String Directions) {
        this.vbase2Id = vbase2Id;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.town = town;
        this.county = county;
        this.country = country;
        this.PostCode = PostCode;
        this.Directions = Directions;
    }


    public Integer getVbase2Id() {
        return this.vbase2Id;
    }


    public void setVbase2Id(Integer vbase2Id) {
        this.vbase2Id = vbase2Id;
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


    public String getAddress3() {
        return this.address3;
    }


    public void setAddress3(String address3) {
        this.address3 = address3;
    }


    public String getTown() {
        return this.town;
    }


    public void setTown(String town) {
        this.town = town;
    }


    public County getCounty() {
        return this.county;
    }


    public void setCounty(County county) {
        this.county = county;
    }


    public Country getCountry() {
        return this.country;
    }


    public void setCountry(Country country) {
        this.country = country;
    }


    public String getPostCode() {
        return this.PostCode;
    }


    public void setPostCode(String PostCode) {
        this.PostCode = PostCode;
    }


    public String getDirections() {
        return this.Directions;
    }


    public void setDirections(String Directions) {
        this.Directions = Directions;
    }
}
