package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class to handle any unknown properties by outputting a log message
 *
 * @author stuart.boston
 */
public abstract class AbstractJsonMapping implements Serializable {

    private static final transient Logger LOG = LoggerFactory.getLogger(AbstractJsonMapping.class);

    @JsonProperty("error")
    private ImdbStatusMessage statusMessage = null;
    private boolean error = Boolean.FALSE;

    public ImdbStatusMessage getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(ImdbStatusMessage statusMessage) {
        this.statusMessage = statusMessage;
        // Set the error flag
        this.error = Boolean.TRUE;
    }

    public boolean isError() {
        return error;
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
        unknown.append(": Unknown property='").append(key);
        unknown.append("' value='").append(value).append("'");

        LOG.trace(unknown.toString());
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE, Boolean.FALSE);
    }
}
