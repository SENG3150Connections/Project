package NewcastleConnections.Cart.Actions;

import NewcastleConnections.Cart.Cart;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Harry on 15/10/2017.
 */
public class UpdateCartTest extends StrutsJUnit4TestCase<UpdateCart> {

    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }
	
	// -----------------------
	// ----- ERROR TESTS -----
	// -----------------------

    @Test
    public void testNoParams() throws Exception {
        ActionProxy proxy = getActionProxy("/edit-cart.action");
        UpdateCart action = (UpdateCart) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return ERROR", result.equals(ActionSupport.ERROR));
    }

    @Test
    public void testMethod() throws Exception {
        request.setParameter("method", "add");
        ActionProxy proxy = getActionProxy("/edit-cart.action");
        UpdateCart action = (UpdateCart) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return ERROR", result.equals(ActionSupport.ERROR));
    }

    @Test
    public void testType() throws Exception {
        request.setParameter("type", "experience");
        ActionProxy proxy = getActionProxy("/edit-cart.action");
        UpdateCart action = (UpdateCart) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return ERROR", result.equals(ActionSupport.ERROR));
    }

    @Test
    public void testId() throws Exception {
        request.setParameter("id", "1");
        ActionProxy proxy = getActionProxy("/edit-cart.action");
        UpdateCart action = (UpdateCart) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return ERROR", result.equals(ActionSupport.ERROR));
    }
	
	// -----------------------
	// --- END ERROR TESTS ---
	// -----------------------

	
	// -----------------------
	// ----- VALID TESTS -----
	// -----------------------
	
	// --- TEMPLATE ---
	@Test
    public void testParams(String type, String method, int id) throws Exception {
		testParams(type, method, id, "SUCCESS");
	}
	
	@Test
    public void testParams(String type, String method, int id, String returnType) throws Exception {
        request.setParameter("type", type);
        request.setParameter("method", method);
        request.setParameter("id", id + "");
        ActionProxy proxy = getActionProxy("/edit-cart.action");
        UpdateCart action = (UpdateCart) proxy.getAction();
        String result = proxy.execute();
		
		if (returnType.equals("ERROR")) {
			assertTrue("Action should return ERROR", result.equals(ActionSupport.ERROR));
			return;
		}
		
		assertTrue("Action should return SUCCESS", result.equals(ActionSupport.SUCCESS));
        assertTrue("Method should be '" + method + "'", action.getMethod().equals(method));
        assertTrue("Type should be '" + type + "'", action.getMethod().equals(type));
        assertTrue("Id should be '" + id + "'", action.getMethod().equals(id));
	}

	// --- TYPE: EXPERIENCE ---
    @Test
    public void testTypeExperienceAdd() throws Exception {
		testParams("experience", "add", 1);
	}
	
    @Test
    public void testTypeExperienceRemove() throws Exception {
		testParams("experience", "remove", 1);
	}
	
    @Test
    public void testTypeExperienceInvalid() throws Exception {
		testParams("experience", "invalid", 1, "ERROR");
	}

	// --- TYPE: HOTEL ---
    @Test
    public void testTypeHotelAdd() throws Exception {
		testParams("hotel", "add", 1);
	}
	
    @Test
    public void testTypeHotelRemove() throws Exception {
		testParams("hotel", "remove", 1);
	}
	
    @Test
    public void testTypeHotelInvalid() throws Exception {
		testParams("hotel", "invalid", 1, "ERROR");
	}

	// --- TYPE: RESTAURANT ---
    @Test
    public void testTypeRestaurantAdd() throws Exception {
		testParams("restaurant", "add", 1);
	}
	
    @Test
    public void testTypeRestaurantRemove() throws Exception {
		testParams("restaurant", "remove", 1);
	}
	
    @Test
    public void testTypeRestaurantInvalid() throws Exception {
		testParams("restaurant", "invalid", 1, "ERROR");
	}

	// --- TYPE: INVALID ---
	
    @Test
    public void testTypeInvalid() throws Exception {
		testParams("invalid", "add", 1, "ERROR");
	}

}
