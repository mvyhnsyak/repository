package ua.vyshnyak.dao;

import java.util.List;

/**
 * Максим
 * 23.11.2019
 */
public interface GenericDao<K, E> {
    void save(E entity);
    void update(E entity);
    E find(K id);
    List<E> findAll();
    void delete(K id);
}
