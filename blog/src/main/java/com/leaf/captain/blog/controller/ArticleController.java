package com.leaf.captain.blog.controller;

import com.leaf.captain.blog.model.Article;
import com.leaf.captain.blog.model.Category;
import com.leaf.captain.blog.service.ArticleService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

//@RestController
@Controller
@RequestMapping("/article")
public class ArticleController {

    private static final Logger logger = LogManager.getLogger(ArticleController.class);

    private static final int ARTICLE_CONTENT_PREVIEW_LENGTH = 100;

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
        Map<Category, List<Article>> categoryArticleMap = articleService.loadCategoryArticleMap();
        if (logger.isDebugEnabled()) {
            for (Category category : categoryArticleMap.keySet()) {
                logger.debug(categoryArticleMap.get(category));
            }
        }
        map.put("categoryArticleMap", categoryArticleMap);
        return "view_articles";
    }

    @RequestMapping(value = "/publish", method = RequestMethod.GET)
    public String publishArticle(ModelMap map) {
        map.put("categories", articleService.loadCategories());
        return "write-blog";
    }

    @RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
    public String saveArticle(Article article, Model model) {
        if(logger.isDebugEnabled()) {
            logger.debug("Starting to save article: " + article);
        }
        articleService.saveArticle(article);
        return "view_articles";
    }

    @RequestMapping(value = "/byCategory", method = RequestMethod.GET)
    public String getArticlesByCategoryName(Integer id, ModelMap map) {
        List<Article> articles = articleService.loadArticlesByCategoryId(id);
        for (Article article : articles) {
            article.setContent(article.getContent().substring(0, article.getContent().length() < ARTICLE_CONTENT_PREVIEW_LENGTH ? article.getContent().length() : ARTICLE_CONTENT_PREVIEW_LENGTH) + "...");
        }
        if (logger.isDebugEnabled()) {
            logger.debug(articles);
        }
        map.put("articles", articles);
        map.put("categories", articleService.loadCategories()); //TODO need to refactor here
        return "index";
    }

    @RequestMapping(value = "byId", method = RequestMethod.GET)
    public String getArticleById(Integer id, ModelMap map) {
        Article article = articleService.get(id);
        if (logger.isDebugEnabled()) {
            logger.debug(article);
        }
        map.put("currentArticle", article);
        map.put("categories", articleService.loadCategories()); //TODO need to refactor here
        return "index";
    }

    @ModelAttribute
    Article setArticle() {
        return new Article();
    }

}