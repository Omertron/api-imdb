package com.omertron.imdbapi.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

public class ImdbPerson extends SearchObject {

    private static final Logger LOGGER = Logger.getLogger(ImdbPerson.class);
    @JsonProperty("nconst")
    private String actorId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("bio")
    private String biography;
    @JsonProperty("aka")
    private List<String> aka = new ArrayList<String>();
    @JsonProperty("has")
    private List<String> has = new ArrayList<String>();
    @JsonProperty("birth")
    private ImdbBirth birth;
    @JsonProperty("photos")
    private List<ImdbImage> photos = Collections.EMPTY_LIST;
    private List<ImdbKnownFor> knownFor = Collections.EMPTY_LIST;
    @JsonProperty("attr")
    private String attr;

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public List<ImdbKnownFor> getKnownFor() {
        return knownFor;
    }

    @JsonProperty("known_for")
    public void setKnownFor(Object passedObject) {
        if (passedObject.getClass() == String.class) {
            this.knownFor = new ArrayList<ImdbKnownFor>();
            ImdbKnownFor kf = new ImdbKnownFor();
            ImdbMovie m = new ImdbMovie();
            m.setTitle((String) passedObject);
            kf.setTitle(m);
            this.knownFor.add(kf);
        } else {
            this.knownFor = (List<ImdbKnownFor>) passedObject;
        }
    }

    public List<ImdbImage> getPhotos() {
        return photos;
    }

    public void setPhotos(List<ImdbImage> photos) {
        this.photos = photos;
    }

    public ImdbBirth getBirth() {
        return birth;
    }

    public void setBirth(ImdbBirth birth) {
        this.birth = birth;
    }

    public List<String> getHas() {
        return has;
    }

    public void setHas(List<String> has) {
        this.has = has;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
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
