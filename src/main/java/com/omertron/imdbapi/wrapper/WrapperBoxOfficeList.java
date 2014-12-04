package com.omertron.imdbapi.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omertron.imdbapi.model.AbstractJsonMapping;
import com.omertron.imdbapi.model.ImdbBoxOffice;
import java.util.Collections;
import java.util.List;

/**
 * JSON Wrapper class for the response from the API
 *
 * Not intended for use outside of the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties({"@meta", "exp", "copyright", "@type", "db"})
public class WrapperBoxOfficeList extends AbstractJsonMapping {

    @JsonProperty("label")
    private String label = "";
    @JsonProperty("list")
    private List<ImdbBoxOffice> boxOffice = Collections.emptyList();

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
}
