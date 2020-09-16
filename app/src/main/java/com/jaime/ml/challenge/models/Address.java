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

public class Address {
    @SerializedName("state_id")
    private String stateId;
    @SerializedName("state_name")
    private String stateName;
    @SerializedName("city_id")
    private String cityId;
    @SerializedName("city_name")
    private String cityName;

    public String getStateId() { return stateId; }

    public void setStateId(String value) { this.stateId = value; }


    public String getStateName() { return stateName; }

    public void setStateName(String value) { this.stateName = value; }


    public String getCityId() { return cityId; }

    public void setCityId(String value) { this.cityId = value; }


    public String getCityName() { return cityName; }

    public void setCityName(String value) { this.cityName = value; }
}
