package com.omertron.imdbapi.model;

import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

public class ImdbSearchResult {

    private static final Logger LOGGER = Logger.getLogger(ImdbSearchResult.class);
    @JsonProperty("label")
    private String label;
    @JsonProperty("list")
    private List<ImdbMovieDetails> movies = Collections.EMPTY_LIST;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ImdbMovieDetails> getMovies() {
        return movies;
    }

    public void setMovies(List<ImdbMovieDetails> movies) {
        this.movies = movies;
    }

    /**
     * Handle unknown properties and print a message
     *
     * @param key
     * @param value
     */
    @JsonAnySetter
    public void handleUnknown(String key, Object value) {
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown property: '").append(key);
        sb.append("' value: '").append(value).append("'");
        LOGGER.warn(sb.toString());
    }
}
