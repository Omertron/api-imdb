package com.omertron.imdbapi.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.omertron.imdbapi.model.ImdbQuotes;

/**
 * JSON Wrapper class for the response from the API
 *
 * Not intended for use outside of the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties({"@meta", "exp", "copyright", "@type", "db"})
public class WrapperQuotes  extends AbstractWrapper<ImdbQuotes> {

    @JsonSetter("data")
    @Override
    public void setResult(ImdbQuotes result) {
        this.result = result;
    }

    @Override
    public ImdbQuotes getResult() {
        return getResult(ImdbQuotes.class);
    }
}
