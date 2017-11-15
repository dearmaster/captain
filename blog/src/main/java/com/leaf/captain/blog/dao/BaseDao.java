package com.leaf.captain.blog.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

    Serializable save(T t);
    void delete(T t);
    void update(T t);
    List<T> load();

}