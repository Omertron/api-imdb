package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;

public class ImdbSeason extends AbstractJsonMapping {

    @JsonProperty("label")
    private String label = "";
    @JsonProperty("token")
    private String token = "";
    @JsonProperty("list")
    private List<ImdbMovie> episodes = Collections.emptyList();

    public List<ImdbMovie> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<ImdbMovie> episodes) {
        this.episodes = episodes;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
