package NewcastleConnections.Authentication;

import com.auth0.SessionUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;


public class AuthenticationInterceptor extends AbstractInterceptor {

    public static final String LOGIN = "login";

    public String intercept(ActionInvocation invocation) throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();

        String accessToken = (String) SessionUtils.get(request, "accessToken");
        String idToken = (String) SessionUtils.get(request, "idToken");
        if (accessToken == null && idToken == null) {

            return LOGIN;
        }

        return invocation.invoke();
    }
}
