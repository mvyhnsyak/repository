package ua.vyshnyak.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.vyshnyak.dao.impl.EmployeeDao;
import ua.vyshnyak.entities.Employee;

import static org.mockito.Mockito.verify;

/**
 * Максим
 * 24.11.2019
 */

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @InjectMocks
    private EmployeeService employeeService;
    @Mock
    private EmployeeDao employeeDao;

    @Test
    void testCreate() throws Exception {
        Employee employee = new Employee("Name");

        employeeService.create(employee);

        verify(employeeDao).save(employee);
    }

    @Test
    void testUpdate() throws Exception {
        Employee employee = new Employee("Name");

        employeeService.update(employee);

        verify(employeeDao).update(employee);
    }
}