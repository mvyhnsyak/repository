package ua.vyshnyak.dao.impl;

import ua.vyshnyak.dao.AbstractDao;
import ua.vyshnyak.entities.Bug;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Максим
 * 24.11.2019
 */
public class BugDao extends AbstractDao<Long, Bug> {

    @Override
    public void save(Bug entity) {
        entity.setId(idCounter.incrementAndGet());
        entities.put(entity.getId(), new Bug(entity));
    }

    @Override
    public void update(Bug entity) {
        entities.put(entity.getId(), new Bug(entity));
    }

    @Override
    public Bug find(Long id) {
        return new Bug(entities.get(id));
    }

    @Override
    public List<Bug> findAll() {
        List<Bug> Bugs = entities.values().stream()
                .map(Bug::new)
                .collect(Collectors.toList());
        return new ArrayList<>(Bugs);
    }

    @Override
    public void delete(Long id) {
        entities.remove(id);
    }
}
