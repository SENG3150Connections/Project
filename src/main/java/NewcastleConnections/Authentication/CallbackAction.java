package NewcastleConnections.Authentication;

import com.auth0.AuthenticationController;
import com.auth0.IdentityVerificationException;
import com.auth0.SessionUtils;
import com.auth0.Tokens;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.jooq.util.derby.sys.Sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CallbackAction extends ActionSupport {

    private String redirectOnSuccess;
    private String redirectOnFail;
    private AuthenticationController authenticationController;

    @Override
    public String execute() {


        redirectOnSuccess = "/home";
        redirectOnFail = "/login";

        try {
            authenticationController = AuthenticationControllerProvider.getInstance();

            HttpServletRequest request = ServletActionContext.getRequest();
            HttpServletResponse response = ServletActionContext.getResponse();


            handle(request, response);


        } catch (Exception e) {

        }


        return SUCCESS;
    }


    private void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Tokens tokens = authenticationController.handle(request);
            SessionUtils.set(request, "accessToken", tokens.getAccessToken());
            SessionUtils.set(request, "idToken", tokens.getIdToken());
            response.sendRedirect(redirectOnSuccess);
        } catch (IdentityVerificationException e) {
            e.printStackTrace();
            response.sendRedirect(redirectOnFail);
        }
    }
}
