package com.jaime.ml.challenge.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Value {
    private Struct struct;
    private long source;
    private String id;
    private String name;

    @JsonProperty("struct")
    public Struct getStruct() { return struct; }
    @JsonProperty("struct")
    public void setStruct(Struct value) { this.struct = value; }

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
}
