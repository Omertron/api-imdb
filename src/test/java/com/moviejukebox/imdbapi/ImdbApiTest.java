/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviejukebox.imdbapi;

import com.moviejukebox.imdbapi.model.*;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author stuart.boston
 */
public class ImdbApiTest {

    private static final Logger LOGGER = Logger.getLogger(ImdbApiTest.class);
    private static final String MOVIE_ID = "tt0848228";   // Avengers
    private static final String TV_ID = "tt0898266";  // The Big Bang Theory
    private static final String ACTOR_ID = "nm0000148";  // Harrison Ford

    public ImdbApiTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ImdbApi.showVersion();
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
     * Test of getShowtimes method, of class ImdbApi.
     */
//    @Test
//    public void testGetShowtimes() {
//        LOGGER.info("getShowtimes");
//        String location = "";
//        Date date = new Date();
//        String expResult = "";
//        String result = ImdbApi.getShowtimes(location, date);
//        LOGGER.info("Result: " + result);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of getParentalGuide method, of class ImdbApi.
     */
    @Test
    public void testGetParentalGuide() {
        LOGGER.info("getParentalGuide");
        List<ImdbText> result = ImdbApi.getParentalGuide(MOVIE_ID);
        assertFalse("Parental guide list is empty", result.isEmpty());
    }
    /**
     * Test of getUserReviews method, of class ImdbApi.
     */
    @Test
    public void testGetUserReviews() {
        LOGGER.info("getUserReviews");
        List<ImdbUserComment> result = ImdbApi.getUserReviews(MOVIE_ID);
        assertFalse("User reviews is empty", result.isEmpty());
    }
    /**
     * Test of getExternalReviews method, of class ImdbApi.
     */
    @Test
    public void testGetExternalReviews() {
        LOGGER.info("getExternalReviews");
        List<ImdbReview> result = ImdbApi.getExternalReviews(MOVIE_ID);
        assertFalse("External reviews is empty", result.isEmpty());
    }
    /**
     * Test of getComingSoon method, of class ImdbApi.
     */
    @Test
    public void testGetComingSoon() {
        LOGGER.info("getComingSoon");
        List<ImdbList> result = ImdbApi.getComingSoon();

        assertFalse("Coming soon is empty", result.isEmpty());
    }
    /**
     * Test of getTop250 method, of class ImdbApi.
     */
    @Test
    public void testGetTop250() {
        LOGGER.info("getTop250");
        List<ImdbList> result = ImdbApi.getTop250();
        assertFalse("Top250 is empty", result.isEmpty());
    }
    /**
     * Test of getBottom100 method, of class ImdbApi.
     */
    @Test
    public void testGetBottom100() {
        LOGGER.info("getBottom100");
        List<ImdbList> result = ImdbApi.getBottom100();
        assertFalse("Bottom100 is empty", result.isEmpty());
    }
    /**
     * Test of getActorQuotes method, of class ImdbApi.
     */
    @Test
    public void testGetActorQuotes() {
        LOGGER.info("getActorQuotes");
        List<String> result = ImdbApi.getActorQuotes(ACTOR_ID);
        assertFalse("Actor Quotes is empty", result.isEmpty());
    }
    /**
     * Test of getActorTrivia method, of class ImdbApi.
     */
    @Test
    public void testGetActorTrivia() {
        LOGGER.info("getActorTrivia");
        List<ImdbText> result = ImdbApi.getActorTrivia(ACTOR_ID);
        assertFalse("Actor Trivia is empty", result.isEmpty());
    }
    /**
     * Test of getActorFilmography method, of class ImdbApi.
     */
    @Test
    public void testGetActorFilmography() {
        LOGGER.info("getActorFilmography");
        List<ImdbFilmography> result = ImdbApi.getActorFilmography(ACTOR_ID);
        assertFalse("Actor Filmography is empty", result.isEmpty());
    }
    /**
     * Test of getActorDetails method, of class ImdbApi.
     */
    @Test
    public void testGetActorDetails() {
        LOGGER.info("getActorDetails");
        ImdbPerson result = ImdbApi.getActorDetails(ACTOR_ID);
        assertNotNull("Actor Details is empty", result);

    }
    /**
     * Test of getTitleEpisodes method, of class ImdbApi.
     */
    @Test
    public void testGetTitleEpisodes() {
        LOGGER.info("getTitleEpisodes");
        List<ImdbSeason> result = ImdbApi.getTitleEpisodes(TV_ID);
        assertNotNull("Title Episodes is empty", result);
    }
    /**
     * Test of getTitleGoofs method, of class ImdbApi.
     */
    @Test
    public void testGetTitleGoofs() {
        LOGGER.info("getTitleGoofs");
        List<ImdbSpoiler> result = ImdbApi.getTitleGoofs(MOVIE_ID);
        assertNotNull("Title Goofs is empty", result);
    }
    /**
     * Test of getTitleQuotes method, of class ImdbApi.
     */
    @Test
    public void testGetTitleQuotes() {
        LOGGER.info("getTitleQuotes");
        ImdbQuotes result = ImdbApi.getTitleQuotes(MOVIE_ID);
        assertNotNull("Title Quotes is empty", result);
    }
    /**
     * Test of getTitleTrivia method, of class ImdbApi.
     */
    @Test
    public void testGetTitleTrivia() {
        LOGGER.info("getTitleTrivia");
        List<ImdbSpoiler> result = ImdbApi.getTitleTrivia(MOVIE_ID);
        assertNotNull("Title Trivia is empty", result);
    }
    /**
     * Test of getTitlePhotos method, of class ImdbApi.
     */
    @Test
    public void testGetTitlePhotos() {
        LOGGER.info("getTitlePhotos");
        List<ImdbImage> result = ImdbApi.getTitlePhotos(MOVIE_ID);
        assertNotNull("Title Photos is empty", result);
    }
    /**
     * Test of getFullDetails method, of class ImdbApi.
     */
    @Test
    public void testGetFullDetails() {
        LOGGER.info("getFullDetails");
        ImdbMovieDetails result = ImdbApi.getFullDetails(MOVIE_ID);
        assertNotNull("Full Details is empty", result);
    }
    /**
     * Test of getFullCast method, of class ImdbApi.
     */
    @Test
    public void testGetFullCast() {
        LOGGER.info("getFullCast");
        List<ImdbCredit> result = ImdbApi.getFullCast(MOVIE_ID);
        assertNotNull("Full Cast is empty", result);
    }
    /**
     * Test of getSearch method, of class ImdbApi.
     */
    @Test
    public void testGetSearch() {
        LOGGER.info("getSearch");
        Map<String, List<SearchObject>> result = ImdbApi.getSearch("Avengers");

        assertNotNull("Search is empty", result);
        assertTrue("Search has no results", result.size() > 0);
    }
}
