package com.leaf.captain.dear.controller;

import com.leaf.captain.dear.model.Article;
import com.leaf.captain.dear.service.ArticleService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

//@RestController
@Controller
@RequestMapping("/blog")
public class BlogController {

    private static final Logger logger = LogManager.getLogger(BlogController.class);

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public List<Article> load() {
        return articleService.loadArticles();
    }

    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayArticles(ModelMap map) {
        map.put("categories", articleService.loadCategories());
        return "view_articles";
    }*/

    /*@RequestMapping(value = "/all", method = RequestMethod.GET)
    public String loadAllArticles(ModelMap map) {
        Map<Category, List<Article>> categoryArticleMap = articleService.loadCategoryArticleMap();
        if (logger.isDebugEnabled()) {
            for (Category category : categoryArticleMap.keySet()) {
                logger.debug(categoryArticleMap.get(category));
            }
        }
        map.put("categoryArticleMap", categoryArticleMap);
        return "view_articles";
    }*/

    @RequestMapping(value = "/publish", method = RequestMethod.GET)
    public String publishArticle(ModelMap map) {
        map.put("categories", articleService.loadCategories());
        return "write-dear";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveArticle(Article article, Model model) {
        if(logger.isDebugEnabled()) {
            logger.debug("Starting to save article: " + article);
        }
        article.setPublishDate(new Date());
        articleService.saveArticle(article);
        return "view_articles";
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String getArticlesByCategoryName(Integer id, ModelMap map) {
        List<Article> articles = articleService.loadArticlesByCategoryId(id);
        if (logger.isDebugEnabled()) {
            logger.debug(articles);
        }
        map.put("articles", articles);
        map.put("categories", articleService.loadCategories()); //TODO need to refactor here
        return "blog";
    }

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String getArticleById(Integer id, ModelMap map) {
        Article article = articleService.get(id);
        if (logger.isDebugEnabled()) {
            logger.debug(article);
        }
        map.put("currentArticle", article);
        map.put("categories", articleService.loadCategories()); //TODO need to refactor here
        return "blog";
    }

    @ModelAttribute
    Article setArticle() {
        return new Article();
    }

}