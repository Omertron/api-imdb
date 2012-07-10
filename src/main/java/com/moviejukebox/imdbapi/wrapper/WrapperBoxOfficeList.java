package com.moviejukebox.imdbapi.wrapper;

import com.moviejukebox.imdbapi.model.ImdbBoxOffice;
import java.util.Collections;
import java.util.List;
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
//@JsonIgnoreProperties({"@meta", "exp", "copyright"})
public class WrapperBoxOfficeList {

    private static final Logger LOGGER = Logger.getLogger(WrapperBoxOfficeList.class);
    @JsonProperty("label")
    private String label;
    @JsonProperty("list")
    private List<ImdbBoxOffice> boxOffice;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ImdbBoxOffice> getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(List<ImdbBoxOffice> boxOffice) {
        this.boxOffice = boxOffice;
    }

    @Override
    public String toString() {
        return "WrapperBoxOfficeList{" + "label=" + label + ", boxOffice=" + boxOffice + '}';
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
