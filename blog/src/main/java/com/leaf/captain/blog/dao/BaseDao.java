package com.leaf.captain.blog.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

    Serializable save(T t);
    void delete(T t);
    void update(T t);
    List<T> load();

    /**
     * Since session.get is lazy loading
     * Exception LazyInitializationException will be thrown if you use session.get(id)
     * and use the object in application out of current session.
     * While session.get(id) doesn't support lazy loading, so, no exception will be throw
     */
    T get(Integer id);
}