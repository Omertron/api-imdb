package com.moviejukebox.imdbapi.model;

import org.apache.log4j.Logger;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbMovieCharacter {

    private static final Logger LOGGER = Logger.getLogger(ImdbMovieCharacter.class);
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

    @Override
    public String toString() {
        return "ImdbMovieCharacter{" + "character=" + character + ", title=" + title + ", attribute=" + attribute + ", actorId=" + actorId + '}';
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
