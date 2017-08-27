package NewcastleConnections.Actions;

import NewcastleConnections.Cart.Cart;
import NewcastleConnections.Cart.CartHotel;
import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.ExperiencesRecord;
import NewcastleConnections.packagedeals.tables.records.ResturantsRecord;
import NewcastleConnections.packagedeals.tables.records.TransportRecord;
import com.opensymphony.xwork2.ActionSupport;
import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import com.opensymphony.xwork2.inject.Inject;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import java.sql.SQLException;
import java.util.LinkedList;

import static NewcastleConnections.packagedeals.Tables.*;

public class Results extends ActionSupport {

    // Results property (to be shared with the JSP page)
    private Result<HotelsRecord> hotels;
    private Result<ResturantsRecord> restaurants;
    private Result<ExperiencesRecord> experiences;
    private Result<TransportRecord> transport;

    public LinkedList recommendedHotels;
    public LinkedList recommendedRestaurants;
    public LinkedList recommendedExperiences;
    int recommendedItem = (int)(Math.random() * 3);

    private int hotelCount;
    private int restaurantCount;
    private int experienceCount;
    private int transportCount;
    private int totalCount;
    private Cart cart;

    // URL bar properties
    private String search;
    private String start;
    private String finish;
    private int people;

    @Override
    public String execute() {
        try {
            // Get connection
            DatabaseConnection connection = new DatabaseConnection();
            DSLContext dsl = connection.getDSL();

            // query
            if (search == null || search.isEmpty()) {
                hotels = dsl.selectFrom(HOTELS).fetch();
                restaurants = dsl.selectFrom(RESTURANTS).fetch();
                experiences = dsl.selectFrom(EXPERIENCES).fetch();
                transport = dsl.selectFrom(TRANSPORT).fetch();
            } else {
                String like = "%"+search+"%";
                hotels = dsl.selectFrom(HOTELS).where(HOTELS.NAME.likeIgnoreCase(like)).fetch();
                restaurants = dsl.selectFrom(RESTURANTS).where(RESTURANTS.NAME.likeIgnoreCase(like)).fetch();
                experiences = dsl.selectFrom(EXPERIENCES).where(EXPERIENCES.NAME.likeIgnoreCase(like)).fetch();
                transport = dsl.selectFrom(TRANSPORT).where(TRANSPORT.NAME.likeIgnoreCase(like)).fetch();
            }

            // Close connection
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ERROR;
        }

        hotelCount = hotels.size();
        restaurantCount = restaurants.size();
        experienceCount = experiences.size();
        transportCount = transport.size();

        totalCount = hotelCount + restaurantCount + experienceCount + transportCount;


        // Recommendations

        if (cart.getHotels().size() != 0) {

            HotelsRecord hotel = cart.getHotels().get(cart.getHotels().size()-1).getHotel();
            generateRecommendations(hotel.getLongitude(),hotel.getLatitude(),2);

        } else if (cart.getExperiences().size() != 0) {

            ExperiencesRecord experience = cart.getExperiences().get(cart.getExperiences().size()-1).getExperience();
            generateRecommendations(experience.getLongitude(),experience.getLatitude(),2);

        } else if (cart.getRestaurants().size() != 0) {

            ResturantsRecord resturant = cart.getRestaurants().get(cart.getRestaurants().size()-1).getRestaurant();
            generateRecommendations(resturant.getLongitude(),resturant.getLatitude(),2);
        }

        // Return Success
        return SUCCESS;
    }

