package com;

import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws ParseException {
        logger.info("Starting the application....");

        SpringApplication app = new SpringApplication(Application.class);

        app.run(Application.class, args);

//        Bootstrap.main(args);
    }

    @Override
    public void run(String... args){
        logger.info("Exectuting: command line runner");

    }

}
