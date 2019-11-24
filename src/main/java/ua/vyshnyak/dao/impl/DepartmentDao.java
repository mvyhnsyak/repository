package ua.vyshnyak.dao.impl;

import ua.vyshnyak.dao.AbstractDao;
import ua.vyshnyak.entities.Department;
import ua.vyshnyak.entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Максим
 * 23.11.2019
 */
public class DepartmentDao extends AbstractDao<Long, Department> {
    @Override
    public void save(Department entity) {
        entity.setId(idCounter.incrementAndGet());
        entities.put(entity.getId(), new Department(entity));
    }

    @Override
    public void update(Department entity) {
        entities.put(entity.getId(), new Department(entity));
    }

    @Override
    public Department find(Long id) {
        return new Department(entities.get(id));
    }

    @Override
    public List<Department> findAll() {
        List<Department> departments = entities.values().stream()
                .map(Department::new)
                .collect(Collectors.toList());
        return new ArrayList<>(departments);
    }

    @Override
    public void delete(Long id) {
        entities.remove(id);
    }

    public List<Employee> findAllEmployeesInDepartment(Long departmentId) {
        return new Department(entities.get(departmentId)).getEmployees();
    }
}
