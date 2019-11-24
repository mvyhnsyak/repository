package ua.vyshnyak.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Максим
 * 23.11.2019
 */
public class Department extends BaseEntity<Long> {
    private String description;
    private List<Employee> employees = new ArrayList<>();

    public Department(String description) {
        this.description = description;
    }

    public Department(Department department) {
        setId(department.getId());
        this.description = department.description;
        this.employees = department.employees.stream()
                .map(Employee::new)
                .collect(Collectors.toList());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(description, that.description) &&
                Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, employees);
    }
}
