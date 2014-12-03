package com.omertron.imdbapi.wrapper;

import com.omertron.imdbapi.model.ImdbSynopsis;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JSON Wrapper class for the response from the API
 *
 * Not intended for use outside of the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties({"@meta", "exp", "copyright", "@type", "db"})
public class WrapperSynopsis extends AbstractWrapper {

    @JsonProperty("data")
    private ImdbSynopsis synopsis;

    public ImdbSynopsis getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(ImdbSynopsis synopsis) {
        this.synopsis = synopsis;
    }
}
