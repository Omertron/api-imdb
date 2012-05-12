package com.moviejukebox.imdbapi.model;

import java.util.Collections;
import java.util.Map;
import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

public class ImdbText {

    private static final Logger LOGGER = Logger.getLogger(ImdbText.class);
    @JsonProperty("text")
    private String text;
    @JsonProperty("label")
    private String label;
    @JsonProperty("date")
    private Map<String,String> date = Collections.EMPTY_MAP;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, String> getDate() {
        return date;
    }

    public void setDate(Map<String, String> date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ImdbText{" + "text=" + text + ", label=" + label + ", date=" + date + '}';
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
