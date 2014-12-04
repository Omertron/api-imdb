package com.omertron.imdbapi.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omertron.imdbapi.model.AbstractJsonMapping;
import com.omertron.imdbapi.model.ImdbMovieDetails;

/**
 * JSON Wrapper class for the response from the API
 *
 * Not intended for use outside of the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties({"@meta", "exp", "copyright", "@type", "db"})
public class WrapperMovieDetails extends AbstractJsonMapping {

    @JsonProperty("data")
    private ImdbMovieDetails movie;

    public ImdbMovieDetails getMovie() {
        return movie;
    }

    public void setMovie(ImdbMovieDetails movie) {
        this.movie = movie;
    }
}
