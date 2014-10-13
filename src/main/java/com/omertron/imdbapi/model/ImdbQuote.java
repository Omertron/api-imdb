package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;

public class ImdbQuote extends AbstractJsonMapping {

    @JsonProperty("qconst")
    private String quoteId = "";
    @JsonProperty("lines")
    private List<ImdbQuoteLine> lines = Collections.emptyList();

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

}
