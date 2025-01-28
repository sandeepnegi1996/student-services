package com.hashcodehub.springboot.studentservices.Controller;

import com.hashcodehub.springboot.studentservices.helpers.SpringLoggerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/index")
    public String index() {

        logger.debug("this is index debug logger message");
        logger.info("this is index info logger message");
        logger.warn("this is index warn logger message");
        logger.error("this is index error logger message");
        logger.info("GCP Demo");


        new SpringLoggerHelper().helpMethod();
        return "index";
    }

    @RequestMapping("/generateLogs")
    public void generateLogs() {
        for (int i = 0; i < 10000000; i++) {
            logger.debug("massive debug logger message");
            logger.info("massive info logger message");
            logger.warn("massive warn logger message");
            logger.error("massive error logger message");

        }

    }
}
