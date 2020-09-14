package com.jaime.ml.challenge.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Seller {
    private long id;
    private Object permalink;
    private Object registrationDate;
    private boolean carDealer;
    private boolean realEstateAgency;
    private Object tags;

    @JsonProperty("id")
    public long getId() { return id; }
    @JsonProperty("id")
    public void setId(long value) { this.id = value; }

    @JsonProperty("permalink")
    public Object getPermalink() { return permalink; }
    @JsonProperty("permalink")
    public void setPermalink(Object value) { this.permalink = value; }

    @JsonProperty("registration_date")
    public Object getRegistrationDate() { return registrationDate; }
    @JsonProperty("registration_date")
    public void setRegistrationDate(Object value) { this.registrationDate = value; }

    @JsonProperty("car_dealer")
    public boolean getCarDealer() { return carDealer; }
    @JsonProperty("car_dealer")
    public void setCarDealer(boolean value) { this.carDealer = value; }

    @JsonProperty("real_estate_agency")
    public boolean getRealEstateAgency() { return realEstateAgency; }
    @JsonProperty("real_estate_agency")
    public void setRealEstateAgency(boolean value) { this.realEstateAgency = value; }

    @JsonProperty("tags")
    public Object getTags() { return tags; }
    @JsonProperty("tags")
    public void setTags(Object value) { this.tags = value; }
}
