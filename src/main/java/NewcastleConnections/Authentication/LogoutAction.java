package NewcastleConnections.Authentication;

/*
LogoutAction.java
Author: Seb Brown, Scott Walker

Description:
    Invalidate session when user logs out
*/

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LogoutAction extends ActionSupport implements SessionAware {

    // -- Private member data --
    private Map<String, Object> session;

    // -- Public --
    //   Role: Implement the execute method for the action. Nullify the current users session.
    // Return: Result string for struts.xml to process.
    //
    @Override
    public String execute() {
        // Get current session
        SessionMap session = (SessionMap) this.session;

        // Invalidate the session
        session.invalidate();

        // Renew servlet session
        session.put("renewServletSession", null);
        session.remove("renewServletSession");
        // Populate the struts session
        session.entrySet();

        return SUCCESS;
    }

    // -- Public --
    //   Role: Set the session map for the current action
    //
    public void setSession(Map<String, Object> map) {
        session = map;
    }
}
