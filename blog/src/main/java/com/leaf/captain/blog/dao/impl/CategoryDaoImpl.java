package com.leaf.captain.blog.dao.impl;

import com.leaf.captain.blog.dao.AbstractDao;
import com.leaf.captain.blog.dao.CategoryDao;
import com.leaf.captain.blog.model.Category;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl extends AbstractDao<Category> implements CategoryDao {

    @Override
    public List<Category> load() {
        return super.load(Category.class);
    }

    @Override
    public Category getByName(String name) {
        return super.execute(
                session -> {
                    //List<User> list = session.createCriteria(User.class).add(Restrictions.eq("username", username)).list();
                    List<Category> list = session.createCriteria(Category.class).add(Restrictions.eq("name", name)).list();
                    if(!list.isEmpty())
                        return list.get(0);
                    return null;
                }
        );
    }

}