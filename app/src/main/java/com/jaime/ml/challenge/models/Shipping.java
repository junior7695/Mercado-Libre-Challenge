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

import java.util.List;

public class Shipping {
    @SerializedName("free_shipping")
    private boolean freeShipping;
    @SerializedName("mode")
    private String mode;
    @SerializedName("tags")
    private List<String> tags;
    @SerializedName("logistic_type")
    private String logisticType;
    @SerializedName("store_pick_up")
    private boolean storePickUp;


    public boolean getFreeShipping() { return freeShipping; }

    public void setFreeShipping(boolean value) { this.freeShipping = value; }


    public String getMode() { return mode; }

    public void setMode(String value) { this.mode = value; }


    public List<String> getTags() { return tags; }

    public void setTags(List<String> value) { this.tags = value; }


    public String getLogisticType() { return logisticType; }

    public void setLogisticType(String value) { this.logisticType = value; }


    public boolean getStorePickUp() { return storePickUp; }

    public void setStorePickUp(boolean value) { this.storePickUp = value; }
}
