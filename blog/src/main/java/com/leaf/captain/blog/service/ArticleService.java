package com.leaf.captain.blog.service;

import com.leaf.captain.blog.model.Article;
import com.leaf.captain.blog.model.Category;

import java.io.Serializable;
import java.util.List;

public interface ArticleService {

    Serializable saveArticle(Article blog);

    List<Article> loadArticles();

    List<Category> loadCategories();

}