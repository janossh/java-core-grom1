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


    }


    public static List<Department> getDepartments() {
        return departments;
    }
}
