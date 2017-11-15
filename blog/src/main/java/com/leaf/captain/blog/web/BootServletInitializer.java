package com.leaf.captain.blog.web;

import com.leaf.captain.blog.StartBlogApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * This class is for use to deploy to an outer web container
 */
public class BootServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(StartBlogApplication.class);
    }

}