package NewcastleConnections;

/*
Recommendations.java
Author: Seb Brown / Scott Walker

Description:
    Generate Recommendations for the user based on their current cart.
*/

import NewcastleConnections.packagedeals.tables.records.ExperiencesRecord;
import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import NewcastleConnections.packagedeals.tables.records.ResturantsRecord;
import org.jooq.Record;
import org.jooq.Result;

import java.sql.SQLException;
import java.util.LinkedList;

import static NewcastleConnections.packagedeals.Tables.*;
import static NewcastleConnections.packagedeals.Tables.EXPERIENCES;

public class Recommendations {

    // Private member data
    private LinkedList hotels;
    private LinkedList restaurants;
    private LinkedList experiences;
    private int recommendedItem;

    // -- Constructor --
    //   Role: Create an empty recommendation set
    //
    public Recommendations() {
        hotels = new LinkedList();
        restaurants = new LinkedList();
        experiences = new LinkedList();
        recommendedItem = 0;
    }

    // -- Constructor --
    //   Role: Create recommendations for a specific record
    //
    public Recommendations(ExperiencesRecord record, int numberOfResults) {
        generateRecommendations(record.getLongitude(), record.getLatitude(), numberOfResults);
    }

    // -- Constructor --
    //   Role: Create recommendations for a specific record
    //
    public Recommendations(HotelsRecord record, int numberOfResults) {
        generateRecommendations(record.getLongitude(), record.getLatitude(), numberOfResults);
    }

    // -- Constructor --
    //   Role: Create recommendations for a specific record
    //
    public Recommendations(ResturantsRecord record, int numberOfResults) {
        generateRecommendations(record.getLongitude(), record.getLatitude(), numberOfResults);
    }

    // -- Private --
    //   Role: Set the private lists to each record in order of recommending.
    //
    private void generateRecommendations(double searchLongitude, double searchLattitude, int numberOfResults) {
        // Which category we will display
        recommendedItem = (int)(Math.random() * 3);

        try {
            // Initialise connection
            DatabaseConnection connection = new DatabaseConnection();

            // Fecth all records
            Result<HotelsRecord> hotels = connection.getDSL().selectFrom(HOTELS).fetch();
            Result<ResturantsRecord> restaurants = connection.getDSL().selectFrom(RESTURANTS).fetch();
            Result<ExperiencesRecord> experiences = connection.getDSL().selectFrom(EXPERIENCES).fetch();

            // Each linked list element is a 2-tuple, it contains a distance double and a database record.
            LinkedList<DistancedRecord> distances_hotels = new LinkedList<>();
            LinkedList<DistancedRecord> distances_restaurants = new LinkedList<>();
            LinkedList<DistancedRecord> distances_experiences = new LinkedList<>();

            // Process hotels into DistancedRecord
            for (Record record : hotels) {
                double dist = calculateHypotenuse(searchLongitude,
                        record.getValue(HOTELS.LONGITUDE),
                        searchLattitude,
                        record.getValue(HOTELS.LATITUDE));
                distances_hotels.add(new DistancedRecord(dist, record));
            }

            // Process restaurants into DistancedRecord
            for (Record record : restaurants) {
                double dist = calculateHypotenuse(searchLongitude,
                        record.getValue(RESTURANTS.LONGITUDE),
                        searchLattitude,
                        record.getValue(RESTURANTS.LATITUDE));
                distances_restaurants.add(new DistancedRecord(dist, record));
            }

            // Process experiences into DistancedRecord
            for (Record record : experiences) {
                double dist = calculateHypotenuse(searchLongitude,
                        record.getValue(EXPERIENCES.LONGITUDE),
                        searchLattitude,
                        record.getValue(EXPERIENCES.LATITUDE));
                distances_experiences.add(new DistancedRecord(dist, record));
            }

            // Sort the results by proximity to input coordinate
            distances_hotels = mSort(distances_hotels);
            distances_restaurants = mSort(distances_restaurants);
            distances_experiences = mSort(distances_experiences);

            // Now extract the top results.
            this.hotels = new LinkedList();
            this.restaurants = new LinkedList();
            this.experiences = new LinkedList();

            // Add all records back into the lists in order of rank, up to the max limit.
            for (int i = 0; i < Math.min(numberOfResults, distances_hotels.size()); i++) {
                this.hotels.add(distances_hotels.get(i).record);
            }
            for (int i = 0; i < Math.min(numberOfResults, distances_restaurants.size()); i++) {
                this.restaurants.add(distances_restaurants.get(i).record);
            }
            for (int i = 0; i < Math.min(numberOfResults, distances_experiences.size()); i++) {
                this.experiences.add(distances_experiences.get(i).record);
            }

            // Close the connections
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    // -- Private --
    //   Role: Calculate 2D distance of 2 points
    //
    private double calculateHypotenuse(double x0, double x1, double y0, double y1) {
        return Math.sqrt(Math.pow((Math.abs(x1 - x0)), 2) + Math.pow((Math.abs(y1 - y0)), 2));
    }

    // -- Getters and Setters --

    public LinkedList getHotels() {
        return hotels;
    }

    public LinkedList getRestaurants() {
        return restaurants;
    }

    public LinkedList getExperiences() {
        return experiences;
    }

    public int getRecommendedItem() {
        return recommendedItem;
    }

    // -- Merge sort functions --

    private LinkedList<DistancedRecord> mSort(LinkedList<DistancedRecord> list) {

        int n = list.size(); // n = cardinality of input set
        if (n == 1) { // if there is only one element, return it, there's nothing to sort.
            return list;
        } else {
            int m = n / 2; // Get the middle index of the input set
            LinkedList<DistancedRecord> l1 = new LinkedList<>();
            LinkedList<DistancedRecord> l2 = new LinkedList<>();
            for (int i = 0; i < m; i++) { //populate l1 so that it equals the first half of the input set
                l1.add(list.get(i));
            }
            for (int j = m; j < list.size(); j++) { //populate l2 so that it equals the second half of the input set
                l2.add(list.get(j));
            }
            l1 = mSort(l1); // split l1 again
            l2 = mSort(l2); // split l2 again.
            return merge(l1, l2); // merge l1 and l2 together
        }
    }

    private LinkedList<DistancedRecord> merge(LinkedList<DistancedRecord> l1, LinkedList<DistancedRecord> l2) {
        if (l1.isEmpty()) { // if l1 is empty, return l2, we're done
            return l2;
        } else if (l2.isEmpty()) { // if l2 is empty, return l1, we're done
            return l1;
        } else {

            DistancedRecord first;
            LinkedList<DistancedRecord> l;
            // if the first element of l1 <= first element of l2
            if (l1.getFirst().distance <= l2.getFirst().distance) {
                first = l1.removeFirst(); // Take the first element
            } else {
                first = l2.removeFirst();
            }
            l = merge(l1, l2); // merge both sets minus first
            l.addFirst(first); // add first back to l
            return l;
        }
    }

    /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
     |  Private inner class DistancedRecord  |
     *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

    private class DistancedRecord {
        private double distance;
        private Object record;

        private DistancedRecord(double distance, Object record) {
            this.distance = distance;
            this.record = record;
        }
    }
}
