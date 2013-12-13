package com.omertron.imdbapi.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.omertron.imdbapi.model.AbstractJsonMapping;
import com.omertron.imdbapi.model.ImdbImageDetails;

public class SearchObject extends AbstractJsonMapping {

    @JsonProperty("image")
    private ImdbImageDetails image;

    public ImdbImageDetails getImage() {
        return image;
    }

    public void setImage(ImdbImageDetails image) {
        this.image = image;
    }
}
