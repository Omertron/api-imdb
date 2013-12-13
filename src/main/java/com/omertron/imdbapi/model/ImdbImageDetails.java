package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbImageDetails extends AbstractJsonMapping {

    @JsonProperty("width")
    private int width = -1;
    @JsonProperty("height")
    private int height = -1;
    @JsonProperty("url")
    private String url = "";

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}