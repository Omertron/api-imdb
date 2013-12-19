package com.omertron.imdbapi.tools;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yamj.api.common.http.CommonHttpClient;

public final class ApiBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(ApiBuilder.class);
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static CommonHttpClient httpClient;
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
        throw new UnsupportedOperationException("Class cannot be initialised");
    }

    public static void setHttpClient(CommonHttpClient httpClient) {
        ApiBuilder.httpClient = httpClient;
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
        sbURL.append("&timestamp=").append(System.currentTimeMillis() / 1000);

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

    public static <T> T getWrapper(Class<T> clazz, String function, Map<String, String> args) {
        try {
            String webPage = httpClient.requestContent(buildUrl(function, args), Charset.forName(DEFAULT_CHARSET));
            Object response = MAPPER.readValue(webPage, clazz);
            return clazz.cast(response);
        } catch (JsonParseException ex) {
            LOG.warn("JsonParseException: {}", ex.getMessage());
        } catch (JsonMappingException ex) {
            LOG.warn("JsonMappingException: {}", ex.getMessage());
        } catch (IOException ex) {
            LOG.warn("IOException: {}", ex.getMessage());
        }
        return null;
    }

    public static ResponseDetail getResponse(String function, Map<String, String> args) {
        WrapperResponse wr = getWrapper(WrapperResponse.class, function, args);
        if (wr == null) {
            return null;
        } else {
            return wr.getResponse();
        }
    }

    public static ResponseDetail getResponse(String function) {
        return getResponse(function, Collections.EMPTY_MAP);
    }

    public static WrapperSearch getSearchWrapper(String function, Map<String, String> args) {
        WrapperSearch wrapper = getWrapper(WrapperSearch.class, function, args);

        if (wrapper == null) {
            return null;
        }

        return wrapper.getSearchData();
    }
}
