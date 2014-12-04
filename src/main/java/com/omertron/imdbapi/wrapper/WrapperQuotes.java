package com.omertron.imdbapi.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omertron.imdbapi.model.AbstractJsonMapping;
import com.omertron.imdbapi.model.ImdbQuotes;

/**
 * JSON Wrapper class for the response from the API
 *
 * Not intended for use outside of the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties({"@meta", "exp", "copyright", "@type", "db"})
public class WrapperQuotes extends AbstractJsonMapping {

    @JsonProperty("data")
    private ImdbQuotes quotes;

    public ImdbQuotes getQuotes() {
        return quotes;
    }

    public void setQuotes(ImdbQuotes quotes) {
        this.quotes = quotes;
    }
}
