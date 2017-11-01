package lesson30.task1.task2;

import java.util.*;


public class DAO {
    private Firm firm;
    private List<Department> departments;
    private List<Customer> customers;
    private List<Project> projects;
    private List<Employee> employees;

    public DAO() {
        Department departmentDeveloper = new Department(DepartmentType.программисты);
        Department departmentAnalitic = new Department(DepartmentType.аналитики);
        Department departmentDisigner = new Department(DepartmentType.дизайнеры);
        Department departmentManagement = new Department(DepartmentType.менеджмент);

        Customer customer1 = new Customer("Alladin1", "USA", 15000);
        Customer customer2 = new Customer("Alladin2", "USA", 5000);
        Customer customer3 = new Customer("Alladin3", "USA", 2000);

        customers = new ArrayList<>();

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        Employee employeeRoman = new Employee("Roman", "Ivanov", new Date(), Position.DEVELOPER, departmentDeveloper);
        Employee employeeIvan = new Employee("Ivan", "Ivanov", new Date(), Position.DEVELOPER, departmentDeveloper);
        Employee employeeTamara = new Employee("Tamara", "Ivanov", new Date(), Position.TEAM_LEAD, departmentDeveloper);
        Employee employeeTrainy = new Employee("Student", "XXX", new Date(), Position.DEVELOPER, departmentDeveloper);

        employees = new ArrayList<>();
        employees.add(employeeRoman);
        employees.add(employeeIvan);
        employees.add(employeeTamara);
        employees.add(employeeTrainy);

        departmentDeveloper.getEmployees().add(employeeRoman);
        departmentDeveloper.getEmployees().add(employeeIvan);
        departmentDeveloper.getEmployees().add(employeeTamara);
        departmentDeveloper.getEmployees().add(employeeTrainy);

        departments = new ArrayList<>();
        departments.add(departmentDeveloper);
        departments.add(departmentDisigner);
        departments.add(departmentAnalitic);
        departments.add(departmentManagement);




        firm = new Firm(new Date(), departments, customers);

        Project project1 = new Project("1Project", customer1);
        Project project2 = new Project("2Project", customer2);
        Project project3 = new Project("3Project", customer3);
        Project project4 = new Project("4Project", customer3);

        projects = new ArrayList<>();

        projects.add(project1);
        projects.add(project2);
        projects.add(project3);
        projects.add(project4);

        employeeRoman.addProjects(project1);
        employeeIvan.addProjects(project1);
        employeeTamara.addProjects(project1);
        employeeRoman.addProjects(project3);
        employeeTamara.addProjects(project4);
    }

    public Firm getFirm() {
        return firm;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
