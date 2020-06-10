package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

//import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WordService {
    private final ApiCallService apiCallService;

    private static Logger logger = LoggerFactory.getLogger(WordService.class);

    WordService(ApiCallService apiCallService){
        this.apiCallService = apiCallService;
    }

    public void addWord(String word){
        Pattern pattern = Pattern.compile("[^a-z]");
        Matcher matcher = pattern.matcher(word);
        boolean find = matcher.find();

        if(!find && word.length() >= 5 && word.length() <= 7){
            apiCallService.create(word);

            logger.info(String.format("The following word is added: %s" , word));
        }else {
            logger.warn(String.format("The following word doest not meet the requirements: %s", word));
        }
    }
}
