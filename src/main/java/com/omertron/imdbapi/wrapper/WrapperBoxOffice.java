package com.omertron.imdbapi.wrapper;

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
@JsonIgnoreProperties({"@meta", "exp", "copyright"})
public class WrapperBoxOffice {

    private static final Logger LOG = LoggerFactory.getLogger(WrapperBoxOffice.class);
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
        LOG.warn(sb.toString());
    }
}
