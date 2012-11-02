package com.omertron.imdbapi.model;

import org.apache.log4j.Logger;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbKnownFor {

    private static final Logger LOGGER = Logger.getLogger(ImdbKnownFor.class);
    @JsonProperty("title")
    private ImdbMovie title = new ImdbMovie();
    @JsonProperty("attr")
    private String attribute = "";

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public ImdbMovie getTitle() {
        return title;
    }

    public void setTitle(ImdbMovie title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ImdbKnownFor{" + "title=" + title + ", attribute=" + attribute + '}';
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
