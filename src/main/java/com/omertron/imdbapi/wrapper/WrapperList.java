package com.omertron.imdbapi.wrapper;

import com.omertron.imdbapi.model.ImdbList;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"@meta", "exp", "copyright", "@type", "db"})
public class WrapperList extends AbstractWrapper {

    @JsonProperty("label")
    private String label = "";
    @JsonProperty("list")
    private List<ImdbList> imdbList = Collections.emptyList();

    public List<ImdbList> getImdbList() {
        return imdbList;
    }

    public void setImdbList(List<ImdbList> imdbList) {
        this.imdbList = imdbList;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
