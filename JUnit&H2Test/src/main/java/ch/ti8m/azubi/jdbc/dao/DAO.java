package ch.ti8m.azubi.jdbc.dao;

import ch.ti8m.azubi.jdbc.model.Person;

import java.util.List;

public interface DAO<E> {

    /**
     * Return a list of all entities.
     */
    List<E> list() throws Exception;

    /**
     * Get the entity with the given id. If no such entity is found, null is returned.
     */
    E get(int id) throws Exception;

    /**
     * Create a new entity.
     */
    void create(E entity) throws Exception;

    /**
     * Update an entity
     */
    void update(E entity) throws Exception;

    /**
     * Save an entity (create when id is not set, otherwise update)
     */
    void save(E entity) throws Exception;

    /**
     * Delete an entity by id.
     */
    boolean delete(int id) throws Exception;

    /**
     * Search persons using a search text
     */
    List<Person> find(String searchText) throws Exception;
}

