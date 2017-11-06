package lesson30.task1.task2;

import java.util.*;


public class CustomerDAO {

    private static List<Customer> customers;


    public CustomerDAO() {

        Customer customer1 = new Customer("Alladin1", "USA", 15000);
        Customer customer2 = new Customer("Alladin2", "USA", 5000);
        Customer customer3 = new Customer("Alladin3", "USA", 2000);

        customers = new ArrayList<>();

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
    }


    public static List<Customer> getCustomers() {
        return customers;
    }


}
