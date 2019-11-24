package ua.vyshnyak.services.impl;

import ua.vyshnyak.dao.impl.DepartmentDao;
import ua.vyshnyak.dao.impl.EmployeeDao;
import ua.vyshnyak.entities.Department;
import ua.vyshnyak.entities.Employee;
import ua.vyshnyak.services.IDepartmentService;

import java.util.List;

/**
 * Максим
 * 23.11.2019
 */
public class DepartmentService implements IDepartmentService {
    private DepartmentDao departmentDao;
    private EmployeeDao employeeDao;

    public DepartmentService(DepartmentDao departmentDao, EmployeeDao employeeDao) {
        this.departmentDao = departmentDao;
        this.employeeDao = employeeDao;
    }

    public void create(Department department) {
        departmentDao.save(department);
    }

    public void update(Department department) {
        departmentDao.update(department);
    }

    public void assignToDepartment(Long departmentId, Long employeeId) {
        Employee employee = employeeDao.find(employeeId);
        Department department = departmentDao.find(departmentId);
        department.addEmployee(employee);
        departmentDao.update(department);
    }

    public List<Employee> getAllEmployees(Long departmentId) {
        return departmentDao.findAllEmployeesInDepartment(departmentId);
    }
}
