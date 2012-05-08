package com.omertron.imdbapi.model;

import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

public class ImdbUserComment {

    private static final Logger LOGGER = Logger.getLogger(ImdbUserComment.class);
    @JsonProperty("user_score")
    private int userScore;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("user_location")
    private String userLocation;
    @JsonProperty("text")
    private String text;
    @JsonProperty("date")
    private String date;
    @JsonProperty("status")
    private String status;
    @JsonProperty("user_score_count")
    private int userScoreCount;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("user_rating")
    private int userRating;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public int getUserScoreCount() {
        return userScoreCount;
    }

    public void setUserScoreCount(int userScoreCount) {
        this.userScoreCount = userScoreCount;
    }

    @Override
    public String toString() {
        return "UserComment{" + "userScore=" + userScore + ", summary=" + summary + ", userLocation=" + userLocation + ", date=" + date + ", status=" + status + ", userScoreCount=" + userScoreCount + ", userName=" + userName + ", userRating=" + userRating + '}';
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
