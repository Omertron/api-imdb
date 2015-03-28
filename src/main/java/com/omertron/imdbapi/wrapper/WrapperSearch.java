package com.omertron.imdbapi.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omertron.imdbapi.model.AbstractJsonMapping;
import com.omertron.imdbapi.model.ImdbSearchResult;
import com.omertron.imdbapi.search.SearchObject;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JSON Wrapper class for the response from the API
 *
 * Not intended for use outside of the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties({"@meta", "exp", "copyright", "@type", "db"})
public class WrapperSearch extends AbstractJsonMapping {

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
        this.searchResults = new HashMap<>();
        for (ImdbSearchResult result : searchResults) {
            this.searchResults.put(result.getLabel(), result.getSearchObject());
        }
    }
}
