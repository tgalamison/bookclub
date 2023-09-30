package com.bookclub.bookclub.service.dao;

import java.util.List;

public interface GenericCrudDao<E, K> {

    /**
     * Add an entity to the data store.
     *
     * @param entity The entity to be added.
     */
    void add(E entity);

    /**
     * Update an existing entity in the data store.
     *
     * @param entity The entity to be updated.
     */
    void update(E entity);

    /**
     * Remove an entity from the data store.
     *
     * @param entity The entity to be removed.
     * @return true if removal was successful, false otherwise.
     */
    boolean remove(E entity);

    /**
     * Retrieve a list of all entities from the data store.
     *
     * @return List of entities.
     */
    List<E> list();

    /**
     * Find and retrieve an entity from the data store by its key.
     *
     * @param key The key of the entity to be retrieved.
     * @return The entity associated with the given key.
     */
    E find(K key);
}
