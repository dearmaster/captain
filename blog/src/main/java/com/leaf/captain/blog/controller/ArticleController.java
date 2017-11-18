package com.leaf.captain.blog.controller;

import com.leaf.captain.blog.model.Article;
import com.leaf.captain.blog.service.ArticleService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
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

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String loadAllArticles(ModelMap map) {
        map.put("categoryArticleMap", articleService.loadCategoryArticleMap());
        return "view_articles";
    }

    @RequestMapping(value = "/publish", method = RequestMethod.GET)
    public String publishArticle(ModelMap map) {
        map.put("categories", articleService.loadCategories());
        return "write-blog";
    }

    @RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
    public String saveArticle(Article article,Model model) {
        articleService.saveArticle(article);
        return "write-blog";
    }

    @ModelAttribute
    Article setArticle(){
        return new Article();
    }

}