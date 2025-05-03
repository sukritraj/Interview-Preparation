package com.example.design.lld.ecommerce;

public class ShippingInfo {
    private String address;
    private String city;
    private String postalCode;
    private String country;

    public ShippingInfo(String address, String city, String postalCode, String country) {
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getFullAddress() {
        return address + ", " + city + ", " + postalCode + ", " + country;
    }
}

