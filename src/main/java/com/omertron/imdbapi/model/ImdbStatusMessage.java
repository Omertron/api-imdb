package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ImdbStatusMessage {

    @JsonProperty("status")
    private String status;
    @JsonProperty("code")
    private String code;
    @JsonProperty("message")
    private String message;
    private Throwable thrownError = null;

    public ImdbStatusMessage() {
        this("", "", "");
    }

    public ImdbStatusMessage(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public ImdbStatusMessage(String message) {
        this.status = "000";
        this.code = "ERROR";
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Throwable getThrownError() {
        return thrownError;
    }

    public void setThrownError(Throwable thrownError) {
        this.thrownError = thrownError;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE, Boolean.FALSE);
    }
}
