package com.moviejukebox.imdbapi.model;

import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

public class ImdbChartMoviemeter {

    private static final Logger LOGGER = Logger.getLogger(ImdbChartMoviemeter.class);
    @JsonProperty("rank")
    private int rank;
    @JsonProperty("prev")
    private int prev;
    @JsonProperty("object")
    private ImdbMovie movie;

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
        LOGGER.warn(sb.toString());
    }
}
