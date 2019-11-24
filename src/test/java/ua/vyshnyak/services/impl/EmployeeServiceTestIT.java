package ua.vyshnyak.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.vyshnyak.dao.impl.EmployeeDao;
import ua.vyshnyak.entities.Employee;
import ua.vyshnyak.services.IEmployeeService;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Максим
 * 24.11.2019
 */

class EmployeeServiceTestIT {
    private IEmployeeService employeeService;
    private EmployeeDao employeeDao;

    @BeforeEach
    void setup() {
        employeeDao = new EmployeeDao();
        employeeService = new EmployeeService(employeeDao);
    }

    @Test
    void testCreate() throws Exception {
        Employee employee = new Employee("Name");

        employeeService.create(employee);

        assertThat(employee.getId(), is(notNullValue()));
        assertThat(employeeDao.find(employee.getId()), is(employee));
    }

    @Test
    void testUpdate() throws Exception {
        Employee employee = new Employee("Name");
        employeeDao.save(employee);
        employee.setName("Updated");

        employeeService.update(employee);

        assertThat(employeeDao.find(employee.getId()), is(employee));
    }
}