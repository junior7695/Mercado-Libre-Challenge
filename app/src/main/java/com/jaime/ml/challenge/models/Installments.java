package com.jaime.ml.challenge.models;

/*-----------------------------------------------*/
/*					Author                       */
/*				Jaime Vallejo                    */
/*                                               */
/*				Fecha Creacion                   */
/*				  14/09/2020                     */
/*                                               */
/*				Descripcion                      */
/*   Proyecto creado como un Challenge de ML     */
/*   como proceso de selección                   */
/*-----------------------------------------------*/


import com.google.gson.annotations.SerializedName;

public class Installments {
    @SerializedName("quantity")
    private long quantity;
    @SerializedName("amount")
    private double amount;
    @SerializedName("rate")
    private long rate;
    @SerializedName("currency_id")
    private String currencyId;


    public long getQuantity() { return quantity; }

    public void setQuantity(long value) { this.quantity = value; }


    public double getAmount() { return amount; }

    public void setAmount(double value) { this.amount = value; }


    public long getRate() { return rate; }

    public void setRate(long value) { this.rate = value; }


    public String getCurrencyId() { return currencyId; }

    public void setCurrencyId(String value) { this.currencyId = value; }
}
