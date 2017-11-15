package com.leaf.captain.blog.controller;

import com.leaf.captain.blog.model.Article;
import com.leaf.captain.blog.service.ArticleService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private static final Logger logger = LogManager.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public List<Article> load() {
        return articleService.load();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "index";
    }

}