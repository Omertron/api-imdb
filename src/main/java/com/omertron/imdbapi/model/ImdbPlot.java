package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbPlot extends AbstractJsonMapping {

    @JsonProperty("outline")
    private String outline = "";
    @JsonProperty("more")
    private int more = -1;
    @JsonProperty("summary")
    private String summary = "";
    @JsonProperty("total_summaries")
    private int totalSummaries = -1;
    @JsonProperty("text")
    private String text = "";
    @JsonProperty("author")
    private String author = "";

    public int getMore() {
        return more;
    }

    public void setMore(int more) {
        this.more = more;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public int getTotalSummaries() {
        return totalSummaries;
    }

    public void setTotalSummaries(int totalSummaries) {
        this.totalSummaries = totalSummaries;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
