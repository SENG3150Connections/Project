package NewcastleConnections.Authentication;

/*
ManagementInterceptor.java
Author: Seb Brown

Description:
    Get the AuthenticationController for our auth0 account.
*/

import com.auth0.AuthenticationController;

public class AuthenticationControllerProvider {

    // -- Public Static --
    //   Role: Get the AuthenticationController for our auth0 account.
    //
    public static AuthenticationController getInstance() {
        String domain = "team1.au.auth0.com";
        String clientId = "HKpOX9JEWIRKx5CHcPBllJj1draI5ppD";
        String clientSecret = "mjBNj2NzL-f9CaqTrq7x8YUNRqZqrqrF3qwm0lYdcn7v8FItRjUUVm6E6SAIRbPH";

        return AuthenticationController.newBuilder(domain, clientId, clientSecret).build();
    }
}
