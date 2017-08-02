package NewcastleConnections.Authentication;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutAction extends ActionSupport {

    @Override
    public String execute() {

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        if (request.getSession() != null) {
            request.getSession().invalidate();
        }
        try {
            response.sendRedirect("/login");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }
}
