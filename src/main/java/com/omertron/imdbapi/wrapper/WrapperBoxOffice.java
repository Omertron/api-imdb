package com.omertron.imdbapi.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omertron.imdbapi.model.AbstractJsonMapping;

/**
 * JSON Wrapper class for the response from the API
 *
 * Not intended for use outside of the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties({"@meta", "exp", "copyright", "@type", "db"})
public class WrapperBoxOffice extends AbstractJsonMapping {

    // Root element
    @JsonProperty("data")
    private WrapperBoxOffice data;
    // Elements under the root
    @JsonProperty("date")
    private String date = "";
    @JsonProperty("list")
    private WrapperBoxOfficeList boxOfficeList;

    public WrapperBoxOffice getData() {
        return data;
    }

    public void setData(WrapperBoxOffice data) {
        this.data = data;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public WrapperBoxOfficeList getBoxOfficeList() {
        return boxOfficeList;
    }

    public void setBoxOfficeList(WrapperBoxOfficeList boxOfficeList) {
        this.boxOfficeList = boxOfficeList;
    }

    @Override
    public String toString() {
        return "WrapperBoxOffice{" + "data=" + data + ", date=" + date + ", boxOfficeList=" + boxOfficeList + '}';
    }
}
