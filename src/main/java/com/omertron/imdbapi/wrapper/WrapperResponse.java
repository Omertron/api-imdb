package com.omertron.imdbapi.wrapper;

import org.slf4j.Logger;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.LoggerFactory;

/**
 * JSON Wrapper class for the response from the API
 *
 * Not intended for use outside of the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties({"@meta","exp","copyright"})
public class WrapperResponse {

    private static final Logger LOG = LoggerFactory.getLogger(WrapperResponse.class);
    @JsonProperty("data")
    private ResponseDetail response;

    public ResponseDetail getResponse() {
        return response;
    }

    public void setResponse(ResponseDetail response) {
        this.response = response;
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
