package com.omertron.imdbapi.wrapper;

import com.omertron.imdbapi.model.ImdbMovieDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * JSON Wrapper class for the response from the API
 *
 * Not intended for use outside of the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties({"@meta", "exp", "copyright", "@type", "db"})
public class WrapperMovieDetails extends AbstractWrapper {

    @JsonProperty("data")
    private ImdbMovieDetails movie;

    public ImdbMovieDetails getMovie() {
        return movie;
    }

    public void setMovie(ImdbMovieDetails movie) {
        this.movie = movie;
    }
}
