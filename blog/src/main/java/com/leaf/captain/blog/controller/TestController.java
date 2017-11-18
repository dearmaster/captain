package com.leaf.captain.blog.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = LogManager.getLogger(TestController.class);

    @RequestMapping("/mathematic_error")
    public String testError500(ModelMap map) {
        return "SUCCESS";
    }

}