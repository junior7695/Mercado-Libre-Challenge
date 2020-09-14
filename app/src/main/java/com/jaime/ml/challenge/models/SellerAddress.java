package com.jaime.ml.challenge.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SellerAddress {
    private String id;
    private String comment;
    private String addressLine;
    private String zipCode;
    private City country;
    private City state;
    private City city;
    private String latitude;
    private String longitude;

    @JsonProperty("id")
    public String getId() { return id; }
    @JsonProperty("id")
    public void setId(String value) { this.id = value; }

    @JsonProperty("comment")
    public String getComment() { return comment; }
    @JsonProperty("comment")
    public void setComment(String value) { this.comment = value; }

    @JsonProperty("address_line")
    public String getAddressLine() { return addressLine; }
    @JsonProperty("address_line")
    public void setAddressLine(String value) { this.addressLine = value; }

    @JsonProperty("zip_code")
    public String getZipCode() { return zipCode; }
    @JsonProperty("zip_code")
    public void setZipCode(String value) { this.zipCode = value; }

    @JsonProperty("country")
    public City getCountry() { return country; }
    @JsonProperty("country")
    public void setCountry(City value) { this.country = value; }

    @JsonProperty("state")
    public City getState() { return state; }
    @JsonProperty("state")
    public void setState(City value) { this.state = value; }

    @JsonProperty("city")
    public City getCity() { return city; }
    @JsonProperty("city")
    public void setCity(City value) { this.city = value; }

    @JsonProperty("latitude")
    public String getLatitude() { return latitude; }
    @JsonProperty("latitude")
    public void setLatitude(String value) { this.latitude = value; }

    @JsonProperty("longitude")
    public String getLongitude() { return longitude; }
    @JsonProperty("longitude")
    public void setLongitude(String value) { this.longitude = value; }
}
