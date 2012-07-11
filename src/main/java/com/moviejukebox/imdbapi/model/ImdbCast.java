/*
 *      Copyright (c) 2004-2012 YAMJ Members
 *      http://code.google.com/p/moviejukebox/people/list
 *
 *      Web: http://code.google.com/p/moviejukebox/
 *
 *      This software is licensed under a Creative Commons License
 *      See this page: http://code.google.com/p/moviejukebox/wiki/License
 *
 *      For any reuse or distribution, you must make clear to others the
 *      license terms of this work.
 */
package com.moviejukebox.imdbapi.model;

import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * JSON Wrapper class for the response from the API
 *
 * Not intended for use outside of the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties("rewrite")
public class ImdbCast {

    private static final Logger LOGGER = Logger.getLogger(ImdbCast.class);
    @JsonProperty("name")
    private ImdbPerson person = new ImdbPerson();
    @JsonProperty("attr")
    private String attr = "";
    @JsonProperty("char")
    private String character = "";
    @JsonProperty("job")
    private String job = "";
    @JsonProperty("as")
    private String roleAs = "";
    @JsonProperty("label")
    private String label = "";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRoleAs() {
        return roleAs;
    }

    public void setRoleAs(String roleAs) {
        this.roleAs = roleAs;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public ImdbPerson getPerson() {
        return person;
    }

    public void setPerson(ImdbPerson person) {
        this.person = person;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    @Override
    public String toString() {
        return "ImdbCast{" + "person=" + person + ", attr=" + attr + ", character=" + character + ", job=" + job + ", roleAs=" + roleAs + ", label=" + label + '}';
    }

    /**
     * Handle unknown properties and print a message
     *
     * @param key
     * @param value
     */
    @JsonAnySetter
    public void handleUnknown(String key, Object value) {
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown property: '").append(key);
        sb.append("' value: '").append(value).append("'");
        LOGGER.warn(sb.toString());
    }
}
