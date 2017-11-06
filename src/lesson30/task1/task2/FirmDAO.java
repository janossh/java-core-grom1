package lesson30.task1.task2;

import java.util.Date;

public class FirmDAO {
    private static Firm firm;

    public FirmDAO() {
        firm = new Firm(new Date(), DepartmentDAO.getDepartments(), CustomerDAO.getCustomers());
    }

    public static Firm getFirm() {
        return firm;
    }
}
