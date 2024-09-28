package com.hashcodehub.springboot.studentservices.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringLoggerHelper {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    public void helpMethod() {

        logger.debug("This is helper debug message");
        logger.info("This is helper info message");
        logger.warn("This is helper warn message");
        logger.error("This is helper error message");
    }

}
