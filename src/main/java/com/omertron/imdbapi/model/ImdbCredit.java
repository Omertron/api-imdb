package com.omertron.imdbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;

public class ImdbCredit extends AbstractJsonMapping{

    @JsonProperty("label")
    private String label = "";
    @JsonProperty("token")
    private String token = "";
    @JsonProperty("list")
    private List<ImdbCast> credits = Collections.emptyList();

    public List<ImdbCast> getCredits() {
        return credits;
    }

    public void setCredits(List<ImdbCast> credits) {
        this.credits = credits;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
