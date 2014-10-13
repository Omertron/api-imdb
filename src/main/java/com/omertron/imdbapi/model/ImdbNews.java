package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ImdbNews extends AbstractJsonMapping {

    @JsonProperty("channel")
    private String channel = "";
    @JsonProperty("total")
    private int total = -1;
    @JsonProperty("sources")
    private Map<String, ImdbSource> source = Collections.emptyMap();
    @JsonProperty("markup")
    private String markup = "";
    @JsonProperty("label")
    private String label = "";
    @JsonProperty("limit")
    private int limit = -1;
    @JsonProperty("items")
    private List<ImdbItems> items = Collections.emptyList();
    @JsonProperty("@type")
    private String type = "";
    @JsonProperty("start")
    private int start = -1;

    public List<ImdbItems> getItems() {
        return items;
    }

    public void setItems(List<ImdbItems> items) {
        this.items = items;
    }

    public Map<String, ImdbSource> getSource() {
        return source;
    }

    public void setSource(Map<String, ImdbSource> source) {
        this.source = source;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getMarkup() {
        return markup;
    }

    public void setMarkup(String markup) {
        this.markup = markup;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}