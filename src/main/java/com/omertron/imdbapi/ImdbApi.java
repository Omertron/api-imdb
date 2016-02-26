package com.omertron.imdbapi;

import com.omertron.imdbapi.model.ImdbBoxOffice;
import com.omertron.imdbapi.model.ImdbChartMoviemeter;
import com.omertron.imdbapi.model.ImdbChartStarmeter;
import com.omertron.imdbapi.model.ImdbCredit;
import com.omertron.imdbapi.model.ImdbFilmography;
import com.omertron.imdbapi.model.ImdbImage;
import com.omertron.imdbapi.model.ImdbList;
import com.omertron.imdbapi.model.ImdbMovieDetails;
import com.omertron.imdbapi.model.ImdbPerson;
import com.omertron.imdbapi.model.ImdbPlot;
import com.omertron.imdbapi.model.ImdbQuotes;
import com.omertron.imdbapi.model.ImdbReview;
import com.omertron.imdbapi.model.ImdbSeason;
import com.omertron.imdbapi.model.ImdbSpoiler;
import com.omertron.imdbapi.model.ImdbSynopsis;
import com.omertron.imdbapi.model.ImdbText;
import com.omertron.imdbapi.model.ImdbUserComment;
import com.omertron.imdbapi.search.SearchObject;
import com.omertron.imdbapi.tools.ApiBuilder;
import com.omertron.imdbapi.wrapper.ResponseDetail;
import com.omertron.imdbapi.wrapper.WrapperActorData;
import com.omertron.imdbapi.wrapper.WrapperBoxOffice;
import com.omertron.imdbapi.wrapper.WrapperChartMoviemeter;
import com.omertron.imdbapi.wrapper.WrapperChartStarmeter;
import com.omertron.imdbapi.wrapper.WrapperMovieDetails;
import com.omertron.imdbapi.wrapper.WrapperQuotes;
import com.omertron.imdbapi.wrapper.WrapperSearch;
import com.omertron.imdbapi.wrapper.WrapperSynopsis;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yamj.api.common.http.SimpleHttpClientBuilder;

/**
 * Java API class for the IMDB JSON API
 *
 * @author stuart.boston
 */
public final class ImdbApi {

    private static final Logger LOG = LoggerFactory.getLogger(ImdbApi.class);
    private static final String TCONST = "tconst";
    private static final String NCONST = "nconst";
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    /*
     * Outstanding methods to implement
     * TODO: tv/tonight
     * TODO: tv/recap
     * TODO: chart/starmeter
     * TODO: feature/borntoday
     */
    public ImdbApi() {
        this(new SimpleHttpClientBuilder().build());
    }

    public ImdbApi(HttpClient httpClient) {
        ApiBuilder.setHttpClient(httpClient);
    }

    /**
     * Set the locale using a pre-constructed java locale object
     *
     * @param locale
     */
    public void setLocale(Locale locale) {
        ApiBuilder.setLocale(locale);
    }

    /**
     * Set the locale using the language only.
     *
     * This will default to the source country for that language.
     *
     * @param language
     */
    public void setLocale(String language) {
        setLocale(new Locale(language));
    }

    /**
     * Set the locale using the language an country.
     *
     * @param language
     * @param country
     */
    public void setLocale(String language, String country) {
        setLocale(new Locale(language, country));
    }

    /**
     * Get the show times for a particular location
     *
     * @param location
     * @param date
     * @return
     */
    public URL getShowtimes(String location, Date date) {
        Map<String, String> args = new HashMap<>();
        args.put("location", location);

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        args.put("date", sdf.format(date));
        return ApiBuilder.buildUrl("showtimes/location", args);
    }

    /**
     * Get the parental guide information for a title
     *
     * @param imdbId
     * @return
     */
    public List<ImdbText> getParentalGuide(String imdbId) {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);

