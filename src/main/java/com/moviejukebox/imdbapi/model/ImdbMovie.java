package com.moviejukebox.imdbapi.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

public class ImdbMovie {

    private static final Logger LOGGER = Logger.getLogger(ImdbMovie.class);
    private String imdbId = "";
    @JsonProperty("type")
    private String type = "";
    @JsonProperty("title")
    private String title = "";
    @JsonProperty("principals")
    private List<ImdbPerson> principles = Collections.EMPTY_LIST;
    @JsonProperty("image")
    private ImdbImageDetails image = new ImdbImageDetails();
    private int year = -1;
    private String releaseDate = "";

    public List<ImdbPerson> getPrinciples() {
        return principles;
    }

    public void setPrinciples(List<ImdbPerson> principles) {
        this.principles = principles;
    }

    public String getImdbId() {
        return imdbId;
    }

    @JsonProperty("tconst")
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @JsonProperty("title_id")
    public void setTitleId(String imdbId) {
        this.imdbId = imdbId;
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

    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("release_date")
    public void setReleaseDate(Map<String, String> releaseDate) {
        if (!releaseDate.isEmpty()) {
            for (Entry<String, String> rd : releaseDate.entrySet()) {
                this.releaseDate = rd.getValue();
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "ImdbMovie{" + "imdbId=" + imdbId + ", type=" + type + ", title=" + title + ", principles=" + principles + ", image=" + image + ", year=" + year + ", releaseDate=" + releaseDate + '}';
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
