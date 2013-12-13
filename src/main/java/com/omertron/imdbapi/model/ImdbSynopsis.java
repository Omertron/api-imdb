package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbSynopsis extends AbstractJsonMapping {

    @JsonProperty("tconst")
    private String imdbId = "";
    @JsonProperty("text")
    private String text = "";
    @JsonProperty("type")
    private String type = "";
    @JsonProperty("title")
    private String title = "";
    @JsonProperty("year")
    private int year = -1;

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
