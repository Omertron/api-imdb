package com.omertron.imdbapi.model;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImdbQuoteLine {

    private static final Logger LOG = LoggerFactory.getLogger(ImdbQuoteLine.class);
    @JsonProperty("stage")
    private String stage = "";
    @JsonProperty("quote")
    private String quote = "";
    @JsonProperty("chars")
    private List<ImdbMovieCharacter> chars = Collections.EMPTY_LIST;

    public List<ImdbMovieCharacter> getChars() {
        return chars;
    }

    public void setChars(List<ImdbMovieCharacter> chars) {
        this.chars = chars;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    @Override
    public String toString() {
        return "ImdbQuoteLine{" + "stage=" + stage + ", quote=" + quote + ", chars=" + chars + '}';
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
