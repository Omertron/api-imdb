package com.moviejukebox.imdbapi.wrapper;

import com.moviejukebox.imdbapi.model.ImdbChartMoviemeter;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * JSON Wrapper class for the response from the API
 *
 * Not intended for use outside of the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties({"@meta", "exp", "copyright"})
public class WrapperChartMoviemeter {

    private static final Logger LOGGER = Logger.getLogger(WrapperChartMoviemeter.class);
    @JsonProperty("data")
    private WrapperChartMoviemeter data;
    @JsonProperty("list")
    private List<ImdbChartMoviemeter> chartMoviemeter = Collections.EMPTY_LIST;

    public WrapperChartMoviemeter getData() {
        return data;
    }

    public void setData(WrapperChartMoviemeter data) {
        this.data = data;
    }

    public List<ImdbChartMoviemeter> getChartMoviemeter() {
        return chartMoviemeter;
    }

    public void setChartMoviemeter(List<ImdbChartMoviemeter> chartMoviemeter) {
        this.chartMoviemeter = chartMoviemeter;
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
