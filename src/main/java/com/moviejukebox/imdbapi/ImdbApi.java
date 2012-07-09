package com.moviejukebox.imdbapi;

import com.moviejukebox.imdbapi.model.*;
import com.moviejukebox.imdbapi.search.SearchObject;
import com.moviejukebox.imdbapi.tools.ApiBuilder;
import com.moviejukebox.imdbapi.tools.FilteringLayout;
import com.moviejukebox.imdbapi.wrapper.Response;
import com.moviejukebox.imdbapi.wrapper.WrapperActorData;
import com.moviejukebox.imdbapi.wrapper.WrapperMovieDetails;
import com.moviejukebox.imdbapi.wrapper.WrapperQuotes;
import com.moviejukebox.imdbapi.wrapper.WrapperSearch;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public final class ImdbApi {

    private static final Logger LOGGER = Logger.getLogger(ImdbApi.class);
    private static final String TCONST = "tconst";
    private static final String NCONST = "nconst";

    // Outstanding methods to implement
    //TODO: chart/moviemeter
    //TODO: chart/top
    //TODO: tv/tonight
    //TODO: tv/recap
    //TODO: chart/starmeter
    //TODO: feature/borntoday
    //TODO: news
    //TODO: title/plot
    //TODO: title/synopsis

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

    public static URL getShowtimes(String location, Date date) {
        Map<String, String> args = new HashMap<String, String>();
        args.put("location", location);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        args.put("date", sdf.format(date));
        return ApiBuilder.buildUrl("showtimes/location", args);
    }

    public static List<ImdbText> getParentalGuide(String imdbId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(TCONST, imdbId);

        Response response = ApiBuilder.getResponse("title/parentalguide", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getParentalGuide();
        }
    }

    public static List<ImdbUserComment> getUserReviews(String imdbId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(TCONST, imdbId);

        Response response = ApiBuilder.getResponse("title/usercomments", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getUserComments();
        }
    }

    public static List<ImdbReview> getExternalReviews(String imdbId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(TCONST, imdbId);

        Response response = ApiBuilder.getResponse("title/external_reviews", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getExternalReviews();
        }
    }

    public static List<ImdbList> getComingSoon() {
        Response response = ApiBuilder.getResponse("feature/comingsoon");
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getList().getImdbList();
        }
    }

    public static List<ImdbList> getTop250() {
        Response response = ApiBuilder.getResponse("chart/top");
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getList().getImdbList();
        }
    }

    public static List<ImdbList> getBottom100() {
        Response response = ApiBuilder.getResponse("chart/bottom");
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getList().getImdbList();
        }
    }

    public static List<String> getActorQuotes(String actorId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(NCONST, actorId);
        Response response = ApiBuilder.getResponse("name/quotes", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getQuotes();
        }
    }

    public static List<ImdbText> getActorTrivia(String actorId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(NCONST, actorId);
        Response response = ApiBuilder.getResponse("name/trivia", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getTrivia();
        }
    }

    public static List<ImdbFilmography> getActorFilmography(String actorId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(NCONST, actorId);
        Response response = ApiBuilder.getResponse("name/filmography", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getFilmography();
        }
    }

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

    public static List<ImdbSeason> getTitleEpisodes(String imdbId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(TCONST, imdbId);
        Response response = ApiBuilder.getResponse("title/episodes", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getSeasons();
        }
    }

    public static List<ImdbSpoiler> getTitleGoofs(String imdbId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(TCONST, imdbId);
        Response response = ApiBuilder.getResponse("title/goofs", args);
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

    public static List<ImdbSpoiler> getTitleTrivia(String imdbId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(TCONST, imdbId);
        Response response = ApiBuilder.getResponse("title/trivia", args);
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

    public static List<ImdbImage> getTitlePhotos(String imdbId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(TCONST, imdbId);
        Response response = ApiBuilder.getResponse("title/photos", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getPhotos();
        }
    }

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

    public static List<ImdbCredit> getFullCast(String imdbId) {
        Map<String, String> args = new HashMap<String, String>();
        args.put(TCONST, imdbId);

        Response response = ApiBuilder.getResponse("title/fullcredits", args);
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getCredits();
        }

    }

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
            return null;
        } else {
            return wrapper.getSearchResults();
        }
    }

    public static List<ImdbList> getBoxOffice() {
        Response response = ApiBuilder.getResponse("boxoffice");
        if (response == null) {
            return Collections.EMPTY_LIST;
        } else {
            return response.getList().getImdbList();
        }
    }

}
