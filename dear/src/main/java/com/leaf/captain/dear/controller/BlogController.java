package com.leaf.captain.dear.controller;

import com.leaf.captain.dear.model.Blog;
import com.leaf.captain.dear.service.BlogService;
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

    private static final String VIEW_BLOG = "blog";
    private static final String VIEW_WRITE_BLOG = "write_blog";

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public List<Blog> load() {
        return blogService.loadBlogs();
    }

    @RequestMapping(value = "/publish", method = RequestMethod.GET)
    public String publishBlog(ModelMap map) {
        map.put("categories", blogService.loadCategories());
        return VIEW_WRITE_BLOG;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBlog(@ModelAttribute Blog blog, Model model) {
        if(logger.isDebugEnabled()) {
            logger.debug("Starting to save blog: " + blog);
        }
        blog.setPublishDate(new Date());
        blogService.saveBlog(blog);
        return "redirect:/" + VIEW_BLOG;
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String getBlogsByCategoryName(Integer id, ModelMap map) {
        List<Blog> blogs = blogService.loadBlogsByCategoryId(id);
        if (logger.isDebugEnabled()) {
            logger.debug(blogs);
        }
        map.put("blogs", blogs);
        map.put("categories", blogService.loadCategories()); //TODO need to refactor here
        return VIEW_BLOG;
    }

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String getBlogById(Integer id, ModelMap map) {
        Blog blog = blogService.get(id);
        if (logger.isDebugEnabled()) {
            logger.debug(blog);
        }
        map.put("currentBlog", blog);
        map.put("categories", blogService.loadCategories()); //TODO need to refactor here
        return VIEW_BLOG;
    }

}