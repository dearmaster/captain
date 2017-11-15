package com.leaf.captain.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartBlogApplication {

    private static final String customizedPath = "configuration/log4j.xml";

    static {
        System.setProperty("log4j.configuration", customizedPath);
    }

    public static void main(String[] args) {
        SpringApplication.run(StartBlogApplication.class, args);
    }

}