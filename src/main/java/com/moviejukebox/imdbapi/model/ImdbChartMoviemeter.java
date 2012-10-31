package com.moviejukebox.imdbapi.model;

import org.apache.log4j.Logger;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbChartMoviemeter {

    private static final Logger LOGGER = Logger.getLogger(ImdbChartMoviemeter.class);
    @JsonProperty("rank")
    private int rank = -1;
    @JsonProperty("prev")
    private int prev = -1;
    @JsonProperty("object")
    private ImdbMovie movie = new ImdbMovie();

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPrev() {
        return prev;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }

    public ImdbMovie getMovie() {
        return movie;
    }

    public void setMovie(ImdbMovie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "ImdbChartMoviemeter{" + "rank=" + rank + ", prev=" + prev + ", movie=" + movie + '}';
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
        LOGGER.trace(sb.toString());
    }
}
