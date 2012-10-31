package com.moviejukebox.imdbapi.model;

import com.moviejukebox.imdbapi.search.SearchObject;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbMovieDetails extends SearchObject {

    private static final Logger LOGGER = Logger.getLogger(ImdbMovieDetails.class);
    @JsonProperty("photos")
    private List<ImdbImage> photos = Collections.EMPTY_LIST;
    @JsonProperty("certificate")
    private Map<String, String> certificate = Collections.EMPTY_MAP;
    @JsonProperty("has")
    private List<String> has = Collections.EMPTY_LIST;
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
    private List<String> genres = Collections.EMPTY_LIST;
    @JsonProperty("num_votes")
    private double numVotes = -1;
    @JsonProperty("can_rate")
    private boolean canRate = Boolean.FALSE;
    @JsonProperty("quote")
    private ImdbQuote quote = new ImdbQuote();
    @JsonProperty("release_date")
    private Map<String, String> releaseDate = Collections.EMPTY_MAP;
    @JsonProperty("goof")
    private String goof = "";
    @JsonProperty("trivium")
    private String trivium = "";
    @JsonProperty("news")
    private ImdbNews news = new ImdbNews();
    @JsonProperty("writers_summary")
    private List<ImdbCast> writers = Collections.EMPTY_LIST;
    @JsonProperty("directors_summary")
    private List<ImdbCast> directors = Collections.EMPTY_LIST;
    @JsonProperty("plot")
    private ImdbPlot plot = new ImdbPlot();
    @JsonProperty("best_plot")
    private ImdbPlot bestPlot = new ImdbPlot();
    @JsonProperty("cast_summary")
    private List<ImdbCast> cast = Collections.EMPTY_LIST;
    @JsonProperty("user_comment")
    private ImdbUserComment userComment = new ImdbUserComment();
    @JsonProperty("trailer")
    private ImdbTrailer trailer = new ImdbTrailer();
    @JsonProperty("principals")
    private List<ImdbPerson> principals = Collections.EMPTY_LIST;
    @JsonProperty("seasons")
    private List<Integer> seasons = Collections.EMPTY_LIST;
    @JsonProperty("creators")
    private List<ImdbCast> creators = Collections.EMPTY_LIST;
    @JsonProperty("production_status")
    private String productionStatus = "";

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

    @Override
    public String toString() {
        return "ImdbMovieDetails{" + "photos=" + photos + ", certificate=" + certificate + ", has=" + has + ", type=" + type + ", title=" + title + ", year=" + year + ", runtime=" + runtime + ", tagline=" + tagline + ", rating=" + rating + ", imdbId=" + imdbId + ", genres=" + genres + ", numVotes=" + numVotes + ", canRate=" + canRate + ", quote=" + quote + ", releaseDate=" + releaseDate + ", goof=" + goof + ", trivium=" + trivium + ", news=" + news + ", writers=" + writers + ", directors=" + directors + ", plot=" + plot + ", bestPlot=" + bestPlot + ", cast=" + cast + ", userComment=" + userComment + ", trailer=" + trailer + ", principals=" + principals + ", seasons=" + seasons + ", creators=" + creators + ", productionStatus=" + productionStatus + '}';
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
