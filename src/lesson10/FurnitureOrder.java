package lesson10;

import java.util.Date;

public class FurnitureOrder extends Order {
    private String furnitureCode;
    private double shipingPrice;
//  private double discountPrice = 0;

    public FurnitureOrder(String itemName, Date dateCreated, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated,  shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    public void validateOrder() {
        if (getDateConfirmed() == null)
            if (getCustomerOwned().getCity() == "Киев" || getCustomerOwned().getCity() == "Львов")
                if (getShipToCity() != null)
                    if (getBasePrice() >= 500)
                        if (getCustomerOwned().getName() != null && getCustomerOwned().getName() != "Тест")
                            if (getCustomerOwned().getGender() != null)
                                setDateConfirmed(new Date());

        System.out.println(getItemName() + " validate order -- " + (getDateConfirmed() != null));
    }

    @Override
    public void calculatePrice() {

        if (getBasePrice() < 5000)
            shipingPrice = getBasePrice() * 0.05;
        else
            shipingPrice = getBasePrice() * 0.02;
        setTotalPrice(getBasePrice() + shipingPrice);
        System.out.println(getItemName() + " total price -- " + getTotalPrice());
    }
}
