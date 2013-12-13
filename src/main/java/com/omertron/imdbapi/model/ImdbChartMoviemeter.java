package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbChartMoviemeter extends AbstractJsonMapping {

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
}