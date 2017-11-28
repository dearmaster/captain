package com.leaf.captain.dear.dao.impl;

import com.leaf.captain.dear.dao.AbstractDao;
import com.leaf.captain.dear.dao.ArticleDao;
import com.leaf.captain.dear.model.Article;
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