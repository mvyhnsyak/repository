package ua.vyshnyak.entities;

import java.util.Objects;

/**
 * Максим
 * 24.11.2019
 */
public class Bug extends BaseEntity<Long> {
    private String description;

    public Bug(String description) {
        this.description = description;
    }

    public Bug(Bug bug) {
        setId(bug.getId());
        this.description = bug.description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bug bug = (Bug) o;
        return Objects.equals(description, bug.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}
