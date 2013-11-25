package com.omertron.imdbapi.model;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImdbQuote {

    private static final Logger LOG = LoggerFactory.getLogger(ImdbQuote.class);
    @JsonProperty("qconst")
    private String quoteId = "";
    @JsonProperty("lines")
    private List<ImdbQuoteLine> lines = Collections.EMPTY_LIST;

    public List<ImdbQuoteLine> getLines() {
        return lines;
    }

    public void setLines(List<ImdbQuoteLine> lines) {
        this.lines = lines;
    }

    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    @Override
    public String toString() {
        return "ImdbQuote{" + "quoteId=" + quoteId + ", lines=" + lines + '}';
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
        LOG.trace(sb.toString());
    }
}
