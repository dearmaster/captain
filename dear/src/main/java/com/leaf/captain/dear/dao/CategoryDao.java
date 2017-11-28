package com.leaf.captain.dear.dao;

import com.leaf.captain.dear.model.Category;

public interface CategoryDao extends BaseDao<Category> {

    Category getAndRefresh(Integer id);

}