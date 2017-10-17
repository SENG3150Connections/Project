package NewcastleConnections.Authentication;

/*
ManagementInterceptor.java
Author: Scott Walker

Description:
    Interceptor for accessing the management portal pages. If user is not admin,
    they will be redirected back to the home pages.
*/

import com.auth0.SessionUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class ManagementInterceptor extends AbstractInterceptor {

    // Static return strings.
    public static final String LOGIN = "login"; // Not logged in at all
    public static final String DENIED = "denied"; // Logged in but not the correct role

    // -- Public --
    //   Role: Implement intercept method. Check if user is logged in as an admin.
    // Return: Result string for struts.xml to process.
    //
    public String intercept(ActionInvocation invocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();

        // Get tokens
        String accessToken = (String) SessionUtils.get(request, "accessToken");
        String idToken = (String) SessionUtils.get(request, "idToken");

        // No tokens from auth0, must not be logged in.
        if (accessToken == null && idToken == null)
            return LOGIN;

        // Check if role is admin role
        String role = SessionUtils.get(request, "userPermissions").toString();
        if (!role.equals("1"))
            return DENIED;

        // User is an admin, allow access and continue invocation chain.
        return invocation.invoke();
    }
}
