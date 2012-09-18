package com.moviejukebox.imdbapi.wrapper;

import com.moviejukebox.imdbapi.model.ImdbChartStarmeter;
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
@JsonIgnoreProperties({"@meta","exp","copyright"})
public class WrapperChartStarmeter {

    private static final Logger LOGGER = Logger.getLogger(WrapperChartStarmeter.class);
    @JsonProperty("data")
    private WrapperChartStarmeter data;
    @JsonProperty("list")
    private List<ImdbChartStarmeter> chartStarmeter = Collections.EMPTY_LIST;

    public WrapperChartStarmeter getData() {
        return data;
    }

    public void setData(WrapperChartStarmeter data) {
        this.data = data;
    }

    public List<ImdbChartStarmeter> getChartStarmeter() {
        return chartStarmeter;
    }

    public void setChartStarmeter(List<ImdbChartStarmeter> chartStarmeter) {
        this.chartStarmeter = chartStarmeter;
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
