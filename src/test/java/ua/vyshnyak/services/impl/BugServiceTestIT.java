package ua.vyshnyak.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.vyshnyak.dao.impl.BugDao;
import ua.vyshnyak.dao.impl.EmployeeDao;
import ua.vyshnyak.entities.Bug;
import ua.vyshnyak.entities.Employee;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Максим
 * 24.11.2019
 */

class BugServiceTestIT {
    private BugService bugService;
    private BugDao bugDao;
    private EmployeeDao employeeDao;

    @BeforeEach
    void setup() {
        bugDao = new BugDao();
        employeeDao = new EmployeeDao();
        bugService = new BugService(bugDao, employeeDao);
    }

    @Test
    void testCreate() throws Exception {
        Bug bug = new Bug("Description");

        bugService.create(bug);

        assertThat(bug.getId(), is(notNullValue()));
        assertThat(bugDao.find(bug.getId()), is(bug));
    }

    @Test
    void testUpdate() throws Exception {
        Bug bug = new Bug("Description");
        bugDao.save(bug);
        bug.setDescription("Updated");

        bugService.update(bug);

        assertThat(bugDao.find(bug.getId()), is(bug));
    }

    @Test
    void testAssignToUser() throws Exception {
        Bug bug = new Bug("Description");
        Employee employee = new Employee("Name");
        bugDao.save(bug);
        employeeDao.save(employee);

        bugService.assignToUser(bug.getId(), employee.getId());

        employee = employeeDao.find(employee.getId());

        assertThat(employee.getBugs().size(), is(1));
        assertThat(employee.getBugs().get(0), is(bug));
    }
}