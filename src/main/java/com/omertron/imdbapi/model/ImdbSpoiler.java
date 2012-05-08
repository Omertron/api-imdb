package com.omertron.imdbapi.model;

import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

public class ImdbSpoiler {

    private static final Logger LOGGER = Logger.getLogger(ImdbSpoiler.class);
    private String spoiler;
    @JsonProperty("text")
    private String text;
    @JsonProperty("type")
    private String type;

    public ImdbSpoiler() {
    }

    public ImdbSpoiler(String spoiler, String text, String type) {
        this.spoiler = spoiler;
        this.text = text;
        this.type = type;
    }

    public String getSpoiler() {
        return spoiler;
    }

    public void setSpoiler(String spoiler) {
        this.spoiler = spoiler;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ImdbSpoiler{" + "spoiler=" + spoiler + ", text=" + text + ", type=" + type + '}';
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
