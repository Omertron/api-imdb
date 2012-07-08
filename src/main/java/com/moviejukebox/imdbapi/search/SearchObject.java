package com.moviejukebox.imdbapi.search;

import com.moviejukebox.imdbapi.model.ImdbImageDetails;
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
