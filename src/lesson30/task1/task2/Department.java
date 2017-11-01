package lesson30.task1.task2;

import java.util.HashSet;
import java.util.Set;

public class Department {
    private DepartmentType type;
    private Set<Employee> employees = new HashSet<>();

    public Department(DepartmentType type) {
        this.type = type;
    }

    public DepartmentType getType() {
        return type;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (type != that.type) return false;
        return employees.equals(that.employees);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
//        result = 31 * result + employees.hashCode();
        return result;
    }
}
