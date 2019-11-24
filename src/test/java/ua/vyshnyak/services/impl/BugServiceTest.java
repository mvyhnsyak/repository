package ua.vyshnyak.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.vyshnyak.dao.impl.BugDao;
import ua.vyshnyak.dao.impl.EmployeeDao;
import ua.vyshnyak.entities.Bug;
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
class BugServiceTest {
    @InjectMocks
    private BugService bugService;
    @Mock
    private BugDao bugDao;
    @Mock
    private EmployeeDao employeeDao;

    @Test
    void testCreate() throws Exception {
        Bug bug = new Bug("Description");
        bugService.create(bug);
        verify(bugDao).save(bug);
    }

    @Test
    void testUpdate() throws Exception {
        Bug bug = new Bug("Description");
        bugService.update(bug);
        verify(bugDao).update(bug);
    }

    @Test
    void testAssignToUser() throws Exception {
        Bug bug = new Bug("Description");
        bug.setId(1L);
        Employee employee = new Employee("Name");
        employee.setId(1L);

        when(employeeDao.find(employee.getId())).thenReturn(employee);
        when(bugDao.find(bug.getId())).thenReturn(bug);

        bugService.assignToUser(bug.getId(), employee.getId());

        assertThat(employee.getBugs().size(), is(1));
        assertThat(employee.getBugs().get(0), is(bug));

        verify(employeeDao).find(employee.getId());
        verify(bugDao).find(bug.getId());
        verify(employeeDao).update(employee);
    }
}