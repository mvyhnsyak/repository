package ua.vyshnyak.entities;

/**
 * Максим
 * 23.11.2019
 */
public abstract class BaseEntity<T> {
    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
