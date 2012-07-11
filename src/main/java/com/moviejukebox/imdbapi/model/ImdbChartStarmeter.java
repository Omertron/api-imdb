package com.moviejukebox.imdbapi.model;

import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

public class ImdbChartStarmeter {

    private static final Logger LOGGER = Logger.getLogger(ImdbChartStarmeter.class);
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

    @Override
    public String toString() {
        return "ImdbChartStarmeter{" + "rank=" + rank + ", prev=" + prev + ", person=" + person + '}';
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
