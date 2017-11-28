package com.leaf.captain.dear.service;

import com.leaf.captain.dear.model.Article;
import com.leaf.captain.dear.model.Category;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ArticleService {

    Serializable saveArticle(Article blog);

    List<Article> loadArticles();

    List<Category> loadCategories();

    Map<Category, List<Article>> loadCategoryArticleMap();

    List<Article> loadArticlesByCategoryId(Integer categoryId);

    Article get(Integer id);

}