package com.jaime.ml.challenge.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Shipping {
    private boolean freeShipping;
    private String mode;
    private List<String> tags;
    private String logisticType;
    private boolean storePickUp;

    @JsonProperty("free_shipping")
    public boolean getFreeShipping() { return freeShipping; }
    @JsonProperty("free_shipping")
    public void setFreeShipping(boolean value) { this.freeShipping = value; }

    @JsonProperty("mode")
    public String getMode() { return mode; }
    @JsonProperty("mode")
    public void setMode(String value) { this.mode = value; }

    @JsonProperty("tags")
    public List<String> getTags() { return tags; }
    @JsonProperty("tags")
    public void setTags(List<String> value) { this.tags = value; }

    @JsonProperty("logistic_type")
    public String getLogisticType() { return logisticType; }
    @JsonProperty("logistic_type")
    public void setLogisticType(String value) { this.logisticType = value; }

    @JsonProperty("store_pick_up")
    public boolean getStorePickUp() { return storePickUp; }
    @JsonProperty("store_pick_up")
    public void setStorePickUp(boolean value) { this.storePickUp = value; }
}
