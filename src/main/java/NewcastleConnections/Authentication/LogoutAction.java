package NewcastleConnections.Authentication;

/*
LogoutAction.java
Author: Seb Brown

Description:
    Invalidate session when user logs out
*/

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;

public class LogoutAction extends ActionSupport {

    // -- Public --
    //   Role: Implement the execute method for the action. Nullify the current users session.
    // Return: Result string for struts.xml to process.
    //
    @Override
    public String execute() {
        // Get current session
        SessionMap session = (SessionMap) ActionContext.getContext().getSession();

        // Invalidate the session
        session.invalidate();

        // Renew servlet session
        session.put("renewServletSession", null);
        session.remove("renewServletSession");
        // Populate the struts session
        session.entrySet();

        return SUCCESS;
    }
}
