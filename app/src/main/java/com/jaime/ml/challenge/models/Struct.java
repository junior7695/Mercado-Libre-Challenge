package com.jaime.ml.challenge.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Struct {
    private long number;
    private String unit;

    @JsonProperty("number")
    public long getNumber() { return number; }
    @JsonProperty("number")
    public void setNumber(long value) { this.number = value; }

    @JsonProperty("unit")
    public String getUnit() { return unit; }
    @JsonProperty("unit")
    public void setUnit(String value) { this.unit = value; }
}
