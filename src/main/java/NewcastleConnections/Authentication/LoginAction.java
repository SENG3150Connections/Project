package NewcastleConnections.Authentication;

import com.auth0.AuthenticationController;
import com.auth0.SessionUtils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.jooq.util.derby.sys.Sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by seb on 2/8/17.
 */
public class LoginAction extends ActionSupport {

    private AuthenticationController authenticationController;


    @Override
    public String execute() {

        try {
            authenticationController = AuthenticationControllerProvider.getInstance();

            HttpServletRequest request = ServletActionContext.getRequest();
            HttpServletResponse response = ServletActionContext.getResponse();


           /* Awkward fix for a weird caviat of Auth0 where the port number is needed for local instances
            but not for instances running on Heroku.
                */

            int portNumber = request.getServerPort();
            String redirectUri = "";
            if (portNumber == 8080) {
                // Local instance
                redirectUri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/callback";

            } else {
                // Deployed to Heroku, discard the port number
                redirectUri = request.getScheme() + "://" + request.getServerName() + "/callback";

            }
            String authorizeUrl = authenticationController.buildAuthorizeUrl(request, redirectUri).build();

            // Store the page the user has just come from as a session attribute, so we can go back there after auth.
            String referer = request.getHeader("referer");
            SessionUtils.set(request, "authSourceUrl",  referer.substring(referer.lastIndexOf("/") + 1));



            response.sendRedirect(authorizeUrl);
        } catch (Exception e) {

        }

        return SUCCESS;
    }

}
