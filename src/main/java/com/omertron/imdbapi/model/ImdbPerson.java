package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.omertron.imdbapi.search.SearchObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImdbPerson extends SearchObject {

    @JsonProperty("nconst")
    private String actorId = "";
    @JsonProperty("name")
    private String name = "";
    @JsonProperty("bio")
    private String biography = "";
    @JsonProperty("aka")
    private List<String> aka = Collections.emptyList();
    @JsonProperty("has")
    private List<String> has = Collections.emptyList();
    @JsonProperty("birth")
    private ImdbError birth = new ImdbError();
    @JsonProperty("photos")
    private List<ImdbImage> photos = Collections.emptyList();
    private List<ImdbKnownFor> knownFor = Collections.emptyList();
    @JsonProperty("attr")
    private String attr = "";
    @JsonProperty("news")
    private ImdbNews news = new ImdbNews();

    public ImdbNews getNews() {
        return news;
    }

    public void setNews(ImdbNews news) {
        this.news = news;
    }

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
            this.knownFor = new ArrayList<>();
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

    public ImdbError getBirth() {
        return birth;
    }

    public void setBirth(ImdbError birth) {
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

}
