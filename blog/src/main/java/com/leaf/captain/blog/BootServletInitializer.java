package com.leaf.captain.blog;

import com.leaf.captain.blog.Application;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * This class is for use to deploy to an outer web container
 */
public class BootServletInitializer extends SpringBootServletInitializer {

    private static final Logger logger = LogManager.getLogger(BootServletInitializer.class);

    public BootServletInitializer() {
        logger.info("____________________________________");
        logger.info("____________________________________");
        logger.info("____________________________________");
        logger.info("____________________________________");
        logger.info("____________________________________");
        logger.info("____________________________________");
        logger.info("____________________________________");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

}