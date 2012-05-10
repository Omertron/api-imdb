package com.moviejukebox.imdbapi.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class SearchObject {

    @JsonProperty("image")
    private ImdbImageDetails image;

    public ImdbImageDetails getImage() {
        return image;
    }

    public void setImage(ImdbImageDetails image) {
        this.image = image;
    }
}
