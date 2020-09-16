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

public class Attribute {
    @SerializedName("source")
    private long source;
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("value_id")
    private String valueId;
    @SerializedName("attribute_group_name")
    private String attributeGroupName;
    @SerializedName("value_name")
    private String valueName;
    @SerializedName("value_struct")
    private Struct valueStruct;
    @SerializedName("values")
    private List<Value> values;
    @SerializedName("attribute_group_id")
    private String attributeGroupId;


    public long getSource() { return source; }

    public void setSource(long value) { this.source = value; }


    public String getId() { return id; }

    public void setId(String value) { this.id = value; }


    public String getName() { return name; }

    public void setName(String value) { this.name = value; }


    public String getValueId() { return valueId; }

    public void setValueId(String value) { this.valueId = value; }


    public String getAttributeGroupName() { return attributeGroupName; }

    public void setAttributeGroupName(String value) { this.attributeGroupName = value; }


    public String getValueName() { return valueName; }

    public void setValueName(String value) { this.valueName = value; }


    public Struct getValueStruct() { return valueStruct; }

    public void setValueStruct(Struct value) { this.valueStruct = value; }


    public List<Value> getValues() { return values; }

    public void setValues(List<Value> value) { this.values = value; }


    public String getAttributeGroupId() { return attributeGroupId; }

    public void setAttributeGroupId(String value) { this.attributeGroupId = value; }
}
