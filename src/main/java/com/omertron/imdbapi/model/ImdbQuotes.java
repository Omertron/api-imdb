package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;

public class ImdbQuotes extends AbstractJsonMapping {

    @JsonProperty("tconst")
    private String imdbId = "";
    @JsonProperty("type")
    private String type = "";
    @JsonProperty("title")
    private String title = "";
    @JsonProperty("year")
    private int year = -1;
    @JsonProperty("quotes")
    private List<ImdbQuote> lines = Collections.emptyList();

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

}
