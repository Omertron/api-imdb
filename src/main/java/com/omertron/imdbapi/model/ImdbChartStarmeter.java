package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbChartStarmeter extends AbstractJsonMapping {

    @JsonProperty("rank")
    private int rank = -1;
    @JsonProperty("prev")
    private int prev = -1;
    @JsonProperty("object")
    private ImdbPerson person = new ImdbPerson();

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

    public ImdbPerson getPerson() {
        return person;
    }

    public void setPerson(ImdbPerson person) {
        this.person = person;
    }
}
