package com.leaf.captain.dear.dao;

import org.hibernate.Session;

public interface DaoCallBack<T> {
    T doInAction(Session session);
}