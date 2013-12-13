package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbEncodingFormat extends AbstractJsonMapping {

    @JsonProperty("format")
    private String format = "";
    @JsonProperty("url")
    private String url = "";

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
