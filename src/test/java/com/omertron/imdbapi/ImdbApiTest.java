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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
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
        TestLogger.configure();
        // Pulp Fiction
        IMDB_IDS.add("tt0110912");
        // Avengers
        IMDB_IDS.add("tt0848228");
        // The Big Bang Theory)
        IMDB_IDS.add("tt0898266");

        ACTOR_IDS.add("nm0000148");  // Harrison Ford
        ACTOR_IDS.add("nm0000122");  // Charles Chaplin
    }

    /**
     * Test of getParentalGuide method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetParentalGuide() throws ImdbException {
        LOG.info("getParentalGuide");
        for (String imdbId : IMDB_IDS) {
            List<ImdbText> result = imdbApi.getParentalGuide(imdbId);
            assertFalse("Parental guide list is empty for " + imdbId, result.isEmpty());
        }
    }

    /**
     * Test of getUserReviews method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetUserReviews() throws ImdbException {
        LOG.info("getUserReviews");
        for (String imdbId : IMDB_IDS) {

            List<ImdbUserComment> result = imdbApi.getUserReviews(imdbId);
            assertFalse("User reviews is empty for " + imdbId, result.isEmpty());
        }
    }

    /**
     * Test of getExternalReviews method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetExternalReviews() throws ImdbException {
        LOG.info("getExternalReviews");
        for (String imdbId : IMDB_IDS) {
            List<ImdbReview> result = imdbApi.getExternalReviews(imdbId);
            assertFalse("External reviews is empty for " + imdbId, result.isEmpty());
        }
    }

    /**
     * Test of getComingSoon method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetComingSoon() throws ImdbException {
        LOG.info("getComingSoon");
        List<ImdbList> result = imdbApi.getComingSoon();
        assertFalse("Coming soon is empty", result.isEmpty());
    }

    /**
     * Test of getTop250 method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetTop250() throws ImdbException {
        LOG.info("getTop250");
        List<ImdbList> result = imdbApi.getTop250();
        assertFalse("Top250 is empty", result.isEmpty());
    }

    /**
     * Test of getBottom100 method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetBottom100() throws ImdbException {
        LOG.info("getBottom100");
        List<ImdbList> result = imdbApi.getBottom100();
        assertFalse("Bottom100 is empty", result.isEmpty());
    }

    /**
     * Test of getActorQuotes method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetActorQuotes() throws ImdbException {
        LOG.info("getActorQuotes");
        for (String actorId : ACTOR_IDS) {
            List<String> result = imdbApi.getActorQuotes(actorId);
            assertFalse("Actor Quotes is empty for " + actorId, result.isEmpty());
        }
    }

    /**
     * Test of getActorTrivia method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetActorTrivia() throws ImdbException {
        LOG.info("getActorTrivia");
        for (String actorId : ACTOR_IDS) {
            List<ImdbText> result = imdbApi.getActorTrivia(actorId);
            assertFalse("Actor Trivia is empty for " + actorId, result.isEmpty());
        }
    }

    /**
     * Test of getActorFilmography method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetActorFilmography() throws ImdbException {
        LOG.info("getActorFilmography");
        for (String actorId : ACTOR_IDS) {
            List<ImdbFilmography> result = imdbApi.getActorFilmography(actorId);
            assertFalse("Actor Filmography is empty for " + actorId, result.isEmpty());
        }
    }

    /**
     * Test of getActorDetails method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetActorDetails() throws ImdbException {
        LOG.info("getActorDetails");
        for (String actorId : ACTOR_IDS) {
            ImdbPerson result = imdbApi.getActorDetails(actorId);
            assertNotNull("Actor Details is empty for " + actorId, result);
        }
    }

    /**
     * Test of getTitleEpisodes method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetTitleEpisodes() throws ImdbException {
        LOG.info("getTitleEpisodes");
        for (String imdbId : IMDB_IDS) {
            List<ImdbSeason> result = imdbApi.getTitleEpisodes(imdbId);
            assertNotNull("Title Episodes is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getTitleGoofs method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetTitleGoofs() throws ImdbException {
        LOG.info("getTitleGoofs");
        for (String imdbId : IMDB_IDS) {
            List<ImdbSpoiler> result = imdbApi.getTitleGoofs(imdbId);
            assertNotNull("Title Goofs is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getTitleQuotes method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetTitleQuotes() throws ImdbException {
        LOG.info("getTitleQuotes");
        for (String imdbId : IMDB_IDS) {
            ImdbQuotes result = imdbApi.getTitleQuotes(imdbId);
            assertNotNull("Title Quotes is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getTitleTrivia method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetTitleTrivia() throws ImdbException {
        LOG.info("getTitleTrivia");
        for (String imdbId : IMDB_IDS) {
            List<ImdbSpoiler> result = imdbApi.getTitleTrivia(imdbId);
            assertNotNull("Title Trivia is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getTitlePhotos method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetTitlePhotos() throws ImdbException {
        LOG.info("getTitlePhotos");
        for (String imdbId : IMDB_IDS) {
            List<ImdbImage> result = imdbApi.getTitlePhotos(imdbId);
            assertNotNull("Title Photos is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getFullDetails method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetFullDetails() throws ImdbException {
        LOG.info("getFullDetails");
        for (String imdbId : IMDB_IDS) {
            ImdbMovieDetails result = imdbApi.getFullDetails(imdbId);
            assertNotNull("Full Details is empty for " + imdbId, result);
            LOG.info("Genres: {}", result.getGenres());
        }
    }

    /**
     * Test of getFullCast method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetFullCast() throws ImdbException {
        LOG.info("getFullCast");
        for (String imdbId : IMDB_IDS) {
            List<ImdbCredit> result = imdbApi.getFullCast(imdbId);
            assertNotNull("Full Cast is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getSearch method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Ignore("Not working yet")
    public void testGetSearch() throws ImdbException {
        LOG.info("getSearch");
        Map<String, List<SearchObject>> result = imdbApi.getSearch("James Dean");

        assertNotNull("Search is empty", result);
        assertTrue("Search has no results", result.size() > 0);
    }

    /**
     * Test of setLocale method, of class ImdbApi.
     */
    @Test
    public void testSetLocaleLocale() {
        // Not required
    }

    /**
     * Test of setLocale method, of class ImdbApi.
     */
    @Test
    public void testSetLocaleString() {
        // Not required
    }

    /**
     * Test of setLocale method, of class ImdbApi.
     */
    @Test
    public void testSetLocaleStringString() {
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
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetBoxOffice() throws ImdbException {
        LOG.info("getBoxOffice");
        List<ImdbBoxOffice> result = imdbApi.getBoxOffice();
        assertFalse("BoxOffice is empty", result.isEmpty());
    }

    /**
     * Test of getTitlePlot method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetTitlePlot() throws ImdbException {
        LOG.info("getTitlePlot");
        for (String imdbId : IMDB_IDS) {
            List<ImdbPlot> result = imdbApi.getTitlePlot(imdbId);
            assertNotNull("Title plot is empty for " + imdbId, result);
        }
    }

    /**
     * Test of getTitleSynopsis method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetTitleSynopsis() throws ImdbException {
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
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetChartMoviemeter() throws ImdbException {
        LOG.info("getChartMoviemeter");
        List<ImdbChartMoviemeter> result = imdbApi.getChartMoviemeter();
        assertFalse("Chart Moviemeter is empty", result.isEmpty());
    }

    /**
     * Test of getChartStarmeter method, of class ImdbApi.
     *
     * @throws com.omertron.imdbapi.ImdbException
     */
    @Test
    public void testGetChartStarmeter() throws ImdbException {
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
