package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbSpoiler extends AbstractJsonMapping {

    @JsonProperty("spoiler")
    private String spoiler;
    @JsonProperty("text")
    private String text;
    @JsonProperty("type")
    private String type;

    public ImdbSpoiler() {
        this("", "", "");
    }

    public ImdbSpoiler(String spoiler, String text, String type) {
        this.spoiler = spoiler;
        this.text = text;
        this.type = type;
    }

    public String getSpoiler() {
        return spoiler;
    }

    public void setSpoiler(String spoiler) {
        this.spoiler = spoiler;
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

}
