package com.leaf.captain.blog.service.impl;

import com.leaf.captain.blog.dao.ArticleDao;
import com.leaf.captain.blog.model.Article;
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

    @Override
    public Serializable save(Article blog) {
        return articleDao.save(blog);
    }

    @Override
    public List<Article> load() {
        return articleDao.load();
    }

}