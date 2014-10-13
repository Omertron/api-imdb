package com.omertron.imdbapi.wrapper;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omertron.imdbapi.model.ImdbSearchResult;
import com.omertron.imdbapi.search.SearchObject;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JSON Wrapper class for the response from the API
 *
 * Not intended for use outside of the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties({"@meta", "exp", "copyright", "@type"})
public class WrapperSearch {

    private static final Logger LOG = LoggerFactory.getLogger(WrapperSearch.class);
    @JsonProperty("data")
    private WrapperSearch searchData;
    // Self referenced fields from "data"
    @JsonProperty("q")
    private String query;
    @JsonProperty("fields")
    private List<String> fields = Collections.emptyList();
    private Map<String, List<SearchObject>> searchResults;

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public WrapperSearch getSearchData() {
        return searchData;
    }

    public void setSearchData(WrapperSearch searchData) {
        this.searchData = searchData;
    }

    public Map<String, List<SearchObject>> getSearchResults() {
        return searchResults;
    }

    @JsonProperty("results")
    public void setSearchResults(List<ImdbSearchResult> searchResults) {
        this.searchResults = new HashMap<String, List<SearchObject>>();
        for (ImdbSearchResult result : searchResults) {
            this.searchResults.put(result.getLabel(), result.getSearchObject());
        }
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
