package com.omertron.imdbapi.tools;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.omertron.imdbapi.ImdbException;
import com.omertron.imdbapi.model.AbstractJsonMapping;
import com.omertron.imdbapi.model.ImdbMovieDetails;
import com.omertron.imdbapi.model.ImdbPerson;
import com.omertron.imdbapi.search.SearchDeserializer;
import com.omertron.imdbapi.search.SearchObject;
import com.omertron.imdbapi.wrapper.ResponseDetail;
import com.omertron.imdbapi.wrapper.WrapperResponse;
import com.omertron.imdbapi.wrapper.WrapperSearch;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yamj.api.common.exception.ApiExceptionType;

public final class ApiBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(ApiBuilder.class);
    private static final int MILLIS_PER_SECOND = 1000;
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final Charset CHARSET = Charset.forName(DEFAULT_CHARSET);
    private static HttpTools httpTools;
    private static final String BASE_URL = "http://app.imdb.com/";
    private static final String API_VERSION = "v1";
    private static final String APP_ID = "iphone1";
    private static final String SIG = "app1";
    private static Locale imdbLocale = Locale.getDefault();
    /*
     * Jackson JSON configuration
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        SearchDeserializer deserializer = new SearchDeserializer();
        deserializer.registerSearchObject("tconst", ImdbMovieDetails.class);
        deserializer.registerSearchObject("nconst", ImdbPerson.class);

        Version ver = new Version(1, 0, 0, null, "com.omertron.imdbapi.tools", "SearchDeserializer");
        SimpleModule module = new SimpleModule("PolymorphicSearchDeserializerModule", ver);
        module.addDeserializer(SearchObject.class, deserializer);

        MAPPER.registerModule(module);
    }

    private ApiBuilder() {
        throw new UnsupportedOperationException("Class cannot be instantiate");
    }

    public static void setHttpClient(HttpClient httpClient) {
        ApiBuilder.httpTools = new HttpTools(httpClient);
    }

    public static void setLocale(Locale locale) {
        ApiBuilder.imdbLocale = locale;
        LOG.trace("Setting locale to {}", imdbLocale.toString());
    }

    public static URL buildUrl(String function, Map<String, String> arguments) {
        StringBuilder sbURL = new StringBuilder(BASE_URL);

        sbURL.append(function);
        sbURL.append("?api=").append(API_VERSION);
        sbURL.append("&appid=").append(APP_ID);
        sbURL.append("&locale=").append(imdbLocale);
        sbURL.append("&timestamp=").append(System.currentTimeMillis() / MILLIS_PER_SECOND);

        for (Map.Entry<String, String> argEntry : arguments.entrySet()) {
            sbURL.append("&").append(argEntry.getKey());
            sbURL.append("=").append(argEntry.getValue());
        }

        sbURL.append("&sig=").append(SIG);

        LOG.trace("URL = {}", sbURL.toString());
        try {
            return new URL(sbURL.toString());
        } catch (MalformedURLException ex) {
            LOG.trace("Failed to convert string to URL: {}", ex.getMessage());
            return null;
        }
    }

    public static <T extends AbstractJsonMapping> T getWrapper(Class<T> clazz, String function, Map<String, String> args) throws ImdbException {
        T result;
        URL url = buildUrl(function, args);

        // Make sure we have a "blank" object to return
        try {
            result = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new ImdbException(ApiExceptionType.CONNECTION_ERROR, "Failed to instantiate class " + clazz.getSimpleName(), url, ex);
        }

        try {
            String webPage = httpTools.getRequest(url);
            Object response = MAPPER.readValue(webPage, clazz);
            result = clazz.cast(response);
        } catch (JsonParseException ex) {
            throw new ImdbException(ApiExceptionType.MAPPING_FAILED, "JsonParseException", url, ex);
        } catch (JsonMappingException ex) {
            throw new ImdbException(ApiExceptionType.MAPPING_FAILED, "JsonMappingException", url, ex);
        } catch (IOException ex) {
            throw new ImdbException(ApiExceptionType.CONNECTION_ERROR, "IOException", url, ex);
        }

        return result;
    }

    public static ResponseDetail getResponse(String function, Map<String, String> args) throws ImdbException {
        WrapperResponse wr = getWrapper(WrapperResponse.class, function, args);
        return wr.getResult();
    }

    public static ResponseDetail getResponse(String function) throws ImdbException {
        return getResponse(function, Collections.<String, String>emptyMap());
    }

    public static WrapperSearch getSearchWrapper(String function, Map<String, String> args) throws ImdbException {
        WrapperSearch wrapper = getWrapper(WrapperSearch.class, function, args);

        if (wrapper == null) {
            return null;
        }

        return wrapper.getSearchData();
    }

}
