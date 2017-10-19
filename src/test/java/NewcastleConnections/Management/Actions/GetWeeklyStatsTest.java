package NewcastleConnections.Management.Actions;

import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Scott on 18/10/2017.
 */
public class GetWeeklyStatsTest extends StrutsJUnit4TestCase<GetWeeklyStats> {

    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void testNoParams() throws Exception {
        ActionProxy proxy = getActionProxy("/managementPortal.action");
        GetWeeklyStats action = (GetWeeklyStats) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return SUCCESS", result.equals(ActionSupport.SUCCESS));

        assertTrue("Total sales is positive", action.getGrossSalesTotal() >= 0);
        assertTrue("Net sales is positive", action.getNetSalesTotal() >= 0);
        assertTrue("Total Orders is positive", action.getOrdersPlacedTotal() >= 0);
        assertTrue("Total Items is positive", action.getItemsPurchasedTotal() >= 0);
        assertTrue("Total Refunded is positive", action.getRefundedTotal() >= 0);
        assertTrue("Total Coupons is positive", action.getCouponSalesTotal()  >= 0);

    }

}