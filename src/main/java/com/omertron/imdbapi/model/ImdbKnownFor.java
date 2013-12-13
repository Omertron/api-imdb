package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbKnownFor extends AbstractJsonMapping {

    @JsonProperty("title")
    private ImdbMovie title = new ImdbMovie();
    @JsonProperty("attr")
    private String attribute = "";

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public ImdbMovie getTitle() {
        return title;
    }

    public void setTitle(ImdbMovie title) {
        this.title = title;
    }
}