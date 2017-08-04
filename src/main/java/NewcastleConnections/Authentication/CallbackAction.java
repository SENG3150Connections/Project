package NewcastleConnections.Authentication;

import com.auth0.AuthenticationController;
import com.auth0.IdentityVerificationException;
import com.auth0.SessionUtils;
import com.auth0.Tokens;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.jooq.util.derby.sys.Sys;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;


public class CallbackAction extends ActionSupport {

    private String redirectOnFail;
    private AuthenticationController authenticationController;

    @Override
    public String execute() {


        String result = "";

        try {
            authenticationController = AuthenticationControllerProvider.getInstance();

            HttpServletRequest request = ServletActionContext.getRequest();
            HttpServletResponse response = ServletActionContext.getResponse();


            result = handle(request, response);


        } catch (Exception e) {
            e.printStackTrace();
            return "login";
        }


        return result;
    }


    private String handle(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String role = "0";


            Tokens tokens = authenticationController.handle(request);
            SessionUtils.set(request, "accessToken", tokens.getAccessToken());
            SessionUtils.set(request, "idToken", tokens.getIdToken());

            System.out.println(getUserInfo(tokens.getAccessToken()));

            // Now parse the string to a json object and get the value of role attribute (if it exists)
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(getUserInfo(tokens.getAccessToken()));

            System.out.println("JSON" + (json.get("role")));



            if (json.get("role") != null) {

                role = json.get("role").toString();
            }



        return getRedirectOnSuccess(role);
    }


    private String getUserInfo(String accessToken) {
        /**
         *  Code adapted from https://stackoverflow.com/a/3283496/2481192
         *
         */

        String output = "";

        try {
            URL url = new URL ("https://team1.au.auth0.com/userinfo");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty  ("Authorization", "Bearer " + accessToken);
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader bufferedReader   =
                    new BufferedReader (new InputStreamReader(content));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                output += line;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return output;
    }


    private String getRedirectOnSuccess(String userType) {

        // Determine redirect on success based on user type.
        String output = "";

        switch (userType) {

            case "0":
                output = "normal";
                break;
            case "1":
                output = "admin";
                break;

            default:
                output = "normal";
                break;

        }


        return output;
    }
}