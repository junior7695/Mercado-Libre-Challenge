package com.jaime.ml.challenge.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Attribute {
    private long source;
    private String id;
    private String name;
    private String valueId;
    private String attributeGroupName;
    private String valueName;
    private Struct valueStruct;
    private List<Value> values;
    private String attributeGroupId;

    @JsonProperty("source")
    public long getSource() { return source; }
    @JsonProperty("source")
    public void setSource(long value) { this.source = value; }

    @JsonProperty("id")
    public String getId() { return id; }
    @JsonProperty("id")
    public void setId(String value) { this.id = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("value_id")
    public String getValueId() { return valueId; }
    @JsonProperty("value_id")
    public void setValueId(String value) { this.valueId = value; }

    @JsonProperty("attribute_group_name")
    public String getAttributeGroupName() { return attributeGroupName; }
    @JsonProperty("attribute_group_name")
    public void setAttributeGroupName(String value) { this.attributeGroupName = value; }

    @JsonProperty("value_name")
    public String getValueName() { return valueName; }
    @JsonProperty("value_name")
    public void setValueName(String value) { this.valueName = value; }

    @JsonProperty("value_struct")
    public Struct getValueStruct() { return valueStruct; }
    @JsonProperty("value_struct")
    public void setValueStruct(Struct value) { this.valueStruct = value; }

    @JsonProperty("values")
    public List<Value> getValues() { return values; }
    @JsonProperty("values")
    public void setValues(List<Value> value) { this.values = value; }

    @JsonProperty("attribute_group_id")
    public String getAttributeGroupId() { return attributeGroupId; }
    @JsonProperty("attribute_group_id")
    public void setAttributeGroupId(String value) { this.attributeGroupId = value; }
}
