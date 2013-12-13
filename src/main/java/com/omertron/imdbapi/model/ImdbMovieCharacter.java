package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbMovieCharacter extends AbstractJsonMapping {

    @JsonProperty("char")
    private String character = "";
    @JsonProperty("title")
    private ImdbMovie title = new ImdbMovie();
    @JsonProperty("attr")
    private String attribute = "";
    @JsonProperty("nconst")
    private String actorId = "";

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public ImdbMovie getTitle() {
        return title;
    }

    public void setTitle(ImdbMovie title) {
        this.title = title;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}