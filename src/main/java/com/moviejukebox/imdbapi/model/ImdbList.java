package com.moviejukebox.imdbapi.model;

import java.util.List;
import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

public class ImdbList {

    private static final Logger LOGGER = Logger.getLogger(ImdbList.class);
    @JsonProperty("label")
    private String label;
    @JsonProperty("token")
    private String token;
    @JsonProperty("list")
    private List<ImdbMovie> movie;
    @JsonProperty("num_votes")
    private int numVotes;
    @JsonProperty("tconst")
    private String imdbId;
    @JsonProperty("type")
    private String type;
    @JsonProperty("title")
    private String title;
    @JsonProperty("can_rate")
    private boolean canRate;
    @JsonProperty("rating")
    private int rating;
    @JsonProperty("image")
    private ImdbImageDetails image;
    @JsonProperty("year")
    private int year;

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
