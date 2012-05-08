package com.omertron.imdbapi.model;

import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

public class ImdbSeason {

    private static final Logger LOGGER = Logger.getLogger(ImdbSeason.class);
    @JsonProperty("label")
    private String label;
    @JsonProperty("token")
    private String token;
    @JsonProperty("list")
    private List<ImdbMovie> episodes = Collections.EMPTY_LIST;

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
