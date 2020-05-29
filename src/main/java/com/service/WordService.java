package com.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WordService {
    private final ApiService apiService;

    public String addWord(String word) throws IOException {
        //Worden met 5,6,7 letters worden afgevangen in de Database
        Pattern pattern = Pattern.compile("[^a-z]");
        Matcher matcher = pattern.matcher(word);
        boolean find = matcher.find();
        if(!find){
            apiService.create(word);
        }
        return word;
    }

    WordService(ApiService apiService){
        this.apiService = apiService;
    }
}
