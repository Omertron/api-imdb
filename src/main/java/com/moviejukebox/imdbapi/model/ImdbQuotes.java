package com.moviejukebox.imdbapi.model;

import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbQuotes {

    private static final Logger LOGGER = Logger.getLogger(ImdbQuotes.class);
    @JsonProperty("tconst")
    private String imdbId = "";
    @JsonProperty("type")
    private String type = "";
    @JsonProperty("title")
    private String title = "";
    @JsonProperty("year")
    private int year = -1;
    @JsonProperty("quotes")
    private List<ImdbQuote> lines = Collections.EMPTY_LIST;

    public List<ImdbQuote> getLines() {
        return lines;
    }

    public void setLines(List<ImdbQuote> lines) {
        this.lines = lines;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "ImdbQuotes{" + "imdbId=" + imdbId + ", type=" + type + ", title=" + title + ", year=" + year + ", lines=" + lines + '}';
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
        LOGGER.trace(sb.toString());
    }
}
