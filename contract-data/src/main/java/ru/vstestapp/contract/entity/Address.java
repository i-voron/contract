package ru.vstestapp.contract.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Embeddable
public class Address {
    @NotBlank(message = "{javax.validation.constraints.NotNull.message}")
    @Column(length = 50)
    private String country; //государство
    private String zip; //индекс
    @NotBlank(message = "{javax.validation.constraints.NotNull.message}")
    @Column(length = 50)
    private String region;  //республика, край, область
    private String district; //район
    @NotBlank(message = "{javax.validation.constraints.NotNull.message}")
    @Column(length = 50)
    private String city; //населённый пункт
    @NotBlank(message = "{javax.validation.constraints.NotNull.message}")
    @Column(length = 50)
    private String street; //улица
    @Positive(message = "{NumberPositive.message}")
    private Integer house; //дом
    private String corpus; //корпус
    private String building; //строение
    //    @Min(value = 1,message = "flat must be at least 1 characters int")
    @NotNull
    @Positive(message = "{NumberPositive.message}")
    private Integer flat; //квартира

    public Address() {
    }

    public Address(@NotBlank(message = "country is required") String country, String zip, @NotBlank(message = "region is required") String region, String district, @NotBlank(message = "city is required") String city, @NotBlank(message = "street is required") String street, Integer house, String corpus, String building, @NotNull Integer flat) {
        this.country = country;
        this.zip = zip;
        this.region = region;
        this.district = district;
        this.city = city;
        this.street = street;
        this.house = house;
        this.corpus = corpus;
        this.building = building;
        this.flat = flat;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public String getCorpus() {
        return corpus;
    }

    public void setCorpus(String corpus) {
        this.corpus = corpus;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }
}
