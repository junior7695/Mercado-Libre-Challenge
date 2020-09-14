package com.jaime.ml.challenge.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    private String stateId;
    private String stateName;
    private String cityId;
    private String cityName;

    @JsonProperty("state_id")
    public String getStateId() { return stateId; }
    @JsonProperty("state_id")
    public void setStateId(String value) { this.stateId = value; }

    @JsonProperty("state_name")
    public String getStateName() { return stateName; }
    @JsonProperty("state_name")
    public void setStateName(String value) { this.stateName = value; }

    @JsonProperty("city_id")
    public String getCityId() { return cityId; }
    @JsonProperty("city_id")
    public void setCityId(String value) { this.cityId = value; }

    @JsonProperty("city_name")
    public String getCityName() { return cityName; }
    @JsonProperty("city_name")
    public void setCityName(String value) { this.cityName = value; }
}
