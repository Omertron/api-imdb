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

    /*
     * Outstanding methods to implement
     * TODO: tv/tonight
     * TODO: tv/recap
     * TODO: chart/starmeter
     * TODO: feature/borntoday
     */
    private static final Logger LOG = LoggerFactory.getLogger(ImdbApi.class);
    private static final String TCONST = "tconst";
    private static final String NCONST = "nconst";
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private final ApiBuilder apiBuilder;
    private Locale defaultLocale;

    /**
     * Constructor with a default HttpClient and Locale
     */
    public ImdbApi() {
        this(new SimpleHttpClientBuilder().build(), Locale.getDefault());
    }

    public ImdbApi(HttpClient httpClient) {
        this(httpClient, Locale.getDefault());
    }

    public ImdbApi(HttpClient httpClient, String language) {
        this(httpClient, new Locale(language));
    }

    public ImdbApi(HttpClient httpClient, String language, String country) {
        this(httpClient, new Locale(language, country));
    }

    public ImdbApi(HttpClient httpClient, Locale locale) {
        apiBuilder = new ApiBuilder(httpClient);
        this.defaultLocale = locale;
    }

//<editor-fold defaultstate="collapsed" desc="Locale Setters">
    /**
     * Set the locale using a pre-constructed java locale object
     *
     * @param locale
     */
    public void setLocale(Locale locale) {
        this.defaultLocale = locale;
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
     * Get the currently set default locale
     *
     * You can use this after setting the locale with language and/or country to
     * get the proper Locale value for the function calls.
     *
     * @return
     */
    public Locale getLocale() {
        return defaultLocale;
    }
//</editor-fold>

    /**
     * Get the show times for a particular location
     *
     * @param location
     * @param date
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public URL getShowtimes(String location, Date date) throws ImdbException {
        return getShowtimes(location, date, defaultLocale);
    }

    /**
     * Get the show times for a particular location
     *
     * @param location
     * @param date
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public URL getShowtimes(String location, Date date, Locale locale) throws ImdbException {
        Map<String, String> args = new HashMap<>();
        args.put("location", location);

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        args.put("date", sdf.format(date));
        return apiBuilder.buildUrl("showtimes/location", args, locale);
    }

    /**
     * Get the parental guide information for a title
     *
     * @param imdbId
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbText> getParentalGuide(String imdbId) throws ImdbException {
        return getParentalGuide(imdbId, defaultLocale);
    }

    /**
     * Get the parental guide information for a title
     *
     * @param imdbId
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbText> getParentalGuide(String imdbId, Locale locale) throws ImdbException {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);

        ResponseDetail response = apiBuilder.getResponse("title/parentalguide", args, locale);
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
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbUserComment> getUserReviews(String imdbId) throws ImdbException {
        return getUserReviews(imdbId, defaultLocale);
    }

    /**
     * Get the user reviews for a title
     *
     * @param imdbId
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbUserComment> getUserReviews(String imdbId, Locale locale) throws ImdbException {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);

        ResponseDetail response = apiBuilder.getResponse("title/usercomments", args, locale);
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
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbReview> getExternalReviews(String imdbId) throws ImdbException {
        return getExternalReviews(imdbId, defaultLocale);
    }

    /**
     * Get the external reviews for a title
     *
     * @param imdbId
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbReview> getExternalReviews(String imdbId, Locale locale) throws ImdbException {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);

        ResponseDetail response = apiBuilder.getResponse("title/external_reviews", args, locale);
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
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbList> getComingSoon() throws ImdbException {
        return getComingSoon(defaultLocale);
    }

    /**
     * Get the list of coming soon titles
     *
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbList> getComingSoon(Locale locale) throws ImdbException {
        ResponseDetail response = apiBuilder.getResponse("feature/comingsoon", locale);
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
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbList> getTop250() throws ImdbException {
        return getTop250(defaultLocale);
    }

    /**
     * Get the Top250 list
     *
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbList> getTop250(Locale locale) throws ImdbException {
        ResponseDetail response = apiBuilder.getResponse("chart/top", locale);
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
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbList> getBottom100() throws ImdbException {
        return getBottom100(defaultLocale);
    }

    /**
     * Get the Bottom 100 list
     *
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbList> getBottom100(Locale locale) throws ImdbException {
        ResponseDetail response = apiBuilder.getResponse("chart/bottom", locale);
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
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<String> getActorQuotes(String actorId) throws ImdbException {
        return getActorQuotes(actorId, defaultLocale);
    }

    /**
     * Get the quotes for an actor
     *
     * @param actorId
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<String> getActorQuotes(String actorId, Locale locale) throws ImdbException {
        Map<String, String> args = new HashMap<>();
        args.put(NCONST, actorId);
        ResponseDetail response = apiBuilder.getResponse("name/quotes", args, locale);
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
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbText> getActorTrivia(String actorId) throws ImdbException {
        return getActorTrivia(actorId, defaultLocale);
    }

    /**
     * Get the trivia for an actor
     *
     * @param actorId
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbText> getActorTrivia(String actorId, Locale locale) throws ImdbException {
        Map<String, String> args = new HashMap<>();
        args.put(NCONST, actorId);
        ResponseDetail response = apiBuilder.getResponse("name/trivia", args, locale);
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
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbFilmography> getActorFilmography(String actorId) throws ImdbException {
        return getActorFilmography(actorId, defaultLocale);
    }

    /**
     * Get the actor's filmography
     *
     * @param actorId
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbFilmography> getActorFilmography(String actorId, Locale locale) throws ImdbException {
        Map<String, String> args = new HashMap<>();
        args.put(NCONST, actorId);
        ResponseDetail response = apiBuilder.getResponse("name/filmography", args, locale);
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
     * @throws com.omertron.imdbapi.ImdbException
     */
    public ImdbPerson getActorDetails(String actorId) throws ImdbException {
        return getActorDetails(actorId, defaultLocale);
    }

    /**
     * Get the main details about the actor
     *
     * @param actorId
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public ImdbPerson getActorDetails(String actorId, Locale locale) throws ImdbException {
        Map<String, String> args = new HashMap<>();
        args.put(NCONST, actorId);

        WrapperActorData wrapper = apiBuilder.getWrapper(WrapperActorData.class, "name/maindetails", args, locale);
        return wrapper.getResult();
    }

    /**
     * Get the episodes for a show
     *
     * @param imdbId
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbSeason> getTitleEpisodes(String imdbId) throws ImdbException {
        return getTitleEpisodes(imdbId, defaultLocale);
    }

    /**
     * Get the episodes for a show
     *
     * @param imdbId
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbSeason> getTitleEpisodes(String imdbId, Locale locale) throws ImdbException {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);
        ResponseDetail response = apiBuilder.getResponse("title/episodes", args, locale);
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
     * @throws com.omertron.imdbapi.ImdbException
     */
    public ImdbQuotes getTitleQuotes(String imdbId) throws ImdbException {
        return getTitleQuotes(imdbId, defaultLocale);
    }

    /**
     * Get the quotes for a title
     *
     * @param imdbId
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public ImdbQuotes getTitleQuotes(String imdbId, Locale locale) throws ImdbException {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);

        WrapperQuotes wrapper = apiBuilder.getWrapper(WrapperQuotes.class, "title/quotes", args, locale);
        return wrapper.getResult();
    }

    /**
     * Get the goofs for a title
     *
     * @param imdbId
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbSpoiler> getTitleGoofs(String imdbId) throws ImdbException {
        return getTitleGoofs(imdbId, defaultLocale);
    }

    /**
     * Get the goofs for a title
     *
     * @param imdbId
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbSpoiler> getTitleGoofs(String imdbId, Locale locale) throws ImdbException {
        return getTitleSpoilers(imdbId, "title/goofs", locale);
    }

    /**
     * Get the trivia for a title
     *
     * @param imdbId
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbSpoiler> getTitleTrivia(String imdbId) throws ImdbException {
        return getTitleTrivia(imdbId, defaultLocale);
    }

    /**
     * Get the trivia for a title
     *
     * @param imdbId
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbSpoiler> getTitleTrivia(String imdbId, Locale locale) throws ImdbException {
        return getTitleSpoilers(imdbId, "title/trivia", locale);
    }

    /**
     * Get a list of "spoilers" for a title
     *
     * @param imdbId
     * @param requestType
     * @return
     */
    private List<ImdbSpoiler> getTitleSpoilers(String imdbId, String requestType) throws ImdbException {
        return getTitleSpoilers(imdbId, requestType, defaultLocale);
    }

    /**
     * Get a list of "spoilers" for a title
     *
     * @param imdbId
     * @param requestType
     * @return
     */
    private List<ImdbSpoiler> getTitleSpoilers(String imdbId, String requestType, Locale locale) throws ImdbException {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);
        ResponseDetail response = apiBuilder.getResponse(requestType, args, locale);
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
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbImage> getTitlePhotos(String imdbId) throws ImdbException {
        return getTitlePhotos(imdbId, defaultLocale);
    }

    /**
     * Get the photos for a title
     *
     * @param imdbId
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbImage> getTitlePhotos(String imdbId, Locale locale) throws ImdbException {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);
        ResponseDetail response = apiBuilder.getResponse("title/photos", args, locale);
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
     * @throws com.omertron.imdbapi.ImdbException
     */
    public ImdbMovieDetails getFullDetails(String imdbId) throws ImdbException {
        return getFullDetails(imdbId, defaultLocale);
    }

    /**
     * Get the main details for a title
     *
     * @param imdbId
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public ImdbMovieDetails getFullDetails(String imdbId, Locale locale) throws ImdbException {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);
        WrapperMovieDetails wrapper = apiBuilder.getWrapper(WrapperMovieDetails.class, "title/maindetails", args, locale);
        return wrapper.getResult();
    }

    /**
     * Get the cast for a title
     *
     * @param imdbId
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbCredit> getFullCast(String imdbId) throws ImdbException {
        return getFullCast(imdbId, defaultLocale);
    }

    /**
     * Get the cast for a title
     *
     * @param imdbId
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbCredit> getFullCast(String imdbId, Locale locale) throws ImdbException {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);

        ResponseDetail response = apiBuilder.getResponse("title/fullcredits", args, locale);
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
     * @throws com.omertron.imdbapi.ImdbException
     */
    public Map<String, List<SearchObject>> getSearch(String query) throws ImdbException {
        return getSearch(query, defaultLocale);
    }

    /**
     * Perform a search on the IMDB
     *
     * @param query
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public Map<String, List<SearchObject>> getSearch(String query, Locale locale) throws ImdbException {
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

        WrapperSearch wrapper = apiBuilder.getSearchWrapper("find", args, locale);
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
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbBoxOffice> getBoxOffice() throws ImdbException {
        return getBoxOffice(defaultLocale);
    }

    /**
     * Get the latest box office information
     *
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    /**
     * Get the latest box office information
     *
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbBoxOffice> getBoxOffice(Locale locale) throws ImdbException {
        WrapperBoxOffice wrapper = apiBuilder.getWrapper(WrapperBoxOffice.class, "boxoffice", Collections.<String, String>emptyMap(), locale);
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
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbPlot> getTitlePlot(String imdbId) throws ImdbException {
        return getTitlePlot(imdbId, defaultLocale);
    }

    /**
     * Get all the plots for a title.
     *
     * @param imdbId
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbPlot> getTitlePlot(String imdbId, Locale locale) throws ImdbException {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);

        ResponseDetail response = apiBuilder.getResponse("title/plot", args, locale);
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
     * @throws com.omertron.imdbapi.ImdbException
     */
    public ImdbSynopsis getTitleSynopsis(String imdbId) throws ImdbException {
        return getTitleSynopsis(imdbId, defaultLocale);
    }

    /**
     * Get all the synopsis for a title.
     *
     * @param imdbId
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public ImdbSynopsis getTitleSynopsis(String imdbId, Locale locale) throws ImdbException {
        Map<String, String> args = new HashMap<>();
        args.put(TCONST, imdbId);

        WrapperSynopsis wrapper = apiBuilder.getWrapper(WrapperSynopsis.class, "title/synopsis", args, locale);
        return wrapper.getResult();
    }

    /**
     * Get the Chart Movie Meter
     *
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbChartMoviemeter> getChartMoviemeter() throws ImdbException {
        return getChartMoviemeter(defaultLocale);
    }

    /**
     * Get the Chart Movie Meter
     *
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbChartMoviemeter> getChartMoviemeter(Locale locale) throws ImdbException {
        WrapperChartMoviemeter wrapper = apiBuilder.getWrapper(WrapperChartMoviemeter.class, "chart/moviemeter", Collections.<String, String>emptyMap(), locale);
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
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbChartStarmeter> getChartStarmeter() throws ImdbException {
        return getChartStarmeter(defaultLocale);
    }

    /**
     * Get the Chart Star Meter
     *
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public List<ImdbChartStarmeter> getChartStarmeter(Locale locale) throws ImdbException {
        WrapperChartStarmeter wrapper = apiBuilder.getWrapper(WrapperChartStarmeter.class, "chart/starmeter", Collections.<String, String>emptyMap(), locale);
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
     * @throws com.omertron.imdbapi.ImdbException
     */
    public URL getTvTonight(Date date) throws ImdbException {
        return getTvTonight(date, defaultLocale);
    }

    /**
     * Get the TV Tonight
     *
     * @param date
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public URL getTvTonight(Date date, Locale locale) throws ImdbException {
        Map<String, String> args = new HashMap<>();

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        args.put("date", sdf.format(date));
        return apiBuilder.buildUrl("tv/tonight", args, locale);
    }

    /**
     * Get the TV Tonight
     *
     * @param date
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public URL getTvRecap(Date date) throws ImdbException {
        return getTvRecap(date, defaultLocale);
    }

    /**
     * Get the TV Tonight
     *
     * @param date
     * @param locale
     * @return
     * @throws com.omertron.imdbapi.ImdbException
     */
    public URL getTvRecap(Date date, Locale locale) throws ImdbException {
        Map<String, String> args = new HashMap<>();

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        args.put("date", sdf.format(date));
        return apiBuilder.buildUrl("tv/recap", args, locale);
    }

}
