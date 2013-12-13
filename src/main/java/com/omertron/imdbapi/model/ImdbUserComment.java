package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbUserComment extends AbstractJsonMapping {

    @JsonProperty("user_score")
    private int userScore = -1;
    @JsonProperty("summary")
    private String summary = "";
    @JsonProperty("user_location")
    private String userLocation = "";
    @JsonProperty("text")
    private String text = "";
    @JsonProperty("date")
    private String date = "";
    @JsonProperty("status")
    private String status = "";
    @JsonProperty("user_score_count")
    private int userScoreCount = -1;
    @JsonProperty("user_name")
    private String userName = "";
    @JsonProperty("user_rating")
    private int userRating = -1;

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

}
