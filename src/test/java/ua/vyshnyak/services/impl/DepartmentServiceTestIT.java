package ua.vyshnyak.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.vyshnyak.dao.impl.DepartmentDao;
import ua.vyshnyak.dao.impl.EmployeeDao;
import ua.vyshnyak.entities.Department;
import ua.vyshnyak.entities.Employee;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Максим
 * 24.11.2019
 */

class DepartmentServiceTestIT {
    private DepartmentService departmentService;
    private DepartmentDao departmentDao;
    private EmployeeDao employeeDao;

    @BeforeEach
    void setup() {
        departmentDao = new DepartmentDao();
        employeeDao = new EmployeeDao();
        departmentService = new DepartmentService(departmentDao, employeeDao);
    }

    @Test
    void testCreate() throws Exception {
        Department department = new Department("Description");

        departmentService.create(department);

        assertThat(department.getId(), is(notNullValue()));
        assertThat(departmentDao.find(department.getId()), is(department));
    }

    @Test
    void testUpdate() throws Exception {
        Department department = new Department("Description");
        departmentDao.save(department);
        department.setDescription("Updated description");

        departmentService.update(department);

        assertThat(department.getId(), is(notNullValue()));
        assertThat(departmentDao.find(department.getId()), is(department));
    }

    @Test
    void testAssignToDepartment() throws Exception {
        Department department = new Department("Description");
        Employee employee = new Employee("Name");
        departmentDao.save(department);
        employeeDao.save(employee);

        departmentService.assignToDepartment(department.getId(), employee.getId());

        department = departmentDao.find(department.getId());
        assertThat(department.getEmployees().size(), is(1));
        assertThat(department.getEmployees().get(0), is(employee));
    }

    @Test
    void testGetAllEmployees() throws Exception {
        Department department = new Department("Description");
        List<Employee> employees = Arrays.asList(new Employee("Name1"), new Employee("Name2"));
        departmentDao.save(department);
        employees.forEach(employeeDao::save);
        department.setEmployees(employees);
        departmentDao.update(department);

        List<Employee> result = departmentService.getAllEmployees(department.getId());

        assertThat(result, is(employees));
    }
}