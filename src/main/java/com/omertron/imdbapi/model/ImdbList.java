package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;

public class ImdbList extends AbstractJsonMapping {

    @JsonProperty("label")
    private String label = "";
    @JsonProperty("token")
    private String token = "";
    @JsonProperty("list")
    private List<ImdbMovie> movie = Collections.emptyList();
    @JsonProperty("num_votes")
    private int numVotes = -1;
    @JsonProperty("tconst")
    private String imdbId = "";
    @JsonProperty("type")
    private String type = "";
    @JsonProperty("title")
    private String title = "";
    @JsonProperty("can_rate")
    private boolean canRate = Boolean.FALSE;
    @JsonProperty("rating")
    private int rating = -1;
    @JsonProperty("image")
    private ImdbImageDetails image = new ImdbImageDetails();
    @JsonProperty("year")
    private int year = -1;
    @JsonProperty("weekend")
    private ImdbMoney weekend = new ImdbMoney();

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ImdbMovie> getMovie() {
        return movie;
    }

    public void setMovie(List<ImdbMovie> movie) {
        this.movie = movie;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isCanRate() {
        return canRate;
    }

    public void setCanRate(boolean canRate) {
        this.canRate = canRate;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public int getNumVotes() {
        return numVotes;
    }

    public void setNumVotes(int numVotes) {
        this.numVotes = numVotes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ImdbImageDetails getImage() {
        return image;
    }

    public void setImage(ImdbImageDetails image) {
        this.image = image;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ImdbMoney getWeekend() {
        return weekend;
    }

    public void setWeekend(ImdbMoney weekend) {
        this.weekend = weekend;
    }
}