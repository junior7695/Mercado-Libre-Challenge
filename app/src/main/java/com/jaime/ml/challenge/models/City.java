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

public class City {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;


    public String getId() { return id; }

    public void setId(String value) { this.id = value; }


    public String getName() { return name; }

    public void setName(String value) { this.name = value; }
}
