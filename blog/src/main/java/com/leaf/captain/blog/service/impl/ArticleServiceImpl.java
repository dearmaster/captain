package com.leaf.captain.blog.service.impl;

import com.leaf.captain.blog.dao.ArticleDao;
import com.leaf.captain.blog.dao.CategoryDao;
import com.leaf.captain.blog.model.Article;
import com.leaf.captain.blog.model.Category;
import com.leaf.captain.blog.service.ArticleService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.*;

@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private static final Logger logger = LogManager.getLogger(ArticleServiceImpl.class);

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Serializable saveArticle(Article article) {
        Category category = categoryDao.get(article.getCategory().getId());
        article.setCategory(category);
        Serializable ret =  articleDao.save(article);
        if(logger.isDebugEnabled()) {
            logger.debug(category);
            logger.debug(article);
        }
        return ret;
    }

    @Override
    public List<Article> loadArticles() {
        return articleDao.load();
    }

    @Override
    public List<Category> loadCategories() {
        return categoryDao.load();
    }

    @Override
    public Map<Category, List<Article>> loadCategoryArticleMap() {
        List<Article> list = articleDao.load();
        Map<Category, List<Article>> map = new TreeMap<>();
        if(!list.isEmpty()) {
            for(Article article : list) {
                List<Article> articlesInCurrentCategory = map.get(article.getCategory());
                if(null == articlesInCurrentCategory)
                    articlesInCurrentCategory = new ArrayList<>();
                articlesInCurrentCategory.add(article);
                map.put(article.getCategory(), articlesInCurrentCategory);
            }
        }
        return map;
    }

    @Override
    public List<Article> loadArticlesByCategoryId(Integer categoryId) {
        Category category = categoryDao.getAndRefresh(categoryId);
        return category.getArticles();
    }

    @Override
    public Article get(Integer id) {
        return articleDao.get(id);
    }
}