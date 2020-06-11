package com.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration
public class TestApplicationRunner implements ApplicationRunner {
    private static Logger logger = LoggerFactory.getLogger(TestApplicationRunner.class);

    public TestApplicationRunner(){
        logger.info("Test application runner started");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Test application is running");
    }
}
