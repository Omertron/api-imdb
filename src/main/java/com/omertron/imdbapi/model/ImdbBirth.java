package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.Map;

public class ImdbBirth extends AbstractJsonMapping {

    @JsonProperty("date")
    private Map<String, String> date = Collections.emptyMap();
    @JsonProperty("place")
    private String place = "";

    public Map<String, String> getDate() {
        return date;
    }

    public void setDate(Map<String, String> date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

}