        ResponseDetail response = ApiBuilder.getResponse("title/parentalguide", args);
        if (response == null) {
            return Collections.emptyList();
        } else {
            return response.getParentalGuide();
        }
    }

    /**
     * Get the user reviews for a title
     *
     * @param imdbId
     * @return
     */
    public List<ImdbUserComment> getUserReviews(String imdbId) {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);

        ResponseDetail response = ApiBuilder.getResponse("title/usercomments", args);
        if (response == null) {
            return Collections.emptyList();
        } else {
            return response.getUserComments();
        }
    }

    /**
     * Get the external reviews for a title
     *
     * @param imdbId
     * @return
     */
    public List<ImdbReview> getExternalReviews(String imdbId) {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);

        ResponseDetail response = ApiBuilder.getResponse("title/external_reviews", args);
        if (response == null) {
            return Collections.emptyList();
        } else {
            return response.getExternalReviews();
        }
    }

    /**
     * Get the list of coming soon titles
     *
     * @return
     */
    public List<ImdbList> getComingSoon() {
        ResponseDetail response = ApiBuilder.getResponse("feature/comingsoon");
        if (response == null) {
            return Collections.emptyList();
        } else {
            return response.getList().getImdbList();
        }
    }

    /**
     * Get the Top250 list
     *
     * @return
     */
    public List<ImdbList> getTop250() {
        ResponseDetail response = ApiBuilder.getResponse("chart/top");
        if (response == null) {
            return Collections.emptyList();
        } else {
            return response.getList().getImdbList();
        }
    }

    /**
     * Get the Bottom 100 list
     *
     * @return
     */
    public List<ImdbList> getBottom100() {
        ResponseDetail response = ApiBuilder.getResponse("chart/bottom");
        if (response == null) {
            return Collections.emptyList();
        } else {
            return response.getList().getImdbList();
        }
    }

    /**
     * Get the quotes for an actor
     *
     * @param actorId
     * @return
     */
    public List<String> getActorQuotes(String actorId) {
        Map<String, String> args = new HashMap<>();
        args.put(NCONST, actorId);
        ResponseDetail response = ApiBuilder.getResponse("name/quotes", args);
        if (response == null) {
            return Collections.emptyList();
        } else {
            return response.getQuotes();
        }
    }

    /**
     * Get the trivia for an actor
     *
     * @param actorId
     * @return
     */
    public List<ImdbText> getActorTrivia(String actorId) {
        Map<String, String> args = new HashMap<>();
        args.put(NCONST, actorId);
        ResponseDetail response = ApiBuilder.getResponse("name/trivia", args);
        if (response == null) {
            return Collections.emptyList();
        } else {
            return response.getTrivia();
        }
    }

    /**
     * Get the actor's filmography
     *
     * @param actorId
     * @return
     */
    public List<ImdbFilmography> getActorFilmography(String actorId) {
        Map<String, String> args = new HashMap<>();
        args.put(NCONST, actorId);
        ResponseDetail response = ApiBuilder.getResponse("name/filmography", args);
        if (response == null) {
            return Collections.emptyList();
        } else {
            return response.getFilmography();
        }
    }

    /**
     * Get the main details about the actor
     *
     * @param actorId
     * @return
     */
    public ImdbPerson getActorDetails(String actorId) {
        Map<String, String> args = new HashMap<>();
        args.put(NCONST, actorId);

        WrapperActorData wrapper = ApiBuilder.getWrapper(WrapperActorData.class, "name/maindetails", args);
        return wrapper.getResult();
    }

    /**
     * Get the episodes for a show
     *
     * @param imdbId
     * @return
     */
    public List<ImdbSeason> getTitleEpisodes(String imdbId) {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);
        ResponseDetail response = ApiBuilder.getResponse("title/episodes", args);
        if (response == null) {
            return Collections.emptyList();
        } else {
            return response.getSeasons();
        }
    }

    /**
     * Get the quotes for a title
     *
     * @param imdbId
     * @return
     */
    public ImdbQuotes getTitleQuotes(String imdbId) {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);

        WrapperQuotes wrapper = ApiBuilder.getWrapper(WrapperQuotes.class, "title/quotes", args);
        return wrapper.getResult();
    }

    /**
     * Get the goofs for a title
     *
     * @param imdbId
     * @return
     */
    public List<ImdbSpoiler> getTitleGoofs(String imdbId) {
        return getTitleSpoilers(imdbId, "title/goofs");
    }

    /**
     * Get the trivia for a title
     *
     * @param imdbId
     * @return
     */
    public List<ImdbSpoiler> getTitleTrivia(String imdbId) {
        return getTitleSpoilers(imdbId, "title/trivia");
    }

    /**
     * Get a list of "spoilers" for a title
     *
     * @param imdbId
     * @param requestType
     * @return
     */
    private List<ImdbSpoiler> getTitleSpoilers(String imdbId, String requestType) {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);
        ResponseDetail response = ApiBuilder.getResponse(requestType, args);
        if (response == null) {
            return Collections.emptyList();
        } else {
            List<ImdbSpoiler> spoilers = new ArrayList<>();

            for (ImdbSpoiler spoiler : response.getSpoilt()) {
                spoiler.setSpoiler("spoilt");
                spoilers.add(spoiler);
            }

            for (ImdbSpoiler spoiler : response.getUnspoilt()) {
                spoiler.setSpoiler("unspoilt");
                spoilers.add(spoiler);
            }

            return spoilers;
        }

    }

    /**
     * Get the photos for a title
     *
     * @param imdbId
     * @return
     */
    public List<ImdbImage> getTitlePhotos(String imdbId) {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);
        ResponseDetail response = ApiBuilder.getResponse("title/photos", args);
        if (response == null) {
            return Collections.emptyList();
        } else {
            return response.getPhotos();
        }
    }

    /**
     * Get the main details for a title
     *
     * @param imdbId
     * @return
     */
    public ImdbMovieDetails getFullDetails(String imdbId) {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);
        WrapperMovieDetails wrapper = ApiBuilder.getWrapper(WrapperMovieDetails.class, "title/maindetails", args);
        return wrapper.getResult();
    }

    /**
     * Get the cast for a title
     *
     * @param imdbId
     * @return
     */
    public List<ImdbCredit> getFullCast(String imdbId) {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);

        ResponseDetail response = ApiBuilder.getResponse("title/fullcredits", args);
        if (response == null) {
            return Collections.emptyList();
        } else {
            return response.getCredits();
        }

    }

    /**
     * Perform a search on the IMDB
     *
     * @param query
     * @return
     */
    public Map<String, List<SearchObject>> getSearch(String query) {
        Map<String, String> args = new HashMap<>();

        String encodedQuery;
        try {
            encodedQuery = URLEncoder.encode(query, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            LOG.trace("Failed to encode '{}': {}", query, ex.getMessage(), ex);
            encodedQuery = query;
        }
        args.put("q", encodedQuery);
        // Added for the change to the find api
        args.put("device", "0");

        WrapperSearch wrapper = ApiBuilder.getSearchWrapper("find", args);
        if (wrapper == null) {
            return Collections.emptyMap();
        } else {
            return wrapper.getSearchResults();
        }
    }

    /**
     * Get the latest box office information
     *
     * @return
     */
    public List<ImdbBoxOffice> getBoxOffice() {
        WrapperBoxOffice wrapper = ApiBuilder.getWrapper(WrapperBoxOffice.class, "boxoffice", Collections.<String, String>emptyMap());
        // Because WrapperBoxOffice is a "double" wrapper, we need to access the "inner" layer through the "outer" layer
        if (wrapper != null && wrapper.getData().getBoxOfficeList() != null) {
            return wrapper.getData().getBoxOfficeList().getBoxOffice();
        }
        return Collections.emptyList();
    }

    /**
     * Get all the plots for a title.
     *
     * @param imdbId
     * @return
     */
    public List<ImdbPlot> getTitlePlot(String imdbId) {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);

        ResponseDetail response = ApiBuilder.getResponse("title/plot", args);
        if (response == null) {
            return Collections.emptyList();
        } else {
            return response.getPlots();
        }
    }

    /**
     * Get all the synopsis for a title.
     *
     * @param imdbId
     * @return
     */
    public ImdbSynopsis getTitleSynopsis(String imdbId) {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);

        WrapperSynopsis wrapper = ApiBuilder.getWrapper(WrapperSynopsis.class, "title/synopsis", args);
        return wrapper.getResult();
    }

    /**
     * Get the Chart Movie Meter
     *
     * @return
     */
    public List<ImdbChartMoviemeter> getChartMoviemeter() {
        WrapperChartMoviemeter wrapper = ApiBuilder.getWrapper(WrapperChartMoviemeter.class, "chart/moviemeter", Collections.<String, String>emptyMap());
        if (wrapper == null) {
            return Collections.emptyList();
        } else {
            return wrapper.getData().getChartMoviemeter();
        }
    }

    /**
     * Get the Chart Star Meter
     *
     * @return
     */
    public List<ImdbChartStarmeter> getChartStarmeter() {
        WrapperChartStarmeter wrapper = ApiBuilder.getWrapper(WrapperChartStarmeter.class, "chart/starmeter", Collections.<String, String>emptyMap());
        if (wrapper == null) {
            return Collections.emptyList();
        } else {
            return wrapper.getData().getChartStarmeter();
        }
    }

    /**
     * Get the TV Tonight
     *
     * @param date
     * @return
     */
    public URL getTvTonight(Date date) {
        Map<String, String> args = new HashMap<>();

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        args.put("date", sdf.format(date));
        return ApiBuilder.buildUrl("tv/tonight", args);
    }

    /**
     * Get the TV Tonight
     *
     * @param date
     * @return
     */
    public URL getTvRecap(Date date) {
        Map<String, String> args = new HashMap<>();

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        args.put("date", sdf.format(date));
        return ApiBuilder.buildUrl("tv/recap", args);
    }

}
