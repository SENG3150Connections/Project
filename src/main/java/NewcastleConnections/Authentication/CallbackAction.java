package NewcastleConnections.Authentication;

/*
ManagementInterceptor.java
Author: Seb Brown

Description:
    Store all appropriate user info retrieved from auth0 in the local session upon login.
*/

import NewcastleConnections.DatabaseConnection;
import com.auth0.AuthenticationController;
import com.auth0.InvalidRequestException;
import com.auth0.SessionUtils;
import com.auth0.Tokens;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.jooq.Result;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import NewcastleConnections.packagedeals.tables.records.UsersRecord;

import static NewcastleConnections.packagedeals.Tables.*;

public class CallbackAction extends ActionSupport {

    // Static return strings
    public static final String LOGIN = "login";

    private AuthenticationController authenticationController;

    // -- Public --
    //   Role: Implement the execute method for the action.
    // Return: Result string for struts.xml to process.
    //
    @Override
    public String execute() {
        try {
            // Get Servlet objects
            authenticationController = AuthenticationControllerProvider.getInstance();
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpServletResponse response = ServletActionContext.getResponse();

            // Return the code that handle returns.
            return handle(request, response);
        } catch (Exception e) {
            // Something went wrong, return to login.
            e.printStackTrace();
            return LOGIN;
        }
    }

    // -- Public --
    //   Role: Store the user info in the session and database if user doesn't exist yet.
    // Return: Result string for struts.xml to process.
    //
    private String handle(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // Set initial tokens
        try {
            Tokens tokens = authenticationController.handle(request);
            SessionUtils.set(request, "accessToken", tokens.getAccessToken());
            SessionUtils.set(request, "idToken", tokens.getIdToken());

            // Now parse the string to a json object and get the value of role attribute (if it exists)
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(getUserInfo(tokens.getAccessToken()));

            // Now store user data as session attributes to be referenced.
            SessionUtils.set(request, "userId", json.get("user_id"));
            SessionUtils.set(request, "userNickname", json.get("nickname"));
            SessionUtils.set(request, "userEmail", json.get("email"));

            // Check to see if there is a user in the DB with a matching ID
            DatabaseConnection connection = new DatabaseConnection();
            Result<UsersRecord> users = connection.getDSL().selectFrom(USERS).where("userId= '" + json.get("user_id") + "'").fetch();

            // If there is not, store one.
            if (users.isEmpty()) {
                UsersRecord newUser = new UsersRecord();
                connection.getDSL().attach(newUser);

                newUser.setUserid(json.get("user_id").toString());
                newUser.setEmail(json.get("email").toString());
                // Could potentially store more statistics here if required.
                newUser.store();
            }
            connection.close();

            // Store role as session attribute, else "0" if undefined.
            String role = "0";
            if (json.get("role") != null) {
                role = json.get("role").toString();
            }
            SessionUtils.set(request, "userPermissions", role);

            if (role.equals("1")) { // If admin, redirect to management portal upon login
                response.sendRedirect("managementPortal");
            } else { // Else redirect back to the page they were on.
                response.sendRedirect(SessionUtils.get(request, "authSourceUrl").toString());
            }
        } catch (InvalidRequestException e) {
            return LOGIN;
        }

        return SUCCESS;
    }

    // -- Public --
    //   Role: Read in user info from auth0
    //   Args: Our auth0 access token.
    // Return: The user info.
    //
    private String getUserInfo(String accessToken) {
        String output = "";

        try {
            URL url = new URL("https://team1.au.auth0.com/userinfo");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Bearer " + accessToken);
            InputStream content = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(content));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                output += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return output;
    }
}
