package com.moviejukebox.imdbapi.model;

import org.apache.log4j.Logger;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbBoxOffice {

    private static final Logger LOGGER = Logger.getLogger(ImdbBoxOffice.class);
    @JsonProperty("weekend")
    private ImdbMoney weekend = new ImdbMoney();
    @JsonProperty("title")
    private ImdbMovie title = new ImdbMovie();
    @JsonProperty("rank")
    private int rank = -1;
    @JsonProperty("gross")
    private ImdbMoney gross = new ImdbMoney();
    @JsonProperty("vendor_title")
    private String vendorTitle;

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

    public String getVendorTitle() {
        return vendorTitle;
    }

    public void setVendorTitle(String vendorTitle) {
        this.vendorTitle = vendorTitle;
    }

    @Override
    public String toString() {
        return "ImdbBoxOffice{" + "weekend=" + weekend + ", title=" + title + ", rank=" + rank + ", gross=" + gross + ", vendorTitle=" + vendorTitle + '}';
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
