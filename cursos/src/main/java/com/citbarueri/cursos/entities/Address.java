package com.citbarueri.cursos.entities;

public class Address {
    
    private String name;
    private String address;
    private String address_num;
    private String address_alt;
    private String neighborhood;
    private String city;
    private String state;
    private String zip_code;
    private String country;

    public Address() {}

    public Address(String name, String address, String address_num, String address_alt,
    String neighborhood, String city, String state, String zip_code, String country) {
        this.name = name;
        this.address = address;
        this.address_num = address_num;
        this.address_alt = address_alt;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }

    public void setAddressNum(String address_num) {
        this.address_num = address_num;
    }
    public String getAddressNum() {
        return this.address_num;
    }

    public void setAddressAlt(String address_alt) {
        this.address_alt = address_alt;
    }
    public String getAddressAlt() {
        return this.address_alt;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    public String getNeighborhood() {
        return this.neighborhood;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return this.city;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return this.state;
    }

    public void setZipCode(String zip_code) {
        this.zip_code = zip_code;
    }
    public String get() {
        return this.zip_code;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String getCountry() {
        return this.country;
    }

}
