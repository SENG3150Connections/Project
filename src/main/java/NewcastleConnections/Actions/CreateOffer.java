package NewcastleConnections.Actions;

import com.opensymphony.xwork2.ActionSupport;


/**
 * Created by Harry on 12/8/17.
 */
public class CreateOffer extends ActionSupport {
    private String offerType = "";

    @Override
    public String execute() {

        // Return Success
        return SUCCESS;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }
}
