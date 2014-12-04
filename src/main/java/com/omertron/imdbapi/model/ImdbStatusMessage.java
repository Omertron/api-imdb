package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbStatusMessage {

    @JsonProperty("status")
    private String status = "";
    @JsonProperty("code")
    private String code = "";
    @JsonProperty("message")
    private String message = "";

    public ImdbStatusMessage() {
    }

    public ImdbStatusMessage(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public ImdbStatusMessage(boolean defaultMessage) {
        if (defaultMessage) {
            this.status = "000";
            this.code = "error";
            this.message = "Unknown error message";
        } else {
            this.status = "";
            this.code = "";
            this.message = "";
        }
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

}
