package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
//@SuppressWarnings("PMD.UselessParentheses")
public class WordService {
    private final ApiService apiService;

    private static Logger logger = LoggerFactory.getLogger(WordService.class);

    WordService(ApiService apiService){
        this.apiService = apiService;
    }


    public void addWord(String word) throws IOException {
        //Worden met 5,6,7 letters worden afgevangen in de Database
        Pattern pattern = Pattern.compile("[^a-z]");
        Matcher matcher = pattern.matcher(word);
        boolean find = matcher.find();
        if(!find && word.length() >= 5 && word.length() <= 7){
            apiService.create(word);

            logger.info(String.format("The following word is added: %s" , word));
        }

    }

}
