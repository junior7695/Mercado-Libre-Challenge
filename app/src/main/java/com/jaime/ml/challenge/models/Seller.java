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

public class Seller {
    @SerializedName("id")
    private long id;
    @SerializedName("permalink")
    private String permalink;
    @SerializedName("registration_date")
    private String registrationDate;
    @SerializedName("car_dealer")
    private boolean carDealer;
    @SerializedName("real_estate_agency")
    private boolean realEstateAgency;
    @SerializedName("tags")
    private String tags;


    public long getId() { return id; }

    public void setId(long value) { this.id = value; }


    public String getPermalink() { return permalink; }

    public void setPermalink(String value) { this.permalink = value; }


    public String getRegistrationDate() { return registrationDate; }

    public void setRegistrationDate(String value) { this.registrationDate = value; }


    public boolean getCarDealer() { return carDealer; }

    public void setCarDealer(boolean value) { this.carDealer = value; }


    public boolean getRealEstateAgency() { return realEstateAgency; }

    public void setRealEstateAgency(boolean value) { this.realEstateAgency = value; }


    public String getTags() { return tags; }

    public void setTags(String value) { this.tags = value; }
}
