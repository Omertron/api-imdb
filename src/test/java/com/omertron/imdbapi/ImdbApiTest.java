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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImdbApiTest {

    private static final Logger LOG = LoggerFactory.getLogger(ImdbApiTest.class);
    private static final List<String> IMDB_IDS = new ArrayList<>();
    private static final List<String> ACTOR_IDS = new ArrayList<>();
    private final ImdbApi imdbApi;

    public ImdbApiTest() {
        imdbApi = new ImdbApi();
    }

    @BeforeClass
    public static void setUpClass() {
        TestLogger.Configure();
        // Pulp Fiction
        IMDB_IDS.add("tt0110912");
        // Avengers
        IMDB_IDS.add("tt0848228");
        // The Big Bang Theory)
        IMDB_IDS.add("tt0898266");

        ACTOR_IDS.add("nm0000148");  // Harrison Ford
        ACTOR_IDS.add("nm0000122");  // Charles Chaplin
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getParentalGuide method, of class ImdbApi.
     */
    @Test
    public void testGetParentalGuide() {
        LOG.info("getParentalGuide");
        for (String imdbId : IMDB_IDS) {
            List<ImdbText> result = imdbApi.getParentalGuide(imdbId);
            assertFalse("Parental guide list is empty for " + imdbId, result.isEmpty());
        }
    }

    /**
     * Test of getUserReviews method, of class ImdbApi.
     */
    @Test
    public void testGetUserReviews() {
        LOG.info("getUserReviews");
        for (String imdbId : IMDB_IDS) {

            List<ImdbUserComment> result = imdbApi.getUserReviews(imdbId);
            assertFalse("User reviews is empty for " + imdbId, result.isEmpty());
        }
    }

    /**
     * Test of getExternalReviews method, of class ImdbApi.
     */
    @Test
    public void testGetExternalReviews() {
        LOG.info("getExternalReviews");
        for (String imdbId : IMDB_IDS) {
            List<ImdbReview> result = imdbApi.getExternalReviews(imdbId);
            assertFalse("External reviews is empty for " + imdbId, result.isEmpty());
        }
    }

    /**
     * Test of getComingSoon method, of class ImdbApi.
     */
    @Test
    public void testGetComingSoon() {
        LOG.info("getComingSoon");
        List<ImdbList> result = imdbApi.getComingSoon();
        assertFalse("Coming soon is empty", result.isEmpty());
    }

    /**
     * Test of getTop250 method, of class ImdbApi.
     */
    @Test
    public void testGetTop250() {
        LOG.info("getTop250");
        List<ImdbList> result = imdbApi.getTop250();
        assertFalse("Top250 is empty", result.isEmpty());
    }

    /**
     * Test of getBottom100 method, of class ImdbApi.
     */
    @Test
    public void testGetBottom100() {
        LOG.info("getBottom100");
        List<ImdbList> result = imdbApi.getBottom100();
        assertFalse("Bottom100 is empty", result.isEmpty());
    }

    /**
     * Test of getActorQuotes method, of class ImdbApi.
     */
    @Test
    public void testGetActorQuotes() {
        LOG.info("getActorQuotes");
        for (String actorId : ACTOR_IDS) {
            List<String> result = imdbApi.getActorQuotes(actorId);
            assertFalse("Actor Quotes is empty for " + actorId, result.isEmpty());
        }
    }

    /**
     * Test of getActorTrivia method, of class ImdbApi.
     */
    @Test
    public void testGetActorTrivia() {
        LOG.info("getActorTrivia");
        for (String actorId : ACTOR_IDS) {
            List<ImdbText> result = imdbApi.getActorTrivia(actorId);
            assertFalse("Actor Trivia is empty for " + actorId, result.isEmpty());
        }
    }

    /**
     * Test of getActorFilmography method, of class ImdbApi.
     */
    @Test
    public void testGetActorFilmography() {
        LOG.info("getActorFilmography");
        for (String actorId : ACTOR_IDS) {
            List<ImdbFilmography> result = imdbApi.getActorFilmography(actorId);
            assertFalse("Actor Filmography is empty for " + actorId, result.isEmpty());
        }
    }

    /**
     * Test of getActorDetails method, of class ImdbApi.
     */
    @Test
    public void testGetActorDetails() {
        LOG.info("getActorDetails");
        for (String actorId : ACTOR_IDS) {
            ImdbPerson result = imdbApi.getActorDetails(actorId);
            assertNotNull("Actor Details is empty for " + actorId, result);
        }
    }

    /**
     * Test of getTitleEpisodes method, of class ImdbApi.
     */
    @Test
    public void testGetTitleEpisodes() {
        LOG.info("getTitleEpisodes");
        for (String imdbId : IMDB_IDS) {
            List<ImdbSeason> result = imdbApi.getTitleEpisodes(imdbId);
            assertNotNull("Title Episodes is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getTitleGoofs method, of class ImdbApi.
     */
    @Test
    public void testGetTitleGoofs() {
        LOG.info("getTitleGoofs");
        for (String imdbId : IMDB_IDS) {
            List<ImdbSpoiler> result = imdbApi.getTitleGoofs(imdbId);
            assertNotNull("Title Goofs is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getTitleQuotes method, of class ImdbApi.
     */
    @Test
    public void testGetTitleQuotes() {
        LOG.info("getTitleQuotes");
        for (String imdbId : IMDB_IDS) {
            ImdbQuotes result = imdbApi.getTitleQuotes(imdbId);
            assertNotNull("Title Quotes is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getTitleTrivia method, of class ImdbApi.
     */
    @Test
    public void testGetTitleTrivia() {
        LOG.info("getTitleTrivia");
        for (String imdbId : IMDB_IDS) {
            List<ImdbSpoiler> result = imdbApi.getTitleTrivia(imdbId);
            assertNotNull("Title Trivia is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getTitlePhotos method, of class ImdbApi.
     */
    @Test
    public void testGetTitlePhotos() {
        LOG.info("getTitlePhotos");
        for (String imdbId : IMDB_IDS) {
            List<ImdbImage> result = imdbApi.getTitlePhotos(imdbId);
            assertNotNull("Title Photos is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getFullDetails method, of class ImdbApi.
     */
    @Test
    public void testGetFullDetails() {
        LOG.info("getFullDetails");
        for (String imdbId : IMDB_IDS) {
            ImdbMovieDetails result = imdbApi.getFullDetails(imdbId);
            assertNotNull("Full Details is empty for " + imdbId, result);
            LOG.info("Genres: {}", result.getGenres());
        }
    }

    /**
     * Test of getFullCast method, of class ImdbApi.
     */
    @Test
    public void testGetFullCast() {
        LOG.info("getFullCast");
        for (String imdbId : IMDB_IDS) {
            List<ImdbCredit> result = imdbApi.getFullCast(imdbId);
            assertNotNull("Full Cast is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getSearch method, of class ImdbApi.
     */
    @Ignore("Not working yet")
    public void testGetSearch() {
        LOG.info("getSearch");
        Map<String, List<SearchObject>> result = imdbApi.getSearch("James Dean");

        assertNotNull("Search is empty", result);
        assertTrue("Search has no results", result.size() > 0);
    }

    /**
     * Test of setLocale method, of class ImdbApi.
     */
    @Test
    public void testSetLocale_Locale() {
        // Not required
    }

    /**
     * Test of setLocale method, of class ImdbApi.
     */
    @Test
    public void testSetLocale_String() {
        // Not required
    }

    /**
     * Test of setLocale method, of class ImdbApi.
     */
    @Test
    public void testSetLocale_String_String() {
        // Not required
    }

    /**
     * Test of showVersion method, of class ImdbApi.
     */
    @Test
    public void testShowVersion() {
        // Not required
    }

    /**
     * Test of getShowtimes method, of class ImdbApi.
     */
    @Test
    public void testGetShowtimes() {
        LOG.info("getShowtimes - Not tested");
    }

    /**
     * Test of getBoxOffice method, of class ImdbApi.
     */
    @Test
    public void testGetBoxOffice() {
        LOG.info("getBoxOffice");
        List<ImdbBoxOffice> result = imdbApi.getBoxOffice();
        assertFalse("BoxOffice is empty", result.isEmpty());
    }

    /**
     * Test of getTitlePlot method, of class ImdbApi.
     */
    @Test
    public void testGetTitlePlot() {
        LOG.info("getTitlePlot");
        for (String imdbId : IMDB_IDS) {
            List<ImdbPlot> result = imdbApi.getTitlePlot(imdbId);
            assertNotNull("Title plot is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getTitleSynopsis method, of class ImdbApi.
     */
    @Test
    public void testGetTitleSynopsis() {
        LOG.info("getTitleSynopsis");
        for (String imdbId : IMDB_IDS) {
            ImdbSynopsis result = imdbApi.getTitleSynopsis(imdbId);

            // There could be a valid "No synopsis" error thrown
            if (result.isError() && result.getStatusMessage().getMessage().startsWith("No synopsis currently available")) {
                LOG.info("Valid response returned for '{}': {}", imdbId, result.getStatusMessage().getMessage());
            } else {
                assertNotNull("Title synopsis is empty for " + imdbId, result);
            }
        }
    }

    /**
     * Test of getChartMoviemeter method, of class ImdbApi.
     */
    @Test
    public void testGetChartMoviemeter() {
        LOG.info("getChartMoviemeter");
        List<ImdbChartMoviemeter> result = imdbApi.getChartMoviemeter();
        assertFalse("Chart Moviemeter is empty", result.isEmpty());
    }

    /**
     * Test of getChartStarmeter method, of class ImdbApi.
     */
    @Test
    public void testGetChartStarmeter() {
        LOG.info("getChartStarmeter");
        List<ImdbChartStarmeter> result = imdbApi.getChartStarmeter();
        assertFalse("Chart Starmeter is empty", result.isEmpty());
    }

    /**
     * Test of getTvTonight method, of class ImdbApi.
     */
    @Ignore("Not complete")
    public void testGetTvTonight() {
        LOG.info("getTvTonight");
    }

    /**
     * Test of getTvRecap method, of class ImdbApi.
     */
    @Ignore("Not complete")
    public void testGetTvRecap() {
        LOG.info("getTvRecap");
    }
}
