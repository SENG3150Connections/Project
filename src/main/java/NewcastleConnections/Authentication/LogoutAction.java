package NewcastleConnections.Authentication;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutAction extends ActionSupport {

    @Override
    public String execute() {

        HttpServletResponse response = ServletActionContext.getResponse();

        // Invalidate the session
        SessionMap session = (SessionMap) ActionContext.getContext().getSession();

        //invalidate
        session.invalidate();
        //renew servlet session
        session.put("renewServletSession", null);
        session.remove("renewServletSession");
        //populate the struts session
        session.entrySet();

        return SUCCESS;
    }
}
