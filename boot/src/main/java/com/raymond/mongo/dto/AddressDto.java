package com.raymond.mongo.dto;

import java.util.List;

/**
 * Created by Raymond Kwong on 6/26/2016.
 */
public class AddressDto {
    private String building;
    private List<String> coord;
    private String street;
    private String zipcode;

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public List<String> getCoord() {
        return coord;
    }

    public void setCoord(List<String> coord) {
        this.coord = coord;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
