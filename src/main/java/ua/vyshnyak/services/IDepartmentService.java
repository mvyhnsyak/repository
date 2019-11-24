package ua.vyshnyak.services;

import ua.vyshnyak.entities.Department;
import ua.vyshnyak.entities.Employee;

import java.util.List;

/**
 * Максим
 * 23.11.2019
 */
public interface IDepartmentService extends IGenericService<Department> {
    void assignToDepartment(Long departmentId, Long employeeId);
    List<Employee> getAllEmployees(Long departmentId);
}
