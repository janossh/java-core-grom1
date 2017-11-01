package lesson30.task1.task2;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Employee {
    private String firstName;
    private String lastName;
    private Date dateHired;
    private Position position;
    private Department department;
    private Set<Project> projects = new HashSet<>();

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public Position getPosition() {
        return position;
    }

    public Department getDepartment() {
        return department;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public Employee(String firstName, String lastName, Date dateHired, Position position, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateHired = dateHired;
        this.position = position;
        this.department = department;

        //addEmploeeToDepartment(this);


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!firstName.equals(employee.firstName)) return false;
        if (!lastName.equals(employee.lastName)) return false;
        if (!dateHired.equals(employee.dateHired)) return false;
        if (position != employee.position) return false;
        if (!department.equals(employee.department)) return false;
        return projects.equals(employee.projects);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + dateHired.hashCode();
        result = 31 * result + position.hashCode();
//        result = 31 * result + department.hashCode();
        result = 31 * result + projects.hashCode();
        return result;
    }

//    public void addEmploeeToDepartment(Employee employee) {
//        if (this.department != null)
//            this.department.getEmployees().add(this);
//    }

    public void addProjects(Project project) {
        projects.add(project);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateHired=" + dateHired +
                ", position=" + position +
                ", department=" + department +
                '}';
    }
}
