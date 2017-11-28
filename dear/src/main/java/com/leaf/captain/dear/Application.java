package com.leaf.captain.dear;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.leaf.captain.dear.model")
public class Application {

    private static final String customizedPath = "configuration/log4j.xml";

    static {
        System.setProperty("log4j.configuration", customizedPath);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}