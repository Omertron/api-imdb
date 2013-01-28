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
import com.omertron.imdbapi.tools.FilteringLayout;
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
import java.util.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * Java API class for the IMDB JSON API
 *
 * @author stuart.boston
 */
public final class ImdbApi {

    private static final Logger LOGGER = Logger.getLogger(ImdbApi.class);
    private static final String TCONST = "tconst";
    private static final String NCONST = "nconst";

    /*
     * Outstanding methods to implement
     * TODO: tv/tonight
     * TODO: tv/recap
     * TODO: chart/starmeter
     * TODO: feature/borntoday
     */
    static {
        FilteringLayout.addReplacementString("app.imdb.com");
    }

    private ImdbApi() {
        throw new UnsupportedOperationException("Class cannot be initialised");
    }

    /**
     * Set the locale using a pre-constructed java locale object
     *
     * @param locale
     */
    public static void setLocale(Locale locale) {
        ApiBuilder.setLocale(locale);
    }

    /**
     * Set the locale using the language only.
     *
     * This will default to the source country for that language.
     *
     * @param language
     */
    public static void setLocale(String language) {
        setLocale(new Locale(language));
    }

    /**
     * Set the locale using the language an country.
     *
     * @param language
     * @param country
     */
    public static void setLocale(String language, String country) {
        setLocale(new Locale(language, country));
    }

    /**
     * Output the API version information to the debug log
     */
    public static void showVersion() {
        String apiTitle = ImdbApi.class.getPackage().getSpecificationTitle();

        if (StringUtils.isNotBlank(apiTitle)) {
            String apiVersion = ImdbApi.class.getPackage().getSpecificationVersion();
            String apiRevision = ImdbApi.class.getPackage().getImplementationVersion();
            StringBuilder sv = new StringBuilder();
            sv.append(apiTitle);
            sv.append(" ").append(apiVersion);
            sv.append(" r").append(apiRevision);
            LOGGER.debug(sv.toString());
        } else {
            LOGGER.debug("API-IMDB version/revision information not available");
        }
    }

    /**
     * Get the show times for a particular location
     *
     * @param location
     * @param date
     */
    public static URL getShowtimes(String location, Date date) {
        Map<String, String> args = new HashMap<String, String>();
        args.put("location", location);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        args.put("date", sdf.format(date));
        return ApiBuilder.buildUrl("showtimes/location", args);
    }

    /**
     * Get the parental guide information for a title
     *
     * @param imdbId
     */
    public static List<ImdbText> getParentalGuide(String imdbId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(TCONST, imdbId);

        ResponseDetail response = ApiBuilder.getResponse("title/parentalguide", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getParentalGuide();
        }
    }

    /**
     * Get the user reviews for a title
     *
     * @param imdbId
     */
    public static List<ImdbUserComment> getUserReviews(String imdbId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(TCONST, imdbId);

        ResponseDetail response = ApiBuilder.getResponse("title/usercomments", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getUserComments();
        }
    }

    /**
     * Get the external reviews for a title
     *
     * @param imdbId
     */
    public static List<ImdbReview> getExternalReviews(String imdbId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(TCONST, imdbId);

        ResponseDetail response = ApiBuilder.getResponse("title/external_reviews", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getExternalReviews();
        }
    }

