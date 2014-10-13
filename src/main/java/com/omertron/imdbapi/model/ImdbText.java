package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.Map;

public class ImdbText extends AbstractJsonMapping {

    @JsonProperty("text")
    private String text = "";
    @JsonProperty("label")
    private String label = "";
    @JsonProperty("date")
    private Map<String, String> date = Collections.emptyMap();

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

}
