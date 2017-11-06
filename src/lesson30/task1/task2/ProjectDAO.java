package lesson30.task1.task2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProjectDAO {
    private static List<Project> projects;

    public ProjectDAO() {
        Project project1 = new Project("1Project", CustomerDAO.getCustomers().get(0));
        Project project2 = new Project("2Project", CustomerDAO.getCustomers().get(1));
        Project project3 = new Project("3Project", CustomerDAO.getCustomers().get(2));
        Project project4 = new Project("4Project", CustomerDAO.getCustomers().get(2));

        projects = new ArrayList<>();

        projects.add(project1);
        projects.add(project2);
        projects.add(project3);
        projects.add(project4);
    }


    public static List<Project> getProjects() {
        return projects;
    }

    public static Project getProject(int index) {
        if (getProjects() == null) return null;
        return getProjects().get(index);
    }

    public static Set<Project> projectsByCustomer(Customer customer) {
        Set<Project> projects = new HashSet<>();

        for (Department dp : FirmDAO.getFirm().getDepartments()) {
            if (dp != null)
                for (Employee em : dp.getEmployees()) {
                    if (em != null)
                        for (Project pr : em.getProjects()) {
                            if (pr != null && pr.getCustomer().equals(customer))
                                projects.add(pr);
                        }
                }
        }
        return projects;
    }

    public static Set<Project> projectsByEMployee(Employee employee) {
        if (employee == null) return null;
        return employee.getProjects();
    }
}
