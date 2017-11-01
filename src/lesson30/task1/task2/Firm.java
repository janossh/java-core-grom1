package lesson30.task1.task2;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Firm {
    private Date dateFounded;
    private List<Department> departments;
    private List<Customer> customers;

    public Firm(Date dateFounded, List<Department> departments, List<Customer> customers) {
        this.dateFounded = dateFounded;
        this.departments = departments;
        this.customers = customers;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}


