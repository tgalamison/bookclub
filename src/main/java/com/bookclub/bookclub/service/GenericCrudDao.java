package com.bookclub.bookclub.service;

import java.util.List;

public interface GenericCrudDao<E, K> {
    void add(E entity);
    void update(E entity);
    boolean remove(K key);
    List<E> list(K key); // Return a list of objects of type E.
    E find(K key); // Return an object of type E by type K value.
}
