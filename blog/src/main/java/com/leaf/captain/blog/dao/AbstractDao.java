package com.leaf.captain.blog.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractDao<T> implements BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Serializable save(final T t) {
        return this.execute(new DaoCallBack<Serializable>() {
            @Override
            public Serializable doInAction(Session session) {
                return session.save(t);
            }
        });
    }

    @Override
    public void delete(final T t) {

        this.execute(
                session -> {
                    session.delete(t);
                    return null;
                }
        );

    }

    @Override
    public void update(final T t) {

        this.execute(
                session -> {
                    session.update(t);
                    return null;
                }
        );

    }

    public List<T> load(final Class<T> claz) {

        return this.execute(
          session -> {
              String hql = "from " + claz.getSimpleName();
              return session.createQuery(hql).list();
          }
        );

    }

    protected <T> T execute(DaoCallBack<T> callBack) {
        Session session = sessionFactory.getCurrentSession();
        return callBack.doInAction(session);
    }

}