package NewcastleConnections.Session;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.DefaultActionProxy;

/**
 * Created by Scott on 14/08/2017.
 */
public class ActionProxy extends DefaultActionProxy {

    protected ActionProxy(ActionInvocation inv, String namespace, String actionName, String methodName, boolean executeResult, boolean cleanupContext) {
        super(inv, namespace, actionName, methodName, executeResult, cleanupContext);
    }

    @Override
    protected void prepare() {
        super.prepare();
    }
}