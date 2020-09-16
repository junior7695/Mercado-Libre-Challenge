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

public class Value {
    @SerializedName("struct")
    private Struct struct;
    @SerializedName("source")
    private long source;
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;


    public Struct getStruct() { return struct; }

    public void setStruct(Struct value) { this.struct = value; }


    public long getSource() { return source; }

    public void setSource(long value) { this.source = value; }


    public String getId() { return id; }

    public void setId(String value) { this.id = value; }


    public String getName() { return name; }

    public void setName(String value) { this.name = value; }
}
