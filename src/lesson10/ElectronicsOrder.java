package lesson10;

import java.util.Date;

public class ElectronicsOrder extends Order {
    private int guaranteeMonths;
    private double shipingPrice;
    private double discountPrice = 0;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    public String toString() {
        return "ElectronicsOrder{" +
                "guaranteeMonths=" + guaranteeMonths +
                ", shipingPrice=" + shipingPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }

    @Override
    public void validateOrder() {
        if (getDateConfirmed() == null)
            if (getCustomerOwned().getCity() == "Киев" || getCustomerOwned().getCity() == "Одесса" || getCustomerOwned().getCity() == "Днепр" || getCustomerOwned().getCity() == "Харьков")
                if (getShipToCity() == "Киев" || getShipToCity() == "Одесса" || getShipToCity() == "Днепр" || getShipToCity() == "Харьков")
                    if (getBasePrice() >= 100)
                        if (getCustomerOwned().getName() != null)
                            if (getCustomerOwned().getGender() == "Женский")
                                setDateConfirmed(new Date());


        System.out.println(getItemName() + " validate order -- " + (getDateConfirmed() != null));
    }

    @Override
    public void calculatePrice() {

        if (getShipToCity() == "Киев" || getCustomerOwned().getCity() == "Одесса")
            shipingPrice = getBasePrice() * 0.1;
        else
            shipingPrice = getBasePrice() * 0.15;
        if (getBasePrice() >= 1000)
            discountPrice = getBasePrice() * 0.05;

        setTotalPrice(getBasePrice() + shipingPrice - discountPrice);

        System.out.println(getItemName() + " total price -- " + getTotalPrice());
    }
}
