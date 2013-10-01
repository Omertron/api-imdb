package com.omertron.imdbapi.model;

import org.apache.log4j.Logger;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbPlot {

    private static final Logger LOGGER = Logger.getLogger(ImdbPlot.class);
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

    @Override
    public String toString() {
        return "ImdbPlot{" + "outline=" + outline + ", more=" + more + ", summary=" + summary + ", totalSummaries=" + totalSummaries + ", text=" + text + ", author=" + author + '}';
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
