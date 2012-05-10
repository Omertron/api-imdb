package com.omertron.imdbapi.tools;

import com.omertron.imdbapi.model.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;

public class ApiBuilder {

    private static final Logger LOGGER = Logger.getLogger(ApiBuilder.class);
    private static final String LOGMESSAGE = "ImdbApi: ";
    private static final String BASE_URL = "http://app.imdb.com/";
    private static final String API_VERSION = "v1";
    private static final String APP_ID = "iphone1";
    private static final Locale LOCALE = Locale.getDefault();
    private static final String SIG = "app1";
    private static final String APIKEY = "2wex6aeu6a8q9e49k7sfvufd6rhh0n";
    /*
     * Jackson JSON configuration
     */
    private static ObjectMapper mapper = new ObjectMapper();

    private ApiBuilder() {
        throw new UnsupportedOperationException("Class cannot be initialised");
    }

    public static URL buildUrl(String function, Map<String, String> arguments) {
        StringBuilder sbURL = new StringBuilder(BASE_URL);

        sbURL.append(function);
        sbURL.append("?api=").append(API_VERSION);
        sbURL.append("&appid=").append(APP_ID);
        sbURL.append("&locale=").append(LOCALE);
        sbURL.append("&timestamp=").append(System.currentTimeMillis() / 1000);

        for (Map.Entry<String, String> argEntry : arguments.entrySet()) {
            sbURL.append("&").append(argEntry.getKey());
            sbURL.append("=").append(argEntry.getValue());
        }

        sbURL.append("&sig=").append(SIG);

        LOGGER.info(LOGMESSAGE + "URL = " + sbURL.toString());
        try {
            return new URL(sbURL.toString());
        } catch (MalformedURLException ex) {
            return null;
        }
    }

    public static <T> T getWrapper(Class<T> clazz, String function, Map<String, String> args) {
        try {
            String webPage = WebBrowser.request(buildUrl(function, args));
            Object response = mapper.readValue(webPage, clazz);
            return clazz.cast(response);
        } catch (JsonParseException ex) {
            LOGGER.warn(LOGMESSAGE + "JsonParseException: " + ex.getMessage());
        } catch (JsonMappingException ex) {
            LOGGER.warn(LOGMESSAGE + "JsonMappingException: " + ex.getMessage());
        } catch (IOException ex) {
            LOGGER.warn(LOGMESSAGE + "IOException: " + ex.getMessage());
        }
        return null;
    }

    public static Response getResponse(String function, Map<String, String> args) {
        WrapperResponse wr = getWrapper(WrapperResponse.class, function, args);
        if (wr == null) {
            return null;
        } else {
            return wr.getResponse();
        }
    }

    public static Response getResponse(String function) {
        return getResponse(function, Collections.EMPTY_MAP);
    }

    public static WrapperSearch getSearchWrapper(String function, Map<String, String> args) {
        SearchDeserializer deserializer = new SearchDeserializer();
        deserializer.registerSearchObject("tconst", ImdbMovieDetails.class);
        deserializer.registerSearchObject("nconst", ImdbPerson.class);

        SimpleModule module = new SimpleModule("PolymorphicSearchDeserializerModule", new Version(1, 0, 0, null));
        module.addDeserializer(SearchObject.class, deserializer);

        mapper.registerModule(module);

        WrapperSearch wrapper = getWrapper(WrapperSearch.class, function, args);
        return wrapper.getSearchData();
    }
}
