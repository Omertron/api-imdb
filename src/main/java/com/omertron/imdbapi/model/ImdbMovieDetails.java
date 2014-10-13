package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.omertron.imdbapi.search.SearchObject;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class ImdbMovieDetails extends SearchObject {

    @JsonProperty("photos")
    private List<ImdbImage> photos = Collections.emptyList();
    @JsonProperty("certificate")
    private Map<String, String> certificate = Collections.emptyMap();
    @JsonProperty("has")
    private List<String> has = Collections.emptyList();
    @JsonProperty("type")
    private String type = "";
    @JsonProperty("title")
    private String title = "";
    private int year = -1;
    @JsonProperty("runtime")
    private ImdbRuntime runtime = new ImdbRuntime();
    @JsonProperty("tagline")
    private String tagline = "";
    @JsonProperty("rating")
    private float rating = 0.0f;
    @JsonProperty("tconst")
    private String imdbId = "";
    @JsonProperty("genres")
    private List<String> genres = Collections.emptyList();
    @JsonProperty("num_votes")
    private double numVotes = -1;
    @JsonProperty("can_rate")
    private boolean canRate = Boolean.FALSE;
    @JsonProperty("quote")
    private ImdbQuote quote = new ImdbQuote();
    @JsonProperty("release_date")
    private Map<String, String> releaseDate = Collections.emptyMap();
    @JsonProperty("goof")
    private String goof = "";
    @JsonProperty("trivium")
    private String trivium = "";
    @JsonProperty("news")
    private ImdbNews news = new ImdbNews();
    @JsonProperty("writers_summary")
    private List<ImdbCast> writers = Collections.emptyList();
    @JsonProperty("directors_summary")
    private List<ImdbCast> directors = Collections.emptyList();
    @JsonProperty("plot")
    private ImdbPlot plot = new ImdbPlot();
    @JsonProperty("best_plot")
    private ImdbPlot bestPlot = new ImdbPlot();
    @JsonProperty("cast_summary")
    private List<ImdbCast> cast = Collections.emptyList();
    @JsonProperty("user_comment")
    private ImdbUserComment userComment = new ImdbUserComment();
    @JsonProperty("trailer")
    private ImdbTrailer trailer = new ImdbTrailer();
    @JsonProperty("principals")
    private List<ImdbPerson> principals = Collections.emptyList();
    @JsonProperty("seasons")
    private List<Integer> seasons = Collections.emptyList();
    @JsonProperty("creators")
    private List<ImdbCast> creators = Collections.emptyList();
    @JsonProperty("production_status")
    private String productionStatus = "";
    @JsonProperty("year_end")
    private String yearEnd = "";

    public List<ImdbPerson> getPrincipals() {
        return principals;
    }

    public void setPrincipals(List<ImdbPerson> principals) {
        this.principals = principals;
    }

    public ImdbTrailer getTrailer() {
        return trailer;
    }

    public void setTrailer(ImdbTrailer trailer) {
        this.trailer = trailer;
    }

    public ImdbUserComment getUserComment() {
        return userComment;
    }

    public void setUserComment(ImdbUserComment userComment) {
        this.userComment = userComment;
    }

    public List<ImdbCast> getCast() {
        return cast;
    }

    public void setCast(List<ImdbCast> cast) {
        this.cast = cast;
    }

    public ImdbPlot getPlot() {
        return plot;
    }

    public void setPlot(ImdbPlot plot) {
        this.plot = plot;
    }

    public List<ImdbCast> getDirectors() {
        return directors;
    }

    public void setDirectors(List<ImdbCast> directors) {
        this.directors = directors;
    }

    public List<ImdbCast> getWriters() {
        return writers;
    }

    public void setWriters(List<ImdbCast> writers) {
        this.writers = writers;
    }

    public ImdbNews getNews() {
        return news;
    }

    public void setNews(ImdbNews news) {
        this.news = news;
    }

    public String getTrivium() {
        return trivium;
    }

    public void setTrivium(String trivium) {
        this.trivium = trivium;
    }

    public String getGoof() {
        return goof;
    }

    public void setGoof(String goof) {
        this.goof = goof;
    }

    public Map<String, String> getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Map<String, String> releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ImdbQuote getQuote() {
        return quote;
    }

    public void setQuote(ImdbQuote quote) {
        this.quote = quote;
    }

    public boolean isCanRate() {
        return canRate;
    }

    public void setCanRate(boolean canRate) {
        this.canRate = canRate;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public double getNumVotes() {
        return numVotes;
    }

    public void setNumVotes(double numVotes) {
        this.numVotes = numVotes;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Map<String, String> getCertificate() {
        return certificate;
    }

    public void setCertificate(Map<String, String> certificate) {
        this.certificate = certificate;
    }

    public List<String> getHas() {
        return has;
    }

    public void setHas(List<String> has) {
        this.has = has;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
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

    public int getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(String year) {
        if (StringUtils.isNumeric(year)) {
            this.year = Integer.parseInt(year);
        } else {
            this.year = 0;
        }
    }

    public List<ImdbImage> getPhotos() {
        return photos;
    }

    public void setPhotos(List<ImdbImage> photos) {
        this.photos = photos;
    }

    public ImdbPlot getBestPlot() {
        return bestPlot;
    }

    public void setBestPlot(ImdbPlot bestPlot) {
        this.bestPlot = bestPlot;
    }

    public List<Integer> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Integer> seasons) {
        this.seasons = seasons;
    }

    public List<ImdbCast> getCreators() {
        return creators;
    }

    public void setCreators(List<ImdbCast> creators) {
        this.creators = creators;
    }

    public String getProductionStatus() {
        return productionStatus;
    }

    public void setProductionStatus(String productionStatus) {
        this.productionStatus = productionStatus;
    }

    public ImdbRuntime getRuntime() {
        return runtime;
    }

    public void setRuntime(ImdbRuntime runtime) {
        this.runtime = runtime;
    }

    public String getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(String yearEnd) {
        this.yearEnd = yearEnd;
    }
}