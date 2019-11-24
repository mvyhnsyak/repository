package ua.vyshnyak.services.impl;

import ua.vyshnyak.dao.impl.EmployeeDao;
import ua.vyshnyak.entities.Employee;
import ua.vyshnyak.services.IEmployeeService;

/**
 * Максим
 * 23.11.2019
 */
public class EmployeeService implements IEmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void create(Employee employee) {
        employeeDao.save(employee);
    }

    public void update(Employee employee) {
        employeeDao.update(employee);
    }
}
