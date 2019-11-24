package ua.vyshnyak.services;

import ua.vyshnyak.entities.Bug;

/**
 * Максим
 * 24.11.2019
 */
public interface IBugService extends IGenericService<Bug> {
    void assignToUser(Long bugId, Long employeeId);
}
