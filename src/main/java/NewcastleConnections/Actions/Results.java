package NewcastleConnections.Actions;

import NewcastleConnections.DatabaseConnection;
import com.opensymphony.xwork2.ActionSupport;
import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import org.jooq.Result;

import static NewcastleConnections.packagedeals.Tables.*;


/**
 * Created by seb on 1/8/17.
 */
public class Results extends ActionSupport {


    // Results property (to be shared with the JSP page)
    private Result<HotelsRecord> results;

    public Result<HotelsRecord> getResults() {


        try {

            // Get connection
            DatabaseConnection connection = new DatabaseConnection();

            // query
            Result<HotelsRecord> results = connection.getDSL().selectFrom(HOTELS).fetch();

            this.results = results;

            // Close connection
            connection.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return results;
    }



    @Override
    public String execute() throws Exception {


        // Return Success
        return SUCCESS;
    }


}
