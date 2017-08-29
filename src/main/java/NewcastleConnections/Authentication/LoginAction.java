package NewcastleConnections.Authentication;

/*
LoginAction.java
Author: Seb Brown / Scott Walker

Description:
    Redirect the user to the auth0 login page when accessing /login
*/

import com.auth0.AuthenticationController;
import com.auth0.SessionUtils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends ActionSupport {

    // -- Public --
    //   Role: Implement the execute method for the action. Redirect to auth0.
    // Return: Result string for struts.xml to process.
    //
    @Override
    public String execute() {

        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpServletResponse response = ServletActionContext.getResponse();

            /* Awkward fix for a weird caveat of Auth0 where the port number is needed for local instances
            but not for instances running on Heroku. */
            String redirectUri;
            if (request.getServerPort() != 80) {
                // Local instance
                redirectUri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/callback";
            } else {
                // Deployed to Heroku or Server, discard the port number
                redirectUri = request.getScheme() + "://" + request.getServerName() + "/callback";
            }

            AuthenticationController authenticationController = AuthenticationControllerProvider.getInstance();
            String authorizeUrl = authenticationController.buildAuthorizeUrl(request, redirectUri).build();

            // Store the page the user has just come from as a session attribute, so we can go back there after auth.
            String referer = request.getHeader("referer");
            SessionUtils.set(request, "authSourceUrl", referer.substring(referer.lastIndexOf("/") + 1));

            response.sendRedirect(authorizeUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }
}
