package com.omertron.imdbapi.wrapper;

import com.omertron.imdbapi.model.ImdbChartMoviemeter;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * JSON Wrapper class for the response from the API
 *
 * Not intended for use outside of the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties({"@meta", "exp", "copyright", "@type", "db"})
public class WrapperChartMoviemeter extends AbstractWrapper {

    @JsonProperty("data")
    private WrapperChartMoviemeter data;
    @JsonProperty("list")
    private List<ImdbChartMoviemeter> chartMoviemeter = Collections.emptyList();

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
}
