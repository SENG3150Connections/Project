package NewcastleConnections.Authentication;

import com.auth0.AuthenticationController;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Scott on 20/10/2017.
 */
public class AuthenticationControllerProviderTest extends StrutsJUnit4TestCase<AuthenticationControllerProvider> {

    @Test
    public void getInstance() throws Exception {
        String redirectUri;
        if (request.getServerPort() != 80) {
            // Local instance
            redirectUri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/callback";
        } else {
            // Deployed to Heroku or Server, discard the port number
            redirectUri = request.getScheme() + "://" + request.getServerName() + "/callback";
        }

        AuthenticationController auth = AuthenticationControllerProvider.getInstance();
        String authorizeUrl = auth.buildAuthorizeUrl(request, redirectUri).build();

        String[] urlParts = authorizeUrl.split("\\?");
        assertEquals("Domains match", urlParts[0], "https://team1.au.auth0.com/authorize");
    }

}