package com.omertron.imdbapi.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.omertron.imdbapi.model.ImdbMovieDetails;

/**
 * JSON Wrapper class for the response from the API
 *
 * Not intended for use outside of the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties({"@meta", "exp", "copyright", "@type", "db"})
public class WrapperMovieDetails extends AbstractWrapper<ImdbMovieDetails> {

    @JsonSetter("data")
    @Override
    public void setResult(ImdbMovieDetails result) {
        this.result = result;
    }

    @Override
    public ImdbMovieDetails getResult() {
        return getResult(ImdbMovieDetails.class);
    }
}
