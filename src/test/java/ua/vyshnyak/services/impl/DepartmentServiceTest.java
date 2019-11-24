package ua.vyshnyak.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.vyshnyak.dao.impl.DepartmentDao;
import ua.vyshnyak.dao.impl.EmployeeDao;
import ua.vyshnyak.entities.Department;
import ua.vyshnyak.entities.Employee;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Максим
 * 24.11.2019
 */

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    @InjectMocks
    private DepartmentService departmentService;
    @Mock
    private DepartmentDao departmentDao;
    @Mock
    private EmployeeDao employeeDao;

    @Test
    void testCreate() throws Exception {
        Department department = new Department("Description");
        departmentService.create(department);
        verify(departmentDao).save(department);
    }

    @Test
    void testUpdate() throws Exception {
        Department department = new Department("Description");
        departmentService.update(department);
        verify(departmentDao).update(department);
    }

    @Test
    void testAssignToDepartment() throws Exception {
        Employee employee = new Employee("Name");
        employee.setId(1L);
        Department department = new Department("Description");
        department.setId(1L);

        when(employeeDao.find(1L)).thenReturn(employee);
        when(departmentDao.find(1L)).thenReturn(department);

        departmentService.assignToDepartment(1L, 1L);

        assertThat(department.getEmployees().size(), is(1));
        assertThat(department.getEmployees().get(0), is(employee));

        verify(employeeDao).find(1L);
        verify(departmentDao).find(1L);
        verify(departmentDao).update(department);
    }

    @Test
    void testGetAllEmployees() throws Exception {
        departmentService.getAllEmployees(1L);

        verify(departmentDao).findAllEmployeesInDepartment(1L);
    }
}