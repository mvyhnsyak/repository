package ua.vyshnyak.services.impl;

import ua.vyshnyak.dao.impl.BugDao;
import ua.vyshnyak.dao.impl.EmployeeDao;
import ua.vyshnyak.entities.Bug;
import ua.vyshnyak.entities.Employee;
import ua.vyshnyak.services.IBugService;

/**
 * Максим
 * 24.11.2019
 */
public class BugService implements IBugService {
    private BugDao bugDao;
    private EmployeeDao employeeDao;

    public BugService(BugDao bugDao, EmployeeDao employeeDao) {
        this.bugDao = bugDao;
        this.employeeDao = employeeDao;
    }

    public void create(Bug bug) {
        bugDao.save(bug);
    }

    public void update(Bug bug) {
        bugDao.update(bug);
    }

    public void assignToUser(Long bugId, Long employeeId) {
        Employee employee = employeeDao.find(employeeId);
        Bug bug = bugDao.find(bugId);
        employee.addBug(bug);
        employeeDao.update(employee);
    }
}
