package com.leaf.captain.blog.dao;

import com.leaf.captain.blog.model.Category;

/**
 * All load* method will fetch the corresponding articles
 * by cascade
 *
 * All get* method will not
 */
public interface CategoryDao extends BaseDao<Category> {

    Category getByName(String name);

    Category loadByName(String name);

}