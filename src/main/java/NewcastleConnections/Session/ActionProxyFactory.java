package NewcastleConnections.Session;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.DefaultActionProxyFactory;

/**
 * Created by Scott on 14/08/2017.
 */
public class ActionProxyFactory extends DefaultActionProxyFactory {

    public ActionProxyFactory() {
        super();
    }

    @Override
    public com.opensymphony.xwork2.ActionProxy createActionProxy(ActionInvocation inv, String namespace, String actionName, String methodName, boolean executeResult, boolean cleanupContext) {

        ActionProxy proxy = new ActionProxy(inv, namespace, actionName, methodName, executeResult, cleanupContext);
        container.inject(proxy);
        container.setScopeStrategy(new ScopeStrategy());
        proxy.prepare();
        return proxy;
    }
}