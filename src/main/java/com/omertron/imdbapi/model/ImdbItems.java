package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbItems extends AbstractJsonMapping {

    @JsonProperty("source")
    private String source = "";
    @JsonProperty("head")
    private String head = "";
    @JsonProperty("id")
    private String id = "";
    @JsonProperty("datetime")
    private String dateTime = "";

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}