package com.example.tretiakoff.sifg2.api.model.doctor;

/**
 * Created by tretiakoff on 05/07/2018.
 */

public class Address {

    public Address(int id, String line, String zip_code, String city, String country_code, double latitude, double longitude) {
        this.id = id;
        this.line = line;
        this.zip_code = zip_code;
        this.city = city;
        this.country_code = country_code;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public String getLine() {
        return line;
    }

    public String getZip_code() {
        return zip_code;
    }

    public String getCity() {
        return city;
    }

    public String getCountry_code() {
        return country_code;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    private int id;
    private String line;
    private String zip_code;
    private String city;
    private String country_code;
    private double latitude;
    private double longitude;

}
