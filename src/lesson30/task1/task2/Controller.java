package lesson30.task1.task2;

import java.util.HashSet;
import java.util.Set;

public class Controller {

    public Controller() {
        DepartmentDAO departmentDAO = new DepartmentDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        ProjectDAO projectDAO = new ProjectDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();



        FirmDAO firmDAO = new FirmDAO();
    }



    public Set<Employee> employeesByProject(Project projectName) {
        return EmployeeDAO.employeesByProject(projectName);
    }

    public Set<Project> projectsByEmployee(Employee employee) {
        return ProjectDAO.projectsByEMployee(employee);
    }

    public Set<Employee> employeesByDepartmentWithoutProject(Department departmentType) {
        return EmployeeDAO.employeesByDepartmentWithoutProject(departmentType);
    }

    public Set<Employee> employeesWithoutProject() {
        return EmployeeDAO.employeesWithoutProject();
    }

    public Set<Employee> employeesByTeamLead(Employee lead) {
        return EmployeeDAO.employeesByTeamLead(lead);
    }

    public Set<Employee> teamLeadsByEmployee(Employee employee) {
        return EmployeeDAO.teamLeadsByEmployee(employee);
    }

    public Set<Employee> employeesByProjectEmployee(Employee employee) {
        return EmployeeDAO.employeesByProjectEmployee(employee);
    }

    public Set<Project> projectsByCustomer(Customer customer) {
        return ProjectDAO.projectsByCustomer(customer);
    }

    public Set<Employee> employeesByCustomerProjects(Customer customer) {
        return EmployeeDAO.employeesByCustomerProjects(customer);
    }


}
