package lesson27.order;

public class Order {
    private long id;
    private int pric;
    private String currency;
    private String itemName;
    private String shopIdentificator;

    public Order(long id, int pric, String currency, String itemName, String shopIdentificator) {
        this.id = id;
        this.pric = pric;
        this.currency = currency;
        this.itemName = itemName;
        this.shopIdentificator = shopIdentificator;
    }
}
