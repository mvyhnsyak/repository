package ua.vyshnyak.entities;

import java.util.Objects;

/**
 * Максим
 * 23.11.2019
 */
public class Employee extends BaseEntity<Long> {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public Employee(Employee employee) {
        setId(employee.getId());
        this.name = employee.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
