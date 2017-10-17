package NewcastleConnections.Cart;

/*
CartItem.java
Author: Scott Walker

Description:
    Interface class for Cart objects to implement.
*/

public interface CartItem {
    String getName();
    int getId();
    boolean getReady();
    double getPrice();
}
