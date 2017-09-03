package NewcastleConnections.Authentication;

/*
ManagementInterceptor.java
Author: Seb Brown

Description:
    Checks if user is authenticated with auth0
*/

import com.auth0.SessionUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationInterceptor extends AbstractInterceptor {

    // Static return string
    public static final String LOGIN = "login"; // Not logged in

    // -- Public --
    //   Role: Implement intercept method. Check if user is logged in.
    // Return: Result string for struts.xml to process.
    //
    public String intercept(ActionInvocation invocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();

        String accessToken = (String) SessionUtils.get(request, "accessToken");
        String idToken = (String) SessionUtils.get(request, "idToken");

        if (accessToken == null || idToken == null) {
            return LOGIN;
        }

        // User is logged in, continue invocation chain.
        return invocation.invoke();
    }
}
