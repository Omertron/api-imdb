package com.moviejukebox.imdbapi;

import com.moviejukebox.imdbapi.model.*;
import com.moviejukebox.imdbapi.tools.ApiBuilder;
import com.moviejukebox.imdbapi.tools.FilteringLayout;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.log4j.Logger;

public class ImdbApi {
    private static final Logger LOGGER = Logger.getLogger(ImdbApi.class);

    private static final String TCONST = "tconst";
    private static final String NCONST = "nconst";

    public ImdbApi() {
        FilteringLayout.addReplacementString("app.imdb.com");
    }

    public static URL getShowtimes(String location, Date date) {
        Map<String, String> args = new HashMap<String, String>();
        args.put("location", location);

        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
        args.put("date", dt1.format(date));
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

        WrapperSearch wrapper = ApiBuilder.getSearchWrapper("find", args);
        if (wrapper == null) {
            return null;
        } else {
            return wrapper.getSearchResults();
        }
    }

}
