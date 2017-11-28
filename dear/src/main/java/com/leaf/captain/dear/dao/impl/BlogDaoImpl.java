package com.leaf.captain.dear.dao.impl;

import com.leaf.captain.dear.dao.AbstractDao;
import com.leaf.captain.dear.dao.BlogDao;
import com.leaf.captain.dear.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogDaoImpl extends AbstractDao<Blog> implements BlogDao {

    @Override
    public List<Blog> load() {
        return super.get(Blog.class);
    }

    @Override
    public Blog get(Integer id) {
        return super.get(Blog.class, id);
    }

}