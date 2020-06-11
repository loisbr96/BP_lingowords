package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){
        logger.info("Starting the application....");

        SpringApplication app = new SpringApplication(Application.class);
        app.run(Application.class, args);

    }

    @Override
    public void run(String... args){
        logger.info("Executing: command line runner");

    }



}
