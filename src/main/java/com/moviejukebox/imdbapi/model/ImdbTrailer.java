package com.moviejukebox.imdbapi.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

public class ImdbTrailer {

    private static final Logger LOGGER = Logger.getLogger(ImdbTrailer.class);
    @JsonProperty("description")
    private String description = "";
    @JsonProperty("duration_seconds")
    private int durationSeconds = -1;
    @JsonProperty("content_type")
    private String contentType = "";
    @JsonProperty("id")
    private String id = "";
    @JsonProperty("title")
    private String title = "";
    @JsonProperty("@type")
    private String type = "";
    @JsonProperty("relatedTitle")
    private ImdbMovie relatedMovie = new ImdbMovie();
    @JsonProperty("relatedName")
    private ImdbPerson relatedName = new ImdbPerson();
    @JsonProperty("slates")
    private List<ImdbImageDetails> slates = Collections.EMPTY_LIST;
    @JsonProperty("encodings")
    private Map<String, ImdbEncodingFormat> encodings = Collections.EMPTY_MAP;

    public Map<String, ImdbEncodingFormat> getEncodings() {
        return encodings;
    }

    public void setEncodings(Map<String, ImdbEncodingFormat> encodings) {
        this.encodings = encodings;
    }

    public List<ImdbImageDetails> getSlates() {
        return slates;
    }

    public void setSlates(List<ImdbImageDetails> slates) {
        this.slates = slates;
    }

    public ImdbMovie getRelatedMovie() {
        return relatedMovie;
    }

    public void setRelatedMovie(ImdbMovie relatedMovie) {
        this.relatedMovie = relatedMovie;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(int durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ImdbPerson getRelatedName() {
        return relatedName;
    }

    public void setRelatedName(ImdbPerson relatedName) {
        this.relatedName = relatedName;
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

    @Override
    public String toString() {
        return "ImdbTrailer{" + "description=" + description + ", durationSeconds=" + durationSeconds + ", contentType=" + contentType + ", id=" + id + ", title=" + title + ", type=" + type + ", relatedMovie=" + relatedMovie + ", relatedName=" + relatedName + ", slates=" + slates + ", encodings=" + encodings + '}';
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
