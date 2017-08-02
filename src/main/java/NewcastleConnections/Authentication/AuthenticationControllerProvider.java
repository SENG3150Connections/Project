package NewcastleConnections.Authentication;

import com.auth0.AuthenticationController;
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.ServletConfig;
import java.io.UnsupportedEncodingException;

/**
 * Created by seb on 2/8/17.
 */
public class AuthenticationControllerProvider {


    public static AuthenticationController getInstance() {
        String domain = "team1.au.auth0.com";
        String clientId = "HKpOX9JEWIRKx5CHcPBllJj1draI5ppD";
        String clientSecret = "mjBNj2NzL-f9CaqTrq7x8YUNRqZqrqrF3qwm0lYdcn7v8FItRjUUVm6E6SAIRbPH";

        return AuthenticationController.newBuilder(domain, clientId, clientSecret)
                .build();
    }

}
