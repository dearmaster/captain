package com.leaf.captain.blog.service.impl;

import com.leaf.captain.blog.dao.ArticleDao;
import com.leaf.captain.blog.dao.CategoryDao;
import com.leaf.captain.blog.model.Article;
import com.leaf.captain.blog.model.Category;
import com.leaf.captain.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Serializable saveArticle(Article blog) {
        return articleDao.save(blog);
    }

    @Override
    public List<Article> loadArticles() {
        return articleDao.load();
    }

    @Override
    public List<Category> loadCategories() {
        return categoryDao.load();
    }

}