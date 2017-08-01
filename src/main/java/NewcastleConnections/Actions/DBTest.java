package NewcastleConnections.Actions;

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.DatabaseConnectionManager;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by seb on 1/8/17.
 */
public class DBTest extends ActionSupport {


    private String testOutput;

    @Override
    public String execute() {



        return SUCCESS;
    }

    public String getTestOutput() {

        return new DatabaseConnectionManager().test();

    }



}
