package com.leaf.captain.blog.controller;

import com.leaf.captain.blog.model.Category;
import com.leaf.captain.blog.service.ArticleService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AppController {

    private static final Logger logger = LogManager.getLogger(AppController.class);

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String navigateToIndex(ModelMap map) {
        List<Category> categories = articleService.loadCategories();
        if(logger.isDebugEnabled()) {
            logger.debug(categories);
        }
        map.put("categories", categories);
        return "index";
    }

}