package com.omertron.imdbapi.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omertron.imdbapi.model.AbstractJsonMapping;

/**
 * JSON Wrapper class for the response from the API
 *
 * Not intended for use outside of the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties({"@meta", "exp", "copyright", "@type", "db"})
public class WrapperResponse extends AbstractJsonMapping {

    @JsonProperty("data")
    private ResponseDetail response;

    public ResponseDetail getResponse() {
        return response;
    }

    public void setResponse(ResponseDetail response) {
        this.response = response;
    }
}
