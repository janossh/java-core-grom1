package lesson30.task1.task2;

import java.util.*;

public class EmployeeDAO {
    private static List<Employee> employees;

    public EmployeeDAO() {

        Employee employeeRoman = new Employee("Roman", "Ivanov", new Date(), Position.DEVELOPER, DepartmentDAO.getDepartments().get(0));
        Employee employeeIvan = new Employee("Ivan", "Ivanov", new Date(), Position.DEVELOPER, DepartmentDAO.getDepartments().get(0));
        Employee employeeTamara = new Employee("Tamara", "Ivanov", new Date(), Position.TEAM_LEAD, DepartmentDAO.getDepartments().get(0));
        Employee employeeTrainy = new Employee("Student", "XXX", new Date(), Position.DEVELOPER, DepartmentDAO.getDepartments().get(0));

        employees = new ArrayList<>();
        employees.add(employeeRoman);
        employees.add(employeeIvan);
        employees.add(employeeTamara);
        employees.add(employeeTrainy);

        employeeRoman.addProjects(ProjectDAO.getProjects().get(0));
        employeeIvan.addProjects(ProjectDAO.getProjects().get(0));
        employeeTamara.addProjects(ProjectDAO.getProjects().get(0));
        employeeRoman.addProjects(ProjectDAO.getProjects().get(2));
        employeeTamara.addProjects(ProjectDAO.getProjects().get(3));

        DepartmentDAO.getDepartments().get(0).getEmployees().add(EmployeeDAO.getEmployees().get(0));
        DepartmentDAO.getDepartments().get(0).getEmployees().add(EmployeeDAO.getEmployees().get(1));
        DepartmentDAO.getDepartments().get(0).getEmployees().add(EmployeeDAO.getEmployees().get(2));
        DepartmentDAO.getDepartments().get(0).getEmployees().add(EmployeeDAO.getEmployees().get(3));
    }


    public static List<Employee> getEmployees() {
        return employees;
    }

    public static Employee getEmployee(int index) {
        if (getEmployees() == null) return null;
        return getEmployees().get(index);
    }

    public static Set<Employee> employeesByCustomerProjects(Customer customer) {
        Set<Employee> employees = new HashSet<>();

        for (Project pr : ProjectDAO.projectsByCustomer(customer)) {
            if (pr != null)
                for (Department dp : FirmDAO.getFirm().getDepartments()) {
                    if (dp != null)
                        for (Employee em : dp.getEmployees()) {
                            if (em != null && em.getProjects().contains(pr)) {
                                employees.add(em);
                            }
                        }
                }
        }

        return employees;
    }

    public static Set<Employee> employeesByProjectEmployee(Employee employee) {
        Set<Employee> employees = new HashSet<>();

        for (Project pr : employee.getProjects()) {
            if (pr != null)
                for (Department dp : FirmDAO.getFirm().getDepartments()) {
                    if (dp != null)
                        for (Employee em : dp.getEmployees()) {
                            if (em != null && !employee.equals(em) && em.getProjects().contains(pr)) {
                                employees.add(em);
                            }
                        }
                }
        }
        return employees;
    }

    public static Set<Employee> teamLeadsByEmployee(Employee employee) {
        Set<Employee> employees = new HashSet<>();

        for (Project pr : employee.getProjects()) {
            if (pr != null)
                for (Department dp : FirmDAO.getFirm().getDepartments()) {
                    if (dp != null)
                        for (Employee em : dp.getEmployees()) {
                            if (em != null && !employee.equals(em) && em.getPosition() == Position.TEAM_LEAD && em.getProjects().contains(pr)) {
                                employees.add(em);
                            }
                        }
                }
        }
        return employees;
    }

    public static Set<Employee> employeesByTeamLead(Employee lead) {
        Set<Employee> employees = new HashSet<>();

        for (Project pr : lead.getProjects()) {
            if (pr != null)
                for (Department dp : FirmDAO.getFirm().getDepartments()) {
                    if (dp != null)
                        for (Employee em : dp.getEmployees()) {
                            if (em != null && !lead.equals(em) && em.getPosition() != Position.TEAM_LEAD && em.getProjects().contains(pr)) {
                                employees.add(em);
                            }
                        }
                }
        }

        return employees;
    }

    public static Set<Employee> employeesWithoutProject() {
        Set<Employee> employees = new HashSet<>();

        for (Department dp : FirmDAO.getFirm().getDepartments()) {
            if (dp != null)
                for (Employee em : dp.getEmployees()) {
                    if (em != null && em.getProjects().isEmpty()) {
                        employees.add(em);
                    }
                }
        }
        return employees;
    }

    public static Set<Employee> employeesByDepartmentWithoutProject(Department department) {
        Set<Employee> employees = new HashSet<>();
        for (Employee em : department.getEmployees()) {
            if (em != null && em.getProjects().isEmpty()) {
                employees.add(em);
            }
        }
        return employees;
    }

    public static Set<Employee> employeesByProject(Project project) {

        Set<Employee> employees = new HashSet<>();

        for (Department dp : FirmDAO.getFirm().getDepartments()) {
            if (dp != null)
                for (Employee em : dp.getEmployees()) {
                    if (em != null && em.getProjects().contains(project)) {
                        employees.add(em);
                    }
                }
        }
        return employees;
    }
}
