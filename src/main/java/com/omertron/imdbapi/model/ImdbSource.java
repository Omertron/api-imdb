package com.omertron.imdbapi.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class ImdbSource {
    @JsonProperty("logo")
    private String logo;
    @JsonProperty("url")
    private String url;
    @JsonProperty("label")
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
