package com.leaf.captain.blog.dao.impl;

import com.leaf.captain.blog.dao.AbstractDao;
import com.leaf.captain.blog.dao.CategoryDao;
import com.leaf.captain.blog.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl extends AbstractDao<Category> implements CategoryDao {

    @Override
    public List<Category> load() {
        return super.get(Category.class);
    }

    public Category getAndRefresh(Integer id) {
        return super.getAndRefresh(Category.class, id);
    }

    @Override
    public Category get(Integer id) {
        return super.get(Category.class, id);
    }

}