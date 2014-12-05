package com.omertron.imdbapi.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.omertron.imdbapi.model.ImdbSynopsis;

/**
 * JSON Wrapper class for the response from the API
 *
 * Not intended for use outside of the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties({"@meta", "exp", "copyright", "@type", "db"})
public class WrapperSynopsis  extends AbstractWrapper<ImdbSynopsis> {

    @JsonSetter("data")
    @Override
    public void setResult(ImdbSynopsis result) {
        this.result = result;
    }

    @Override
    public ImdbSynopsis getResult() {
        return getResult(ImdbSynopsis.class);
    }
}
