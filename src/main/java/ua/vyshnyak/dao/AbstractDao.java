package ua.vyshnyak.dao;

import ua.vyshnyak.entities.BaseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Максим
 * 23.11.2019
 */
public abstract class AbstractDao<K, E extends BaseEntity> implements GenericDao<K, E> {
    protected AtomicLong idCounter = new AtomicLong();
    protected Map<K, E> entities = new HashMap<>();
}
