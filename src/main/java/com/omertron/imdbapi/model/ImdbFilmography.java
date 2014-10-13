package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;

public class ImdbFilmography extends AbstractJsonMapping {

    @JsonProperty("label")
    private String label = "";
    @JsonProperty("token")
    private String token = "";
    @JsonProperty("list")
    private List<ImdbMovieCharacter> list = Collections.emptyList();

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

}