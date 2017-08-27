package NewcastleConnections;

import NewcastleConnections.packagedeals.tables.records.ExperiencesRecord;
import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import NewcastleConnections.packagedeals.tables.records.ResturantsRecord;
import NewcastleConnections.packagedeals.tables.records.TransportRecord;
import org.jooq.Record;
import org.jooq.Result;

import java.sql.SQLException;
import java.util.LinkedList;

import static NewcastleConnections.packagedeals.Tables.*;
import static NewcastleConnections.packagedeals.Tables.EXPERIENCES;


public class Recommendations {


    public LinkedList hotels;
    public LinkedList restaurants;
    public LinkedList experiences;

    public void generateRecommendations(double searchLongitude, double searchLattitude, int numberOfResults) {

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
            this.hotels = new LinkedList();
            this.restaurants = new LinkedList();
            this.experiences = new LinkedList();


            for (int i = 0; i < numberOfResults; i++) {
                if (i <= distances_hotels.size()) {
                    this.hotels.add(distances_hotels.get(i).get(1));
                }
            }
            for (int i = 0; i < numberOfResults; i++) {
                if (i <= distances_restaurants.size()) {
                    this.restaurants.add(distances_restaurants.get(i).get(1));
                }
            }
            for (int i = 0; i < numberOfResults; i++) {
                if (i <= distances_experiences.size()) {
                    this.experiences.add(distances_experiences.get(i).get(1));
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

}