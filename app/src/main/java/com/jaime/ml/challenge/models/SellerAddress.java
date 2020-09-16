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

public class SellerAddress {
    @SerializedName("id")
    private String id;
    @SerializedName("comment")
    private String comment;
    @SerializedName("address_line")
    private String addressLine;
    @SerializedName("zip_code")
    private String zipCode;
    @SerializedName("country")
    private City country;
    @SerializedName("state")
    private City state;
    @SerializedName("city")
    private City city;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;


    public String getId() { return id; }

    public void setId(String value) { this.id = value; }


    public String getComment() { return comment; }

    public void setComment(String value) { this.comment = value; }


    public String getAddressLine() { return addressLine; }

    public void setAddressLine(String value) { this.addressLine = value; }


    public String getZipCode() { return zipCode; }

    public void setZipCode(String value) { this.zipCode = value; }


    public City getCountry() { return country; }

    public void setCountry(City value) { this.country = value; }


    public City getState() { return state; }

    public void setState(City value) { this.state = value; }


    public City getCity() { return city; }

    public void setCity(City value) { this.city = value; }


    public String getLatitude() { return latitude; }

    public void setLatitude(String value) { this.latitude = value; }


    public String getLongitude() { return longitude; }

    public void setLongitude(String value) { this.longitude = value; }
}
