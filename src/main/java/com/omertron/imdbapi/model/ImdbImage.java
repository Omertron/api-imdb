package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"@meta", "exp", "copyright"})
public class ImdbImage extends AbstractJsonMapping {

    @JsonProperty("created")
    private String created = "";
    @JsonProperty("caption")
    private String caption = "";
    @JsonProperty("link")
    private String link = "";
    @JsonProperty("image")
    private ImdbImageDetails image = new ImdbImageDetails();
    @JsonProperty("by")
    private String by = "";
    @JsonProperty("source")
    private String source = "";

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public ImdbImageDetails getImage() {
        return image;
    }

    public void setImage(ImdbImageDetails image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}