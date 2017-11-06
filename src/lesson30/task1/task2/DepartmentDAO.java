package lesson30.task1.task2;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    private static List<Department> departments;

    public DepartmentDAO() {
        Department departmentDeveloper = new Department(DepartmentType.программисты);
        Department departmentAnalitic = new Department(DepartmentType.аналитики);
        Department departmentDisigner = new Department(DepartmentType.дизайнеры);
        Department departmentManagement = new Department(DepartmentType.менеджмент);

        departments = new ArrayList<>();
        departments.add(departmentDeveloper);
        departments.add(departmentDisigner);
        departments.add(departmentAnalitic);
        departments.add(departmentManagement);

        departmentDeveloper.getEmployees().add(EmployeeDAO.getEmployees().get(0));
        departmentDeveloper.getEmployees().add(EmployeeDAO.getEmployees().get(1));
        departmentDeveloper.getEmployees().add(EmployeeDAO.getEmployees().get(2));
        departmentDeveloper.getEmployees().add(EmployeeDAO.getEmployees().get(3));
    }


    public static List<Department> getDepartments() {
        return departments;
    }
}
