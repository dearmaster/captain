package com.leaf.captain.blog.dao;

import org.hibernate.Session;

public interface DaoCallBack<T> {
    T doInAction(Session session);
}