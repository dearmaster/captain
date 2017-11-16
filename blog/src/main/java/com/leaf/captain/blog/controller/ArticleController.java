package com.leaf.captain.blog.controller;

import com.leaf.captain.blog.model.Article;
import com.leaf.captain.blog.service.ArticleService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/article")
public class ArticleController {

    private static final Logger logger = LogManager.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/loadArticles", method = RequestMethod.GET)
    public List<Article> load() {
        return articleService.loadArticles();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayArticles(ModelMap map) {
        map.put("categories", articleService.loadCategories());
        return "view_articles";
    }

}