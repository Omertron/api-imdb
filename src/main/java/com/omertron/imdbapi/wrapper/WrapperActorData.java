package com.omertron.imdbapi.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.omertron.imdbapi.model.ImdbPerson;

/**
 * JSON Wrapper class for the response from the API
 *
 * Not intended for use outside of the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties({"@meta", "exp", "copyright", "@type", "db"})
public class WrapperActorData extends AbstractWrapper<ImdbPerson> {

    @JsonSetter("data")
    @Override
    public void setResult(ImdbPerson result) {
        this.result = result;
    }

    @Override
    public ImdbPerson getResult() {
        return getResult(ImdbPerson.class);
    }
}
