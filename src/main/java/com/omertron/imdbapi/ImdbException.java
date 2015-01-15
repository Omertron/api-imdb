package com.omertron.imdbapi;

import java.net.URL;

public class ImdbException extends Exception {

    private static final long serialVersionUID = 1L;

    public enum ImdbExceptionType {
        /*
         * Unknown error occured
         */
        UNKNOWN_CAUSE,
        /*
         * URL is invalid
         */
        INVALID_URL,
        /*
         * The ID was not found
         */
        ID_NOT_FOUND,
        /*
         * Mapping failed from target to internal onbjects
         */
        MAPPING_FAILED,
        /*
         * Error connecting to the service
         */
        CONNECTION_ERROR,
        /*
         * Autorisation rejected
         */
        AUTHORISATION_FAILURE,
        /*
         * Page not found
         */
        HTTP_404_ERROR,
        /*
         * Service Unavailable, usually temporary
         */
        HTTP_503_ERROR;
    }

    private final ImdbExceptionType exceptionType;
    private final String response;
    private final String url;

    public ImdbException(final ImdbExceptionType exceptionType, final String response, final String url) {
        super();
        this.exceptionType = exceptionType;
        this.response = response;
        this.url = url;
    }

    public ImdbException(final ImdbExceptionType exceptionType, final String response, final URL url) {
      super();
      this.exceptionType = exceptionType;
      this.response = response;
      this.url = url.toExternalForm();
  }

    public ImdbException(final ImdbExceptionType exceptionType, final String response, final String url, final Throwable cause) {
        super(cause);
        this.exceptionType = exceptionType;
        this.response = response;
        this.url = url;
    }

    public ImdbException(final ImdbExceptionType exceptionType, final String response, final URL url, final Throwable cause) {
      super(cause);
      this.exceptionType = exceptionType;
      this.response = response;
      this.url = url.toExternalForm();
  }

    public ImdbExceptionType getExceptionType() {
        return exceptionType;
    }

    public String getResponse() {
        return response;
    }

    public String getUrl(){
      return url;
    }
}
