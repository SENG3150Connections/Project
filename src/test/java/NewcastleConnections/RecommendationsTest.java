package NewcastleConnections;

import NewcastleConnections.packagedeals.tables.records.ExperiencesRecord;
import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import NewcastleConnections.packagedeals.tables.records.ResturantsRecord;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Scott on 25/10/2017.
 */
public class RecommendationsTest {

    private static final double LATITUDE = -32.92715;
    private static final double LONGITUDE = 151.77647;

    @Test
    public void testNoRecommendation() throws Exception {
        Recommendations rec = new Recommendations();
        assertTrue("Empty result set", rec.getRecommendedItem() == 0);
        int eSize = rec.getExperiences().size();
        int hSize = rec.getHotels().size();
        int rSize = rec.getRestaurants().size();
        assertEquals("Empty result set", eSize, 0);
        assertEquals("Empty result set", hSize, 0);
        assertEquals("Empty result set", rSize, 0);
    }

    @Test
    public void testZeroCoords() throws Exception {
        int results = 0;
        testExperience(0, 0, results);
        testHotel(0, 0, results);
        testRestaurant(0, 0, results);
    }

    @Test
    public void testZeroCoordsResultsPositive() throws Exception {
        int results = 2;
        testExperience(0, 0, results);
        testHotel(0, 0, results);
        testRestaurant(0, 0, results);
    }

    @Test
    public void testZeroResults() throws Exception {
        int results = 0;
        testExperience(LONGITUDE, LATITUDE, results);
        testHotel(LONGITUDE, LATITUDE, results);
        testRestaurant(LONGITUDE, LATITUDE, results);
    }

    @Test
    public void testResultsPositive() throws Exception {
        int results = 2;
        testExperience(LONGITUDE + 0.5, LATITUDE, results);
        testHotel(LONGITUDE, LATITUDE + 0.5, results);
        testRestaurant(LONGITUDE, LATITUDE, results);
    }

    public void testExperience(double longitude, double latitude, int numberOfResults) {
        ExperiencesRecord exp = new ExperiencesRecord();
        exp.setLongitude(longitude);
        exp.setLatitude(latitude);

        Recommendations rec = new Recommendations(exp, numberOfResults);
        testWithParams(rec, numberOfResults);
    }

    public void testHotel(double longitude, double latitude, int numberOfResults) {
        HotelsRecord hotel = new HotelsRecord();
        hotel.setLongitude(longitude);
        hotel.setLatitude(latitude);

        Recommendations rec = new Recommendations(hotel, numberOfResults);
        testWithParams(rec, numberOfResults);
    }

    public void testRestaurant(double longitude, double latitude, int numberOfResults) {
        ResturantsRecord restaurant = new ResturantsRecord();
        restaurant.setLongitude(longitude);
        restaurant.setLatitude(latitude);

        Recommendations rec = new Recommendations(restaurant, numberOfResults);
        testWithParams(rec, numberOfResults);
    }

    public void testWithParams(Recommendations rec, int numberOfResults) {
        int i = rec.getRecommendedItem();
        assertTrue("Recommended item between 0 and 2", i >= 0 && i <= 2);

        int eSize = rec.getExperiences().size();
        int hSize = rec.getHotels().size();
        int rSize = rec.getRestaurants().size();

        // Can return less results if not enough hotels, etc
        assertTrue("Experience result size matches", numberOfResults >= eSize);
        assertTrue("Hotel result size matches", numberOfResults >= hSize);
        assertTrue("Restaurant result size matches", numberOfResults >= rSize);
    }

}