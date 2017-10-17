package NewcastleConnections.Management.Actions;

/*
CreateOffer.java
Author: Harry Barden

Description:
    Simple action class to pass an offer type string
*/

import com.opensymphony.xwork2.ActionSupport;

public class CreateOffer extends ActionSupport {

    private String offerType = "";

    // -- Public --
    //   Role: Method that is executed when the page is requested.
    //
    @Override
    public String execute() {
        return SUCCESS;
    }

    // -- Getters and Setters --

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }
}
