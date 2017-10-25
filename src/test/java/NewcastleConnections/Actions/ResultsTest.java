package NewcastleConnections.Actions;

import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResultsTest extends StrutsJUnit4TestCase<Results> {

    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void testNoParams() throws Exception {
        ActionProxy proxy = getActionProxy("/results.action");
        Results action = (Results) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return SUCCESS", result.equals(ActionSupport.SUCCESS));
        assertListSizes(action);

        assertNotNull("Recommendations not null", action.getRecommendations());
        assertNotNull("Cart not null", action.getCart());
    }

    @Test
    public void testSearchParamEmpty() throws Exception {
        request.setParameter("search", "blahblahblahblah");
        ActionProxy proxy = getActionProxy("/results.action");
        Results action = (Results) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return SUCCESS", result.equals(ActionSupport.SUCCESS));
        assertListSizes(action);
        assertEquals("Result set is empty", action.getTotalCount(), 0);
    }

    @Test
    public void testSearchParamProper() throws Exception {
        request.setParameter("search", "novotel");
        ActionProxy proxy = getActionProxy("/results.action");
        Results action = (Results) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return SUCCESS", result.equals(ActionSupport.SUCCESS));
        assertListSizes(action);
        assertEquals("Result set is one", action.getTotalCount(), 1);
        assertEquals("Result is a hotel", action.getHotelCount(), 1);
        assertEquals("Name is a match", action.getHotels().get(0).getName(), "Novotel Newcastle Beach");
    }

    @Test
    public void testRequestParams() throws Exception {
        request.setParameter("search", "novotel");
        request.setParameter("start", "start");
        request.setParameter("finish", "finish");
        request.setParameter("people", "2");
        ActionProxy proxy = getActionProxy("/results.action");
        Results action = (Results) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return SUCCESS", result.equals(ActionSupport.SUCCESS));

        assertEquals("Parameters match", action.getSearch(), "novotel");
        assertEquals("Parameters match", action.getStart(), "start");
        assertEquals("Parameters match", action.getFinish(), "finish");
        assertEquals("Parameters match", action.getPeople(), 2);
    }

    public void assertListSizes(Results action) {
        assertEquals("Counts add up", action.getTotalCount(),
                action.getExperienceCount() + action.getHotelCount() + action.getRestaurantCount() + action.getTransportCount());

        assertTrue("Counts are positive", action.getExperienceCount() >= 0);
        assertTrue("Counts are positive", action.getHotelCount() >= 0);
        assertTrue("Counts are positive", action.getRestaurantCount() >= 0);
        assertTrue("Counts are positive", action.getTransportCount() >= 0);

        assertEquals("Counts match", action.getExperienceCount(), action.getExperiences().size());
        assertEquals("Counts match", action.getHotelCount(), action.getHotels().size());
        assertEquals("Counts match", action.getRestaurantCount(), action.getRestaurants().size());
        assertEquals("Counts match", action.getTransportCount(), action.getTransport().size());
    }

}