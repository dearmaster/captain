package com.leaf.captain.dear.service;

import com.leaf.captain.dear.model.Blog;
import com.leaf.captain.dear.model.Category;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BlogService {

    Serializable saveBlog(Blog blog);

    List<Blog> loadBlogs();

    List<Category> loadCategories();

    Map<Category, List<Blog>> loadCategoryBlogMap();

    List<Blog> loadBlogsByCategoryId(Integer categoryId);

    Blog get(Integer id);

}