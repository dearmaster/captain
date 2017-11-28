package com.leaf.captain.dear.controller;

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
        logger.info("Exception will be thrown here for test......");
        //ERROR will be thrown here as no view found for the corresponding name SUCCESS
        return "SUCCESS";
    }

}