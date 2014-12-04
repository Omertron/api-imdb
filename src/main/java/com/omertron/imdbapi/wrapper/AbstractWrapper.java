package com.omertron.imdbapi.wrapper;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omertron.imdbapi.model.ImdbStatusMessage;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractWrapper {

    private static final transient Logger LOG = LoggerFactory.getLogger(AbstractWrapper.class);

    @JsonProperty("error")
    private ImdbStatusMessage error;

    public ImdbStatusMessage getError() {
        return error;
    }

    public void setError(ImdbStatusMessage error) {
        this.error = error;
    }

    /**
     * Handle unknown properties and print a message
     *
     * @param key
     * @param value
     */
    @JsonAnySetter
    protected void handleUnknown(String key, Object value) {
        StringBuilder unknown = new StringBuilder(this.getClass().getSimpleName());
        unknown.append(": Unknown wrapper property='").append(key);
        unknown.append("' value='").append(value).append("'");

        LOG.trace(unknown.toString());
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE, Boolean.FALSE);
    }
}
