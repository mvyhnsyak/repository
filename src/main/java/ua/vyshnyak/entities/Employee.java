package ua.vyshnyak.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Максим
 * 23.11.2019
 */
public class Employee extends BaseEntity<Long> {
    private String name;
    private List<Bug> bugs = new ArrayList<>();

    public Employee(String name) {
        this.name = name;
    }

    public Employee(Employee employee) {
        setId(employee.getId());
        this.name = employee.name;
        this.bugs = employee.bugs.stream()
                .map(Bug::new)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bug> getBugs() {
        return bugs;
    }

    public void setBugs(List<Bug> bugs) {
        this.bugs = bugs;
    }

    public void addBug(Bug bug) {
        this.bugs.add(bug);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(bugs, employee.bugs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bugs);
    }
}
