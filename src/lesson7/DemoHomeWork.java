package lesson7;

import lesson6.Order;

import java.util.Date;

public class DemoHomeWork {

    public Order createOrder() {
        Order newOrder = new Order(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy");
        return newOrder;
    }

    public Order createOrderAndCallMethods() {
        Order newOrder = new Order(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
        newOrder.confirmOrder();
        newOrder.checkPrice();
        newOrder.isValidType();
        return newOrder;
    }

}
