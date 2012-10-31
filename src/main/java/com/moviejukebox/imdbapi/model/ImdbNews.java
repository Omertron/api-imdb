package com.moviejukebox.imdbapi.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbNews {

    private static final Logger LOGGER = Logger.getLogger(ImdbNews.class);
    @JsonProperty("channel")
    private String channel = "";
    @JsonProperty("total")
    private int total = -1;
    @JsonProperty("sources")
    private Map<String, ImdbSource> source = Collections.EMPTY_MAP;
    @JsonProperty("markup")
    private String markup = "";
    @JsonProperty("label")
    private String label = "";
    @JsonProperty("limit")
    private int limit = -1;
    @JsonProperty("items")
    private List<ImdbItems> items = Collections.EMPTY_LIST;
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

    @Override
    public String toString() {
        return "ImdbNews{" + "channel=" + channel + ", total=" + total + ", source=" + source + ", markup=" + markup + ", label=" + label + ", limit=" + limit + ", items=" + items + ", type=" + type + ", start=" + start + '}';
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
