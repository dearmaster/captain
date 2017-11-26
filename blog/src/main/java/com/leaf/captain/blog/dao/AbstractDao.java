package com.leaf.captain.blog.dao;

import com.leaf.captain.blog.model.Article;
import com.leaf.captain.blog.model.Category;
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
        return this.execute(session -> session.save(t));
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

        String hql = "from " + claz.getSimpleName();
        return this.execute(
          session -> session.createQuery(hql).list()
        );

    }

    public T load(Class<T> claz, Integer id) {
        return this.execute(
                session -> (T) session.get(claz, id)
        );
    }

    /**
     * Need to be implemented by sub classes
     */
    @Override
    public T get(Integer id) {
        return null;
    }

    protected <T> T execute(DaoCallBack<T> callBack) {
        Session session = sessionFactory.getCurrentSession();
        return callBack.doInAction(session);
    }

}