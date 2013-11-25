package com.omertron.imdbapi.wrapper;

import com.omertron.imdbapi.model.ImdbList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.LoggerFactory;

public class WrapperList {

    private static final Logger LOG = LoggerFactory.getLogger(WrapperList.class);
    @JsonProperty("label")
    private String label = "";
    @JsonProperty("list")
    private List<ImdbList> imdbList = Collections.EMPTY_LIST;

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
        LOG.warn(sb.toString());
    }
}
