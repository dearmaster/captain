package com.leaf.captain.blog.dao.impl;

import com.leaf.captain.blog.dao.AbstractDao;
import com.leaf.captain.blog.dao.ArticleDao;
import com.leaf.captain.blog.model.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleDaoImpl extends AbstractDao<Article> implements ArticleDao {

    @Override
    public List<Article> load() {
        return super.get(Article.class);
    }

    @Override
    public Article get(Integer id) {
        return super.get(Article.class, id);
    }

}