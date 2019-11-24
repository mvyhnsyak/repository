package ua.vyshnyak.services;

import ua.vyshnyak.entities.BaseEntity;

/**
 * Максим
 * 23.11.2019
 */
public interface IGenericService<E extends BaseEntity> {
    void create(E entity);
    void update(E entity);
}
