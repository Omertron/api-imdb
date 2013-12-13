package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbBoxOffice extends AbstractJsonMapping{

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

}
