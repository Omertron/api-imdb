package com.omertron.imdbapi.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * JSON Wrapper class for the response from the API
 *
 * Not intended for use outside of the API
 *
 * @author stuart.boston
 */
@JsonIgnoreProperties({"@meta", "exp", "copyright", "@type", "db"})
public class WrapperResponse  extends AbstractWrapper<ResponseDetail> {

    @JsonSetter("data")
    @Override
    public void setResult(ResponseDetail result) {
        this.result = result;
    }

    @Override
    public ResponseDetail getResult() {
        return getResult(ResponseDetail.class);
    }
}