    private void generateRecommendations(double searchLongitude, double searchLattitude, int numberOfResults) {

        try {


            DatabaseConnection connection = new DatabaseConnection();

            Result<HotelsRecord> hotels = connection.getDSL().selectFrom(HOTELS).fetch();
            Result<ResturantsRecord> restaurants = connection.getDSL().selectFrom(RESTURANTS).fetch();
            Result<ExperiencesRecord> experiences = connection.getDSL().selectFrom(EXPERIENCES).fetch();
            Result<TransportRecord> transport = connection.getDSL().selectFrom(TRANSPORT).fetch();




            // Do some geometry and calculate how close records are to input coordinates.

            // Each linked list element is a 2-tuple, it contains a distance double and a database record.

            LinkedList<LinkedList> distances_hotels = new LinkedList();
            LinkedList<LinkedList>  distances_restaurants = new LinkedList();
            LinkedList<LinkedList>  distances_experiences = new LinkedList();
            LinkedList<LinkedList>  distances_transport = new LinkedList();

            for (Record record : hotels) {

                LinkedList row = new LinkedList();
                row.add(calculateHypotenuse(searchLongitude,
                        record.getValue(HOTELS.LONGITUDE),
                        searchLattitude,
                        record.getValue(HOTELS.LATITUDE)));
                row.add(record);
                distances_hotels.add(row);
            }

            for (Record record : restaurants) {

                LinkedList row = new LinkedList();
                row.add(calculateHypotenuse(searchLongitude,
                        record.getValue(RESTURANTS.LONGITUDE),
                        searchLattitude,
                        record.getValue(RESTURANTS.LATITUDE)));
                row.add(record);
                distances_restaurants.add(row);
            }

            for (Record record : experiences) {

                LinkedList row = new LinkedList();
                row.add(calculateHypotenuse(searchLongitude,
                        record.getValue(EXPERIENCES.LONGITUDE),
                        searchLattitude,
                        record.getValue(EXPERIENCES.LATITUDE)));
                row.add(record);
                distances_experiences.add(row);
            }


            // Sort the results by proximity to input coordinate


            distances_hotels = mSort(distances_hotels);
            distances_restaurants = mSort(distances_restaurants);
            distances_experiences = mSort(distances_experiences);


            // Now extract the top results.
            recommendedHotels = new LinkedList();
            recommendedRestaurants = new LinkedList();
            recommendedExperiences = new LinkedList();


            for (int i = 0; i < numberOfResults; i++) {
                if (i <= distances_hotels.size()) {
                    recommendedHotels.add(distances_hotels.get(i).get(1));
                }
            }
            for (int i = 0; i < numberOfResults; i++) {
                if (i <= distances_restaurants.size()) {
                    recommendedRestaurants.add(distances_restaurants.get(i).get(1));
                }
            }
            for (int i = 0; i < numberOfResults; i++) {
                if (i <= distances_experiences.size()) {
                    recommendedExperiences.add(distances_experiences.get(i).get(1));
                }
            }



            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private double calculateHypotenuse(double x0, double x1, double y0, double y1) {

        return Math.sqrt( Math.pow((Math.abs(x1 - x0)),2) + Math.pow((Math.abs(y1 - y0)),2) );

    }


    /**
     * Sorting functions (MergeSort)
     */


    private LinkedList<LinkedList> mSort(LinkedList list) {

        int n = list.size(); // n = cardinality of input set
        if (n == 1) { // if there is only one element, return it, there's nothing to sort.
            return list;
        } else {
            int m = n/2; // Get the middle index of the input set
            LinkedList l1 = new LinkedList();
            LinkedList l2 = new LinkedList();
            for (int i = 0; i < m; i++ ) { //populate l1 so that it equals the first half of the input set
                l1.add(list.get(i));
            }
            for (int j = m; j < list.size(); j++ ) { //populate l2 so that it equals the second half of the input set
                l2.add(list.get(j));
            }
            l1 = mSort(l1); // split l1 again
            l2 = mSort(l2); // split l2 again.
            return merge(l1,l2); // merge l1 and l2 together
        }
    }

    private LinkedList merge(LinkedList<LinkedList> l1, LinkedList<LinkedList> l2) {
        if (l1.isEmpty()) { // if l1 is empty, return l2, we're done
            return l2;
        } else if (l2.isEmpty()) { // if l2 is empty, return l1, we're done
            return l1;
        } else {
            // if the first element of l1 <= first element of l2
            if ((double)l1.getFirst().get(0) <= (double)l2.getFirst().get(0)) {
                LinkedList first = l1.getFirst(); // Take the first element
                l1.removeFirst();
                LinkedList l = merge(l1,l2); // merge both sets minus first
                l.addFirst(first); // add first back to l
                return l;
            } else {
                LinkedList first = l2.getFirst();
                l2.removeFirst();
                LinkedList l = merge(l1,l2);
                l.addFirst(first);
                return l;
            }
        }
    }


    public Result<HotelsRecord> getHotels() {
        return hotels;
    }

    public Result<ResturantsRecord> getRestaurants() {
        return restaurants;
    }

    public Result<ExperiencesRecord> getExperiences() {
        return experiences;
    }

    public Result<TransportRecord> getTransport() {
        return transport;
    }

    public int getHotelCount() {
        return hotelCount;
    }

    public int getRestaurantCount() {
        return restaurantCount;
    }

    public int getExperienceCount() {
        return experienceCount;
    }

    public int getTransportCount() {
        return transportCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public Cart getCart() {
        return cart;
    }

    @Inject("cart")
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    // URL bar properties

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getRecommendedItem() { return recommendedItem; }

    public LinkedList getRecommendedHotels() { return recommendedHotels; }

    public LinkedList getRecommendedRestaurants() { return recommendedRestaurants; }

    public LinkedList getRecommendedExperiences() { return recommendedExperiences; }
}
