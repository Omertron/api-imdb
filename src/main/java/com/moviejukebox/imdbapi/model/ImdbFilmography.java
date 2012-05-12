package com.moviejukebox.imdbapi.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

public class ImdbFilmography {

    private static final Logger LOGGER = Logger.getLogger(ImdbFilmography.class);
    @JsonProperty("label")
    private String label;
    @JsonProperty("token")
    private String token;
    @JsonProperty("list")
    private List<ImdbMovieCharacter> list=new ArrayList<ImdbMovieCharacter>();

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ImdbMovieCharacter> getList() {
        return list;
    }

    public void setList(List<ImdbMovieCharacter> list) {
        this.list = list;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ImdbFilmography{" + "label=" + label + ", token=" + token + ", list=" + list + '}';
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
