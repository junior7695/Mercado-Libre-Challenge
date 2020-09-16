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

public class Struct {
    @SerializedName("number")
    private long number;
    @SerializedName("unit")
    private String unit;


    public long getNumber() { return number; }

    public void setNumber(long value) { this.number = value; }


    public String getUnit() { return unit; }

    public void setUnit(String value) { this.unit = value; }
}
