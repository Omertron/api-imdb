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
import com.omertron.imdbapi.tools.FilteringLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.*;
import static org.junit.Assert.*;

public class ImdbApiTest {

    private static final Logger LOGGER = Logger.getLogger(ImdbApiTest.class);
    private static final List<String> IMDB_IDS = new ArrayList<String>();
    private static final List<String> ACTOR_IDS = new ArrayList<String>();

    public ImdbApiTest() {
        if (IMDB_IDS.isEmpty()) {
            IMDB_IDS.add("tt0110912");  // Pulp Fiction
            IMDB_IDS.add("tt0848228");  // Avengers
            IMDB_IDS.add("tt0898266");  // The Big Bang Theory)
        }

        if (ACTOR_IDS.isEmpty()) {
            ACTOR_IDS.add("nm0000148");  // Harrison Ford
        }
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        // Set the logger level to TRACE
        Logger.getRootLogger().setLevel(Level.TRACE);
        // Show the version of the API
        ImdbApi.showVersion();
        // Make sure the filter isn't applied to the test output
        FilteringLayout.addReplacementString("DO_NOT_MATCH");
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
    //@Test
    public void testGetParentalGuide() {
        LOGGER.info("getParentalGuide");
        for (String imdbId : IMDB_IDS) {
            List<ImdbText> result = ImdbApi.getParentalGuide(imdbId);
            assertFalse("Parental guide list is empty for " + imdbId, result.isEmpty());
        }
    }

    /**
     * Test of getUserReviews method, of class ImdbApi.
     */
    //@Test
    public void testGetUserReviews() {
        LOGGER.info("getUserReviews");
        for (String imdbId : IMDB_IDS) {

            List<ImdbUserComment> result = ImdbApi.getUserReviews(imdbId);
            assertFalse("User reviews is empty for " + imdbId, result.isEmpty());
        }
    }

    /**
     * Test of getExternalReviews method, of class ImdbApi.
     */
//    //@Test
    public void testGetExternalReviews() {
        LOGGER.info("getExternalReviews");
        for (String imdbId : IMDB_IDS) {
            List<ImdbReview> result = ImdbApi.getExternalReviews(imdbId);
            assertFalse("External reviews is empty for " + imdbId, result.isEmpty());
        }
    }

    /**
     * Test of getComingSoon method, of class ImdbApi.
     */
    //@Test
    public void testGetComingSoon() {
        LOGGER.info("getComingSoon");
        List<ImdbList> result = ImdbApi.getComingSoon();
        assertFalse("Coming soon is empty", result.isEmpty());
    }

    /**
     * Test of getTop250 method, of class ImdbApi.
     */
    //@Test
    public void testGetTop250() {
        LOGGER.info("getTop250");
        List<ImdbList> result = ImdbApi.getTop250();
        assertFalse("Top250 is empty", result.isEmpty());
    }

    /**
     * Test of getBottom100 method, of class ImdbApi.
     */
    //@Test
    public void testGetBottom100() {
        LOGGER.info("getBottom100");
        List<ImdbList> result = ImdbApi.getBottom100();
        assertFalse("Bottom100 is empty", result.isEmpty());
    }

    /**
     * Test of getActorQuotes method, of class ImdbApi.
     */
    //@Test
    public void testGetActorQuotes() {
        LOGGER.info("getActorQuotes");
        for (String actorId : ACTOR_IDS) {
            List<String> result = ImdbApi.getActorQuotes(actorId);
            assertFalse("Actor Quotes is empty for " + actorId, result.isEmpty());
        }
    }

    /**
     * Test of getActorTrivia method, of class ImdbApi.
     */
    //@Test
    public void testGetActorTrivia() {
        LOGGER.info("getActorTrivia");
        for (String actorId : ACTOR_IDS) {
            List<ImdbText> result = ImdbApi.getActorTrivia(actorId);
            assertFalse("Actor Trivia is empty for " + actorId, result.isEmpty());
        }
    }

    /**
     * Test of getActorFilmography method, of class ImdbApi.
     */
    //@Test
    public void testGetActorFilmography() {
        LOGGER.info("getActorFilmography");
        for (String actorId : ACTOR_IDS) {
            List<ImdbFilmography> result = ImdbApi.getActorFilmography(actorId);
            assertFalse("Actor Filmography is empty for " + actorId, result.isEmpty());
        }
    }

    /**
     * Test of getActorDetails method, of class ImdbApi.
     */
    //@Test
    public void testGetActorDetails() {
        LOGGER.info("getActorDetails");
        for (String actorId : ACTOR_IDS) {
            ImdbPerson result = ImdbApi.getActorDetails(actorId);
            assertNotNull("Actor Details is empty for " + actorId, result);
        }
    }

    /**
     * Test of getTitleEpisodes method, of class ImdbApi.
     */
    //@Test
    public void testGetTitleEpisodes() {
        LOGGER.info("getTitleEpisodes");
        for (String imdbId : IMDB_IDS) {
            List<ImdbSeason> result = ImdbApi.getTitleEpisodes(imdbId);
            assertNotNull("Title Episodes is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getTitleGoofs method, of class ImdbApi.
     */
    //@Test
    public void testGetTitleGoofs() {
        LOGGER.info("getTitleGoofs");
        for (String imdbId : IMDB_IDS) {
            List<ImdbSpoiler> result = ImdbApi.getTitleGoofs(imdbId);
            assertNotNull("Title Goofs is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getTitleQuotes method, of class ImdbApi.
     */
    //@Test
    public void testGetTitleQuotes() {
        LOGGER.info("getTitleQuotes");
        for (String imdbId : IMDB_IDS) {
            ImdbQuotes result = ImdbApi.getTitleQuotes(imdbId);
            assertNotNull("Title Quotes is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getTitleTrivia method, of class ImdbApi.
     */
    //@Test
    public void testGetTitleTrivia() {
        LOGGER.info("getTitleTrivia");
        for (String imdbId : IMDB_IDS) {
            List<ImdbSpoiler> result = ImdbApi.getTitleTrivia(imdbId);
            assertNotNull("Title Trivia is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getTitlePhotos method, of class ImdbApi.
     */
    //@Test
    public void testGetTitlePhotos() {
        LOGGER.info("getTitlePhotos");
        for (String imdbId : IMDB_IDS) {
            List<ImdbImage> result = ImdbApi.getTitlePhotos(imdbId);
            assertNotNull("Title Photos is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getFullDetails method, of class ImdbApi.
     */
    //@Test
    public void testGetFullDetails() {
        LOGGER.info("getFullDetails");
        for (String imdbId : IMDB_IDS) {
            ImdbMovieDetails result = ImdbApi.getFullDetails(imdbId);
            assertNotNull("Full Details is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getFullCast method, of class ImdbApi.
     */
    //@Test
    public void testGetFullCast() {
        LOGGER.info("getFullCast");
        for (String imdbId : IMDB_IDS) {
            List<ImdbCredit> result = ImdbApi.getFullCast(imdbId);
            assertNotNull("Full Cast is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getSearch method, of class ImdbApi.
     */
    @Test
    public void testGetSearch() {
        LOGGER.info("getSearch");
//        Map<String, List<SearchObject>> result = ImdbApi.getSearch("Avengers");
        Map<String, List<SearchObject>> result = ImdbApi.getSearch("James Dean");

        assertNotNull("Search is empty", result);
        assertTrue("Search has no results", result.size() > 0);
    }

    /**
     * Test of setLocale method, of class ImdbApi.
     */
    //@Test
    public void testSetLocale_Locale() {
        // Not required
    }

    /**
     * Test of setLocale method, of class ImdbApi.
     */
    //@Test
    public void testSetLocale_String() {
        // Not required
    }

    /**
     * Test of setLocale method, of class ImdbApi.
     */
    //@Test
    public void testSetLocale_String_String() {
        // Not required
    }

    /**
     * Test of showVersion method, of class ImdbApi.
     */
    //@Test
    public void testShowVersion() {
        // Not required
    }

    /**
     * Test of getShowtimes method, of class ImdbApi.
     */
    //@Test
    public void testGetShowtimes() {
        LOGGER.info("getShowtimes - Not tested");
    }

    /**
     * Test of getBoxOffice method, of class ImdbApi.
     */
    //@Test
    public void testGetBoxOffice() {
        LOGGER.info("getBoxOffice");
        List<ImdbBoxOffice> result = ImdbApi.getBoxOffice();
        assertFalse("BoxOffice is empty", result.isEmpty());
    }

    /**
     * Test of getTitlePlot method, of class ImdbApi.
     */
    //@Test
    public void testGetTitlePlot() {
        LOGGER.info("getTitlePlot");
        for (String imdbId : IMDB_IDS) {
            List<ImdbPlot> result = ImdbApi.getTitlePlot(imdbId);
            assertNotNull("Title plot is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getTitleSynopsis method, of class ImdbApi.
     */
    //@Test
    public void testGetTitleSynopsis() {
        LOGGER.info("getTitlePlot");
        for (String imdbId : IMDB_IDS) {
            ImdbSynopsis result = ImdbApi.getTitleSynopsis(imdbId);
            assertNotNull("Title synopsis is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getChartMoviemeter method, of class ImdbApi.
     */
    //@Test
    public void testGetChartMoviemeter() {
        LOGGER.info("getChartMoviemeter");
        List<ImdbChartMoviemeter> result = ImdbApi.getChartMoviemeter();
        assertFalse("Chart Moviemeter is empty", result.isEmpty());
    }

    /**
     * Test of getChartStarmeter method, of class ImdbApi.
     */
    //@Test
    public void testGetChartStarmeter() {
        LOGGER.info("getChartStarmeter");
        List<ImdbChartStarmeter> result = ImdbApi.getChartStarmeter();
        assertFalse("Chart Starmeter is empty", result.isEmpty());
    }
}
