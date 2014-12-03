package com.omertron.imdbapi.wrapper;

import com.omertron.imdbapi.model.ImdbBoxOffice;
import java.util.Collections;
import java.util.List;
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
public class WrapperBoxOfficeList extends AbstractWrapper {

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
