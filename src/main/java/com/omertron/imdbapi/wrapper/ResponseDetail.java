package com.omertron.imdbapi.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omertron.imdbapi.model.AbstractJsonMapping;
import com.omertron.imdbapi.model.ImdbCredit;
import com.omertron.imdbapi.model.ImdbFilmography;
import com.omertron.imdbapi.model.ImdbImage;
import com.omertron.imdbapi.model.ImdbPlot;
import com.omertron.imdbapi.model.ImdbReview;
import com.omertron.imdbapi.model.ImdbSeason;
import com.omertron.imdbapi.model.ImdbSpoiler;
import com.omertron.imdbapi.model.ImdbText;
import com.omertron.imdbapi.model.ImdbUserComment;
import java.util.Collections;
import java.util.List;

/**
 * This class holds the various responses from the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties({"copyright"})
public class ResponseDetail extends AbstractJsonMapping {

    @JsonProperty("tconst")
    private String imdbId = "";
    @JsonProperty("limit")
    private int limit = -1;
    @JsonProperty("type")
    private String type = "";
    @JsonProperty("title")
    private String title = "";
    @JsonProperty("total")
    private int total = -1;
    @JsonProperty("year")
    private int year = -1;
    @JsonProperty("country")
    private String country = "";
    @JsonProperty("parental_guide")
    private List<ImdbText> parentalGuide = Collections.emptyList();
    @JsonProperty("user_comments")
    private List<ImdbUserComment> userComments = Collections.emptyList();
    @JsonProperty("reviews")
    private List<ImdbReview> externalReviews = Collections.emptyList();
    @JsonProperty("list")
    private WrapperList list;
    @JsonProperty("quotes")
    private List<String> quotes = Collections.emptyList();
    @JsonProperty("nconst")
    private String actorId = "";
    @JsonProperty("name")
    private String name = "";
    @JsonProperty("trivia")
    private List<ImdbText> trivia = Collections.emptyList();
    @JsonProperty("filmography")
    private List<ImdbFilmography> filmography = Collections.emptyList();
    @JsonProperty("seasons")
    private List<ImdbSeason> seasons = Collections.emptyList();
    @JsonProperty("spoilt")
    private List<ImdbSpoiler> spoilt = Collections.emptyList();
    @JsonProperty("unspoilt")
    private List<ImdbSpoiler> unspoilt = Collections.emptyList();
    @JsonProperty("photos")
    private List<ImdbImage> photos = Collections.emptyList();
    @JsonProperty("credits")
    private List<ImdbCredit> credits = Collections.emptyList();
    @JsonProperty("date")
    private String date = "";
    @JsonProperty("plots")
    private List<ImdbPlot> plots = Collections.emptyList();

    public List<ImdbCredit> getCredits() {
        return credits;
    }

    public void setCredits(List<ImdbCredit> credits) {
        this.credits = credits;
    }

    public List<ImdbImage> getPhotos() {
        return photos;
    }

    public void setPhotos(List<ImdbImage> photos) {
        this.photos = photos;
    }

    public List<ImdbSpoiler> getSpoilt() {
        return spoilt;
    }

    public void setSpoilt(List<ImdbSpoiler> spoilt) {
        this.spoilt = spoilt;
    }

    public List<ImdbSpoiler> getUnspoilt() {
        return unspoilt;
    }

    public void setUnspoilt(List<ImdbSpoiler> unspoilt) {
        this.unspoilt = unspoilt;
    }

    public List<ImdbSeason> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<ImdbSeason> seasons) {
        this.seasons = seasons;
    }

    public List<ImdbFilmography> getFilmography() {
        return filmography;
    }

    public void setFilmography(List<ImdbFilmography> filmography) {
        this.filmography = filmography;
    }

    public List<ImdbText> getParentalGuide() {
        return parentalGuide;
    }

    public void setParentalGuide(List<ImdbText> parentalGuide) {
        this.parentalGuide = parentalGuide;
    }

    public List<ImdbUserComment> getUserComments() {
        return userComments;
    }

    public void setUserComments(List<ImdbUserComment> userComments) {
        this.userComments = userComments;
    }

    public List<ImdbReview> getExternalReviews() {
        return externalReviews;
    }

    public void setExternalReviews(List<ImdbReview> externalReviews) {
        this.externalReviews = externalReviews;
    }

    public WrapperList getList() {
        return list;
    }

    public void setList(WrapperList list) {
        this.list = list;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<String> quotes) {
        this.quotes = quotes;
    }

    public List<ImdbText> getTrivia() {
        return trivia;
    }

    public void setTrivia(List<ImdbText> trivia) {
        this.trivia = trivia;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<ImdbPlot> getPlots() {
        return plots;
    }

    public void setPlots(List<ImdbPlot> plots) {
        this.plots = plots;
    }
}
