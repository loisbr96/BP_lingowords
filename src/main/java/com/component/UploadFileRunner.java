package com.component;

import com.Application;
import com.service.IntroductionService;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;

import java.nio.file.Files;
import java.nio.file.Paths;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(value=1)
public class UploadFileRunner implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    private IntroductionService introductionService;

    public UploadFileRunner(IntroductionService introductionService){
        this.introductionService = introductionService;
    }

    @Override
    public void run(String[] args) {
        logger.info("the uploadfile runner is running");




//        //check if user passes any argument
//        if (args.length > 0) {
//            System.out.println(introductionService.getMessage(args[0]));
//        } else {
//            //print the default message
//            System.out.println(introductionService.getMessage());
//        }
    }
}
