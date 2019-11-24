package ua.vyshnyak.dao.impl;

import ua.vyshnyak.dao.AbstractDao;
import ua.vyshnyak.entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Максим
 * 23.11.2019
 */
public class EmployeeDao extends AbstractDao<Long, Employee> {

    @Override
    public void save(Employee entity) {
        entity.setId(idCounter.incrementAndGet());
        entities.put(entity.getId(), new Employee(entity));
    }

    @Override
    public void update(Employee entity) {
        entities.put(entity.getId(), new Employee(entity));
    }

    @Override
    public Employee find(Long id) {
        return new Employee(entities.get(id));
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = entities.values().stream()
                .map(Employee::new)
                .collect(Collectors.toList());
        return new ArrayList<>(employees);
    }

    @Override
    public void delete(Long id) {
        entities.remove(id);
    }
}