    /**
     * Get the list of coming soon titles
     */
    public static List<ImdbList> getComingSoon() {
        ResponseDetail response = ApiBuilder.getResponse("feature/comingsoon");
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getList().getImdbList();
        }
    }

    /**
     * Get the Top250 list
     */
    public static List<ImdbList> getTop250() {
        ResponseDetail response = ApiBuilder.getResponse("chart/top");
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getList().getImdbList();
        }
    }

    /**
     * Get the Bottom 100 list
     */
    public static List<ImdbList> getBottom100() {
        ResponseDetail response = ApiBuilder.getResponse("chart/bottom");
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getList().getImdbList();
        }
    }

    /**
     * Get the quotes for an actor
     *
     * @param actorId
     */
    public static List<String> getActorQuotes(String actorId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(NCONST, actorId);
        ResponseDetail response = ApiBuilder.getResponse("name/quotes", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getQuotes();
        }
    }

    /**
     * Get the trivia for an actor
     *
     * @param actorId
     */
    public static List<ImdbText> getActorTrivia(String actorId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(NCONST, actorId);
        ResponseDetail response = ApiBuilder.getResponse("name/trivia", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getTrivia();
        }
    }

    /**
     * Get the actor's filmography
     *
     * @param actorId
     */
    public static List<ImdbFilmography> getActorFilmography(String actorId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(NCONST, actorId);
        ResponseDetail response = ApiBuilder.getResponse("name/filmography", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getFilmography();
        }
    }

    /**
     * Get the main details about the actor
     *
     * @param actorId
     */
    public static ImdbPerson getActorDetails(String actorId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(NCONST, actorId);

        WrapperActorData wad = ApiBuilder.getWrapper(WrapperActorData.class, "name/maindetails", args);
        if (wad == null) {
            return null;
        } else {
            return wad.getActorData();
        }
    }

    /**
     * Get the episodes for a show
     *
     * @param imdbId
     */
    public static List<ImdbSeason> getTitleEpisodes(String imdbId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(TCONST, imdbId);
        ResponseDetail response = ApiBuilder.getResponse("title/episodes", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getSeasons();
        }
    }

    /**
     * Get the goofs for a title
     *
     * @param imdbId
     */
    public static List<ImdbSpoiler> getTitleGoofs(String imdbId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(TCONST, imdbId);
        ResponseDetail response = ApiBuilder.getResponse("title/goofs", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            List<ImdbSpoiler> spoilers = new ArrayList<ImdbSpoiler>();

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
     * Get the quotes for a title
     *
     * @param imdbId
     */
    public static ImdbQuotes getTitleQuotes(String imdbId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(TCONST, imdbId);

        WrapperQuotes wrapper = ApiBuilder.getWrapper(WrapperQuotes.class, "title/quotes", args);
        if (wrapper == null) {
            return null;
        } else {
            return wrapper.getQuotes();
        }
    }

    /**
     * Get the trivia for a title
     *
     * @param imdbId
     */
    public static List<ImdbSpoiler> getTitleTrivia(String imdbId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(TCONST, imdbId);
        ResponseDetail response = ApiBuilder.getResponse("title/trivia", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            List<ImdbSpoiler> spoilers = new ArrayList<ImdbSpoiler>();

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
     */
    public static List<ImdbImage> getTitlePhotos(String imdbId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(TCONST, imdbId);
        ResponseDetail response = ApiBuilder.getResponse("title/photos", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getPhotos();
        }
    }

    /**
     * Get the main details for a title
     *
     * @param imdbId
     */
    public static ImdbMovieDetails getFullDetails(String imdbId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(TCONST, imdbId);
        WrapperMovieDetails wrapper = ApiBuilder.getWrapper(WrapperMovieDetails.class, "title/maindetails", args);
        if (wrapper == null) {
            return null;
        } else {
            return wrapper.getMovie();
        }
    }

    /**
     * Get the cast for a title
     *
     * @param imdbId
     */
    public static List<ImdbCredit> getFullCast(String imdbId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(TCONST, imdbId);

        ResponseDetail response = ApiBuilder.getResponse("title/fullcredits", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getCredits();
        }

    }

    /**
     * Perform a search on the IMDB
     *
     * @param query
     */
    public static Map<String, List<SearchObject>> getSearch(String query) {
        Map<String, String> args = new HashMap<String, String>();

        String encodedQuery;
        try {
            encodedQuery = URLEncoder.encode(query, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            encodedQuery = query;
        }
        args.put("q", encodedQuery);
        // Added for the change to the find api
        args.put("device", "0");

        WrapperSearch wrapper = ApiBuilder.getSearchWrapper("find", args);
        if (wrapper == null) {
            return Collections.EMPTY_MAP;
        } else {
            return wrapper.getSearchResults();
        }
    }

    /**
     * Get the latest box office information
     */
    public static List<ImdbBoxOffice> getBoxOffice() {
        WrapperBoxOffice wrapper = ApiBuilder.getWrapper(WrapperBoxOffice.class, "boxoffice", Collections.EMPTY_MAP);
        // Because WrapperBoxOffice is a "double" wrapper, we need to access the "inner" layer through the "outer" layer
        if (wrapper != null && wrapper.getData().getBoxOfficeList() != null) {
            return wrapper.getData().getBoxOfficeList().getBoxOffice();
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * Get all the plots for a title.
     *
     * @param imdbId
     */
    public static List<ImdbPlot> getTitlePlot(String imdbId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(TCONST, imdbId);

        ResponseDetail response = ApiBuilder.getResponse("title/plot", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getPlots();
        }
    }

    /**
     * Get all the synopsis for a title.
     *
     * @param imdbId
     */
    public static ImdbSynopsis getTitleSynopsis(String imdbId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(TCONST, imdbId);

        WrapperSynopsis wrapper = ApiBuilder.getWrapper(WrapperSynopsis.class, "title/synopsis", args);
        if (wrapper == null) {
            return null;
        } else {
            return wrapper.getSynopsis();
        }
    }

    /**
     * Get the Chart Movie Meter
     */
    public static List<ImdbChartMoviemeter> getChartMoviemeter() {
        WrapperChartMoviemeter wrapper = ApiBuilder.getWrapper(WrapperChartMoviemeter.class, "chart/moviemeter", Collections.EMPTY_MAP);
        if (wrapper == null) {
            return Collections.EMPTY_LIST;
        } else {
            return wrapper.getData().getChartMoviemeter();
        }
    }

    /**
     * Get the Chart Star Meter
     */
    public static List<ImdbChartStarmeter> getChartStarmeter() {
        WrapperChartStarmeter wrapper = ApiBuilder.getWrapper(WrapperChartStarmeter.class, "chart/starmeter", Collections.EMPTY_MAP);
        if (wrapper == null) {
            return Collections.EMPTY_LIST;
        } else {
            return wrapper.getData().getChartStarmeter();
        }
    }
}
