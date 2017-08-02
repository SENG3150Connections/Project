package NewcastleConnections.Authentication;

import com.auth0.AuthenticationController;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

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


           // String redirectUri = request.getScheme() + "://" + request.getServerName() + "/callback";
                String redirectUri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/callback";

            String authorizeUrl = authenticationController.buildAuthorizeUrl(request, redirectUri).build();

            response.sendRedirect(authorizeUrl);
        } catch (Exception e) {

        }

        return SUCCESS;
    }

}
