package com.leaf.captain.dear.service.impl;

import com.leaf.captain.dear.dao.BlogDao;
import com.leaf.captain.dear.dao.CategoryDao;
import com.leaf.captain.dear.model.Blog;
import com.leaf.captain.dear.model.Category;
import com.leaf.captain.dear.service.BlogService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.*;

@Service("blogService")
@Transactional
public class BlogServiceImpl implements BlogService {

    private static final Logger logger = LogManager.getLogger(BlogServiceImpl.class);

    @Autowired
    private BlogDao blogDao;
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Serializable saveBlog(Blog blog) {
        Category category = categoryDao.get(blog.getCategory().getId());
        blog.setCategory(category);
        Serializable ret =  blogDao.save(blog);
        if(logger.isDebugEnabled()) {
            logger.debug(category);
            logger.debug(blog);
        }
        return ret;
    }

    @Override
    public List<Blog> loadBlogs() {
        return blogDao.load();
    }

    @Override
    public List<Category> loadCategories() {
        return categoryDao.load();
    }

    @Override
    public Map<Category, List<Blog>> loadCategoryBlogMap() {
        List<Blog> list = blogDao.load();
        Map<Category, List<Blog>> map = new TreeMap<>();
        if(!list.isEmpty()) {
            for(Blog blog : list) {
                List<Blog> blogsInCurrentCategory = map.get(blog.getCategory());
                if(null == blogsInCurrentCategory)
                    blogsInCurrentCategory = new ArrayList<>();
                blogsInCurrentCategory.add(blog);
                map.put(blog.getCategory(), blogsInCurrentCategory);
            }
        }
        return map;
    }

    @Override
    public List<Blog> loadBlogsByCategoryId(Integer categoryId) {
        Category category = categoryDao.getAndRefresh(categoryId);
        return category.getBlogs();
    }

    @Override
    public Blog get(Integer id) {
        return blogDao.get(id);
    }
}