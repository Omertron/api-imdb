package com.omertron.imdbapi.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omertron.imdbapi.model.AbstractJsonMapping;
import com.omertron.imdbapi.model.ImdbPerson;

/**
 * JSON Wrapper class for the response from the API
 *
 * Not intended for use outside of the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties({"@meta", "exp", "copyright", "@type", "db"})
public class WrapperActorData extends AbstractJsonMapping {

    @JsonProperty("data")
    private ImdbPerson actorData;

    public ImdbPerson getActorData() {
        return actorData;
    }

    public void setActorData(ImdbPerson actorData) {
        this.actorData = actorData;
    }
}
