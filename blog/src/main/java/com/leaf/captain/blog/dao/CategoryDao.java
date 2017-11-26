package com.leaf.captain.blog.dao;

import com.leaf.captain.blog.model.Category;

public interface CategoryDao extends BaseDao<Category> {

    Category getAndRefresh(Integer id);

}