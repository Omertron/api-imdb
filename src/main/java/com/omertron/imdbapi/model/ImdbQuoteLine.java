package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;

public class ImdbQuoteLine extends AbstractJsonMapping {

    @JsonProperty("stage")
    private String stage = "";
    @JsonProperty("quote")
    private String quote = "";
    @JsonProperty("chars")
    private List<ImdbMovieCharacter> chars = Collections.emptyList();

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

}
