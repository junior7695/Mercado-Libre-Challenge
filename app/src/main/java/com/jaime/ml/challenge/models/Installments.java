package com.jaime.ml.challenge.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Installments {
    private long quantity;
    private double amount;
    private long rate;
    private String currencyId;

    @JsonProperty("quantity")
    public long getQuantity() { return quantity; }
    @JsonProperty("quantity")
    public void setQuantity(long value) { this.quantity = value; }

    @JsonProperty("amount")
    public double getAmount() { return amount; }
    @JsonProperty("amount")
    public void setAmount(double value) { this.amount = value; }

    @JsonProperty("rate")
    public long getRate() { return rate; }
    @JsonProperty("rate")
    public void setRate(long value) { this.rate = value; }

    @JsonProperty("currency_id")
    public String getCurrencyId() { return currencyId; }
    @JsonProperty("currency_id")
    public void setCurrencyId(String value) { this.currencyId = value; }
}
