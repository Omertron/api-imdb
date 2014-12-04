package com.omertron.imdbapi.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omertron.imdbapi.model.AbstractJsonMapping;
import com.omertron.imdbapi.model.ImdbSynopsis;

/**
 * JSON Wrapper class for the response from the API
 *
 * Not intended for use outside of the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties({"@meta", "exp", "copyright", "@type", "db"})
public class WrapperSynopsis extends AbstractJsonMapping {

    @JsonProperty("data")
    private ImdbSynopsis synopsis;

    public ImdbSynopsis getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(ImdbSynopsis synopsis) {
        this.synopsis = synopsis;
    }
}
