package com.moviejukebox.imdbapi.model;

import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

public class ImdbBoxOffice {

    private static final Logger LOGGER = Logger.getLogger(ImdbBoxOffice.class);
    @JsonProperty("weekend")
    private ImdbMoney weekend;
    @JsonProperty("title")
    private ImdbMovie title;
    @JsonProperty("rank")
    private int rank;
    @JsonProperty("gross")
    private ImdbMoney gross;

    public ImdbMoney getWeekend() {
        return weekend;
    }

    public void setWeekend(ImdbMoney weekend) {
        this.weekend = weekend;
    }

    public ImdbMovie getTitle() {
        return title;
    }

    public void setTitle(ImdbMovie title) {
        this.title = title;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public ImdbMoney getGross() {
        return gross;
    }

    public void setGross(ImdbMoney gross) {
        this.gross = gross;
    }

    @Override
    public String toString() {
        return "ImdbBoxOffice{" + "weekend=" + weekend + ", title=" + title + ", rank=" + rank + ", gross=" + gross + '}';
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
