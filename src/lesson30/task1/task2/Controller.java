package lesson30.task1.task2;

import java.util.HashSet;
import java.util.Set;

public class Controller {

    private DAO dao = new DAO();

    public Set<Employee> employeesByProject(Project project) {

        Set<Employee> employees = new HashSet<>();

        for (Department dp : dao.getFirm().getDepartments()) {
            for (Employee em : dp.getEmployees()) {
                if (em.getProjects().contains(project)) {
                    employees.add(em);
                }
            }
        }
        return employees;
    }

    public Set<Project> projectsByEMployee(Employee employee) {
        return employee.getProjects();
    }

    public Set<Employee> employeesByDepartmentWithoutProject(Department department) {
        Set<Employee> employees = new HashSet<>();
        for (Employee em : department.getEmployees()) {
            if (em.getProjects().isEmpty()) {
                employees.add(em);
            }
        }
        return employees;
    }

    public Set<Employee> employeesWithoutProject() {
        Set<Employee> employees = new HashSet<>();

        for (Department dp : dao.getFirm().getDepartments()) {
            for (Employee em : dp.getEmployees()) {
                if (em.getProjects().isEmpty()) {
                    employees.add(em);
                }
            }
        }
        return employees;
    }

    public Set<Employee> employeesByTeamLead(Employee lead) {
        Set<Employee> employees = new HashSet<>();

        for (Project pr : lead.getProjects()) {
            for (Department dp : dao.getFirm().getDepartments()) {
                for (Employee em : dp.getEmployees()) {
                    if (!lead.equals(em) && em.getPosition() != Position.TEAM_LEAD && em.getProjects().contains(pr)) {
                        employees.add(em);
                    }
                }
            }
        }

        return employees;
    }

    public Set<Employee> teamLeadsByEmployee(Employee employee) {
        Set<Employee> employees = new HashSet<>();

        for (Project pr : employee.getProjects()) {
            for (Department dp : dao.getFirm().getDepartments()) {
                for (Employee em : dp.getEmployees()) {
                    if (!employee.equals(em) && em.getPosition() == Position.TEAM_LEAD && em.getProjects().contains(pr)) {
                        employees.add(em);
                    }
                }
            }
        }
        return employees;
    }

    public Set<Employee> employeesByProjectEmployee(Employee employee) {
        Set<Employee> employees = new HashSet<>();

        for (Project pr : employee.getProjects()) {
            for (Department dp : dao.getFirm().getDepartments()) {
                for (Employee em : dp.getEmployees()) {
                    if (!employee.equals(em) && em.getProjects().contains(pr)) {
                        employees.add(em);
                    }
                }
            }
        }
        return employees;
    }

    public Set<Project> projectsByCustomer(Customer customer) {
        Set<Project> projects = new HashSet<>();

        for (Department dp : dao.getFirm().getDepartments()) {
            for (Employee em : dp.getEmployees()) {
                for (Project pr : em.getProjects()) {
                    if (pr.getCustomer().equals(customer))
                        projects.add(pr);
                }
            }
        }
        return projects;
    }

    public Set<Employee> employeesByCustomerProjects(Customer customer) {
        Set<Employee> employees = new HashSet<>();

        for (Project pr : projectsByCustomer(customer)) {
            for (Department dp : dao.getFirm().getDepartments()) {
                for (Employee em : dp.getEmployees()) {
                    if (em.getProjects().contains(pr)) {
                        employees.add(em);
                    }
                }
            }
        }

        return employees;
    }

    public Project getProject(int index) {
        return dao.getProjects().get(index);
    }

    public Employee getEmployee(int index) {
        return dao.getEmployees().get(index);
    }

    //- employeesByCustomerProjects(Customer customer) - список сотрудников, участвующих в проектах, выполняемых для заданного заказчика

}
