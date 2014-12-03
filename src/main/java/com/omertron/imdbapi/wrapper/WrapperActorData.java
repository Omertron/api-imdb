package com.omertron.imdbapi.wrapper;

import com.omertron.imdbapi.model.ImdbPerson;
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
@JsonIgnoreProperties({"@meta", "exp", "copyright", "@type", "db"})
public class WrapperActorData extends AbstractWrapper {

    @JsonProperty("data")
    private ImdbPerson actorData;

    public ImdbPerson getActorData() {
        return actorData;
    }

    public void setActorData(ImdbPerson actorData) {
        this.actorData = actorData;
    }
}
