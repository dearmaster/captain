package com.leaf.captain.blog.service;

import com.leaf.captain.blog.model.Article;

import java.io.Serializable;
import java.util.List;

public interface ArticleService {

    Serializable save(Article blog);

    List<Article> load();

}