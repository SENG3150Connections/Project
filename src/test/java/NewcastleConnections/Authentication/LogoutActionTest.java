package NewcastleConnections.Authentication;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.apache.struts2.dispatcher.SessionMap;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Scott on 9/10/2017.
 */
public class LogoutActionTest extends StrutsJUnit4TestCase<LogoutAction> {

    @Test
    public void execute() throws Exception {
        // Set user session
        ActionContext.getContext().put(ActionContext.SESSION, new SessionMap(request));

        // Check initial session is not null
        SessionMap session = (SessionMap) ActionContext.getContext().getSession();
        session.put("test", "test");
        assertTrue("Session is not initially empty", session.size() > 0);

        // Perform the action
        ActionProxy proxy = getActionProxy("/logout.action");
        proxy.getInvocation().getInvocationContext().setSession(session);
        proxy.execute();

        // Session should now return null
        session = (SessionMap) ActionContext.getContext().getSession();
        assertTrue("Session is now empty", session.size() == 0);
    }

}