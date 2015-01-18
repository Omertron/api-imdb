package com.omertron.imdbapi;

import java.net.URL;
import org.yamj.api.common.exception.ApiException;
import org.yamj.api.common.exception.ApiExceptionType;

public class ImdbException extends ApiException {

    public ImdbException(ApiExceptionType exceptionType, String response) {
        super(exceptionType, response);
    }

    public ImdbException(ApiExceptionType exceptionType, String response, URL url) {
        super(exceptionType, response, url);
    }

    public ImdbException(ApiExceptionType exceptionType, String response, int responseCode, URL url) {
        super(exceptionType, response, responseCode, url);
    }

    public ImdbException(ApiExceptionType exceptionType, String response, String url) {
        super(exceptionType, response, url);
    }

    public ImdbException(ApiExceptionType exceptionType, String response, int responseCode, String url) {
        super(exceptionType, response, responseCode, url);
    }

    public ImdbException(ApiExceptionType exceptionType, String response, URL url, Throwable cause) {
        super(exceptionType, response, url, cause);
    }

    public ImdbException(ApiExceptionType exceptionType, String response, int responseCode, URL url, Throwable cause) {
        super(exceptionType, response, responseCode, url, cause);
    }

    public ImdbException(ApiExceptionType exceptionType, String response, String url, Throwable cause) {
        super(exceptionType, response, url, cause);
    }

    public ImdbException(ApiExceptionType exceptionType, String response, int responseCode, String url, Throwable cause) {
        super(exceptionType, response, responseCode, url, cause);
    }
}
