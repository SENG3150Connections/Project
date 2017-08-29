package NewcastleConnections.Authentication;

import com.auth0.SessionUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class ManagementInterceptor extends AbstractInterceptor {

    public static final String LOGIN = "login";
    public static final String DENIED = "denied";

    public String intercept(ActionInvocation invocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();

        String accessToken = (String) SessionUtils.get(request, "accessToken");
        String idToken = (String) SessionUtils.get(request, "idToken");

        if (accessToken == null && idToken == null)
            return LOGIN;

        System.out.println(SessionUtils.get(request, "userPermissions"));
        String role = SessionUtils.get(request, "userPermissions").toString();

        if (!role.equals("1"))
            return DENIED;

        return invocation.invoke();
    }
}
