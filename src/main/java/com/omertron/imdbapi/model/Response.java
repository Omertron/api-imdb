package com.omertron.imdbapi.model;

import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * This class holds the various responses from the API
 *
 * @author stuart.boston
 */
public class Response {

    private static final Logger LOGGER = Logger.getLogger(Response.class);
    @JsonProperty("copyright")
    private String copyright;
    @JsonProperty("tconst")
    private String imdbId;
    @JsonProperty("limit")
    private int limit;
    @JsonProperty("type")
    private String type;
    @JsonProperty("title")
    private String title;
    @JsonProperty("total")
    private int total;
    @JsonProperty("year")
    private int year;
    @JsonProperty("country")
    private String country;
    @JsonProperty("parental_guide")
    private List<ImdbText> parentalGuide = Collections.EMPTY_LIST;
    @JsonProperty("user_comments")
    private List<ImdbUserComment> userComments = Collections.EMPTY_LIST;
    @JsonProperty("reviews")
    private List<ImdbReview> externalReviews = Collections.EMPTY_LIST;
    @JsonProperty("list")
    private WrapperList list;
    @JsonProperty("quotes")
    private List<String> quotes;
    @JsonProperty("nconst")
    private String actorId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("trivia")
    private List<ImdbText> trivia;
    @JsonProperty("filmography")
    private List<ImdbFilmography> filmography = Collections.EMPTY_LIST;
    @JsonProperty("seasons")
    private List<ImdbSeason> seasons = Collections.EMPTY_LIST;
    @JsonProperty("spoilt")
    private List<ImdbSpoiler> spoilt = Collections.EMPTY_LIST;
    @JsonProperty("unspoilt")
    private List<ImdbSpoiler> unspoilt = Collections.EMPTY_LIST;
    @JsonProperty("photos")
    private List<ImdbImage> photos = Collections.EMPTY_LIST;
    @JsonProperty("credits")
    private List<ImdbCredit> credits = Collections.EMPTY_LIST;

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

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
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
